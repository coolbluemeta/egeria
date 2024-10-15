/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.opentypes;


import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataProperty;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;
import org.odpi.openmetadata.repositoryservices.archiveutilities.OMRSArchiveBuilder;
import org.odpi.openmetadata.repositoryservices.archiveutilities.OMRSArchiveHelper;
import org.odpi.openmetadata.repositoryservices.connectors.stores.archivestore.properties.OpenMetadataArchive;
import org.odpi.openmetadata.repositoryservices.connectors.stores.archivestore.properties.OpenMetadataArchiveType;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.ClassificationPropagationRule;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.RelationshipDef;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.RelationshipEndCardinality;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.RelationshipEndDef;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefAttribute;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefAttributeStatus;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefPatch;
import org.odpi.openmetadata.repositoryservices.ffdc.OMRSErrorCode;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.OMRSLogicErrorException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * OpenMetadataTypesArchive builds an open metadata archive containing all the standard open metadata types.
 * These types have hardcoded dates and guids so that however many times this archive is rebuilt, it will
 * produce the same content.
 * <p>
 * Details of the open metadata types are documented on the wiki:
 * <a href="https://egeria-project.org/types/">The Open Metadata Type System</a>
 * </p>
 * <p>
 * There are 8 areas, each covering a different topic area of metadata.  The module breaks down the process of creating
 * the models into the areas and then the individual models to simplify the maintenance of this class
 * </p>
 */
public class OpenMetadataTypesArchive3_15
{
    /*
     * This is the header information for the archive.
     */
    private static final String                  archiveGUID        = "bce3b0a0-662a-4f87-b8dc-844078a11a6e";
    private static final String                  archiveName        = "Open Metadata Types";
    private static final String                  archiveDescription = "Standard types for open metadata repositories.";
    private static final OpenMetadataArchiveType archiveType        = OpenMetadataArchiveType.CONTENT_PACK;
    private static final String                  archiveVersion     = "3.15";
    private static final String                  originatorName     = "Egeria";
    private static final String                  originatorLicense  = "Apache-2.0";
    private static final Date                    creationDate       = new Date(1588261366992L);

    /*
     * Specific values for initializing TypeDefs
     */
    private static final long   versionNumber = 1L;
    private static final String versionName   = "1.0";


    private final OMRSArchiveBuilder archiveBuilder;
    private final OMRSArchiveHelper  archiveHelper;

    /**
     * Default constructor sets up the archive builder.  This in turn sets up the header for the archive.
     */
    public OpenMetadataTypesArchive3_15()
    {
        this.archiveBuilder = new OMRSArchiveBuilder(archiveGUID,
                                                     archiveName,
                                                     archiveDescription,
                                                     archiveType,
                                                     archiveVersion,
                                                     originatorName,
                                                     originatorLicense,
                                                     creationDate,
                                                     null);

        this.archiveHelper = new OMRSArchiveHelper(archiveBuilder,
                                                   archiveGUID,
                                                   originatorName,
                                                   creationDate,
                                                   versionNumber,
                                                   versionName);
    }


    /**
     * Chained constructor sets up the archive builder.  This in turn sets up the header for the archive.
     *
     * @param archiveBuilder accumulator for types
     */
    public OpenMetadataTypesArchive3_15(OMRSArchiveBuilder archiveBuilder)
    {
        this.archiveBuilder = archiveBuilder;

        this.archiveHelper = new OMRSArchiveHelper(archiveBuilder,
                                                   archiveGUID,
                                                   originatorName,
                                                   creationDate,
                                                   versionNumber,
                                                   versionName);
    }


    /**
     * Return the unique identifier for this archive.
     *
     * @return String guid
     */
    public String getArchiveGUID()
    {
        return archiveGUID;
    }


    /**
     * Returns the open metadata type archive containing all the standard open metadata types.
     *
     * @return populated open metadata archive object
     */
    public OpenMetadataArchive getOpenMetadataArchive()
    {
        final String methodName = "getOpenMetadataArchive";

        if (this.archiveBuilder != null)
        {
            /*
             * Build the type archive.
             */
            this.getOriginalTypes();

            /*
             * The completed archive is ready to be packaged up and returned
             */
            return this.archiveBuilder.getOpenMetadataArchive();
        }
        else
        {
            /*
             * This is a logic error since it means the creation of the archive builder threw an exception
             * in the constructor and so this object should not be used.
             */
            throw new OMRSLogicErrorException(OMRSErrorCode.ARCHIVE_UNAVAILABLE.getMessageDefinition(),
                                              this.getClass().getName(),
                                              methodName);
        }
    }


