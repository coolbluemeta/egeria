/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.integration.iterator;


import org.odpi.openmetadata.frameworks.auditlog.AuditLog;
import org.odpi.openmetadata.frameworks.openmetadata.properties.MetadataCorrelationHeader;
import org.odpi.openmetadata.frameworks.openmetadata.properties.OpenMetadataElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.RelatedMetadataElement;
import org.odpi.openmetadata.frameworks.integration.ffdc.OIFAuditCode;
import org.odpi.openmetadata.frameworks.openmetadata.enums.PermittedSynchronization;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * MemberElement describes a single element in a metadata collection.  It is also able to determine the
 * action to take in the synchronization process provided targetPermittedSynchronization is set up
 * to be To/From/Both and the third party technology supports creation/last update dates (because if these
 * dates are null, the classifier assumes the element does not exist in the third party.)
 */
public class MemberElement
{
    private final OpenMetadataElement              element;
    private final RelatedMetadataElement           rootSchemaType;
    private       MetadataCorrelationHeader        externalIdentifier = null;
    private final Map<String, Map<String, String>> vendorProperties;
    private final String                           catalogTargetName;
    private final String                           connectorName;
    private final boolean                          isElementActive;
    private final PermittedSynchronization         targetPermittedSynchronization;
    private final AuditLog                         auditLog;
    private PermittedSynchronization               instanceSyncDirection = null;


    /**
     * Create a member element.
     *
     * @param element open metadata element
     * @param rootSchemaType the schema type element or the root of the schema (if exists)
     * @param externalIdentifiers external identifiers for this element from the third party system
     * @param externalScopeGUID unique identifier for the owning scope (typically a catalog)
     * @param vendorProperties additional properties related to the particular technology deployment.
     * @param isElementActive is the element retrieved either archived or deleted (false) or still actively available (true)
     * @param catalogTargetName name of target
     * @param connectorName name of the connector
     * @param targetPermittedSynchronization direction of metadata flow policy
     * @param auditLog logging destination
     */
    MemberElement(OpenMetadataElement              element,
                  RelatedMetadataElement           rootSchemaType,
                  List<MetadataCorrelationHeader>  externalIdentifiers,
                  String                           externalScopeGUID,
                  Map<String, Map<String, String>> vendorProperties,
                  boolean                          isElementActive,
                  String                           catalogTargetName,
                  String                           connectorName,
                  PermittedSynchronization         targetPermittedSynchronization,
                  AuditLog                         auditLog)
    {
        this.element                        = element;
        this.rootSchemaType                 = rootSchemaType;
        this.vendorProperties               = vendorProperties;
        this.isElementActive                = isElementActive;
        this.catalogTargetName              = catalogTargetName;
        this.connectorName                  = connectorName;
        this.targetPermittedSynchronization = targetPermittedSynchronization;
        this.auditLog                       = auditLog;

        if (element == null)
        {
            this.instanceSyncDirection = PermittedSynchronization.FROM_THIRD_PARTY;
        }

        if ((externalIdentifiers != null) && (externalScopeGUID != null))
        {
            for (MetadataCorrelationHeader externalIdentifier : externalIdentifiers)
            {
                if ((externalIdentifier != null) && (externalScopeGUID.equals(externalIdentifier.getExternalScopeGUID())))
                {
                    this.externalIdentifier = externalIdentifier;
                    if (externalIdentifier.getSynchronizationDirection() != null)
                    {
                        this.instanceSyncDirection = externalIdentifier.getSynchronizationDirection();
                    }
                }
            }
        }

        if (instanceSyncDirection == null)
        {
            instanceSyncDirection = targetPermittedSynchronization;
        }
    }


    /**
     * Return the element.
     *
     * @return open metadata element
     */
    public OpenMetadataElement getElement()
    {
        return element;
    }


    /**
     * Return the related schema type element that is the root of the element's schema.  This is only
     * present on assets - and not all assets have a schema.
     *
     * @return related metadata element
     */
    public RelatedMetadataElement getRootSchemaType()
    {
        return rootSchemaType;
    }


    /**
     * The specific identifier from the third party system.
     *
     * @return selected external identifier
     */
    public MetadataCorrelationHeader getExternalIdentifier()
    {
        return externalIdentifier;
    }


    /**
     * Return any additional properties that are specific to the deployment.
     *
     * @return string map
     */
    public Map<String, String> getVendorProperties(String vendorIdentifier)
    {
        return vendorProperties.get(vendorIdentifier);
    }


