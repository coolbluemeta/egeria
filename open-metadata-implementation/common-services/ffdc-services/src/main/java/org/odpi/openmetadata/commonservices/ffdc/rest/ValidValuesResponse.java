/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.commonservices.ffdc.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.ValidValueElement;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * ValidValuesResponse is a response object for passing back a list of valid value objects.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ValidValuesResponse extends FFDCResponseBase
{
    private List<ValidValueElement> elements = null;


    /**
     * Default constructor
     */
    public ValidValuesResponse()
    {
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public ValidValuesResponse(ValidValuesResponse template)
    {
        super(template);

        if (template != null)
        {
            elements = template.getElements();
        }
    }


    /**
     * Return the list of metadata elements.
     *
     * @return result object
     */
    public List<ValidValueElement> getElements()
    {
        return elements;
    }


    /**
     * Set up the list of metadata elements to return.
     *
     * @param elements result object
     */
    public void setElements(List<ValidValueElement> elements)
    {
        this.elements = elements;
    }


    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "ValidValuesResponse{" +
                "elements=" + elements +
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
        if (objectToCompare == null || getClass() != objectToCompare.getClass())
        {
            return false;
        }
        if (!super.equals(objectToCompare))
        {
            return false;
        }
        ValidValuesResponse that = (ValidValuesResponse) objectToCompare;
        return Objects.equals(elements, that.elements);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), elements);
    }
}
