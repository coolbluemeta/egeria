/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.samples.archiveutilities.businesssystems;

import org.odpi.openmetadata.frameworks.openmetadata.refdata.SolutionComponentType;
import org.odpi.openmetadata.samples.governanceactions.clinicaltrials.metadata.ClinicalTrialSolutionComponent;

import java.util.Arrays;
import java.util.List;

/**
 * A description of the predefined solution components.
 */
public enum SolutionComponent
{
    HOSPITAL("ee2bb773-e630-4cf9-bdf1-7c2dd64fe4ec",
             SolutionComponentType.THIRD_PARTY_PROCESS.getSolutionComponentType(),
             "External Organization Processes",
             "Hospital Processes",
             "Processes running in the hospital that negotiate data sharing agreements, recruit patients, train staf and deliver data.",
             "V1.0",
             new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
             null,
             new InformationSupplyChainSegment[]{
                     InformationSupplyChainSegment.HOSPITAL_TO_LANDING_AREA}),

    HOSPITAL_LANDING_AREA_FOLDER(ClinicalTrialSolutionComponent.HOSPITAL_LANDING_AREA_FOLDER.getGUID(),
                                 SolutionComponentType.DATA_STORAGE.getSolutionComponentType(),
                                 "File Directory",
                                 "Hospital Landing Area Folder",
                                 "Destination for incoming files from a particular hospital.",
                                 "V1.0",
                                 new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                                 null,
                                 new InformationSupplyChainSegment[]{
                                         InformationSupplyChainSegment.HOSPITAL_TO_LANDING_AREA,
                                         InformationSupplyChainSegment.LANDING_AREA_TO_DATA_LAKE}),

    LANDING_FOLDER_CATALOGUER(ClinicalTrialSolutionComponent.LANDING_FOLDER_CATALOGUER.getGUID(),
                              SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                              "Integration Connector",
                              "Landing Folder Cataloguer",
                              "Integration connector that is cataloguing files arriving in the hospital landing area folders and invoking the onboarding pipeline.",
                              "V1.0",
                              new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                              null,
                              new InformationSupplyChainSegment[]{
                                      InformationSupplyChainSegment.LANDING_AREA_TO_DATA_LAKE}),

    WEEKLY_MEASUREMENTS_ONBOARDING_PIPELINE(ClinicalTrialSolutionComponent.WEEKLY_MEASUREMENTS_ONBOARDING_PIPELINE.getGUID(),
                                            SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                                            "Governance Action Process",
                                            "Weekly Measurements Onboarding Pipeline",
                                            "Move landing area files to data lake, catalog files in data lake with lineage from the landing area and validate/certify that the data contains valid values.  The cataloguing includes lineage, retention, origin, governance zones.  The quality validation survey will add a certification to the file asset if the data contains valid values.",
                                            "V1.0",
                                            new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                                            null,
                                            new InformationSupplyChainSegment[]{
                                                    InformationSupplyChainSegment.LANDING_AREA_TO_DATA_LAKE}),

    WEEKLY_MEASUREMENTS_DATA_LAKE_FOLDER(ClinicalTrialSolutionComponent.WEEKLY_MEASUREMENTS_DATA_LAKE_FOLDER.getGUID(),
                                         SolutionComponentType.DATA_STORAGE.getSolutionComponentType(),
                                         "Unity Catalog Volume (File Directory)",
                                         "Weekly Measurements Data Lake Folder",
                                         "The directory where the files from the hospitals are assembled for sharing.",
                                         "V1.0",
                                         new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                                         null,
                                         new InformationSupplyChainSegment[]{
                                                 InformationSupplyChainSegment.DATA_LAKE_TO_SANDBOX,
                                                 InformationSupplyChainSegment.LANDING_AREA_TO_DATA_LAKE}),

    POPULATE_SANDBOX("26c07ca4-3b8e-484b-812b-36c1ace4b275",
                     SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                     "Airflow DAG",
                     "Populate Sandbox",
                     "A process that copies certified files from the hospitals into the research team's sandbox for processing.",
                     "V1.0",
                     new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                     null,
                     new InformationSupplyChainSegment[]{
                             InformationSupplyChainSegment.DATA_LAKE_TO_SANDBOX}),

