/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.properties.security;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * GovernanceZoneProperties describes a governance zone.  This describes the access permissions for a collection
 * of open metadata elements that are members of the governance zone.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServiceAccessControlProperties extends SecurityAccessControlProperties
{
    private Map<String, String> mappingProperties = null;


    /**
     * Default constructor
     */
    public ServiceAccessControlProperties()
    {
        super();
        super.typeName = OpenMetadataType.SERVICE_ACCESS_CONTROL.typeName;
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public ServiceAccessControlProperties(ServiceAccessControlProperties template)
    {
        super(template);

        if (template != null)
        {
            this.mappingProperties = template.getMappingProperties();
        }
    }


    /**
     * Return the appropriate mapping properties used by the security service needed to map the control to the callable resource.
     *
     * @return text
     */
    public Map<String, String> getMappingProperties()
    {
        return mappingProperties;
    }


    /**
     * Set up the appropriate mapping properties used by the security service needed to map the control to the callable resource.
     *
     * @param mappingProperties text
     */
    public void setMappingProperties(Map<String, String> mappingProperties)
    {
        this.mappingProperties = mappingProperties;
    }


    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "ServiceAccessControlProperties{" +
                "mappingProperties=" + mappingProperties +
                "} " + super.toString();
    }


    /**
     * Return comparison result based on the content of the properties.
     *
     * @param objectToCompare test object
     * @return result of comparison
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
        ServiceAccessControlProperties that = (ServiceAccessControlProperties) objectToCompare;
        return Objects.equals(mappingProperties, that.mappingProperties);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), mappingProperties);
    }
}
