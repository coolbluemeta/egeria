/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.connectors.integration.openlineage;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.integration.connectors.IntegrationConnectorProvider;


/**
 * FileBasedOpenLineageLogStoreProvider is the OCF connector provider for the file-based open lineage log store.
 */
public class FileBasedOpenLineageLogStoreProvider extends IntegrationConnectorProvider
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName = "org.odpi.openmetadata.adapters.connectors.integration.openlineage.FileBasedOpenLineageLogStoreConnector";

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * audit log store implementation.
     */
    public FileBasedOpenLineageLogStoreProvider()
    {
        super(EgeriaOpenConnectorDefinition.FILE_BASED_OPEN_LINEAGE_LOG_STORE,
              connectorClassName,
              null);
    }
}
