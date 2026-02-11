/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.connectors.integration.csvlineageimporter;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;
import org.odpi.openmetadata.frameworks.integration.controls.CatalogTargetType;
import org.odpi.openmetadata.frameworks.integration.connectors.IntegrationConnectorProvider;

import java.util.ArrayList;

public class CSVLineageImporterProvider extends IntegrationConnectorProvider
{
    private static final String connectorClassName     = "org.odpi.openmetadata.adapters.connectors.integration.csvlineageimporter.CSVLineageImporterConnector";

    /**
     * The name of the catalog target that contains the file to monitor.
     */
    static public final String CATALOG_TARGET_NAME    = "fileToLoad";

    public CSVLineageImporterProvider()
    {
        super(EgeriaOpenConnectorDefinition.CSV_LINEAGE_IMPORTER_INTEGRATION_CONNECTOR,
              connectorClassName,
              null);;

        super.catalogTargets = new ArrayList<>();
        CatalogTargetType catalogTargetType = new CatalogTargetType();

        catalogTargetType.setName(CATALOG_TARGET_NAME);
        catalogTargetType.setTypeName(DeployedImplementationType.CSV_FILE.getAssociatedTypeName());
        catalogTargetType.setDeployedImplementationType(DeployedImplementationType.CSV_FILE.getDeployedImplementationType());

        super.catalogTargets.add(catalogTargetType);
    }
}
