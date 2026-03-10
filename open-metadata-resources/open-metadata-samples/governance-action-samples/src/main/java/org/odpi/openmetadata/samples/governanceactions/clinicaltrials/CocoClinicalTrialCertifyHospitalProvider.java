/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.samples.governanceactions.clinicaltrials;

import org.odpi.openmetadata.frameworks.opengovernance.GovernanceActionServiceProviderBase;
import org.odpi.openmetadata.samples.governanceactions.clinicaltrials.metadata.CocoOpenConnectorDefinition;

public class CocoClinicalTrialCertifyHospitalProvider extends GovernanceActionServiceProviderBase
{
    private static final String connectorClassName = CocoClinicalTrialCertifyHospitalService.class.getName();

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * store implementation.
     */
    public CocoClinicalTrialCertifyHospitalProvider()
    {
        super(CocoOpenConnectorDefinition.CERTIFY_HOSPITAL,
              connectorClassName,
              null);

        supportedRequestParameters = CocoClinicalTrialRequestParameter.getCertifyHospitalRequestParameterTypes();
        supportedActionTargetTypes = CocoClinicalTrialActionTarget.getCertifyHospitalActionTargetTypes();

        producedGuards = CocoClinicalTrialGuard.getGuardTypes();
    }
}
