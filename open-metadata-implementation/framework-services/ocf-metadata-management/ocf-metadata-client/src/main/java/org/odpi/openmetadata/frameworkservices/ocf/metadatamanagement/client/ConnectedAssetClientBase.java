/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworkservices.ocf.metadatamanagement.client;

import org.odpi.openmetadata.commonservices.ffdc.InvalidParameterHandler;
import org.odpi.openmetadata.commonservices.ffdc.rest.GUIDResponse;
import org.odpi.openmetadata.commonservices.ffdc.rest.NullRequestBody;
import org.odpi.openmetadata.frameworks.auditlog.AuditLoggingComponent;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.UserNotAuthorizedException;
import org.odpi.openmetadata.frameworkservices.ocf.metadatamanagement.api.ConnectorFactoryInterface;
import org.odpi.openmetadata.frameworkservices.ocf.metadatamanagement.ffdc.OMAGOCFErrorCode;
import org.odpi.openmetadata.frameworkservices.ocf.metadatamanagement.rest.AssetResponse;
import org.odpi.openmetadata.frameworkservices.ocf.metadatamanagement.rest.ConnectionResponse;
import org.odpi.openmetadata.frameworks.auditlog.AuditLog;
import org.odpi.openmetadata.frameworks.connectors.Connector;
import org.odpi.openmetadata.frameworks.connectors.ConnectorBroker;
import org.odpi.openmetadata.frameworks.connectors.ffdc.*;
import org.odpi.openmetadata.frameworks.connectors.properties.AssetUniverse;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.Asset;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.Connection;


/**
 * ConnectedAssetClientBase provides a base calls for clients that support an OCF interface.
 * In particular, it manages the retrieval of connections for assets, and the creation of connectors.
 */
public class ConnectedAssetClientBase implements ConnectorFactoryInterface
{
    protected String   serverName;               /* Initialized in constructor */
    protected String   serverPlatformURLRoot;    /* Initialized in constructor */
    protected AuditLog auditLog;                 /* Initialized in constructor */

    protected InvalidParameterHandler invalidParameterHandler = new InvalidParameterHandler();

    protected static NullRequestBody         nullRequestBody         = new NullRequestBody();

    private final String        serviceURLMarker;
    private final OCFRESTClient ocfRESTClient;

    /**
     * Create a new client with no authentication embedded in the HTTP request.
     *
     * @param serverName name of the server to connect to
     * @param serverPlatformURLRoot the network address of the server running the OCF REST services
     * @param serviceURLMarker indicator of the OMAS that this client is supporting
     * @param auditLog destination for log messages
     * @throws InvalidParameterException there is a problem creating the client-side components to issue any
     * REST API calls.
     */
    public ConnectedAssetClientBase(String   serverName,
                                    String   serverPlatformURLRoot,
                                    String   serviceURLMarker,
                                    AuditLog auditLog) throws InvalidParameterException
    {
        final String methodName = "Client Constructor";

        invalidParameterHandler.validateOMAGServerPlatformURL(serverPlatformURLRoot, serverName, methodName);

        this.serverName = serverName;
        this.serverPlatformURLRoot = serverPlatformURLRoot;
        this.serviceURLMarker = serviceURLMarker;
        this.auditLog = auditLog;

        this.ocfRESTClient = new OCFRESTClient(serverName, serverPlatformURLRoot, auditLog);
    }


    /**
     * Create a new client with no authentication embedded in the HTTP request.
     *
     * @param serverName name of the server to connect to
     * @param serverPlatformURLRoot the network address of the server running the OCF REST services
     * @param maxPageSize maximum page size for this process
     * @param serviceURLMarker indicator of the OMAS that this client is supporting
     * @param auditLog destination for log messages
     * @throws InvalidParameterException there is a problem creating the client-side components to issue any
     * REST API calls.
     */
    public ConnectedAssetClientBase(String   serverName,
                                    String   serverPlatformURLRoot,
                                    String   serviceURLMarker,
                                    int      maxPageSize,
                                    AuditLog auditLog) throws InvalidParameterException
    {
        final String methodName = "Client Constructor";

        invalidParameterHandler.validateOMAGServerPlatformURL(serverPlatformURLRoot, serverName, methodName);
        invalidParameterHandler.setMaxPagingSize(maxPageSize);

        this.serverName = serverName;
        this.serverPlatformURLRoot = serverPlatformURLRoot;
        this.serviceURLMarker = serviceURLMarker;
        this.auditLog = auditLog;

        this.ocfRESTClient = new OCFRESTClient(serverName, serverPlatformURLRoot, auditLog);
    }


