/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.egeriainfrastructure.platform;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;

/**
 * Connector Provider
 */
public class OMAGServerPlatformProvider extends OpenConnectorProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName       = "org.odpi.openmetadata.adapters.connectors.egeriainfrastructure.platform.OMAGServerPlatformConnector";


    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific
     * store implementation.
     */
    public OMAGServerPlatformProvider()
    {
        super(EgeriaOpenConnectorDefinition.OMAG_SERVER_PLATFORM_RESOURCE_CONNECTOR,
              connectorClassName,
              null);
    }
}
