/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.openmetadata.properties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * OpenMetadataRelationshipList is a response object for passing back a list of RelatedMetadataElements
 * or an exception if the request failed.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class RelatedMetadataElementList
{
    private OpenMetadataElement          startingElement = null;
    private List<RelatedMetadataElement> elementList     = null;
    private String                       mermaidGraph    = null;


    /**
     * Default constructor
     */
    public RelatedMetadataElementList()
    {
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public RelatedMetadataElementList(RelatedMetadataElementList template)
    {
        if (template != null)
        {
            startingElement = template.getStartingElement();
            elementList = template.getElementList();
            mermaidGraph = template.getMermaidGraph();
        }
    }


    /**
     * Return the element used as the starting point for the query.
     *
     * @return element
     */
    public OpenMetadataElement getStartingElement()
    {
        return startingElement;
    }


    /**
     * Set up the element used as the starting point for the query.
     *
     * @param startingElement element
     */
    public void setStartingElement(OpenMetadataElement startingElement)
    {
        this.startingElement = startingElement;
    }


    /**
     * Return the list of metadata elements.
     *
     * @return result object
     */
    public List<RelatedMetadataElement> getElementList()
    {
        return elementList;
    }


    /**
     * Set up the metadata element to return.
     *
     * @param elementList result object
     */
    public void setElementList(List<RelatedMetadataElement> elementList)
    {
        this.elementList = elementList;
    }


    /**
     * Return the mermaid string used to render a graph.
     *
     * @return string in Mermaid markdown
     */
    public String getMermaidGraph()
    {
        return mermaidGraph;
    }


    /**
     * Set up mermaid string used to render a graph.
     *
     * @param mermaidGraph string in Mermaid markdown
     */
    public void setMermaidGraph(String mermaidGraph)
    {
        this.mermaidGraph = mermaidGraph;
    }


    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "RelatedMetadataElementList{" +
                "startingElement=" + startingElement +
                ", elementList=" + elementList +
                ", mermaidGraph='" + mermaidGraph + '\'' +
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
        RelatedMetadataElementList that = (RelatedMetadataElementList) objectToCompare;
        return Objects.equals(startingElement, that.startingElement) &&
                Objects.equals(elementList, that.elementList) &&
                Objects.equals(mermaidGraph, that.mermaidGraph);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(startingElement, elementList, mermaidGraph);
    }
}
