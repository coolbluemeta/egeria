/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.userauthn;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.odpi.openmetadata.frameworks.connectors.controls.SecretsStoreCollectionProperty;
import org.odpi.openmetadata.frameworks.connectors.properties.users.UserAccountStatus;
import org.odpi.openmetadata.metadatasecurity.properties.OpenMetadataUserAccount;
import org.odpi.openmetadata.metadatasecurity.server.OpenMetadataPlatformSecurityVerifier;
import org.odpi.openmetadata.userauthn.auth.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * LoginController provides a simple token service that can be used to log a user into open metadata.
 * It uses the Spring framework to provide the authentication token.  The user details are managed by the
 * metadata security connector.
 */
@RestController

@Tag(name="API: User Security Services", description="The user security services provide user authentication services to a client program, plus identification details about this runtime implementation.",
     externalDocs=@ExternalDocumentation(description="Further Information", url="https://egeria-project.org/features/metadata-security/overview"))

public class LoginController
{
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private final TokenService          tokenService;
    private final AuthenticationManager authenticationManager;


    /**
     * Constructor for the token service.
     *
     * @param tokenService implementation of the token generation service
     * @param authenticationManager implementation of the pluggable authentication manager
     */
    public LoginController(TokenService tokenService, AuthenticationManager authenticationManager)
    {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }


    /**
     * External service that provides an encrypted token that act as a bearer token for a REST API request.
     * The userId and password are sent in the request body
     *
     * @param userLogin request body that contains the userId and password
     * @return token
     * @throws AuthenticationException The user and password do not match the values in the user directory.
     */
    @PostMapping("/api/token")

    @Operation(summary = "generateUserToken",
            description = "Validate the user's password and return a bearer token for the user.  This is passed on subsequent API requests.",
            externalDocs = @ExternalDocumentation(description = "Further Information",
                    url = "https://egeria-project.org/features/metadata-security/overview"))

    public String platformToken(@RequestBody LoginRequest userLogin) throws AuthenticationException
    {
        Authentication authentication;

        OpenMetadataUserAccount userAccount = OpenMetadataPlatformSecurityVerifier.getLogonUser(userLogin.userId());
        if (userAccount != null)
        {
            /*
             * This will throw an exception if the user account is not valid or the password is not correct.
             */
            try
            {
                authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.userId(), userLogin.password()));
            }
            catch (AuthenticationException error)
            {
                log.error("User authentication failed for user: {} - {}", userLogin.userId(), error.getMessage());
                throw new AuthenticationServiceException("User authentication failed for user: " + userLogin.userId() + " - " + error.getMessage());
            }

            /*
             * If the user has requested a new password, update their account and then create a new token with the new password.
             */
            if (userLogin.newPassword() != null)
            {
                Map<String, String> secrets = userAccount.getSecrets();

                if (secrets == null)
                {
                    secrets = new HashMap<>();
                }

                secrets.put(SecretsStoreCollectionProperty.ENCRYPTED_PASSWORD.getName(), new BCryptPasswordEncoder().encode(userLogin.newPassword()));
                secrets.remove(SecretsStoreCollectionProperty.CLEAR_PASSWORD.getName());

                userAccount.setSecrets(secrets);

                if (userAccount.getUserAccountStatus() == UserAccountStatus.CREDENTIALS_EXPIRED)
                {
                    userAccount.setUserAccountStatus(UserAccountStatus.AVAILABLE);
                }

                try
                {
                    OpenMetadataPlatformSecurityVerifier.updateLoginUserAccount(userAccount);
                }
                catch (Exception error)
                {
                    log.error("Failed to update user account for user: {} - error message: {}", userLogin.userId(), error.getMessage(), error);
                    throw new AuthenticationServiceException("Failed to update user account: " + error.getMessage());
                }

                authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.userId(), userLogin.newPassword()));
            }
            else if (userAccount.getUserAccountStatus() == UserAccountStatus.CREDENTIALS_EXPIRED)
            {
                log.error("Credentials expired for user: {}.", userLogin.userId());
                throw new AuthenticationServiceException("Credentials expired for user: " + userLogin.userId() + ".");
            }
        }
        else
        {
            log.error("User account not found for user: {}.", userLogin.userId());
            throw new AuthenticationServiceException("User account not found for user: " + userLogin.userId() + ".");
        }

        /*
         * If the authentication is successful, generate a token for the user.
         */
        return tokenService.generateToken(authentication);
    }


    /**
     * External service that provides an encrypted token that act as a bearer token for a REST API request.
     * The userId and password are sent in the request body
     *
     * @param userLogin request body that contains the userId and password
     * @return token
     * @throws AuthenticationException The user and password do not match the values in the user directory.
     */
    @PostMapping("/servers/{serverName}/api/token")

    @Operation(summary="generateUserToken",
            description="Validate the user's password and return a bearer token for the user.  This is passed on subsequent API requests.",
            externalDocs=@ExternalDocumentation(description="Further Information",
                    url="https://egeria-project.org/features/metadata-security/overview"))

    public String serverToken(@PathVariable String       serverName,
                              @RequestBody  LoginRequest userLogin) throws AuthenticationException
    {
        /*
         * Currently, the platform security connector is used to provide tokens for specific servers
         */
        return this.platformToken(userLogin);
    }
}
