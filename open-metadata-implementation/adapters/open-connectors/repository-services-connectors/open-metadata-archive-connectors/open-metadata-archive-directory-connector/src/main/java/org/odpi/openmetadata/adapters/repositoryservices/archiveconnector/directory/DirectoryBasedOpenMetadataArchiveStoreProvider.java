/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.repositoryservices.archiveconnector.directory;


import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.repositoryservices.connectors.stores.archivestore.OpenMetadataArchiveStoreProviderBase;

import java.util.Collections;

/**
 * DirectoryBasedOpenMetadataArchiveStoreProvider is the OCF connector provider for the file based server configuration store.
 */
public class DirectoryBasedOpenMetadataArchiveStoreProvider extends OpenMetadataArchiveStoreProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName = "org.odpi.openmetadata.adapters.repositoryservices.archiveconnector.directory.DirectoryBasedOpenMetadataArchiveStoreConnector";

    /*
     * Names of configuration properties
     */
    public  static final String KEEP_VERSION_HISTORY_PROPERTY = "keepVersionHistory";


    /**
     * Constructor to initialize the ConnectorProviderBase class.
     */
    public DirectoryBasedOpenMetadataArchiveStoreProvider()
    {
        super(EgeriaOpenConnectorDefinition.DIRECTORY_OPEN_METADATA_ARCHIVE_CONNECTOR,
              connectorClassName,
              Collections.singletonList(KEEP_VERSION_HISTORY_PROPERTY));
    }
}
