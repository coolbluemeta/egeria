/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.samples.governanceactions.clinicaltrials;

import org.odpi.openmetadata.frameworks.opengovernance.GovernanceActionServiceProviderBase;
import org.odpi.openmetadata.samples.governanceactions.clinicaltrials.metadata.CocoOpenConnectorDefinition;

/**
 * This governance action service sets up the processes for a new clinical trial.
 * It takes details about the project, hospitals involved, and the Data Lake Catalog
 * to use.  It creates a set of specific processes for running the clinical trial
 * that includes many of the properties that are pre-defined.
 */
public class CocoClinicalTrialSetUpProvider extends GovernanceActionServiceProviderBase
{
    private static final String connectorClassName = CocoClinicalTrialSetUpService.class.getName();

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * store implementation.
     */
    public CocoClinicalTrialSetUpProvider()
    {
        super(CocoOpenConnectorDefinition.SET_UP_CLINICAL_TRIAL, connectorClassName, null);

        supportedRequestParameters = CocoClinicalTrialRequestParameter.getClinicalTrialSetUpRequestParameterTypes();
        supportedActionTargetTypes = CocoClinicalTrialActionTarget.getClinicalTrialSetupActionTargetTypes();

        producedGuards = CocoClinicalTrialGuard.getGuardTypes();
    }
}
