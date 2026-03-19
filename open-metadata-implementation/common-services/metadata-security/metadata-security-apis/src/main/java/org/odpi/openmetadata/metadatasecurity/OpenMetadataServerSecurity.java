/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.metadatasecurity;


import org.odpi.openmetadata.frameworks.openmetadata.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.UserNotAuthorizedException;

/**
 * OpenMetadataServerSecurity provides the root interface for a connector that validates access to Open
 * Metadata services and instances for a specific user.  There are other optional interfaces that
 * define which actions should be validated.
 *
 * Connectors are installed into a specific OMAG Server Instance
 */
public interface OpenMetadataServerSecurity
{
    /**
     * Check that the calling user is authorized to issue a (any) request to the OMAG Server.
     *
     * @param userId calling user
     *
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForServer(String userId) throws UserNotAuthorizedException,
                                                      InvalidParameterException,
                                                      PropertyServerException;


    /**
     * Check that the calling user is authorized to update the configuration for a server.
     *
     * @param userId calling user
     *
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserAsServerAdmin(String userId) throws UserNotAuthorizedException,
                                                          InvalidParameterException,
                                                          PropertyServerException;


    /**
     * Check that the calling user is authorized to issue operator requests to the OMAG Server.
     *
     * @param userId calling user
     *
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserAsServerOperator(String userId) throws UserNotAuthorizedException,
                                                             InvalidParameterException,
                                                             PropertyServerException;


    /**
     * Check that the calling user is authorized to issue operator requests to the OMAG Server.
     *
     * @param userId calling user
     *
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserAsServerInvestigator(String userId) throws UserNotAuthorizedException,
                                                                 InvalidParameterException,
                                                                 PropertyServerException;
}
