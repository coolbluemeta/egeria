/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.metadatasecurity.connectors;

import org.odpi.openmetadata.frameworks.connectors.OpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;
import org.odpi.openmetadata.repositoryservices.auditlog.OMRSAuditingComponent;

import java.util.List;


/**
 * OpenMetadataPlatformSecurityProvider provides implementation of the connector provider for the
 * Open Metadata Platform Security connector.
 */
public abstract class OpenMetadataPlatformSecurityProvider extends OpenConnectorProviderBase
{
    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * OMRS Connector implementation.
     */
    public OpenMetadataPlatformSecurityProvider()
    {
    }


    /**
     * Constructor for an open connector provider.
     *
     * @param openConnectorDescription             connector definition
     * @param connectorClassName                   connector class name
     * @param recognizedConfigurationPropertyNames list of property names that the connector supports
     *                                             in the configuration properties.
     */
    public OpenMetadataPlatformSecurityProvider(OpenConnectorDefinition openConnectorDescription,
                                                String                  connectorClassName,
                                                List<String> recognizedConfigurationPropertyNames)
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
    public OpenMetadataPlatformSecurityProvider(OpenConnectorDefinition openConnectorDescription,
                                                String                  connectorClassName,
                                                List<String>            recognizedConfigurationPropertyNames,
                                                List<String>            connectorInterfaces,
                                                String                  expectedDataFormat)
    {
        super(openConnectorDescription, connectorClassName, recognizedConfigurationPropertyNames, connectorInterfaces, expectedDataFormat);
    }
}