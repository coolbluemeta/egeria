/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.connectors.integration.jdbc.ffdc;

import org.odpi.openmetadata.frameworks.auditlog.AuditLogRecordSeverityLevel;
import org.odpi.openmetadata.frameworks.auditlog.messagesets.AuditLogMessageDefinition;
import org.odpi.openmetadata.frameworks.auditlog.messagesets.AuditLogMessageSet;


/**
 * The JDBCIntegrationConnectorAuditCode is used to define the message content for the Audit Log.
 * The 5 fields in the enum are:
 * <ul>
 *     <li>Log Message Id - to uniquely identify the message</li>
 *     <li>Severity - is this an event, decision, action, error or exception</li>
 *     <li>Log Message Text - includes placeholder to allow additional values to be captured</li>
 *     <li>SystemAction - describes the result of the situation</li>
 *     <li>UserAction - describes how a user should correct the situation</li>
 * </ul>
 */
public enum JDBCIntegrationConnectorAuditCode implements AuditLogMessageSet
{

    EXITING_ON_CONNECTION_FAIL("JDBC-INTEGRATION-CONNECTOR-0001",
                               AuditLogRecordSeverityLevel.INFO,
                               "Exiting from method {0} as a result of a failed connection",
                               "Stopping execution",
                               "Investigate log for additional details"),
    EXITING_ON_COMPLETE("JDBC-INTEGRATION-CONNECTOR-0002",
                        AuditLogRecordSeverityLevel.INFO,
                        "Execution of method {0} is complete",
                        "Stopping execution",
                        "No user actions necessary"),
    EXITING_ON_INTEGRATION_CONTEXT_FAIL("JDBC-INTEGRATION-CONNECTOR-0004",
                                        AuditLogRecordSeverityLevel.INFO,
                                        "Exiting from method {0} as a result of a failed integration context retrieval",
                                        "Stopping execution",
                                        "Consult logs for further details"),
    EXCEPTION_READING_JDBC("JDBC-INTEGRATION-CONNECTOR-0005",
                           AuditLogRecordSeverityLevel.EXCEPTION,
                           "An SQL exception was received by method {0}. Exception message is: {1}",
                           "Reading JDBC",
                           "Take appropriate action to remedy the issue described in the exception message"),
    EXCEPTION_WRITING_OMAS("JDBC-INTEGRATION-CONNECTOR-0006",
                           AuditLogRecordSeverityLevel.EXCEPTION,
                           "An exception was received by method {0}. Exception message is: {1}",
                           "Upserting an entity into the Metadata Access Server failed.",
                           "Investigate OMAS availability. If it is available then contact the Egeria team for support"),
    EXITING_ON_DATABASE_TRANSFER_FAIL("JDBC-INTEGRATION-CONNECTOR-0007",
                                      AuditLogRecordSeverityLevel.INFO,
                                      "Exiting from method {0} as a result of a failed database transfer",
                                      "Stopping execution",
                                      "Consult logs for further details"),
    EXCEPTION_READING_OMAS("JDBC-INTEGRATION-CONNECTOR-0008",
                           AuditLogRecordSeverityLevel.EXCEPTION,
                           "Error reading data from Metadata Access Server in method {0}. Possible message is {1}",
                           "Reading OMAS information",
                           "Consult logs for further details"),
    PARTIAL_TRANSFER_COMPLETE_FOR_DB_OBJECTS("JDBC-INTEGRATION-CONNECTOR-0009",
                                             AuditLogRecordSeverityLevel.INFO,
                                             "Metadata transfer complete for {0} in {1} seconds",
                                             "Transferring metadata information",
                                             "None"),
    EXCEPTION_WHEN_REMOVING_ELEMENT_IN_OMAS("JDBC-INTEGRATION-CONNECTOR-0010",
                                            AuditLogRecordSeverityLevel.INFO,
                                            "Unknown error when removing element from Metadata Access Server with guid {0} and qualified name {1}.",
                                            "Removing element in OMAS",
                                            "Consult logs for further details"),
    EXCEPTION_ON_CONTEXT_RETRIEVAL("JDBC-INTEGRATION-CONNECTOR-0011",
                                   AuditLogRecordSeverityLevel.EXCEPTION,
                                   "Retrieving integration context failed in method {0}",
                                   "Stopping execution",
                                   "Take appropriate action to remedy the issue described in the exception message"),
    TRANSFER_COMPLETE_FOR_DB_OBJECT("JDBC-INTEGRATION-CONNECTOR-0012",
                                    AuditLogRecordSeverityLevel.INFO,
                                    "Transfer complete for {0}",
                                    "Continue execution",
                                    "None"),
    TRANSFER_EXCEPTIONS_FOR_DB_OBJECT("JDBC-INTEGRATION-CONNECTOR-0013",
                                      AuditLogRecordSeverityLevel.INFO,
                                      "Metadata transfer skipped for following {0}: {1}",
                                      "Continue execution",
                                      "None"),
    EXITING_ON_METADATA_TEST("JDBC-INTEGRATION-CONNECTOR-00014",
                             AuditLogRecordSeverityLevel.INFO,
                             "Exiting from method {0} as a result of a failed metadata query test",
                             "Stopping execution",
                             "Investigate log for additional details");


