/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adminservices.configuration.registration;

import org.odpi.openmetadata.frameworks.auditlog.ComponentDevelopmentStatus;


/**
 * ViewServiceDescription provides a list of registered view services.
 */
public enum ViewServiceDescription
{

    /**
     * View glossary terms and categories within a glossary.
     */
    GLOSSARY_BROWSER(805,
                     ComponentDevelopmentStatus.STABLE,
                     "Glossary Browser",
                     "Glossary Browser OMVS",
                     "glossary-browser",
                     "View glossary terms and categories within a glossary.",
                     "https://egeria-project.org/services/omvs/glossary-browser/overview/",
                     AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Create glossary terms and organize them into categories as part of a controlled workflow process. It supports the editing glossary and multiple states.
     */
    GLOSSARY_MANAGER(806,
                     ComponentDevelopmentStatus.STABLE,
                     "Glossary Manager",
                     "Glossary Manager OMVS",
                     "glossary-manager",
                     "Create glossary terms and organize them into categories as part of a controlled workflow process. It supports the editing glossary and multiple states.",
                     "https://egeria-project.org/services/omvs/glossary-manager/overview/",
                     AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Manage information about the logged on user as well as their preferences.
     */
    MY_PROFILE(807,
               ComponentDevelopmentStatus.STABLE,
               "My Profile",
               "My Profile OMVS",
               "my-profile",
               "Manage information about the logged on user as well as their preferences.",
               "https://egeria-project.org/services/omvs/my-profile/overview/",
               AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Search and understand your assets.
     */
    ASSET_CATALOG (808,
                   ComponentDevelopmentStatus.STABLE,
                   "Asset Catalog",
                   "Asset Catalog OMVS",
                   "asset-catalog",
                   "Search and understand your assets.",
                   "https://egeria-project.org/services/omvs/asset-catalog/overview/",
                   AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Build collections of asset and other metadata.
     */
    COLLECTION_MANAGER  (809,
                         ComponentDevelopmentStatus.STABLE,
                         "Collection Manager",
                         "Collection Manager OMVS",
                         "collection-manager",
                         "Build collections of asset and other metadata.",
                         "https://egeria-project.org/services/omvs/collection-manager/overview/",
                         AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Manage Egeria's automation services.
     */
    AUTOMATED_CURATION  (810,
                         ComponentDevelopmentStatus.STABLE,
                         "Automated Curation",
                         "Automated Curation OMVS",
                         "automated-curation",
                         "Manage Egeria's automation services.",
                         "https://egeria-project.org/services/omvs/automated-curation/overview/",
                         AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Work with notelogs, comments, informal tags, ratings/reviews and likes.
     */
    FEEDBACK_MANAGER  (811,
                         ComponentDevelopmentStatus.STABLE,
                         "Feedback Manager",
                         "Feedback Manager OMVS",
                         "feedback-manager",
                         "Work with note logs, comments, informal tags, ratings/reviews and likes.",
                         "https://egeria-project.org/services/omvs/feedback-manager/overview/",
                       AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Maintain definitions of governance actions such as governance action processes and governance action types.
     */
    ACTION_AUTHOR(812,
                  ComponentDevelopmentStatus.STABLE,
                  "Action Author",
                  "Action Author OMVS",
                  "action-author",
                  "Maintain definitions of governance actions such as governance action processes and governance action types.",
                  "https://egeria-project.org/services/omvs/action-author/overview/",
                  AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Set up and manage projects.
     */
    PROJECT_MANAGER  (813,
                         ComponentDevelopmentStatus.STABLE,
                         "Project Manager",
                         "Project Manager OMVS",
                         "project-manager",
                         "Set up and manage projects.",
                         "https://egeria-project.org/services/omvs/project-manager/overview/",
                      AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),


    /**
     * Define and search for new data resources.
     */
    DATA_DISCOVERY  (814,
                      ComponentDevelopmentStatus.IN_DEVELOPMENT,
                      "Data Discovery",
                      "Data Discovery OMVS",
                      "data-discovery",
                      "Define and search for new data resources.",
                      "https://egeria-project.org/services/omvs/data-discovery/overview/",
                     AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Retrieve and refine the templates for use during cataloguing.
     */
    TEMPLATE_MANAGER  (815,
                     ComponentDevelopmentStatus.STABLE,
                     "Template Manager",
                     "Template Manager OMVS",
                     "template-manager",
                     "Retrieve and refine the templates for use during cataloguing.",
                     "https://egeria-project.org/services/omvs/template-manager/overview/",
                       AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Work with code tables and associated reference data.
     */
    REFERENCE_DATA  (816,
                       ComponentDevelopmentStatus.IN_DEVELOPMENT,
                       "Reference Data",
                       "Reference Data OMVS",
                       "reference-data",
                       "Work with code tables and associated reference data.",
                       "https://egeria-project.org/services/omvs/reference-data/overview/",
                     AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Maintain and query valid values for metadata.
     */
    VALID_METADATA (817,
                     ComponentDevelopmentStatus.STABLE,
                     "Valid Metadata",
                     "Valid Metadata OMVS",
                     "valid-metadata",
                     "Maintain and query valid values for metadata.",
                     "https://egeria-project.org/services/omvs/valid-metadata/overview/",
                    AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Maintain classifications and relationships used to organize open metadata elements.
     */
    CLASSIFICATION_MANAGER (818,
                            ComponentDevelopmentStatus.STABLE,
                            "Classification Manager",
                            "Classification Manager OMVS",
                            "classification-manager",
                            "Maintain classifications and relationships used to organize open metadata elements.",
                            "https://egeria-project.org/services/omvs/classification-manager/overview/",
                            AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Manage the metadata about the assets managed by a DevOps pipeline.
     */
    DEVOPS_PIPELINE (819,
                     ComponentDevelopmentStatus.IN_DEVELOPMENT,
                     "DevOps Pipeline",
                     "DevOps Pipeline OMVS",
                     "devops-pipeline",
                     "Maintain the metadata about the assets managed by a devops pipeline.",
                     "https://egeria-project.org/services/omvs/devops-pipeline/overview/",
                     AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),


    /**
     * Set up and review rules and security tags to protect data and systems.
     */
    SECURITY_OFFICER (820,
                      ComponentDevelopmentStatus.IN_DEVELOPMENT,
                      "Security Officer",
                      "Security Officer OMVS",
                      "security-officer",
                      "Set up and review rules and security tags to protect data and systems.",
                      "https://egeria-project.org/services/omvs/security-officer/overview/",
                      AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),


    /**
     * Manage governance of privacy.
     */
    PRIVACY_OFFICER (821,
                     ComponentDevelopmentStatus.IN_DEVELOPMENT,
                     "Privacy Officer",
                     "Privacy Officer OMVS",
                     "privacy-officer",
                     "Manage the governance of privacy.",
                     "https://egeria-project.org/services/omvs/privacy-officer/overview/",
                     AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Manage governance of data.
     */
    DATA_OFFICER (822,
                  ComponentDevelopmentStatus.IN_DEVELOPMENT,
                  "Data Officer",
                  "Data Officer OMVS",
                  "data-officer",
                  "Manage the governance of data.",
                  "https://egeria-project.org/services/omvs/data-officer/overview/",
                  AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Describe teams and organizational structure.
     */
    PEOPLE_ORGANIZER (823,
                  ComponentDevelopmentStatus.IN_DEVELOPMENT,
                  "People Organizer",
                  "People Organizer OMVS",
                  "people-organizer",
                  "Describe teams, roles and organizational structure.",
                  "https://egeria-project.org/services/omvs/people-organizer/overview/",
                      AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),


    /**
     * Retrieve configuration and status from platforms and servers.
     */
    RUNTIME_MANAGER (824,
                      ComponentDevelopmentStatus.STABLE,
                      "Runtime Manager",
                      "Runtime Manager OMVS",
                      "runtime-manager",
                      "Retrieve configuration and status from platforms and servers.",
                      "https://egeria-project.org/services/omvs/runtime-manager/overview/",
                     AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Maintain governance definitions used in all governance domains.
     */
    GOVERNANCE_OFFICER (825,
                     ComponentDevelopmentStatus.STABLE,
                     "Governance Officer",
                     "Governance Officer OMVS",
                     "governance-officer",
                     "Maintain governance definitions used to define any governance domain.",
                     "https://egeria-project.org/services/omvs/governance-officer/overview/",
                        AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Create schema definitions to describe the structure of data.
     */
    DATA_DESIGNER (826,
                   ComponentDevelopmentStatus.STABLE,
                   "Data Designer",
                   "Data Designer OMVS",
                   "data-designer",
                   "Create data specifications to describe data requirements.",
                   "https://egeria-project.org/services/omvs/data-designer/overview/",
                   AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),


    /**
     * Provides generic search, query and retrieval operations for open metadata.
     */
    METADATA_EXPLORER (827,
                   ComponentDevelopmentStatus.STABLE,
                   "Metadata Explorer",
                   "Metadata Explorer OMVS",
                   "metadata-explorer",
                   "Provides generic search, query and retrieval operations for open metadata.",
                   "https://egeria-project.org/services/omvs/metadata-explorer/overview/",
                       AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),


    /**
     * Manages the definitions of notifications.  This includes the definition of the trigger for the notification, the style of notification and the recipient.
     */
    NOTIFICATION_MANAGER (828,
                       ComponentDevelopmentStatus.IN_DEVELOPMENT,
                       "Notification Manager",
                       "Notification Manager OMVS",
                       "notification-manager",
                       "Manages the definitions of notifications.  This includes the definition of the trigger for the notification, the style of notification and the recipient.",
                       "https://egeria-project.org/services/omvs/notification-manager/overview/",
                          AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Manages the definitions of information supply chains and solution components.
     */
    SOLUTION_ARCHITECT (829,
                          ComponentDevelopmentStatus.STABLE,
                          "Solution Architect",
                          "Solution Architect OMVS",
                          "solution-architect",
                          "Manages the definitions of information supply chains and solution components.",
                          "https://egeria-project.org/services/omvs/solution-architect/overview/",
                        AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Retrieve elements based on type or the classifications/relationships attached to these metadata elements.
     */
    CLASSIFICATION_EXPLORER (830,
                            ComponentDevelopmentStatus.STABLE,
                            "Classification Explorer",
                            "Classification Explorer OMVS",
                            "classification-explorer",
                            "Retrieve elements based on type or the classifications/relationships attached to these metadata elements.",
                            "https://egeria-project.org/services/omvs/classification-explorer/overview/",
                             AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Manages context events and other time related behaviour.
     */
    TIME_KEEPER (831,
                             ComponentDevelopmentStatus.IN_DEVELOPMENT,
                             "Time Keeper",
                             "Time Keeper OMVS",
                             "time-keeper",
                             "Manages context events and other time related behaviour.",
                             "https://egeria-project.org/services/omvs/time-keeper/overview/",
                 AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),


    /**
     * Manages the definitions of user identities, actor profiles, contact details and actor roles.
     */
    ACTOR_MANAGER (832,
                 ComponentDevelopmentStatus.STABLE,
                 "Actor Manager",
                 "Actor Manager OMVS",
                 "actor-manager",
                 "Manages the definitions of user identities, actor profiles, contact details and actor roles.",
                 "https://egeria-project.org/services/omvs/actor-manager/overview/",
                   AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Manages the definitions of communities, their leaders and membership.
     */
    COMMUNITY_MATTERS (833,
                   ComponentDevelopmentStatus.IN_DEVELOPMENT,
                   "Community Matters",
                   "Community Matters OMVS",
                   "community-matters",
                   "Manages the definitions of communities, their leaders and membership.",
                   "https://egeria-project.org/services/omvs/community-matters/overview/",
                       AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Manages the definition of subject areas and reporting on their contents.
     */
    SUBJECT_AREA (834,
                       ComponentDevelopmentStatus.IN_DEVELOPMENT,
                       "Subject Area",
                       "Subject Area OMVS",
                       "subject-area",
                       "Manages the definition of subject areas and reporting on their contents.",
                       "https://egeria-project.org/services/omvs/subject-area/overview/",
                  AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    /**
     * Manages the creation and maintenance of connections, connector types and endpoints.
     */
    CONNECTION_MAKER (835,
                      ComponentDevelopmentStatus.IN_DEVELOPMENT,
                      "Connection Maker",
                      "Connection Maker OMVS",
                      "connection-maker",
                      "Manages the creation and maintenance of connections, connector types and endpoints.",
                      "https://egeria-project.org/services/omvs/connection-maker/overview/",
                      AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),


    /**
     * Manages the creation and maintenance of connections, connector types and endpoints.
     */
    SCHEMA_MAKER (836,
                      ComponentDevelopmentStatus.IN_DEVELOPMENT,
                      "Schema Maker",
                      "Schema Maker OMVS",
                      "schema-maker",
                      "Manages the creation and maintenance of schema elements.",
                      "https://egeria-project.org/services/omvs/schema-maker/overview/",
                  AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),


    /**
     * Manages the creation and maintenance of locations.
     */
    LOCATION_ARENA(837,
                   ComponentDevelopmentStatus.IN_DEVELOPMENT,
                   "Location Arena",
                   "Location Arena OMVS",
                   "location-arena",
                   "Manages the creation and maintenance of locations.",
                   "https://egeria-project.org/services/omvs/location-arena/overview/",
                   AccessServiceDescription.OMF_METADATA_MANAGEMENT.getServiceName()),

    ;


    private final int                        viewServiceCode;
    private final ComponentDevelopmentStatus viewServiceDevelopmentStatus;
    private final String                     viewServiceName;
    private final String                     viewServiceFullName;
    private final String                     viewServiceURLMarker;
    private final String                     viewServiceDescription;
    private final String                     viewServiceWiki;
    private final String                     viewServicePartnerService;


    /**
     * Default Constructor
     *
     * @param viewServiceCode        ordinal for this UI view
     * @param viewServiceDevelopmentStatus development status
     * @param viewServiceURLMarker   string used in URLs
     * @param viewServiceName        symbolic name for this UI view
     * @param viewServiceDescription short description for this UI view
     * @param viewServiceWiki        wiki page for the UI view for this UI view
     */
    ViewServiceDescription(int                        viewServiceCode,
                           ComponentDevelopmentStatus viewServiceDevelopmentStatus,
                           String                     viewServiceName,
                           String                     viewServiceFullName,
                           String                     viewServiceURLMarker,
                           String                     viewServiceDescription,
                           String                     viewServiceWiki,
                           String                     viewServicePartnerService)
    {
        /*
         * Save the values supplied
         */
        this.viewServiceCode = viewServiceCode;
        this.viewServiceDevelopmentStatus = viewServiceDevelopmentStatus;
        this.viewServiceName = viewServiceName;
        this.viewServiceFullName = viewServiceFullName;
        this.viewServiceURLMarker = viewServiceURLMarker;
        this.viewServiceDescription = viewServiceDescription;
        this.viewServiceWiki = viewServiceWiki;
        this.viewServicePartnerService = viewServicePartnerService;
    }


    /**
     * Return the code for this enum instance
     *
     * @return int type code
     */
    public int getViewServiceCode() {
        return viewServiceCode;
    }


    /**
     * Return the development status of the component.
     *
     * @return enum describing the status
     */
    public ComponentDevelopmentStatus getViewServiceDevelopmentStatus()
    {
        return viewServiceDevelopmentStatus;
    }


    /**
     * Return the default name for this enum instance.
     *
     * @return String default name
     */
    public String getViewServiceName() {
        return viewServiceName;
    }


    /**
     * Return the formal name for this enum instance.
     *
     * @return String default name
     */
    public String getViewServiceFullName() {
        return viewServiceFullName;
    }

    /**
     * Return the string that appears in the REST API URL that identifies the owning service.
     * Null means no REST APIs supported by this service.
     *
     * @return String default name
     */
    public String getViewServiceURLMarker() {
        return viewServiceURLMarker;
    }

    /**
     * Return the default description for the type for this enum instance.
     *
     * @return String default description
     */
    public String getViewServiceDescription() {
        return viewServiceDescription;
    }


    /**
     * Return the URL for the wiki page describing this UI view.
     *
     * @return String URL for the wiki page
     */
    public String getViewServiceWiki() {
        return viewServiceWiki;
    }


    /**
     * Return the description of the service that this view service is partnered with.
     *
     * @return  Full name of related service
     */
    public String getViewServicePartnerService()
    {
        return viewServicePartnerService;
    }
}
