/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.samples.governanceactions.clinicaltrials.metadata;

import java.util.Arrays;
import java.util.List;

/**
 * A description of the predefined solution components.
 */
public enum SolutionComponent
{
    HOSPITAL("ee2bb773-e630-4cf9-bdf1-7c2dd64fe4ec",
             "External Organization Processes",
             "Hospital Processes",
             "Processes running in the hospital that negotiate data sharing agreements, recruit patients, train staf and deliver data.",
             "V1.0",
             SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
             null,
             new InformationSupplyChainSegment[]{
                     InformationSupplyChainSegment.HOSPITAL_TO_LANDING_AREA}),

    HOSPITAL_LANDING_AREA_FOLDER("1c150d6e-30cf-481c-9afb-3b06c9c9e78f",
                                 "Hospital Landing Area Folder",
                                 "File Directory",
                                 "Destination for incoming files from a particular hospital.",
                                 "V1.0",
                                 SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                                 null,
                                 new InformationSupplyChainSegment[]{
                                         InformationSupplyChainSegment.HOSPITAL_TO_LANDING_AREA,
                                         InformationSupplyChainSegment.LANDING_AREA_TO_DATA_LAKE}),

    LANDING_FOLDER_CATALOGUER("07705e15-efff-4f80-8992-f04ac85e0ef1",
                              "Integration Connector",
                              "Landing Folder Cataloguer",
                              "Integration connector that is cataloguing files arriving in the hospital landing area folders and invoking the onboarding pipeline.",
                              "V1.0",
                              SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                              null,
                              new InformationSupplyChainSegment[]{
                                      InformationSupplyChainSegment.LANDING_AREA_TO_DATA_LAKE}),

    WEEKLY_MEASUREMENTS_ONBOARDING_PIPELINE("7f5dca65-50b4-4103-9ac7-3a406a09047a",
                                            "Governance Action Process",
                                            "Move landing area files to data lake, catalog files in data lake with lineage from the landing area and validate/certify that the data contains valid values.",
                                            "Moves each file into the data lake folder, catalogues it and adds lineage, retention, origin, governance zones and runs a quality validation survey to certify that the data contains valid values.",
                                            "V1.0",
                                            SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                                            null,
                                            new InformationSupplyChainSegment[]{
                                                    InformationSupplyChainSegment.LANDING_AREA_TO_DATA_LAKE}),

    WEEKLY_MEASUREMENTS_DATA_LAKE_FOLDER("a5d4d638-6836-47e5-99d0-fdcde637e13f",
                                         "Unity Catalog Volume (File Directory)",
                                         "Weekly Measurements Data Lake Folder",
                                         "The directory where the files from the hospitals are assembled for sharing.",
                                         "V1.0",
                                         SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                                         null,
                                         new InformationSupplyChainSegment[]{
                                                 InformationSupplyChainSegment.DATA_LAKE_TO_SANDBOX,
                                                 InformationSupplyChainSegment.LANDING_AREA_TO_DATA_LAKE}),

    POPULATE_SANDBOX("26c07ca4-3b8e-484b-812b-36c1ace4b275",
                     "Airflow DAG",
                     "Populate Sandbox",
                     "A process that copies certified files from the hospitals into the research team's sandbox for processing.",
                     "V1.0",
                     SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                     null,
                     new InformationSupplyChainSegment[]{
                             InformationSupplyChainSegment.DATA_LAKE_TO_SANDBOX}),

    TREATMENT_VALIDATION_SANDBOX("d48f579f-76d3-4c49-b1b4-575f5645a9d0",
                                 "PostgreSQL Database",
                                 "Treatment Validation Sandbox",
                                 "A postgreSQL database schema for assembling data needed to validate the clinical trial.",
                                 "V1.0",
                                 SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                                 null,
                                 new InformationSupplyChainSegment[]{
                                         InformationSupplyChainSegment.DATA_LAKE_TO_SANDBOX,
                                         InformationSupplyChainSegment.ASSESS_TREATMENT}),

    ANALYSE_PATIENT_DATA("b5c8da4c-f925-4cf1-8294-e43cd2c1a584",
                         "AI Workflow",
                         "Analyse Patient Data",
                         "ML Flow based analytics pipeline to run the variety of models over the patient data.",
                         "V1.0",
                         SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                         null,
                         new InformationSupplyChainSegment[]{
                                 InformationSupplyChainSegment.ASSESS_TREATMENT}),

