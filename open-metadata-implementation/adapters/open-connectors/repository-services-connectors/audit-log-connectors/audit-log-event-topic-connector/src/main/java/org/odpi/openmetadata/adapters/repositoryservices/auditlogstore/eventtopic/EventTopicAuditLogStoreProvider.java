/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.repositoryservices.auditlogstore.eventtopic;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.repositoryservices.connectors.stores.auditlogstore.OMRSAuditLogStoreProviderBase;

import java.util.Collections;

/**
 * EventTopicAuditLogStoreProvider is the OCF connector provider for the event topic audit log store destination.
 * This log destination is an event topic and each log record is sent as an individual event with a JSON payload.
 */
public class EventTopicAuditLogStoreProvider extends OMRSAuditLogStoreProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName  = "org.odpi.openmetadata.adapters.repositoryservices.auditlogstore.eventtopic.EventTopicAuditLogStoreConnector";


    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * audit log destination implementation.
     */
    public EventTopicAuditLogStoreProvider()
    {
        super(EgeriaOpenConnectorDefinition.TOPIC_AUDIT_LOG_DESTINATION_CONNECTOR,
              connectorClassName,
              Collections.singletonList(supportedSeveritiesProperty));
    }
}

