/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.assetmanager.rest;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.properties.schema.SchemaTypeProperties;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * SchemaTypeRequestBody describes the request body used to create/update schema type properties.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class SchemaTypeRequestBody extends UpdateRequestBody
{
    private SchemaTypeProperties elementProperties = null;


    /**
     * Default constructor
     */
    public SchemaTypeRequestBody()
    {
        super();
    }


    /**
     * Copy/clone constructor.
     *
     * @param template object to copy
     */
    public SchemaTypeRequestBody(SchemaTypeRequestBody template)
    {
        super(template);

        if (template != null)
        {
            elementProperties = template.getElementProperties();
        }
    }


    /**
     * Return the properties for the element.
     *
     * @return properties object
     */
    public SchemaTypeProperties getElementProperties()
    {
        return elementProperties;
    }


    /**
     * Set up the properties for the element.
     *
     * @param elementProperties properties object
     */
    public void setElementProperties(SchemaTypeProperties elementProperties)
    {
        this.elementProperties = elementProperties;
    }


    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "SchemaTypeRequestBody{" +
                       "elementProperties=" + elementProperties +
                       ", metadataCorrelationProperties=" + getMetadataCorrelationProperties() +
                       ", effectiveTime=" + getEffectiveTime() +
                       '}';
    }


    /**
     * Return comparison result based on the content of the properties.
     *
     * @param objectToCompare test object
     * @return result of comparison
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
        if (! super.equals(objectToCompare))
        {
            return false;
        }
        SchemaTypeRequestBody that = (SchemaTypeRequestBody) objectToCompare;
        return Objects.equals(elementProperties, that.elementProperties);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), elementProperties);
    }
}
