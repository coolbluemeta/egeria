/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.apachekafka.integration;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.connectors.controls.KafkaDeployedImplementationType;
import org.odpi.openmetadata.adapters.connectors.controls.KafkaTemplateConfigurationProperty;
import org.odpi.openmetadata.adapters.connectors.controls.KafkaTemplateType;
import org.odpi.openmetadata.frameworks.connectors.controls.SupportedTechnologyType;
import org.odpi.openmetadata.frameworks.integration.controls.CatalogTargetType;
import org.odpi.openmetadata.frameworks.integration.connectors.IntegrationConnectorProvider;
import org.odpi.openmetadata.frameworks.openmetadata.definitions.DeployedImplementationTypeDefinition;

import java.util.Collections;


/**
 * KafkaMonitorIntegrationProvider is the connector provider for the kafka integration connector that extracts topic names from the broker.
 */
public class KafkaTopicIntegrationProvider extends IntegrationConnectorProvider
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName     = "org.odpi.openmetadata.adapters.connectors.apachekafka.integration.KafkaTopicIntegrationConnector";



    /**
     * The name of the catalog target that contains the server to monitor.
     */
    static public final String CATALOG_TARGET_NAME    = "kafkaServerToMonitor";

    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific
     * store implementation.
     */
    public KafkaTopicIntegrationProvider()
    {
        super(EgeriaOpenConnectorDefinition.APACHE_KAFKA_TOPIC_INTEGRATION_CONNECTOR,
              connectorClassName,
              KafkaTemplateConfigurationProperty.getRecognizedConfigurationProperties());

        super.supportedConfigurationProperties = KafkaTemplateConfigurationProperty.getConfigurationPropertyTypes();

        CatalogTargetType catalogTargetType = new CatalogTargetType();

        catalogTargetType.setName(CATALOG_TARGET_NAME);
        catalogTargetType.setTypeName(KafkaDeployedImplementationType.APACHE_KAFKA_SERVER.getAssociatedTypeName());
        catalogTargetType.setDeployedImplementationType(KafkaDeployedImplementationType.APACHE_KAFKA_SERVER.getDeployedImplementationType());

        super.catalogTargets           = Collections.singletonList(catalogTargetType);
        super.supportedTemplateTypes   = Collections.singletonList(KafkaTemplateType.KAFKA_TOPIC_TEMPLATE.getTemplateType());
        super.supportedTechnologyTypes = SupportedTechnologyType.getSupportedTechnologyTypes(new DeployedImplementationTypeDefinition[]{KafkaDeployedImplementationType.APACHE_KAFKA_SERVER, KafkaDeployedImplementationType.APACHE_KAFKA_EVENT_BROKER});
    }
}
