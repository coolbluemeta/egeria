<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the ODPi Egeria project. -->

# The Basic Files Integration Connectors

The basic files integration connectors monitor changes in a file directory (folder) and updates the open metadata
repository/repositories to reflect the changes to both the files and folders underneath it.

## Data Files Monitor Integration Connector

The **DataFilesMonitorIntegrationConnector** maintains a DataFile asset for each file in the directory (or any subdirectory).
When a new file is created, a new DataFile asset is created.  If a file is modified, the lastModified property
of the corresponding DataFile asset is updated.  When a file is deleted, its corresponding DataFile asset is also deleted.

Specifically:

- A [`DataFile`](https://egeria-project.org/types/2/0220-files-and-folders/#datafile) asset is created and then maintained for each file in the folder (or any sub-folder).
- When a new file is created, a new `DataFile` asset is created.
- If a file is modified, the `lastModified` property of the corresponding `DataFile` asset is updated.
- When a file is deleted, its corresponding `DataFile` asset is either:
    - Archived: this means the asset is no longer returned on standard asset catalog searches, but it is still visible in [lineage graphs](https://egeria-project.org/concepts/lineage). This is the default behavior.
    - Deleted: this means that all metadata associated with the data file is removed. Only use this option if lineage is not important for these file.
- A [`FileFolder`](https://egeria-project.org/types/2/0220-files-and-folders) metadata asset for the monitored folder is created when the first file is catalogued, if it does not already exist.

### Configuration

![Figure 1](docs/data-files-monitor-integration-connector.png)
> **Figure 1:** Operation of the data files monitor integration connector

This connector runs in the [integration daemon](https://egeria-project.org/concepts/integration-daemon).

Following is its connection definition to use on the [administration commands that configure the integration daemon](https://egeria-project.org/guides/admin/servers/by-server-type/configuring-an-integration-daemon):

```json linenums="1" hl_lines="13 16-18"
{
  "connection": 
  {
    "class": "Connection",
    "connectorType": 
    {
      "class": "ConnectorType",
      "connectorProviderClassName": "org.odpi.openmetadata.adapters.connectors.integration.basicfiles.DataFilesMonitorIntegrationProvider"
    },
    "endpoint": 
    {
      "class": "Endpoint",
      "address": "{{folderName}}"
    },
    "configurationProperties": 
    {
      "templateQualifiedName": "{{templateQualifiedName}}",
      "allowCatalogDelete": ""         
    }
  }
}
```

- Replace `{{folderName}}` with the path name of the folder where the files will be located.
- The `configurationProperties` are optional and are used to override the connector's default behavior:
    - If `templateQualifiedName` is present in the configuration properties then `{{templateQualifiedName}}` must be set to the qualified name of a [`DataFile`](https://egeria-project.org/types/2/0220-Files-and-Folders/#datafile) metadata element that should be used as a template for the catalog entry for new files discovered by this connector. The base properties, schema, connection, classifications and any other attachments connected to the template are copied to the new metadata element for the file. (See [templated cataloging](https://egeria-project.org/features/templated-cataloging) for more information on the use of templates.)
    - If `allowCatalogDelete` is present in the configuration properties then the metadata element for a file is deleted when the file is deleted. If this property is not in the configuration properties, then the metadata element is archived (by adding the [Memento](https://egeria-project.org/types/0/0010-Base-Model/#memento) classification to its entry). The archived element is no longer returned in standard catalog queries, but it is still visible in [lineage](https://egeria-project.org/concepts/lineage). Do not set `allowCatalogDelete` if lineage of these files is important.

## Data Folder Monitor Integration Connector


The **DataFolderMonitorIntegrationConnector** maintains a DataFolder asset for the directory.  The files and directories
underneath it are assumed to be elements/records in the DataFolder asset and so each time there is a change to the
files and directories under the monitored directory, it results in an update to the lastModified property
of the corresponding DataFolder asset.


## Configuration

![figure 1](docs/data-folder-monitor-integration-connector.png)
> **Figure 1:** Operation of the data folder monitor integration connector

This connector runs in the [integration daemon](https://egeria-project.org/concepts/integration-daemon).

Following is its connection definition to use on the [administration commands that configure the integration daemon](https://egeria-project.org/guides/admin/servers/by-server-type/configuring-an-integration-daemon):

```json linenums="1" hl_lines="13"
{
  "connection": 
  {
    "class": "Connection",
    "connectorType": 
    {
      "class": "ConnectorType",
      "connectorProviderClassName": "org.odpi.openmetadata.adapters.connectors.integration.basicfiles.DataFolderMonitorIntegrationProvider"
    },
    "endpoint": 
    {
      "class": "Endpoint",
      "address": "{{folderName}}"
    }
  }
}
```

Replace `{{folderName}}` with the path name of the folder to monitor.

## Deployment and configuration

The basic files integration connectors are included in the main Egeria assembly.
They run in the [Integration Daemon](https://egeria-project.org/concepts/integration-daemon).


----
* Return to [Integration Connectors module](..)

----
License: [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/),
Copyright Contributors to the ODPi Egeria project.