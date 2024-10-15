/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.integration.context;

import org.odpi.openmetadata.frameworks.connectors.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.UserNotAuthorizedException;
import org.odpi.openmetadata.frameworks.governanceaction.client.ActionControlInterface;
import org.odpi.openmetadata.frameworks.governanceaction.client.OpenMetadataClient;
import org.odpi.openmetadata.frameworks.governanceaction.properties.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * StewardshipAction defines methods that are used to request help for a situation that the caller can not handle.
 */
public  class StewardshipAction
{
    private final OpenMetadataClient     openMetadataStore;
    private final ActionControlInterface actionControlInterface;
    private final String                 userId;
    private final String                 originatorGUID;


    /**
     * The constructor needs an implementation of the open metadata store.
     *
     * @param openMetadataStore client implementation
     * @param actionControlInterface interface for creating governance actions
     * @param userId calling user
     * @param originatorGUID unique identifier of the source of the to do
     */
    public StewardshipAction(OpenMetadataClient     openMetadataStore,
                             ActionControlInterface actionControlInterface,
                             String                 userId,
                             String                 originatorGUID)
    {
        this.openMetadataStore      = openMetadataStore;
        this.actionControlInterface = actionControlInterface;
        this.userId                 = userId;
        this.originatorGUID         = originatorGUID;
    }


    /**
     * Create an incident report to capture the situation detected by this governance action service.
     * This incident report will be processed by other governance activities.
     *
     * @param qualifiedName unique identifier to give this new incident report
     * @param domainIdentifier governance domain associated with this action (0=ALL)
     * @param background description of the situation
     * @param impactedResources details of the resources impacted by this situation
     * @param previousIncidents links to previous incident reports covering this situation
     * @param incidentClassifiers initial classifiers for the incident report
     * @param additionalProperties additional arbitrary properties for the incident reports
     * @param originatorGUID the unique identifier of the person or process that created the incident
     *
     * @return unique identifier of the resulting incident report
     * @throws InvalidParameterException null or non-unique qualified name for the incident report
     * @throws UserNotAuthorizedException this governance action service is not authorized to create an incident report
     * @throws PropertyServerException there is a problem with the metadata store
     */
    public String createIncidentReport(String                        qualifiedName,
                                       int                           domainIdentifier,
                                       String                        background,
                                       List<IncidentImpactedElement> impactedResources,
                                       List<IncidentDependency>      previousIncidents,
                                       Map<String, Integer>          incidentClassifiers,
                                       Map<String, String>           additionalProperties,
                                       String                        originatorGUID) throws InvalidParameterException,
                                                                                            UserNotAuthorizedException,
                                                                                            PropertyServerException
    {
        return openMetadataStore.createIncidentReport(userId,
                                                      qualifiedName,
                                                      domainIdentifier,
                                                      background,
                                                      impactedResources,
                                                      previousIncidents,
                                                      incidentClassifiers,
                                                      additionalProperties,
                                                      originatorGUID);
    }


    /**
     * Create a "To Do" request for someone to work on.
     *
     * @param qualifiedName unique name for the to do.  (Could be the engine name and a guid?)
     * @param title short meaningful phrase for the person receiving the request
     * @param instructions further details on what to do
     * @param category a category of to dos (for example, "data error", "access request")
     * @param priority priority value (based on organization's scale)
     * @param dueDate date/time this needs to be completed
     * @param additionalProperties additional arbitrary properties for the incident reports
     * @param assignToGUID unique identifier the Actor element for the recipient
     * @param sponsorGUID unique identifier of the element that describes the rule, project that this is on behalf of
     * @param actionTargets the list of elements that should be acted upon
     *
     * @return unique identifier of new to do element
     *
     * @throws InvalidParameterException either todoQualifiedName or assignedTo are null or not recognized
     * @throws UserNotAuthorizedException the governance action service is not authorized to create a "to do" entity
     * @throws PropertyServerException there is a problem connecting to (or inside) the metadata store
     */
    public String openToDo(String                qualifiedName,
                           String                title,
                           String                instructions,
                           String                category,
                           int                   priority,
                           Date                  dueDate,
                           Map<String, String>   additionalProperties,
                           String                assignToGUID,
                           String                sponsorGUID,
                           List<NewActionTarget> actionTargets) throws InvalidParameterException,
                                                                       UserNotAuthorizedException,
                                                                       PropertyServerException
    {
        return openMetadataStore.openToDo(userId, qualifiedName, title, instructions, category, priority, dueDate, additionalProperties, assignToGUID, sponsorGUID, originatorGUID, actionTargets);
    }





