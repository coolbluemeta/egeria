/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.commonservices.mermaid;

import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.SolutionBlueprintComponent;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.SolutionBlueprintElement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Creates a mermaid graph rendering of the Open Metadata Framework's solution blueprint graph.
 */
public class SolutionBlueprintMermaidGraphBuilder extends MermaidGraphBuilderBase
{
    /**
     * Construct a mermaid markdown graph.
     *
     * @param solutionBlueprintElement content
     */
    public SolutionBlueprintMermaidGraphBuilder(SolutionBlueprintElement solutionBlueprintElement)
    {
        mermaidGraph.append("---\n");
        mermaidGraph.append("title: Components and Roles for Solution Blueprint - ");
        mermaidGraph.append(solutionBlueprintElement.getProperties().getDisplayName());
        mermaidGraph.append(" [");
        mermaidGraph.append(solutionBlueprintElement.getElementHeader().getGUID());
        mermaidGraph.append("]\n---\nflowchart TD\n%%{init: {\"flowchart\": {\"htmlLabels\": false}} }%%\n\n");

        String currentNodeName    = solutionBlueprintElement.getElementHeader().getGUID();
        String currentDisplayName = solutionBlueprintElement.getProperties().getDisplayName();

        if (solutionBlueprintElement.getSolutionComponents() != null)
        {
            super.startSubgraph("Components and Actors", VisualStyle.SOLUTION_BLUEPRINT_GRAPH);

            addDescription(solutionBlueprintElement, false);

            List<String> solutionLinkingWireGUIDs = new ArrayList<>();

            for (SolutionBlueprintComponent node : solutionBlueprintElement.getSolutionComponents())
            {
                if (node != null)
                {
                    super.addSolutionComponentToGraph(null,
                                                      null,
                                                      node.getSolutionComponent(),
                                                      solutionLinkingWireGUIDs,
                                                      false);
                }
            }

            super.endSubgraph();
        }
        else
        {
            appendNewMermaidNode(currentNodeName,
                                 currentDisplayName,
                                 solutionBlueprintElement.getElementHeader().getType().getTypeName(),
                                 checkForClassifications(solutionBlueprintElement.getElementHeader(),
                                                         VisualStyle.SOLUTION_BLUEPRINT));

            addDescription(solutionBlueprintElement, true);
        }
    }



    /**
     * Add a text box with the description (if any)
     *
     * @param solutionBlueprintElement element with the potential description
     * @param linkToBlueprint should it be linked to the parent node?
     */
    private void addDescription(SolutionBlueprintElement solutionBlueprintElement,
                                boolean                  linkToBlueprint)
    {
        if (solutionBlueprintElement.getProperties() != null)
        {
            if (solutionBlueprintElement.getProperties().getDescription() != null)
            {
                String descriptionNodeName = UUID.randomUUID().toString();

                appendNewMermaidNode(descriptionNodeName,
                                     solutionBlueprintElement.getProperties().getDescription(),
                                     "Description",
                                     VisualStyle.DESCRIPTION);

                if (linkToBlueprint)
                {
                    super.appendMermaidLine(null,
                                            solutionBlueprintElement.getElementHeader().getGUID(),
                                            null,
                                            descriptionNodeName);
                }
            }
        }
    }
}
