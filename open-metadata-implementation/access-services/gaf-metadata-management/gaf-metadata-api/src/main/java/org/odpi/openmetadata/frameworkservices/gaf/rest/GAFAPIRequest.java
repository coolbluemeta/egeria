/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworkservices.gaf.rest;

import org.odpi.openmetadata.frameworks.auditlog.requestid.RequestIdService;
import org.odpi.openmetadata.repositoryservices.rest.properties.OMRSAPIRequest;

import java.util.Objects;

public class GAFAPIRequest implements RequestIdService
{
    private String requestId = null;


    /**
     * Default constructor
     */
    public GAFAPIRequest()
    {
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public GAFAPIRequest(GAFAPIRequest template)
    {
        if (template != null)
        {
            this.requestId = template.getRequestId();
        }
    }

    /**
     * Return the unique identifier for the request.
     *
     * @return string guid
     */
    @Override
    public String getRequestId()
    {
        return requestId;
    }


    /**
     * Set up the unique identifier for the request.
     *
     * @param requestId string guid
     */
    @Override
    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "GAFAPIRequest{" +
                "requestId='" + requestId + '\'' +
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
        if (objectToCompare == null || getClass() != objectToCompare.getClass()) return false;
        GAFAPIRequest that = (GAFAPIRequest) objectToCompare;
        return Objects.equals(requestId, that.requestId);
    }


    /**
     * Create a hash code for this element type.
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(requestId);
    }
}
