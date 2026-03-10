/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.samples.governanceactions.clinicaltrials.metadata;

import org.odpi.openmetadata.frameworks.auditlog.AuditLogReportingComponent;
import org.odpi.openmetadata.frameworks.auditlog.ComponentDevelopmentStatus;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;

public enum CocoOpenConnectorDefinition implements OpenConnectorDefinition
{
    CERTIFY_HOSPITAL(900,
                     "c07a2573-f191-459b-b567-831200702b11",
                     "CocoPharmaceuticals::GovernanceActionService::ClinicalTrial::CertifyHospital",
                     "Clinical Trial Certify Hospital Governance Action Service",
                     "Adds a certification to the Hospital organization so that its data can be included in a clinical trial.",
                     "https://github.com/odpi/egeria/tree/main/open-metadata-resources/open-metadata-samples/governance-action-samples",
                     "org.odpi.openmetadata.samples.governanceactions.clinicaltrials.CocoClinicalTrialCertifyHospitalProvider",
                     ComponentDevelopmentStatus.STABLE,
                     DeployedImplementationType.GOVERNANCE_ACTION_SERVICE_CONNECTOR.getAssociatedTypeName(),
                     DeployedImplementationType.GOVERNANCE_ACTION_SERVICE_CONNECTOR.getDeployedImplementationType()),

    CERTIFY_WEEKLY_MEASUREMENTS(901,
                                "dd01ede5-ccfc-48db-8315-788b7de5b55f",
                                "CocoPharmaceuticals::SurveyActionService::ClinicalTrial::CertifyWeekly Measurements",
                                "Clinical Trial Certify Weekly Measurements Survey Action Service",
                                "Adds a certification to the inbound weekly measurements data so it can be included in a clinical trial.",
                                "https://github.com/odpi/egeria/tree/main/open-metadata-resources/open-metadata-samples/governance-action-samples",
                                "org.odpi.openmetadata.samples.governanceactions.clinicaltrials.CocoClinicalTrialCertifyWeeklyMeasurementsProvider",
                                ComponentDevelopmentStatus.STABLE,
                                DeployedImplementationType.SURVEY_ACTION_SERVICE_CONNECTOR.getAssociatedTypeName(),
                                DeployedImplementationType.SURVEY_ACTION_SERVICE_CONNECTOR.getDeployedImplementationType()),


    ONBOARD_HOSPITAL(902,
                     "a2963773-e3e3-4d46-92c9-cb836f71a751",
                     "CocoPharmaceuticals::GovernanceActionService::ClinicalTrial::OnboardHospital",
                     "Clinical Trial Hospital Onboarding Governance Action Service",
                     "Sets up the landing area for data from a hospital as part of a clinical trial, along with the pipeline that catalogued the data and moved it into the data lake.  The aim is that the data is moved from the landing area as soon as possible.",
                     "https://github.com/odpi/egeria/tree/main/open-metadata-resources/open-metadata-samples/governance-action-samples",
                     "org.odpi.openmetadata.samples.governanceactions.clinicaltrials.CocoClinicalTrialHospitalOnboardingProvider",
                     ComponentDevelopmentStatus.STABLE,
                     DeployedImplementationType.GOVERNANCE_ACTION_SERVICE_CONNECTOR.getAssociatedTypeName(),
                     DeployedImplementationType.GOVERNANCE_ACTION_SERVICE_CONNECTOR.getDeployedImplementationType()),

    NOMINATE_HOSPITAL(903,
                      "f89e7b05-d05b-449f-8c5c-d5dd7833acec",
                      "CocoPharmaceuticals::GovernanceActionService::ClinicalTrial::NominateHospital",
                      "Clinical Trial Nominate Hospital Governance Action Service",
                      "Adds an incomplete certification relationship the Hospital organization that identifies the hospital contacts that will complete the certification process.  Any previous certifications that the hospital has to this clinical trial are cancelled (ended).",
                      "https://github.com/odpi/egeria/tree/main/open-metadata-resources/open-metadata-samples/governance-action-samples",
                      "org.odpi.openmetadata.samples.governanceactions.clinicaltrials.CocoClinicalTrialNominateHospitalProvider",
                      ComponentDevelopmentStatus.STABLE,
                      DeployedImplementationType.GOVERNANCE_ACTION_SERVICE_CONNECTOR.getAssociatedTypeName(),
                      DeployedImplementationType.GOVERNANCE_ACTION_SERVICE_CONNECTOR.getDeployedImplementationType()),

    SET_UP_DATA_LAKE(904,
                     "2e82b30e-0c31-4cf0-82a8-9f84afe63e8a",
                     "CocoPharmaceuticals::GovernanceActionService::ClinicalTrial::SetUpDataLake",
                     "Clinical Trial Set-Up Data Lake Governance Action Service",
                     "Sets up the storage definitions that support the receipt of weekly patient measurement data for a clinical trial.  This data is accessible through OSS Unity Catalog (UC).",
                     "https://github.com/odpi/egeria/tree/main/open-metadata-resources/open-metadata-samples/governance-action-samples",
                     "org.odpi.openmetadata.samples.governanceactions.clinicaltrials.CocoClinicalTrialSetUpDataLakeProvider",
                     ComponentDevelopmentStatus.STABLE,
                     DeployedImplementationType.GOVERNANCE_ACTION_SERVICE_CONNECTOR.getAssociatedTypeName(),
                     DeployedImplementationType.GOVERNANCE_ACTION_SERVICE_CONNECTOR.getDeployedImplementationType()),

