/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.auditlog.requestid;


import java.util.UUID;

/**
 * Provides access to the request id for the current thread.  It also manages its
 * creation and update.
 */
public class RequestId
{
    private static final ThreadLocal<String> requestId = ThreadLocal.withInitial(() -> UUID.randomUUID().toString());

    /**
     * Default constructor initializes the request id with a random UUID.
     */
    public RequestId()
    {
    }


    /**
     * Set up the request id for the current thread.  This may be null
     * to create a new request id value.
     *
     * @param requestIdValue requestId from the caller
     */
    public synchronized void setRequestId(String requestIdValue)
    {
        if (requestIdValue != null)
        {
            requestId.set(requestIdValue);
        }
        else
        {
            clearRequestId();
        }
    }


    /**
     * Set up the request id for the current thread.  This may be null
     * to create a new request id value.
     *
     */
    public synchronized void clearRequestId()
    {
        requestId.set(UUID.randomUUID().toString());
    }


    /**
     * Return the requestId for this thread.
     *
     * @return string UUID
     */
    public synchronized String getRequestId()
    {
        return requestId.get();
    }


    /**
     * JSON-style toString.
     *
     * @return list of properties and their values.
     */
    @Override
    public String toString()
    {
        return "RequestId{" +
                "requestId='" + requestId.get() + '\'' +
                '}';
    }
}
