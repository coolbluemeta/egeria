/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.metadataelements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * GovernanceDefinitionGraph documents the linked governance definitions of the governance program.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GovernanceDefinitionGraph extends GovernanceDefinitionElement
{
    private List<RelatedElementStub> parents            = null;
    private List<RelatedElementStub> peers              = null;
    private List<RelatedElementStub> children           = null;
    private List<RelatedElementStub> metrics            = null;
    private List<RelatedElementStub> externalReferences = null;
    private List<RelatedElementStub> others             = null;
    private String                   mermaidGraph       = null;


    /**
     * Default Constructor
     */
    public GovernanceDefinitionGraph()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public GovernanceDefinitionGraph(GovernanceDefinitionGraph template)
    {
        super (template);

        if (template != null)
        {
            parents = template.getParents();
            peers = template.getPeers();
            children = template.getChildren();
            metrics = template.getMetrics();
            externalReferences = template.getExternalReferences();
            others = template.getOthers();
            mermaidGraph    = template.getMermaidGraph();
        }
    }


    /**
     * Return the list of governance definitions that are requirements for this governance definition.
     *
     * @return list of governance definition stubs
     */
    public List<RelatedElementStub> getParents()
    {
        return parents;
    }


    /**
     * Set up the list of governance definition that are requirements for this governance definition.
     *
     * @param parents list of governance definition stubs
     */
    public void setParents(List<RelatedElementStub> parents)
    {
        this.parents = parents;
    }


    /**
     * Return the list of peer governance definitions that are related to this governance definition.
     *
     * @return list of governance definition stubs
     */
    public List<RelatedElementStub> getPeers()
    {
        return peers;
    }


    /**
     * Set up the list of governance definitions that are related to this governance definition.
     *
     * @param peers list of governance definition stubs
     */
    public void setPeers(List<RelatedElementStub> peers)
    {
        this.peers = peers;
    }


    /**
     * Return the governance definitions that support this governance definition.
     *
     * @return list of governance definition stubs
     */
    public List<RelatedElementStub> getChildren()
    {
        return children;
    }


    /**
     * Set up the governance definitions that support this governance definition.
     *
     * @param children list of governance definition stubs
     */
    public void setChildren(List<RelatedElementStub> children)
    {
        this.children = children;
    }


    /**
     * Return the governance metrics that measure this governance definition.
     *
     * @return list of governance definition stubs
     */
    public List<RelatedElementStub> getMetrics()
    {
        return metrics;
    }


    /**
     * Set up the governance metrics that measure this governance definition.
     *
     * @param metrics list of governance definition stubs
     */
    public void setMetrics(List<RelatedElementStub> metrics)
    {
        this.metrics = metrics;
    }


    /**
     * Return details of the external references that have been linked to this governance definition.
     *
     * @return list of links to external references
     */
    public List<RelatedElementStub> getExternalReferences()
    {
        return externalReferences;
    }


    /**
     * Set up the details of the external references that have been linked to this governance definition.
     *
     * @param externalReferences list of links to external references
     */
    public void setExternalReferences(List<RelatedElementStub> externalReferences)
    {
        this.externalReferences = externalReferences;
    }


    /**
     * Return details of other relationships
     *
     * @return details of other related elements
     */
    public List<RelatedElementStub> getOthers()
    {
        return others;
    }


    /**
     * Set details of other relationships.
     *
     * @param others details of other related elements
     */
    public void setOthers(List<RelatedElementStub> others)
    {
        this.others = others;
    }


    /**
     *
     * @return mermaid markdown
     */
    public String getMermaidGraph()
    {
        return mermaidGraph;
    }


    /**
     * Set up the graph view of the information supply chain.
     *
     * @param mermaidGraph mermaid markdown
     */
    public void setMermaidGraph(String mermaidGraph)
    {
        this.mermaidGraph = mermaidGraph;
    }


    /**
     * JSON-style toString
     *
     * @return string containing the properties and their values
     */
    @Override
    public String toString()
    {
        return "GovernanceDefinitionGraph{" +
                "parents=" + parents +
                ", peers=" + peers +
                ", children=" + children +
                ", metrics=" + metrics +
                ", externalReferences=" + externalReferences +
                ", others=" + others +
                ", mermaidGraph='" + mermaidGraph + '\'' +
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
        if (! (objectToCompare instanceof GovernanceDefinitionGraph that))
        {
            return false;
        }
        if (! super.equals(objectToCompare))
        {
            return false;
        }
        return Objects.equals(parents, that.parents) && Objects.equals(peers, that.peers) &&
                       Objects.equals(children, that.children) &&
                       Objects.equals(metrics, that.metrics) &&
                       Objects.equals(others, that.others) &&
                       Objects.equals(externalReferences, that.externalReferences) &&
                       Objects.equals(mermaidGraph, that.mermaidGraph);
    }


    /**
     * Return hash code based on properties.
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), parents, peers, children, metrics, externalReferences, others, mermaidGraph);
    }
}