    TREATMENT_EFFICACY_EVIDENCE("48bc201e-3d4e-4beb-bdb2-0fd9d134f6d5",
                                "Content Manager",
                                "Treatment Efficacy Evidence",
                                "Assembly of the data required by the regulator.",
                                "V1.0",
                                SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                                null,
                                new InformationSupplyChainSegment[]{
                                        InformationSupplyChainSegment.DELIVER_REPORT,
                                        InformationSupplyChainSegment.ASSESS_TREATMENT}),

    ASSEMBLE_REPORT("72a86eec-9734-4bc0-babb-4fec0aa7c9ff",
                    "Manual Process",
                    "Assemble Treatment Assessment Report",
                    "A process of creating a filing report for the regulators detailing the findings from the clinical trial.",
                    "V1.0",
                    SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                    null,
                    new InformationSupplyChainSegment[]{
                            InformationSupplyChainSegment.DELIVER_REPORT}),

    REPORT_VALIDATION_AND_DELIVERY("0bf2547c-937c-41b6-814f-6284849271a1",
                                   "Manual Process",
                                   "Treatment Assessment Report Validation and Delivery",
                                   "An expert review, presentation, discussions relating to the results of the clinical trial.",
                                   "V1.0",
                                   SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                                   null,
                                   new InformationSupplyChainSegment[]{InformationSupplyChainSegment.DELIVER_REPORT}),

    NOMINATE_HOSPITAL("11c7c850-c67c-41cc-9423-d74db47cbf3a",
                      "Governance Action Process",
                      "Nominate Hospital",
                      "Add details of a hospital as a candidate for participation in the clinical trials.",
                      "V1.0",
                      SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                      null,
                      null),

    CERTIFY_HOSPITAL("37b8560d-84d4-434b-9b0d-105420fcc924",
                     "Governance Action Process",
                     "Certify Hospital",
                     "Confirm that a hospital has met all of the criteria to participate in the clinical trial.",
                     "V1.0",
                     SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                     null,
                     null),

    ONBOARD_HOSPITAL("e9c2f911-ffcb-40c6-aeee-8c4d43811576",
                     "Governance Action Process",
                     "Onboard Hospital",
                     "Set up the onboarding pipeline for a participating hospital.  This fails if the hospital is not certified.",
                     "V1.0",
                     SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                     null,
                     null),

    SET_UP_DATA_LAKE_FOLDER("fb32bef2-e79f-4893-b500-2e547f24d482",
                            "Governance Action Process",
                            "Set up Data Lake Folder",
                            "Set up the directory and Unity Catalog Volume for incoming patient measurements.",
                            "V1.0",
                            SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                            new SolutionComponent[]{
                                    WEEKLY_MEASUREMENTS_DATA_LAKE_FOLDER
                            },
                            null),

    SET_UP_CLINICAL_TRIAL("849b0b42-f465-452b-813c-477d6398e082",
                          "Governance Action Process",
                          "Set up clinical trial",
                          "Generates the project, and governance action processes needed to drive a clinical trial.",
                          "V2.0",
                          SolutionBlueprint.CLINICAL_TRIAL_MANAGEMENT,
                          null,
                          null),

    ;


    private final String                   guid;
    private final String                   componentType;
    private final String                   displayName;
    private final String                   description;
    private final String                   versionIdentifier;
    private final SolutionBlueprint        owningBlueprint;
    private final SolutionComponent[]      subComponents;
    private final InformationSupplyChainSegment[] linkedFromSegment;


    /**
     * Construct an enum instance.
     *
     * @param guid unique identifier
     * @param componentType   type of solution component - for example, is it a process, of file or database.
     * @param displayName display name of solution component
     * @param description description of solution component
     * @param versionIdentifier version identifier of the solution component
     * @param owningBlueprint the blueprint that this belongs to
     * @param subComponents optional subcomponents of the solution
     * @param linkedFromSegment array of segments that are implemented by this component
     */
    SolutionComponent(String                          guid,
                      String                          componentType,
                      String                          displayName,
                      String                          description,
                      String                          versionIdentifier,
                      SolutionBlueprint               owningBlueprint,
                      SolutionComponent[]             subComponents,
                      InformationSupplyChainSegment[] linkedFromSegment)
    {
        this.guid              = guid;
        this.componentType     = componentType;
        this.displayName       = displayName;
        this.description       = description;
        this.versionIdentifier = versionIdentifier;
        this.owningBlueprint   = owningBlueprint;
        this.subComponents     = subComponents;
        this.linkedFromSegment = linkedFromSegment;

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


    public SolutionBlueprint getOwningBlueprint()
    {
        return owningBlueprint;
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
