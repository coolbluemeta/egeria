/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project */
/* Copyright Contributors to the ODPi Egeria category. */
package org.odpi.openmetadata.viewservices.classificationexplorer.server;

import org.odpi.openmetadata.commonservices.ffdc.RESTCallLogger;
import org.odpi.openmetadata.commonservices.ffdc.RESTCallToken;
import org.odpi.openmetadata.commonservices.ffdc.RESTExceptionHandler;
import org.odpi.openmetadata.commonservices.ffdc.rest.*;
import org.odpi.openmetadata.frameworks.auditlog.AuditLog;
import org.odpi.openmetadata.frameworks.openmetadata.enums.GlossaryTermAssignmentStatus;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.MetadataRelationshipSummaryList;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.RelatedMetadataElementSummaryList;
import org.odpi.openmetadata.frameworks.openmetadata.properties.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.governance.FindAssetOriginProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.governance.LevelIdentifierQueryProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.governance.SemanticAssignmentQueryProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.schema.DataFieldQueryProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.security.SecurityTagQueryProperties;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataProperty;
import org.odpi.openmetadata.tokencontroller.TokenController;
import org.odpi.openmetadata.viewservices.classificationexplorer.handler.StewardshipManagementHandler;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 * The ClassificationExplorerRESTServices provides the implementation of the Classification Explorer Open Metadata View Service (OMVS).
 * This interface provides view interfaces for glossary UIs.
 */

public class ClassificationExplorerRESTServices extends TokenController
{
    private static final ClassificationExplorerInstanceHandler instanceHandler = new ClassificationExplorerInstanceHandler();

    private static final RESTExceptionHandler restExceptionHandler = new RESTExceptionHandler();

    private static final RESTCallLogger restCallLogger = new RESTCallLogger(LoggerFactory.getLogger(ClassificationExplorerRESTServices.class),
                                                                            instanceHandler.getServiceName());


    /**
     * Default constructor
     */
    public ClassificationExplorerRESTServices()
    {
    }


