/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworkservices.gaf.rest;

import com.fasterxml.jackson.annotation.*;
import org.odpi.openmetadata.commonservices.ffdc.rest.FFDCResponseBase;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * OMAGGAFAPIResponse provides a common header for Metadata Store Service managed rest to its REST API.
 * It manages information about exceptions.  If no exception has been raised exceptionClassName is null.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class GAFAPIResponse extends FFDCResponseBase
{
    /**
     * Default constructor
     */
    public GAFAPIResponse()
    {
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public GAFAPIResponse(GAFAPIResponse template)
    {
        super(template);
    }


    /**
     * JSON-like toString
     *
     * @return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "GAFAPIResponse{} " + super.toString();
    }
}
