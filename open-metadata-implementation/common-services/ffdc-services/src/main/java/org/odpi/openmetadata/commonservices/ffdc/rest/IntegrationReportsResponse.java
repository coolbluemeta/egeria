/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.commonservices.ffdc.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.reports.ConnectorActivityReport;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;


/**
 * IntegrationReportsResponse is the response structure used on REST API calls that returns a
 * list of ConnectorActivityReport objects as a response.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class IntegrationReportsResponse extends FFDCResponseBase
{
    private List<ConnectorActivityReport> elements = null;

    /**
     * Default constructor
     */
    public IntegrationReportsResponse()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public IntegrationReportsResponse(IntegrationReportsResponse template)
    {
        super(template);

        if (template != null)
        {
            this.elements = template.getElements();
        }
    }


    /**
     * Return the properties objects.
     *
     * @return list of properties objects
     */
    public List<ConnectorActivityReport> getElements()
    {
        if (elements == null)
        {
            return null;
        }
        else
        {
            return elements;
        }
    }


    /**
     * Set up the properties objects.
     *
     * @param elements  list of properties objects
     */
    public void setElements(List<ConnectorActivityReport> elements)
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
        return "IntegrationReportsResponse{" +
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
        IntegrationReportsResponse that = (IntegrationReportsResponse) objectToCompare;
        return Objects.equals(getElements(), that.getElements());
    }

    
    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), getElements());
    }
}
