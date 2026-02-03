/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors;

import org.odpi.openmetadata.adapters.connectors.controls.EgeriaDeployedImplementationType;
import org.odpi.openmetadata.frameworks.openmetadata.definitions.SolutionComponentDefinition;
import org.odpi.openmetadata.frameworks.openmetadata.definitions.SolutionComponentWireDefinition;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;

import java.util.List;

/**
 * Define the linkage between solution components defined for the Egeria runtime.
 */
public enum EgeriaSolutionComponentWire implements SolutionComponentWireDefinition
{
    AIRFLOW_POSTGRES(DeployedImplementationType.APACHE_AIRFLOW_SERVER.getSolutionComponent(),
                     EgeriaSolutionComponent.WORKSPACES_POSTGRES_SERVER,
                         "stores data",
                         "Apache Airflow stores job definitions and its operational data on PostgreSQL."),

    AIRFLOW_POSTGRES_DB(DeployedImplementationType.APACHE_AIRFLOW_SERVER.getSolutionComponent(),
                     EgeriaSolutionComponent.AIRFLOW_POSTGRESQL_DATABASE,
                     "stores data",
                     "Apache Airflow stores job definitions and its operational data on PostgreSQL."),

    SUPERSET_POSTGRES(DeployedImplementationType.APACHE_SUPERSET.getSolutionComponent(),
                     EgeriaSolutionComponent.WORKSPACES_POSTGRES_SERVER,
                     "stores data",
                     "Apache Superset stores database queries and report designs on PostgreSQL."),

    SUPERSET_POSTGRES_DB(DeployedImplementationType.APACHE_SUPERSET.getSolutionComponent(),
                      EgeriaSolutionComponent.SUPERSET_POSTGRESQL_DATABASE,
                      "stores data",
                      "Apache Superset stores database queries and report designs on PostgreSQL."),

    UC_POSTGRES(EgeriaSolutionComponent.RDBMS_UNITY_CATALOG,
                      EgeriaSolutionComponent.WORKSPACES_POSTGRES_SERVER,
                      "stores data",
                      "Unity catalog can be configured to store its metadata catalog in PostgreSQL."),

    UC_POSTGRES_DB(EgeriaSolutionComponent.RDBMS_UNITY_CATALOG,
                         EgeriaSolutionComponent.UC_POSTGRESQL_DATABASE,
                         "stores data",
                         "Unity catalog can be configured to store its metadata catalog in PostgreSQL."),

    MARQUEZ_POSTGRES(DeployedImplementationType.MARQUEZ_SERVER.getSolutionComponent(),
                EgeriaSolutionComponent.WORKSPACES_POSTGRES_SERVER,
                "stores data",
                "Marquez stores its metadata catalog in PostgreSQL."),

    MARQUEZ_POSTGRES_DB(DeployedImplementationType.MARQUEZ_SERVER.getSolutionComponent(),
                   EgeriaSolutionComponent.MARQUEZ_POSTGRESQL_DATABASE,
                   "stores data",
                   "Marquez stores its metadata catalog in PostgreSQL."),

    EGERIA_POSTGRES(EgeriaDeployedImplementationType.OMAG_SERVER_PLATFORM.getSolutionComponent(),
                    EgeriaSolutionComponent.WORKSPACES_POSTGRES_SERVER,
                    "stores data",
                    "Egeria has multiple options for storing both metadata and operational data on PostgreSQL."),

    EGERIA_KAFKA(EgeriaDeployedImplementationType.OMAG_SERVER_PLATFORM.getSolutionComponent(),
                 EgeriaSolutionComponent.APACHE_KAFKA,
                 "exchanges notifications",
                 "Egeria uses Apache Kafka to both send and receive notifications."),

    METADATA_ACCESS_STORE_REPOSITORY(EgeriaDeployedImplementationType.METADATA_ACCESS_STORE.getSolutionComponent(),
                                     DeployedImplementationType.OPEN_METADATA_REPOSITORY.getSolutionComponent(),
                                     "stores data",
                                     "A metadata access store stores its metadata in a metadata repository."),

    METADATA_ACCESS_STORE_OM_EVENTS(EgeriaDeployedImplementationType.METADATA_ACCESS_STORE.getSolutionComponent(),
                                 EgeriaSolutionComponent.OPEN_METADATA_TOPIC,
                                 "metadata change notifications",
                                 "A metadata access store sends a kafka event each time a metadata element, relationship, or classification changes."),

    INTEGRATION_DAEMON_OM_EVENTS(EgeriaSolutionComponent.OPEN_METADATA_TOPIC,
                                 EgeriaDeployedImplementationType.INTEGRATION_DAEMON.getSolutionComponent(),
                                 "metadata change notifications",
                                 "An integration connector uses open metadata events to monitor changing metadata."),

    ENGINE_HOST_OM_EVENTS(EgeriaSolutionComponent.OPEN_METADATA_TOPIC,
                              EgeriaDeployedImplementationType.ENGINE_HOST.getSolutionComponent(),
                              "metadata change notifications",
                              "A governance service uses open metadata events to monitor changing metadata."),


