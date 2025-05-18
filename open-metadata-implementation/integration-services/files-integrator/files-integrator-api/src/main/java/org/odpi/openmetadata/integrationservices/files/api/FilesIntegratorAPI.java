/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.integrationservices.files.api;

import org.odpi.openmetadata.commonservices.ffdc.properties.ConnectorReport;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.UserNotAuthorizedException;


/**
 * FilesIntegratorAPI is the interface to validate that a connector is suitable to run in the Files Integrator OMIS.
 * It validates that it implements the correct interfaces and returns the connector type for the connector.
 */
public interface FilesIntegratorAPI
{
    /**
     * Validate the connector and return its connector type.
     *
     * @param userId calling user
     * @param connectorProviderClassName name of a specific connector or null for all connectors
     *
     * @return connector report for this connector
     *
     * @throws InvalidParameterException the connector provider class name is not a valid connector fo this service
     * @throws UserNotAuthorizedException user not authorized to issue this request
     * @throws PropertyServerException there was a problem detected by the integration service
     */
    ConnectorReport validateConnector(String userId,
                                      String connectorProviderClassName) throws InvalidParameterException,
                                                                                UserNotAuthorizedException,
                                                                                PropertyServerException;
}
