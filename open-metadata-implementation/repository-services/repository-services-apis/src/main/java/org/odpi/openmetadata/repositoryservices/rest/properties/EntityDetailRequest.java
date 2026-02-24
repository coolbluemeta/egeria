/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.repositoryservices.rest.properties;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EntityDetail;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;


/**
 * EntityDetailRequest describes the response structure for an OMRS REST API that sends
 * an EntityDetail object.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class EntityDetailRequest extends OMRSAPIRequest
{
    private EntityDetail entity = null;

    /**
     * Default constructor
     */
    public EntityDetailRequest()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public EntityDetailRequest(EntityDetailRequest template)
    {
        super(template);

        if (template != null)
        {
            entity = template.getEntity();
        }
    }


    /**
     * Return the resulting entity object.
     *
     * @return entity object
     */
    public EntityDetail getEntity()
    {
        if (entity == null)
        {
            return null;
        }
        else
        {
            return new EntityDetail(entity);
        }
    }


    /**
     * Set up the resulting entity object.
     *
     * @param entity entity object
     */
    public void setEntity(EntityDetail entity)
    {
        this.entity = entity;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "EntityDetailRequest{" +
                "entity=" + entity +
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
        if (this == objectToCompare)
        {
            return true;
        }
        if (!(objectToCompare instanceof EntityDetailRequest that))
        {
            return false;
        }
        if (!super.equals(objectToCompare))
        {
            return false;
        }
        return Objects.equals(getEntity(), that.getEntity());
    }


    /**
     * Create a hash code for this element type.
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), getEntity());
    }
}
