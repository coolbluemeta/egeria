/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.repositoryservices.archiveconnector.file;


import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.repositoryservices.connectors.stores.archivestore.OpenMetadataArchiveStoreProviderBase;


/**
 * FileBasedOpenMetadataArchiveStoreProvider is the OCF connector provider for the file based server configuration store.
 */
public class FileBasedOpenMetadataArchiveStoreProvider extends OpenMetadataArchiveStoreProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName = "org.odpi.openmetadata.adapters.repositoryservices.archiveconnector.file.FileBasedOpenMetadataArchiveStoreConnector";

    /**
     * Constructor to initialize the ConnectorProviderBase class.
     */
    public FileBasedOpenMetadataArchiveStoreProvider()
    {
        super(EgeriaOpenConnectorDefinition.JSON_FILE_OPEN_METADATA_ARCHIVE_CONNECTOR,
              connectorClassName,
              null);
    }
}
