/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.governanceservers.enginehostservices.listener;

import org.odpi.openmetadata.adminservices.configuration.properties.EngineConfig;
import org.odpi.openmetadata.frameworks.auditlog.AuditLog;
import org.odpi.openmetadata.frameworks.openmetadata.events.OpenMetadataEventListener;
import org.odpi.openmetadata.frameworks.openmetadata.events.OpenMetadataOutTopicEvent;
import org.odpi.openmetadata.governanceservers.enginehostservices.admin.GovernanceEngineHandler;
import org.odpi.openmetadata.governanceservers.enginehostservices.api.WatchdogEventSupportingEngine;
import org.odpi.openmetadata.governanceservers.enginehostservices.enginemap.GovernanceEngineMap;
import org.odpi.openmetadata.governanceservers.enginehostservices.ffdc.EngineHostServicesAuditCode;


/**
 * OpenMetadataOutTopicListener receives watchdog events from the open metadata out topic.
 */
public class OpenMetadataOutTopicListener implements OpenMetadataEventListener
{
    private final EngineConfig        engineConfig;
    private final GovernanceEngineMap governanceEngineHandlers;
    private final AuditLog            auditLog;


    /**
     * Constructor for the listener.  Its job is to receive events and pass the information received on to the
     * appropriate governance engine handler.
     *
     * @param engineConfig the specific engine that this listener is focused on
     * @param governanceEngineHandlers these are the handlers for all the governance engines that are hosted by this
     *                                engine host server.
     * @param auditLog logging destination
     */
    public OpenMetadataOutTopicListener(EngineConfig        engineConfig,
                                        GovernanceEngineMap governanceEngineHandlers,
                                        AuditLog            auditLog)
    {
        this.engineConfig = engineConfig;
        this.governanceEngineHandlers = governanceEngineHandlers;
        this.auditLog = auditLog;
    }


    /**
     * Process an event that was published by the Open Metadata Services.
     *
     * @param event event object - call getEventType to find out what type of event.
     */
    @Override
    public void processEvent(OpenMetadataOutTopicEvent event)
    {
        if ((event != null) && event.getElementHeader() != null)
        {
            GovernanceEngineHandler governanceEngineHandler = governanceEngineHandlers.getGovernanceEngineHandler(engineConfig);

            if (governanceEngineHandler == null)
            {
                return;
            }

            /*
             * Pass on events to listening governance services
             */
            if (governanceEngineHandler instanceof WatchdogEventSupportingEngine watchdogEventSupportingEngine)
            {
                final String actionDescription = "processWatchdogEvent";

                try
                {
                    watchdogEventSupportingEngine.publishWatchdogEvent(event);
                }
                catch (Exception error)
                {
                    auditLog.logException(actionDescription,
                                          EngineHostServicesAuditCode.UNEXPECTED_EXCEPTION.getMessageDefinition(governanceEngineHandler.getClass().getName(),
                                                                                                                engineConfig.getEngineQualifiedName(),
                                                                                                                error.getClass().getName(),
                                                                                                                actionDescription,
                                                                                                                error.getMessage()),
                                          event.toString(),
                                          error);
                }
            }
        }
    }
}
