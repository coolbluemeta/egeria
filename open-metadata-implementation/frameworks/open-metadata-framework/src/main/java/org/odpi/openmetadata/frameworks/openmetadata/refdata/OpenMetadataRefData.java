/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.refdata;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * OpenMetadataRefData defines the common methods for an open metadata reference data enum.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public interface OpenMetadataRefData
{
    /**
     * Return the numeric representation of the enumeration.
     *
     * @return int ordinal
     */
    int getOrdinal();

    /**
     * Return the default name of the enumeration.
     *
     * @return String name
     */
    String name();


    /**
     * Return the display name of the enumeration.
     *
     * @return String name
     */
    String getDisplayName();


    /**
     * Return the default description of the enumeration.
     *
     * @return String description
     */
    String getDescription();


    /**
     * Return the unique identifier for the valid value that represents the enum value.
     *
     * @return  guid
     */
    String getDescriptionGUID();


    /**
     * Return whether the enum is the default value or not.
     *
     * @return boolean
     */
    boolean isDefault();
}
