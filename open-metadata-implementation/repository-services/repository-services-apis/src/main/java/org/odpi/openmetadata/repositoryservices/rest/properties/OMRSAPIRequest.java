/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.repositoryservices.rest.properties;

import com.fasterxml.jackson.annotation.*;
import org.odpi.openmetadata.frameworks.auditlog.requestid.RequestIdService;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EntityDetail;

import java.io.Serializable;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * OMRSAPIRequest provides a common header for complex OMRS request to the OMRS REST API.   It manages
 * the parameters in the request body.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = AttributeTypeDefRequest.class, name = "AttributeTypeDefRequest"),
                @JsonSubTypes.Type(value = AttributeTypeDefCategoryRequest.class, name = "AttributeTypeDefCategoryRequest"),
                @JsonSubTypes.Type(value = OMRSAPIFindRequest.class, name = "OMRSAPIFindRequest"),
                @JsonSubTypes.Type(value = GetRequest.class, name = "GetRequest"),
                @JsonSubTypes.Type(value = TypeDefReIdentifyRequest.class, name = "TypeDefReIdentifyRequest"),
                @JsonSubTypes.Type(value = TypeDefRequest.class, name = "TypeDefRequest"),
                @JsonSubTypes.Type(value = TypeDefCategoryRequest.class, name = "TypeDefCategoryRequest"),
                @JsonSubTypes.Type(value = TypeDefPatchRequest.class, name = "TypeDefPatchRequest"),
                @JsonSubTypes.Type(value = TypeDefPropertiesRequest.class, name = "TypeDefPropertiesRequest"),
                @JsonSubTypes.Type(value = InstancePropertiesRequest.class, name = "InstancePropertiesRequest"),
                @JsonSubTypes.Type(value = InstanceStatusRequest.class, name = "InstanceStatusRequest"),
                @JsonSubTypes.Type(value = ClassificationRequest.class, name = "ClassificationRequest"),
                @JsonSubTypes.Type(value = InstanceGraphRequest.class, name = "InstanceGraphRequest"),
                @JsonSubTypes.Type(value = MetadataCollectionIdRequest.class, name = "MetadataCollectionIdRequest"),
                @JsonSubTypes.Type(value = EntityCreateRequest.class, name = "EntityCreateRequest"),
                @JsonSubTypes.Type(value = EntityDetailRequest.class, name = "EntityDetailRequest"),
                @JsonSubTypes.Type(value = EntityProxyRequest.class, name = "EntityProxyRequest"),
                @JsonSubTypes.Type(value = RelationshipCreateRequest.class, name = "RelationshipCreateRequest"),
                @JsonSubTypes.Type(value = RelationshipRequest.class, name = "RelationshipRequest"),
        })
public class OMRSAPIRequest implements RequestIdService
{
    private String requestId = null;


    /**
     * Default constructor
     */
    public OMRSAPIRequest()
    {
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public OMRSAPIRequest(OMRSAPIRequest template)
    {
        if (template != null)
        {
            this.requestId = template.getRequestId();
        }
    }

    /**
     * Return the unique identifier for the request.
     *
     * @return string guid
     */
    @Override
    public String getRequestId()
    {
        return requestId;
    }


    /**
     * Set up the unique identifier for the request.
     *
     * @param requestId string guid
     */
    @Override
    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "OMRSAPIRequest{" +
                "requestId='" + requestId + '\'' +
                '}';
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
        if (objectToCompare == null || getClass() != objectToCompare.getClass()) return false;
        OMRSAPIRequest that = (OMRSAPIRequest) objectToCompare;
        return Objects.equals(requestId, that.requestId);
    }


    /**
     * Create a hash code for this element type.
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(requestId);
    }
}
