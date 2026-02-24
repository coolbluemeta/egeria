/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.auditlog.requestid;

public interface RequestIdService
{
    /**
     * Return the unique identifier for the request.
     *
     * @return string guid
     */
    String getRequestId();


    /**
     * Set up the unique identifier for the request.
     *
     * @param requestId string guid
     */
    void setRequestId(String requestId);
}