    /**
     * Return the action that needs to be taken based on the information both in the open metadata
     * ecosystem and the third party system.
     *
     * @param thirdPartyElementCreationTime the time that the element was created in the third party - if this value
     *                                      is null then it is assumed that the element does not exist in the third party system
     * @param thirdPartyElementLastUpdateTime the time that the element was last updated in the third party
     * @return the action to take
     */
    public MemberAction getMemberAction(Date   thirdPartyElementCreationTime,
                                        Date   thirdPartyElementLastUpdateTime)
    {
        final String methodName = "getMemberAction";

        if (element != null) /* Element in Egeria.  */
        {
            if (isElementActive)
            {
                if (thirdPartyElementCreationTime == null)  /* Element just in Egeria. */
                {
                    if (externalIdentifier == null)        /* Element never synchronized before */
                    {
                        if ((targetPermittedSynchronization == PermittedSynchronization.BOTH_DIRECTIONS) ||
                                (targetPermittedSynchronization == PermittedSynchronization.TO_THIRD_PARTY))
                        {
                            return MemberAction.CREATE_INSTANCE_IN_THIRD_PARTY;
                        }
                        else if (targetPermittedSynchronization == PermittedSynchronization.FROM_THIRD_PARTY)
                        {
                            auditLog.logMessage(methodName,
                                                OIFAuditCode.IGNORED_EGERIA_ELEMENT.getMessageDefinition(connectorName,
                                                                                                         element.getType().getTypeName(),
                                                                                                         element.getElementGUID(),
                                                                                                         element.getOrigin().getHomeMetadataCollectionName(),
                                                                                                         element.getOrigin().getHomeMetadataCollectionId(),
                                                                                                         catalogTargetName,
                                                                                                         targetPermittedSynchronization.getName()));

                            return MemberAction.NO_ACTION;
                        }
                    }
                    else if (instanceSyncDirection != null) /* this should be true */
                    {
                        if ((instanceSyncDirection == PermittedSynchronization.BOTH_DIRECTIONS) ||
                            (instanceSyncDirection == PermittedSynchronization.FROM_THIRD_PARTY))
                        {
                            return MemberAction.DELETE_INSTANCE_IN_OPEN_METADATA;
                        }
                        else if (instanceSyncDirection == PermittedSynchronization.TO_THIRD_PARTY)
                        {
                            return MemberAction.CREATE_INSTANCE_IN_THIRD_PARTY;
                        }
                    }
                }
                else /* Element in both. */
                {
                    DateComparison dateComparison = this.compareAges(thirdPartyElementCreationTime, thirdPartyElementLastUpdateTime);

                    if (dateComparison == DateComparison.DATES_EQUAL)
                    {
                        return MemberAction.NO_ACTION;
                    }

                    if (dateComparison == DateComparison.EGERIA_COPY_NEWEST)
                    {
                        if (instanceSyncDirection == PermittedSynchronization.FROM_THIRD_PARTY)
                        {
                            return MemberAction.UPDATE_INSTANCE_IN_OPEN_METADATA;
                        }
                        else if ((instanceSyncDirection == PermittedSynchronization.BOTH_DIRECTIONS) ||
                                (instanceSyncDirection == PermittedSynchronization.TO_THIRD_PARTY))
                        {
                            return MemberAction.UPDATE_INSTANCE_IN_THIRD_PARTY;
                        }
                    }

                    if (dateComparison == DateComparison.THIRD_PARTY_COPY_NEWEST)
                    {
                        if (instanceSyncDirection == PermittedSynchronization.TO_THIRD_PARTY)
                        {
                            return MemberAction.UPDATE_INSTANCE_IN_THIRD_PARTY;
                        }
                        else if ((instanceSyncDirection == PermittedSynchronization.BOTH_DIRECTIONS) ||
                                (instanceSyncDirection == PermittedSynchronization.FROM_THIRD_PARTY))
                        {
                            return MemberAction.UPDATE_INSTANCE_IN_OPEN_METADATA;
                        }
                    }
                }
            }
            else /* element in egeria is either deleted or archived */
            {
                if (targetPermittedSynchronization == PermittedSynchronization.TO_THIRD_PARTY)
                {
                    return MemberAction.DELETE_INSTANCE_IN_THIRD_PARTY;
                }
                else if (targetPermittedSynchronization == PermittedSynchronization.FROM_THIRD_PARTY)
                {
                    return MemberAction.CREATE_INSTANCE_IN_OPEN_METADATA;
                }
                else if (targetPermittedSynchronization == PermittedSynchronization.BOTH_DIRECTIONS)
                {
                    DateComparison dateComparison = compareAges(thirdPartyElementCreationTime,
                                                                thirdPartyElementLastUpdateTime);
                    if ((dateComparison == DateComparison.EGERIA_COPY_NEWEST) ||
                        (dateComparison == DateComparison.DATES_EQUAL))
                    {
                        return MemberAction.DELETE_INSTANCE_IN_THIRD_PARTY;
                    }
                    else if (dateComparison == DateComparison.THIRD_PARTY_COPY_NEWEST)
                    {
                        return MemberAction.CREATE_INSTANCE_IN_OPEN_METADATA;
                    }
                }
            }
        }
        else /* No element in Egeria. */
        {
            return MemberAction.CREATE_INSTANCE_IN_OPEN_METADATA;
        }

        /*
         *  This is a logic error.
         */
        auditLog.logMessage(methodName,
                            OIFAuditCode.UNKNOWN_ACTION.getMessageDefinition(connectorName, this.toString()));

        return MemberAction.UNKNOWN_ACTION;
    }


