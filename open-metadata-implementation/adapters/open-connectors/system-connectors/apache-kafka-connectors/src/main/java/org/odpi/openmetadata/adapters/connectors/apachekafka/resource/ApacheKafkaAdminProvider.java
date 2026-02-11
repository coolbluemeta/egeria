/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.apachekafka.resource;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.connectors.controls.KafkaDeployedImplementationType;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;
import org.odpi.openmetadata.frameworks.connectors.controls.SupportedTechnologyType;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;
import org.odpi.openmetadata.frameworks.openmetadata.definitions.DeployedImplementationTypeDefinition;


/**
 * ApacheKafkaAdminProvider is the connector provider for the Apache Kafka Admin connector that provides a Java API
 * to the Apache Kafka's Admin interface.
 */
public class ApacheKafkaAdminProvider extends OpenConnectorProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName       = "org.odpi.openmetadata.adapters.connectors.apachekafka.resource.ApacheKafkaAdminConnector";


    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific
     * store implementation.
     */
    public ApacheKafkaAdminProvider()
    {
        super(EgeriaOpenConnectorDefinition.APACHE_KAFKA_ADMIN_RESOURCE_CONNECTOR,
              connectorClassName,
              null);

        super.supportedTechnologyTypes = SupportedTechnologyType.getSupportedTechnologyTypes(new DeployedImplementationTypeDefinition[]{KafkaDeployedImplementationType.APACHE_KAFKA_SERVER, KafkaDeployedImplementationType.APACHE_KAFKA_EVENT_BROKER, DeployedImplementationType.APACHE_KAFKA_TOPIC});
    }
}
