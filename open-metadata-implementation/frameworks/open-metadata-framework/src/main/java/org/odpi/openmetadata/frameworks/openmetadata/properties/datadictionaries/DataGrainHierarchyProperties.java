/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.openmetadata.properties.datadictionaries;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.properties.LabeledRelationshipProperties;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * DataGrainHierarchyProperties describes the inheritance link between two data grains.
 */
@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataGrainHierarchyProperties extends LabeledRelationshipProperties
{
    /**
     * Default constructor
     */
    public DataGrainHierarchyProperties()
    {
        super();
        super.typeName = OpenMetadataType.DATA_GRAIN_HIERARCHY_RELATIONSHIP.typeName;
    }


    /**
     * Copy/clone constructor.
     *
     * @param template template object to copy.
     */
    public DataGrainHierarchyProperties(DataGrainHierarchyProperties template)
    {
        super(template);
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "DataGrainHierarchyProperties{} " + super.toString();
    }
}
