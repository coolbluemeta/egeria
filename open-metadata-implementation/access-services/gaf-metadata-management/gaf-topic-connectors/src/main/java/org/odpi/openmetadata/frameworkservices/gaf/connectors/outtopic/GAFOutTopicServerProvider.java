/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworkservices.gaf.connectors.outtopic;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;

/**
 * The GAFOutTopicServerProvider provides a base class for the connector provider supporting
 * GAFOutTopicServerConnector Connectors.
 * It extends ConnectorProviderBase, which does the creation of connector instances.  The subclasses of
 * GAFOutTopicClientProvider must initialize ConnectorProviderBase with the Java class
 * name of their Connector implementation (by calling super.setConnectorClassName(className)).
 * Then the connector provider will work.
 */
public class GAFOutTopicServerProvider extends OpenConnectorProviderBase
{
    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * discovery service implementation.
     */
    public GAFOutTopicServerProvider()
    {
        super(EgeriaOpenConnectorDefinition.GAF_TOPIC_SERVER_CONNECTOR,
              GAFOutTopicServerConnector.class.getName(),
              null);
    }
}