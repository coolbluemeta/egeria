/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.connectors.properties.users;


/**
 * UserAccountType indicates whether the user account is for a person or an automated process (non-personal account - NPA).
 */
public enum UserAccountType
{
    /**
     * The account is for an individual who is an employee of the organization
     */
    EMPLOYEE(0, "Employee", "The account is for an individual who is an employee of the organization."),

    /**
     * The account is for an individual who is a contractor to the organization
     */
    CONTRACTOR(1, "Contractor", "The account is for an individual who is a contractor to the organization."),


    /**
     * The account is for an individual who is not a part of the organization
     */
    EXTERNAL(2, "External", "The account is for an individual who is not a part of the organization."),

    /**
     * The account is for a system, service, software component - some form of automation.
     */
    DIGITAL(3, "Digital", "The account is for a system, service, software component - some form of automation."),
    ;

    private final int    ordinal;
    private final String name;
    private final String description;


    /**
     * Default constructor sets up the specific values for an enum instance.
     *
     * @param ordinal     int enum value ordinal
     * @param name        String name
     * @param description String description
     */
    UserAccountType(int ordinal,
                    String name,
                    String description)
    {
        this.ordinal     = ordinal;
        this.name        = name;
        this.description = description;
    }


    /**
     * Return the numerical value for the enum.
     *
     * @return int enum value ordinal
     */
    public int getOrdinal()
    {
        return ordinal;
    }


    /**
     * Return the descriptive name for the enum.
     *
     * @return String name
     */
    public String getName()
    {
        return name;
    }


    /**
     * Return the description for the enum.
     *
     * @return String description
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * toString() JSON-style
     *
     * @return string description
     */
    @Override
    public String toString()
    {
        return "UserAccountType{" +
                "ordinal=" + ordinal +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
