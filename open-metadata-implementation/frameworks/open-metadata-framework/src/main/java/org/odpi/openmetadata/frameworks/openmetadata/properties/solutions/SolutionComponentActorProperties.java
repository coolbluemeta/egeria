/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.properties.solutions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.properties.RelationshipProperties;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * SolutionComponentActorProperties represents a SolutionComponentActor relationship.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class SolutionComponentActorProperties extends RelationshipProperties
{
    private String description    = null;
    private String role           = null;

    /**
     * Default constructor
     */
    public SolutionComponentActorProperties()
    {
        super();
        super.setTypeName(OpenMetadataType.SOLUTION_COMPONENT_ACTOR_RELATIONSHIP.typeName);
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public SolutionComponentActorProperties(SolutionComponentActorProperties template)
    {
        super(template);

        if (template != null)
        {
            this.description    = template.getDescription();
            this.role           = template.getRole();
        }
    }


    /**
     * Return the description for this element.
     *
     * @return string description
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Set up the description for this element.
     *
     * @param description string
     */
    public void setDescription(String description)
    {
        this.description = description;
    }


    /**
     * Return the role of this role in supporting the behaviour of element it is derived from.
     *
     * @return String
     */
    public String getRole()
    {
        return role;
    }


    /**
     * Set up the role of this role in supporting the behaviour of element it is derived from.
     *
     * @param role String
     */
    public void setRole(String role)
    {
        this.role = role;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "SolutionComponentActorProperties{" +
                "description='" + description + '\'' +
                ", role='" + role + '\'' +
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
        if (! (objectToCompare instanceof SolutionComponentActorProperties that))
        {
            return false;
        }
        if (! super.equals(objectToCompare))
        {
            return false;
        }
        return Objects.equals(description, that.description) &&
                       Objects.equals(role, that.role);
    }


    /**
     * Return hash code based on properties.
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), description, role);
    }
}
