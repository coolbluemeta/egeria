/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworkservices.omf.server;


import org.odpi.openmetadata.adminservices.configuration.registration.CommonServicesDescription;
import org.odpi.openmetadata.commonservices.generichandlers.*;
import org.odpi.openmetadata.commonservices.generichandlers.ElementHeaderConverter;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.ElementHeader;
import org.odpi.openmetadata.frameworks.openmetadata.properties.MetadataCorrelationHeader;
import org.odpi.openmetadata.frameworks.openmetadata.properties.OpenMetadataElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.ValidMetadataValue;
import org.odpi.openmetadata.frameworks.openmetadata.properties.ValidMetadataValueDetail;
import org.odpi.openmetadata.frameworkservices.omf.converters.*;
import org.odpi.openmetadata.frameworkservices.omf.converters.MetadataElementConverter;
import org.odpi.openmetadata.frameworkservices.omf.ffdc.OpenMetadataStoreErrorCode;
import org.odpi.openmetadata.frameworkservices.omf.handlers.MetadataElementHandler;
import org.odpi.openmetadata.commonservices.multitenant.OMASServiceInstance;
import org.odpi.openmetadata.commonservices.multitenant.ffdc.exceptions.NewInstanceException;
import org.odpi.openmetadata.frameworks.auditlog.AuditLog;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryConnector;

/**
 * omfMetadataManagementInstance caches references to OMRS objects for a specific server.
 * It is also responsible for registering itself in the instance map.
 * It is created by the admin class during server start up and
 */
public class OMFMetadataManagementInstance extends OMASServiceInstance
{
    private final static CommonServicesDescription myDescription = CommonServicesDescription.OMF_METADATA_MANAGEMENT;

    private final MetadataElementHandler<OpenMetadataElement>                            metadataElementHandler;
    private final ValidValuesHandler<ValidMetadataValue>                                 validMetadataValuesHandler;
    private final ValidValuesHandler<ValidMetadataValueDetail>                           validMetadataValuesDetailHandler;
    private final ExternalIdentifierHandler<MetadataCorrelationHeader, ElementHeader> externalIdentifierHandler;

    /**
     * Set up the local repository connector that will service the REST Calls.
     *
     * @param repositoryConnector link to the repository responsible for servicing the REST calls.
     * @param auditLog logging destination
     * @param localServerUserId userId used for server initiated actions
     * @param maxPageSize max number of results to return on single request.
     *
     * @throws NewInstanceException a problem occurred during initialization
     */
    public OMFMetadataManagementInstance(OMRSRepositoryConnector repositoryConnector,
                                         AuditLog                auditLog,
                                         String                  localServerUserId,
                                         int                     maxPageSize) throws NewInstanceException
    {
        super(myDescription.getServiceName(),
              repositoryConnector,
              null,
              null,
              null,
              auditLog,
              localServerUserId,
              maxPageSize,
              null,
              null,
              null,
              null);

        final String methodName = "new ServiceInstance";

        if (repositoryHandler != null)
        {
            this.metadataElementHandler = new MetadataElementHandler<>(new MetadataElementConverter<>(repositoryHelper, serviceName, serverName),
                                                                       OpenMetadataElement.class,
                                                                       serviceName,
                                                                       serverName,
                                                                       invalidParameterHandler,
                                                                       repositoryHandler,
                                                                       repositoryHelper,
                                                                       localServerUserId,
                                                                       securityVerifier,
                                                                       supportedZones,
                                                                       defaultZones,
                                                                       publishZones,
                                                                       auditLog);


            this.validMetadataValuesHandler = new ValidValuesHandler<>(new ValidMetadataValueConverter<>(repositoryHelper, serviceName, serverName),
                                                                       ValidMetadataValue.class,
                                                                       serviceName,
                                                                       serverName,
                                                                       invalidParameterHandler,
                                                                       repositoryHandler,
                                                                       repositoryHelper,
                                                                       localServerUserId,
                                                                       securityVerifier,
                                                                       supportedZones,
                                                                       defaultZones,
                                                                       publishZones,
                                                                       auditLog);

            this.validMetadataValuesDetailHandler = new ValidValuesHandler<>(new ValidMetadataValueConverter<>(repositoryHelper, serviceName, serverName),
                                                                             ValidMetadataValueDetail.class,
                                                                             serviceName,
                                                                             serverName,
                                                                             invalidParameterHandler,
                                                                             repositoryHandler,
                                                                             repositoryHelper,
                                                                             localServerUserId,
                                                                             securityVerifier,
                                                                             supportedZones,
                                                                             defaultZones,
                                                                             publishZones,
                                                                             auditLog);

            this.externalIdentifierHandler = new ExternalIdentifierHandler<>(new ExternalIdentifierConverter<>(repositoryHelper, serviceName, serverName),
                                                                             MetadataCorrelationHeader.class,
                                                                             new ElementHeaderConverter<>(repositoryHelper, serviceName, serverName),
                                                                             ElementHeader.class,
                                                                             serviceName,
                                                                             serverName,
                                                                             invalidParameterHandler,
                                                                             repositoryHandler,
                                                                             repositoryHelper,
                                                                             localServerUserId,
                                                                             securityVerifier,
                                                                             supportedZones,
                                                                             defaultZones,
                                                                             publishZones,
                                                                             auditLog);

        }
        else
        {
            throw new NewInstanceException(OpenMetadataStoreErrorCode.OMRS_NOT_INITIALIZED.getMessageDefinition(methodName),
                                           this.getClass().getName(),
                                           methodName);
        }
    }


    /**
     * Return the handler for open metadata store requests.
     *
     * @return handler object
     */
    public MetadataElementHandler<OpenMetadataElement> getMetadataElementHandler()
    {
        return metadataElementHandler;
    }

    /**
     * Return the handler for open metadata store requests.
     *
     * @return handler object
     */
    public ValidValuesHandler<ValidMetadataValue> getValidMetadataValuesHandler()
    {
        return validMetadataValuesHandler;
    }

    /**
     * Return the handler for reference data requests.
     *
     * @return handler object
     */
    public ValidValuesHandler<ValidMetadataValueDetail> getValidMetadataValuesDetailHandler()
    {
        return validMetadataValuesDetailHandler;
    }


    /**
     * Return the handler for external identifiers requests.
     *
     * @return handler object
     */
    public ExternalIdentifierHandler<MetadataCorrelationHeader, ElementHeader> getExternalIdentifierHandler()
    {
        return externalIdentifierHandler;
    }
}
