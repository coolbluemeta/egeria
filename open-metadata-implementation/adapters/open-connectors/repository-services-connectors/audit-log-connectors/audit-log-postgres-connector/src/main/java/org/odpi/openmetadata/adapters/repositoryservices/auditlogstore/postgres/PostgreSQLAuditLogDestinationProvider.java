/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.repositoryservices.auditlogstore.postgres;

import org.odpi.openmetadata.adapters.connectors.EgeriaOpenConnectorDefinition;
import org.odpi.openmetadata.adapters.repositoryservices.auditlogstore.postgres.controls.PostgreSQLAuditLogConfigurationProperty;
import org.odpi.openmetadata.frameworks.connectors.controls.SupportedTechnologyType;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;
import org.odpi.openmetadata.frameworks.openmetadata.definitions.DeployedImplementationTypeDefinition;
import org.odpi.openmetadata.repositoryservices.connectors.stores.auditlogstore.OMRSAuditLogStoreProviderBase;

import java.util.Collections;

/**
 * PostgreSQLAuditLogDestinationProvider is the factory class for the JDBC Audit log Destination.
 */
public class PostgreSQLAuditLogDestinationProvider extends OMRSAuditLogStoreProviderBase
{

    /**
     * Constructor used to initialize the ConnectorProviderBase with the Java class name of the specific
     * audit log store implementation.
     */
    public PostgreSQLAuditLogDestinationProvider()
    {
        super(EgeriaOpenConnectorDefinition.POSTGRES_AUDIT_LOG_DESTINATION_CONNECTOR,
              PostgreSQLAuditLogDestinationConnector.class.getName(),
              Collections.singletonList(supportedSeveritiesProperty));

        super.supportedTechnologyTypes = SupportedTechnologyType.getSupportedTechnologyTypes(new DeployedImplementationTypeDefinition[]{DeployedImplementationType.JDBC_RELATIONAL_DATABASE_SCHEMA});
        super.supportedConfigurationProperties = PostgreSQLAuditLogConfigurationProperty.getConfigurationPropertyTypes();
    }
}
