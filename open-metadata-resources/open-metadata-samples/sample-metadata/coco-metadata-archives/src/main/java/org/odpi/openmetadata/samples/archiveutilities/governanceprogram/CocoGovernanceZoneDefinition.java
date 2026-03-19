/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.samples.archiveutilities.governanceprogram;


/**
 * The CocoGovernanceZoneDefinition is used to feed the definition of the governance zones for
 * Coco Pharmaceuticals.
 */
public enum CocoGovernanceZoneDefinition
{
    /**
     * quarantine
     */
    QUARANTINE( "quarantine",
                "Quarantine Zone",
                "Resources from third parties that are being evaluated by the onboarding team. " +
                        "The assets will move into the other zones once the asset has been catalogued and classified.",
                "Data sets just received and have not yet been properly catalogued."),

    /**
     * landing-area
     */
    LANDING_AREA( "landing-area",
                "Landing Area Zone",
                "Denotes resources from third parties in their initial form. " +
                        "These resources will be copied and augmented by various onboarding processes.",
                "Original data sets received from third parties that have not been moved or transformed."),

    /**
     * data-lake
     */
    DATA_LAKE( "data-lake",
                "Data Lake Zone",
                "Resources for sharing that are read only.",
                "These are production assets that can be used for business decisions."),

    /**
     * research
     */
    RESEARCH( "research",
                "Research Zone",
                "Research data sets and findings",
                "Resources that are driving the development of new products and techniques."),

    /**
     * clinical-trials
     */
    CLINICAL_TRIALS( "clinical-trials",
                "Clinical Trials Zone",
                "Patient data, protocols, outcomes and analysis used within a clinical trial." +
                             "This data is highly confidential and has restricted access.  It is also subject " +
                             "to the data management requirements of the regulators.",
                "Assets supporting the clinical trials."),

    /**
     * human-resources
     */
    HUMAN_RESOURCES( "human-resources",
                "Human Resources (Personnel) Zone",
                "Resources used to manage and support employees of Coco Pharmaceuticals.",
                "Assets controlled by the HR and management teams."),

    /**
     * finance
     */
    FINANCE( "finance",
                "Finance Zone",
                "Resources that support the financial management of Coco Pharmaceuticals.",
                "Resources controlled by the finance team."),

    /**
     * infrastructure
     */
    INFRASTRUCTURE("infrastructure",
                "IT Infrastructure Zone",
                "Resources that describe the IT infrastructure such as hosts, servers, applications, " +
                            "databases and network infrastructure descriptions.",
                "Resources controlled by the IT Infrastructure team."),

    /**
     * development
     */
    DEVELOPMENT("it-development",
                "IT Development and DevOps Zone",
                "Software components and assets that support their ongoing development.",
                "Software development and dev-ops resources."),

    /**
     * manufacturing
     */
    MANUFACTURING( "manufacturing",
                "Supply, Manufacturing and Distribution Zone",
                "Suppliers, manufacturing infrastructure, schedules and outputs.",
                "These are the resources that support the production of Coco Pharmaceutical's products."),

    /**
     * sales
     */
    SALES(      "sales",
                "Sales Zone",
                "Customers, sales plans, orders and fulfilment tracking.",
                "Resources supported by the sales teams."),

    /**
     * governance
     */
    GOVERNANCE( "governance",
                "Governance Zone",
                "Governance definitions, monitoring and reporting assets.",
                "Resources that support the governance team"),

    /**
     * sustainability
     */
    SUSTAINABILITY("sustainability",
                   "Sustainability Reporting",
                   "Resources used to build reports that illustrate the status of Coco Pharmaceuticals' greenhouse gas emissions and sustainability initiatives.",
                   "Activity data that relates to sustainability"),
;


    private final String   zoneName;
    private final String   displayName;
    private final String   description;
    private final String   criteria;


    /**
     * CocoGovernanceZoneDefinition constructor creates an instance of the enum
     *
     * @param zoneName   unique Id for the zone
     * @param displayName   text for the zone
     * @param description   description of the assets in the zone
     * @param criteria   criteria for inclusion
     */
    CocoGovernanceZoneDefinition(String zoneName, String displayName, String description, String criteria)
    {
        this.zoneName = zoneName;
        this.displayName = displayName;
        this.description = description;
        this.criteria = criteria;
    }


    /**
     * Returns the unique name for the zone entity.
     *
     * @return qualified name
     */
    public String getQualifiedName()
    {
        return "GovernanceZone::" + zoneName;
    }


    /**
     * Returns the unique name for the zone.
     *
     * @return zone name
     */
    public String getZoneName()
    {
        return zoneName;
    }


    /**
     * Returns a descriptive name of the zone.
     *
     * @return display name
     */
    public String getDisplayName()
    {
        return displayName;
    }

    /**
     * Returns a detailed description of the assets within the zone.
     *
     * @return description
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Returns a description of the criteria for including assets in the zone.
     *
     * @return criteria
     */
    public String getCriteria()
    {
        return criteria;
    }
}
