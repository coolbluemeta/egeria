/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.apacheatlas.resource;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.controls.ApacheAtlasConfigurationProperty;
import org.odpi.openmetadata.adapters.connectors.controls.AtlasDeployedImplementationType;
import org.odpi.openmetadata.frameworks.connectors.OpenConnectorProviderBase;
import org.odpi.openmetadata.frameworks.connectors.controls.SupportedTechnologyType;
import org.odpi.openmetadata.frameworks.openmetadata.definitions.DeployedImplementationTypeDefinition;


/**
 * ApacheAtlasRESTProvider is the connector provider for the Apache Atlas REST connector that provides a Java API to the Apache Atlas REST API.
 */
public class ApacheAtlasRESTProvider extends OpenConnectorProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName = "org.odpi.openmetadata.adapters.connectors.resource.apacheatlas.ApacheAtlasRESTConnector";


    /**
     * Constructor used to initialize the ConnectorProvider with the Java class name of the specific
     * store implementation.
     */
    public ApacheAtlasRESTProvider()
    {
        super(EgeriaOpenConnectorDefinition.APACHE_ATLAS_RESOURCE_CONNECTOR,
              connectorClassName,
              ApacheAtlasConfigurationProperty.getConfigPropertyNames());

        super.supportedTechnologyTypes = SupportedTechnologyType.getSupportedTechnologyTypes(new DeployedImplementationTypeDefinition[]{AtlasDeployedImplementationType.APACHE_ATLAS_SERVER});
    }
}
