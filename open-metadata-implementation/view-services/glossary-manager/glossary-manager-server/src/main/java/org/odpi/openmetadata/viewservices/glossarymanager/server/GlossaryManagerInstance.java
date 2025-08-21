/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.viewservices.glossarymanager.server;

import org.odpi.openmetadata.commonservices.multitenant.OMVSServiceInstance;
import org.odpi.openmetadata.adminservices.configuration.registration.ViewServiceDescription;
import org.odpi.openmetadata.frameworks.auditlog.AuditLog;
import org.odpi.openmetadata.frameworks.openmetadata.client.OpenMetadataClient;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.openmetadata.handlers.CollectionHandler;
import org.odpi.openmetadata.frameworks.openmetadata.handlers.GlossaryTermHandler;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;
import org.odpi.openmetadata.frameworkservices.omf.client.handlers.EgeriaOpenMetadataStoreHandler;

/**
 * GlossaryManagerInstance caches references to objects it needs for a specific server.
 * It is also responsible for registering itself in the instance map.
 */

public class GlossaryManagerInstance extends OMVSServiceInstance
{
    private static final ViewServiceDescription myDescription = ViewServiceDescription.GLOSSARY_MANAGER;

    private final CollectionHandler   glossaryHandler;
    private final GlossaryTermHandler glossaryTermHandler;

    /**
     * Set up the Glossary Manager OMVS instance*
     * @param serverName name of this server
     * @param auditLog logging destination
     * @param localServerUserId user id to use on OMRS calls where there is no end user, or as part of an HTTP authentication mechanism with serverUserPassword.
     * @param localServerUserPassword password to use as part of an HTTP authentication mechanism.
     * @param maxPageSize maximum page size
     * @param remoteServerName  remote server name
     * @param remoteServerURL remote server URL
     * @throws InvalidParameterException problem with server name or platform URL
     */
    public GlossaryManagerInstance(String       serverName,
                                   AuditLog     auditLog,
                                   String       localServerUserId,
                                   String       localServerUserPassword,
                                   int          maxPageSize,
                                   String       remoteServerName,
                                   String       remoteServerURL) throws InvalidParameterException
    {
        super(serverName,
              myDescription.getViewServiceFullName(),
              auditLog,
              localServerUserId,
              localServerUserPassword,
              maxPageSize,
              remoteServerName,
              remoteServerURL);

        OpenMetadataClient openMetadataClient;
        if (localServerUserPassword == null)
        {
            openMetadataClient = new EgeriaOpenMetadataStoreHandler(remoteServerName,
                                                                    remoteServerURL,
                                                                    maxPageSize);

        }
        else
        {
            openMetadataClient = new EgeriaOpenMetadataStoreHandler(remoteServerName,
                                                                    remoteServerURL,
                                                                    localServerUserId,
                                                                    localServerUserPassword,
                                                                    maxPageSize);
        }

        glossaryHandler = new CollectionHandler(serverName,
                                                auditLog,
                                                myDescription.getViewServiceFullName(),
                                                openMetadataClient,
                                                OpenMetadataType.GLOSSARY.typeName);

        glossaryTermHandler = new GlossaryTermHandler(serverName,
                                                      auditLog,
                                                      myDescription.getViewServiceFullName(),
                                                      openMetadataClient);
    }


    /**
     * Return the glossary handler.
     *
     * @return client
     */
    public CollectionHandler getGlossaryHandler()
    {
        return glossaryHandler;
    }



    /**
     * Return the glossary term handler.
     *
     * @return client
     */
    public GlossaryTermHandler getGlossaryTermHandler()
    {
        return glossaryTermHandler;
    }

}
