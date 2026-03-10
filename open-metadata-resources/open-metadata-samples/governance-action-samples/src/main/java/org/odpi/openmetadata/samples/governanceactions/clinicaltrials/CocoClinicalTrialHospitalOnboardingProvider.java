/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.samples.governanceactions.clinicaltrials;

import org.odpi.openmetadata.frameworks.opengovernance.GovernanceActionServiceProviderBase;
import org.odpi.openmetadata.samples.governanceactions.clinicaltrials.metadata.CocoOpenConnectorDefinition;

public class CocoClinicalTrialHospitalOnboardingProvider extends GovernanceActionServiceProviderBase
{
    private static final String connectorClassName = CocoClinicalTrialHospitalOnboardingService.class.getName();

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * store implementation.
     */
    public CocoClinicalTrialHospitalOnboardingProvider()
    {
        super(CocoOpenConnectorDefinition.ONBOARD_HOSPITAL, connectorClassName, null);

        supportedActionTargetTypes = CocoClinicalTrialActionTarget.getHospitalOnboardingActionTargetTypes();
        supportedRequestParameters = CocoClinicalTrialRequestParameter.getHospitalOnboardingRequestParameterTypes();

        producedGuards = CocoClinicalTrialGuard.getGuardTypes();
    }
}
