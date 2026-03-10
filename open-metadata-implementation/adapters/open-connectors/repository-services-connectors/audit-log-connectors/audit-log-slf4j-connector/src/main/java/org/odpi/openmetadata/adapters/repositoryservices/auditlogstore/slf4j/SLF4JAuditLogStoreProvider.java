/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.repositoryservices.auditlogstore.slf4j;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.repositoryservices.connectors.stores.auditlogstore.OMRSAuditLogStoreProviderBase;

import java.util.Collections;

/**
 * SLF4JAuditLogStoreProvider is the OCF connector provider for the SLF4J audit log store destination.
 */
public class SLF4JAuditLogStoreProvider extends OMRSAuditLogStoreProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName       = "org.odpi.openmetadata.adapters.repositoryservices.auditlogstore.slf4j.SLF4JAuditLogStoreConnector";

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * audit log store implementation.
     */
    public SLF4JAuditLogStoreProvider()
    {
        super(EgeriaOpenConnectorDefinition.SLF4J_AUDIT_LOG_DESTINATION_CONNECTOR,
              connectorClassName,
              Collections.singletonList(supportedSeveritiesProperty));
    }
}

