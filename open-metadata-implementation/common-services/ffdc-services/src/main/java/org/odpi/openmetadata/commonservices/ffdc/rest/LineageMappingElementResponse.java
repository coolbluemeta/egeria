/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.commonservices.ffdc.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.LineageMappingElement;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;


/**
 * LineageMappingElementResponse is the response structure used on the OMAS REST API calls that return the properties
 * for a relationship.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class LineageMappingElementResponse extends FFDCResponseBase
{
    private LineageMappingElement element = null;


    /**
     * Default constructor
     */
    public LineageMappingElementResponse()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public LineageMappingElementResponse(LineageMappingElementResponse template)
    {
        super(template);

        if (template != null)
        {
            this.element = template.getElement();
        }
    }


    /**
     * Return the element result.
     *
     * @return bean
     */
    public LineageMappingElement getElement()
    {
        return element;
    }


    /**
     * Set up the element result.
     *
     * @param element  bean
     */
    public void setElement(LineageMappingElement element)
    {
        this.element = element;
    }


    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "LineageMappingElementResponse{" +
                "element=" + element +
                "} " + super.toString();
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
        if (!(objectToCompare instanceof LineageMappingElementResponse))
        {
            return false;
        }
        if (!super.equals(objectToCompare))
        {
            return false;
        }
        LineageMappingElementResponse that = (LineageMappingElementResponse) objectToCompare;
        return Objects.equals(element, that.element);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(element);
    }
}
