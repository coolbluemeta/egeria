/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.properties.surveyreports;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * DataClassAnnotationProperties recommends a data class that potentially matches this data field.
 */
@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataClassAnnotationProperties extends DataFieldAnnotationProperties
{
    private String       specification = null;
    private List<String> candidateDataClassGUIDs = null;

    /**
     * Default constructor
     */
    public DataClassAnnotationProperties()
    {
        super();
        super.typeName = OpenMetadataType.DATA_CLASS_ANNOTATION.typeName;
    }


    /**
     * Copy clone constructor
     *
     * @param template object to copy
     */
    public DataClassAnnotationProperties(DataClassAnnotationProperties template)
    {
        super(template);

        if (template != null)
        {
            specification = template.getSpecification();
            candidateDataClassGUIDs = template.getCandidateDataClassGUIDs();

        }
    }


    /**
     * Return the specification for this data class annotation.
     *
     * @return string
     */
    public String getSpecification()
    {
        return specification;
    }


    /**
     * Set up the specification for this data class annotation.
     *
     * @param specification string
     */
    public void setSpecification(String specification)
    {
        this.specification = specification;
    }


    /**
     * Return the identifiers of data classes that seem to match the values in this data field.
     *
     * @return list of unique identifiers for data classes
     */
    public List<String> getCandidateDataClassGUIDs()
    {
        return candidateDataClassGUIDs;
    }


    /**
     * Set up the identifiers of data classes that seem to match the values in this data field.
     *
     * @param candidateDataClassGUIDs list of guids
     */
    public void setCandidateDataClassGUIDs(List<String> candidateDataClassGUIDs)
    {
        this.candidateDataClassGUIDs = candidateDataClassGUIDs;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "DataClassAnnotationProperties{" +
                "specification='" + specification + '\'' +
                ", candidateDataClassGUIDs=" + candidateDataClassGUIDs +
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
        if (objectToCompare == null || getClass() != objectToCompare.getClass())
        {
            return false;
        }
        if (!super.equals(objectToCompare))
        {
            return false;
        }
        DataClassAnnotationProperties that = (DataClassAnnotationProperties) objectToCompare;
        return Objects.equals(specification, that.specification) &&
                Objects.equals(candidateDataClassGUIDs, that.candidateDataClassGUIDs);
    }


    /**
     * Create a hash code for this element type.
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), candidateDataClassGUIDs, specification);
    }
}
