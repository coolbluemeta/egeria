/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.repositoryservices.cohortregistrystore.file;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.repositoryservices.connectors.stores.cohortregistrystore.OMRSCohortRegistryStoreProviderBase;

/**
 * FileBasedRegistryStoreProvider is the OCF connector provider for the file based cohort registry store.
 */
public class FileBasedRegistryStoreProvider extends OMRSCohortRegistryStoreProviderBase
{
    /*
     * Class of the connector.
     */
    private static final String connectorClassName = "org.odpi.openmetadata.adapters.repositoryservices.cohortregistrystore.file.FileBasedRegistryStoreConnector";

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * registry store implementation.
     */
    public FileBasedRegistryStoreProvider()
    {
        super(EgeriaOpenConnectorDefinition.JSON_FILE_COHORT_REGISTRY_STORE,
              connectorClassName,
              null);
    }
}
