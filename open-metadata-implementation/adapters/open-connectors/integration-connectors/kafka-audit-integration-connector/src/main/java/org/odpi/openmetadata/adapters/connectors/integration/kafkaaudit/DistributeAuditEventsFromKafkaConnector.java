/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.connectors.integration.kafkaaudit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.odpi.openmetadata.adapters.connectors.integration.kafkaaudit.controls.DistributeAuditEventCatalogTarget;
import org.odpi.openmetadata.adapters.connectors.integration.kafkaaudit.ffdc.DistributeKafkaAuditCode;
import org.odpi.openmetadata.frameworks.connectors.Connector;
import org.odpi.openmetadata.frameworks.connectors.ffdc.ConnectorCheckedException;
import org.odpi.openmetadata.frameworks.governanceaction.properties.CatalogTarget;
import org.odpi.openmetadata.frameworks.integration.connectors.CatalogTargetIntegrator;
import org.odpi.openmetadata.frameworks.integration.properties.RequestedCatalogTarget;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;
import org.odpi.openmetadata.integrationservices.catalog.connector.CatalogIntegratorConnector;
import org.odpi.openmetadata.repositoryservices.connectors.openmetadatatopic.OpenMetadataTopicListener;
import org.odpi.openmetadata.repositoryservices.connectors.stores.auditlogstore.OMRSAuditLogRecord;

/**
 * Distributes audit log events from one or more embedded topic connectors to one or more embedded audit log destinations.
 */
public class DistributeAuditEventsFromKafkaConnector extends CatalogIntegratorConnector implements OpenMetadataTopicListener,
                                                                                                   CatalogTargetIntegrator
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    /**
     * Requests that the connector does a comparison of the metadata in the third party technology and open metadata repositories.
     * Refresh is called when the integration connector first starts and then at intervals defined in the connector's configuration
     * as well as any external REST API calls to explicitly refresh the connector.
     *
     * @throws ConnectorCheckedException there is a problem with the connector.  It is not able to refresh the metadata.
     */
    @Override
    public void refresh() throws ConnectorCheckedException
    {
        super.refreshCatalogTargets(this);
    }


    /**
     * Method to pass an event received on topic.
     *
     * @param event inbound event
     */
    @Override
    public void processEvent(String event)
    {
        final String methodName = "processEvent";

        if (event != null)
        {
            try
            {
                OMRSAuditLogRecord eventObject = OBJECT_MAPPER.readValue(event, OMRSAuditLogRecord.class);

                for (RequestedCatalogTarget requestedCatalogTarget : catalogTargetsManager.getRequestedCatalogTargets())
                {
                    if (requestedCatalogTarget instanceof AuditLogDestinationCatalogTargetProcessor auditLogDestination)
                    {
                        auditLogDestination.storeLogRecord(eventObject);
                    }
                }
            }
            catch (Exception error)
            {
                auditLog.logException(methodName,
                                      DistributeKafkaAuditCode.UNEXPECTED_EXCEPTION.getMessageDefinition(connectorName,
                                                                                                         error.getClass().getName(),

                                                                                                         error.getMessage()),
                                      error);
            }
        }
    }


    /**
     * Perform the required integration logic for the assigned catalog target.
     *
     * @param requestedCatalogTarget the catalog target
     * @throws ConnectorCheckedException there is an unrecoverable error and the connector should stop processing.
     */
    @Override
    public void integrateCatalogTarget(RequestedCatalogTarget requestedCatalogTarget) throws ConnectorCheckedException
    {
        // Nothing to do
    }


    /**
     * Create a new catalog target processor (typically inherits from CatalogTargetProcessorBase).
     *
     * @param retrievedCatalogTarget details of the open metadata elements describing the catalog target
     * @param connectorToTarget connector to access the target resource
     * @return new processor based on the catalog target information
     * @throws ConnectorCheckedException problem connecting to topic
     */
    @Override
    public RequestedCatalogTarget getNewRequestedCatalogTargetSkeleton(CatalogTarget retrievedCatalogTarget,
                                                                       Connector     connectorToTarget) throws ConnectorCheckedException
    {
        if (DistributeAuditEventCatalogTarget.INCOMING_TOPIC.getName().equals(retrievedCatalogTarget.getCatalogTargetName()))
        {
            if (propertyHelper.isTypeOf(retrievedCatalogTarget.getCatalogTargetElement(), OpenMetadataType.KAFKA_TOPIC.typeName))
            {
                return new KafkaTopicSourceCatalogTargetProcessor(retrievedCatalogTarget,
                                                                  connectorToTarget,
                                                                  connectorName,
                                                                  auditLog,
                                                                  this);
            }
        }
        else if (DistributeAuditEventCatalogTarget.DESTINATION.getName().equals(retrievedCatalogTarget.getCatalogTargetName()))
        {
            if (propertyHelper.isTypeOf(retrievedCatalogTarget.getCatalogTargetElement(), OpenMetadataType.DATA_ASSET.typeName))
            {
                return new AuditLogDestinationCatalogTargetProcessor(retrievedCatalogTarget,
                                                                     connectorToTarget,
                                                                     connectorName,
                                                                     auditLog);
            }
        }

        return new RequestedCatalogTarget(retrievedCatalogTarget, connectorToTarget);
    }
}
