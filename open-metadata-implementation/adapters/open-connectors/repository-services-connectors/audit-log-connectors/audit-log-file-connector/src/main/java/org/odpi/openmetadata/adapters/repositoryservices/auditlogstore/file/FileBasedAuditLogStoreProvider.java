/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.repositoryservices.auditlogstore.file;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.repositoryservices.connectors.stores.auditlogstore.OMRSAuditLogStoreProviderBase;

import java.util.Collections;

/**
 * FileBasedAuditLogStoreProvider is the OCF connector provider for the file based audit log store.
 */
public class FileBasedAuditLogStoreProvider extends OMRSAuditLogStoreProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName = "org.odpi.openmetadata.adapters.repositoryservices.auditlogstore.file.FileBasedAuditLogStoreConnector";


    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * audit log store implementation.
     */
    public FileBasedAuditLogStoreProvider()
    {
        super(EgeriaOpenConnectorDefinition.FILE_AUDIT_LOG_DESTINATION_CONNECTOR,
              connectorClassName,
              Collections.singletonList(supportedSeveritiesProperty));
    }
}
