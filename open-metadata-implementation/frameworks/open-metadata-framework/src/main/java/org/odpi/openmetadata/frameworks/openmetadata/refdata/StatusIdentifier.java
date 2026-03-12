/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.refdata;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * StatusIdentifier identifies the status of one of the governed data classifications.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public enum StatusIdentifier implements OpenMetadataRefData
{
    /**
     * The classification assignment was discovered by an automated process.
     */
    DISCOVERED ("fa86c9f2-00d4-4acd-a232-1d58ee19703c", 0,"Discovered",
                               "The classification assignment was discovered by an automated process.", false),

    /**
     * The classification assignment was proposed by a subject-matter expert.
     */
    PROPOSED   ("ba53bff2-1c9c-4b49-8ab2-c2403354726b", 1,"Proposed",
                               "The classification assignment was proposed by a subject matter expert.", false),

    /**
     * The classification assignment was imported from another metadata system.
     */
    IMPORTED   ("e64e8337-b5cb-40e9-b1af-1aed1ee54ea1", 2,"Imported",
                               "The classification assignment was imported from another metadata system.", false),

    /**
     * The classification assignment has been validated and approved by a subject-matter-expert.
     */
    VALIDATED  ("f0e4b19e-8f08-4bfd-91aa-8070bce01b69", 3,"Validated",
                               "The classification assignment has been validated and approved by a subject matter expert.", false),

    /**
     * The classification assignment should no longer be used.
     */
    DEPRECATED ("42db10ad-3e9e-4e7c-875a-3b095f9f0434", 4,"Deprecated",
                               "The classification assignment should no longer be used.", false),

    /**
     * The classification assignment must no longer be used.
     */
    OBSOLETE   ("850930ea-63f5-4dbe-ba1d-e970c6e3e26c", 5,"Obsolete",
                               "The classification assignment must no longer be used.", false),

    /**
     * Another classification assignment status.
     */
    OTHER     ("d6bfaecb-de02-4f86-a318-a189e9a5aa5a", 99, "Other",
                               "Another classification assignment status.", false);


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
    StatusIdentifier(String  descriptionGUID,
                     int     ordinal,
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
        return "StatusIdentifier{name='" + name + '}';
    }
}
