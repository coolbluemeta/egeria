<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the ODPi Egeria project. -->

# JDBC Resource Connector

The JDBC Resource Connector provides a DataSource, which in turn is used to get a connection to underlying database.  It provides access to both the schema metadata and the business data content.

![Figure 1](docs/jdbc-resource-connector.png)
> **Figure 1:** JDBC resource connector


## Configuration

The connector is initialized using the connection information attached to the [RelationalDatabase](https://egeria-project.org/types/2/0224-Databases) asset in the open metadata ecosystem.

![Figure 2](docs/jdbc-resource-connector-use.png)
> **Figure 2:** Connection information used to create an instance of the JDBC resource connector

The optional configuration properties supported by this connector are:

* `jdbcDriverManagerClassName` - requests the named class to be loaded and registered as a driver. This property only needs to be defined if the connector is experiencing exceptions related to a missing DriverManager class for the database URL.
* `jdbcConnectionTimeout` - sets the maximum time in seconds that this data source will wait while attempting to connect to a database. The default value is 0 which means use the system default timeout, if any; otherwise it means no timeout.
* `jdbcDatabaseName` - provides a name to use in messages about the database.  If it is not set then the connection URL string is used.

Below is an example connection for a PostgreSQL database:

```json
{
    "class": "Connection",
    "connectorType": {
      "class": "ConnectorType",
      "connectorProviderClassName": "org.odpi.openmetadata.adapters.connectors.resource.jdbc.JDBCResourceConnectorProvider"
    },
    "endpoint": {
      "class": "Endpoint",
      "address": "jdbc:postgresql://localhost:5432/myDatabase"
    },
    "userId": "xxxxx",
    "clearPassword": "xxxx",
    "configurationProperties": {
      "jdbcDriverManagerClassName": "org.postgresql.Driver",
      "jdbcConnectionTimeout": "10",
      "jdbcDatabaseName": "MyDatabase"
    }
}
```

## Implementation

The JDBC Resource Connector is implemented in the JDBCResourceConnector class.
It provides a basic implementation of the interface javax.sql.DataSource interface to establish a connection to a target database. Because of a method clash, the interface has been implemented as an inner class of the connector and to get the implementation, one must call: 
```
jdbcConnector.asDataSource()
```

Its Jar file includes the PostgreSQL client driver.

