/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.egeriainfrastructure.servers;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.connectors.egeriainfrastructure.control.OMAGServerPlatformConfigurationProperty;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;

/**
 * Connector Provider
 */
public class ViewServerProvider extends OpenConnectorProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName       = "org.odpi.openmetadata.adapters.connectors.egeriainfrastructure.servers.ViewServerConnector";

    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific
     * store implementation.
     */
    public ViewServerProvider()
    {
        super(EgeriaOpenConnectorDefinition.VIEW_SERVER_RESOURCE_CONNECTOR,
              connectorClassName,
              OMAGServerPlatformConfigurationProperty.getRecognizedConfigurationProperties());

        super.supportedConfigurationProperties = OMAGServerPlatformConfigurationProperty.getConfigurationPropertyTypes();
    }
}