    /**
     * Add the types from this archive to the archive builder supplied in the
     * constructor.
     */
    public void getOriginalTypes()
    {
        OpenMetadataTypesArchive3_14 previousTypes = new OpenMetadataTypesArchive3_14(archiveBuilder);

        /*
         * Pull the types from previous releases.
         */
        previousTypes.getOriginalTypes();

        /*
         * Calls for new and changed types go here
         */
        updateGovernanceEngines();
        updateEngineActions();
        update0710DigitalServices();
        update0715DigitalServiceOwnership();
        update0735SolutionPortsAndWires();
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * Allow a mapping from a governance engine request type to a request type supported by a governance service.
     */
    private void updateGovernanceEngines()
    {
        this.archiveBuilder.addTypeDefPatch(updateSupportedGovernanceServiceRelationship());
    }


    private TypeDefPatch updateSupportedGovernanceServiceRelationship()
    {
        /*
         * Create the Patch
         */
        final String typeName = OpenMetadataType.SUPPORTED_GOVERNANCE_SERVICE_RELATIONSHIP.typeName;

        TypeDefPatch typeDefPatch = archiveBuilder.getPatchForType(typeName);

        typeDefPatch.setUpdatedBy(originatorName);
        typeDefPatch.setUpdateTime(creationDate);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();
        TypeDefAttribute       property;

        final String attribute1Name            = OpenMetadataProperty.SERVICE_REQUEST_TYPE.name;
        final String attribute1Description     = OpenMetadataProperty.SERVICE_REQUEST_TYPE.description;
        final String attribute1DescriptionGUID = OpenMetadataProperty.SERVICE_REQUEST_TYPE.descriptionGUID;

        property = archiveHelper.getStringTypeDefAttribute(attribute1Name,
                                                           attribute1Description,
                                                           attribute1DescriptionGUID);
        properties.add(property);

        typeDefPatch.setPropertyDefinitions(properties);

        return typeDefPatch;
    }



    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * Allow a governance service to record a message as part of its completion.  This is particularly useful if it fails.
     */
    private void updateEngineActions()
    {
        this.archiveBuilder.addTypeDefPatch(updateEngineActionEntity());
        this.archiveBuilder.addTypeDefPatch(updateTargetForActionRelationship());
    }


    private TypeDefPatch updateEngineActionEntity()
    {
        /*
         * Create the Patch
         */
        final String typeName = OpenMetadataType.ENGINE_ACTION.typeName;

        TypeDefPatch typeDefPatch = archiveBuilder.getPatchForType(typeName);

        typeDefPatch.setUpdatedBy(originatorName);
        typeDefPatch.setUpdateTime(creationDate);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();
        TypeDefAttribute       property;

        final String attribute1Name            = OpenMetadataProperty.COMPLETION_MESSAGE.name;
        final String attribute1Description     = OpenMetadataProperty.COMPLETION_MESSAGE.description;
        final String attribute1DescriptionGUID = OpenMetadataProperty.COMPLETION_MESSAGE.descriptionGUID;

        property = archiveHelper.getStringTypeDefAttribute(attribute1Name,
                                                           attribute1Description,
                                                           attribute1DescriptionGUID);
        properties.add(property);

        typeDefPatch.setPropertyDefinitions(properties);

        return typeDefPatch;
    }


    private TypeDefPatch updateTargetForActionRelationship()
    {
        /*
         * Create the Patch
         */
        final String typeName = OpenMetadataType.TARGET_FOR_ACTION.typeName;

        TypeDefPatch typeDefPatch = archiveBuilder.getPatchForType(typeName);

        typeDefPatch.setUpdatedBy(originatorName);
        typeDefPatch.setUpdateTime(creationDate);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();
        TypeDefAttribute       property;

        property = archiveHelper.getStringTypeDefAttribute(OpenMetadataProperty.COMPLETION_MESSAGE.name,
                                                           OpenMetadataProperty.COMPLETION_MESSAGE.description,
                                                           OpenMetadataProperty.COMPLETION_MESSAGE.descriptionGUID);
        properties.add(property);

        typeDefPatch.setPropertyDefinitions(properties);

        return typeDefPatch;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void update0710DigitalServices()
    {
        this.archiveBuilder.addRelationshipDef(getDigitalServiceProductRelationship());
        this.archiveBuilder.addTypeDefPatch(updateDigitalProductClassification());
    }

    private RelationshipDef getDigitalServiceProductRelationship()
    {
        final String guid            = "51465a59-c785-406d-929c-def34596e9af";
        final String name            = "DigitalServiceProduct";
        final String description     = "A digital product that is maintained by a digital service.";
        final String descriptionGUID = null;

        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(guid,
                                                                                name,
                                                                                null,
                                                                                description,
                                                                                descriptionGUID,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1EntityType               = "DigitalService";
        final String                     end1AttributeName            = "managingDigitalService";
        final String                     end1AttributeDescription     = "Digital service responsible for the production of the digital product.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(end1EntityType),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "digitalProducts";
        final String                     end2AttributeDescription     = "The associated digital products.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private TypeDefPatch updateDigitalProductClassification()
    {
        /*
         * Create the Patch
         */
        final String typeName = OpenMetadataType.DIGITAL_PRODUCT_CLASSIFICATION.typeName;

        TypeDefPatch typeDefPatch = archiveBuilder.getPatchForType(typeName);

        typeDefPatch.setUpdatedBy(originatorName);
        typeDefPatch.setUpdateTime(creationDate);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();
        TypeDefAttribute       property;

        final String attribute1Name = "syncDatesByKey";
        final String attribute1Description = "Collection of synchronization dates identified by a key (deprecated, added in error).";
        final String attribute1DescriptionGUID = null;
        final String attribute2Name = OpenMetadataProperty.PRODUCT_NAME.name;
        final String attribute2Description = OpenMetadataProperty.PRODUCT_NAME.description;
        final String attribute2DescriptionGUID = OpenMetadataProperty.PRODUCT_NAME.descriptionGUID;
        final String attribute3Name = OpenMetadataProperty.PRODUCT_TYPE.name;
        final String attribute3Description = OpenMetadataProperty.PRODUCT_TYPE.description;
        final String attribute3DescriptionGUID = OpenMetadataProperty.PRODUCT_TYPE.descriptionGUID;
        final String attribute4Name = OpenMetadataProperty.INTRODUCTION_DATE.name;
        final String attribute4Description = OpenMetadataProperty.INTRODUCTION_DATE.description;
        final String attribute4DescriptionGUID = OpenMetadataProperty.INTRODUCTION_DATE.descriptionGUID;
        final String attribute5Name = OpenMetadataProperty.MATURITY.name;
        final String attribute5Description = OpenMetadataProperty.MATURITY.description;
        final String attribute5DescriptionGUID = OpenMetadataProperty.MATURITY.descriptionGUID;
        final String attribute6Name = OpenMetadataProperty.SERVICE_LIFE.name;
        final String attribute6Description = OpenMetadataProperty.SERVICE_LIFE.description;
        final String attribute6DescriptionGUID = OpenMetadataProperty.SERVICE_LIFE.descriptionGUID;
        final String attribute7Name = OpenMetadataProperty.CURRENT_VERSION.name;
        final String attribute7Description = OpenMetadataProperty.CURRENT_VERSION.description;
        final String attribute7DescriptionGUID = OpenMetadataProperty.CURRENT_VERSION.descriptionGUID;
        final String attribute8Name = OpenMetadataProperty.NEXT_VERSION_DATE.name;
        final String attribute8Description = OpenMetadataProperty.NEXT_VERSION_DATE.description;
        final String attribute8DescriptionGUID = OpenMetadataProperty.NEXT_VERSION_DATE.descriptionGUID;
        final String attribute9Name = OpenMetadataProperty.WITHDRAW_DATE.name;
        final String attribute9Description = OpenMetadataProperty.WITHDRAW_DATE.description;
        final String attribute9DescriptionGUID = OpenMetadataProperty.WITHDRAW_DATE.descriptionGUID;

        property = archiveHelper.getMapStringLongTypeDefAttribute(attribute1Name,
                                                                  attribute1Description,
                                                                  attribute1DescriptionGUID);

        property.setAttributeStatus(TypeDefAttributeStatus.DEPRECATED_ATTRIBUTE);
        properties.add(property);
        property = archiveHelper.getStringTypeDefAttribute(attribute2Name,
                                                           attribute2Description,
                                                           attribute2DescriptionGUID);
        properties.add(property);
        property = archiveHelper.getStringTypeDefAttribute(attribute3Name,
                                                           attribute3Description,
                                                           attribute3DescriptionGUID);
        properties.add(property);
        property = archiveHelper.getDateTypeDefAttribute(attribute4Name,
                                                         attribute4Description,
                                                         attribute4DescriptionGUID);
        properties.add(property);
        property = archiveHelper.getStringTypeDefAttribute(attribute5Name,
                                                           attribute5Description,
                                                           attribute5DescriptionGUID);
        properties.add(property);
        property = archiveHelper.getStringTypeDefAttribute(attribute6Name,
                                                           attribute6Description,
                                                           attribute6DescriptionGUID);
        properties.add(property);
        property = archiveHelper.getStringTypeDefAttribute(attribute7Name,
                                                           attribute7Description,
                                                           attribute7DescriptionGUID);
        properties.add(property);
        property = archiveHelper.getDateTypeDefAttribute(attribute8Name,
                                                         attribute8Description,
                                                         attribute8DescriptionGUID);
        properties.add(property);
        property = archiveHelper.getDateTypeDefAttribute(attribute9Name,
                                                         attribute9Description,
                                                         attribute9DescriptionGUID);
        properties.add(property);
        property = archiveHelper.getMapStringStringTypeDefAttribute(OpenMetadataProperty.ADDITIONAL_PROPERTIES.name,
                                                                    OpenMetadataProperty.ADDITIONAL_PROPERTIES.description,
                                                                    OpenMetadataProperty.ADDITIONAL_PROPERTIES.descriptionGUID);
        properties.add(property);

        typeDefPatch.setPropertyDefinitions(properties);

        return typeDefPatch;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void update0715DigitalServiceOwnership()
    {
        this.archiveBuilder.addTypeDefPatch(updateDigitalServiceOperatorRelationship());
    }

    private TypeDefPatch updateDigitalServiceOperatorRelationship()
    {
        /*
         * Create the Patch
         */
        final String typeName = "DigitalServiceOperator";

        TypeDefPatch  typeDefPatch = archiveBuilder.getPatchForType(typeName);

        typeDefPatch.setUpdatedBy(originatorName);
        typeDefPatch.setUpdateTime(creationDate);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "digitalServiceOperators";
        final String                     end2AttributeDescription     = "The unit (team, capability, ...) responsible for managing this digital service.";
        final String                     end2AttributeDescriptionGUID = null;

        RelationshipEndDef relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                                    end2AttributeName,
                                                                                    end2AttributeDescription,
                                                                                    end2AttributeDescriptionGUID,
                                                                                    RelationshipEndCardinality.ANY_NUMBER);


        typeDefPatch.setEndDef2(relationshipEndDef);

        return typeDefPatch;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void update0735SolutionPortsAndWires()
    {
        this.archiveBuilder.addTypeDefPatch(updateSolutionLinkingWireRelationship());
    }

    private TypeDefPatch updateSolutionLinkingWireRelationship()
    {
        /*
         * Create the Patch
         */
        final String typeName = "DigitalServiceOperator";

        TypeDefPatch  typeDefPatch = archiveBuilder.getPatchForType(typeName);

        typeDefPatch.setUpdatedBy(originatorName);
        typeDefPatch.setUpdateTime(creationDate);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "digitalServiceOperators";
        final String                     end2AttributeDescription     = "The unit (team, capability, ...) responsible for managing this digital service.";
        final String                     end2AttributeDescriptionGUID = null;

        RelationshipEndDef relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                                    end2AttributeName,
                                                                                    end2AttributeDescription,
                                                                                    end2AttributeDescriptionGUID,
                                                                                    RelationshipEndCardinality.ANY_NUMBER);


        typeDefPatch.setEndDef2(relationshipEndDef);

        return typeDefPatch;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */
}

