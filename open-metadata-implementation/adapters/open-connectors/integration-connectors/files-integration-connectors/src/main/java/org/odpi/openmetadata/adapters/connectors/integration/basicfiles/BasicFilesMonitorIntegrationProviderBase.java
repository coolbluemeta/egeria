/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.integration.basicfiles;

import org.odpi.openmetadata.frameworks.auditlog.AuditLogReportingComponent;
import org.odpi.openmetadata.frameworks.auditlog.ComponentDevelopmentStatus;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorDefinition;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.ConnectorType;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;
import org.odpi.openmetadata.frameworks.integration.connectors.IntegrationConnectorProvider;

import java.util.ArrayList;
import java.util.List;


/**
 * BasicFilesMonitorIntegrationProviderBase is the base class provider for the basic files integration connectors.
 */
class BasicFilesMonitorIntegrationProviderBase extends IntegrationConnectorProvider
{
    /**
     * An optional boolean flag to indicate that all files should be catalogued, whether they are classified or not.
     */
    static public final String CATALOG_ALL_FILES_CONFIGURATION_PROPERTY     = "catalogAllFiles";


    /**
     * An optional qualified name of a template To Do entity that is created if there is confusion identifying the correct
     * reference data for a file being catalogued.
     */
    static public final String TO_DO_TEMPLATE_CONFIGURATION_PROPERTY           = "toDoTemplateQualifiedName";

    /**
     * An optional qualified name of a template Incident Report entity that is created if there is confusion identifying the correct
     * reference data for a file being catalogued.
     */
    static public final String INCIDENT_REPORT_TEMPLATE_CONFIGURATION_PROPERTY = "incidentReportTemplateQualifiedName";

    /**
     * An optional flag that instructs the connector to wait for the monitoring directory to be created if it does not exist rather than
     * throwing an exception to force the integration connector into failed state.  It can be set to any value - just defining the
     * property causes the connector to wait.
     */
    static public final String WAIT_FOR_DIRECTORY_CONFIGURATION_PROPERTY       = "waitForDirectory";

    /**
     * The name of the catalog target that contains the directory to monitor.
     */
    static public final String CATALOG_TARGET_NAME                             = "directoryToMonitor";

    /**
     * Constructor for an open connector provider.
     *
     * @param openConnectorDescription connector definition
     * @param connectorClassName       connector class name
     */
    BasicFilesMonitorIntegrationProviderBase(OpenConnectorDefinition openConnectorDescription,
                                             String                  connectorClassName)
    {
        super(openConnectorDescription,
              connectorClassName,
              List.of(CATALOG_ALL_FILES_CONFIGURATION_PROPERTY,
                      TO_DO_TEMPLATE_CONFIGURATION_PROPERTY,
                      INCIDENT_REPORT_TEMPLATE_CONFIGURATION_PROPERTY,
                      WAIT_FOR_DIRECTORY_CONFIGURATION_PROPERTY));
    }
}