    /**
     * Enum to represent the comparison of ages of the
     */
    enum DateComparison
    {
        EGERIA_COPY_NEWEST,
        DATES_EQUAL,
        THIRD_PARTY_COPY_NEWEST
    }


    private Date getLastChangeToElement(Date createTime, Date lastUpdateTime)
    {
        Date lastChange = lastUpdateTime;

        if (lastChange == null)
        {
            lastChange = createTime;
        }

        assert (lastChange != null);

        return lastChange;
    }


    /**
     * Determine the relative ages of the elements from open metadata and the third party.
     *
     * @param thirdPartyElementCreationTime the time that the element was created in the third party
     * @param thirdPartyElementLastUpdateTime the time that the element was last updated in the third party
     * @return date comparison enum
     */
    private DateComparison compareAges(Date thirdPartyElementCreationTime,
                                       Date thirdPartyElementLastUpdateTime)
    {
        Date elementComparisonDate = getLastChangeToElement(element.getVersions().getCreateTime(),
                                                            element.getVersions().getUpdateTime());

        Date thirdPartyComparisonDate = getLastChangeToElement(thirdPartyElementCreationTime,
                                                               thirdPartyElementLastUpdateTime);

        if (thirdPartyComparisonDate.after(elementComparisonDate))
        {
            /*
             * Third party has the latest copy - was the change before the last synchronization time
             */
            if (externalIdentifier != null)
            {
                if ((externalIdentifier.getLastSynchronized() != null) && (thirdPartyComparisonDate.after(externalIdentifier.getLastSynchronized())))
                {
                    return DateComparison.THIRD_PARTY_COPY_NEWEST;
                }

                return DateComparison.DATES_EQUAL;
            }
            else
            {
                return DateComparison.THIRD_PARTY_COPY_NEWEST;
            }
        }

        if (elementComparisonDate.after(thirdPartyComparisonDate))
        {
            /*
             * Egeria has the newest copy - has it been updated since the last
             * synchronization date?
             */
            if (externalIdentifier != null)
            {
                if ((externalIdentifier.getLastSynchronized() != null) && (externalIdentifier.getLastSynchronized().before(elementComparisonDate)))
                {
                    return DateComparison.EGERIA_COPY_NEWEST;
                }

                return DateComparison.DATES_EQUAL;
            }
            else
            {
                return DateComparison.EGERIA_COPY_NEWEST;
            }
        }

        return DateComparison.DATES_EQUAL;
    }


    /**
     * Print out useful info.
     *
     * @return string
     */
    @Override
    public String toString()
    {
        String elementGUID = "null";

        if (element != null)
        {
            elementGUID = element.getElementGUID();
        }

        return "MemberElement{" +
                "element=" + elementGUID +
                "externalIdentifiers=" + externalIdentifier +
                ", catalogTargetName='" + catalogTargetName + '\'' +
                ", isElementActive=" + isElementActive +
                ", targetPermittedSynchronization=" + targetPermittedSynchronization +
                ", auditLog=" + auditLog +
                ", instanceSyncDirection=" + instanceSyncDirection +
                '}';
    }
}
