/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.openmetadata.metadataelements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.properties.actors.ActorRoleProperties;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * SolutionRoleElement contains the properties and header for an actor role assigned to a solution retrieved from the metadata repository.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class SolutionRoleElement extends ActorRoleElement
{
    private List<RelatedMetadataElementSummary> solutionComponents = null;


    /**
     * Default constructor
     */
    public SolutionRoleElement()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public SolutionRoleElement(SolutionRoleElement template)
    {
        super (template);

        if (template != null)
        {
            solutionComponents = template.getSolutionComponents();
        }
    }


    /**
     * Return details of the relationships to solution components.
     *
     * @return list of element stubs
     */
    public List<RelatedMetadataElementSummary> getSolutionComponents()
    {
        return solutionComponents;
    }


    /**
     * Set up details of the relationships to solution components.
     *
     * @param solutionComponents relationship details
     */
    public void setSolutionComponents(List<RelatedMetadataElementSummary> solutionComponents)
    {
        this.solutionComponents = solutionComponents;
    }


    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "SolutionRoleElement{" +
                "solutionComponents=" + solutionComponents +
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
        if (!super.equals(objectToCompare)) return false;
        SolutionRoleElement that = (SolutionRoleElement) objectToCompare;
        return Objects.equals(solutionComponents, that.solutionComponents);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), solutionComponents);
    }
}
