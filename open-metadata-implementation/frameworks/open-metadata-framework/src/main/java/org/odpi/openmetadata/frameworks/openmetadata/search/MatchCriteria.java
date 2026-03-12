/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.search;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.OpenMetadataRefData;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * The MatchCriteria enum defines how the metadata instances in the metadata store should be matched
 * against the properties supplied on the search request.
 * <ul>
 *     <li>ALL means all properties must match.</li>
 *     <li>ANY means a match on any of properties is good enough.</li>
 *     <li>NONE means return instances where none of the supplied properties match.</li>
 * </ul>
 */
@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MatchCriteria implements OpenMetadataRefData
{
    /**
     * All properties must match.
     */
    ALL(0, "All", "All properties must match.", "f6ecd071-e5d2-4bda-ae0f-50543cc9b1d2", false),

    /**
     * A match on any of the properties in the instance is good enough.
     */
    ANY(1, "Any", "A match on any of the properties in the instance is good enough.", "cc41f204-3664-4276-b9f0-7080179b7ba7", true),

    /**
     * Return instances where none of the supplied properties match.
     */
    NONE(2, "None", "Return instances where none of the supplied properties match.", "e00c33aa-977f-4e8f-bbcd-fe43b5912a81" , false);

    private final int     ordinal;
    private final String  name;
    private final String  description;
    private final String  descriptionGUID;
    private final boolean isDefault;

    /**
     * Constructor to set up a single instances of the enum.
     *
     * @param ordinal         numerical representation of the match criteria
     * @param name            default string name of the match criteria
     * @param description     default string description of the match criteria
     * @param descriptionGUID unique identifier for the valid value that represents the enum value
     * @param isDefault       is this the default value for the enum?
     */
    MatchCriteria(int     ordinal,
                  String  name,
                  String  description,
                  String  descriptionGUID,
                  boolean isDefault)
    {
        this.ordinal         = ordinal;
        this.name            = name;
        this.description     = description;
        this.descriptionGUID = descriptionGUID;
        this.isDefault       = isDefault;
    }

    /**
     * Return the numeric representation of the match criteria.
     *
     * @return int ordinal
     */
    @Override
    public int getOrdinal()
    {
        return ordinal;
    }


    /**
     * Return the default name of the match criteria.
     *
     * @return String name
     */
    @Override
    public String getDisplayName()
    {
        return name;
    }


    /**
     * Return the default description of the match criteria.
     *
     * @return String description
     */
    @Override
    public String getDescription()
    {
        return description;
    }

    /**
     * Return the unique identifier for the valid value that represents the enum value.
     *
     * @return guid
     */
    @Override
    public String getDescriptionGUID()
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
     * toString() JSON-style
     *
     * @return string description
     */
    @Override
    public String toString()
    {
        return "MatchCriteria{" + name + "}";
    }
}
