/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworkservices.omf.connectors.outtopic;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;

/**
 * The OMFOutTopicClientProvider provides a base class for the connector provider supporting
 * OMFOutTopicClientConnector Connectors.
 * It extends ConnectorProviderBase, which does the creation of connector instances.  The subclasses of
 * OMFOutTopicClientProvider must initialize ConnectorProviderBase with the Java class
 * name of their Connector implementation (by calling super.setConnectorClassName(className)).
 * Then the connector provider will work.
 */
public class OMFOutTopicClientProvider extends OpenConnectorProviderBase
{
    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * topic implementation.
     */
    public OMFOutTopicClientProvider()
    {
        super(EgeriaOpenConnectorDefinition.OMF_TOPIC_CLIENT_CONNECTOR,
              OMFOutTopicClientConnector.class.getName(),
              null);
    }
}