    METADATA_ACCESS_STORE_OG_EVENTS(EgeriaDeployedImplementationType.METADATA_ACCESS_STORE.getSolutionComponent(),
                                    EgeriaSolutionComponent.OPEN_GOVERNANCE_TOPIC,
                                    "open governance notifications",
                                    "A metadata access store sends a kafka event each time a governance engine, governance service, integration group, integration connector or engine action changes."),

    INTEGRATION_DAEMON_OG_EVENTS(EgeriaSolutionComponent.OPEN_GOVERNANCE_TOPIC,
                                 EgeriaDeployedImplementationType.INTEGRATION_DAEMON.getSolutionComponent(),
                                 "configuration change notifications",
                                 "An integration daemon uses open governance events to maintain its configuration.  It listens for new connectors and catalog targets being added to its integration groups to ensure it is running all the requested connectors."),

    ENGINE_HOST_OG_EVENTS(EgeriaSolutionComponent.OPEN_GOVERNANCE_TOPIC,
                          EgeriaDeployedImplementationType.ENGINE_HOST.getSolutionComponent(),
                          "configuration change and engine action notifications",
                          "An engine host uses open governance events to maintain its configuration and detect if there are new engine actions to run."),

    ENGINE_HOST_METADATA(EgeriaDeployedImplementationType.ENGINE_HOST.getSolutionComponent(),
                         EgeriaDeployedImplementationType.METADATA_ACCESS_STORE.getSolutionComponent(),
                         "access metadata",
                         "The engine host accesses details of the governance engines and their services to build out its configuration.  When a governance service runs, it accesses the metadata to work on from the metadata access store as well."),

    INTEGRATION_DAEMON_METADATA(EgeriaDeployedImplementationType.INTEGRATION_DAEMON.getSolutionComponent(),
                                EgeriaDeployedImplementationType.METADATA_ACCESS_STORE.getSolutionComponent(),
                                "access metadata",
                                "The integration daemon accesses details of the integration groups and their connectors to build out its configuration.  When an integration connectors runs, it accesses the metadata to work on from the metadata access store as well."),

    VIEW_SERVER_METADATA(EgeriaDeployedImplementationType.VIEW_SERVER.getSolutionComponent(),
                         EgeriaDeployedImplementationType.METADATA_ACCESS_STORE.getSolutionComponent(),
                         "access metadata",
                         "The view service accesses metadata on behalf of its REST API callers."),

    NOTEBOOK_TO_PYEGERIA(DeployedImplementationType.JUPYTER_NOTEBOOK.getSolutionComponent(),
                         DeployedImplementationType.PYEGERIA.getSolutionComponent(),
                         "access metadata",
                         "Jupyter notebooks are able to execute python code, which includes calls to the pyegeria library."),

    PYEGERIA_TO_VIEW_SERVER(DeployedImplementationType.PYEGERIA.getSolutionComponent(),
                            EgeriaDeployedImplementationType.VIEW_SERVER.getSolutionComponent(),
                            "access metadata",
                            "The pyegeria library provides a python interface to the view service REST APIs."),

    HEY_EGERIA_TO_VIEW_SERVER(EgeriaSolutionComponent.HEY_EGERIA,
                            EgeriaDeployedImplementationType.VIEW_SERVER.getSolutionComponent(),
                            "access metadata",
                            "The hey_egeria command line tool uses its embedded pyegeria library to call the view service REST APIs."),

    DR_EGERIA_TO_VIEW_SERVER(EgeriaSolutionComponent.DR_EGERIA,
                              EgeriaDeployedImplementationType.VIEW_SERVER.getSolutionComponent(),
                              "access metadata",
                              "The Dr.Egeria markdown processor uses its embedded pyegeria library to call the view service REST APIs."),

    DR_EGERIA_TO_MARKDOWN_REPORT(EgeriaSolutionComponent.DR_EGERIA,
                                 DeployedImplementationType.MARKDOWN_DOCUMENT.getSolutionComponent(),
                                 "writes",
                                 "The Dr.Egeria markdown processor is able to create markdown forms and reports based on information received from Egeria."),

    DR_EGERIA_TO_HTML_WEBPAGE(EgeriaSolutionComponent.DR_EGERIA,
                                 DeployedImplementationType.WEBPAGE.getSolutionComponent(),
                                 "writes",
                                 "The Dr.Egeria is able to create HTML web page reports based on information received from Egeria."),

    MARKDOWN_TO_DR_EGERIA(DeployedImplementationType.MARKDOWN_DOCUMENT.getSolutionComponent(),
                          EgeriaSolutionComponent.DR_EGERIA,
                          "read",
                          "The Dr.Egeria markdown processor is able to read markdown documents and turn them into calls to Egeria."),

