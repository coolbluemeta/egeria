/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.openmetadata.metadataelements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.properties.actors.PersonRoleProperties;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * PersonalRoleElement contains the properties and header for a person role assigned to a profile retrieved from the metadata repository.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ActorRoleElement implements MetadataElement
{
    private ElementHeader        elementHeader  = null;
    private PersonRoleProperties properties = null;
    private RelatedBy            relatedBy  = null;


    /**
     * Default constructor
     */
    public ActorRoleElement()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public ActorRoleElement(ActorRoleElement template)
    {
        if (template != null)
        {
            elementHeader = template.getElementHeader();
            properties = template.getProperties();
            relatedBy  = template.getRelatedBy();
        }
    }


    /**
     * Return the element header associated with the properties.
     *
     * @return element header object
     */
    @Override
    public ElementHeader getElementHeader()
    {
        return elementHeader;
    }


    /**
     * Set up the element header associated with the properties.
     *
     * @param header element header object
     */
    @Override
    public void setElementHeader(ElementHeader header)
    {
        this.elementHeader = header;
    }


    /**
     * Return the properties of the role.
     *
     * @return properties
     */
    public PersonRoleProperties getProperties()
    {
        return properties;
    }


    /**
     * Set up the role properties.
     *
     * @param properties  properties
     */
    public void setProperties(PersonRoleProperties properties)
    {
        this.properties = properties;
    }


    /**
     * Return details of the relationship used to retrieve this element.
     * Will be null if the element was retrieved directly rather than via a relationship.
     *
     * @return list of element stubs
     */
    public RelatedBy getRelatedBy()
    {
        return relatedBy;
    }


    /**
     * Set up details of the relationship used to retrieve this element.
     * Will be null if the element was retrieved directly rather than via a relationship.
     *
     * @param relatedBy relationship details
     */
    public void setRelatedBy(RelatedBy relatedBy)
    {
        this.relatedBy = relatedBy;
    }


    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "ActorRoleElement{" +
                       "elementHeader=" + elementHeader +
                       ", properties=" + properties +
                       ", relatedBy=" + relatedBy +
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
        ActorRoleElement that = (ActorRoleElement) objectToCompare;
        return Objects.equals(elementHeader, that.elementHeader) &&
                       Objects.equals(properties, that.properties) &&
                       Objects.equals(relatedBy, that.relatedBy);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), elementHeader, properties, relatedBy);
    }
}
