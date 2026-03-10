/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.samples.governanceactions.clinicaltrials;

import org.odpi.openmetadata.frameworks.opengovernance.GovernanceActionServiceProviderBase;
import org.odpi.openmetadata.samples.governanceactions.clinicaltrials.metadata.CocoOpenConnectorDefinition;

public class CocoClinicalTrialNominateHospitalProvider extends GovernanceActionServiceProviderBase
{
    private static final String connectorClassName = CocoClinicalTrialNominateHospitalService.class.getName();

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * store implementation.
     */
    public CocoClinicalTrialNominateHospitalProvider()
    {
        super(CocoOpenConnectorDefinition.NOMINATE_HOSPITAL, connectorClassName, null);

        supportedRequestParameters = CocoClinicalTrialRequestParameter.getNominateHospitalRequestParameterTypes();
        supportedActionTargetTypes = CocoClinicalTrialActionTarget.getNominateHospitalActionTargetTypes();

        producedGuards = CocoClinicalTrialGuard.getGuardTypes();
    }
}
