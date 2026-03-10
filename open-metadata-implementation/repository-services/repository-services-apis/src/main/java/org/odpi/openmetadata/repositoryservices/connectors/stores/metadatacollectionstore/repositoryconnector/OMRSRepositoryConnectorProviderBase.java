/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector;

import org.odpi.openmetadata.frameworks.connectors.OpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;
import org.odpi.openmetadata.repositoryservices.auditlog.OMRSAuditingComponent;

import java.util.List;

/**
 * The OMRSRepositoryConnectorProviderBase provides a base class for the connector provider supporting OMRS Connectors.
 * It adds no function but provides a placeholder for additional function if needed for the creation of
 * any OMRS Repository connectors.
 * It extends ConnectorProviderBase which does the creation of connector instances.  The subclasses of
 * OMRSRepositoryConnectorProviderBase must initialize ConnectorProviderBase with the Java class
 * name of the OMRS Connector implementation (by calling super.setConnectorClassName(className)).
 * Then the connector provider will work.
 */
public abstract class OMRSRepositoryConnectorProviderBase extends OpenConnectorProviderBase
{
    /**
     * Default Constructor
     */
    public OMRSRepositoryConnectorProviderBase()
    {
        super.setConnectorComponentDescription(OMRSAuditingComponent.REPOSITORY_CONNECTOR);
    }




    /**
     * Constructor for an open connector provider.
     *
     * @param openConnectorDescription             connector definition
     * @param connectorClassName                   connector class name
     * @param recognizedConfigurationPropertyNames list of property names that the connector supports
     *                                             in the configuration properties.
     */
    public OMRSRepositoryConnectorProviderBase(OpenConnectorDefinition openConnectorDescription,
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
    public OMRSRepositoryConnectorProviderBase(OpenConnectorDefinition openConnectorDescription,
                                               String                  connectorClassName,
                                               List<String>            recognizedConfigurationPropertyNames,
                                               List<String>            connectorInterfaces,
                                               String                  expectedDataFormat)
    {
        super(openConnectorDescription, connectorClassName, recognizedConfigurationPropertyNames, connectorInterfaces, expectedDataFormat);
    }
}