    /**
     * Create an engine action in the metadata store which will trigger the governance service
     * associated with the supplied request type.  The engine action remains to act as a record
     * of the actions taken for auditing.
     *
     * @param qualifiedName unique identifier to give this engine action
     * @param domainIdentifier governance domain associated with this action (0=ALL)
     * @param displayName display name for this action
     * @param description description for this action
     * @param requestSourceGUIDs  request source elements for the resulting governance service
     * @param actionTargets list of action target names to GUIDs for the resulting governance service
     * @param receivedGuards list of guards to initiate the engine action
     * @param startTime future start time or null for "as soon as possible"
     * @param governanceEngineName name of the governance engine that should execute the request
     * @param requestType governance request type from the caller
     * @param requestParameters properties to pass to the governance service
     * @param processName name of the process that this action is a part of
     * @param requestSourceName source of the request
     * @param originatorServiceName unique name of the requesting governance service (if initiated by a governance engine).
     * @param originatorEngineName optional unique name of the requesting governance engine (if initiated by a governance engine).
     *
     * @return unique identifier of the engine action
     * @throws InvalidParameterException null qualified name
     * @throws UserNotAuthorizedException the caller is not authorized to create an engine action
     * @throws PropertyServerException there is a problem with the metadata store
     */
    public String initiateEngineAction(String                qualifiedName,
                                       int                   domainIdentifier,
                                       String                displayName,
                                       String                description,
                                       List<String>          requestSourceGUIDs,
                                       List<NewActionTarget> actionTargets,
                                       List<String>          receivedGuards,
                                       Date                  startTime,
                                       String                governanceEngineName,
                                       String                requestType,
                                       Map<String, String>   requestParameters,
                                       String                processName,
                                       String                requestSourceName,
                                       String                originatorServiceName,
                                       String                originatorEngineName) throws InvalidParameterException,
                                                                                          UserNotAuthorizedException,
                                                                                          PropertyServerException
    {
        return actionControlInterface.initiateEngineAction(userId, qualifiedName, domainIdentifier, displayName, description, requestSourceGUIDs, actionTargets, receivedGuards, startTime, governanceEngineName, requestType, requestParameters, processName, requestSourceName, originatorServiceName, originatorEngineName);
    }


    /**
     * Using the named governance action type as a template, initiate an engine action.
     *
     * @param governanceActionTypeQualifiedName unique name of the governance action type to use
     * @param requestSourceGUIDs  request source elements for the resulting governance service
     * @param actionTargets list of action target names to GUIDs for the resulting governance service
     * @param startTime future start time or null for "as soon as possible".
     * @param requestParameters request properties to be passed to the engine action
     * @param originatorServiceName unique name of the requesting governance service (if initiated by a governance engine).
     * @param originatorEngineName optional unique name of the governance engine (if initiated by a governance engine).
     *
     * @return unique identifier of the engine action
     * @throws InvalidParameterException null or unrecognized qualified name of the type
     * @throws UserNotAuthorizedException the caller is not authorized to create an engine action
     * @throws PropertyServerException there is a problem with the metadata store
     */
    public String initiateGovernanceActionType(String                governanceActionTypeQualifiedName,
                                               List<String>          requestSourceGUIDs,
                                               List<NewActionTarget> actionTargets,
                                               Date                  startTime,
                                               Map<String, String>   requestParameters,
                                               String                originatorServiceName,
                                               String                originatorEngineName) throws InvalidParameterException,
                                                                                                  UserNotAuthorizedException,
                                                                                                  PropertyServerException
    {
        return actionControlInterface.initiateGovernanceActionType(userId, governanceActionTypeQualifiedName, requestSourceGUIDs, actionTargets, startTime, requestParameters, originatorServiceName, originatorEngineName);
    }


    /**
     * Using the named governance action process as a template, initiate a chain of engine actions.
     *
     * @param processQualifiedName unique name of the governance action process to use
     * @param requestSourceGUIDs  request source elements for the resulting governance service
     * @param actionTargets list of action target names to GUIDs for the resulting governance service
     * @param startTime future start time or null for "as soon as possible".
     * @param requestParameters request properties to be passed to the first engine action
     * @param originatorServiceName unique name of the requesting governance service (if initiated by a governance engine).
     * @param originatorEngineName optional unique name of the governance engine (if initiated by a governance engine).
     *
     * @return unique identifier of the governance action process instance
     * @throws InvalidParameterException null or unrecognized qualified name of the process
     * @throws UserNotAuthorizedException the caller is not authorized to create a governance action process
     * @throws PropertyServerException there is a problem with the metadata store
     */
    public String initiateGovernanceActionProcess(String                processQualifiedName,
                                                  List<String>          requestSourceGUIDs,
                                                  List<NewActionTarget> actionTargets,
                                                  Date                  startTime,
                                                  Map<String, String>   requestParameters,
                                                  String                originatorServiceName,
                                                  String                originatorEngineName) throws InvalidParameterException,
                                                                                                     UserNotAuthorizedException,
                                                                                                     PropertyServerException
    {
        return actionControlInterface.initiateGovernanceActionProcess(userId, processQualifiedName, requestSourceGUIDs, actionTargets, startTime, requestParameters, originatorServiceName, originatorEngineName);
    }