    TREATMENT_VALIDATION_SANDBOX("d48f579f-76d3-4c49-b1b4-575f5645a9d0",
                                 SolutionComponentType.DATA_STORAGE.getSolutionComponentType(),
                                 "PostgreSQL Database",
                                 "Treatment Validation Sandbox",
                                 "A postgreSQL database schema for assembling data needed to validate the clinical trial.",
                                 "V1.0",
                                 new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                                 null,
                                 new InformationSupplyChainSegment[]{
                                         InformationSupplyChainSegment.DATA_LAKE_TO_SANDBOX,
                                         InformationSupplyChainSegment.ASSESS_TREATMENT}),

    ANALYSE_PATIENT_DATA("b5c8da4c-f925-4cf1-8294-e43cd2c1a584",
                         SolutionComponentType.INSIGHT_MODEL.getSolutionComponentType(),
                         "AI Workflow",
                         "Analyse Patient Data",
                         "ML Flow based analytics pipeline to run the variety of models over the patient data.",
                         "V1.0",
                         new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                         null,
                         new InformationSupplyChainSegment[]{
                                 InformationSupplyChainSegment.ASSESS_TREATMENT}),

    TREATMENT_EFFICACY_EVIDENCE("48bc201e-3d4e-4beb-bdb2-0fd9d134f6d5",
                                SolutionComponentType.DATA_STORAGE.getSolutionComponentType(),
                                "Content Manager",
                                "Treatment Efficacy Evidence",
                                "Assembly of the data required by the regulator.",
                                "V1.0",
                                new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                                null,
                                new InformationSupplyChainSegment[]{
                                        InformationSupplyChainSegment.DELIVER_REPORT,
                                        InformationSupplyChainSegment.ASSESS_TREATMENT}),

    ASSEMBLE_REPORT("72a86eec-9734-4bc0-babb-4fec0aa7c9ff",
                    SolutionComponentType.MANUAL_PROCESS.getSolutionComponentType(),
                    "Manual Process",
                    "Assemble Treatment Assessment Report",
                    "A process of creating a filing report for the regulators detailing the findings from the clinical trial.",
                    "V1.0",
                    new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                    null,
                    new InformationSupplyChainSegment[]{
                            InformationSupplyChainSegment.DELIVER_REPORT}),

    REPORT_VALIDATION_AND_DELIVERY("0bf2547c-937c-41b6-814f-6284849271a1",
                                   SolutionComponentType.DOCUMENT_PUBLISHING.getSolutionComponentType(),
                                   "Manual Process",
                                   "Treatment Assessment Report Validation and Delivery",
                                   "An expert review, presentation, discussions relating to the results of the clinical trial.",
                                   "V1.0",
                                   new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                                   null,
                                   new InformationSupplyChainSegment[]{InformationSupplyChainSegment.DELIVER_REPORT}),

    NOMINATE_HOSPITAL(ClinicalTrialSolutionComponent.NOMINATE_HOSPITAL.getGUID(),
                      SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                      "Governance Action Process",
                      "Nominate Hospital",
                      "Add details of a hospital as a candidate for participation in the clinical trials.",
                      "V1.0",
                      new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                      null,
                      null),

    CERTIFY_HOSPITAL(ClinicalTrialSolutionComponent.CERTIFY_HOSPITAL.getGUID(),
                     SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                     "Governance Action Process",
                     "Certify Hospital",
                     "Confirm that a hospital has met all of the criteria to participate in the clinical trial.",
                     "V1.0",
                     new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                     null,
                     null),

    ONBOARD_HOSPITAL(ClinicalTrialSolutionComponent.ONBOARD_HOSPITAL.getGUID(),
                     SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                     "Governance Action Process",
                     "Onboard Hospital",
                     "Set up the onboarding pipeline for a participating hospital.  This fails if the hospital is not certified.",
                     "V1.0",
                     new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                     null,
                     null),

    SET_UP_DATA_LAKE_FOLDER(ClinicalTrialSolutionComponent.SET_UP_DATA_LAKE_FOLDER.getGUID(),
                            SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                            "Governance Action Process",
                            "Set up Data Lake Folder",
                            "Set up the directory and Unity Catalog Volume for incoming patient measurements.",
                            "V1.0",
                            new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                            new SolutionComponent[]{
                                    WEEKLY_MEASUREMENTS_DATA_LAKE_FOLDER
                            },
                            null),

