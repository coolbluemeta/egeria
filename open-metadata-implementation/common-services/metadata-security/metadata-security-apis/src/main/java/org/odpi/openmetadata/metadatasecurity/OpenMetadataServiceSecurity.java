/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.metadatasecurity;


import org.odpi.openmetadata.frameworks.openmetadata.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.UserNotAuthorizedException;

/**
 * OpenMetadataServiceSecurity provides the interface for a plugin connector that validates whether a calling
 * user can access a specific metadata service.  It is called within the context of a specific OMAG Server.
 * Each OMAG Server can define its own plugin connector implementation and will have its own instance
 * of the connector.  However the server name is supplied so a single connector can use it for logging
 * error messages and locating the valid user list for the server.
 *
 */
public interface OpenMetadataServiceSecurity
{
    /**
     * Check that the calling user is authorized to issue this request.
     *
     * @param userId      calling user
     * @param serviceName name of called service
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException    unable to retrieve necessary information to make the decision.
     */
    void validateUserForService(String userId,
                                String serviceName) throws UserNotAuthorizedException,
                                                           InvalidParameterException,
                                                           PropertyServerException;


    /**
     * Check that the calling user is authorized to issue this specific request.
     *
     * @param userId        calling user
     * @param serviceName   name of called service
     * @param operationName name of called operation
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException    unable to retrieve necessary information to make the decision.
     */
    void validateUserForServiceOperation(String userId,
                                         String serviceName,
                                         String operationName) throws UserNotAuthorizedException,
                                                                      InvalidParameterException,
                                                                      PropertyServerException;
}
