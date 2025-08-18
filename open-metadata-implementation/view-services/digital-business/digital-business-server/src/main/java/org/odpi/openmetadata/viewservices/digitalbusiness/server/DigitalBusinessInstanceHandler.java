/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.viewservices.digitalbusiness.server;


import org.odpi.openmetadata.adminservices.configuration.registration.ViewServiceDescription;
import org.odpi.openmetadata.commonservices.multitenant.OMVSServiceInstanceHandler;



/**
 * DigitalBusinessInstanceHandler retrieves information from the instance map for the
 * view service instances.  The instance map is thread-safe.  Instances are added
 * and removed by the DigitalBusinessAdmin class.
 */
public class DigitalBusinessInstanceHandler extends OMVSServiceInstanceHandler
{
    /**
     * Default constructor registers the view service
     */
    public DigitalBusinessInstanceHandler()
    {
        super(ViewServiceDescription.DIGITAL_BUSINESS.getViewServiceFullName());

        DigitalBusinessRegistration.registerViewService();
    }


}
