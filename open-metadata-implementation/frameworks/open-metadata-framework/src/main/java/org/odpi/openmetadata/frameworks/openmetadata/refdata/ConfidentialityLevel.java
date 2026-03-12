/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.openmetadata.refdata;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * Defines how confidential a data item is.
 */

@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public enum ConfidentialityLevel implements OpenMetadataRefData
{
    /**
      * The data is public information.
      */
    UNCLASSIFIED("472d15fa-5713-40dd-892b-9bf91313957e", 0, "Unclassified", "The data is public information.", false),

    /**
      * The data should not be exposed outside of this organization.
      */
    INTERNAL("e7813b82-8447-43ce-8a67-c941c265257f", 1, "Internal", "The data should not be exposed outside of this organization.", false),

    /**
      * The data should be protected and only shared with people with a need to see it.
      */
    CONFIDENTIAL("b326cfae-1579-4669-b614-e33e5a7e3b18", 2, "Confidential", "The data should be protected and only shared with people with a need to see it.", false),

    /**
      * The data is sensitive and inappropriate use may adversely impact the data subject.
      */
    SENSITIVE("18011377-8dd0-4211-abdf-039da2415f1c", 3, "Sensitive", "The data is sensitive and inappropriate use may adversely impact the data subject.", false),

    /**
      * The data is very valuable and must be restricted to a very small number of people.
      */
    RESTRICTED("b0d939c5-6c06-4bb3-ade3-cc5957182ff4", 4, "Restricted", "The data is very valuable and must be restricted to a very small number of people.", false),

    /**
      * Another confidentially level.
      */
    OTHER("3f052d7e-de9d-4b94-a7d4-01ae0242fab6", 99, "Other", "Another confidentially level.", false),

;

    private final String descriptionGUID;

    private final int            ordinal;
    private final String         name;
    private final String         description;
    private final boolean        isDefault;


    /**
     * Default constructor for the enumeration.
     *
     * @param ordinal numerical representation of the enumeration
     * @param descriptionGUID identifier for valid value
     * @param name default string name of the enumeration
     * @param description default string description of the enumeration
     * @param isDefault is this the default value for the enum?
     */
    ConfidentialityLevel(String  descriptionGUID,
                         int     ordinal,
                         String  name,
                         String  description,
                         boolean isDefault)
    {
        this.ordinal         = ordinal;
        this.name            = name;
        this.descriptionGUID = descriptionGUID;
        this.description     = description;
        this.isDefault       = isDefault;
    }



    /**
     * Return the numeric representation of the enumeration.
     *
     * @return int ordinal
     */
    @Override
    public int getOrdinal() { return ordinal; }


    /**
     * Return the default name of the enumeration.
     *
     * @return String name
     */
    @Override
    public String getDisplayName() { return name; }


    /**
     * Return the default description of the enumeration.
     *
     * @return String description
     */
    @Override
    public String getDescription() { return description; }


    /**
     * Return the unique identifier for the valid value that represents the enum value.
     *
     * @return  guid
     */
    @Override
    public  String getDescriptionGUID()
    {
        return descriptionGUID;
    }


    /**
     * Return whether the enum is the default value or not.
     *
     * @return boolean
     */
    @Override
    public boolean isDefault()
    {
        return isDefault;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "ConfidentialityLevel{" + name + "}";
    }
}
