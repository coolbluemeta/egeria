/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.integration.basicfiles;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.controls.SupportedTechnologyType;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;
import org.odpi.openmetadata.frameworks.integration.controls.CatalogTargetType;
import org.odpi.openmetadata.frameworks.openmetadata.definitions.DeployedImplementationTypeDefinition;

import java.util.ArrayList;

/**
 * DataFolderMonitorIntegrationProvider is the OCF connector provider for the Data Folder Monitor Integration Connector.
 * This is one of the basic files integration connectors.
 */
public class DataFolderMonitorIntegrationProvider extends BasicFilesMonitorIntegrationProviderBase
{
    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * store implementation.
     */
    public DataFolderMonitorIntegrationProvider()
    {
        super(EgeriaOpenConnectorDefinition.DATA_FOLDER_MONITOR_INTEGRATION_CONNECTOR,
              "org.odpi.openmetadata.adapters.connectors.integration.basicfiles.DataFolderMonitorIntegrationConnector");

        CatalogTargetType catalogTargetType = new CatalogTargetType();

        catalogTargetType.setName(CATALOG_TARGET_NAME);
        catalogTargetType.setTypeName(DeployedImplementationType.DATA_FOLDER.getAssociatedTypeName());
        catalogTargetType.setDeployedImplementationType(DeployedImplementationType.DATA_FOLDER.getDeployedImplementationType());

        super.catalogTargets = new ArrayList<>();
        super.catalogTargets.add(catalogTargetType);

        super.supportedTechnologyTypes = SupportedTechnologyType.getSupportedTechnologyTypes(new DeployedImplementationTypeDefinition[]{DeployedImplementationType.FILE_SYSTEM_DIRECTORY,
        DeployedImplementationType.DATA_FOLDER});

        super.supportedConfigurationProperties = BasicFilesMonitoringConfigurationProperty.getConfigurationPropertyTypes();
    }
}
