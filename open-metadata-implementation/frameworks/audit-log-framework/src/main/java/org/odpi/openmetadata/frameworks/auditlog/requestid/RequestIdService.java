/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.auditlog.requestid;

/**
 * Interface for passing the request id on both request and response bodies.
 * The request id is used to track and correlate requests and responses on the API, in the Audit logs,
 * and in the open metadata repositories.
 */
public interface RequestIdService
{
    /**
     * Return the identifier for the request.
     *
     * @return string guid
     */
    String getRequestId();


    /**
     * Set up the identifier for the request.
     *
     * @param requestId string guid
     */
    void setRequestId(String requestId);
}