    private final String                      logMessageId;
    private final AuditLogRecordSeverityLevel severity;
    private final String                      logMessage;
    private final String                      systemAction;
    private final String                      userAction;


    /**
     * The constructor for JDBCIntegrationConnectorAuditCode expects to be passed one of the enumeration rows defined above.
     * Example:
     * JDBCIntegrationConnectorAuditCode auditCode = JDBCIntegrationConnectorAuditCode.EXCEPTION_COMMITTING_OFFSETS;
     * This will expand out to the 5 parameters shown below.
     *
     * @param messageId unique id for the message
     * @param severity severity of the message
     * @param message text for the message
     * @param systemAction description of the action taken by the system when the condition happened
     * @param userAction instructions for resolving the situation, if any
     */
    JDBCIntegrationConnectorAuditCode(String                      messageId,
                                      AuditLogRecordSeverityLevel severity,
                                      String                      message,
                                      String                      systemAction,
                                      String                      userAction)
    {
        this.logMessageId = messageId;
        this.severity = severity;
        this.logMessage = message;
        this.systemAction = systemAction;
        this.userAction = userAction;
    }


    /**
     * Retrieve a message definition object for logging.  This method is used when there are no message inserts.
     *
     * @return message definition object.
     */
    @Override
    public AuditLogMessageDefinition getMessageDefinition()
    {
        return new AuditLogMessageDefinition(logMessageId,
                                             severity,
                                             logMessage,
                                             systemAction,
                                             userAction);
    }


    /**
     * Retrieve a message definition object for logging.  This method is used when there are values to be inserted into the message.
     *
     * @param params array of parameters (all strings).  They are inserted into the message according to the numbering in the message text.
     * @return message definition object.
     */
    @Override
    public AuditLogMessageDefinition getMessageDefinition(String... params)
    {
        AuditLogMessageDefinition messageDefinition = new AuditLogMessageDefinition(logMessageId,
                                                                                    severity,
                                                                                    logMessage,
                                                                                    systemAction,
                                                                                    userAction);
        messageDefinition.setMessageParameters(params);
        return messageDefinition;
    }


    /**
     * JSON-style toString
     *
     * @return string of property names and values for this enum
     */
    @Override
    public String toString()
    {
        return "AuditCode{" +
                       "logMessageId='" + logMessageId + '\'' +
                       ", severity=" + severity +
                       ", logMessage='" + logMessage + '\'' +
                       ", systemAction='" + systemAction + '\'' +
                       ", userAction='" + userAction + '\'' +
                       '}';
    }
}