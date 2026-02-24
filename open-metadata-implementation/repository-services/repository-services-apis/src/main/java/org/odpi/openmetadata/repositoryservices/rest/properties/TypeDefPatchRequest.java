/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.repositoryservices.rest.properties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefPatch;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * TypeDefPatchRequest provides the patch structure for an OMRS API call
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class TypeDefPatchRequest extends OMRSAPIRequest
{
    private TypeDefPatch typeDefPatch = null;


    /**
     * Default constructor
     */
    public TypeDefPatchRequest()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public TypeDefPatchRequest(TypeDefPatchRequest template)
    {
        super(template);

        if (template != null)
        {
            typeDefPatch = template.getTypeDefPatch();
        }
    }


    /**
     * Return the resulting TypeDef object.
     *
     * @return TypeDef object
     */
    public TypeDefPatch getTypeDefPatch()
    {
        if (typeDefPatch == null)
        {
            return null;
        }
        else
        {
            return typeDefPatch;
        }
    }


    /**
     * Set up the response Typedef object
     *
     * @param typeDefPatch Typedef object
     */
    public void setTypeDefPatch(TypeDefPatch typeDefPatch)
    {
        this.typeDefPatch = typeDefPatch;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "TypeDefPatchRequest{" +
                "typeDefPatch=" + typeDefPatch +
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
        if (!(objectToCompare instanceof TypeDefPatchRequest that))
        {
            return false;
        }
        if (!super.equals(objectToCompare))
        {
            return false;
        }
        return Objects.equals(getTypeDefPatch(), that.getTypeDefPatch());
    }


    /**
     * Create a hash code for this element type.
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), getTypeDefPatch());
    }
}
