/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.refdata;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * SeverityLevel defines the severity of the impact that a situation has.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public enum SeverityLevel implements OpenMetadataRefData
{
    /**
     * There is no assessment of the impact's severity on this data.
     */
    UNCLASSIFIED (0, "8f4bcf4f-92f6-4a06-9993-dfb215aa1710", "Unclassified",
                               "There is no assessment of the impact's severity on this data.", true),

    /**
     * The impact is low.
     */
    LOW     (1, "f9a7dcad-fa5c-4ca5-a2d9-50cffc5fbfa4", "Low",
                               "The impact is low.", false),

    /**
     * The impact is medium.
     */
    MEDIUM    (2, "0de22909-05ea-495a-bc0b-9a2d4bd5644e", "Medium",
                               "The impact is medium.", false),

    /**
     * The impact is high.
     */
    HIGH     (3, "82ea6edd-634a-44ea-9f62-add3bf948e2c", "High",
                               "The impact is high.", false),

    /**
     * Another impact severity level.
     */
    OTHER        (99, "5de21541-da3a-4f66-b387-badb15dc9551","Other",
                               "Another impact severity level.", false);


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
    SeverityLevel(int     ordinal,
                  String  descriptionGUID,
                  String  name,
                  String  description,
                  boolean isDefault)
    {
        this.ordinal = ordinal;
        this.name            = name;
        this.descriptionGUID = descriptionGUID;
        this.description     = description;
        this.isDefault = isDefault;
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
        return "SeverityLevel{name='" + name + '}';
    }
}
