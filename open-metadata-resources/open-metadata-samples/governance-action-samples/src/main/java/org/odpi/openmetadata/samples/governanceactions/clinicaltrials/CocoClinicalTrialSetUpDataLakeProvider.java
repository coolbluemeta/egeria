/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.samples.governanceactions.clinicaltrials;

import org.odpi.openmetadata.frameworks.opengovernance.GovernanceActionServiceProviderBase;
import org.odpi.openmetadata.samples.governanceactions.clinicaltrials.metadata.CocoOpenConnectorDefinition;

public class CocoClinicalTrialSetUpDataLakeProvider extends GovernanceActionServiceProviderBase
{
    private static final String connectorClassName = CocoClinicalTrialSetUpDataLakeService.class.getName();

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * store implementation.
     */
    public CocoClinicalTrialSetUpDataLakeProvider()
    {
        super(CocoOpenConnectorDefinition.SET_UP_DATA_LAKE, connectorClassName, null);

        supportedRequestParameters = CocoClinicalTrialRequestParameter.getSetUpDataLakeRequestParameterTypes();
        supportedActionTargetTypes = CocoClinicalTrialActionTarget.getSetUpDataLakeActionTargetTypes();

        producedGuards = CocoClinicalTrialGuard.getGuardTypes();
    }
}
