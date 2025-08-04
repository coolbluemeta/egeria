/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworkservices.omf.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.search.ElementProperties;
import org.odpi.openmetadata.frameworks.openmetadata.search.NewElementProperties;
import org.odpi.openmetadata.frameworks.openmetadata.search.TemplateOptions;

import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * TemplateRequestBody provides a structure for passing the properties for a new metadata element
 * that is to be created via a template.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class OpenMetadataTemplateRequestBody extends TemplateOptions
{
    private String                 templateGUID                 = null;
    private ElementProperties      replacementProperties        = null;
    private Map<String, String>    placeholderPropertyValues    = null;
    private NewElementProperties   parentRelationshipProperties = null;


    /**
     * Default constructor
     */
    public OpenMetadataTemplateRequestBody()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public OpenMetadataTemplateRequestBody(OpenMetadataTemplateRequestBody template)
    {
        super(template);

        if (template != null)
        {
            replacementProperties        = template.getReplacementProperties();
            templateGUID                 = template.getTemplateGUID();
            placeholderPropertyValues    = template.getPlaceholderPropertyValues();
            parentRelationshipProperties = template.getParentRelationshipProperties();
        }
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public OpenMetadataTemplateRequestBody(TemplateOptions template)
    {
        super(template);
    }


    /**
     * Return the properties for the new metadata element.
     *
     * @return list of properties
     */
    public ElementProperties getReplacementProperties()
    {
        return replacementProperties;
    }


    /**
     * Set up the properties for the new metadata element.
     *
     * @param replacementProperties list of properties
     */
    public void setReplacementProperties(ElementProperties replacementProperties)
    {
        this.replacementProperties = replacementProperties;
    }


    /**
     * Set up the unique identifier of the element to use as a template (optional).
     *
     * @param templateGUID String guid
     */
    public void setTemplateGUID(String templateGUID)
    {
        this.templateGUID = templateGUID;
    }


    /**
     * Returns the unique identifier of the element to use as a template (optional).
     *
     * @return string guid
     */
    public String getTemplateGUID()
    {
        return templateGUID;
    }


    /**
     * Return the property values to replace placeholders in the template.
     *
     * @return map of property name to property value
     */
    public Map<String, String> getPlaceholderPropertyValues()
    {
        return placeholderPropertyValues;
    }


    /**
     * Set up the property values to replace placeholders in the template.
     *
     * @param placeholderPropertyValues map of property name to property value
     */
    public void setPlaceholderPropertyValues(Map<String, String> placeholderPropertyValues)
    {
        this.placeholderPropertyValues = placeholderPropertyValues;
    }


    /**
     * Return any properties that should be included in the parent relationship.
     *
     * @return element properties
     */
    public NewElementProperties getParentRelationshipProperties()
    {
        return parentRelationshipProperties;
    }


    /**
     * Set up any properties that should be included in the parent relationship.
     *
     * @param parentRelationshipProperties element properties
     */
    public void setParentRelationshipProperties(NewElementProperties parentRelationshipProperties)
    {
        this.parentRelationshipProperties = parentRelationshipProperties;
    }


    /**
     * JSON-style toString.
     *
     * @return list of properties and their values.
     */
    @Override
    public String toString()
    {
        return "OpenMetadataTemplateRequestBody{" +
                "templateGUID='" + templateGUID + '\'' +
                ", replacementProperties=" + replacementProperties +
                ", placeholderPropertyValues=" + placeholderPropertyValues +
                ", parentRelationshipProperties=" + parentRelationshipProperties +
                "} " + super.toString();
    }


    /**
     * Equals method that returns true if containing properties are the same.
     *
     * @param objectToCompare object to compare
     * @return boolean result of comparison
     */
    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare)
        {
            return true;
        }
        if (! (objectToCompare instanceof OpenMetadataTemplateRequestBody that))
        {
            return false;
        }
        if (! super.equals(objectToCompare))
        {
            return false;
        }
        return Objects.equals(replacementProperties, that.replacementProperties) &&
                       Objects.equals(placeholderPropertyValues, that.placeholderPropertyValues) &&
                       Objects.equals(templateGUID, that.templateGUID)&&
                Objects.equals(parentRelationshipProperties, that.parentRelationshipProperties);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), replacementProperties, templateGUID,
                            placeholderPropertyValues, parentRelationshipProperties);
    }
}
