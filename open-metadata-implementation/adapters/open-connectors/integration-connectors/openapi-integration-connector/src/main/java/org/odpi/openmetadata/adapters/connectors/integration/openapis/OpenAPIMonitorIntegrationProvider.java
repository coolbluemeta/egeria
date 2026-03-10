/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.integration.openapis;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.controls.SupportedTechnologyType;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;
import org.odpi.openmetadata.frameworks.integration.connectors.IntegrationConnectorProvider;
import org.odpi.openmetadata.frameworks.openmetadata.definitions.DeployedImplementationTypeDefinition;

import java.util.Collections;


/**
 * OpenAPIMonitorIntegrationProvider is the base class provider for the openAPI integration connector.
 */
public class OpenAPIMonitorIntegrationProvider extends IntegrationConnectorProvider
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName      = "org.odpi.openmetadata.adapters.connectors.integration.openapis.OpenAPIMonitorIntegrationConnector";

    static final String TEMPLATE_QUALIFIED_NAME_CONFIGURATION_PROPERTY = "templateQualifiedName";


    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific
     * store implementation.
     */
    public OpenAPIMonitorIntegrationProvider()
    {
        super(EgeriaOpenConnectorDefinition.OPEN_API_MONITORING_INTEGRATION_CONNECTOR,
              connectorClassName,
              Collections.singletonList(TEMPLATE_QUALIFIED_NAME_CONFIGURATION_PROPERTY));

        super.supportedTechnologyTypes = SupportedTechnologyType.getSupportedTechnologyTypes(new DeployedImplementationTypeDefinition[]{DeployedImplementationType.SOFTWARE_SERVER});
    }
}
