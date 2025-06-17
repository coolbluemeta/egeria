/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.viewservices.referencedata.admin;

import org.odpi.openmetadata.adminservices.configuration.properties.ViewServiceConfig;
import org.odpi.openmetadata.adminservices.configuration.registration.ViewServiceDescription;
import org.odpi.openmetadata.adminservices.ffdc.exception.OMAGConfigurationErrorException;
import org.odpi.openmetadata.adminservices.registration.ViewServiceAdmin;
import org.odpi.openmetadata.frameworks.auditlog.AuditLog;
import org.odpi.openmetadata.viewservices.referencedata.ffdc.ReferenceDataAuditCode;
import org.odpi.openmetadata.viewservices.referencedata.server.ReferenceDataInstance;

/**
 * ReferenceDataAdmin is the class that is called by the View Server to initialize and terminate
 * the Reference Data OMVS.  The initialization call provides this OMVS with the Audit log and configuration.
 */
public class ReferenceDataAdmin extends ViewServiceAdmin
{
    private AuditLog              auditLog   = null;
    private ReferenceDataInstance instance   = null;
    private String                serverName = null;

    /**
     * Default constructor
     */
    public ReferenceDataAdmin()
    {
    }


    /**
     * Initialize the view service.
     *
     * @param serverName                         name of the local server
     * @param viewServiceConfig                  specific configuration properties for this view service.
     * @param auditLog                           audit log component for logging messages.
     * @param serverUserName                     user id to use on OMRS calls where there is no end user, or as part of an HTTP authentication mechanism with serverUserPassword.
     * @param serverUserPassword                 password to use as part of an HTTP authentication mechanism.
     * @param maxPageSize                        maximum page size. 0 means unlimited
     * @throws OMAGConfigurationErrorException   invalid parameters in the configuration properties.
     */
    @Override
    public void initialize(String                       serverName,
                           ViewServiceConfig            viewServiceConfig,
                           AuditLog                     auditLog,
                           String                       serverUserName,
                           String                       serverUserPassword,
                           int                          maxPageSize) throws OMAGConfigurationErrorException
    {

        final String actionDescription = "initialize";

        auditLog.logMessage(actionDescription, ReferenceDataAuditCode.SERVICE_INITIALIZING.getMessageDefinition());

        this.auditLog = auditLog;
        this.serverName = serverName;

        try
        {
            /*
             * The name and rootURL of a repository server are not passed at this stage - they are not known at this stage
             * because they are set at runtime by the user and potentially changed between operations.
             */
            this.instance = new ReferenceDataInstance(serverName,
                                                      auditLog,
                                                      serverUserName,
                                                      serverUserPassword,
                                                      maxPageSize,
                                                      viewServiceConfig.getOMAGServerName(),
                                                      viewServiceConfig.getOMAGServerPlatformRootURL());

            auditLog.logMessage(actionDescription,
                                ReferenceDataAuditCode.SERVICE_INITIALIZED.getMessageDefinition(),
                                viewServiceConfig.toString());

        }
        catch (Exception error)
        {
            auditLog.logException(actionDescription,
                                  ReferenceDataAuditCode.SERVICE_INSTANCE_FAILURE.getMessageDefinition(error.getMessage()),
                                  viewServiceConfig.toString(),
                                  error);

            super.throwUnexpectedInitializationException(actionDescription,
                                                         ViewServiceDescription.REFERENCE_DATA.getViewServiceFullName(),
                                                         error);
        }
    }

    /**
     * Shutdown the Reference Data service.
     */
    @Override
    public void shutdown()
    {
        final String actionDescription = "shutdown";

        auditLog.logMessage(actionDescription, ReferenceDataAuditCode.SERVICE_TERMINATING.getMessageDefinition(serverName));

        if (instance != null)
        {
            this.instance.shutdown();
        }

        auditLog.logMessage(actionDescription, ReferenceDataAuditCode.SERVICE_SHUTDOWN.getMessageDefinition(serverName));
    }
}