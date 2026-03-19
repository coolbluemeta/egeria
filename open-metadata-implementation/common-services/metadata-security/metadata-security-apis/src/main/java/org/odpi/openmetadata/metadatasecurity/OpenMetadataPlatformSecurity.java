/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.metadatasecurity;


import org.odpi.openmetadata.frameworks.openmetadata.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.UserNotAuthorizedException;

/**
 * OpenMetadataPlatformSecurity provides the interface for a security connector that validates whether a calling
 * user can access any service on an OMAG Server Platform.  It is called within the context of a specific
 * OMAG Server Platform request.
 * Each OMAG Server can also define its own plugin connector implementation and will have its own instance
 * of that connector.
 */
public interface OpenMetadataPlatformSecurity
{
    /**
     * Set up the URL Root for the platform where this is running.
     *
     * @param serverURLRoot url root
     */
     void setServerPlatformURL(String    serverURLRoot);


    /**
     * Check that the calling user is authorized to create new servers.
     *
     * @param userId calling user
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException    unable to retrieve necessary information to make the decision.
     */
    void validateUserForNewServer(String userId) throws UserNotAuthorizedException, InvalidParameterException, PropertyServerException;


    /**
     * Check that the calling user is authorized to issue operator requests to the OMAG Server Platform.
     *
     * @param userId calling user
     *
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserAsOperatorForPlatform(String userId) throws UserNotAuthorizedException, InvalidParameterException, PropertyServerException;


    /**
     * Check that the calling user is authorized to issue diagnostic requests to the OMAG Server Platform.
     *
     * @param userId calling user
     *
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserAsInvestigatorForPlatform(String userId) throws UserNotAuthorizedException, InvalidParameterException, PropertyServerException;
}
