/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.properties.surveyreports;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * ClassificationAnnotationProperties recommends classifications for either an asset or a data field.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)

public class ClassificationAnnotationProperties extends DataFieldAnnotationProperties
{
    private String classificationName = null;
    private Map<String, String> properties = null;

    /**
     * Default constructor
     */
    public ClassificationAnnotationProperties()
    {
        super();
        super.typeName = OpenMetadataType.CLASSIFICATION_ANNOTATION.typeName;
    }


    /**
     * Copy clone constructor
     *
     * @param template object to copy
     */
    public ClassificationAnnotationProperties(ClassificationAnnotationProperties template)
    {
        super(template);

        if (template != null)
        {
            classificationName = template.getClassificationName();
            properties = template.getProperties();
        }
    }


    /**
     * Return the name of the classification to be recommended.
     *
     * @return string
     */
    public String getClassificationName()
    {
        return classificationName;
    }


    /**
     * Set up the name of the classification to be recommended.
     *
     * @param classificationName string
     */
    public void setClassificationName(String classificationName)
    {
        this.classificationName = classificationName;
    }

    /**
     * Return a map of candidate classification names to additional characteristics
     *
     * @return map of classification names to string
     */
    public Map<String, String> getProperties()
    {
        return properties;
    }


    /**
     * Set up a map of candidate classification names to additional characteristics.
     *
     * @param properties map of classification names to string
     */
    public void setProperties(Map<String, String> properties)
    {
        this.properties = properties;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "ClassificationAnnotationProperties{" +
                "classificationName='" + classificationName + '\'' +
                ", properties=" + properties +
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
        ClassificationAnnotationProperties that = (ClassificationAnnotationProperties) objectToCompare;
        return Objects.equals(classificationName, that.classificationName) &&
                Objects.equals(properties, that.properties);
    }


    /**
     * Create a hash code for this element type.
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), classificationName, properties);
    }
}
