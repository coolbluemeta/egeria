/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.accessservices.assetmanager.properties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * TemplateProperties defined the properties that can be overridden from the template object
 * when creating an object from a template.
 */
@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateProperties
{
    private String qualifiedName     = null;
    private  String       displayName       = null;
    private List<String> aliases           = null;
    private   String       versionIdentifier = null;
    private String description       = null;
    private String pathName          = null;
    private String networkAddress    = null;


    /**
     * Default constructor
     */
    public TemplateProperties()
    {
        super();
    }


    /**
     * Copy/clone constructor for the template properties.
     *
     * @param template template object to copy.
     */
    public TemplateProperties(TemplateProperties template)
    {
        if (template != null)
        {
            qualifiedName     = template.getQualifiedName();
            displayName       = template.getDisplayName();
            aliases           = template.getAliases();
            versionIdentifier = template.getVersionIdentifier();
            description       = template.getDescription();
            pathName          = template.getPathName();
            networkAddress    = template.getNetworkAddress();
        }
    }


    /**
     * Returns the stored qualified name property for the metadata entity.
     * If no qualified name is available then the empty string is returned.
     *
     * @return qualifiedName
     */
    public String getQualifiedName()
    {
        return qualifiedName;
    }


    /**
     * Set up the fully qualified name.
     *
     * @param qualifiedName String name
     */
    public void setQualifiedName(String qualifiedName)
    {
        this.qualifiedName = qualifiedName;
    }


    /**
     * Returns the stored display name property for the metadata entity.
     * If no display name is available then null is returned.
     *
     * @return String name
     */
    public String getDisplayName()
    {
        return displayName;
    }


    /**
     * Set up the stored display name property for the metadata entity.
     *
     * @param displayName String name
     */
    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }



    /**
     * Return the list of alternative names for the term.
     *
     * @return list
     */
    public List<String> getAliases()
    {
        return aliases;
    }


    /**
     * Set up the list of alternative names for the term.
     *
     * @param aliases list
     */
    public void setAliases(List<String> aliases)
    {
        this.aliases = aliases;
    }



    /**
     * Set up the version identifier of the resource.
     *
     * @return string version name
     */
    public String getVersionIdentifier()
    {
        return versionIdentifier;
    }


    /**
     * Set up the version identifier of the resource.
     *
     * @param versionIdentifier string version name
     */
    public void setVersionIdentifier(String versionIdentifier)
    {
        this.versionIdentifier = versionIdentifier;
    }


    /**
     * Returns the stored description property for the metadata entity.
     * If no description is provided then null is returned.
     *
     * @return description String text
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Set up the stored description property associated with the metadata entity.
     *
     * @param description String text
     */
    public void setDescription(String description)
    {
        this.description = description;
    }


    /**
     * Return the path name to the physical resource - used when creating new data store assets such as databases, files and folders.
     *
     * @return string name
     */
    public String getPathName()
    {
        return pathName;
    }


    /**
     * Set up the path name to the physical resource - used when creating new data store assets such as databases, files and folders.
     *
     * @param pathName string name
     */
    public void setPathName(String pathName)
    {
        this.pathName = pathName;
    }


    /**
     * Return the physical network address of this metadata element (if this makes sense).
     *
     * @return string name
     */
    public String getNetworkAddress()
    {
        return pathName;
    }


    /**
     * Set up the physical network address of this metadata element (if this makes sense).
     *
     * @param networkAddress string name
     */
    public void setNetworkAddress(String networkAddress)
    {
        this.pathName = networkAddress;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "TemplateProperties{" +
                "qualifiedName='" + qualifiedName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", aliases=" + aliases +
                ", versionIdentifier='" + versionIdentifier + '\'' +
                ", description='" + description + '\'' +
                ", pathName='" + pathName + '\'' +
                ", networkAddress='" + networkAddress + '\'' +
                '}';
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
        if (this == objectToCompare) return true;
        if (objectToCompare == null || getClass() != objectToCompare.getClass()) return false;
        TemplateProperties that = (TemplateProperties) objectToCompare;
        return Objects.equals(qualifiedName, that.qualifiedName) && Objects.equals(displayName, that.displayName) && Objects.equals(aliases, that.aliases) && Objects.equals(versionIdentifier, that.versionIdentifier) && Objects.equals(description, that.description) && Objects.equals(pathName, that.pathName) && Objects.equals(networkAddress, that.networkAddress);
    }

    /**
     * Return hash code based on properties.
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(qualifiedName, displayName, aliases, versionIdentifier, description, pathName, networkAddress);
    }
}
