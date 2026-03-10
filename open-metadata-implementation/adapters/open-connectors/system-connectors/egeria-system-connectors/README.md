<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the Egeria project. -->

# Egeria System Connectors

The connectors in this module are used to work with Egeria.


## Egeria Platform Cataloguing Integration Connector

he *Egeria Platform Cataloguing Connector* is a *Infrastructure Integration Connector* that creates a metadata representation of an OMAG Server Platform.


![Figure 1](docs/egeria-infrastructure-cataloguer-integration-connector.png)
> **Figure 1:** Operation of the Egeria infrastructure cataloguer integration connector

The connector listens for the cataloguing of `SoftwareServerPlatform` entities that have the `deployedImplementationType` property set to`OMAG Server Platform`.  The aim of the connector is to extract as much information about the platform as possible and add this detail to the catalog. It needs the URL of the platform and this is obtained by following the `ServerEndpoint` relationship to extract the network address from the linked endpoint.  If the endpoint is not attached it tries again on the next refresh call.

![Figure 2](docs/egeria-infrastructure-cataloguer-integration-connector-trigger.png)
> **Figure 2:** Locating the platform

Once the endpoint is located, the `platformVersion` property of the software server platform entity is updated with the [*platform origin*](https://egeria-project.org/services/platform-services/overview/#platform-origin) extracted from the platform.  This proves that the endpoint is actually pointing to an OMAG Server Platform.

Next, a request for [all of the configured servers](https://egeria-project.org/services/admin-services/overview/#managing-configuration-documents) that the platform knows about is made.  This returns the [configuration documents](https://egeria-project.org/concepts/configuration-document) for these servers and the contents are examined to catalog the OMAG servers as `SoftwareServer` entities.

The platform is called to return the [*known servers*](https://egeria-project.org/services/platform-services/overview/#known-servers).  These are servers that have run on the platform.  For each of these, the connector adds the `DeployedOn` relationship between the `SoftwareServer` entity and the `SoftwareServerPlatform` entity.

The platform is called again for the [active server status](https://egeria-project.org/services/admin-services/overview/#querying-the active-server-status).  This returns the type of server which is used to set up the appropriate `ServerPurpose` classification:

* `MetadataServer` for [Metadata Access Servers](https://egeria-project.org/concepts/metadata-access-server).
* `GovernanceDeamon` for [Engine Hosts](https://egeria-project.org/concepts/engine-host).
* `IntegrationServer` for [Integration Daemons](https://egeria-project.org/concepts/metadata-access-server).
* `RepositoryProxy` for [Repository Proxies](https://egeria-project.org/concepts/repository-proxy).


![Figure 3](docs/egeria-infrastructure-cataloguer-integration-connector-servers.png)
> **Figure 3:** Extracting OMAG server configuration

The details of each configured OMAG server is used to create appropriate `SoftwareService` entities linked by `SupportedSoftwareCapability` relationships to the server's `SoftwareServer` entity.  Most OMAG services manage one or more connectors and these are represented using `DeployedConnector` entities linked by `ServerAssetUse` relationships.

If the API for the platform is catalogued, the connector uses the service name in the urls to link the individual operations to the appropriate software service using the `ProcessCall` relationship.  The service url marker used to match the API operations is extracted by requesting the [*registered services*](https://egeria-project.org/services/platform-services/overview/#registered-services) from the platform.

![Figure 4](docs/egeria-infrastructure-cataloguer-integration-connector-software-services.png)
> **Figure 4:** Adding the configured services

The connection information is catalogued for each of the deployed connectors and where the connector type is recognized, additional assets (such as Apache Kafka topics) may be created/linked to the deployed connectors.

![Figure 5](docs/egeria-infrastructure-cataloguer-integration-connector-deployed-connector.png)
> **Figure 5:** Adding the connections for the deployed connectors

This processing occurs each time the refresh method is called, and the connector catalogs as much as is possible given the status of the environment on each iteration.

### Configuration

This connector runs in the [Integration Daemon](https://egeria-project.org/concepts/integration-daemon).

This is its connection definition to use on the [administration commands that configure the integration daemon](https://egeria-project.org/guides/admin/servers/by-server-type/configuring-an-integration-daemons).

```json linenums="1"
{
   "connection" : 
                { 
                    "class" : "Connection",
                    "qualifiedName" : "TopicMonitorConnection",
                    "connectorType" : 
                    {
                        "class" : "ConnectorType",
                        "connectorProviderClassName" : "org.odpi.openmetadata.devprojects.connectors.integration.egeria.EgeriaInfrastructureIntegrationProvider"
                    }
                }
}
```


----
* Return to [System Connectors](..)

----
License: [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/),
Copyright Contributors to the Egeria project.