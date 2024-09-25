/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.connectors;

import org.odpi.openmetadata.frameworks.auditlog.AuditLog;
import org.odpi.openmetadata.frameworks.auditlog.AuditLoggingComponent;
import org.odpi.openmetadata.frameworks.auditlog.ComponentDescription;
import org.odpi.openmetadata.frameworks.connectors.controls.SecretsStoreConfigurationProperty;
import org.odpi.openmetadata.frameworks.connectors.ffdc.ConnectorCheckedException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.OCFErrorCode;

/**
 * SecretsStoreConnector is the interface for a connector that is able to retrieve secrets (passwords, certificates, ...) from a secure location.
 * The secrets store connector is embedded in a connector that needs one or more secrets to perform its tasks.  Both connectors are initialised
 * together by the ConnectorBroker.  The secrets store connector is called by the surrounding connector to extract the needed secrets.
 * When the ConnectorBroker detects that there is a secrets store connector embedded in another connector, it attempts to retrieve the standard
 * secrets for the corresponding connection object (if they are null):
 *
 * <ul>
 *     <li>userId</li>
 *     <li>clearPassword</li>
 *     <li>encryptedPassword</li>
 * </ul>
 *
 * This means that even if the outer connector is written to expect these secrets in its connection object, they do not need to be stored
 * in the connection object (ie in the configuration document or in the metadata store) but will be placed in the right fields by the
 * ConnectorBroker.
 * If the name(s) of the secret(s) needed by the connector must be configured, they can be stored in the secureProperties.
 */
public abstract class SecretsStoreConnector extends ConnectorBase implements AuditLoggingComponent
{
    protected String   secretsCollectionName = null;
    protected AuditLog auditLog = null;

    /**
     * Return the component description that is used by this connector in the audit log.
     *
     * @return id, name, description, wiki page URL.
     */
    public ComponentDescription getConnectorComponentDescription()
    {
        if ((this.auditLog != null) && (this.auditLog.getReport() != null))
        {
            return auditLog.getReport().getReportingComponent();
        }

        return null;
    }


    /**
     * Receive an audit log object that can be used to record audit log messages.  The caller has initialized it
     * with the correct component description and log destinations.
     *
     * @param auditLog audit log object
     */
    @Override
    public void setAuditLog(AuditLog auditLog)
    {
        this.auditLog = auditLog;
    }


    /**
     * Indicates that the connector is completely configured and can begin processing.
     *
     * @throws ConnectorCheckedException there is a problem within the connector.
     */
    @Override
    public void start() throws ConnectorCheckedException
    {
        super.start();

        final String methodName = "start";

        secretsCollectionName = super.getStringConfigurationProperty(SecretsStoreConfigurationProperty.SECRETS_COLLECTION_NAME.getName(),
                                                                     connectionProperties.getConfigurationProperties());

        if (secretsCollectionName == null)
        {
            throwMissingConfigurationProperty(this.getClass().getName(),
                                              "secrets",
                                              SecretsStoreConfigurationProperty.SECRETS_COLLECTION_NAME.getName(),
                                              methodName);
        }
    }


    /**
     * Retrieve a secret from the secrets store.
     *
     * @param secretName name of the secret.
     * @return secret
     */
    abstract public String getSecret(String secretName);
}
