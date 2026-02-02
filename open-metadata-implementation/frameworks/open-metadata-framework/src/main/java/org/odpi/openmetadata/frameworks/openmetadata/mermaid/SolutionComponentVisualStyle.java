/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.mermaid;

import org.odpi.openmetadata.frameworks.openmetadata.refdata.SolutionComponentType;

/**
 * SolutionComponentVisualStyle maps solution component types to appropriate visual styles.
 */
public enum SolutionComponentVisualStyle
{
    /**
     * An automated action that is implemented by some form of software.
     */
    AUTOMATED_ACTION(SolutionComponentType.AUTOMATED_ACTION,
                     VisualStyle.AUTOMATED_ACTION_SOLUTION_COMPONENT),

    /**
     * An automated action that is implemented by some form of software.
     */
    LONG_RUNNING_DAEMON(SolutionComponentType.LONG_RUNNING_DAEMON,
                        VisualStyle.LONG_RUNNING_DAEMON_SOLUTION_COMPONENT),

    /**
     * An automated action that is implemented by some form of software.
     */
    MULTI_STEP_PROCESS(SolutionComponentType.MULTI_STEP_PROCESS,
                       VisualStyle.MULTI_STEP_PROCESS_SOLUTION_COMPONENT),

    /**
     * Provides a callable function that can be issued from a console/command line.
     */
    CONSOLE_COMMAND(SolutionComponentType.CONSOLE_COMMAND,
                    VisualStyle.COMMAND_SOLUTION_COMPONENT),


    /**
     * A process that is implemented by a third party and is opaque to the solution.
     */
    THIRD_PARTY_PROCESS(SolutionComponentType.THIRD_PARTY_PROCESS,
                        VisualStyle.THIRD_PARTY_PROCESS_SOLUTION_COMPONENT),


    /**
     * A set of tasks that need to be preformed by individuals or teams of people.
     */
    MANUAL_PROCESS(SolutionComponentType.MANUAL_PROCESS,
                   VisualStyle.MANUAL_PROCESS_SOLUTION_COMPONENT),


    /**
     * The storage of data for later retrieval by automated processes.
     */
    DATA_STORAGE(SolutionComponentType.DATA_STORAGE,
                 VisualStyle.DATA_STORAGE_SOLUTION_COMPONENT),


    /**
     * A distribution of data to a variety of automated processes.
     */
    DATA_DISTRIBUTION(SolutionComponentType.DATA_DISTRIBUTION,
                      VisualStyle.DATA_DISTRIBUTION_SOLUTION_COMPONENT),


    /**
     * The publishing of information (typically documents) to third parties.
     */
    DOCUMENT_PUBLISHING(SolutionComponentType.DOCUMENT_PUBLISHING,
                       VisualStyle.DOCUMENT_PUBLISHING_SOLUTION_COMPONENT),


    /**
     * A trained model using analytical or AI techniques to generate insight from data.
     */
    INSIGHT_MODEL(SolutionComponentType.INSIGHT_MODEL,
                  VisualStyle.INSIGHT_MODEL_SOLUTION_COMPONENT),


    ;

    /**
     * Property value.
     */
    private final SolutionComponentType solutionComponentType;


    /**
     * Suggested shape to use in mermaid diagram.
     */
    private final VisualStyle visualStyle;


    /**
     * Constructor for individual enum value.
     *
     * @param solutionComponentType the property value to use in solutionComponentType
     * @param visualStyle suggested shape to use in mermaid diagram
     */
    SolutionComponentVisualStyle(SolutionComponentType solutionComponentType,
                                 VisualStyle           visualStyle)
    {
        this.solutionComponentType = solutionComponentType;
        this.visualStyle           = visualStyle;
    }


    /**
     * Return the value of this property.
     *
     * @return string
     */
    public SolutionComponentType getSolutionComponentType()
    {
        return solutionComponentType;
    }



    /**
     * Return the shape to use in mermaid graphs.
     *
     * @return null or string
     */
    public VisualStyle getVisualStyle()
    {
        return visualStyle;
    }


    /**
     * Output of this enum class and main value.
     *
     * @return string showing enum value
     */
    @Override
    public String toString()
    {
        return "SolutionComponentVisualStyle{" + solutionComponentType.getSolutionComponentType() + '}';
    }
}