    /**
     * Create a new client with no authentication embedded in the HTTP request.
     *
     * @param serverName name of the server to connect to
     * @param serverPlatformURLRoot the network address of the server running the OCF REST services
     * @param serviceURLMarker indicator of the OMAS that this client is supporting
     * @throws InvalidParameterException there is a problem creating the client-side components to issue any
     * REST API calls.
     */
    public ConnectedAssetClientBase(String serverName,
                                    String serverPlatformURLRoot,
                                    String serviceURLMarker) throws InvalidParameterException
    {
        this(serverName, serverPlatformURLRoot, serviceURLMarker, null);
    }


    /**
     * Create a new client that passes userId and password in each HTTP request.  This is the
     * userId/password of the calling server.  The end user's userId is sent on each request.
     *
     * @param serverName name of the server to connect to
     * @param serverPlatformURLRoot the network address of the server running the OCF REST services
     * @param serviceURLMarker indicator of the OMAS that this client is supporting
     * @param userId caller's userId embedded in all HTTP requests
     * @param password caller's userId embedded in all HTTP requests
     * @param auditLog destination for log messages
     * @throws InvalidParameterException there is a problem creating the client-side components to issue any
     * REST API calls.
     */
    public ConnectedAssetClientBase(String   serverName,
                                    String   serverPlatformURLRoot,
                                    String   serviceURLMarker,
                                    String   userId,
                                    String   password,
                                    AuditLog auditLog) throws InvalidParameterException
    {
        final String methodName = "Client Constructor";

        invalidParameterHandler.validateOMAGServerPlatformURL(serverPlatformURLRoot, serverName, methodName);

        this.serverName = serverName;
        this.serverPlatformURLRoot = serverPlatformURLRoot;
        this.serviceURLMarker = serviceURLMarker;
        this.auditLog = auditLog;

        this.ocfRESTClient = new OCFRESTClient(serverName, serverPlatformURLRoot, userId, password);
    }


    /**
     * Create a new client that passes userId and password in each HTTP request.  This is the
     * userId/password of the calling server.  The end user's userId is sent on each request.
     *
     * @param serverName name of the server to connect to
     * @param serverPlatformURLRoot the network address of the server running the OCF REST services
     * @param serviceURLMarker indicator of the OMAS that this client is supporting
     * @param userId caller's userId embedded in all HTTP requests
     * @param password caller's userId embedded in all HTTP requests
     * @throws InvalidParameterException there is a problem creating the client-side components to issue any
     * REST API calls.
     */
    public ConnectedAssetClientBase(String serverName,
                                    String serverPlatformURLRoot,
                                    String serviceURLMarker,
                                    String userId,
                                    String password) throws InvalidParameterException
    {
        final String methodName = "Client Constructor";

        invalidParameterHandler.validateOMAGServerPlatformURL(serverPlatformURLRoot, serverName, methodName);

        this.serverName = serverName;
        this.serverPlatformURLRoot = serverPlatformURLRoot;
        this.serviceURLMarker = serviceURLMarker;

        this.ocfRESTClient = new OCFRESTClient(serverName, serverPlatformURLRoot, userId, password);
    }


    /**
     * Return the basic properties of an asset.
     *
     * @param userId calling user
     * @param guid unique identifier of asset
     * @param methodName calling method
     *
     * @return Asset bean
     *
     * @throws InvalidParameterException the name is invalid
     * @throws PropertyServerException there is a problem access in the property server
     * @throws UserNotAuthorizedException the user does not have access to the properties
     */
    protected Asset getAssetSummary(String         userId,
                                    String         guid,
                                    String         methodName) throws InvalidParameterException,
                                                                      PropertyServerException,
                                                                      UserNotAuthorizedException
    {
        final String   urlTemplate = "/servers/{0}/open-metadata/framework-services/{1}/connected-asset/users/{2}/assets/{3}";

        AssetResponse restResult = ocfRESTClient.callOCFAssetGetRESTCall(methodName,
                                                                         serverPlatformURLRoot + urlTemplate,
                                                                         serverName,
                                                                         serviceURLMarker,
                                                                         userId,
                                                                         guid);

        return restResult.getAsset();
    }


