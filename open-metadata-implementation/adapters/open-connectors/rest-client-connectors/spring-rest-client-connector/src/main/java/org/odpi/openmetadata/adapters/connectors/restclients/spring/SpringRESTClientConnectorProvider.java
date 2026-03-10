/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.connectors.restclients.spring;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.connectors.restclients.RESTClientConnectorProvider;


/**
 * SpringRESTClientConnectorProvider provides the connector provider for the SpringRESTClientConnector.
 */
public class SpringRESTClientConnectorProvider extends RESTClientConnectorProvider
{
    static final String  connectorClass = SpringRESTClientConnector.class.getName();

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * REST Client Connector implementation.
     */
    public SpringRESTClientConnectorProvider()
    {
        super(EgeriaOpenConnectorDefinition.SPRING_REST_API_CONNECTOR,
              connectorClass,
              null);
    }
}
