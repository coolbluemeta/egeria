/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.integration.openlineage;


/**
 * OpenLineageEventListener is implemented by an integration connector that wishes to receive open lineage events as they are sent to the
 * integration daemon.
 */
public interface OpenLineageEventListener
{
    /**
     * Called each time an open lineage run event is published to the integration daemon.  The integration connector is able to
     * work with the formatted event using the Egeria beans or reformat the open lineage run event using the supplied open lineage backend beans
     * or another set of beans.
     *
     * @param event run event formatted using Egeria supplied beans (null if egeria can not format the event)
     * @param rawEvent json payload received for the event
     */
    void processOpenLineageRunEvent(OpenLineageRunEvent event,
                                    String              rawEvent);
}
