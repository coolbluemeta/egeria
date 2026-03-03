/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.metadatasecurity.server;

import org.odpi.openmetadata.frameworks.connectors.Connector;
import org.odpi.openmetadata.frameworks.connectors.ConnectorBroker;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.UserNotAuthorizedException;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.Connection;
import org.odpi.openmetadata.metadatasecurity.OpenMetadataPlatformSecurity;
import org.odpi.openmetadata.metadatasecurity.OpenMetadataUserSecurity;
import org.odpi.openmetadata.metadatasecurity.ffdc.OpenMetadataSecurityErrorCode;
import org.odpi.openmetadata.metadatasecurity.properties.OpenMetadataUserAccount;


/**
 * OpenMetadataPlatformSecurityVerifier provides the plug-in point for the open metadata platform connector
 */
public class OpenMetadataPlatformSecurityVerifier
{
    private static Connection                   platformSecurityConnection = null;
    private static OpenMetadataPlatformSecurity platformSecurityConnector = null;
    private static OpenMetadataUserSecurity     userSecurityConnector = null;


    /**
     * Override the default location of the configuration documents.
     *
     * @param userId calling user.
     * @param delegatingUserId external userId making request
     * @param serverPlatformURL URL Root of the server platform.
     * @param connection connection used to create and configure the connector that interacts with
     *                   the real store.
     * @throws InvalidParameterException one of the properties is either null or invalid
     * @throws UserNotAuthorizedException the user is not authorized to access this platform
     */
    public static synchronized void setPlatformSecurityConnection(String       userId,
                                                                  String       delegatingUserId,
                                                                  String       serverPlatformURL,
                                                                  Connection   connection) throws InvalidParameterException,
                                                                                                  UserNotAuthorizedException
    {
        final String methodName = "setPlatformSecurityConnection";

        /*
         * Validate that someone has authority to override the connector.
         */
        validatePlatformOperator(userId, delegatingUserId);

        try
        {
            ConnectorBroker connectorBroker = new ConnectorBroker();
            Connector       newConnector    = connectorBroker.getConnector(connection);

            platformSecurityConnector = (OpenMetadataPlatformSecurity)newConnector;

            if (newConnector instanceof OpenMetadataUserSecurity openMetadataUserSecurity)
            {
                userSecurityConnector     = openMetadataUserSecurity;
            }

            platformSecurityConnector.setServerPlatformURL(serverPlatformURL);
            newConnector.start();
            platformSecurityConnection = connection;
        }
        catch (Exception error)
        {
            /*
             * The assumption is that any exceptions creating the new connector are down to a bad connection
             */
            throw new InvalidParameterException(OpenMetadataSecurityErrorCode.BAD_PLATFORM_SECURITY_CONNECTION.getMessageDefinition(error.getMessage(),
                                                                                                                                    connection.toString()),
                                                OpenMetadataPlatformSecurityVerifier.class.getName(),
                                                methodName,
                                                error,
                                                "connection");
        }
    }


    /**
     * Validates that the specified user and, if applicable, the delegating user are authorized to act as
     * platform operators for the OMAG server platform. If a platform security connector is configured,
     * it uses the connector to perform the validation.
     *
     * @param userId           the identifier of the calling user
     * @param delegatingUserId the identifier of an external user making a request on behalf of the calling user;
     *                         can be null if no delegation is involved
     * @throws UserNotAuthorizedException if either the calling user or the delegating user (if provided)
     *                                    is not authorized to perform operator actions on the platform
     */
    private static void validatePlatformOperator(String userId,
                                                 String delegatingUserId) throws UserNotAuthorizedException
    {
        if (platformSecurityConnector != null)
        {
            platformSecurityConnector.validateUserAsOperatorForPlatform(userId);
            if (delegatingUserId != null)
            {
                platformSecurityConnector.validateUserAsOperatorForPlatform(delegatingUserId);
            }
        }
    }


    /**
     * Return the connection object for the configuration store.  Null is returned if the server should
     * use the default store.
     *
     * @param userId calling user
     * @param delegatingUserId external userId making request
     * @return connection response
     * @throws UserNotAuthorizedException the user is not authorized to access this platform
     */
    public static synchronized Connection getPlatformSecurityConnection(String userId,
                                                                        String delegatingUserId) throws UserNotAuthorizedException
    {
        /*
         * Validate that someone has authority to retrieve the connector.
         */
        validatePlatformOperator(userId, delegatingUserId);

        return platformSecurityConnection;
    }


    /**
     * Clear the connection object for the configuration store.  Null is returned if the server should
     * use the default store.
     *
     * @param userId           calling user
     * @param delegatingUserId external userId making request
     * @throws UserNotAuthorizedException the user is not authorized to access this platform
     */
    public static synchronized void clearPlatformSecurityConnection(String userId,
                                                                    String delegatingUserId) throws UserNotAuthorizedException
    {
        /*
         * Validate that someone has authority to override the connector.
         */
        validatePlatformOperator(userId, delegatingUserId);

        platformSecurityConnection = null;
        platformSecurityConnector  = null;
        userSecurityConnector      = null;
    }


