/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.connectors.restclients;

import org.odpi.openmetadata.frameworks.connectors.OpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;

import java.util.List;


/**
 * RESTClientConnectorProvider provides base class of the connector provider for the RESTClientConnector.
 */
public class RESTClientConnectorProvider extends OpenConnectorProviderBase
{

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * REST Client Connector implementation.  This constructor should be overridden in the connector
     * implementation.
     */
    public RESTClientConnectorProvider()
    {
       super();
    }


    /**
     * Constructor for an open connector provider.
     *
     * @param openConnectorDescription             connector definition
     * @param connectorClassName                   connector class name
     * @param recognizedConfigurationPropertyNames list of property names that the connector supports
     *                                             in the configuration properties.
     */
    public RESTClientConnectorProvider(OpenConnectorDefinition openConnectorDescription,
                                       String                  connectorClassName,
                                       List<String> recognizedConfigurationPropertyNames)
    {
        this(openConnectorDescription, connectorClassName, recognizedConfigurationPropertyNames, null, null);
    }


    /**
     * Constructor for an open connector provider.
     *
     * @param openConnectorDescription             connector definition
     * @param connectorClassName                   connector class name
     * @param recognizedConfigurationPropertyNames list of property names that the connector supports
     *                                             in the configuration properties.
     * @param connectorInterfaces                  list of interfaces that the connector supports.
     * @param expectedDataFormat                   description of the data format that the connector expects.
     */
    public RESTClientConnectorProvider(OpenConnectorDefinition openConnectorDescription,
                                       String                  connectorClassName,
                                       List<String>            recognizedConfigurationPropertyNames,
                                       List<String>            connectorInterfaces,
                                       String                  expectedDataFormat)
    {
        super(openConnectorDescription, connectorClassName, recognizedConfigurationPropertyNames, connectorInterfaces, expectedDataFormat);
    }
}
