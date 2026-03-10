/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.repositoryservices.postgres.repositoryconnector;


import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.repositoryservices.postgres.repositoryconnector.controls.PostgresConfigurationProperty;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryConnectorProviderBase;

/**
 * In the Open Connector Framework (OCF), a ConnectorProvider is a factory for a specific type of connector.
 * The PostgresOMRSRepositoryConnectorProvider is the connector provider for the PostgresOMRSRepositoryConnector.
 * It extends OMRSRepositoryConnectorProviderBase which in turn extends the OCF ConnectorProviderBase.
 * ConnectorProviderBase supports the creation of connector instances.
 * <br><br>
 * The PostgresOMRSRepositoryConnectorProvider must initialize ConnectorProviderBase with the Java class
 * name of the OMRS Connector implementation (by calling super.setConnectorClassName(className)).
 * Then the connector provider will work.
 */
public class PostgresOMRSRepositoryConnectorProvider extends OMRSRepositoryConnectorProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName     = "org.odpi.openmetadata.adapters.repositoryservices.postgres.repositoryconnector.PostgresOMRSRepositoryConnector";

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * OMRS Connector implementation.
     */
    public PostgresOMRSRepositoryConnectorProvider()
    {
        super(EgeriaOpenConnectorDefinition.POSTGRES_REPOSITORY_CONNECTOR,
              connectorClassName,
              PostgresConfigurationProperty.getRecognizedConfigurationProperties());

        super.supportedConfigurationProperties = PostgresConfigurationProperty.getConfigurationPropertyTypes();
    }
}