    /**
     * Return information about a user requesting a bearer token
     *
     * @param accountUserId           calling user
     * @return known details of the user
     */
    public static synchronized OpenMetadataUserAccount getLogonUser(String accountUserId)
    {
        if (userSecurityConnector != null)
        {
            try
            {
                return userSecurityConnector.getUserAccount(accountUserId);
            }
            catch (Exception error)
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * Return information about a user.
     *
     * @param userId           calling user
     * @param delegatingUserId external userId making request
     * @param accountUserId user account identifier
     * @throws UserNotAuthorizedException user not recognized
     * @return known details of the user
     */
    public static synchronized OpenMetadataUserAccount getUser(String userId,
                                                               String delegatingUserId,
                                                               String accountUserId) throws UserNotAuthorizedException
    {
        if (userSecurityConnector != null)
        {
            /*
             * Validate that someone has authority to retrieve the user's account details.
             */
            if (delegatingUserId.equals(accountUserId))
            {
                /*
                 * The caller is retrieving their own account.
                 */
                validatePlatformOperator(userId, null);
            }
            else
            {
                validatePlatformOperator(userId, delegatingUserId);
            }

            try
            {
                return userSecurityConnector.getUserAccount(accountUserId);
            }
            catch (Exception error)
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }


    /**
     * Update information about a specific user.  This is used to update user details nd reset the password.
     *
     * @param userAccount security properties about the user
     */
    public static synchronized void updateLoginUserAccount(OpenMetadataUserAccount userAccount)
    {
        if ((userSecurityConnector != null) && (userAccount != null))
        {
            try
            {
                userSecurityConnector.setUserAccount(userAccount);
            }
            catch (Exception exc)
            {
                // nothing to do
            }
        }
    }

    /**
     * Update information about a specific user.  This is used to update user details nd reset the password.
     *
     * @param userId           calling user
     * @param delegatingUserId external userId making request
     * @param userAccount security properties about the user
     * @throws UserNotAuthorizedException user not recognized
     */
    public static synchronized void updateUserAccount(String                  userId,
                                                      String                  delegatingUserId,
                                                      OpenMetadataUserAccount userAccount) throws UserNotAuthorizedException
    {
        if ((userSecurityConnector != null) && (userAccount != null))
        {
            /*
             * Validate that someone has authority to update the user's account details.
             */
            validatePlatformOperator(userId, delegatingUserId);
            userSecurityConnector.setUserAccount(userAccount);
        }
    }


    /**
     * Delete information about a specific user.
     *
     * @param userId           calling user
     * @param delegatingUserId external userId making request
     * @param accountUserId      calling user
     * @throws UserNotAuthorizedException user not recognized
     */
    public static synchronized void deleteUserAccount(String userId,
                                                      String delegatingUserId,
                                                      String accountUserId) throws UserNotAuthorizedException
    {
        /*
         * Validate that someone has authority to delete the user's account details.
         */
        validatePlatformOperator(userId, delegatingUserId);

        if (userSecurityConnector != null)
        {
            userSecurityConnector.deleteUserAccount(accountUserId);
        }
    }


    /**
     * Check that the calling user is authorized to create new servers.
     *
     * @param userId calling user
     *
     * @throws UserNotAuthorizedException the user is not authorized to access this platform
     */
    public static synchronized void  validateUserForNewServer(String   userId) throws UserNotAuthorizedException
    {
        if (platformSecurityConnector != null)
        {
            platformSecurityConnector.validateUserForNewServer(userId);
        }
    }


    /**
     * Check that the calling user is authorized to issue operator requests to the OMAG Server Platform.
     *
     * @param userId calling user
     *
     * @throws UserNotAuthorizedException the user is not authorized to issue operator commands to this platform
     */
    public static synchronized void  validateUserAsOperatorForPlatform(String   userId) throws UserNotAuthorizedException
    {
        if (platformSecurityConnector != null)
        {
            platformSecurityConnector.validateUserAsOperatorForPlatform(userId);
        }
    }


    /**
     * Check that the calling user is authorized to issue diagnostic requests to the OMAG Server Platform.
     *
     * @param userId calling user
     *
     * @throws UserNotAuthorizedException the user is not authorized to issue diagnostic commands to this platform
     */
    public static synchronized void  validateUserAsInvestigatorForPlatform(String   userId) throws UserNotAuthorizedException
    {
        if (platformSecurityConnector != null)
        {
            platformSecurityConnector.validateUserAsInvestigatorForPlatform(userId);
        }
    }
}