    SET_UP_CLINICAL_TRIAL("849b0b42-f465-452b-813c-477d6398e082",
                          SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                          "Governance Action Process",
                          "Set up clinical trial",
                          "Generates the project, and governance action processes needed to drive a clinical trial.",
                          "V2.0",
                          new SolutionBlueprint[]{SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT},
                          null,
                          null),

    SUSTAINABILITY_ODS("fc55ef2d-a88d-44ee-94cb-3fca9b9af8b4",
                       SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                       "PostgreSQL Database",
                       "Sustainability Operational Data Store (ODS)",
                       "A store for both the raw data needed for the sustainability calculations and the results.",
                       "V1.0",
                       new SolutionBlueprint[]{SolutionBlueprint.SUSTAINABILITY_REPORTING},
                       null,
                       new InformationSupplyChainSegment[]{
                               InformationSupplyChainSegment.SUSTAINABILITY_DATA_GATHERING,
                               InformationSupplyChainSegment.SUSTAINABILITY_ASSESSMENT}),

    SUSTAINABILITY_CALCULATORS("06edd666-06fd-43ef-b7bd-22e2651c334f",
                               SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                               "Analytics Application",
                               "Sustainability Calculators",
                               "Algorithms that calculate the impact of Coco Pharmaceuticals' operation and the changes that are making a difference.",
                               "V1.0",
                               new SolutionBlueprint[]{SolutionBlueprint.SUSTAINABILITY_REPORTING},
                               null,
                               new InformationSupplyChainSegment[]{
                                       InformationSupplyChainSegment.SUSTAINABILITY_ASSESSMENT}),

    SUSTAINABILITY_DASHBOARDS("d50a6f1f-49d2-47c3-a55e-5844464bd26f",
                               SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                               "SuperSet Application",
                               "Sustainability Dashboards",
                               "Dashboards that illustrate Coco Pharmaceuticals' sustainability position.",
                               "V1.0",
                              new SolutionBlueprint[]{SolutionBlueprint.SUSTAINABILITY_REPORTING},
                               null,
                               new InformationSupplyChainSegment[]{
                                       InformationSupplyChainSegment.DELIVER_SUSTAINABILITY_REPORT}),

    EMPLOYEE_EXPENSE_TOOL("02cdce9a-7630-479a-90de-fd7698d098f1",
                          SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                          "Cloud Application",
                          "Employee Expense Tool",
                          "Application for recording and categorizing employee expenses, and authorizing the repayment.",
                          "V1.0",
                          new SolutionBlueprint[]{
                                  SolutionBlueprint.SUSTAINABILITY_REPORTING,
                                  SolutionBlueprint.EMPLOYEE_MANAGEMENT},
                          null,
                          new InformationSupplyChainSegment[]{
                                  InformationSupplyChainSegment.SUSTAINABILITY_DATA_GATHERING}),
    HAZMAT_INVENTORY("25fd5be7-692d-4752-9dc7-30068a7d665e",
                     SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                     "COTS Application",
                     "Hazardous Materials (HazMat) Inventory",
                     "Application for recording and tracing hazardous materials.  This includes greenhouse gasses such as CO2 and Hydro-fluorocarbons.",
                     "V1.0",
                     new SolutionBlueprint[]{
                             SolutionBlueprint.SUSTAINABILITY_REPORTING,
                             SolutionBlueprint.HAZARDOUS_MATERIAL_MANAGEMENT},
                     null,
                     new InformationSupplyChainSegment[]{
                             InformationSupplyChainSegment.SUSTAINABILITY_DATA_GATHERING}),

    ACCOUNTING_LEDGER("2c0f5a4e-bb02-4081-a80e-3072ca99a1aa",
                      SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                      "Cloud Application",
                      "Accounting ledgers",
                      "Application for recording and tracing the income and spending of Coco Pharmaceuticals.  This can help to identify how much the company is spending on particular materials and activities.",
                      "V1.0",
                      new SolutionBlueprint[]{
                              SolutionBlueprint.SUSTAINABILITY_REPORTING,
                              SolutionBlueprint.PERSONALIZED_MEDICINE_ORDER_FULFILLMENT},
                      null,
                      new InformationSupplyChainSegment[]{
                              InformationSupplyChainSegment.SUSTAINABILITY_DATA_GATHERING}),

