/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.properties.informationsupplychains;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.properties.ReferenceableProperties;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * InformationSupplyChainSegmentProperties identifies a portion of an information supply chain that is the
 * responsibility of a particular party.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class InformationSupplyChainSegmentProperties extends ReferenceableProperties
{
    private String              displayName          = null;
    private String              description          = null;
    private String              scope                = null;




    /**
     * Default constructor
     */
    public InformationSupplyChainSegmentProperties()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public InformationSupplyChainSegmentProperties(InformationSupplyChainSegmentProperties template)
    {
        super(template);

        if (template != null)
        {
            this.displayName          = template.getDisplayName();
            this.description          = template.getDescription();
            this.scope                = template.getScope();

        }
    }


    /**
     * Return the display name for this information supply chain segment (normally a shortened form of the qualified name).
     *
     * @return string name
     */
    public String getDisplayName()
    {
        return displayName;
    }


    /**
     * Set up the display name for this information supply chain segment (normally a shortened form of the qualified name).
     *
     * @param displayName string name
     */
    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }


    /**
     * Return the description for this information supply chain segment.
     *
     * @return string description
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Set up the description for this information supply chain segment.
     *
     * @param description string
     */
    public void setDescription(String description)
    {
        this.description = description;
    }


    /**
     * Return the scope for this information supply chain segment.
     *
     * @return String
     */
    public String getScope()
    {
        return scope;
    }


    /**
     * Set up the scope for this information supply chain segment.
     *
     * @param scope String
     */
    public void setScope(String scope)
    {
        this.scope = scope;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "InformationSupplyChainSegmentProperties{" +
                "displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", scope='" + scope + '\'' +
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
        if (! (objectToCompare instanceof InformationSupplyChainSegmentProperties that))
        {
            return false;
        }
        if (! super.equals(objectToCompare))
        {
            return false;
        }
        return Objects.equals(displayName, that.displayName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(scope, that.scope);
    }


    /**
     * Return hash code based on properties.
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), displayName, description, scope);
    }
}
