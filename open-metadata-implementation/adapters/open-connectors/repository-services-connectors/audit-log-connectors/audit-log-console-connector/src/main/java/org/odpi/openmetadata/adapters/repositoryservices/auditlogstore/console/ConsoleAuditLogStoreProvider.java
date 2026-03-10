/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.repositoryservices.auditlogstore.console;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.repositoryservices.connectors.stores.auditlogstore.OMRSAuditLogStoreProviderBase;

import java.util.Collections;


/**
 * ConsoleAuditLogStoreProvider is the OCF connector provider for the console audit log store.
 */
public class ConsoleAuditLogStoreProvider extends OMRSAuditLogStoreProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName = "org.odpi.openmetadata.adapters.repositoryservices.auditlogstore.console.ConsoleAuditLogStoreConnector";

    /**
     * Constructor used to initialize the OpenConnectorProviderBase with the Java class name of the specific
     * audit log store implementation.
     */
    public ConsoleAuditLogStoreProvider()
    {
        super(EgeriaOpenConnectorDefinition.CONSOLE_AUDIT_LOG_DESTINATION_CONNECTOR,
              connectorClassName,
              Collections.singletonList(supportedSeveritiesProperty));
    }
}

