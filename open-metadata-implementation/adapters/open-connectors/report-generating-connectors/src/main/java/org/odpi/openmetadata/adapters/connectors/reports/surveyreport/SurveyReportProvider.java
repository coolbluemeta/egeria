/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.reports.surveyreport;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.connectors.reports.ReportGuard;
import org.odpi.openmetadata.adapters.connectors.reports.ReportRequestParameter;
import org.odpi.openmetadata.frameworks.opengovernance.GovernanceActionServiceProviderBase;
import org.odpi.openmetadata.frameworks.opensurvey.controls.SurveyActionTarget;

/**
 * SurveyReportProvider is the OCF connector provider for the "SurveyReportService" Governance Action Service.
 */
public class SurveyReportProvider extends GovernanceActionServiceProviderBase
{
    private static final String connectorClassName = SurveyReportService.class.getName();

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * store implementation.
     */
    public SurveyReportProvider()
    {
        super(EgeriaOpenConnectorDefinition.SURVEY_REPORT_WRITER, connectorClassName, null);

        supportedRequestParameters = ReportRequestParameter.getRequestParameterTypes();
        supportedActionTargetTypes = SurveyActionTarget.getReportActionTargetTypes();
        producedGuards             = ReportGuard.getGuardTypes();
    }
}
