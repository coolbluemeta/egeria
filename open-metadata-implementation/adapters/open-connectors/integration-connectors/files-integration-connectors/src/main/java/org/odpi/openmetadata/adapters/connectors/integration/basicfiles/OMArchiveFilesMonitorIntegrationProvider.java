/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.integration.basicfiles;


import org.odpi.openmetadata.frameworks.connectors.controls.SupportedTechnologyType;
import org.odpi.openmetadata.frameworks.integration.controls.CatalogTargetType;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationTypeDefinition;

import java.util.ArrayList;

/**
 * OMArchiveFilesMonitorIntegrationProvider is the OCF connector provider for the Open Metadata Archive Files Monitor Integration Connector.
 * This is one of the basic files integration connectors.
 */
public class OMArchiveFilesMonitorIntegrationProvider extends BasicFilesMonitorIntegrationProviderBase
{
    private static final String connectorTypeGUID      = "67ed3803-9e14-4a5a-93f3-8d358f3d1ac4";
    private static final int    connectorComponentId   = 697;
    private static final String connectorQualifiedName = "Egeria:IntegrationConnector:Files:OpenMetadataArchiveFilesMonitor";
    private static final String connectorDisplayName   = "Open Metadata Archive Files Monitor Integration Connector";
    private static final String connectorDescription   = "Connector supports cataloguing of Open Metadata Archive files under a specific directory (folder) in the file system.";
    private static final String connectorWikiPage      = "https://egeria-project.org/connectors/integration/om-archive-files-monitor-integration-connector/";

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * store implementation.
     */
    public OMArchiveFilesMonitorIntegrationProvider()
    {
        super(connectorTypeGUID,
              connectorComponentId,
              connectorQualifiedName,
              connectorDisplayName,
              connectorDescription,
              connectorWikiPage,
              "org.odpi.openmetadata.adapters.connectors.integration.basicfiles.OMArchiveFilesMonitorIntegrationConnector");

        CatalogTargetType catalogTargetType = new CatalogTargetType();

        catalogTargetType.setName(CATALOG_TARGET_NAME);
        catalogTargetType.setTypeName(DeployedImplementationType.FILE_FOLDER.getAssociatedTypeName());
        catalogTargetType.setDeployedImplementationType(DeployedImplementationType.FILE_FOLDER.getDeployedImplementationType());

        super.catalogTargets = new ArrayList<>();
        super.catalogTargets.add(catalogTargetType);
        super.supportedTechnologyTypes = SupportedTechnologyType.getSupportedTechnologyTypes(new DeployedImplementationTypeDefinition[]{DeployedImplementationType.FILE_FOLDER,
                DeployedImplementationType.DATA_FOLDER, DeployedImplementationType.DATA_FILE, DeployedImplementationType.FILE});
        super.supportedConfigurationProperties = BasicFilesMonitoringConfigurationProperty.getConfigurationPropertyTypes();
    }
}
