/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.integration.openlineage;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.integration.connectors.IntegrationConnectorProvider;


/**
 * OpenLineageEventReceiverIntegrationProvider is the connector provider for the OpenLineageEventReceiverIntegrationConnector.
 */
public class OpenLineageEventReceiverIntegrationProvider extends IntegrationConnectorProvider
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName     = "org.odpi.openmetadata.adapters.connectors.integration.openlineage.OpenLineageEventReceiverIntegrationConnector";


    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific connector implementation.
     */
    public OpenLineageEventReceiverIntegrationProvider()
    {
        super(EgeriaOpenConnectorDefinition.OPEN_LINEAGE_EVENT_RECEIVER_INTEGRATION_CONNECTOR,
              connectorClassName,
              null);
    }
}
