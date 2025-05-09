/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.connectors.properties;

import org.odpi.openmetadata.frameworks.connectors.properties.beans.ConnectorType;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.EmbeddedConnection;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.Endpoint;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.VirtualConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The VirtualConnectionDetails is an object that contains the properties needed to create and initialise a
 * virtual connector to access a virtual asset that is constructed from access to one of more other assets.
 * Connectors are uses to access the underlying assets.
 * <br><br>
 * The properties for VirtualConnectionDetails are those for ConnectionDetails plus a list of
 * connections for the embedded connectors.
 */
public class VirtualConnectionDetails extends ConnectionDetails
{
    protected VirtualConnection connectionBean;


    /**
     * Bean constructor
     *
     * @param connectionBean bean containing the properties
     */
    public VirtualConnectionDetails(VirtualConnection connectionBean)
    {
        super(connectionBean);

        if (connectionBean == null)
        {
            this.connectionBean = new VirtualConnection();
        }
        else
        {
            this.connectionBean = connectionBean;
        }
    }


    /**
     * Copy/clone Constructor to return a copy of a connection object that is connected to an asset.
     *
     * @param templateConnection template object to copy.
     */
    public VirtualConnectionDetails(VirtualConnectionDetails templateConnection)
    {
        super(templateConnection);

        if (templateConnection == null)
        {
            this.connectionBean = new VirtualConnection();
        }
        else
        {
            this.connectionBean = new VirtualConnection(templateConnection.getConnectionBean());
        }
    }


    /**
     * Return the bean with all the properties.
     *
     * @return connection bean
     */
    @Override
    protected VirtualConnection getConnectionBean()
    {
        return connectionBean;
    }


    /**
     * Returns the stored display name property for the connection.
     * Null means no displayName is available.
     *
     * @return displayName
     */
    public List<EmbeddedConnectionDetails> getEmbeddedConnections()
    {
        List<EmbeddedConnection> embeddedConnectionBeans = connectionBean.getEmbeddedConnections();

        if (embeddedConnectionBeans == null)
        {
            return null;
        }
        else
        {
            List<EmbeddedConnectionDetails> embeddedConnectionDetailsList = new ArrayList<>();

            for (EmbeddedConnection embeddedConnectionBean : embeddedConnectionBeans)
            {
                embeddedConnectionDetailsList.add(new EmbeddedConnectionDetails(embeddedConnectionBean));
            }

            return embeddedConnectionDetailsList;
        }
    }


    /**
     * Returns a formatted string with the connection name.  It is used in formatting error messages for the
     * exceptions thrown by consuming components.  It is extremely cautious because most of the exceptions
     * are reporting a malformed connection object so who knows what else is wrong with it.
     * Within the connection are 2 possible properties that could
     * contain the connection name:
     *   ** qualifiedName - this is a uniqueName and should be there
     *   ** displayName - shorter simpler name but may not be unique - so may not identify the connection in error
     * This method inspects these properties and builds up a string to represent the connection name
     *
     * @return connection name
     */
    @Override
    public String  getConnectionName()
    {
        String   connectionName = "<Unknown>"; /* if all properties are blank */
        String   qualifiedName = connectionBean.getQualifiedName();
        String   displayName = connectionBean.getDisplayName();

        /*
         * The qualifiedName is preferred because it is unique.
         */
        if (qualifiedName != null && (!qualifiedName.isEmpty()))
        {
            /*
             * Use qualified name.
             */
            connectionName = qualifiedName;
        }
        else if (displayName != null && (!displayName.isEmpty()))
        {
            /*
             * The qualifiedName is not set but the displayName is available so use it.
             */
            connectionName = displayName;
        }

        return connectionName;
    }


    /**
     * Returns the stored description property for the connection.
     * If no description is provided then null is returned.
     *
     * @return description
     */
    @Override
    public String getDescription()
    {
        return connectionBean.getDescription();
    }


    /**
     * Returns a copy of the properties for this connection's connector type.
     * A null means there is no connection type.
     *
     * @return connector type for the connection
     */
    @Override
    public ConnectorTypeDetails getConnectorType()
    {
        ConnectorType connectorType = connectionBean.getConnectorType();

        if (connectorType == null)
        {
            return null;
        }
        else
        {
            return new ConnectorTypeDetails(connectorType);
        }
    }


    /**
     * Returns a copy of the properties for this connection's endpoint.
     * Null means no endpoint information available.
     *
     * @return endpoint for the connection
     */
    @Override
    public EndpointDetails getEndpoint()
    {
        Endpoint endpoint = connectionBean.getEndpoint();

        if (endpoint == null)
        {
            return null;
        }
        else
        {
            return new EndpointDetails(endpoint);
        }
    }


    /**
     * Return a copy of the secured properties.  Null means no secured properties are available.
     * This method is protected so only OCF (or subclasses) can access them.  When Connector is passed to calling
     * OMAS, the secured properties are not available.
     *
     * @return secured properties typically user credentials for the connection
     */
    @Override
    public Map<String, String> getSecuredProperties()
    {
        return connectionBean.getSecuredProperties();
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return connectionBean.toString();
    }


    /**
     * Compare the values of the supplied object with those stored in the current object.
     *
     * @param objectToCompare supplied object
     * @return boolean result of comparison
     */
    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare)
        {
            return true;
        }
        if (objectToCompare == null || getClass() != objectToCompare.getClass())
        {
            return false;
        }
        if (!super.equals(objectToCompare))
        {
            return false;
        }
        VirtualConnectionDetails that = (VirtualConnectionDetails) objectToCompare;
        return Objects.equals(getConnectionBean(), that.getConnectionBean());
    }


    /**
     * Hash of properties
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), getConnectionBean());
    }
}