    /**
     * Return information about the elements classified with the data field classification.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom    index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for the request
     *
     * @return void or
     *      InvalidParameterException full path or userId is null or
     *      PropertyServerException problem accessing property server or
     *      UserNotAuthorizedException security access problem
     */
    public MetadataElementSummariesResponse getDataFieldClassifiedElements(String                   serverName,
                                                                           String                   urlMarker,
                                                                           int                      startFrom,
                                                                           int                      pageSize,
                                                                           boolean                  forLineage,
                                                                           boolean                  forDuplicateProcessing,
                                                                           DataFieldQueryProperties requestBody)
    {
        final String methodName = "getDataFieldClassifiedElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog                         auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                response.setElements(handler.getDataFieldClassifiedElements(userId,
                                                                            requestBody.getDefaultValue(),
                                                                            requestBody.getSampleValues(),
                                                                            requestBody.getDataPattern(),
                                                                            requestBody.getNamePattern(),
                                                                            requestBody.getOpenMetadataTypeName(),
                                                                            requestBody.getLimitResultsByStatus(),
                                                                            requestBody.getAsOfTime(),
                                                                            requestBody.getSequencingProperty(),
                                                                            requestBody.getSequencingOrder(),
                                                                            startFrom,
                                                                            pageSize,
                                                                            requestBody.getEffectiveTime(),
                                                                            forLineage,
                                                                            forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getDataFieldClassifiedElements(userId,
                                                                            null,
                                                                            null,
                                                                            null,
                                                                            null,
                                                                            null,
                                                                            null,
                                                                            null,
                                                                            null,
                                                                            null,
                                                                            startFrom,
                                                                            pageSize,
                                                                            new Date(),
                                                                            forLineage,
                                                                            forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Return information about the elements classified with the confidence classification.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom    index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for the request
     *
     * @return void or
     *      InvalidParameterException full path or userId is null or
     *      PropertyServerException problem accessing property server or
     *      UserNotAuthorizedException security access problem
     */
    public MetadataElementSummariesResponse getConfidenceClassifiedElements(String                         serverName,
                                                                            String                         urlMarker,
                                                                            int                            startFrom,
                                                                            int                            pageSize,
                                                                            boolean                        forLineage,
                                                                            boolean                        forDuplicateProcessing,
                                                                            LevelIdentifierQueryProperties requestBody)
    {
        final String methodName = "getConfidenceClassifiedElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                response.setElements(handler.getConfidenceClassifiedElements(userId,
                                                                             requestBody.getReturnSpecificLevel(),
                                                                             requestBody.getLevelIdentifier(),
                                                                             requestBody.getOpenMetadataTypeName(),
                                                                             requestBody.getLimitResultsByStatus(),
                                                                             requestBody.getAsOfTime(),
                                                                             requestBody.getSequencingProperty(),
                                                                             requestBody.getSequencingOrder(),
                                                                             startFrom,
                                                                             pageSize,
                                                                             requestBody.getEffectiveTime(),
                                                                             forLineage,
                                                                             forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getConfidenceClassifiedElements(userId,
                                                                             false,
                                                                             0,
                                                                             null,
                                                                             null,
                                                                             null,
                                                                             null,
                                                                             null,
                                                                             startFrom,
                                                                             pageSize,
                                                                             new Date(),
                                                                             forLineage,
                                                                             forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Return information about the elements classified with the criticality classification.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom    index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for the request
     *
     * @return void or
     *      InvalidParameterException full path or userId is null or
     *      PropertyServerException problem accessing property server or
     *      UserNotAuthorizedException security access problem
     */
    public MetadataElementSummariesResponse getCriticalityClassifiedElements(String                         serverName,
                                                                             String                         urlMarker,
                                                                             int                            startFrom,
                                                                             int                            pageSize,
                                                                             boolean                        forLineage,
                                                                             boolean                        forDuplicateProcessing,
                                                                             LevelIdentifierQueryProperties requestBody)
    {
        final String methodName = "getCriticalityClassifiedElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                response.setElements(handler.getCriticalityClassifiedElements(userId,
                                                                              requestBody.getReturnSpecificLevel(),
                                                                              requestBody.getLevelIdentifier(),
                                                                              requestBody.getOpenMetadataTypeName(),
                                                                              requestBody.getLimitResultsByStatus(),
                                                                              requestBody.getAsOfTime(),
                                                                              requestBody.getSequencingProperty(),
                                                                              requestBody.getSequencingOrder(),
                                                                              startFrom,
                                                                              pageSize,
                                                                              requestBody.getEffectiveTime(),
                                                                              forLineage,
                                                                              forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getCriticalityClassifiedElements(userId,
                                                                              false,
                                                                              0,
                                                                              null,
                                                                              null,
                                                                              null,
                                                                              null,
                                                                              null,
                                                                              startFrom,
                                                                              pageSize,
                                                                              new Date(),
                                                                              forLineage,
                                                                              forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Return information about the elements classified with the confidentiality classification.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom    index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for the request
     *
     * @return void or
     *      InvalidParameterException full path or userId is null or
     *      PropertyServerException problem accessing property server or
     *      UserNotAuthorizedException security access problem
     */
    public MetadataElementSummariesResponse getConfidentialityClassifiedElements(String                         serverName,
                                                                                 String                         urlMarker,
                                                                                 int                            startFrom,
                                                                                 int                            pageSize,
                                                                                 boolean                        forLineage,
                                                                                 boolean                        forDuplicateProcessing,
                                                                                 LevelIdentifierQueryProperties requestBody)
    {
        final String methodName = "getConfidentialityClassifiedElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                response.setElements(handler.getConfidentialityClassifiedElements(userId,
                                                                                  requestBody.getReturnSpecificLevel(),
                                                                                  requestBody.getLevelIdentifier(),
                                                                                  requestBody.getOpenMetadataTypeName(),
                                                                                  requestBody.getLimitResultsByStatus(),
                                                                                  requestBody.getAsOfTime(),
                                                                                  requestBody.getSequencingProperty(),
                                                                                  requestBody.getSequencingOrder(),
                                                                                  startFrom,
                                                                                  pageSize,
                                                                                  requestBody.getEffectiveTime(),
                                                                                  forLineage,
                                                                                  forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getConfidentialityClassifiedElements(userId,
                                                                                  false,
                                                                                  0,
                                                                                  null,
                                                                                  null,
                                                                                  null,
                                                                                  null,
                                                                                  null,
                                                                                  startFrom,
                                                                                  pageSize,
                                                                                  new Date(),
                                                                                  forLineage,
                                                                                  forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Return information about the elements classified with the confidence classification.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom    index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for the request
     *
     * @return void or
     *      InvalidParameterException full path or userId is null or
     *      PropertyServerException problem accessing property server or
     *      UserNotAuthorizedException security access problem
     */
    public MetadataElementSummariesResponse getRetentionClassifiedElements(String                         serverName,
                                                                           String                         urlMarker,
                                                                           int                            startFrom,
                                                                           int                            pageSize,
                                                                           boolean                        forLineage,
                                                                           boolean                        forDuplicateProcessing,
                                                                           LevelIdentifierQueryProperties requestBody)
    {
        final String methodName = "getRetentionClassifiedElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                response.setElements(handler.getRetentionClassifiedElements(userId,
                                                                            requestBody.getReturnSpecificLevel(),
                                                                            requestBody.getLevelIdentifier(),
                                                                            requestBody.getOpenMetadataTypeName(),
                                                                            requestBody.getLimitResultsByStatus(),
                                                                            requestBody.getAsOfTime(),
                                                                            requestBody.getSequencingProperty(),
                                                                            requestBody.getSequencingOrder(),
                                                                            startFrom,
                                                                            pageSize,
                                                                            requestBody.getEffectiveTime(),
                                                                            forLineage,
                                                                            forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getRetentionClassifiedElements(userId,
                                                                            false,
                                                                            0,
                                                                            null,
                                                                            null,
                                                                            null,
                                                                            null,
                                                                            null,
                                                                            startFrom,
                                                                            pageSize,
                                                                            new Date(),
                                                                            forLineage,
                                                                            forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Return information about the elements classified with the security tags classification.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom    index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for the request
     *
     * @return void or
     *      InvalidParameterException full path or userId is null or
     *      PropertyServerException problem accessing property server or
     *      UserNotAuthorizedException security access problem
     */
    public MetadataElementSummariesResponse getSecurityTaggedElements(String                     serverName,
                                                                      String                     urlMarker,
                                                                      int                        startFrom,
                                                                      int                        pageSize,
                                                                      boolean                    forLineage,
                                                                      boolean                    forDuplicateProcessing,
                                                                      SecurityTagQueryProperties requestBody)
    {
        final String methodName = "getSecurityTaggedElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                response.setElements(handler.getSecurityTaggedElements(userId,
                                                                       requestBody.getSecurityLabels(),
                                                                       requestBody.getSecurityProperties(),
                                                                       requestBody.getAccessGroups(),
                                                                       requestBody.getOpenMetadataTypeName(),
                                                                       requestBody.getLimitResultsByStatus(),
                                                                       requestBody.getAsOfTime(),
                                                                       requestBody.getSequencingProperty(),
                                                                       requestBody.getSequencingOrder(),
                                                                       startFrom,
                                                                       pageSize,
                                                                       requestBody.getEffectiveTime(),
                                                                       forLineage,
                                                                       forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getSecurityTaggedElements(userId,
                                                                       null,
                                                                       null,
                                                                       null,
                                                                       null,
                                                                       null,
                                                                       null,
                                                                       null,
                                                                       null,
                                                                       startFrom,
                                                                       pageSize,
                                                                       new Date(),
                                                                       forLineage,
                                                                       forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Return information about the elements classified with the confidence classification.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom    index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for the request
     *
     * @return void or
     *      InvalidParameterException full path or userId is null or
     *      PropertyServerException problem accessing property server or
     *      UserNotAuthorizedException security access problem
     */
    public MetadataElementSummariesResponse getOwnersElements(String             serverName,
                                                              String             urlMarker,
                                                              int                startFrom,
                                                              int                pageSize,
                                                              boolean            forLineage,
                                                              boolean            forDuplicateProcessing,
                                                              FindNameProperties requestBody)
    {
        final String methodName = "getOwnersElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                response.setElements(handler.getOwnersElements(userId,
                                                               requestBody.getName(),
                                                               requestBody.getOpenMetadataTypeName(),
                                                               requestBody.getLimitResultsByStatus(),
                                                               requestBody.getAsOfTime(),
                                                               requestBody.getSequencingProperty(),
                                                               requestBody.getSequencingOrder(),
                                                               startFrom,
                                                               pageSize,
                                                               requestBody.getEffectiveTime(),
                                                               forLineage,
                                                               forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getOwnersElements(userId,
                                                               null,
                                                               null,
                                                               null,
                                                               null,
                                                               null,
                                                               null,
                                                               startFrom,
                                                               pageSize,
                                                               new Date(),
                                                               forLineage,
                                                               forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Return information about the elements classified with the confidence classification.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom    index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for the request
     *
     * @return void or
     *      InvalidParameterException full path or userId is null or
     *      PropertyServerException problem accessing property server or
     *      UserNotAuthorizedException security access problem
     */
    public MetadataElementSummariesResponse getMembersOfSubjectArea(String             serverName,
                                                                    String             urlMarker,
                                                                    int                startFrom,
                                                                    int                pageSize,
                                                                    boolean            forLineage,
                                                                    boolean            forDuplicateProcessing,
                                                                    FindNameProperties requestBody)
    {
        final String methodName = "getMembersOfSubjectArea";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                response.setElements(handler.getMembersOfSubjectArea(userId,
                                                                     requestBody.getName(),
                                                                     requestBody.getOpenMetadataTypeName(),
                                                                     requestBody.getLimitResultsByStatus(),
                                                                     requestBody.getAsOfTime(),
                                                                     requestBody.getSequencingProperty(),
                                                                     requestBody.getSequencingOrder(),
                                                                     startFrom,
                                                                     pageSize,
                                                                     requestBody.getEffectiveTime(),
                                                                     forLineage,
                                                                     forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getMembersOfSubjectArea(userId,
                                                                     null,
                                                                     null,
                                                                     null,
                                                                     null,
                                                                     null,
                                                                     null,
                                                                     startFrom,
                                                                     pageSize,
                                                                     new Date(),
                                                                     forLineage,
                                                                     forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Return information about the assets from a specific origin.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom    index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for the request
     *
     * @return void or
     *      InvalidParameterException full path or userId is null or
     *      PropertyServerException problem accessing property server or
     *      UserNotAuthorizedException security access problem
     */
    public MetadataElementSummariesResponse getAssetsByOrigin(String                    serverName,
                                                              String                    urlMarker,
                                                              int                       startFrom,
                                                              int                       pageSize,
                                                              boolean                   forLineage,
                                                              boolean                   forDuplicateProcessing,
                                                              FindAssetOriginProperties requestBody)
    {
        final String methodName = "getAssetsByOrigin";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                response.setElements(handler.getAssetsByOrigin(userId,
                                                               requestBody.getOrganizationGUID(),
                                                               requestBody.getBusinessCapabilityGUID(),
                                                               requestBody.getOtherOriginValues(),
                                                               requestBody.getOpenMetadataTypeName(),
                                                               requestBody.getLimitResultsByStatus(),
                                                               requestBody.getAsOfTime(),
                                                               requestBody.getSequencingProperty(),
                                                               requestBody.getSequencingOrder(),
                                                               startFrom,
                                                               pageSize,
                                                               requestBody.getEffectiveTime(),
                                                               forLineage,
                                                               forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getAssetsByOrigin(userId,
                                                               null,
                                                               null,
                                                               null,
                                                               null,
                                                               null,
                                                               null,
                                                               null,
                                                               null,
                                                               startFrom,
                                                               pageSize,
                                                               new Date(),
                                                               forLineage,
                                                               forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve the glossary terms linked via a "SemanticAssignment" relationship to the requested element.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param elementGUID unique identifier of the element that is being assigned to the glossary term
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for relationship request
     *
     * @return void or
     * InvalidParameterException full path or userId is null or
     * PropertyServerException problem accessing property server or
     * UserNotAuthorizedException security access problem
     */
    public RelatedMetadataElementSummariesResponse getMeanings(String                            serverName,
                                                               String                            urlMarker,
                                                               String                            elementGUID,
                                                               int                               startFrom,
                                                               int                               pageSize,
                                                               boolean                           forLineage,
                                                               boolean                           forDuplicateProcessing,
                                                               SemanticAssignmentQueryProperties requestBody)
    {
        final String methodName = "getMeanings";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        RelatedMetadataElementSummariesResponse response = new RelatedMetadataElementSummariesResponse();
        AuditLog                                auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                RelatedMetadataElementSummaryList summaryList = handler.getMeanings(userId,
                                                                                    elementGUID,
                                                                                    requestBody.getExpression(),
                                                                                    requestBody.getDescription(),
                                                                                    requestBody.getStatus(),
                                                                                    requestBody.getReturnSpecificConfidence(),
                                                                                    requestBody.getConfidence(),
                                                                                    requestBody.getCreatedBy(),
                                                                                    requestBody.getSteward(),
                                                                                    requestBody.getSource(),
                                                                                    requestBody.getOpenMetadataTypeName(),
                                                                                    requestBody.getLimitResultsByStatus(),
                                                                                    requestBody.getAsOfTime(),
                                                                                    requestBody.getSequencingProperty(),
                                                                                    requestBody.getSequencingOrder(),
                                                                                    startFrom,
                                                                                    pageSize,
                                                                                    requestBody.getEffectiveTime(),
                                                                                    forLineage,
                                                                                    forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
            else
            {
                RelatedMetadataElementSummaryList summaryList = handler.getMeanings(userId,
                                                                                    elementGUID,
                                                                                    null,
                                                                                    null,
                                                                                    GlossaryTermAssignmentStatus.VALIDATED,
                                                                                    false,
                                                                                    0,
                                                                                    null,
                                                                                    null,
                                                                                    null,
                                                                                    null,
                                                                                    null,
                                                                                    null,
                                                                                    null,
                                                                                    null,
                                                                                    startFrom,
                                                                                    pageSize,
                                                                                    new Date(),
                                                                                    forLineage,
                                                                                    forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve the glossary terms linked via a "SemanticAssignment" relationship to the requested element.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param glossaryTermGUID unique identifier of the glossary term that the returned elements are linked to
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for relationship request
     *
     * @return void or
     * InvalidParameterException full path or userId is null or
     * PropertyServerException problem accessing property server or
     * UserNotAuthorizedException security access problem
     */
    public RelatedMetadataElementSummariesResponse getSemanticAssignees(String                            serverName,
                                                                        String                            urlMarker,
                                                                        String                            glossaryTermGUID,
                                                                        int                               startFrom,
                                                                        int                               pageSize,
                                                                        boolean                           forLineage,
                                                                        boolean                           forDuplicateProcessing,
                                                                        SemanticAssignmentQueryProperties requestBody)
    {
        final String methodName = "getSemanticAssignees";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        RelatedMetadataElementSummariesResponse response = new RelatedMetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody != null)
            {
                RelatedMetadataElementSummaryList summaryList = handler.getSemanticAssignees(userId,
                                                                                             glossaryTermGUID,
                                                                                             requestBody.getExpression(),
                                                                                             requestBody.getDescription(),
                                                                                             requestBody.getStatus(),
                                                                                             requestBody.getReturnSpecificConfidence(),
                                                                                             requestBody.getConfidence(),
                                                                                             requestBody.getCreatedBy(),
                                                                                             requestBody.getSteward(),
                                                                                             requestBody.getSource(),
                                                                                             requestBody.getOpenMetadataTypeName(),
                                                                                             requestBody.getLimitResultsByStatus(),
                                                                                             requestBody.getAsOfTime(),
                                                                                             requestBody.getSequencingProperty(),
                                                                                             requestBody.getSequencingOrder(),
                                                                                             startFrom,
                                                                                             pageSize,
                                                                                             requestBody.getEffectiveTime(),
                                                                                             forLineage,
                                                                                             forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
            else
            {
                RelatedMetadataElementSummaryList summaryList = handler.getSemanticAssignees(userId,
                                                                                             glossaryTermGUID,
                                                                                             null,
                                                                                             null,
                                                                                             GlossaryTermAssignmentStatus.VALIDATED,
                                                                                             false,
                                                                                             0,
                                                                                             null,
                                                                                             null,
                                                                                             null,
                                                                                             null,
                                                                                             null,
                                                                                             null,
                                                                                             null,
                                                                                             null,
                                                                                             startFrom,
                                                                                             pageSize,
                                                                                             new Date(),
                                                                                             forLineage,
                                                                                             forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve the governance definitions linked via a "GovernedBy" relationship to the requested element.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param governanceDefinitionGUID unique identifier of the governance definition that the returned elements are linked to
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for relationship request
     *
     * @return void or
     * InvalidParameterException full path or userId is null or
     * PropertyServerException problem accessing property server or
     * UserNotAuthorizedException security access problem
     */
    public RelatedMetadataElementSummariesResponse getGovernedElements(String         serverName,
                                                                       String         urlMarker,
                                                                       String         governanceDefinitionGUID,
                                                                       int            startFrom,
                                                                       int            pageSize,
                                                                       boolean        forLineage,
                                                                       boolean        forDuplicateProcessing,
                                                                       FindProperties requestBody)
    {
        final String methodName = "getGovernedElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        RelatedMetadataElementSummariesResponse response = new RelatedMetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                RelatedMetadataElementSummaryList summaryList = handler.getGovernedElements(userId,
                                                                                            governanceDefinitionGUID,
                                                                                            null,
                                                                                            null,
                                                                                            null,
                                                                                            null,
                                                                                            null,
                                                                                            startFrom,
                                                                                            pageSize,
                                                                                            new Date(),
                                                                                            forLineage,
                                                                                            forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
            else
            {
                RelatedMetadataElementSummaryList summaryList = handler.getGovernedElements(userId,
                                                                                            governanceDefinitionGUID,
                                                                                            requestBody.getOpenMetadataTypeName(),
                                                                                            requestBody.getLimitResultsByStatus(),
                                                                                            requestBody.getAsOfTime(),
                                                                                            requestBody.getSequencingProperty(),
                                                                                            requestBody.getSequencingOrder(),
                                                                                            startFrom,
                                                                                            pageSize,
                                                                                            requestBody.getEffectiveTime(),
                                                                                            forLineage,
                                                                                            forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve the elements linked via a "GovernedBy" relationship to the requested governance definition.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param elementGUID unique identifier of the element that the returned elements are linked to
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for relationship request
     *
     * @return void or
     * InvalidParameterException full path or userId is null or
     * PropertyServerException problem accessing property server or
     * UserNotAuthorizedException security access problem
     */
    public RelatedMetadataElementSummariesResponse getGovernedByDefinitions(String         serverName,
                                                                            String         urlMarker,
                                                                            String         elementGUID,
                                                                            int            startFrom,
                                                                            int            pageSize,
                                                                            boolean        forLineage,
                                                                            boolean        forDuplicateProcessing,
                                                                            FindProperties requestBody)
    {
        final String methodName = "getGovernedByDefinitions";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        RelatedMetadataElementSummariesResponse response = new RelatedMetadataElementSummariesResponse();
        AuditLog                                auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                RelatedMetadataElementSummaryList summaryList = handler.getGovernedByDefinitions(userId,
                                                                                                 elementGUID,
                                                                                                 null,
                                                                                                 null,
                                                                                                 null,
                                                                                                 null,
                                                                                                 null,
                                                                                                 startFrom,
                                                                                                 pageSize,
                                                                                                 new Date(),
                                                                                                 forLineage,
                                                                                                 forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
            else
            {
                RelatedMetadataElementSummaryList summaryList = handler.getGovernedByDefinitions(userId,
                                                                                                 elementGUID,
                                                                                                 requestBody.getOpenMetadataTypeName(),
                                                                                                 requestBody.getLimitResultsByStatus(),
                                                                                                 requestBody.getAsOfTime(),
                                                                                                 requestBody.getSequencingProperty(),
                                                                                                 requestBody.getSequencingOrder(),
                                                                                                 startFrom,
                                                                                                 pageSize,
                                                                                                 requestBody.getEffectiveTime(),
                                                                                                 forLineage,
                                                                                                 forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve the elements linked via a "SourcedFrom" relationship to the requested element.
     * The elements returned were used to create the requested element.  Typically only one element is returned.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param elementGUID unique identifier of the governance definition that the returned elements are linked to
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for relationship request
     *
     * @return void or
     * InvalidParameterException full path or userId is null or
     * PropertyServerException problem accessing property server or
     * UserNotAuthorizedException security access problem
     */
    public RelatedMetadataElementSummariesResponse getSourceElements(String         serverName,
                                                                     String         urlMarker,
                                                                     String         elementGUID,
                                                                     int            startFrom,
                                                                     int            pageSize,
                                                                     boolean        forLineage,
                                                                     boolean        forDuplicateProcessing,
                                                                     FindProperties requestBody)
    {
        final String methodName = "getSourceElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        RelatedMetadataElementSummariesResponse response = new RelatedMetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                RelatedMetadataElementSummaryList summaryList = handler.getSourceElements(userId,
                                                                                          elementGUID,
                                                                                          null,
                                                                                          null,
                                                                                          null,
                                                                                          null,
                                                                                          null,
                                                                                          startFrom,
                                                                                          pageSize,
                                                                                          new Date(),
                                                                                          forLineage,
                                                                                          forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
            else
            {
                RelatedMetadataElementSummaryList summaryList = handler.getSourceElements(userId,
                                                                                          elementGUID,
                                                                                          requestBody.getOpenMetadataTypeName(),
                                                                                          requestBody.getLimitResultsByStatus(),
                                                                                          requestBody.getAsOfTime(),
                                                                                          requestBody.getSequencingProperty(),
                                                                                          requestBody.getSequencingOrder(),
                                                                                          startFrom,
                                                                                          pageSize,
                                                                                          requestBody.getEffectiveTime(),
                                                                                          forLineage,
                                                                                          forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve the elements linked via a "SourcedFrom" relationship to the requested element.
     * The elements returned were created using the requested element as a template.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param elementGUID unique identifier of the element that the returned elements are linked to
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody properties for relationship request
     *
     * @return void or
     * InvalidParameterException full path or userId is null or
     * PropertyServerException problem accessing property server or
     * UserNotAuthorizedException security access problem
     */
    public RelatedMetadataElementSummariesResponse getElementsSourcedFrom(String         serverName,
                                                                          String         urlMarker,
                                                                          String         elementGUID,
                                                                          int            startFrom,
                                                                          int            pageSize,
                                                                          boolean        forLineage,
                                                                          boolean        forDuplicateProcessing,
                                                                          FindProperties requestBody)
    {
        final String methodName = "getElementsSourceFrom";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        RelatedMetadataElementSummariesResponse response = new RelatedMetadataElementSummariesResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                RelatedMetadataElementSummaryList summaryList = handler.getElementsSourcedFrom(userId,
                                                                                               elementGUID,
                                                                                               null,
                                                                                               null,
                                                                                               null,
                                                                                               null,
                                                                                               null,
                                                                                               startFrom,
                                                                                               pageSize,
                                                                                               new Date(),
                                                                                               forLineage,
                                                                                               forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
            else
            {
                RelatedMetadataElementSummaryList summaryList = handler.getElementsSourcedFrom(userId,
                                                                                               elementGUID,
                                                                                               requestBody.getOpenMetadataTypeName(),
                                                                                               requestBody.getLimitResultsByStatus(),
                                                                                               requestBody.getAsOfTime(),
                                                                                               requestBody.getSequencingProperty(),
                                                                                               requestBody.getSequencingOrder(),
                                                                                               startFrom,
                                                                                               pageSize,
                                                                                               requestBody.getEffectiveTime(),
                                                                                               forLineage,
                                                                                               forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }



    /**
     * Retrieve the metadata element using its unique identifier.
     *
     * @param serverName     name of server instance to route request to
     * @param urlMarker  view service URL marker
     * @param elementGUID unique identifier for the metadata element
     * @param forLineage the retrieved element is for lineage processing so include archived elements
     * @param forDuplicateProcessing the retrieved element is for duplicate processing so do not combine results from known duplicates.
     * @param requestBody only return the element if it is effective at this time. Null means anytime. Use "new Date()" for now.
     *
     * @return metadata element properties or
     *  InvalidParameterException the unique identifier is null or not known.
     *  UserNotAuthorizedException the governance action service is not able to access the element
     *  PropertyServerException there is a problem accessing the metadata store
     */
    public MetadataElementSummaryResponse getMetadataElementByGUID(String      serverName,
                                                                   String      urlMarker,
                                                                   String      elementGUID,
                                                                   boolean     forLineage,
                                                                   boolean     forDuplicateProcessing,
                                                                   FindRequest requestBody)
    {
        final String methodName = "getMetadataElementByGUID";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummaryResponse response = new MetadataElementSummaryResponse();
        AuditLog                       auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                response.setElement(handler.getMetadataElementByGUID(userId,
                                                                     elementGUID,
                                                                     null,
                                                                     forLineage,
                                                                     forDuplicateProcessing,
                                                                     new Date()));
            }
            else
            {
                response.setElement(handler.getMetadataElementByGUID(userId,
                                                                     elementGUID,
                                                                     requestBody.getAsOfTime(),
                                                                     forLineage,
                                                                     forDuplicateProcessing,
                                                                     requestBody.getEffectiveTime()));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve the metadata element using its unique name (typically the qualified name).
     *
     * @param serverName     name of server instance to route request to
     * @param urlMarker  view service URL marker
     * @param forLineage the retrieved element is for lineage processing so include archived elements
     * @param forDuplicateProcessing the retrieved element is for duplicate processing so do not combine results from known duplicates.
     * @param requestBody unique name for the metadata element
     *
     * @return metadata element properties or
     *  InvalidParameterException the unique identifier is null or not known.
     *  UserNotAuthorizedException the governance action service is not able to access the element
     *  PropertyServerException there is a problem accessing the metadata store
     */
    public MetadataElementSummaryResponse getMetadataElementByUniqueName(String                     serverName,
                                                                         String                     urlMarker,
                                                                         boolean                    forLineage,
                                                                         boolean                    forDuplicateProcessing,
                                                                         FindPropertyNameProperties requestBody)
    {
        final String methodName = "getMetadataElementByUniqueName";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummaryResponse response = new MetadataElementSummaryResponse();
        AuditLog                       auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                restExceptionHandler.handleNoRequestBody(userId, methodName, serverName);
            }
            else if (requestBody.getPropertyName() == null)
            {
                response.setElement(handler.getMetadataElementByUniqueName(userId,
                                                                           requestBody.getPropertyValue(),
                                                                           OpenMetadataProperty.QUALIFIED_NAME.name,
                                                                           requestBody.getAsOfTime(),
                                                                           forLineage,
                                                                           forDuplicateProcessing,
                                                                           requestBody.getEffectiveTime()));
            }
            else
            {
                response.setElement(handler.getMetadataElementByUniqueName(userId,
                                                                           requestBody.getPropertyValue(),
                                                                           requestBody.getPropertyName(),
                                                                           requestBody.getAsOfTime(),
                                                                           forLineage,
                                                                           forDuplicateProcessing,
                                                                           requestBody.getEffectiveTime()));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve the unique identifier of a metadata element using its unique name (typically the qualified name).
     *
     * @param serverName     name of server instance to route request to
     * @param urlMarker  view service URL marker
     * @param forLineage the retrieved element is for lineage processing so include archived elements
     * @param forDuplicateProcessing the retrieved element is for duplicate processing so do not combine results from known duplicates.
     * @param requestBody unique name for the metadata element
     *
     * @return metadata element unique identifier (guid) or
     *  InvalidParameterException the unique identifier is null or not known or
     *  UserNotAuthorizedException the governance action service is not able to access the element or
     *  PropertyServerException there is a problem accessing the metadata store
     */
    public GUIDResponse getMetadataElementGUIDByUniqueName(String                     serverName,
                                                           String                     urlMarker,
                                                           boolean                    forLineage,
                                                           boolean                    forDuplicateProcessing,
                                                           FindPropertyNameProperties requestBody)
    {
        final String methodName = "getMetadataElementGUIDByUniqueName";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        GUIDResponse response = new GUIDResponse();
        AuditLog     auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                restExceptionHandler.handleNoRequestBody(userId, methodName, serverName);
            }
            else if (requestBody.getPropertyName() == null)
            {
                response.setGUID(handler.getMetadataElementGUIDByUniqueName(userId,
                                                                            requestBody.getPropertyValue(),
                                                                            OpenMetadataProperty.QUALIFIED_NAME.name,
                                                                            forLineage,
                                                                            forDuplicateProcessing,
                                                                            requestBody.getAsOfTime(),
                                                                            requestBody.getEffectiveTime()));
            }
            else
            {
                response.setGUID(handler.getMetadataElementGUIDByUniqueName(userId,
                                                                            requestBody.getPropertyValue(),
                                                                            requestBody.getPropertyName(),
                                                                            forLineage,
                                                                            forDuplicateProcessing,
                                                                            requestBody.getAsOfTime(),
                                                                            requestBody.getEffectiveTime()));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }



    /**
     * Retrieve elements of the requested type name.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody  open metadata type to search on
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public MetadataElementSummariesResponse getElements(String         serverName,
                                                        String         urlMarker,
                                                        int            startFrom,
                                                        int            pageSize,
                                                        boolean        forLineage,
                                                        boolean        forDuplicateProcessing,
                                                        FindProperties requestBody)
    {
        final String methodName = "getElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog                         auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                response.setElements(handler.getElements(userId,
                                                         null,
                                                         null,
                                                         null,
                                                         null,
                                                         null,
                                                         startFrom,
                                                         pageSize,
                                                         new Date(),
                                                         forLineage,
                                                         forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getElements(userId,
                                                         requestBody.getOpenMetadataTypeName(),
                                                         requestBody.getLimitResultsByStatus(),
                                                         requestBody.getAsOfTime(),
                                                         requestBody.getSequencingProperty(),
                                                         requestBody.getSequencingOrder(),
                                                         startFrom,
                                                         pageSize,
                                                         requestBody.getEffectiveTime(),
                                                         forLineage,
                                                         forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve elements by a value found in one of the properties specified.  The value must match exactly.
     * An open metadata type name may be supplied to restrict the results.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param requestBody properties and optional open metadata type to search on
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public MetadataElementSummariesResponse getElementsByPropertyValue(String                      serverName,
                                                                       String                      urlMarker,
                                                                       int                         startFrom,
                                                                       int                         pageSize,
                                                                       boolean                     forLineage,
                                                                       boolean                     forDuplicateProcessing,
                                                                       FindPropertyNamesProperties requestBody)
    {
        final String methodName = "getElementsByPropertyValue";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog                         auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                restExceptionHandler.handleNoRequestBody(userId, methodName, serverName);
            }
            else
            {
                response.setElements(handler.getElementsByPropertyValue(userId,
                                                                        requestBody.getPropertyValue(),
                                                                        requestBody.getPropertyNames(),
                                                                        requestBody.getOpenMetadataTypeName(),
                                                                        requestBody.getLimitResultsByStatus(),
                                                                        requestBody.getAsOfTime(),
                                                                        requestBody.getSequencingProperty(),
                                                                        requestBody.getSequencingOrder(),
                                                                        startFrom,
                                                                        pageSize,
                                                                        requestBody.getEffectiveTime(),
                                                                        forLineage,
                                                                        forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve elements by a value found in one of the properties specified.  The value must be contained in the
     * properties rather than needing to be an exact match.
     * An open metadata type name may be supplied to restrict the results.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param requestBody properties and optional open metadata type to search on
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public MetadataElementSummariesResponse findElementsByPropertyValue(String                       serverName,
                                                                        String                      urlMarker,
                                                                        int                          startFrom,
                                                                        int                          pageSize,
                                                                        boolean                      forLineage,
                                                                        boolean                      forDuplicateProcessing,
                                                                        FindPropertyNamesProperties requestBody)
    {
        final String methodName = "findElementsByPropertyValue";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog                         auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                restExceptionHandler.handleNoRequestBody(userId, methodName, serverName);
            }
            else
            {
                response.setElements(handler.findElementsByPropertyValue(userId,
                                                                         requestBody.getPropertyValue(),
                                                                         requestBody.getPropertyNames(),
                                                                         requestBody.getOpenMetadataTypeName(),
                                                                         requestBody.getLimitResultsByStatus(),
                                                                         requestBody.getAsOfTime(),
                                                                         requestBody.getSequencingProperty(),
                                                                         requestBody.getSequencingOrder(),
                                                                         startFrom,
                                                                         pageSize,
                                                                         requestBody.getEffectiveTime(),
                                                                         forLineage,
                                                                         forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve elements with the requested classification name. It is also possible to limit the results
     * by specifying a type name for the elements that should be returned. If no type name is specified then
     * any type of element may be returned.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param classificationName name of classification
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody  open metadata type to search on
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public MetadataElementSummariesResponse getElementsByClassification(String         serverName,
                                                                        String         urlMarker,
                                                                        String         classificationName,
                                                                        int            startFrom,
                                                                        int            pageSize,
                                                                        boolean        forLineage,
                                                                        boolean        forDuplicateProcessing,
                                                                        FindProperties requestBody)
    {
        final String methodName = "getElementsByClassification";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog                         auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                response.setElements(handler.getElementsByClassification(userId,
                                                                         classificationName,
                                                                         null,
                                                                         null,
                                                                         null,
                                                                         null,
                                                                         null,
                                                                         startFrom,
                                                                         pageSize,
                                                                         new Date(),
                                                                         forLineage,
                                                                         forDuplicateProcessing));
            }
            else
            {
                response.setElements(handler.getElementsByClassification(userId,
                                                                         classificationName,
                                                                         requestBody.getOpenMetadataTypeName(),
                                                                         requestBody.getLimitResultsByStatus(),
                                                                         requestBody.getAsOfTime(),
                                                                         requestBody.getSequencingProperty(),
                                                                         requestBody.getSequencingOrder(),
                                                                         startFrom,
                                                                         pageSize,
                                                                         requestBody.getEffectiveTime(),
                                                                         forLineage,
                                                                         forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve elements with the requested classification name and with the requested a value
     * found in one of the classification's properties specified.  The value must match exactly.
     * An open metadata type name may be supplied to restrict the types of elements returned.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param classificationName name of classification
     * @param requestBody properties and optional open metadata type to search on
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public MetadataElementSummariesResponse getElementsByClassificationWithPropertyValue(String                      serverName,
                                                                                         String                      urlMarker,
                                                                                         String                      classificationName,
                                                                                         int                         startFrom,
                                                                                         int                         pageSize,
                                                                                         boolean                     forLineage,
                                                                                         boolean                     forDuplicateProcessing,
                                                                                         FindPropertyNamesProperties requestBody)
    {
        final String methodName = "getElementsByClassificationWithPropertyValue";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog                         auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                restExceptionHandler.handleNoRequestBody(userId, methodName, serverName, FindPropertyNamesProperties.class.getName());
            }
            else
            {
                response.setElements(handler.getElementsByClassification(userId,
                                                                         classificationName,
                                                                         requestBody.getPropertyValue(),
                                                                         requestBody.getPropertyNames(),
                                                                         requestBody.getOpenMetadataTypeName(),
                                                                         requestBody.getLimitResultsByStatus(),
                                                                         requestBody.getAsOfTime(),
                                                                         requestBody.getSequencingProperty(),
                                                                         requestBody.getSequencingOrder(),
                                                                         startFrom,
                                                                         pageSize,
                                                                         requestBody.getEffectiveTime(),
                                                                         forLineage,
                                                                         forDuplicateProcessing,
                                                                         methodName));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve elements with the requested classification name and with the requested a value found in
     * one of the classification's properties specified.  The value must be contained in the
     * properties rather than needing to be an exact match.
     * An open metadata type name may be supplied to restrict the results.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param classificationName name of classification
     * @param requestBody properties and optional open metadata type to search on
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public MetadataElementSummariesResponse findElementsByClassificationWithPropertyValue(String                       serverName,
                                                                                          String                       urlMarker,
                                                                                          String                       classificationName,
                                                                                          int                          startFrom,
                                                                                          int                          pageSize,
                                                                                          boolean                      forLineage,
                                                                                          boolean                      forDuplicateProcessing,
                                                                                          FindPropertyNamesProperties requestBody)
    {
        final String methodName = "findElementsByClassificationWithPropertyValue";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataElementSummariesResponse response = new MetadataElementSummariesResponse();
        AuditLog                         auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                restExceptionHandler.handleNoRequestBody(userId, methodName, serverName, FindPropertyNamesProperties.class.getName());
            }
            else
            {
                response.setElements(handler.findElementsByClassificationWithPropertyValue(userId,
                                                                                           classificationName,
                                                                                           null,
                                                                                           null,
                                                                                           requestBody.getOpenMetadataTypeName(),
                                                                                           requestBody.getLimitResultsByStatus(),
                                                                                           requestBody.getAsOfTime(),
                                                                                           requestBody.getSequencingProperty(),
                                                                                           requestBody.getSequencingOrder(),
                                                                                           startFrom,
                                                                                           pageSize,
                                                                                           requestBody.getEffectiveTime(),
                                                                                           forLineage,
                                                                                           forDuplicateProcessing));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve related elements of the requested type name.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param elementGUID unique identifier of the starting element
     * @param relationshipTypeName name of relationship
     * @param startingAtEnd indicates which end to retrieve from (0 is "either end"; 1 is end1; 2 is end 2)
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody  open metadata type to search on
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public RelatedMetadataElementSummariesResponse getRelatedElements(String         serverName,
                                                                      String         urlMarker,
                                                                      String         elementGUID,
                                                                      String         relationshipTypeName,
                                                                      int            startingAtEnd,
                                                                      int            startFrom,
                                                                      int            pageSize,
                                                                      boolean        forLineage,
                                                                      boolean        forDuplicateProcessing,
                                                                      FindProperties requestBody)
    {
        final String methodName = "getRelatedElements";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        RelatedMetadataElementSummariesResponse response = new RelatedMetadataElementSummariesResponse();
        AuditLog                                auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                RelatedMetadataElementSummaryList summaryList = handler.getRelatedElements(userId,
                                                                                           elementGUID,
                                                                                           relationshipTypeName,
                                                                                           startingAtEnd,
                                                                                           null,
                                                                                           null,
                                                                                           null,
                                                                                           null,
                                                                                           null,
                                                                                           null,
                                                                                           null,
                                                                                           startFrom,
                                                                                           pageSize,
                                                                                           new Date(),
                                                                                           forLineage,
                                                                                           forDuplicateProcessing,
                                                                                           methodName);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
            else
            {
                RelatedMetadataElementSummaryList summaryList = handler.getRelatedElements(userId,
                                                                                           elementGUID,
                                                                                           relationshipTypeName,
                                                                                           startingAtEnd,
                                                                                           null,
                                                                                           null,
                                                                                           requestBody.getOpenMetadataTypeName(),
                                                                                           requestBody.getLimitResultsByStatus(),
                                                                                           requestBody.getAsOfTime(),
                                                                                           requestBody.getSequencingProperty(),
                                                                                           requestBody.getSequencingOrder(),
                                                                                           startFrom,
                                                                                           pageSize,
                                                                                           requestBody.getEffectiveTime(),
                                                                                           forLineage,
                                                                                           forDuplicateProcessing,
                                                                                           methodName);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve elements linked via the requested relationship type name and with the requested a value
     * found in one of the classification's properties specified.  The value must match exactly.
     * An open metadata type name may be supplied to restrict the types of elements returned.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param elementGUID unique identifier of the starting element
     * @param relationshipTypeName name of relationship
     * @param startingAtEnd indicates which end to retrieve from (0 is "either end"; 1 is end1; 2 is end 2)
     * @param requestBody properties and optional open metadata type to search on
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public RelatedMetadataElementSummariesResponse getRelatedElementsWithPropertyValue(String                       serverName,
                                                                                       String                       urlMarker,
                                                                                       String                       elementGUID,
                                                                                       String                       relationshipTypeName,
                                                                                       int                          startingAtEnd,
                                                                                       int                          startFrom,
                                                                                       int                          pageSize,
                                                                                       boolean                      forLineage,
                                                                                       boolean                      forDuplicateProcessing,
                                                                                       FindPropertyNamesProperties requestBody)
    {
        final String methodName = "getRelatedElementsWithPropertyValue";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        RelatedMetadataElementSummariesResponse response = new RelatedMetadataElementSummariesResponse();
        AuditLog                         auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                restExceptionHandler.handleNoRequestBody(userId, methodName, serverName, FindPropertyNamesProperties.class.getName());
            }
            else
            {
                RelatedMetadataElementSummaryList summaryList = handler.getRelatedElements(userId,
                                                                                           elementGUID,
                                                                                           relationshipTypeName,
                                                                                           startingAtEnd,
                                                                                           requestBody.getPropertyValue(),
                                                                                           requestBody.getPropertyNames(),
                                                                                           requestBody.getOpenMetadataTypeName(),
                                                                                           requestBody.getLimitResultsByStatus(),
                                                                                           requestBody.getAsOfTime(),
                                                                                           requestBody.getSequencingProperty(),
                                                                                           requestBody.getSequencingOrder(),
                                                                                           startFrom,
                                                                                           pageSize,
                                                                                           requestBody.getEffectiveTime(),
                                                                                           forLineage,
                                                                                           forDuplicateProcessing,
                                                                                           methodName);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve elements linked via the requested relationship type name and with the relationship's properties
     * specified.  The value must be contained in one of the properties specified (or any property if no property names are specified).
     * An open metadata type name may be supplied to restrict the linked elements that are matched.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param elementGUID unique identifier of the starting element
     * @param relationshipTypeName name of relationship
     * @param startingAtEnd indicates which end to retrieve from (0 is "either end"; 1 is end1; 2 is end 2)
     * @param requestBody properties and optional open metadata type to search on
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public RelatedMetadataElementSummariesResponse findRelatedElementsWithPropertyValue(String                       serverName,
                                                                                        String                       urlMarker,
                                                                                        String                       elementGUID,
                                                                                        String                       relationshipTypeName,
                                                                                        int                          startingAtEnd,
                                                                                        int                          startFrom,
                                                                                        int                          pageSize,
                                                                                        boolean                      forLineage,
                                                                                        boolean                      forDuplicateProcessing,
                                                                                        FindPropertyNamesProperties requestBody)
    {
        final String methodName = "findRelatedElementsWithPropertyValue";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        RelatedMetadataElementSummariesResponse response = new RelatedMetadataElementSummariesResponse();
        AuditLog                         auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                restExceptionHandler.handleNoRequestBody(userId, methodName, serverName, FindPropertyNamesProperties.class.getName());
            }
            else
            {
                RelatedMetadataElementSummaryList summaryList = handler.findRelatedElementsWithPropertyValue(userId,
                                                                                                             elementGUID,
                                                                                                             relationshipTypeName,
                                                                                                             startingAtEnd,
                                                                                                             requestBody.getPropertyValue(),
                                                                                                             requestBody.getPropertyNames(),
                                                                                                             requestBody.getOpenMetadataTypeName(),
                                                                                                             requestBody.getLimitResultsByStatus(),
                                                                                                             requestBody.getAsOfTime(),
                                                                                                             requestBody.getSequencingProperty(),
                                                                                                             requestBody.getSequencingOrder(),
                                                                                                             startFrom,
                                                                                                             pageSize,
                                                                                                             requestBody.getEffectiveTime(),
                                                                                                             forLineage,
                                                                                                             forDuplicateProcessing);
                if (summaryList != null)
                {
                    response.setElements(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve relationships of the requested relationship type name.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody  open metadata type to search on
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public MetadataRelationshipSummariesResponse getRelationships(String         serverName,
                                                                  String         urlMarker,
                                                                  int            startFrom,
                                                                  int            pageSize,
                                                                  boolean        forLineage,
                                                                  boolean        forDuplicateProcessing,
                                                                  FindProperties requestBody)
    {
        final String methodName = "getRelationships";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataRelationshipSummariesResponse response = new MetadataRelationshipSummariesResponse();
        AuditLog                              auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                MetadataRelationshipSummaryList summaryList = handler.getRelationships(userId,
                                                                                       null,
                                                                                       null,
                                                                                       null,
                                                                                       null,
                                                                                       null,
                                                                                       null,
                                                                                       null,
                                                                                       startFrom,
                                                                                       pageSize,
                                                                                       new Date(),
                                                                                       forLineage,
                                                                                       forDuplicateProcessing,
                                                                                       methodName);
                if (summaryList != null)
                {
                    response.setRelationships(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
            else
            {
                MetadataRelationshipSummaryList summaryList = handler.getRelationships(userId,
                                                                                       requestBody.getOpenMetadataTypeName(),
                                                                                       null,
                                                                                       null,
                                                                                       requestBody.getLimitResultsByStatus(),
                                                                                       requestBody.getAsOfTime(),
                                                                                       requestBody.getSequencingProperty(),
                                                                                       requestBody.getSequencingOrder(),
                                                                                       startFrom,
                                                                                       pageSize,
                                                                                       requestBody.getEffectiveTime(),
                                                                                       forLineage,
                                                                                       forDuplicateProcessing,
                                                                                       methodName);
                if (summaryList != null)
                {
                    response.setRelationships(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve relationships of the requested relationship type name and with the requested a value found in
     * one of the relationship's properties specified.  The value must match exactly.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param requestBody properties and optional open metadata type to search on
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public MetadataRelationshipSummariesResponse getRelationshipsWithPropertyValue(String                       serverName,
                                                                                   String                       urlMarker,
                                                                                   int                          startFrom,
                                                                                   int                          pageSize,
                                                                                   boolean                      forLineage,
                                                                                   boolean                      forDuplicateProcessing,
                                                                                   FindPropertyNamesProperties requestBody)
    {
        final String methodName = "getRelationshipsWithPropertyValue";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataRelationshipSummariesResponse response = new MetadataRelationshipSummariesResponse();
        AuditLog                              auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                restExceptionHandler.handleNoRequestBody(userId, methodName, serverName, FindPropertyNamesProperties.class.getName());
            }
            else
            {
                MetadataRelationshipSummaryList summaryList = handler.getRelationships(userId,
                                                                                       requestBody.getOpenMetadataTypeName(),
                                                                                       requestBody.getPropertyValue(),
                                                                                       requestBody.getPropertyNames(),
                                                                                       requestBody.getLimitResultsByStatus(),
                                                                                       requestBody.getAsOfTime(),
                                                                                       requestBody.getSequencingProperty(),
                                                                                       requestBody.getSequencingOrder(),
                                                                                       startFrom,
                                                                                       pageSize,
                                                                                       requestBody.getEffectiveTime(),
                                                                                       forLineage,
                                                                                       forDuplicateProcessing,
                                                                                       methodName);

                if (summaryList != null)
                {
                    response.setRelationships(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve relationships of the requested relationship type name and with the requested a value found in one of
     * the relationship's properties specified.  The value must only be contained in the properties rather than
     * needing to be an exact match.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param requestBody properties and optional open metadata type to search on
     * @param startFrom  index of the list to start from (0 for start)
     * @param pageSize   maximum number of elements to return.
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public MetadataRelationshipSummariesResponse findRelationshipsWithPropertyValue(String                       serverName,
                                                                                    String                   urlMarker,
                                                                                    int                          startFrom,
                                                                                    int                          pageSize,
                                                                                    boolean                      forLineage,
                                                                                    boolean                      forDuplicateProcessing,
                                                                                    FindPropertyNamesProperties requestBody)
    {
        final String methodName = "findRelationshipsWithPropertyValue";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        MetadataRelationshipSummariesResponse response = new MetadataRelationshipSummariesResponse();
        AuditLog                              auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                restExceptionHandler.handleNoRequestBody(userId, methodName, serverName, FindPropertyNamesProperties.class.getName());
            }
            else
            {
                MetadataRelationshipSummaryList summaryList = handler.findRelationshipsWithPropertyValue(userId,
                                                                                                         requestBody.getOpenMetadataTypeName(),
                                                                                                         requestBody.getPropertyValue(),
                                                                                                         requestBody.getPropertyNames(),
                                                                                                         requestBody.getLimitResultsByStatus(),
                                                                                                         requestBody.getAsOfTime(),
                                                                                                         requestBody.getSequencingProperty(),
                                                                                                         requestBody.getSequencingOrder(),
                                                                                                         startFrom,
                                                                                                         pageSize,
                                                                                                         requestBody.getEffectiveTime(),
                                                                                                         forLineage,
                                                                                                         forDuplicateProcessing);

                if (summaryList != null)
                {
                    response.setRelationships(summaryList.getElementList());
                    response.setMermaidGraph(summaryList.getMermaidGraph());
                }
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }


    /**
     * Retrieve the header for the instance identified by the supplied unique identifier.
     * It may be an element (entity) or a relationship between elements.
     *
     * @param serverName  name of the server instance to connect to
     * @param urlMarker  view service URL marker
     * @param guid identifier to use in the lookup
     * @param forLineage return elements marked with the Memento classification?
     * @param forDuplicateProcessing do not merge elements marked as duplicates?
     * @param requestBody effective time
     *
     * @return list of matching elements or
     *  InvalidParameterException  one of the parameters is invalid
     *  UserNotAuthorizedException the user is not authorized to issue this request
     *  PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public ElementHeaderResponse retrieveInstanceForGUID(String             serverName,
                                                         String             urlMarker,
                                                         String             guid,
                                                         boolean            forLineage,
                                                         boolean            forDuplicateProcessing,
                                                         ResultsRequestBody requestBody)
    {
        final String methodName = "retrieveInstanceForGUID";

        RESTCallToken token = restCallLogger.logRESTCall(serverName, methodName);

        ElementHeaderResponse response = new ElementHeaderResponse();
        AuditLog              auditLog = null;

        try
        {
            String userId = super.getUser(instanceHandler.getServiceName(), methodName);

            restCallLogger.setUserId(token, userId);

            auditLog = instanceHandler.getAuditLog(userId, serverName, methodName);
            StewardshipManagementHandler handler = instanceHandler.getStewardshipManagementHandler(userId, serverName, urlMarker, methodName);

            if (requestBody == null)
            {
                response.setElement(handler.retrieveInstanceForGUID(userId,
                                                                    guid,
                                                                    forLineage,
                                                                    forDuplicateProcessing,
                                                                    null));
            }
            else
            {
                response.setElement(handler.retrieveInstanceForGUID(userId,
                                                                    guid,
                                                                    forLineage,
                                                                    forDuplicateProcessing,
                                                                    requestBody.getEffectiveTime()));
            }
        }
        catch (Exception error)
        {
            restExceptionHandler.captureExceptions(response, error, methodName, auditLog);
        }

        restCallLogger.logRESTCallReturn(token, response.toString());
        return response;
    }
}