    HTML_TO_WEB_SERVER(DeployedImplementationType.WEBPAGE.getSolutionComponent(),
                       EgeriaSolutionComponent.APACHE_WEB_SERVER,
                       "read",
                       "The Apache Web Server is able to display HTML Web Pages in the browser."),

    MY_EGERIA_TO_VIEW_SERVER(EgeriaSolutionComponent.MY_EGERIA,
                             EgeriaDeployedImplementationType.VIEW_SERVER.getSolutionComponent(),
                             "access metadata",
                             "The my_egeria user interface uses its embedded pyegeria library to call the view service REST APIs."),

    PYEGERIA_TO_PLATFORM(DeployedImplementationType.PYEGERIA.getSolutionComponent(),
                         EgeriaDeployedImplementationType.OMAG_SERVER_PLATFORM.getSolutionComponent(),
                         "access metadata",
                         "The pyegeria library provides a python interface to the OMAG Server Platform REST APIs.  This includes server administration and status."),

    AIRFLOW_TO_OL_PROXY(DeployedImplementationType.APACHE_AIRFLOW_SERVER.getSolutionComponent(),
                        EgeriaSolutionComponent.OL_PROXY,
                        "open lineage events",
                        "Apache Airflow has native support for Open Lineage events.  These events are sent to the Open Lineage Proxy for distribution."),

    OL_PROXY_TO_KAFKA(EgeriaSolutionComponent.OL_PROXY,
                      EgeriaSolutionComponent.APACHE_KAFKA,
                        "open lineage events",
                        "Open Lineage Events are published to a Kafka Topic"),

    OL_PROXY_TO_KAFKA_TOPIC(EgeriaSolutionComponent.OL_PROXY,
                            EgeriaSolutionComponent.OL_KAFKA_TOPIC,
                            "open lineage events",
                            "Open Lineage Events are published to a Kafka Topic"),

    OL_EVENTS_TO_ID(EgeriaSolutionComponent.OL_KAFKA_TOPIC,
                    EgeriaDeployedImplementationType.INTEGRATION_DAEMON.getSolutionComponent(),
                            "open lineage events",
                            "Open Lineage Events are received by the integration daemon for processing."),

    EGERIA_BUILD_CREATES_ARCHIVE(EgeriaSolutionComponent.EGERIA_BUILD,
                                 DeployedImplementationType.OPEN_METADATA_ARCHIVE.getSolutionComponent(),
                                 "constructs",
                                 "The Egeria build constructs the open metadata archives."),

    EGERIA_BUILD_CREATES_PLATFORM(EgeriaSolutionComponent.EGERIA_BUILD,
                                  EgeriaDeployedImplementationType.OMAG_SERVER_PLATFORM.getSolutionComponent(),
                                 "assembles",
                                 "The Egeria build complies the code for the OMAG Server Platform and assembles it, with the resources it needs to run."),

    LOAD_ARCHIVE_READS_ARCHIVE(EgeriaSolutionComponent.LOAD_ARCHIVE,
                               DeployedImplementationType.OPEN_METADATA_ARCHIVE.getSolutionComponent(),
                               "reads",
                               "The load archive command reads the archive."),

    LOAD_ARCHIVE_FILLS_REPO(EgeriaSolutionComponent.LOAD_ARCHIVE,
                            DeployedImplementationType.OPEN_METADATA_REPOSITORY.getSolutionComponent(),
                            "load",
                            "The load archive command pushes the archive content into the selected open metadata repository."),

    ;

    final SolutionComponentDefinition component1;
    final SolutionComponentDefinition component2;
    final String                      label;
    final String                      description;

    EgeriaSolutionComponentWire(SolutionComponentDefinition component1,
                                SolutionComponentDefinition component2,
                                String                      label,
                                String                      description)
    {
        this.component1              = component1;
        this.component2              = component2;
        this.label                   = label;
        this.description             = description;
    }


    /**
     * Return the component for end 1
     *
     * @return component definition
     */
    @Override
    public SolutionComponentDefinition getComponent1()
    {
        return component1;
    }


    /**
     * Return the component for end 2
     *
     * @return component definition
     */
    @Override
    public SolutionComponentDefinition getComponent2()
    {
        return component2;
    }


    /**
     * Return the relationship label.
     *
     * @return string
     */
    @Override
    public String getLabel()
    {
        return label;
    }


    /**
     * Return the relationship description.
     *
     * @return string
     */
    @Override
    public String getDescription()
    {
        return description;
    }


    /**
     * Return the list of ISC qualified names that the wire belongs to.
     *
     * @return list of strings
     */
    @Override
    public List<String> getISCQualifiedNames()
    {
        return null;
    }


    /**
     * Output of this enum class and main value.
     *
     * @return string showing enum value
     */
    @Override
    public String toString()
    {
        return "SolutionComponentWire{" +
                "component1=" + component1 +
                ", component2=" + component2 +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", ISCQualifiedNames=" + getISCQualifiedNames() +
                "} " + super.toString();
    }
}
