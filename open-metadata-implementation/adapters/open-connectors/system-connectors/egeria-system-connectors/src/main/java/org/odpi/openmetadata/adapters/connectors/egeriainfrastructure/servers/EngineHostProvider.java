/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.egeriainfrastructure.servers;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.connectors.egeriainfrastructure.control.OMAGServerPlatformConfigurationProperty;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;

/**
 * Connector Provider
 */
public class EngineHostProvider extends OpenConnectorProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName       = "org.odpi.openmetadata.adapters.connectors.egeriainfrastructure.servers.EngineHostConnector";


    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific
     * store implementation.
     */
    public EngineHostProvider()
    {
        super(EgeriaOpenConnectorDefinition.ENGINE_HOST_RESOURCE_CONNECTOR,
              connectorClassName,
              OMAGServerPlatformConfigurationProperty.getRecognizedConfigurationProperties());

        super.supportedConfigurationProperties = OMAGServerPlatformConfigurationProperty.getConfigurationPropertyTypes();
    }
}