    SET_UP_CLINICAL_TRIAL(905,
                          "b8f96da4-5f01-40bf-89e4-5d631574d12c",
                          "CocoPharmaceuticals::GovernanceActionService::ClinicalTrial::InitialSetUp",
                          "Set-Up New Clinical Trial Governance Action Service",
                          "Sets up the processes for a new clinical trial. It takes details about the project, hospitals involved and the Data Lake Catalog to use.  It creates a set of specific processes for running the clinical trial that includes many of the properties that are pre-defined.",
                          "https://github.com/odpi/egeria/tree/main/open-metadata-resources/open-metadata-samples/governance-action-samples",
                          "org.odpi.openmetadata.samples.governanceactions.clinicaltrials.CocoClinicalTrialSetUpProvider",
                          ComponentDevelopmentStatus.STABLE,
                          DeployedImplementationType.GOVERNANCE_ACTION_SERVICE_CONNECTOR.getAssociatedTypeName(),
                          DeployedImplementationType.GOVERNANCE_ACTION_SERVICE_CONNECTOR.getDeployedImplementationType()),

    ;


    private final int                        connectorComponentId;
    private final String                     connectorTypeGUID;
    private final String                     connectorQualifiedName;
    private final String                     connectorDisplayName;
    private final String                     connectorDescription;
    private final String                     connectorWikiPage;
    private final String                     connectorProviderClassName;
    private final ComponentDevelopmentStatus connectorDevelopmentStatus;
    private final String                     supportedAssetTypeName;
    private final String                     supportedDeployedImplementationType;


    /**
     * Constructor for an open connector definition.
     *
     * @param connectorComponentId                connector component identifier
     * @param connectorTypeGUID                   connector type unique identifier
     * @param connectorQualifiedName              connector type qualified name
     * @param connectorDisplayName                connector type display name
     * @param connectorDescription                connector type description
     * @param connectorWikiPage                   connector wiki page
     * @param connectorProviderClassName          connector provider class name
     * @param connectorDevelopmentStatus          connector development status
     * @param supportedAssetTypeName              connector supported asset type name
     * @param supportedDeployedImplementationType connector supported deployed implementation type
     */
    CocoOpenConnectorDefinition(int                        connectorComponentId,
                                String                     connectorTypeGUID,
                                String                     connectorQualifiedName,
                                String                     connectorDisplayName,
                                String                     connectorDescription,
                                String                     connectorWikiPage,
                                String                     connectorProviderClassName,
                                ComponentDevelopmentStatus connectorDevelopmentStatus,
                                String                     supportedAssetTypeName,
                                String                     supportedDeployedImplementationType)
    {
        this.connectorComponentId                = connectorComponentId;
        this.connectorTypeGUID                   = connectorTypeGUID;
        this.connectorQualifiedName              = connectorQualifiedName;
        this.connectorDisplayName                = connectorDisplayName;
        this.connectorDescription                = connectorDescription;
        this.connectorWikiPage                   = connectorWikiPage;
        this.connectorProviderClassName          = connectorProviderClassName;
        this.connectorDevelopmentStatus          = connectorDevelopmentStatus;
        this.supportedAssetTypeName              = supportedAssetTypeName;
        this.supportedDeployedImplementationType = supportedDeployedImplementationType;
    }


    /**
     * Return the component identifier for the connector.
     *
     * @return int
     */
    @Override
    public int getConnectorComponentId()
    {
        return connectorComponentId;
    }


    /**
     * Return the unique identifier for the connector type.
     *
     * @return string
     */
    @Override
    public String getConnectorTypeGUID()
    {
        return connectorTypeGUID;
    }


    /**
     * Return the qualified name of the connector type.
     *
     * @return string
     */
    @Override
    public String getConnectorQualifiedName()
    {
        return connectorQualifiedName;
    }


    /**
     * Return the display name of the connector type.
     *
     * @return string
     */
    @Override
    public String getConnectorDisplayName()
    {
        return connectorDisplayName;
    }


    /**
     * Return the description of the connector type.
     *
     * @return string
     */
    @Override
    public String getConnectorDescription()
    {
        return connectorDescription;
    }


    /**
     * Return the link to the wiki page for this connector.
     *
     * @return string
     */
    @Override
    public String getConnectorWikiPage()
    {
        return connectorWikiPage;
    }


    /**
     * Return the class name of the connector provider that implements this connector.
     *
     * @return string
     */
    @Override
    public String getConnectorProviderClassName()
    {
        return connectorProviderClassName;
    }


    /**
     * Return the development status of the connector.
     *
     * @return ComponentDevelopmentStatus enum
     */
    @Override
    public ComponentDevelopmentStatus getConnectorDevelopmentStatus()
    {
        return connectorDevelopmentStatus;
    }


    /**
     * Return the name of the asset type that this connector supports.
     *
     * @return string
     */
    @Override
    public String getSupportedAssetTypeName()
    {
        return supportedAssetTypeName;
    }


    /**
     * Return the name of the deployed implementation that this connector supports.
     *
     * @return string
     */
    @Override
    public String getSupportedDeployedImplementationType()
    {
        return supportedDeployedImplementationType;
    }


    /**
     * Return the component description for this connector.
     * This is used to initialize the audit log for the connector.
     *
     * @return AuditLogReportingComponent
     */
    @Override
    public AuditLogReportingComponent getComponentDescription()
    {
        return new AuditLogReportingComponent(connectorComponentId,
                                              connectorDevelopmentStatus,
                                              connectorDisplayName,
                                              connectorDescription,
                                              connectorWikiPage);
    }
}
