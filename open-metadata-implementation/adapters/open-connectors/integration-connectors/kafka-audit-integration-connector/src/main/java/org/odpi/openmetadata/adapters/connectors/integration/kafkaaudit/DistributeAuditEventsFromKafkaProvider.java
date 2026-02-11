/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.integration.kafkaaudit;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.connectors.integration.kafkaaudit.controls.DistributeAuditEventCatalogTarget;
import org.odpi.openmetadata.frameworks.connectors.controls.SupportedTechnologyType;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;
import org.odpi.openmetadata.frameworks.integration.connectors.IntegrationConnectorProvider;
import org.odpi.openmetadata.frameworks.openmetadata.definitions.DeployedImplementationTypeDefinition;


/**
 * DistributeAuditEventsFromKafkaProvider is the connector provider for the LoadAuditEventsFromKafka connector that publishes insights about
 * the audit log events being published to a kafka topic.
 */
public class DistributeAuditEventsFromKafkaProvider extends IntegrationConnectorProvider
{
    /**
     * Class of the connector.
     */
    private static final String connectorClassName     = "org.odpi.openmetadata.adapters.connectors.integration.kafkaaudit.DistributeAuditEventsFromKafkaConnector";

    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific
     * store implementation.
     */
    public DistributeAuditEventsFromKafkaProvider()
    {
        super(EgeriaOpenConnectorDefinition.DISTRIBUTE_AUDIT_LOG_EVENTS_FROM_KAFKA_TOPIC,
              connectorClassName,
              null);

        super.catalogTargets = DistributeAuditEventCatalogTarget.getCatalogTargetTypes();
        super.supportedTechnologyTypes = SupportedTechnologyType.getSupportedTechnologyTypes(new DeployedImplementationTypeDefinition[]{DeployedImplementationType.APACHE_KAFKA_TOPIC, DeployedImplementationType.DATA_ASSET});
    }
}
