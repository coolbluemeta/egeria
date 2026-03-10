/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.repositoryservices.connectors.stores.archivestore;

import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorDefinition;
import org.odpi.openmetadata.repositoryservices.auditlog.OMRSAuditingComponent;

import java.util.List;

/**
 * The OpenMetadataArchiveProviderStoreBase provides a base class for the connector provider supporting OMRS
 * open metadata archive stores.  It extends ConnectorProviderBase which does the creation of connector instances.
 * The subclasses of OpenMetadataArchiveStoreProviderBase must initialize ConnectorProviderBase with the Java class
 * name of the audit log connector implementation (by calling super.setConnectorClassName(className)).
 * Then the connector provider will work.
 */
public abstract class OpenMetadataArchiveStoreProviderBase extends OpenConnectorProviderBase
{
    /**
     * Default Constructor
     */
    protected OpenMetadataArchiveStoreProviderBase()
    {
        super.setConnectorComponentDescription(OMRSAuditingComponent.ARCHIVE_STORE_CONNECTOR);
    }


    /**
     * Constructor for an open connector provider.
     *
     * @param openConnectorDescription             connector definition
     * @param connectorClassName                   connector class name
     * @param recognizedConfigurationPropertyNames list of property names that the connector supports
     *                                             in the configuration properties.
     */
    public OpenMetadataArchiveStoreProviderBase(OpenConnectorDefinition openConnectorDescription,
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
    public OpenMetadataArchiveStoreProviderBase(OpenConnectorDefinition openConnectorDescription,
                                                String                  connectorClassName,
                                                List<String>            recognizedConfigurationPropertyNames,
                                                List<String>            connectorInterfaces,
                                                String                  expectedDataFormat)
    {
        super(openConnectorDescription, connectorClassName, recognizedConfigurationPropertyNames, connectorInterfaces, expectedDataFormat);
    }
}

