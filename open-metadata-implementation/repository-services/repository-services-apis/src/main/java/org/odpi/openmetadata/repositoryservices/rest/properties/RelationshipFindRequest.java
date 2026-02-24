/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.repositoryservices.rest.properties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.search.EndMatchCriteria;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * RelationshipFindRequest restricts a find request to relationships linked with specific entities.
 */
@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelationshipFindRequest extends InstanceFindRequest
{
    private List<String>     end1EntityGUIDs = null;
    private List<String>     end2EntityGUIDs  = null;
    private EndMatchCriteria endMatchCriteria = null;


    /**
     * Default constructor
     */
    public RelationshipFindRequest()
    {
        super();
    }


    /**
     * Copy/clone constructor.
     *
     * @param template object to copy
     */
    public RelationshipFindRequest(RelationshipFindRequest template)
    {
        super(template);

        if (template != null)
        {
            this.end1EntityGUIDs = template.getEnd1EntityGUIDs();
            this.end2EntityGUIDs = template.getEnd2EntityGUIDs();
            this.endMatchCriteria = template.getEndMatchCriteria();
        }
    }


    /**
     * Return the list of entity guids used to match end 1 of the relationships.
     *
     * @return list of guids
     */
    public List<String> getEnd1EntityGUIDs()
    {
        return end1EntityGUIDs;
    }


    /**
     * Set up the list of entity guids used to match end 1 of the relationships.
     *
     * @param end1EntityGUIDs list of guids
     */
    public void setEnd1EntityGUIDs(List<String> end1EntityGUIDs)
    {
        this.end1EntityGUIDs = end1EntityGUIDs;
    }


    /**
     * Return the list of entity guids used to match end 2 of the relationships.
     *
     * @return list of guids
     */
    public List<String> getEnd2EntityGUIDs()
    {
        return end2EntityGUIDs;
    }


    /**
     * Set up the list of entity guids used to match end 2 of the relationships.
     *
     * @param end2EntityGUIDs list of guids
     */
    public void setEnd2EntityGUIDs(List<String> end2EntityGUIDs)
    {
        this.end2EntityGUIDs = end2EntityGUIDs;
    }


    /**
     * Return the end matching search criteria.
     *
     * @return SearchClassifications
     */
    public EndMatchCriteria getEndMatchCriteria()
    {
        return endMatchCriteria;
    }


    /**
     * Set the end matching search criteria.
     *
     * @param endMatchCriteria to set as search criteria
     */
    public void setEndMatchCriteria(EndMatchCriteria endMatchCriteria)
    {
        this.endMatchCriteria = endMatchCriteria;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "RelationshipFindRequest{" +
                "end1EntityGUIDs=" + end1EntityGUIDs +
                ", end2EntityGUIDs=" + end2EntityGUIDs +
                ", endMatchCriteria=" + endMatchCriteria +
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
        if (objectToCompare == null || getClass() != objectToCompare.getClass()) return false;
        if (!super.equals(objectToCompare)) return false;
        RelationshipFindRequest that = (RelationshipFindRequest) objectToCompare;
        return Objects.equals(end1EntityGUIDs, that.end1EntityGUIDs) &&
                Objects.equals(end2EntityGUIDs, that.end2EntityGUIDs) &&
                endMatchCriteria == that.endMatchCriteria;
    }

    /**
     * Create a hash code for this element type.
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), end1EntityGUIDs, end2EntityGUIDs, endMatchCriteria);
    }

}
