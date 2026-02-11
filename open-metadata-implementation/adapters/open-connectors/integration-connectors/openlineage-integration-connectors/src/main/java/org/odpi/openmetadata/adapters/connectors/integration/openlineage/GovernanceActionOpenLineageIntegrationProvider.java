/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.connectors.integration.openlineage;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.connectors.integration.openlineage.controls.OpenLineagePublishConfigurationProperty;
import org.odpi.openmetadata.frameworks.integration.connectors.IntegrationConnectorProvider;


/**
 * The GovernanceActionOpenLineageIntegrationProvider provides the connector provider for GovernanceActionOpenLineageIntegrationConnector.
 */
public class GovernanceActionOpenLineageIntegrationProvider extends IntegrationConnectorProvider
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName = "org.odpi.openmetadata.adapters.connectors.integration.openlineage.GovernanceActionOpenLineageIntegrationConnector";


    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific connector implementation.
     */
    public GovernanceActionOpenLineageIntegrationProvider()
    {
        super(EgeriaOpenConnectorDefinition.GOVERNANCE_ACTION_OPEN_LINEAGE_INTEGRATION_CONNECTOR,
              connectorClassName,
              OpenLineagePublishConfigurationProperty.getRecognizedConfigurationProperties());

        super.supportedConfigurationProperties = OpenLineagePublishConfigurationProperty.getConfigurationPropertyTypes();
    }
}

