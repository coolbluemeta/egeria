/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.repositoryservices.connectors.omrstopic;

import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorDefinition;
import org.odpi.openmetadata.repositoryservices.auditlog.OMRSAuditingComponent;

import java.util.List;


/**
 * OMRSTopicProvider provides implementation of the connector provider for the OMRSTopicConnector.
 */
public class OMRSTopicProvider extends OpenConnectorProviderBase
{
    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * OMRS Connector implementation.
     */
    public OMRSTopicProvider()
    {
        Class<OMRSTopicConnector>    connectorClass = OMRSTopicConnector.class;

        super.setConnectorClassName(connectorClass.getName());
        super.setConnectorComponentDescription(OMRSAuditingComponent.OMRS_TOPIC_CONNECTOR);
    }


    /**
     * Constructor for an open connector provider.
     *
     * @param openConnectorDescription             connector definition
     * @param connectorClassName                   connector class name
     * @param recognizedConfigurationPropertyNames list of property names that the connector supports
     *                                             in the configuration properties.
     */
    public OMRSTopicProvider(OpenConnectorDefinition openConnectorDescription,
                             String                  connectorClassName,
                             List<String>            recognizedConfigurationPropertyNames)
    {
        super(openConnectorDescription, connectorClassName, recognizedConfigurationPropertyNames);
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
    public OMRSTopicProvider(OpenConnectorDefinition openConnectorDescription,
                             String                  connectorClassName,
                             List<String>            recognizedConfigurationPropertyNames,
                             List<String>            connectorInterfaces,
                             String                  expectedDataFormat)
    {
        super(openConnectorDescription, connectorClassName, recognizedConfigurationPropertyNames, connectorInterfaces, expectedDataFormat);
    }
}