    GOODS_INVENTORY("50768e61-43b6-4241-96a3-4c413582ec1f",
                    SolutionComponentType.AUTOMATED_PROCESS.getSolutionComponentType(),
                    "COTS Application",
                    "Goods Inventory",
                    "Application for recording and tracing physical materials as they are acquired, stored, distributed and used.",
                    "V1.0",
                    new SolutionBlueprint[]{
                            SolutionBlueprint.SUSTAINABILITY_REPORTING,
                            SolutionBlueprint.INVENTORY_MANAGEMENT},
                    null,
                    new InformationSupplyChainSegment[]{
                            InformationSupplyChainSegment.SUSTAINABILITY_DATA_GATHERING}),


    ;


    private final String                          guid;
    private final String                          componentType;
    private final String                          implementationType;
    private final String                          displayName;
    private final String                          description;
    private final String                          versionIdentifier;
    private final SolutionBlueprint[]             consumingBlueprints;
    private final SolutionComponent[]             subComponents;
    private final InformationSupplyChainSegment[] linkedFromSegment;


    /**
     * Construct an enum instance.
     *
     * @param guid unique identifier
     * @param componentType   type of solution component - ege automated process
     * @param implementationType   type of software component - for example, is it a process, of file or database.
     * @param displayName display name of solution component
     * @param description description of solution component
     * @param versionIdentifier version identifier of the solution component
     * @param consumingBlueprints the blueprint that this belongs to
     * @param subComponents optional subcomponents of the solution
     * @param linkedFromSegment array of segments that are implemented by this component
     */
    SolutionComponent(String                          guid,
                      String                          componentType,
                      String                          implementationType,
                      String                          displayName,
                      String                          description,
                      String                          versionIdentifier,
                      SolutionBlueprint[]             consumingBlueprints,
                      SolutionComponent[]             subComponents,
                      InformationSupplyChainSegment[] linkedFromSegment)
    {
        this.guid                = guid;
        this.componentType       = componentType;
        this.implementationType  = implementationType;
        this.displayName         = displayName;
        this.description         = description;
        this.versionIdentifier   = versionIdentifier;
        this.consumingBlueprints = consumingBlueprints;
        this.subComponents       = subComponents;
        this.linkedFromSegment   = linkedFromSegment;

    }


    /**
     * Return the GUID for the element.
     *
     * @return string
     */
    public String getGUID()
    {
        return guid;
    }


    /**
     * Return the type of solution component - for example, is it a process, of file or database.
     *
     * @return string
     */
    public String getComponentType()
    {
        return componentType;
    }


    /**
     * Return which type of software component is likely to be deployed to implement this solution component.
     *
     * @return string
     */
    public String getImplementationType()
    {
        return implementationType;
    }


    /**
     * Return the display name of the solution blueprint.
     *
     * @return string
     */
    public String getDisplayName()
    {
        return displayName;
    }


    /**
     * Return the description of the solution blueprint
     *
     * @return string
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Return the version identifier of the solution blueprint.
     *
     * @return string
     */
    public String getVersionIdentifier()
    {
        return versionIdentifier;
    }


    public List<SolutionBlueprint> getConsumingBlueprints()
    {
        if (consumingBlueprints == null)
        {
            return null;
        }

        return Arrays.asList(consumingBlueprints);
    }


    /**
     * Return the optional list of subcomponents.
     *
     * @return null or list
     */
    public List<SolutionComponent> getSubComponents()
    {
        if (subComponents == null)
        {
            return null;
        }

        return Arrays.asList(subComponents);
    }


    /**
     * Return the segments that preceded this segment.
     *
     * @return list of segments
     */
    public List<InformationSupplyChainSegment> getLinkedFromSegment()
    {
        if (linkedFromSegment == null)
        {
            return null;
        }

        return Arrays.asList(linkedFromSegment);
    }


    /**
     * Return the unique name of the solution blueprint.
     *
     * @return string
     */
    public String getQualifiedName()
    {
        return "SolutionComponent:" + displayName + ":" + versionIdentifier;
    }


    /**
     * Output of this enum class and main value.
     *
     * @return string showing enum value
     */
    @Override
    public String toString()
    {
        return "SolutionComponent{" + displayName + '}';
    }
}
