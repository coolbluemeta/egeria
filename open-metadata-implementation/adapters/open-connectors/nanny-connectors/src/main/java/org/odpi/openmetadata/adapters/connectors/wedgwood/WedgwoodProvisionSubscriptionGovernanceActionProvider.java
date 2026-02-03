/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.wedgwood;


import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.opengovernance.GovernanceActionServiceProviderBase;

/**
 * ProvisionTabularDataSetGovernanceActionProvider is the OCF connector provider for the Tabular Data Provisioning Governance Action Service.
 * This is a Provisioning Governance Action Service.
 */
public class WedgwoodProvisionSubscriptionGovernanceActionProvider extends GovernanceActionServiceProviderBase
{
    private static final String connectorClassName = WedgwoodProvisionSubscriptionGovernanceActionConnector.class.getName();

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * store implementation.
     */
    public WedgwoodProvisionSubscriptionGovernanceActionProvider()
    {
        super(EgeriaOpenConnectorDefinition.PROVISION_SUBSCRIPTION,
              connectorClassName,
              null);
        super.setConnectorClassName(connectorClassName);

        supportedRequestParameters = WedgwoodProvisionSubscriptionRequestParameter.getRequestParameterTypes();
        supportedActionTargetTypes = WedgwoodProvisionSubscriptionActionTarget.getActionTargetTypes();
        producedGuards = WedgwoodProvisionSubscriptionGuard.getGuardTypes();
    }
}