    /**
     * Request the status of an executing engine action request.
     *
     * @param engineActionGUID identifier of the engine action request.
     *
     * @return status enum
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws UserNotAuthorizedException user not authorized to issue this request.
     * @throws PropertyServerException there was a problem detected by the metadata store.
     */
    public EngineActionElement getEngineAction(String engineActionGUID) throws InvalidParameterException,
                                                                               UserNotAuthorizedException,
                                                                               PropertyServerException
    {
        return actionControlInterface.getEngineAction(userId, engineActionGUID);
    }



    /**
     * Request that execution of an engine action is stopped.
     *
     * @param engineActionGUID identifier of the engine action request.
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws UserNotAuthorizedException user not authorized to issue this request.
     * @throws PropertyServerException there was a problem detected by the metadata store.
     */
    public void cancelEngineAction(String engineActionGUID) throws InvalidParameterException,
                                                                   UserNotAuthorizedException,
                                                                   PropertyServerException
    {
        actionControlInterface.cancelEngineAction(userId, engineActionGUID);
    }


    /**
     * Retrieve the engine actions known to the server.
     *
     * @param startFrom starting from element
     * @param pageSize maximum elements to return
     * @return list of engine action elements
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws UserNotAuthorizedException user not authorized to issue this request.
     * @throws PropertyServerException there was a problem detected by the metadata store.
     */
    public List<EngineActionElement>  getEngineActions(int    startFrom,
                                                       int    pageSize) throws InvalidParameterException,
                                                                               UserNotAuthorizedException,
                                                                               PropertyServerException
    {
        return actionControlInterface.getEngineActions(userId, startFrom, pageSize);
    }


    /**
     * Retrieve the engine actions that are still in process.
     *
     * @param startFrom starting from element
     * @param pageSize maximum elements to return
     * @return list of engine action elements
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws UserNotAuthorizedException user not authorized to issue this request.
     * @throws PropertyServerException there was a problem detected by the metadata store.
     */
    public List<EngineActionElement>  getActiveEngineActions(int    startFrom,
                                                             int    pageSize) throws InvalidParameterException,
                                                                                     UserNotAuthorizedException,
                                                                                     PropertyServerException
    {
        return actionControlInterface.getActiveEngineActions(userId, startFrom, pageSize);
    }


    /**
     * Retrieve the list of engine action metadata elements that contain the search string.
     * The search string is treated as a regular expression.
     *
     * @param searchString string to find in the properties
     * @param startFrom paging start point
     * @param pageSize maximum results that can be returned
     *
     * @return list of matching metadata elements
     *
     * @throws InvalidParameterException  one of the parameters is invalid
     * @throws UserNotAuthorizedException the user is not authorized to issue this request
     * @throws PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public List<EngineActionElement> findEngineActions(String searchString,
                                                       int    startFrom,
                                                       int    pageSize) throws InvalidParameterException,
                                                                               UserNotAuthorizedException,
                                                                               PropertyServerException
    {
        return actionControlInterface.findEngineActions(userId, searchString, startFrom, pageSize);
    }


    /**
     * Retrieve the list of engine action metadata elements with a matching qualified or display name.
     * There are no wildcards supported on this request.
     *
     * @param name name to search for
     * @param startFrom paging start point
     * @param pageSize maximum results that can be returned
     *
     * @return list of matching metadata elements
     *
     * @throws InvalidParameterException  one of the parameters is invalid
     * @throws UserNotAuthorizedException the user is not authorized to issue this request
     * @throws PropertyServerException    there is a problem reported in the open metadata server(s)
     */
    public List<EngineActionElement> getEngineActionsByName(String name,
                                                            int    startFrom,
                                                            int    pageSize) throws InvalidParameterException,
                                                                                    UserNotAuthorizedException,
                                                                                    PropertyServerException
    {
        return actionControlInterface.getEngineActionsByName(userId, name, startFrom, pageSize);
    }
}