    /**
     * Returns a comprehensive collection of properties about the requested asset.
     *
     * @param userId         userId of user making request.
     * @param assetGUID      unique identifier for asset.
     *
     * @return a comprehensive collection of properties about the asset.
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws PropertyServerException there is a problem retrieving the asset properties from the property servers).
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    public AssetUniverse getAssetProperties(String userId,
                                            String assetGUID) throws InvalidParameterException,
                                                                     PropertyServerException,
                                                                     UserNotAuthorizedException
    {
        final String   methodName = "getAssetProperties";
        final String   guidParameter = "assetGUID";

        invalidParameterHandler.validateUserId(userId, methodName);
        invalidParameterHandler.validateGUID(assetGUID, guidParameter, methodName);

        try
        {
            /*
             * Make use of the ConnectedAsset OMAS Service which provides the metadata services for the
             * Open Connector Framework (OCF).
             */
            return ConnectedAssetUniverse.create(serviceURLMarker, serverName, serverPlatformURLRoot, userId, assetGUID);
        }
        catch (UserNotAuthorizedException | InvalidParameterException | PropertyServerException error)
        {
            throw error;
        }
        catch (Exception error)
        {
            throw new PropertyServerException(OMAGOCFErrorCode.NO_ASSET_PROPERTIES.getMessageDefinition(assetGUID,
                                                                                                        error.getClass().getName(),
                                                                                                        error.getMessage()),
                                              this.getClass().getName(),
                                              methodName);
        }
    }


    /**
     * Use the Open Connector Framework (OCF) to create a connector using the supplied connection.
     * The connector is initialized by not started.
     *
     * @param restClient client that calls REST APIs
     * @param serviceName calling service
     * @param userId calling user
     * @param requestedConnection  connection describing the required connector
     * @param methodName  name of the calling method.
     *
     * @return a new connector.
     *
     * @throws ConnectionCheckedException  there are issues with the values in the connection
     * @throws ConnectorCheckedException the connector had an operational issue accessing the asset.
     */
    protected Connector getConnectorForConnection(OCFRESTClient   restClient,
                                                  String          serviceName,
                                                  String          userId,
                                                  Connection      requestedConnection,
                                                  String          methodName) throws ConnectionCheckedException,
                                                                                     ConnectorCheckedException
    {
        ConnectorBroker connectorBroker = new ConnectorBroker(auditLog);

        /*
         * Pass the connection to the ConnectorBroker to create the connector instance.
         * Again, exceptions from this process are returned directly to the caller.
         */
        Connector newConnector = connectorBroker.getConnector(requestedConnection);

        /*
         * If no exception is thrown by getConnector, we should have a connector instance.
         */
        if (newConnector == null)
        {
            /*
             * This is probably some sort of logic error since the connector should have been returned.
             * Whatever the cause, the process can not proceed without a connector.
             */
            throw new ConnectorCheckedException(OMAGOCFErrorCode.NULL_CONNECTOR_RETURNED.getMessageDefinition(requestedConnection.getQualifiedName(),
                                                                                                              serviceName,
                                                                                                              serverName,
                                                                                                              serverPlatformURLRoot),
                                                this.getClass().getName(),
                                                methodName);
        }

        try
        {
            String  assetGUID = this.getAssetForConnection(restClient, serviceName, userId, requestedConnection.getGUID());

            /*
             * If the connector is successfully created, set up the Connected Asset Properties for the connector.
             * The properties should be retrieved from the open metadata repositories, so use an OMAS implementation
             * of the EgeriaConnectedAssetDetails object.
             */
            EgeriaConnectedAssetDetails connectedAssetProperties = new EgeriaConnectedAssetDetails(serviceName,
                                                                                                   serverName,
                                                                                                   userId,
                                                                                                   serverPlatformURLRoot,
                                                                                                   newConnector.getConnectorInstanceId(),
                                                                                                   newConnector.getConnection(),
                                                                                                   assetGUID);

            /*
             * Pass the new connected asset properties to the connector
             */
            newConnector.initializeConnectedAssetProperties(connectedAssetProperties);
        }
        catch (Exception  error)
        {
            /*
             * Ignore error - connectedAssetDetails is left at null.
             */
        }

        /*
         * At this stage, the asset properties are not retrieved from the server.  This does not happen until the caller
         * issues a connector.getConnectedAssetProperties.  This causes the connectedAssetDetails.refresh() call
         * to be made, which contacts the OMAG server and retrieves the asset properties.
         *
         * Delaying the population of the connected asset properties ensures the latest values are returned to the
         * caller (consider a long-running connection).  Alternatively, these properties may not ever be used by the
         * caller so retrieving the properties at this point would be unnecessary.
         */

        return newConnector;
    }


    /**
     * Returns the connection corresponding to the supplied connection GUID.
     *
     * @param restClient client that calls REST APIs
     * @param serviceName name of the calling service
     * @param userId userId of user making request.
     * @param guid   the unique id for the connection within the metadata repository.
     *
     * @return connection instance.
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws PropertyServerException there is a problem retrieving information from the property server(s).
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    protected Connection getConnectionByGUID(OCFRESTClient  restClient,
                                             String         serviceName,
                                             String         userId,
                                             String         guid) throws InvalidParameterException,
                                                                         PropertyServerException,
                                                                         UserNotAuthorizedException
    {
        final String   methodName  = "getConnectionByGUID";
        final String   urlTemplate = "/servers/{0}/open-metadata/framework-services/{1}/connected-asset/users/{2}/connections/{3}";

        ConnectionResponse   restResult = restClient.callOCFConnectionGetRESTCall(methodName,
                                                                                  serverPlatformURLRoot + urlTemplate,
                                                                                  serverName,
                                                                                  serviceName,
                                                                                  userId,
                                                                                  guid);

         return restResult.getConnection();
    }


    /**
     * Returns the connection object corresponding to the supplied connection name.
     *
     * @param restClient client that calls REST APIs
     * @param serviceName name of the calling service
     * @param userId  String - userId of user making request.
     * @param name  this is the qualifiedName of the connection.
     *
     * @return Connection retrieved from property server.
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws PropertyServerException there is a problem retrieving information from the property (metadata) server.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    protected Connection getConnectionByName(OCFRESTClient  restClient,
                                             String         serviceName,
                                             String         userId,
                                             String         name) throws InvalidParameterException,
                                                                         PropertyServerException,
                                                                         UserNotAuthorizedException
    {
        final String   methodName = "getConnectionByName";
        final String   urlTemplate = "/servers/{0}/open-metadata/framework-services/{1}/connected-asset/users/{2}/connections/by-name/{3}";

        ConnectionResponse restResult = restClient.callOCFConnectionGetRESTCall(methodName,
                                                                                serverPlatformURLRoot + urlTemplate,
                                                                                serverName,
                                                                                serviceName,
                                                                                userId,
                                                                                name);

        return restResult.getConnection();
    }


    /**
     * Log an audit message about this asset.
     *
     * @param userId the userId of the requesting user.
     * @param assetGUID unique identifier for the asset.
     * @param serviceName name of survey service
     * @param message       message to log
     * @throws InvalidParameterException  one of the parameters is null or invalid.
     * @throws PropertyServerException    there is a problem retrieving the asset properties from the property servers).
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    public void logAssetAuditMessage(String userId,
                                     String assetGUID,
                                     String serviceName,
                                     String message) throws InvalidParameterException,
                                                            PropertyServerException,
                                                            UserNotAuthorizedException
    {
        final String   methodName = "logAssetAuditMessage";
        final String   urlTemplate = "/servers/{0}/open-metadata/framework-services/{1}/connected-asset/users/{2}/assets/{3}/log-records/{4}";

        ocfRESTClient.callVoidPostRESTCall(methodName,
                                           serverPlatformURLRoot + urlTemplate,
                                           message,
                                           serverName,
                                           serviceURLMarker,
                                           userId,
                                           serviceName);
    }



    /**
     * Returns the connection corresponding to the supplied asset GUID.
     *
     * @param restClient client that calls REST APIs
     * @param serviceName name of the calling service
     * @param userId       userId of user making request.
     * @param assetGUID   the unique id for the asset within the metadata repository.
     *
     * @return   connector instance.
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws PropertyServerException there is a problem retrieving information from the property server(s).
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    public Connection getConnectionForAsset(OCFRESTClient  restClient,
                                            String         serviceName,
                                            String         userId,
                                            String         assetGUID) throws InvalidParameterException,
                                                                             PropertyServerException,
                                                                             UserNotAuthorizedException
    {
        final String   methodName = "getConnectionForAsset";
        final String   urlTemplate = "/servers/{0}/open-metadata/framework-services/{1}/connected-asset/users/{2}/assets/{3}/connection";

        ConnectionResponse restResult = restClient.callOCFConnectionGetRESTCall(methodName,
                                                                                serverPlatformURLRoot + urlTemplate,
                                                                                serverName,
                                                                                serviceName,
                                                                                userId,
                                                                                assetGUID);

        return restResult.getConnection();
    }



    /**
     * Returns the unique identifier for the asset connected to the requested connection.
     *
     * @param restClient initialized client for calling REST APIs.
     * @param serviceName name of the calling service.
     * @param userId the userId of the requesting user.
     * @param connectionGUID  unique identifier for the connection.
     *
     * @return unique identifier of asset.
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws PropertyServerException there is a problem retrieving information from the property server.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    protected String  getAssetForConnection(OCFRESTClient  restClient,
                                            String         serviceName,
                                            String         userId,
                                            String         connectionGUID) throws InvalidParameterException,
                                                                                  PropertyServerException,
                                                                                  UserNotAuthorizedException
    {
        final String   methodName = "getAssetForConnection";
        final String   urlTemplate = "/servers/{0}/open-metadata/framework-services/{1}/connected-asset/users/{2}/assets/by-connection/{3}";

        GUIDResponse restResult = restClient.callGUIDGetRESTCall(methodName,
                                                                 serverPlatformURLRoot + urlTemplate,
                                                                 serverName,
                                                                 serviceName,
                                                                 userId,
                                                                 connectionGUID);

        return restResult.getGUID();
    }


    /**
     * Returns the anchor asset.
     *
     * @param userId the userId of the requesting user.
     * @param guid unique identifier for the metadata element.
     *
     * @return the anchor asset.
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws PropertyServerException there is a problem retrieving information from the property server.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    public Asset getAnchorAssetFromGUID(String userId,
                                        String guid) throws InvalidParameterException,
                                                            PropertyServerException,
                                                            UserNotAuthorizedException
    {
        final String methodName = "getAnchorAssetFromGUID";
        final String guidParameterName = "guid";
        final String urlTemplate = "/servers/{0}/open-metadata/framework-services/{1}/connected-asset/users/{2}/assets/from-anchor/{3}";

        invalidParameterHandler.validateUserId(userId, methodName);
        invalidParameterHandler.validateGUID(guid, guidParameterName, methodName);

        AssetResponse restResult = ocfRESTClient.callOCFAssetGetRESTCall(methodName,
                                                                         serverPlatformURLRoot + urlTemplate,
                                                                         serverName,
                                                                         serviceURLMarker,
                                                                         userId,
                                                                         guid);

        return restResult.getAsset();
    }


    /**
     * Returns the unique identifier corresponding to the supplied connection.
     *
     * @param userId calling user
     * @param connection   the connection object that contains the properties needed to create the connection.
     *
     * @return guid
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws ConnectionCheckedException there are errors in the configuration of the connection which is preventing
     *                                      the creation of a connector.
     * @throws ConnectorCheckedException there are errors in the initialization of the connector.
     */
    public String saveConnection(String     userId,
                                 Connection connection) throws InvalidParameterException,
                                                               PropertyServerException,
                                                               UserNotAuthorizedException,
                                                               ConnectionCheckedException,
                                                               ConnectorCheckedException
    {
        final String methodName = "saveConnection";
        final String connectionParameterName = "connection";
        final String urlTemplate = "/servers/{0}/open-metadata/framework-services/{1}/connected-asset/users/{2}/connections";

        invalidParameterHandler.validateUserId(userId, methodName);
        invalidParameterHandler.validateObject(connection, connectionParameterName, methodName);

        GUIDResponse restResult = ocfRESTClient.callGUIDPostRESTCall(methodName,
                                                                    serverPlatformURLRoot + urlTemplate,
                                                                    connection,
                                                                    serverName,
                                                                    serviceURLMarker,
                                                                    userId);

        return restResult.getGUID();
    }


    /**
     * Returns the unique identifier corresponding to the supplied connection.
     *
     * @param userId calling user
     * @param assetGUID the unique identifier of an asset to attach the connection to
     * @param connection   the connection object that contains the properties needed to create the connection.
     *
     * @return guid
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws ConnectionCheckedException there are errors in the configuration of the connection which is preventing
     *                                      the creation of a connector.
     * @throws ConnectorCheckedException there are errors in the initialization of the connector.
     */
    public String saveConnection(String     userId,
                                 String     assetGUID,
                                 Connection connection) throws InvalidParameterException,
                                                               PropertyServerException,
                                                               UserNotAuthorizedException,
                                                               ConnectionCheckedException,
                                                               ConnectorCheckedException
    {
        final String methodName = "saveConnection";
        final String connectionParameterName = "connection";
        final String assetParameterName = "assetGUID";
        final String urlTemplate = "/servers/{0}/open-metadata/framework-services/{1}/connected-asset/users/{2}/connections?assetGUID={3}";

        invalidParameterHandler.validateUserId(userId, methodName);
        invalidParameterHandler.validateGUID(assetGUID, assetParameterName, methodName);
        invalidParameterHandler.validateObject(connection, connectionParameterName, methodName);

        GUIDResponse restResult = ocfRESTClient.callGUIDPostRESTCall(methodName,
                                                                     serverPlatformURLRoot + urlTemplate,
                                                                     connection,
                                                                     serverName,
                                                                     serviceURLMarker,
                                                                     userId,
                                                                     assetGUID);

        return restResult.getGUID();
    }


    /*
     * ===============================================
     * ConnectorFactoryInterface
     * ===============================================
     */


    /**
     * Returns the connector corresponding to the supplied connection name.
     *
     * @param userId           userId of user making request.
     * @param connectionName   this may be the qualifiedName or displayName of the connection.
     *
     * @return   connector instance - or null if there is no connection
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws ConnectionCheckedException there are errors in the configuration of the connection which is preventing
     *                                      the creation of a connector.
     * @throws ConnectorCheckedException there are errors in the initialization of the connector.
     * @throws PropertyServerException there is a problem retrieving information from the property server(s).
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    @Override
    public Connector getConnectorByName(String userId,
                                        String connectionName) throws InvalidParameterException,
                                                                      ConnectionCheckedException,
                                                                      ConnectorCheckedException,
                                                                      PropertyServerException,
                                                                      UserNotAuthorizedException
    {
        final String methodName = "getConnectorByName";
        final String nameParameter = "connectionName";

        invalidParameterHandler.validateUserId(userId, methodName);
        invalidParameterHandler.validateName(connectionName, nameParameter, methodName);

        Connection connection = this.getConnectionByName(ocfRESTClient, serviceURLMarker, userId, connectionName);

        if (connection != null)
        {
            return this.getConnectorForConnection(ocfRESTClient,
                                                  serviceURLMarker,
                                                  userId,
                                                  connection,
                                                  methodName);
        }

        return null;
    }


    /**
     * Returns the connector corresponding to the supplied asset GUID.
     *
     * @param userId       userId of user making request.
     * @param assetGUID   the unique id for the asset within the metadata repository.
     *
     * @return    connector instance - or null if there is no connection
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws ConnectionCheckedException there are errors in the configuration of the connection which is preventing
     *                                      the creation of a connector.
     * @throws ConnectorCheckedException there are errors in the initialization of the connector.
     * @throws PropertyServerException there is a problem retrieving information from the property server(s).
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    @Override
    public Connector getConnectorForAsset(String   userId,
                                          String   assetGUID) throws InvalidParameterException,
                                                                     ConnectionCheckedException,
                                                                     ConnectorCheckedException,
                                                                     PropertyServerException,
                                                                     UserNotAuthorizedException
    {
        return this.getConnectorForAsset(userId, assetGUID, null);
    }


    /**
     * Returns the connector corresponding to the supplied asset GUID.
     *
     * @param userId       userId of user making request.
     * @param assetGUID   the unique id for the asset within the metadata repository.
     * @param auditLog    optional logging destination
     *
     * @return    connector instance - or null if there is no connection
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws ConnectionCheckedException there are errors in the configuration of the connection which is preventing
     *                                      the creation of a connector.
     * @throws ConnectorCheckedException there are errors in the initialization of the connector.
     * @throws PropertyServerException there is a problem retrieving information from the property server(s).
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    @Override
    public Connector getConnectorForAsset(String   userId,
                                          String   assetGUID,
                                          AuditLog auditLog) throws InvalidParameterException,
                                                                    ConnectionCheckedException,
                                                                    ConnectorCheckedException,
                                                                    PropertyServerException,
                                                                    UserNotAuthorizedException
    {
        final  String  methodName = "getConnectorForAsset";
        final  String  guidParameter = "assetGUID";

        invalidParameterHandler.validateUserId(userId, methodName);
        invalidParameterHandler.validateGUID(assetGUID, guidParameter, methodName);

        Connection connection = this.getConnectionForAsset(ocfRESTClient, serviceURLMarker, userId, assetGUID);

        if (connection != null)
        {
            Connector connector = this.getConnectorForConnection(ocfRESTClient,
                                                                 serviceURLMarker,
                                                                 userId,
                                                                 connection,
                                                                 methodName);

            if ((auditLog != null) && (connector instanceof AuditLoggingComponent auditLoggingComponent))
            {
                /*
                 * This set up the connector to log messages in the integration connector's audit log.
                 */
                auditLoggingComponent.setAuditLog(auditLog);
            }

            return connector;
        }

        return null;
    }


    /**
     * Returns the connector corresponding to the supplied connection GUID.
     *
     * @param userId           userId of user making request.
     * @param connectionGUID   the unique id for the connection within the metadata repository.
     *
     * @return  connector instance - or null if there is no connection
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws ConnectionCheckedException there are errors in the configuration of the connection which is preventing
     *                                      the creation of a connector.
     * @throws ConnectorCheckedException there are errors in the initialization of the connector.
     * @throws PropertyServerException there is a problem retrieving information from the property server(s).
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     */
    @Override
    public Connector getConnectorByGUID(String userId,
                                        String connectionGUID) throws InvalidParameterException,
                                                                      ConnectionCheckedException,
                                                                      ConnectorCheckedException,
                                                                      PropertyServerException,
                                                                      UserNotAuthorizedException
    {
        final  String  methodName = "getConnectorByGUID";
        final  String  guidParameter = "connectionGUID";

        invalidParameterHandler.validateUserId(userId, methodName);
        invalidParameterHandler.validateGUID(connectionGUID, guidParameter, methodName);

        Connection connection = this.getConnectionByGUID(ocfRESTClient, serviceURLMarker, userId, connectionGUID);

        if (connection != null)
        {
            return this.getConnectorForConnection(ocfRESTClient,
                                                  serviceURLMarker,
                                                  userId,
                                                  connection,
                                                  methodName);
        }

        return null;
    }


    /**
     * Returns the connector corresponding to the supplied connection.
     *
     * @param userId       userId of user making request.
     * @param connection   the connection object that contains the properties needed to create the connection.
     *
     * @return  connector instance
     *
     * @throws InvalidParameterException one of the parameters is null or invalid.
     * @throws ConnectionCheckedException there are errors in the configuration of the connection which is preventing
     *                                      the creation of a connector.
     * @throws ConnectorCheckedException there are errors in the initialization of the connector.
     */
    @Override
    public Connector  getConnectorByConnection(String     userId,
                                               Connection connection) throws InvalidParameterException,
                                                                             ConnectionCheckedException,
                                                                             ConnectorCheckedException
    {
        final  String  methodName = "getConnectorByConnection";

        invalidParameterHandler.validateUserId(userId, methodName);

        return this.getConnectorForConnection(ocfRESTClient, serviceURLMarker, userId, connection, methodName);
    }


}
