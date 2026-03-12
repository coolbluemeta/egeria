/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.viewservices.metadataexpert.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.commonservices.ffdc.rest.FFDCResponseBase;
import org.odpi.openmetadata.frameworks.openmetadata.search.PropertyComparisonOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * PropertyComparisonOperatorListResponse is a response object for passing back a list of enum values or an exception if the request failed.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class PropertyComparisonOperatorListResponse extends FFDCResponseBase
{
    private List<PropertyComparisonOperator> values = null;


    /**
     * Default constructor
     */
    public PropertyComparisonOperatorListResponse()
    {
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public PropertyComparisonOperatorListResponse(PropertyComparisonOperatorListResponse template)
    {
        super(template);

        if (template != null)
        {
            values = template.getValues();
        }
    }


    /**
     * Return the list of values.
     *
     * @return result object
     */
    public List<PropertyComparisonOperator> getValues()
    {
        if (values == null)
        {
            return null;
        }
        else if (values.isEmpty())
        {
            return null;
        }
        else
        {
            return new ArrayList<>(values);
        }
    }


    /**
     * Set up the values to return.
     *
     * @param values result object
     */
    public void setValues(List<PropertyComparisonOperator> values)
    {
        this.values = values;
    }


    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "PropertyComparisonOperatorListResponse{" +
                "values=" + values +
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
        PropertyComparisonOperatorListResponse that = (PropertyComparisonOperatorListResponse) objectToCompare;
        return Objects.equals(values, that.values);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), values);
    }
}
