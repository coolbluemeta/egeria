/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.subscriptions;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.ConnectorType;
import org.odpi.openmetadata.frameworks.opengovernance.GovernanceActionServiceProviderBase;

/**
 * CancelSubscriptionGovernanceActionProvider is the OCF connector provider for the "Cancel Digital Subscription"
 * Governance Action Service.
 */
public class CancelSubscriptionGovernanceActionProvider extends GovernanceActionServiceProviderBase
{
    private static final String connectorClassName = CancelSubscriptionGovernanceActionConnector.class.getName();

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * store implementation.
     */
    public CancelSubscriptionGovernanceActionProvider()
    {
        super(EgeriaOpenConnectorDefinition.CANCEL_SUBSCRIPTION,
              connectorClassName,
              null);

        super.supportedRequestParameters = null;
        super.producedGuards = ManageDigitalSubscriptionGuard.getGuardTypes();
        super.supportedActionTargetTypes = ManageDigitalSubscriptionActionTarget.getCancelSubscriptionActionTargetTypes();
        super.producedActionTargetTypes = null;
    }
}
