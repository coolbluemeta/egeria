/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.userauthn;

import org.odpi.openmetadata.commonservices.ffdc.rest.FFDCResponseBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.security.core.AuthenticationException;


/**
 * Exception handler for Jackson serialization/deserialization errors.
 */
@RestControllerAdvice
public class AuthenticationExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(AuthenticationExceptionHandler.class);


    /**
     * Handler for all read-side streaming processing problems,
     * including parsing and input value coercion problems.
     *
     * @param authenticationException the exception that occurred during parsing
     * @return 401 Unauthorized response
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<FFDCResponseBase> handleAuthenticationException(AuthenticationException authenticationException)
    {
        log.error("Authentication error: {}", authenticationException.getMessage(), authenticationException); // Log exception with stack trace

        FFDCResponseBase error = new FFDCResponseBase();
        error.setRelatedHTTPCode(HttpStatus.UNAUTHORIZED.value());
        error.setExceptionClassName(authenticationException.getClass().getName());
        error.setExceptionErrorMessage(authenticationException.getMessage());
        error.setExceptionSystemAction("The system is unable to authenticate the calling user and an error is returned.");
        error.setExceptionUserAction("Check the status of the user's account and credentials and try again.");

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}
