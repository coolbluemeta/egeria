/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.properties.collections;

import com.fasterxml.jackson.annotation.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.ReferenceableProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.datadictionaries.DataDictionaryProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.datadictionaries.DataSpecProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.digitalbusiness.AgreementProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.digitalbusiness.DigitalProductProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.glossaries.GlossaryCategoryProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.governance.NamingStandardRuleProperties;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * CollectionProperties describes the core properties of a collection.  The collection is a managed list of elements.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = AgreementProperties.class, name = "AgreementProperties"),
                @JsonSubTypes.Type(value = DataDictionaryProperties.class, name = "DataDictionaryProperties"),
                @JsonSubTypes.Type(value = DataSpecProperties.class, name = "DataSpecProperties"),
                @JsonSubTypes.Type(value = DigitalProductProperties.class, name = "DigitalProductProperties"),
                @JsonSubTypes.Type(value = GlossaryCategoryProperties.class, name = "GlossaryCategoryProperties"),
                @JsonSubTypes.Type(value = NamingStandardRuleSetProperties.class, name = "NamingStandardRuleSetProperties"),
        })
public class CollectionProperties extends ReferenceableProperties
{
    /**
     * Default constructor
     */
    public CollectionProperties()
    {
        super();
        super.setTypeName(OpenMetadataType.COLLECTION.typeName);
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public CollectionProperties(ReferenceableProperties template)
    {
        super(template);

        if (template != null)
        {
        }
    }


    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "CollectionProperties{" +
                "} " + super.toString();
    }
}
