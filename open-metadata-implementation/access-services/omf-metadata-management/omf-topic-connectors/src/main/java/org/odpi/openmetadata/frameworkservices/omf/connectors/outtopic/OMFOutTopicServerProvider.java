/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworkservices.omf.connectors.outtopic;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;

/**
 * The OMFOutTopicServerProvider provides a base class for the connector provider supporting
 * OMFOutTopicServerConnector Connectors.
 * It extends ConnectorProviderBase, which does the creation of connector instances.  The subclasses of
 * OMFOutTopicClientProvider must initialize ConnectorProviderBase with the Java class
 * name of their Connector implementation (by calling super.setConnectorClassName(className)).
 * Then the connector provider will work.
 */
public class OMFOutTopicServerProvider extends OpenConnectorProviderBase
{
    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * topic connector implementation.
     */
    public OMFOutTopicServerProvider()
    {
        super(EgeriaOpenConnectorDefinition.OMF_TOPIC_SERVER_CONNECTOR,
              OMFOutTopicServerConnector.class.getName(),
              null);
    }
}