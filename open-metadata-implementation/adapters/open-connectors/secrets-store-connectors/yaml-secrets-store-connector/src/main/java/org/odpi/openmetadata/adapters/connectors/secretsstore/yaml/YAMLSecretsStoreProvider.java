/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.secretsstore.yaml;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;
import org.odpi.openmetadata.frameworks.connectors.controls.SecretsStoreConfigurationProperty;


/**
 * YAMLSecretsStoreProvider is the connector provider for the Secrets Store Connector based on a YAML File.
 * This connector can only access a single secrets collection. The name of this secrets collection is specified in the configuration properties.
 */
public class YAMLSecretsStoreProvider extends OpenConnectorProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName     = YAMLSecretsStoreConnector.class.getName();

    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific
     * store implementation.
     */
    public YAMLSecretsStoreProvider()
    {
        super(EgeriaOpenConnectorDefinition.YAML_SECRETS_STORE_CONNECTOR,
              connectorClassName,
              SecretsStoreConfigurationProperty.getRecognizedConfigurationProperties());

        super.supportedConfigurationProperties = SecretsStoreConfigurationProperty.getConfigurationPropertyTypes();
    }
}
