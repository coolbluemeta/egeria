/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.properties.security;

import com.fasterxml.jackson.annotation.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.collections.CollectionProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.governance.*;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * SecurityListProperties defines a group of security groups or security roles.
 */
@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = SecurityGroupProperties.class, name = "SecurityGroupProperties"),
                @JsonSubTypes.Type(value = SecurityRoleProperties.class, name = "SecurityRoleProperties"),
        })
public class SecurityListProperties extends CollectionProperties
{
    private String distinguishedName = null;


    /**
     * Default Constructor
     */
    public SecurityListProperties()
    {
        super();
        super.typeName = OpenMetadataType.SECURITY_LIST.typeName;
    }


    /**
     * Copy/Clone Constructor
     *
     * @param template object to copy
     */
    public SecurityListProperties(SecurityListProperties template)
    {
        super(template);

        if (template != null)
        {
            this.distinguishedName = template.getDistinguishedName();
        }
    }


    /**
     * Return the specific distinguishedName of the security group.
     *
     * @return string description
     */
    public String getDistinguishedName()
    {
        return distinguishedName;
    }


    /**
     * Set up the specific distinguishedName of the security group.
     *
     * @param distinguishedName string description
     */
    public void setDistinguishedName(String distinguishedName)
    {
        this.distinguishedName = distinguishedName;
    }


    /**
     * JSON-style toString
     *
     * @return string containing the properties and their values
     */
    @Override
    public String toString()
    {
        return "SecurityListProperties{" +
                "distinguishedName='" + distinguishedName + '\'' +
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
        SecurityListProperties that = (SecurityListProperties) objectToCompare;
        return Objects.equals(distinguishedName, that.distinguishedName);
    }


    /**
     * Return hash code based on properties.
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), distinguishedName);
    }
}
