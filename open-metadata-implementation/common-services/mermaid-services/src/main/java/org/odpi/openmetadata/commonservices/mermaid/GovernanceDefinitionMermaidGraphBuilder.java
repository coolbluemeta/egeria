/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.commonservices.mermaid;

import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.GovernanceDefinitionElement;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.GovernanceDefinitionGraph;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.RelatedElement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class GovernanceDefinitionMermaidGraphBuilder extends MermaidGraphBuilderBase
{
    /**
     * Constructor for the graph
     *
     * @param governanceDefinitionGraph contents
     */
    public GovernanceDefinitionMermaidGraphBuilder(GovernanceDefinitionGraph governanceDefinitionGraph)
    {
        mermaidGraph.append("---\n");
        mermaidGraph.append("title: Governance Definition - ");
        mermaidGraph.append(governanceDefinitionGraph.getProperties().getTitle());
        mermaidGraph.append(" [");
        mermaidGraph.append(governanceDefinitionGraph.getElementHeader().getGUID());
        mermaidGraph.append("]\n---\nflowchart LR\n%%{init: {\"flowchart\": {\"htmlLabels\": false}} }%%\n\n");

        List<String> usedNodeNames = new ArrayList<>();

        String currentNodeName = governanceDefinitionGraph.getElementHeader().getGUID();
        String currentDisplayName = governanceDefinitionGraph.getProperties().getTitle();

        appendNewMermaidNode(currentNodeName,
                             currentDisplayName,
                             governanceDefinitionGraph.getElementHeader().getType().getTypeName(),
                             VisualStyle.GOVERNANCE_DEFINITION);

        usedNodeNames.add(currentNodeName);

        this.addDescription(governanceDefinitionGraph);

        if (governanceDefinitionGraph.getParents() != null)
        {
            for (RelatedElement parent : governanceDefinitionGraph.getParents())
            {
                if ((parent != null) && (! usedNodeNames.contains(parent.getRelatedElement().getGUID())))
                {
                    currentNodeName    = parent.getRelatedElement().getGUID();
                    currentDisplayName = parent.getRelatedElement().getUniqueName();

                    appendNewMermaidNode(currentNodeName,
                                         currentDisplayName,
                                         parent.getRelatedElement().getType().getTypeName(),
                                         VisualStyle.SUPPORTING_GOVERNANCE_DEFINITION);

                    usedNodeNames.add(currentNodeName);

                    super.appendMermaidLine(parent.getRelationshipHeader().getGUID(),
                                            this.removeSpaces(parent.getRelatedElement().getGUID()),
                                            parent.getRelationshipHeader().getType().getTypeName(),
                                            this.removeSpaces(governanceDefinitionGraph.getElementHeader().getGUID()));
                }
            }
        }

        if (governanceDefinitionGraph.getPeers() != null)
        {
            for (RelatedElement peer : governanceDefinitionGraph.getPeers())
            {
                if ((peer != null) && (! usedNodeNames.contains(peer.getRelatedElement().getGUID())))
                {
                    currentNodeName    = peer.getRelatedElement().getGUID();
                    currentDisplayName = peer.getRelatedElement().getUniqueName();

                    appendNewMermaidNode(currentNodeName,
                                         currentDisplayName,
                                         peer.getRelatedElement().getType().getTypeName(),
                                         VisualStyle.SUPPORTING_GOVERNANCE_DEFINITION);

                    usedNodeNames.add(currentNodeName);

                    super.appendMermaidThinLine(peer.getRelationshipHeader().getGUID(),
                                                this.removeSpaces(peer.getRelatedElement().getGUID()),
                                                peer.getRelationshipHeader().getType().getTypeName(),
                                                this.removeSpaces(governanceDefinitionGraph.getElementHeader().getGUID()));
                }
            }
        }

        if (governanceDefinitionGraph.getChildren() != null)
        {
            for (RelatedElement child : governanceDefinitionGraph.getChildren())
            {
                if ((child != null) && (! usedNodeNames.contains(child.getRelatedElement().getGUID())))
                {
                    currentNodeName    = child.getRelatedElement().getGUID();
                    currentDisplayName = child.getRelatedElement().getUniqueName();

                    appendNewMermaidNode(currentNodeName,
                                         currentDisplayName,
                                         child.getRelatedElement().getType().getTypeName(),
                                         VisualStyle.SUPPORTING_GOVERNANCE_DEFINITION);

                    usedNodeNames.add(currentNodeName);

                    super.appendMermaidLine(child.getRelationshipHeader().getGUID(),
                                            this.removeSpaces(governanceDefinitionGraph.getElementHeader().getGUID()),
                                            child.getRelationshipHeader().getType().getTypeName(),
                                            this.removeSpaces(child.getRelatedElement().getGUID()));
                }
            }
        }

        if (governanceDefinitionGraph.getMetrics() != null)
        {
            for (RelatedElement metrics : governanceDefinitionGraph.getMetrics())
            {
                if ((metrics != null) && (! usedNodeNames.contains(metrics.getRelatedElement().getGUID())))
                {
                    currentNodeName    = metrics.getRelatedElement().getGUID();
                    currentDisplayName = metrics.getRelatedElement().getUniqueName();

                    appendNewMermaidNode(currentNodeName,
                                         currentDisplayName,
                                         metrics.getRelatedElement().getType().getTypeName(),
                                         VisualStyle.GOVERNANCE_METRIC);

                    usedNodeNames.add(currentNodeName);

                    super.appendMermaidLine(metrics.getRelationshipHeader().getGUID(),
                                            this.removeSpaces(governanceDefinitionGraph.getElementHeader().getGUID()),
                                            metrics.getRelationshipHeader().getType().getTypeName(),
                                            this.removeSpaces(metrics.getRelatedElement().getGUID()));
                }
            }
        }

        if (governanceDefinitionGraph.getExternalReferences() != null)
        {
            for (RelatedElement externalReference : governanceDefinitionGraph.getExternalReferences())
            {
                if ((externalReference != null) && (! usedNodeNames.contains(externalReference.getRelatedElement().getGUID())))
                {
                    currentNodeName    = externalReference.getRelatedElement().getGUID();
                    currentDisplayName = externalReference.getRelatedElement().getUniqueName();

                    appendNewMermaidNode(currentNodeName,
                                         currentDisplayName,
                                         externalReference.getRelatedElement().getType().getTypeName(),
                                         VisualStyle.EXTERNAL_REFERENCES);

                    usedNodeNames.add(currentNodeName);

                    super.appendMermaidLine(externalReference.getRelationshipHeader().getGUID(),
                                            this.removeSpaces(governanceDefinitionGraph.getElementHeader().getGUID()),
                                            externalReference.getRelationshipHeader().getType().getTypeName(),
                                            this.removeSpaces(externalReference.getRelatedElement().getGUID()));
                }
            }
        }

        if (governanceDefinitionGraph.getOthers() != null)
        {
            for (RelatedElement other : governanceDefinitionGraph.getOthers())
            {
                if ((other != null) && (! usedNodeNames.contains(other.getRelatedElement().getGUID())))
                {
                    currentNodeName    = other.getRelatedElement().getGUID();
                    currentDisplayName = other.getRelatedElement().getUniqueName();

                    appendNewMermaidNode(currentNodeName,
                                         currentDisplayName,
                                         other.getRelatedElement().getType().getTypeName(),
                                         VisualStyle.GOVERNED_ELEMENT);

                    usedNodeNames.add(currentNodeName);

                    super.appendMermaidLine(other.getRelationshipHeader().getGUID(),
                                            this.removeSpaces(governanceDefinitionGraph.getElementHeader().getGUID()),
                                            other.getRelationshipHeader().getType().getTypeName(),
                                            this.removeSpaces(other.getRelatedElement().getGUID()));
                }
            }
        }
    }


    /**
     * Add a text boxes with the description of the process (if any)
     *
     * @param governanceDefinitionElement element with the potential description
     */
    private void addDescription(GovernanceDefinitionElement governanceDefinitionElement)
    {
        if (governanceDefinitionElement.getProperties() != null)
        {
            String lastNodeName = null;

            if (governanceDefinitionElement.getProperties().getSummary() != null)
            {
                String descriptionNodeName = UUID.randomUUID().toString();

                appendNewMermaidNode(descriptionNodeName,
                                     governanceDefinitionElement.getProperties().getSummary(),
                                     "Summary",
                                     VisualStyle.DESCRIPTION);

                lastNodeName = descriptionNodeName;
            }

            if (governanceDefinitionElement.getProperties().getDescription() != null)
            {
                String descriptionNodeName = UUID.randomUUID().toString();

                appendNewMermaidNode(descriptionNodeName,
                                     governanceDefinitionElement.getProperties().getDescription(),
                                     "Description",
                                     VisualStyle.DESCRIPTION);

                if (lastNodeName != null)
                {
                    super.appendInvisibleMermaidLine(lastNodeName, descriptionNodeName);
                }

                lastNodeName = descriptionNodeName;
            }

            if (governanceDefinitionElement.getProperties().getScope() != null)
            {
                String descriptionNodeName = UUID.randomUUID().toString();

                appendNewMermaidNode(descriptionNodeName,
                                     governanceDefinitionElement.getProperties().getScope(),
                                     "Scope",
                                     VisualStyle.DESCRIPTION);

                if (lastNodeName != null)
                {
                    super.appendInvisibleMermaidLine(lastNodeName, descriptionNodeName);
                }

                lastNodeName = descriptionNodeName;
            }

            if (governanceDefinitionElement.getProperties().getImportance() != null)
            {
                String descriptionNodeName = UUID.randomUUID().toString();

                appendNewMermaidNode(descriptionNodeName,
                                     governanceDefinitionElement.getProperties().getImportance(),
                                     "Importance",
                                     VisualStyle.DESCRIPTION);

                if (lastNodeName != null)
                {
                    super.appendInvisibleMermaidLine(lastNodeName, descriptionNodeName);
                }

                lastNodeName = descriptionNodeName;
            }

            if (governanceDefinitionElement.getProperties().getImplications() != null)
            {
                for (String implication : governanceDefinitionElement.getProperties().getImplications())
                {
                    String descriptionNodeName = UUID.randomUUID().toString();

                    appendNewMermaidNode(descriptionNodeName,
                                         implication,
                                         "Implication",
                                         VisualStyle.DESCRIPTION);

                    if (lastNodeName != null)
                    {
                        super.appendInvisibleMermaidLine(lastNodeName, descriptionNodeName);
                    }

                    lastNodeName = descriptionNodeName;
                }
            }

            if (governanceDefinitionElement.getProperties().getOutcomes() != null)
            {
                for (String outcome : governanceDefinitionElement.getProperties().getOutcomes())
                {
                    String descriptionNodeName = UUID.randomUUID().toString();

                    appendNewMermaidNode(descriptionNodeName,
                                         outcome,
                                         "Implication",
                                         VisualStyle.DESCRIPTION);

                    if (lastNodeName != null)
                    {
                        super.appendInvisibleMermaidLine(lastNodeName, descriptionNodeName);
                    }

                    lastNodeName = descriptionNodeName;
                }
            }

            if (governanceDefinitionElement.getProperties().getResults() != null)
            {
                for (String result : governanceDefinitionElement.getProperties().getResults())
                {
                    String descriptionNodeName = UUID.randomUUID().toString();

                    appendNewMermaidNode(descriptionNodeName,
                                         result,
                                         "Result",
                                         VisualStyle.DESCRIPTION);

                    if (lastNodeName != null)
                    {
                        super.appendInvisibleMermaidLine(lastNodeName, descriptionNodeName);
                    }

                    lastNodeName = descriptionNodeName;
                }
            }
        }
    }
}
