/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.repositoryservices.rest.properties;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceStatus;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * InstanceStatusRequest carries the properties needed to update the status of an entity, relationship, or classification.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class InstanceStatusRequest extends OMRSAPIRequest
{
    private InstanceStatus instanceStatus = null;


    /**
     * Default constructor
     */
    public InstanceStatusRequest()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public InstanceStatusRequest(InstanceStatusRequest template)
    {
        super(template);

        if (template != null)
        {
            this.instanceStatus = template.getInstanceStatus();
        }
    }


    /**
     * Return the list of properties for the new entity.
     *
     * @return instance properties object
     */
    public InstanceStatus getInstanceStatus()
    {
        return instanceStatus;
    }


    /**
     * Set up the initial properties for the entity.
     *
     * @param instanceStatus InstanceProperties object
     */
    public void setInstanceStatus(InstanceStatus instanceStatus)
    {
        this.instanceStatus = instanceStatus;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "InstanceStatusRequest{" +
                "instanceStatus=" + instanceStatus +
                "} " + super.toString();
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
        if (!super.equals(objectToCompare)) return false;
        InstanceStatusRequest that = (InstanceStatusRequest) objectToCompare;
        return instanceStatus == that.instanceStatus;
    }


    /**
     * Create a hash code for this element type.
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), instanceStatus);
    }
}
