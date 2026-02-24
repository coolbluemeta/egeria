/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.repositoryservices.rest.properties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDef;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefProperties;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * TypeDefPropertiesRequest provides the request structure for an OMRS API call that passes properties for a TypeDef
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class TypeDefPropertiesRequest extends OMRSAPIRequest
{
    private TypeDefProperties typeDefProperties = null;


    /**
     * Default constructor
     */
    public TypeDefPropertiesRequest()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public TypeDefPropertiesRequest(TypeDefPropertiesRequest template)
    {
        super(template);

        if (template != null)
        {
            typeDefProperties = template.getTypeDefProperties();
        }
    }


    /**
     * Return the resulting TypeDef object.
     *
     * @return TypeDef object
     */
    public TypeDefProperties getTypeDefProperties()
    {
        return typeDefProperties;
    }


    /**
     * Set up the response Typedef object
     *
     * @param typeDefProperties Typedef object
     */
    public void setTypeDefProperties(TypeDefProperties typeDefProperties)
    {
        this.typeDefProperties = typeDefProperties;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "TypeDefPropertiesRequest{" +
                "typeDefProperties=" + typeDefProperties +
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
        if (!(objectToCompare instanceof TypeDefPropertiesRequest that))
        {
            return false;
        }
        if (!super.equals(objectToCompare))
        {
            return false;
        }
        return Objects.equals(getTypeDefProperties(), that.getTypeDefProperties());
    }


    /**
     * Create a hash code for this element type.
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), getTypeDefProperties());
    }
}
