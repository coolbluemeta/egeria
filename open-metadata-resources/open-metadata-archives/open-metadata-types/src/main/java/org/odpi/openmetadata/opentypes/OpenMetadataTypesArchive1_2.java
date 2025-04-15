/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.opentypes;


import org.odpi.openmetadata.frameworks.openmetadata.enums.*;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataProperty;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;
import org.odpi.openmetadata.frameworks.openmetadata.enums.AnnotationStatus;
import org.odpi.openmetadata.repositoryservices.archiveutilities.OMRSArchiveBuilder;
import org.odpi.openmetadata.repositoryservices.archiveutilities.OMRSArchiveHelper;
import org.odpi.openmetadata.repositoryservices.connectors.stores.archivestore.properties.OpenMetadataArchiveType;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceStatus;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * OpenMetadataTypesArchive1_2 provides the archive content for the open metadata types that were defined before Release 1.3.  These types
 * should not be changed or extended in this file.  New types, and patches to existing types should be added to OpenMetadataTypes.
 * <p>
 * Details of the open metadata types are documented on the wiki:
 * <a href="https://egeria.odpi.org/open-metadata-publication/website/open-metadata-types/">The Open Metadata Type System</a>
 * </p>
 * <p>
 * There are 8 areas, each covering a different topic area of metadata.  The module breaks down the process of creating
 * the models into the areas and then the individual models to simplify the maintenance of this class
 * </p>
 */
public class OpenMetadataTypesArchive1_2
{
    /*
     * This is the header information for the archive.
     */
    private static final String                  archiveGUID        = "bce3b0a0-662a-4f87-b8dc-844078a11a6e";
    private static final String                  archiveName        = "Open Metadata Types";
    private static final String                  archiveVersion     = "1.2";
    private static final String                  archiveDescription = "Standard types for open metadata repositories.";
    private static final OpenMetadataArchiveType archiveType        = OpenMetadataArchiveType.CONTENT_PACK;
    private static final String                  originatorName     = "ODPi Egeria";
    private static final String                  originatorLicense  = "Apache-2.0";
    private static final Date                    creationDate       = new Date(1577886131090L);

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
    public OpenMetadataTypesArchive1_2()
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
    public OpenMetadataTypesArchive1_2(OMRSArchiveBuilder archiveBuilder)
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
     * Add the types from this archive to the archive builder supplied in the
     * constructor.
     */
    public void getOriginalTypes()
    {
        this.addStandardPrimitiveDefs();
        this.addStandardCollectionDefs();
        this.addArea0Types();
        this.addArea1Types();
        this.addArea2Types();
        this.addArea3Types();
        this.addArea4Types();
        this.addArea5Types();
        this.addArea6Types();
    }


    /*
     * ========================================
     * Attribute types
     */


    /**
     * Add the standard primitive types to the archive builder.
     */
    public void addStandardPrimitiveDefs()
    {
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_UNKNOWN));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_BOOLEAN));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_BYTE));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_CHAR));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_SHORT));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_INT));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_LONG));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_FLOAT));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_DOUBLE));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_BIGINTEGER));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_BIGDECIMAL));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING));
        this.archiveBuilder.addPrimitiveDef(archiveHelper.getPrimitiveDef(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_DATE));
    }


    /**
     * Add the standard collection types to the archive builder.
     */
    public void addStandardCollectionDefs()
    {
        this.archiveBuilder.addCollectionDef(getMapStringStringCollectionDef());
        this.archiveBuilder.addCollectionDef(getMapStringBooleanCollectionDef());
        this.archiveBuilder.addCollectionDef(getMapStringIntCollectionDef());
        this.archiveBuilder.addCollectionDef(getMapStringLongCollectionDef());
        this.archiveBuilder.addCollectionDef(getMapStringDoubleCollectionDef());
        this.archiveBuilder.addCollectionDef(getMapStringDateCollectionDef());
        this.archiveBuilder.addCollectionDef(getMapStringObjectCollectionDef());
        this.archiveBuilder.addCollectionDef(getArrayStringCollectionDef());
        this.archiveBuilder.addCollectionDef(getArrayIntCollectionDef());
    }


    /**
     * Defines the {@code map<string,string>} type.
     *
     * @return CollectionDef for this type
     */
    private CollectionDef getMapStringStringCollectionDef()
    {
        final String guid            = "005c7c14-ac84-4136-beed-959401b041f8";
        final String description     = "A map from string to string.";
        final String descriptionGUID = "f285d0ca-50ab-4564-b129-c7e3ba4e8545";

        return archiveHelper.getMapCollectionDef(guid,
                                                 description,
                                                 descriptionGUID,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING);
    }


    /**
     * Defines the {@code map<string,boolean>} type.
     *
     * @return CollectionDef for this type
     */
    private CollectionDef getMapStringBooleanCollectionDef()
    {
        final String guid            = "8fa603dd-c2c5-43fc-8ff4-92141f2414ab";
        final String description     = "A map from string to Boolean.";
        final String descriptionGUID = "72d76e44-350c-4ff3-baae-54b837f723c7";

        return archiveHelper.getMapCollectionDef(guid,
                                                 description,
                                                 descriptionGUID,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_BOOLEAN);
    }


    /**
     * Defines the {@code map<string,int>} type.
     *
     * @return CollectionDef for this type
     */
    private CollectionDef getMapStringIntCollectionDef()
    {
        final String guid            = "8fa603dd-c2c5-43fc-8ff4-92141f2414ac";
        final String description     = "A map from string to int.";
        final String descriptionGUID = "47373fd6-be40-439b-97ca-881878eed1f4";

        return archiveHelper.getMapCollectionDef(guid,
                                                 description,
                                                 descriptionGUID,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_INT);
    }


    /**
     * Defines the {@code map<string,long>} type.
     *
     * @return CollectionDef for this type
     */
    private CollectionDef getMapStringLongCollectionDef()
    {
        final String guid            = "8fa603dd-c2c5-43fc-8ff4-92141f2414ae";
        final String description     = "A map from string to long.";
        final String descriptionGUID = "039b3466-e28b-4c73-8181-d9a57749c706";

        return archiveHelper.getMapCollectionDef(guid,
                                                 description,
                                                 descriptionGUID,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_LONG);
    }


    /**
     * Defines the {@code map<string,double>} type.
     *
     * @return CollectionDef for this type
     */
    private CollectionDef getMapStringDateCollectionDef()
    {
        final String guid            = "ee293c68-e34d-4885-a512-f927d35a5893";
        final String description     = "A map from string to date.";
        final String descriptionGUID = "978b8ad1-c7c8-4892-bd83-98c9f07e8028";

        return archiveHelper.getMapCollectionDef(guid,
                                                 description,
                                                 descriptionGUID,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_DATE);
    }


    /**
     * Defines the {@code map<string,double>} type.
     *
     * @return CollectionDef for this type
     */
    private CollectionDef getMapStringDoubleCollectionDef()
    {
        final String guid            = "17211869-ed39-4ba9-bead-ffd967df65a8";
        final String description     = "A map from string to double.";
        final String descriptionGUID = "ee2cf3d5-3ff8-4d6a-82ed-35c0123dcc89";

        return archiveHelper.getMapCollectionDef(guid,
                                                 description,
                                                 descriptionGUID,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_DOUBLE);
    }

    /**
     * Defines the {@code map<string,object>} type.
     *
     * @return CollectionDef for this type
     */
    private CollectionDef getMapStringObjectCollectionDef()
    {
        final String guid            = "8fa603dd-c2c5-43fc-8ff4-92141f2414ad";
        final String description     = "A map from string to object.";
        final String descriptionGUID = "6dd2944b-9107-41c6-a10b-6a938fd6f2f5";

        return archiveHelper.getMapCollectionDef(guid,
                                                 description,
                                                 descriptionGUID,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING,
                                                 PrimitiveDefCategory.OM_PRIMITIVE_TYPE_UNKNOWN);
    }


    /**
     * Define the {@code array<string>} type.
     *
     * @return CollectionDef for this object
     */
    private CollectionDef getArrayStringCollectionDef()
    {
        final String guid            = "0428b5d3-f824-459c-b7f5-f8151de59707";
        final String description     = "An array of strings.";
        final String descriptionGUID = "4a384611-d8c1-4909-a6f8-1385ffe210e2";

        return archiveHelper.getArrayCollectionDef(guid,
                                                   description,
                                                   descriptionGUID,
                                                   PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING);
    }


    /**
     * Define the {@code array<int>} type.
     *
     * @return CollectionDef for this object
     */
    private CollectionDef getArrayIntCollectionDef()
    {
        final String guid            = "0103fe10-98b0-4910-8ee0-21d529f7ff6d";
        final String description     = "An array of integers.";
        final String descriptionGUID = "ac772d8b-278e-4017-a7e8-1988c74c091e";

        return archiveHelper.getArrayCollectionDef(guid,
                                                   description,
                                                   descriptionGUID,
                                                   PrimitiveDefCategory.OM_PRIMITIVE_TYPE_INT);
    }


    /*
     * ========================================
     * AREA 0: common types and infrastructure
     */

    /**
     * Add the list of area 0 types
     */
    public void addArea0Types()
    {
        this.add0010BaseModel();
        this.add0015LinkedMediaTypes();
        this.add0017ExternalIdentifiers();
        this.add0019MoreInformation();
        this.add0020PropertyFacets();
        this.add0025Locations();
        this.add0030HostsAndPlatforms();
        this.add0035ComplexHosts();
        this.add0037SoftwareServerPlatforms();
        this.add0040SoftwareServers();
        this.add0042SoftwareServerCapabilities();
        this.add0045ServersAndAssets();
        this.add0050ApplicationsAndProcesses();
        this.add0055DataProcessingEngines();
        this.add0070NetworksAndGateways();
        this.add0090CloudPlatformsAndServices();
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0010 Base Model defines the core entities that have been inherited from the original Apache Atlas model.
     * It defines an initial set of asset types that need to be governed (more assets are defined in Area 2).
     */
    private void add0010BaseModel()
    {
        this.archiveBuilder.addEntityDef(getReferenceableEntity());
        this.archiveBuilder.addEntityDef(getAssetEntity());
        this.archiveBuilder.addEntityDef(getInfrastructureEntity());
        this.archiveBuilder.addEntityDef(getProcessEntity());
        this.archiveBuilder.addEntityDef(getDataAssetEntity());
        this.archiveBuilder.addEntityDef(getDataSetEntity());
    }


    /**
     * The Referenceable entity is the superclass of all the governed open metadata entities.  It specifies that
     * these entities have a unique identifier called OpenMetadataProperty.QUALIFIED_NAME.name.
     *
     * @return Referenceable EntityDef
     */
    private EntityDef getReferenceableEntity()
    {
        /*
         * Build the Entity
         */
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.REFERENCEABLE, null);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();
        TypeDefAttribute       property;

        property = archiveHelper.getTypeDefAttribute(OpenMetadataProperty.QUALIFIED_NAME);

        property.setUnique(true);
        property.setValuesMaxCount(1);
        property.setValuesMinCount(1);
        property.setAttributeCardinality(AttributeCardinality.ONE_ONLY);
        properties.add(property);

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ADDITIONAL_PROPERTIES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    /**
     * The Asset entity is the root entity for the assets that open metadata and governance is governing.
     *
     * @return Asset EntityDef
     */
    private EntityDef getAssetEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.ASSET,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    /**
     * The Infrastructure entity describes an asset that is physical infrastructure or part of the software
     * platform that supports the data and process assets.
     *
     * @return Infrastructure EntityDef
     */
    private EntityDef getInfrastructureEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.INFRASTRUCTURE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName));
    }


    /**
     * The Process entity describes a well-defined sequence of activities performed by people or software components.
     *
     * @return Process EntityDef
     */
    private EntityDef getProcessEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.PROCESS,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName));

        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.FORMULA));

        entityDef.setPropertiesDefinition(properties);

        ArrayList<InstanceStatus> validInstanceStatusList = new ArrayList<>();

        validInstanceStatusList.add(InstanceStatus.DRAFT);
        validInstanceStatusList.add(InstanceStatus.PROPOSED);
        validInstanceStatusList.add(InstanceStatus.APPROVED);
        validInstanceStatusList.add(InstanceStatus.ACTIVE);
        validInstanceStatusList.add(InstanceStatus.DELETED);

        entityDef.setValidInstanceStatusList(validInstanceStatusList);
        entityDef.setInitialStatus(InstanceStatus.DRAFT);

        return entityDef;
    }



    /**
     * The DataSet entity describes a collection of related data.
     *
     * @return DataSet EntityDef
     */
    private EntityDef getDataAssetEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DATA_ASSET,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName));
    }



    /**
     * The DataSet entity describes a collection of related data.
     *
     * @return DataSet EntityDef
     */
    private EntityDef getDataSetEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DATA_SET,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_ASSET.typeName));
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0015 Linked Media Types describe different media (like images and documents) that enhance the description
     * of an entity.  Media entities can be added to any Referenceable entities.
     */
    private void add0015LinkedMediaTypes()
    {
        this.archiveBuilder.addEnumDef(getMediaTypeEnum());
        this.archiveBuilder.addEnumDef(getMediaUsageEnum());

        this.archiveBuilder.addEntityDef(getExternalReferenceEntity());
        this.archiveBuilder.addEntityDef(getRelatedMediaEntity());

        this.archiveBuilder.addRelationshipDef(getExternalReferenceLinkRelationship());
        this.archiveBuilder.addRelationshipDef(getMediaReferenceRelationship());

    }


    private EnumDef getMediaTypeEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(MediaType.getOpenTypeGUID(),
                                                        MediaType.getOpenTypeName(),
                                                        MediaType.getOpenTypeDescription(),
                                                        MediaType.getOpenTypeDescriptionGUID(),
                                                        MediaType.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (MediaType enumValue : MediaType.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EnumDef getMediaUsageEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(MediaUsage.getOpenTypeGUID(),
                                                        MediaUsage.getOpenTypeName(),
                                                        MediaUsage.getOpenTypeDescription(),
                                                        MediaUsage.getOpenTypeDescriptionGUID(),
                                                        MediaUsage.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (MediaUsage enumValue : MediaUsage.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getExternalReferenceEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.EXTERNAL_REFERENCE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.URL));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ORGANIZATION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getRelatedMediaEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.RELATED_MEDIA,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.EXTERNAL_REFERENCE.typeName));
    }


    private RelationshipDef getExternalReferenceLinkRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.EXTERNAL_REFERENCE_LINK_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "relatedItem";
        final String                     end1AttributeDescription     = "Item that is referencing this work.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "externalReference";
        final String                     end2AttributeDescription     = "Link to more information from an external source.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.EXTERNAL_REFERENCE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.REFERENCE_ID));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getMediaReferenceRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.MEDIA_REFERENCE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "consumingItem";
        final String                     end1AttributeDescription     = "Item that is referencing this work.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "relatedMedia";
        final String                     end2AttributeDescription     = "Link to external media.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.RELATED_MEDIA.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MEDIA_ID));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0017 External Identifiers define identifiers used to identify this entity in other systems.
     */
    private void add0017ExternalIdentifiers()
    {
        this.archiveBuilder.addEnumDef(getKeyPatternEnum());

        this.archiveBuilder.addEntityDef(getExternalIdEntity());

        this.archiveBuilder.addRelationshipDef(getExternalIdScopeRelationship());
        this.archiveBuilder.addRelationshipDef(getExternalIdLinkRelationship());
    }


    private EnumDef getKeyPatternEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(KeyPattern.getOpenTypeGUID(),
                                                        KeyPattern.getOpenTypeName(),
                                                        KeyPattern.getOpenTypeDescription(),
                                                        KeyPattern.getOpenTypeDescriptionGUID(),
                                                        KeyPattern.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (KeyPattern enumValue : KeyPattern.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getExternalIdEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.EXTERNAL_ID,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IDENTIFIER));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.KEY_PATTERN));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getExternalIdScopeRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.EXTERNAL_ID_SCOPE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "scopedTo";
        final String                     end1AttributeDescription     = "Identifies where this external identifier is known.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "managedResources";
        final String                     end2AttributeDescription     = "Link to details of a resource that this component manages.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.EXTERNAL_ID.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getExternalIdLinkRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.EXTERNAL_ID_LINK_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "resources";
        final String                     end1AttributeDescription     = "Resource being identified.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "alsoKnownAs";
        final String                     end2AttributeDescription     = "Identifier used in an external system.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.EXTERNAL_ID.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.USAGE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0019 More information
     */
    private void add0019MoreInformation()
    {
        this.archiveBuilder.addRelationshipDef(getMoreInformationRelationship());
    }


    private RelationshipDef getMoreInformationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.MORE_INFORMATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "describes";
        final String                     end1AttributeDescription     = "Describes this core element.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "providesMoreInformation";
        final String                     end2AttributeDescription     = "Provides more information about this referenceable.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0020 Property Facets define blocks of properties that are unique to a particular vendor or service.
     */
    private void add0020PropertyFacets()
    {
        this.archiveBuilder.addEntityDef(getPropertyFacetEntity());

        this.archiveBuilder.addRelationshipDef(getReferenceableFacetRelationship());
    }


    private EntityDef getPropertyFacetEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.PROPERTY_FACET,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROPERTIES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getReferenceableFacetRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.REFERENCEABLE_FACET,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "relatedEntity";
        final String                     end1AttributeDescription     = "Identifies which element this property facet belongs to.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "facets";
        final String                     end2AttributeDescription     = "Additional properties from different sources.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROPERTY_FACET.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0025 Locations define entities that describe physical, logical and cyber locations for Assets.
     */
    private void add0025Locations()
    {
        this.archiveBuilder.addEntityDef(getLocationEntity());

        this.archiveBuilder.addRelationshipDef(getNestedLocationRelationship());
        this.archiveBuilder.addRelationshipDef(getAdjacentLocationRelationship());
        this.archiveBuilder.addRelationshipDef(getAssetLocationRelationship());

        this.archiveBuilder.addClassificationDef(getMobileAssetClassification());
        this.archiveBuilder.addClassificationDef(getFixedLocationClassification());
        this.archiveBuilder.addClassificationDef(getSecureLocationClassification());
        this.archiveBuilder.addClassificationDef(getCyberLocationClassification());
    }


    private EntityDef getLocationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.LOCATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private RelationshipDef getNestedLocationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.NESTED_LOCATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "groupingLocations";
        final String                     end1AttributeDescription     = "Location that is covering the broader area.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.LOCATION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "nestedLocations";
        final String                     end2AttributeDescription     = "Location that is nested in this location.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.LOCATION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private RelationshipDef getAdjacentLocationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ADJACENT_LOCATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "peerLocations";
        final String                     end1AttributeDescription     = "Location that is adjacent to this location.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.LOCATION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "peerLocations";
        final String                     end2AttributeDescription     = "Location that is adjacent to this location.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.LOCATION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private RelationshipDef getAssetLocationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ASSET_LOCATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "localAssets";
        final String                     end1AttributeDescription     = "Assets sited at this location.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "knownLocations";
        final String                     end2AttributeDescription     = "Places where this asset is sited.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.LOCATION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private ClassificationDef getMobileAssetClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.MOBILE_ASSET_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName),
                                                  false);
    }

    private ClassificationDef getFixedLocationClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.FIXED_LOCATION_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.LOCATION.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.COORDINATES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TIME_ZONE));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }

    private ClassificationDef getSecureLocationClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.SECURE_LOCATION_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.LOCATION.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.LEVEL));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }

    private ClassificationDef getCyberLocationClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.CYBER_LOCATION_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.LOCATION.typeName),
                                                  false);
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0030 Hosts and Platforms describe the Software and Hardware platforms hosting Assets.
     */
    private void add0030HostsAndPlatforms()
    {
        this.archiveBuilder.addEnumDef(getEndiannessEnum());

        this.archiveBuilder.addEntityDef(getITInfrastructureEntity());
        this.archiveBuilder.addEntityDef(getHostEntity());
        this.archiveBuilder.addEntityDef(getOperatingPlatformEntity());
    }

    private EnumDef getEndiannessEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(ByteOrdering.getOpenTypeGUID(),
                                                        ByteOrdering.getOpenTypeName(),
                                                        ByteOrdering.getOpenTypeDescription(),
                                                        ByteOrdering.getOpenTypeDescriptionGUID(),
                                                        ByteOrdering.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (ByteOrdering byteOrdering : ByteOrdering.values())
        {
            elementDef = archiveHelper.getEnumElementDef(byteOrdering.getOrdinal(),
                                                         byteOrdering.getName(),
                                                         byteOrdering.getDescription(),
                                                         byteOrdering.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (byteOrdering.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private EntityDef getITInfrastructureEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.IT_INFRASTRUCTURE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.INFRASTRUCTURE.typeName));
    }

    private EntityDef getHostEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.HOST,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.IT_INFRASTRUCTURE.typeName));
    }

    private EntityDef getOperatingPlatformEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.OPERATING_PLATFORM,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.OPERATING_SYSTEM));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0035 Complex Hosts describe virtualization and clustering options for Hosts.
     */
    private void add0035ComplexHosts()
    {
        this.archiveBuilder.addEntityDef(getHostClusterEntity());
        this.archiveBuilder.addEntityDef(getVirtualContainerEntity());

        this.archiveBuilder.addRelationshipDef(getHostClusterMemberRelationship());
    }

    private EntityDef getHostClusterEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.HOST_CLUSTER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.HOST.typeName));
    }

    private EntityDef getVirtualContainerEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.VIRTUAL_CONTAINER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.HOST.typeName));
    }

    private RelationshipDef getHostClusterMemberRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.HOST_CLUSTER_MEMBER_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "hostCluster";
        final String                     end1AttributeDescription     = "Cluster managing this host.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.HOST_CLUSTER.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "managedHosts";
        final String                     end2AttributeDescription     = "Member of the host cluster.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.HOST.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0037 Software Server Platforms describe the structure of a software server platform.
     */
    private void add0037SoftwareServerPlatforms()
    {
        this.archiveBuilder.addEnumDef(getOperationalStatusEnum());

        this.archiveBuilder.addEntityDef(getSoftwareServerPlatformEntity());
    }

    private EnumDef getOperationalStatusEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(OperationalStatus.getOpenTypeGUID(),
                                                        OperationalStatus.getOpenTypeName(),
                                                        OperationalStatus.getOpenTypeDescription(),
                                                        OperationalStatus.getOpenTypeDescriptionGUID());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (OperationalStatus enumValue : OperationalStatus.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private EntityDef getSoftwareServerPlatformEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.SOFTWARE_SERVER_PLATFORM,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.IT_INFRASTRUCTURE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.USER_ID));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }



    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0040 Software Servers describe the structure of a software server and its capabilities.
     */
    private void add0040SoftwareServers()
    {
        this.archiveBuilder.addEntityDef(getSoftwareServerEntity());
        this.archiveBuilder.addEntityDef(getEndpointEntity());

        this.archiveBuilder.addRelationshipDef(getServerEndpointRelationship());
    }

    private EntityDef getSoftwareServerEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.SOFTWARE_SERVER,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.IT_INFRASTRUCTURE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.USER_ID));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getEndpointEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.ENDPOINT,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NETWORK_ADDRESS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROTOCOL));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ENCRYPTION_METHOD));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private RelationshipDef getServerEndpointRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.SERVER_ENDPOINT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "servers";
        final String                     end1AttributeDescription     = "Server supporting this endpoint.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "endpoints";
        final String                     end2AttributeDescription     = "Endpoints supported by this server.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ENDPOINT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0042 Software Server Capabilities describe the deployed capabilities on a software server.
     */
    private void add0042SoftwareServerCapabilities()
    {
        this.archiveBuilder.addEntityDef(getSoftwareServerCapabilityEntity());
    }

    private EntityDef getSoftwareServerCapabilityEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.SOFTWARE_SERVER_CAPABILITY,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0045 Servers and Assets defines the relationships between SoftwareServers and Assets.
     */
    private void add0045ServersAndAssets()
    {
        this.archiveBuilder.addEnumDef(getServerAssetUseTypeEnum());
    }


    private EnumDef getServerAssetUseTypeEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(ServerAssetUseType.getOpenTypeGUID(),
                                                        ServerAssetUseType.getOpenTypeName(),
                                                        ServerAssetUseType.getOpenTypeDescription(),
                                                        ServerAssetUseType.getOpenTypeDescriptionGUID());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (ServerAssetUseType enumValue : ServerAssetUseType.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0050ApplicationsAndProcesses()
    {
        this.archiveBuilder.addEntityDef(getApplicationEntity());

        this.archiveBuilder.addClassificationDef(getApplicationServerClassification());
        this.archiveBuilder.addClassificationDef(getWebserverClassification());
    }

    private EntityDef getApplicationEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.APPLICATION,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER_CAPABILITY.typeName));
    }

    private ClassificationDef getApplicationServerClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.APPLICATION_SERVER_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER.typeName),
                                                  false);
    }

    private ClassificationDef getWebserverClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.WEBSERVER_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER.typeName),
                                                  false);
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0055DataProcessingEngines()
    {
        this.archiveBuilder.addEntityDef(getEngineEntity());

        this.archiveBuilder.addClassificationDef(getWorkflowEngineClassification());
        this.archiveBuilder.addClassificationDef(getReportingEngineClassification());
        this.archiveBuilder.addClassificationDef(getAnalyticsEngineClassification());
        this.archiveBuilder.addClassificationDef(getDataMovementEngineClassification());
        this.archiveBuilder.addClassificationDef(getDataVirtualizationEngineClassification());
    }

    private EntityDef getEngineEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.ENGINE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER_CAPABILITY.typeName));
    }

    private ClassificationDef getWorkflowEngineClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.WORKFLOW_ENGINE_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.ENGINE.typeName),
                                                  false);
    }

    private ClassificationDef getReportingEngineClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.REPORTING_ENGINE_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.ENGINE.typeName),
                                                  false);
    }

    private ClassificationDef getAnalyticsEngineClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.ANALYTICS_ENGINE,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.ENGINE.typeName),
                                                  false);
    }

    private ClassificationDef getDataMovementEngineClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.DATA_MOVEMENT_ENGINE,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.ENGINE.typeName),
                                                  false);
    }

    private ClassificationDef getDataVirtualizationEngineClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.DATA_VIRTUALIZATION_ENGINE,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.ENGINE.typeName),
                                                  false);
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0070 Networks and Gateways provide a very simple network model.
     */
    private void add0070NetworksAndGateways()
    {
        this.archiveBuilder.addEntityDef(getNetworkEntity());
        this.archiveBuilder.addEntityDef(getNetworkGatewayEntity());

        this.archiveBuilder.addRelationshipDef(getNetworkGatewayLinkRelationship());
    }

    private EntityDef getNetworkEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.NETWORK,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.IT_INFRASTRUCTURE.typeName));
    }


    private EntityDef getNetworkGatewayEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.NETWORK_GATEWAY,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER_CAPABILITY.typeName));
    }

    private RelationshipDef getNetworkGatewayLinkRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.NETWORK_GATEWAY_LINK_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "gateways";
        final String                     end1AttributeDescription     = "Gateways to other networks.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.NETWORK_GATEWAY.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "networkConnections";
        final String                     end2AttributeDescription     = "Connections to different networks.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.NETWORK.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0090 Cloud Platforms and Services provides classifications for infrastructure to allow cloud platforms
     * and services to be identified.
     */
    private void add0090CloudPlatformsAndServices()
    {
        this.archiveBuilder.addClassificationDef(getCloudProviderClassification());
        this.archiveBuilder.addClassificationDef(getCloudPlatformClassification());
        this.archiveBuilder.addClassificationDef(getCloudTenantClassification());
        this.archiveBuilder.addClassificationDef(getCloudServiceClassification());
    }


    private ClassificationDef getCloudProviderClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.CLOUD_PROVIDER_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.HOST.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROVIDER_NAME));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private ClassificationDef getCloudPlatformClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.CLOUD_PLATFORM_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER_PLATFORM.typeName),
                                                  false);
    }


    private ClassificationDef getCloudTenantClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.CLOUD_TENANT_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TENANT_NAME));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private ClassificationDef getCloudServiceClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.CLOUD_SERVICE_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER_CAPABILITY.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.OFFERING_NAME));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }

    /*
     * ========================================
     * AREA 1: collaboration
     */

    private void addArea1Types()
    {
        this.add0110Actors();
        this.add0112People();
        this.add0115Teams();
        this.add0117EngineProfiles();
        this.add0120Collections();
        this.add0130Projects();
        this.add0135Meetings();
        this.add0137Actions();
        this.add0140Communities();
        this.add0150Feedback();
        this.add0155CrowdSourcing();
        this.add0160Notes();
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0110 Actors describe the people and their relationships who are using the Assets.
     */
    private void add0110Actors()
    {
        this.archiveBuilder.addEnumDef(getContactMethodTypeEnum());

        this.archiveBuilder.addEntityDef(getActorProfileEntity());
        this.archiveBuilder.addEntityDef(getUserIdentityEntity());
        this.archiveBuilder.addEntityDef(getContactDetailsEntity());

        this.archiveBuilder.addRelationshipDef(getContactThroughRelationship());
        this.archiveBuilder.addRelationshipDef(getProfileIdentityRelationship());
    }

    private EnumDef getContactMethodTypeEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(ContactMethodType.getOpenTypeGUID(),
                                                        ContactMethodType.getOpenTypeName(),
                                                        ContactMethodType.getOpenTypeDescription(),
                                                        ContactMethodType.getOpenTypeDescriptionGUID(),
                                                        ContactMethodType.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (ContactMethodType enumValues : ContactMethodType.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private EntityDef getActorProfileEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.ACTOR_PROFILE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getUserIdentityEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.USER_IDENTITY,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));
    }

    private EntityDef getContactDetailsEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.CONTACT_DETAILS,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.CONTACT_METHOD_TYPE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONTACT_METHOD_VALUE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONTACT_METHOD_SERVICE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private RelationshipDef getContactThroughRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.CONTACT_THROUGH_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "contactDetails";
        final String                     end1AttributeDescription     = "Contact details owner.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ACTOR_PROFILE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "contacts";
        final String                     end2AttributeDescription     = "Contact information.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CONTACT_DETAILS.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private RelationshipDef getProfileIdentityRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PROFILE_IDENTITY_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "profile";
        final String                     end1AttributeDescription     = "Description of the person, organization or engine that uses this user identity.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ACTOR_PROFILE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "userIdentities";
        final String                     end2AttributeDescription     = "Authentication identifiers in use by the owner of this profile.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.USER_IDENTITY.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0112 People describe the people, their roles and their peer network.
     */
    private void add0112People()
    {
        this.archiveBuilder.addEntityDef(getPersonEntity());
        this.archiveBuilder.addEntityDef(getContributionRecordEntity());
        this.archiveBuilder.addEntityDef(getPersonRoleEntity());

        this.archiveBuilder.addRelationshipDef(getPersonRoleAppointmentRelationship());
        this.archiveBuilder.addRelationshipDef(getPeerRelationship());
    }

    private EntityDef getPersonEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.PERSON,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.ACTOR_PROFILE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.FULL_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.JOB_TITLE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getContributionRecordEntity()
    {
       EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.CONTRIBUTION_RECORD,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.KARMA_POINTS));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getPersonRoleEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.PERSON_ROLE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));
    }

    private RelationshipDef getPersonRoleAppointmentRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PERSON_ROLE_APPOINTMENT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 2.
         */
        final String                     end1AttributeName            = "rolePerformers";
        final String                     end1AttributeDescription     = "The people performing this role.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);


        /*
         * Set up end 1.
         */
        final String                     end2AttributeName            = "performsRoles";
        final String                     end2AttributeDescription     = "Roles performed by this person.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON_ROLE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }

    private RelationshipDef getPeerRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PEER_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "peers";
        final String                     end1AttributeDescription     = "List of this person's peer network.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "peers";
        final String                     end2AttributeDescription     = "List of this person's peer network.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0115 Teams describe the organization of people.
     */
    private void add0115Teams()
    {
        this.archiveBuilder.addEntityDef(getTeamEntity());
        this.archiveBuilder.addEntityDef(getTeamLeaderEntity());
        this.archiveBuilder.addEntityDef(getTeamMemberEntity());

        this.archiveBuilder.addRelationshipDef(getTeamLeadershipRelationship());
        this.archiveBuilder.addRelationshipDef(getTeamMembershipRelationship());
        this.archiveBuilder.addRelationshipDef(getTeamStructureRelationship());
    }

    private EntityDef getTeamEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.TEAM,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.ACTOR_PROFILE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TEAM_TYPE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getTeamLeaderEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.TEAM_LEADER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON_ROLE.typeName));
    }

    private EntityDef getTeamMemberEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.TEAM_MEMBER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON_ROLE.typeName));
    }

    private RelationshipDef getTeamStructureRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.TEAM_STRUCTURE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "superTeam";
        final String                     end1AttributeDescription     = "The aggregating team.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TEAM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "subTeam";
        final String                     end2AttributeDescription     = "The teams where work is delegated to.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TEAM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DELEGATION_ESCALATION));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }

    private RelationshipDef getTeamLeadershipRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.TEAM_LEADERSHIP_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "teamLeaders";
        final String                     end1AttributeDescription     = "The leaders of the team.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TEAM_LEADER.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "leadsTeam";
        final String                     end2AttributeDescription     = "The team lead by this team leader.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TEAM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ROLE_POSITION));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }

    private RelationshipDef getTeamMembershipRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.TEAM_MEMBERSHIP_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "teamMembers";
        final String                     end1AttributeDescription     = "The members of the team.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TEAM_MEMBER.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "memberOfTeam";
        final String                     end2AttributeDescription     = "The team that this person is a member of.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TEAM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ROLE_POSITION));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0117 IT profiles defines a special actor profile for an engine
     */
    private void add0117EngineProfiles()
    {
        this.archiveBuilder.addEntityDef(getITProfileEntity());
    }

    private EntityDef getITProfileEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.IT_PROFILE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.ACTOR_PROFILE.typeName));
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0120 Collections defines how to group related Referenceables together
     */
    private void add0120Collections()
    {
        this.archiveBuilder.addEnumDef(getOrderByEnum());

        this.archiveBuilder.addEntityDef(getCollectionEntity());

        this.archiveBuilder.addRelationshipDef(getCollectionMembershipRelationship());
        this.archiveBuilder.addRelationshipDef(getResourceListRelationship());

        this.archiveBuilder.addClassificationDef(getFolderClassification());
        this.archiveBuilder.addClassificationDef(getSetClassification());
    }


    private EnumDef getOrderByEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(OrderBy.getOpenTypeGUID(),
                                                        OrderBy.getOpenTypeName(),
                                                        OrderBy.getOpenTypeDescription(),
                                                        OrderBy.getOpenTypeDescriptionGUID());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (OrderBy orderBy : OrderBy.values())
        {
            elementDef = archiveHelper.getEnumElementDef(orderBy.getOrdinal(),
                                                         orderBy.getName(),
                                                         orderBy.getDescription(),
                                                         orderBy.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (orderBy.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getCollectionEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.COLLECTION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getCollectionMembershipRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.COLLECTION_MEMBERSHIP_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "foundInCollections";
        final String                     end1AttributeDescription     = "Collections that link to this element.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.COLLECTION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "collectionMembers";
        final String                     end2AttributeDescription     = "Members of this collection.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MEMBERSHIP_RATIONALE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getResourceListRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.RESOURCE_LIST_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "resourceListAnchors";
        final String                     end1AttributeDescription     = "Referenceable objects that are using the linked to resource.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "supportingResources";
        final String                     end2AttributeDescription     = "Resources identified as of interest to the anchor.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RESOURCE_USE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RESOURCE_USE_DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RESOURCE_USE_PROPERTIES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.WATCH_RESOURCE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private ClassificationDef getFolderClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.FOLDER,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.COLLECTION.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.COLLECTION_ORDER));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ORDER_BY_PROPERTY_NAME));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }

    private ClassificationDef getSetClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.RESULTS_SET,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.COLLECTION.typeName),
                                                  false);
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0130 Projects describes the structure of a project and related collections.
     */
    private void add0130Projects()
    {
        this.archiveBuilder.addEntityDef(getProjectEntity());
        this.archiveBuilder.addEntityDef(getProjectManagerEntity());

        this.archiveBuilder.addRelationshipDef(getProjectHierarchyRelationship());
        this.archiveBuilder.addRelationshipDef(getProjectDependencyRelationship());
        this.archiveBuilder.addRelationshipDef(getProjectTeamRelationship());
        this.archiveBuilder.addRelationshipDef(getProjectManagementRelationship());

        this.archiveBuilder.addClassificationDef(getTaskClassification());
        this.archiveBuilder.addClassificationDef(getCampaignClassification());
    }


    private EntityDef getProjectEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.PROJECT,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.START_DATE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PLANNED_END_DATE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getProjectManagerEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.PROJECT_MANAGER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON_ROLE.typeName));
    }


    private RelationshipDef getProjectHierarchyRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PROJECT_HIERARCHY_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "managingProject";
        final String                     end1AttributeDescription     = "Project that oversees this project.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "managedProject";
        final String                     end2AttributeDescription     = "Project that this project is responsible for managing.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getProjectDependencyRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PROJECT_DEPENDENCY_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "dependentProject";
        final String                     end1AttributeDescription     = "Projects that are dependent on this project.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "dependsOnProjects";
        final String                     end2AttributeDescription     = "Projects that are delivering resources or outcomes needed by this project.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DEPENDENCY_SUMMARY));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getProjectTeamRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PROJECT_TEAM_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "projectFocus";
        final String                     end1AttributeDescription     = "Projects that a team is working on.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "supportingActors";
        final String                     end2AttributeDescription     = "People and teams supporting this project.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ACTOR_PROFILE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TEAM_ROLE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /**
     * Add Task classification
     *
     * @return classification def
     */
    private ClassificationDef getTaskClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.TASK_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT.typeName),
                                                  false);
    }


    private RelationshipDef getProjectManagementRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PROJECT_MANAGEMENT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "projectsManaged";
        final String                     end1AttributeDescription     = "The projects that are being managed by this project manager.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "projectManagers";
        final String                     end2AttributeDescription     = "The roles for managing this project.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT_MANAGER.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private ClassificationDef getCampaignClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.CAMPAIGN_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.COLLECTION.typeName),
                                                  false);
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0135 Meetings defines how to record meetings and todos.
     */
    private void add0135Meetings()
    {
        this.archiveBuilder.addEntityDef(getMeetingEntity());

        this.archiveBuilder.addRelationshipDef(getMeetingsRelationship());
    }


    private EntityDef getMeetingEntity()
    {
       EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.MEETING,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TITLE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.START_TIME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.END_TIME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.OBJECTIVE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MINUTES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private RelationshipDef getMeetingsRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.MEETINGS,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 2.
         */
        final String                     end1AttributeName            = "meetings";
        final String                     end1AttributeDescription     = "Related meetings.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.MEETING.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);


        /*
         * Set up end 1.
         */
        final String                     end2AttributeName            = "meetingOwner";
        final String                     end2AttributeDescription     = "Person, project, community or team that called the meeting.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);

        return relationshipDef;
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0137 - Actions for People
     */
    private void add0137Actions()
    {
        this.archiveBuilder.addEnumDef(getToDoStatusEnum());

        this.archiveBuilder.addEntityDef(getToDoEntity());

        this.archiveBuilder.addRelationshipDef(getToDoSourceRelationship());
        this.archiveBuilder.addRelationshipDef(getActionSponsorRelationship());
        this.archiveBuilder.addRelationshipDef(getActionAssignment());
    }


    private EnumDef getToDoStatusEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(ToDoStatus.getOpenTypeGUID(),
                                                        ToDoStatus.getOpenTypeName(),
                                                        ToDoStatus.getOpenTypeDescription(),
                                                        ToDoStatus.getOpenTypeDescriptionGUID(),
                                                        ToDoStatus.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (ToDoStatus toDoStatus : ToDoStatus.values())
        {
            elementDef = archiveHelper.getEnumElementDef(toDoStatus.getOrdinal(),
                                                         toDoStatus.getName(),
                                                         toDoStatus.getDescription(),
                                                         toDoStatus.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (toDoStatus.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getToDoEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.TO_DO,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CREATION_TIME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PRIORITY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DUE_TIME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.COMPLETION_TIME));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TO_DO_STATUS));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getToDoSourceRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.TO_DO_SOURCE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "actionSource";
        final String                     end1AttributeDescription     = "Source of the to do request.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "actions";
        final String                     end2AttributeDescription     = "Requests to perform actions related to this element.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TO_DO.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getActionSponsorRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ACTION_SPONSOR_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "toDoSponsor";
        final String                     end1AttributeDescription     = "Element such as person, team, rule, incident, project, that is driving the need for the action.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "trackedActions";
        final String                     end2AttributeDescription     = "Actions that need to be completed.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TO_DO.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private RelationshipDef getActionAssignment()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ACTION_ASSIGNMENT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "assignedResources";
        final String                     end1AttributeDescription     = "One or more people assigned to complete the action (to do).";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON_ROLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "toDoList";
        final String                     end2AttributeDescription     = "List of toDos assigned to this person's role.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TO_DO.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0140 Communities describe communities of people who have similar interests.
     */
    private void add0140Communities()
    {
        this.archiveBuilder.addEnumDef(getCommunityMembershipTypeEnum());

        this.archiveBuilder.addEntityDef(getCommunityEntity());
        this.archiveBuilder.addEntityDef(getCommunityMemberEntity());

        this.archiveBuilder.addRelationshipDef(getCommunityMembershipRelationship());
    }

    private EnumDef getCommunityMembershipTypeEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(CommunityMembershipType.getOpenTypeGUID(),
                                                        CommunityMembershipType.getOpenTypeName(),
                                                        CommunityMembershipType.getOpenTypeDescription(),
                                                        CommunityMembershipType.getOpenTypeDescriptionGUID());
        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (GovernanceDomain enumValue : GovernanceDomain.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private EntityDef getCommunityEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.COMMUNITY,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MISSION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getCommunityMemberEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.COMMUNITY_MEMBER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON_ROLE.typeName));
    }

    private RelationshipDef getCommunityMembershipRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.COMMUNITY_MEMBERSHIP_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "memberOfCommunity";
        final String                     end1AttributeDescription     = "Communities that the person is a member of.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.COMMUNITY.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "communityMembers";
        final String                     end2AttributeDescription     = "Members of the community.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.COMMUNITY_MEMBER.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.MEMBERSHIP_TYPE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0150 Feedback provides all of the collaborative feedback and attachments that can be made by the user
     * community of the Assets.
     */
    private void add0150Feedback()
    {
        this.archiveBuilder.addEnumDef(getStarRatingEnum());
        this.archiveBuilder.addEnumDef(getCommentTypeEnum());

        this.archiveBuilder.addEntityDef(getRatingEntity());
        this.archiveBuilder.addEntityDef(getCommentEntity());
        this.archiveBuilder.addEntityDef(getLikeEntity());
        this.archiveBuilder.addEntityDef(getInformalTagEntity());

        this.archiveBuilder.addRelationshipDef(getAttachedRatingRelationship());
        this.archiveBuilder.addRelationshipDef(getAttachedCommentRelationship());
        this.archiveBuilder.addRelationshipDef(getAttachedLikeRelationship());
        this.archiveBuilder.addRelationshipDef(getAcceptedAnswerRelationship());
        this.archiveBuilder.addRelationshipDef(getAttachedTagRelationship());
    }


    private EnumDef getStarRatingEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(StarRating.getOpenTypeGUID(),
                                                        StarRating.getOpenTypeName(),
                                                        StarRating.getOpenTypeDescription(),
                                                        StarRating.getOpenTypeDescriptionGUID(),
                                                        StarRating.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (StarRating enumValue : StarRating.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EnumDef getCommentTypeEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(CommentType.getOpenTypeGUID(),
                                                        CommentType.getOpenTypeName(),
                                                        CommentType.getOpenTypeDescription(),
                                                        CommentType.getOpenTypeDescriptionGUID(),
                                                        CommentType.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (CommentType commentType : CommentType.values())
        {
            elementDef = archiveHelper.getEnumElementDef(commentType.getOrdinal(),
                                                         commentType.getName(),
                                                         commentType.getDescription(),
                                                         commentType.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (commentType.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private EntityDef getRatingEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.RATING, null);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.STARS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.REVIEW));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getCommentEntity()
    {
         EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.COMMENT,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TEXT));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TYPE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getLikeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.LIKE, null);
    }


    private EntityDef getInformalTagEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.INFORMAL_TAG, null);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TAG_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TAG_DESCRIPTION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getAttachedRatingRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ATTACHED_RATING_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "ratingAnchor";
        final String                     end1AttributeDescription     = "Element that is rated.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "starRatings";
        final String                     end2AttributeDescription     = "Accumulated ratings.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.RATING.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getAttachedCommentRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ATTACHED_COMMENT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "commentAnchor";
        final String                     end1AttributeDescription     = "Element that this comment relates.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "comments";
        final String                     end2AttributeDescription     = "Accumulated comments.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.COMMENT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getAttachedLikeRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ATTACHED_LIKE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "likeAnchor";
        final String                     end1AttributeDescription     = "Element that is liked.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "likes";
        final String                     end2AttributeDescription     = "Accumulated likes.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.LIKE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getAcceptedAnswerRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ACCEPTED_ANSWER_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "answeredQuestions";
        final String                     end1AttributeDescription     = "Questions that now has an accepted answer.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.COMMENT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "acceptedAnswers";
        final String                     end2AttributeDescription     = "Accumulated answers.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.COMMENT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getAttachedTagRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ATTACHED_TAG_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "taggedElement";
        final String                     end1AttributeDescription     = "Element that is tagged.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "tags";
        final String                     end2AttributeDescription     = "Accumulated tags.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.INFORMAL_TAG.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0155 Crowd Sourcing describes the people involved in crowd sourcing new metadata content.
     */
    private void add0155CrowdSourcing()
    {
        this.archiveBuilder.addEnumDef(getCrowdSourcingRoleEnum());
        this.archiveBuilder.addEntityDef(getCrowdSourcingContributorEntity());
        this.archiveBuilder.addRelationshipDef(getCrowdSourcingContributionRelationship());
    }


    private EnumDef getCrowdSourcingRoleEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(CrowdSourcingRole.getOpenTypeGUID(),
                                                        CrowdSourcingRole.getOpenTypeName(),
                                                        CrowdSourcingRole.getOpenTypeDescription(),
                                                        CrowdSourcingRole.getOpenTypeDescriptionGUID());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (KeyPattern enumValue : KeyPattern.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private EntityDef getCrowdSourcingContributorEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.CROWD_SOURCING_CONTRIBUTOR,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON_ROLE.typeName));
    }

    private RelationshipDef getCrowdSourcingContributionRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.CROWD_SOURCING_CONTRIBUTION,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "contributions";
        final String                     end1AttributeDescription     = "Items that this person has contributed.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "contributors";
        final String                     end2AttributeDescription     = "Person contributing content.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CROWD_SOURCING_CONTRIBUTOR.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.ROLE_TYPE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0160 Notes describes note logs and notes within them.  Notes are kept by the owners/stewards working on the
     * Assets.
     */
    private void add0160Notes()
    {
        this.archiveBuilder.addEntityDef(getNoteEntryEntity());
        this.archiveBuilder.addEntityDef(getNoteLogEntity());
        this.archiveBuilder.addEntityDef(getNoteLogAuthorEntity());

        this.archiveBuilder.addRelationshipDef(getAttachedNoteLogRelationship());
        this.archiveBuilder.addRelationshipDef(getAttachedNoteLogEntryRelationship());
        this.archiveBuilder.addRelationshipDef(getNoteLogAuthorshipRelationship());
    }

    private EntityDef getNoteEntryEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.NOTE_ENTRY,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TITLE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TEXT));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getNoteLogAuthorEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.NOTE_LOG_AUTHOR,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON_ROLE.typeName));
    }

    private EntityDef getNoteLogEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.NOTE_LOG,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private RelationshipDef getAttachedNoteLogRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ATTACHED_NOTE_LOG_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "describes";
        final String                     end1AttributeDescription     = "Subject of the note log.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "noteLogs";
        final String                     end2AttributeDescription     = "Log of related notes.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.NOTE_LOG.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IS_PUBLIC));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }

    private RelationshipDef getNoteLogAuthorshipRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.NOTE_LOG_AUTHORSHIP_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "authors";
        final String                     end1AttributeDescription     = "Person contributing to the note log.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.NOTE_LOG_AUTHOR.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "authoredNoteLogs";
        final String                     end2AttributeDescription     = "Note log containing contributions.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.NOTE_LOG.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private RelationshipDef getAttachedNoteLogEntryRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ATTACHED_NOTE_LOG_ENTRY_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "logs";
        final String                     end1AttributeDescription     = "Logs that this entry relates.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.NOTE_LOG.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "entries";
        final String                     end2AttributeDescription     = "Accumulated notes.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.NOTE_ENTRY.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * ========================================
     * AREA 2: connectors and assets
     */

    /**
     * Area 2 covers the different types of Assets and the Connection information used by the Open Connector Framework
     * (OCF).
     */
    private void addArea2Types()
    {
        this.add0201ConnectorsAndConnections();
        this.add0205ConnectionLinkage();
        this.add0210DataStores();
        this.add0212DeployedAPIs();
        this.add0215SoftwareComponents();
        this.add0220FilesAndFolders();
        this.add0221DocumentStores();
        this.add0222GraphStores();
        this.add0223EventsAndLogs();
        this.add0224Databases();
        this.add0225MetadataRepositories();
        this.add0227Keystores();
        this.add0230CodeTables();
        this.add0235InformationView();
        this.add0239Reports();
        this.add0290Ports();
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0201 Connectors and Connections defines the details of the Connection that describes the connector type
     * and endpoint for a specific connector instance.
     */
    private void add0201ConnectorsAndConnections()
    {
        this.archiveBuilder.addEntityDef(getConnectionEntity());
        this.archiveBuilder.addEntityDef(getConnectorTypeEntity());

        this.archiveBuilder.addRelationshipDef(getConnectionEndpointRelationship());
        this.archiveBuilder.addRelationshipDef(getConnectionConnectorTypeRelationship());
    }

    private EntityDef getConnectionEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.CONNECTION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SECURED_PROPERTIES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIGURATION_PROPERTIES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.USER_ID));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CLEAR_PASSWORD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ENCRYPTED_PASSWORD));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getConnectorTypeEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.CONNECTOR_TYPE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONNECTOR_PROVIDER_CLASS_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RECOGNIZED_ADDITIONAL_PROPERTIES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RECOGNIZED_SECURED_PROPERTIES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RECOGNIZED_CONFIGURATION_PROPERTIES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private RelationshipDef getConnectionEndpointRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.CONNECTION_ENDPOINT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "connectionEndpoint";
        final String                     end1AttributeDescription     = "Server endpoint that provides access to the asset.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ENDPOINT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "connections";
        final String                     end2AttributeDescription     = "Connections to this endpoint.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CONNECTION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private RelationshipDef getConnectionConnectorTypeRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.CONNECTION_CONNECTOR_TYPE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "connections";
        final String                     end1AttributeDescription     = "Connections using this connector type.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CONNECTION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "connectorType";
        final String                     end2AttributeDescription     = "Type of connector to use for the asset.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CONNECTOR_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0205 Connection Links defines the relationship between the connection and an Asset, plus the nesting
     * of connections for information virtualization support.
     */
    private void add0205ConnectionLinkage()
    {
        this.archiveBuilder.addEntityDef(getVirtualConnectionEntity());

        this.archiveBuilder.addRelationshipDef(getEmbeddedConnectionRelationship());
        this.archiveBuilder.addRelationshipDef(getConnectionToAssetRelationship());
    }

    private EntityDef getVirtualConnectionEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.VIRTUAL_CONNECTION,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.CONNECTION.typeName));
    }

    private RelationshipDef getEmbeddedConnectionRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.EMBEDDED_CONNECTION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "supportingVirtualConnections";
        final String                     end1AttributeDescription     = "Virtual connections using this connection.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.VIRTUAL_CONNECTION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "embeddedConnections";
        final String                     end2AttributeDescription     = "Connections embedded in this virtual connection.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CONNECTION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ARGUMENTS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }

    private RelationshipDef getConnectionToAssetRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.CONNECTION_TO_ASSET_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "connections";
        final String                     end1AttributeDescription     = "Connections to this asset.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CONNECTION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "asset";
        final String                     end2AttributeDescription     = "Asset that can be accessed with this connection.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ASSET_SUMMARY));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0210 DataStores describe physical data store assets.
     */
    private void add0210DataStores()
    {
        this.archiveBuilder.addEntityDef(getDataStoreEntity());

        this.archiveBuilder.addRelationshipDef(getDataSetContentRelationship());
    }

    private EntityDef getDataStoreEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.DATA_STORE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_ASSET.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STORE_CREATE_TIME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STORE_UPDATE_TIME));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private RelationshipDef getDataSetContentRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.DATA_SET_CONTENT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end2AttributeName            = "supportedDataSets";
        final String                     end2AttributeDescription     = "Data sets that use this asset.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end1AttributeName            = "dataContent";
        final String                     end1AttributeDescription     = "Assets supporting a data set.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);



        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0212 Deployed APIs defines an API that has been deployed to IT Infrastructure
     */
    private void add0212DeployedAPIs()
    {
        this.archiveBuilder.addEntityDef(getDeployedAPIEntity());

        this.archiveBuilder.addRelationshipDef(getAPIEndpointRelationship());

        this.archiveBuilder.addClassificationDef(getRequestResponseInterfaceClassification());
        this.archiveBuilder.addClassificationDef(getListenerInterfaceClassification());
        this.archiveBuilder.addClassificationDef(getPublisherInterfaceClassification());
    }

    private EntityDef getDeployedAPIEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DEPLOYED_API,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName));
    }

    private RelationshipDef getAPIEndpointRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.API_ENDPOINT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "supportedAPIs";
        final String                     end1AttributeDescription     = "APIs that can be called from this endpoint.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DEPLOYED_API.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "accessEndpoints";
        final String                     end2AttributeDescription     = "Endpoints used to call this API.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ENDPOINT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private ClassificationDef getRequestResponseInterfaceClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.REQUEST_RESPONSE_INTERFACE_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.DEPLOYED_API.typeName),
                                                  false);
    }

    private ClassificationDef getListenerInterfaceClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.LISTENER_INTERFACE_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.DEPLOYED_API.typeName),
                                                  false);
    }

    private ClassificationDef getPublisherInterfaceClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.PUBLISHER_INTERFACE_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.DEPLOYED_API.typeName),
                                                  false);
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0215 Software Components defines a generic Asset for a software component.
     */
    private void add0215SoftwareComponents()
    {
        this.archiveBuilder.addEntityDef(getDeployedSoftwareComponentEntity());
    }


    private EntityDef getDeployedSoftwareComponentEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.DEPLOYED_SOFTWARE_COMPONENT,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.PROCESS.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IMPLEMENTATION_LANGUAGE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0220 Files and Folders provides the definitions for describing filesystems and their content
     */
    private void add0220FilesAndFolders()
    {
        this.archiveBuilder.addEntityDef(getFileFolderEntity());
        this.archiveBuilder.addEntityDef(getDataFolderEntity());
        this.archiveBuilder.addEntityDef(getDataFileEntity());
        this.archiveBuilder.addEntityDef(getCSVFileEntity());
        this.archiveBuilder.addEntityDef(getAvroFileEntity());
        this.archiveBuilder.addEntityDef(getJSONFileEntity());

        this.archiveBuilder.addRelationshipDef(getFolderHierarchyRelationship());
        this.archiveBuilder.addRelationshipDef(getNestedFileRelationship());
        this.archiveBuilder.addRelationshipDef(getLinkedFileRelationship());

        this.archiveBuilder.addClassificationDef(getFileSystemClassification());
    }

    private EntityDef getFileFolderEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.FILE_FOLDER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_STORE.typeName));
    }

    private EntityDef getDataFolderEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DATA_FOLDER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.FILE_FOLDER.typeName));
    }

    private EntityDef getDataFileEntity()
    {
        EntityDef entityDef =  archiveHelper.getDefaultEntityDef(OpenMetadataType.DATA_FILE,
                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_STORE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.FILE_TYPE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getCSVFileEntity()
    {
        EntityDef entityDef =  archiveHelper.getDefaultEntityDef(OpenMetadataType.CSV_FILE,
                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FILE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DELIMITER_CHARACTER));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.QUOTE_CHARACTER));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getAvroFileEntity()
    {
        return  archiveHelper.getDefaultEntityDef(OpenMetadataType.AVRO_FILE,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FILE.typeName));
    }

    private EntityDef getJSONFileEntity()
    {
        return  archiveHelper.getDefaultEntityDef(OpenMetadataType.JSON_FILE,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FILE.typeName));
    }

    private RelationshipDef getFolderHierarchyRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.FOLDER_HIERARCHY_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "parentFolder";
        final String                     end1AttributeDescription     = "Parent folder.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.FILE_FOLDER.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "nestedFolder";
        final String                     end2AttributeDescription     = "Folders embedded in this folder.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.FILE_FOLDER.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private RelationshipDef getNestedFileRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.NESTED_FILE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "homeFolder";
        final String                     end1AttributeDescription     = "Identifies the containing folder of this datafile.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.FILE_FOLDER.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "nestedFiles";
        final String                     end2AttributeDescription     = "Files stored in this folder.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FILE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private RelationshipDef getLinkedFileRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.LINKED_FILE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "linkedFolders";
        final String                     end1AttributeDescription     = "Folders that this file is linked to.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.FILE_FOLDER.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "linkedFiles";
        final String                     end2AttributeDescription     = "Files linked to the folder.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FILE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    private ClassificationDef getFileSystemClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.FILE_SYSTEM_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER_CAPABILITY.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.FORMAT));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ENCRYPTION));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0221 Document Stores define both simple document stores and content management systems
     */
    private void add0221DocumentStores()
    {
        this.archiveBuilder.addEntityDef(getMediaFileEntity());
        this.archiveBuilder.addEntityDef(getMediaCollectionEntity());
        this.archiveBuilder.addEntityDef(getDocumentEntity());
        this.archiveBuilder.addEntityDef(getDocumentStoreEntity());

        this.archiveBuilder.addRelationshipDef(getLinkedMediaRelationship());
    }

    private EntityDef getMediaFileEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.MEDIA_FILE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FILE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EMBEDDED_METADATA));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getMediaCollectionEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.MEDIA_COLLECTION,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName));
    }

    private EntityDef getDocumentEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DOCUMENT,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.MEDIA_FILE.typeName));
    }

    private EntityDef getDocumentStoreEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DOCUMENT_STORE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_STORE.typeName));
    }


    private RelationshipDef getLinkedMediaRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.LINKED_MEDIA_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "linkedMediaFiles";
        final String                     end1AttributeDescription     = "Link to related media files.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.MEDIA_FILE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "linkedMediaFiles";
        final String                     end2AttributeDescription     = "Link to related media files.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.MEDIA_FILE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0222GraphStores()
    {
        this.archiveBuilder.addEntityDef(getGraphStoreEntity());
    }

    private EntityDef getGraphStoreEntity()
    {
       return archiveHelper.getDefaultEntityDef(OpenMetadataType.GRAPH_STORE,
                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_STORE.typeName));
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0223 Events and Logs describes events, log files and event management.
     */
    private void add0223EventsAndLogs()
    {
        this.archiveBuilder.addEntityDef(getSubscriberListEntity());
        this.archiveBuilder.addEntityDef(getTopicEntity());
        this.archiveBuilder.addEntityDef(getLogFileEntity());

        this.archiveBuilder.addRelationshipDef(getTopicSubscribersRelationship());

        this.archiveBuilder.addClassificationDef(getNotificationManagerClassification());
    }

    private EntityDef getSubscriberListEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.SUBSCRIBER_LIST,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.COLLECTION.typeName));
    }

    private EntityDef getTopicEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.TOPIC,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TOPIC_TYPE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getLogFileEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.LOG_FILE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FILE.typeName));
    }

    private RelationshipDef getTopicSubscribersRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.TOPIC_SUBSCRIBERS_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "subscribers";
        final String                     end1AttributeDescription     = "The endpoints subscribed to this topic.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SUBSCRIBER_LIST.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "topics";
        final String                     end2AttributeDescription     = "The topics used by this subscriber list.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TOPIC.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private ClassificationDef getNotificationManagerClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.NOTIFICATION_MANAGER,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER_CAPABILITY.typeName),
                                                  false);
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0224 Databases describe database servers
     */
    private void add0224Databases()
    {
        this.archiveBuilder.addEntityDef(getDeployedDatabaseSchemaEntity());
        this.archiveBuilder.addEntityDef(getDatabaseEntity());

        this.archiveBuilder.addClassificationDef(getDatabaseServerClassification());
    }

    private EntityDef getDeployedDatabaseSchemaEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DEPLOYED_DATABASE_SCHEMA,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName));
    }


    private EntityDef getDatabaseEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.DATABASE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_STORE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.INSTANCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IMPORTED_FROM));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private ClassificationDef getDatabaseServerClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.DATABASE_SERVER_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0225MetadataRepositories()
    {
        this.archiveBuilder.addEntityDef(getEnterpriseAccessLayerEntity());
        this.archiveBuilder.addEntityDef(getCohortMemberEntity());
        this.archiveBuilder.addEntityDef(getMetadataRepositoryCohortEntity());
        this.archiveBuilder.addEntityDef(getMetadataCollectionEntity());
        this.archiveBuilder.addEntityDef(getMetadataRepositoryEntity());
        this.archiveBuilder.addEntityDef(getCohortRegistryStoreEntity());

        this.archiveBuilder.addRelationshipDef(getMetadataCohortPeerRelationship());
        this.archiveBuilder.addRelationshipDef(getCohortMemberMetadataCollectionRelationship());

        this.archiveBuilder.addClassificationDef(getMetadataServerClassification());
        this.archiveBuilder.addClassificationDef(getRepositoryProxyClassification());
    }


    private EntityDef getEnterpriseAccessLayerEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.ENTERPRISE_ACCESS_LAYER,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER_CAPABILITY.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TOPIC_ROOT));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ENTERPRISE_METADATA_COLLECTION_ID));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getCohortMemberEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.COHORT_MEMBER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER_CAPABILITY.typeName));
    }

    private EntityDef getMetadataRepositoryCohortEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.METADATA_REPOSITORY_COHORT,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.COHORT_TOPICS));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getMetadataCollectionEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.METADATA_COLLECTION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MANAGED_METADATA_COLLECTION_ID));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    private EntityDef getMetadataRepositoryEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.METADATA_REPOSITORY,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_STORE.typeName));
    }


    private EntityDef getCohortRegistryStoreEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.COHORT_REGISTRY_STORE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_STORE.typeName));
    }


    private RelationshipDef getMetadataCohortPeerRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.METADATA_COHORT_PEER_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "registeredWithCohorts";
        final String                     end1AttributeDescription     = "Identifies which cohorts this cohort member is registered with.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.METADATA_REPOSITORY_COHORT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "cohortMembership";
        final String                     end2AttributeDescription     = "Members of this cohort.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.COHORT_MEMBER.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.REGISTRATION_DATE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getCohortMemberMetadataCollectionRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.COHORT_MEMBER_METADATA_COLLECTION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "cohortMember";
        final String                     end1AttributeDescription     = "Cohort registry representing this metadata collection on the metadata highway.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.COHORT_MEMBER.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "localMetadataCollection";
        final String                     end2AttributeDescription     = "Metadata to exchange with the cohorts.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.METADATA_COLLECTION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private ClassificationDef getMetadataServerClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.METADATA_SERVER_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.FORMAT));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private ClassificationDef getRepositoryProxyClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.REPOSITORY_PROXY_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER.typeName),
                                                  false);
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0227Keystores()
    {
        this.archiveBuilder.addEntityDef(getKeystoreFileEntity());
        this.archiveBuilder.addEntityDef(geSecretsCollectionEntity());
    }


    private EntityDef getKeystoreFileEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.KEYSTORE_FILE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FILE.typeName));
    }


    private EntityDef geSecretsCollectionEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.SECRETS_COLLECTION,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName));
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0230CodeTables()
    {
        this.archiveBuilder.addEntityDef(getReferenceCodeTableEntity());
        this.archiveBuilder.addEntityDef(getReferenceCodeMappingTableEntity());

    }


    private EntityDef getReferenceCodeTableEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.REFERENCE_CODE_TABLE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName));
    }


    private EntityDef getReferenceCodeMappingTableEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.REFERENCE_CODE_MAPPING_TABLE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName));
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0235InformationView()
    {
        this.archiveBuilder.addEntityDef(getInformationViewEntity());
    }


    private EntityDef getInformationViewEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.INFORMATION_VIEW,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName));
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0239Reports()
    {
        this.archiveBuilder.addEntityDef(getFormEntity());
        this.archiveBuilder.addEntityDef(getDeployedReportEntity());
    }

    private EntityDef getFormEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.FORM,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName));
    }

    private EntityDef getDeployedReportEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.DEPLOYED_REPORT,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ID));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.AUTHOR));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.URL));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CREATED_TIME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.LAST_MODIFIED_TIME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.LAST_MODIFIER));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private void add0290Ports()
    {
        this.archiveBuilder.addEnumDef(getPortTypeEnum());

        this.archiveBuilder.addEntityDef(getPortEntity());
        this.archiveBuilder.addEntityDef(getPortAliasEntity());
        this.archiveBuilder.addEntityDef(getPortImplementationEntity());

        this.archiveBuilder.addRelationshipDef(getProcessPortRelationship());
        this.archiveBuilder.addRelationshipDef(getPortDelegationRelationship());
    }

    /**
     * The PortType enum describes the data flow direction through a port
     *
     * @return PortType EnumDef
     */
    private EnumDef getPortTypeEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(PortType.getOpenTypeGUID(),
                                                        PortType.getOpenTypeName(),
                                                        PortType.getOpenTypeDescription(),
                                                        PortType.getOpenTypeDescriptionGUID(),
                                                        PortType.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (PortType enumValue : PortType.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    /**
     * The Port entity describes the input or output of a process
     *
     * @return Port EntityDef
     */
    private EntityDef getPortEntity()
    {
        /*
         * Build the Entity
         */
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.PORT,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.PORT_TYPE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }

    /**
     * The PortAlias describes the input/output of a higher-level process
     *
     * @return PortAlias EntityDef
     */
    private EntityDef getPortAliasEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.PORT_ALIAS,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.PORT.typeName));
    }

    /**
     * The PortImplementation describes the input/output of a lowest-level process
     *
     * @return PortImplementation EntityDef
     */
    private EntityDef getPortImplementationEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.PORT_IMPLEMENTATION,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.PORT.typeName));
    }

    /**
     * The PortDelegation relationship describes the relationship between a more granular and a more abstract port
     * @return PortDelegation RelationshipDef
     */
    private RelationshipDef getPortDelegationRelationship()
    {
        /*
         * Build the relationship
         */
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PORT_DELEGATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "delegatingFrom";
        final String                     end1AttributeDescription     = "Higher level Port";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PORT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "delegatingTo";
        final String                     end2AttributeDescription     = "Lower level port";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PORT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);


        return relationshipDef;
    }

    /**
     * The ProcessPort relationship describes the link between a port and the process used by the port.
     * @return ProcessPort RelationshipDef
     */
    private RelationshipDef getProcessPortRelationship()
    {
        /*
         * Build the relationship
         */
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PROCESS_PORT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "owningProcess";
        final String                     end1AttributeDescription     = "Process linked to the port";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROCESS.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "ports";
        final String                     end2AttributeDescription     = "Port to the process";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PORT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);


        return relationshipDef;
    }

    /*
     * ========================================
     * AREA 3: glossary
     */

    /**
     * Area 3 covers semantic definitions.
     */
    private void addArea3Types()
    {
        this.add0310Glossary();
        this.add0320CategoryHierarchy();
        this.add0330Terms();
        this.add0340Dictionary();
        this.add0350RelatedTerms();
        this.add0360Contexts();
        this.add0370SemanticAssignment();
        this.add0380SpineObjects();
        this.add0385ControlledGlossaryDevelopment();
        this.add0390GlossaryProject();
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0310 Glossary covers the top-level glossary object that organizes glossary terms.
     */
    private void add0310Glossary()
    {
        this.archiveBuilder.addEntityDef(getGlossaryEntity());

        this.archiveBuilder.addClassificationDef(getTaxonomyClassification());
        this.archiveBuilder.addClassificationDef(getCanonicalVocabularyClassification());
    }


    private EntityDef getGlossaryEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.GLOSSARY,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.LANGUAGE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.USAGE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private ClassificationDef getTaxonomyClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.TAXONOMY_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ORGANIZING_PRINCIPLE));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private ClassificationDef getCanonicalVocabularyClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.CANONICAL_VOCABULARY_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SCOPE));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0320 Category Hierarchy adds categories to the glossary that allow terms to be defined in taxonomies
     * or hierarchies of folders.
     */
    private void add0320CategoryHierarchy()
    {
        this.archiveBuilder.addEntityDef(getGlossaryCategoryEntity());

        this.archiveBuilder.addRelationshipDef(getCategoryAnchorRelationship());
        this.archiveBuilder.addRelationshipDef(getCategoryHierarchyLinkRelationship());

        this.archiveBuilder.addClassificationDef(getSubjectAreaClassification());
    }


    private EntityDef getGlossaryCategoryEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.GLOSSARY_CATEGORY,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getCategoryAnchorRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.CATEGORY_ANCHOR_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "anchor";
        final String                     end1AttributeDescription     = "Owning glossary for this category.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "categories";
        final String                     end2AttributeDescription     = "Categories owned by this glossary.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_CATEGORY.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getCategoryHierarchyLinkRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.CATEGORY_HIERARCHY_LINK_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "superCategory";
        final String                     end1AttributeDescription     = "Identifies the parent category.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_CATEGORY.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "subcategories";
        final String                     end2AttributeDescription     = "Glossary categories nested inside this category.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_CATEGORY.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private ClassificationDef getSubjectAreaClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.SUBJECT_AREA_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0330 Terms brings in the glossary term that captures a single semantic meaning.
     */
    private void add0330Terms()
    {
        this.archiveBuilder.addEnumDef(getTermRelationshipStatusEnum());

        this.archiveBuilder.addEntityDef(getGlossaryTermEntity());

        this.archiveBuilder.addRelationshipDef(getTermAnchorRelationship());
        this.archiveBuilder.addRelationshipDef(getTermCategorizationRelationship());
    }

    private EnumDef getTermRelationshipStatusEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(GlossaryTermRelationshipStatus.getOpenTypeGUID(),
                                                        GlossaryTermRelationshipStatus.getOpenTypeName(),
                                                        GlossaryTermRelationshipStatus.getOpenTypeDescription(),
                                                        GlossaryTermRelationshipStatus.getOpenTypeDescriptionGUID(),
                                                        GlossaryTermRelationshipStatus.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (GlossaryTermRelationshipStatus enumValues : GlossaryTermRelationshipStatus.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getGlossaryTermEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.GLOSSARY_TERM,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SUMMARY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXAMPLES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ABBREVIATION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.USAGE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getTermAnchorRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.TERM_ANCHOR_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "anchor";
        final String                     end1AttributeDescription     = "Owning glossary.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "terms";
        final String                     end2AttributeDescription     = "Terms owned by this glossary.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getTermCategorizationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.TERM_CATEGORIZATION,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "categories";
        final String                     end1AttributeDescription     = "Glossary categories that this term is linked to.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_CATEGORY.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "terms";
        final String                     end2AttributeDescription     = "Glossary terms linked to this category.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0340 Dictionary provides classifications for a term that define what type of term it is and
     * how it intended to be used.
     */
    private void add0340Dictionary()
    {
        this.archiveBuilder.addEnumDef(getActivityTypeEnum());

        this.archiveBuilder.addClassificationDef(getActivityDescriptionClassification());
        this.archiveBuilder.addClassificationDef(getAbstractConceptClassification());
        this.archiveBuilder.addClassificationDef(getDataValueClassification());
    }


    private EnumDef getActivityTypeEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(GlossaryTermActivityType.getOpenTypeGUID(),
                                                        GlossaryTermActivityType.getOpenTypeName(),
                                                        GlossaryTermActivityType.getOpenTypeDescription(),
                                                        GlossaryTermActivityType.getOpenTypeDescriptionGUID(),
                                                        GlossaryTermActivityType.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (GlossaryTermActivityType enumValues : GlossaryTermActivityType.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private ClassificationDef getActivityDescriptionClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.ACTIVITY_DESCRIPTION_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.ACTIVITY_TYPE));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private ClassificationDef getAbstractConceptClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.ABSTRACT_CONCEPT_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                  false);
    }


    private ClassificationDef getDataValueClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.DATA_VALUE_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                  false);
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0350 Related Terms provides a selection of semantic relationships
     */
    private void add0350RelatedTerms()
    {
        this.archiveBuilder.addRelationshipDef(getRelatedTermRelationship());
        this.archiveBuilder.addRelationshipDef(getSynonymRelationship());
        this.archiveBuilder.addRelationshipDef(getAntonymRelationship());
        this.archiveBuilder.addRelationshipDef(getPreferredTermRelationship());
        this.archiveBuilder.addRelationshipDef(getReplacementTermRelationship());
        this.archiveBuilder.addRelationshipDef(getTranslationRelationship());
        this.archiveBuilder.addRelationshipDef(getISARelationshipRelationship());
        this.archiveBuilder.addRelationshipDef(getValidValueRelationship());
    }


    private RelationshipDef getRelatedTermRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.RELATED_TERM_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "seeAlso";
        final String                     end1AttributeDescription     = "Related glossary terms.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "seeAlso";
        final String                     end2AttributeDescription     = "Related glossary terms.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getSynonymRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.SYNONYM_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "synonyms";
        final String                     end1AttributeDescription     = "Glossary terms with the same meaning.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "synonyms";
        final String                     end2AttributeDescription     = "Glossary terms with the same meaning.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getAntonymRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ANTONYM_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "antonyms";
        final String                     end1AttributeDescription     = "Glossary terms with the opposite meaning.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "antonyms";
        final String                     end2AttributeDescription     = "Glossary terms with the opposite meaning.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getPreferredTermRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PREFERRED_TERM_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "alternateTerms";
        final String                     end1AttributeDescription     = "Alternative glossary terms.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "preferredTerms";
        final String                     end2AttributeDescription     = "Related glossary terms.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getReplacementTermRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.REPLACEMENT_TERM_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "replacedTerms";
        final String                     end1AttributeDescription     = "Replaced glossary terms.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "replacementTerms";
        final String                     end2AttributeDescription     = "Replacement glossary terms.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getTranslationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.TRANSLATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "translations";
        final String                     end1AttributeDescription     = "Translations of glossary term.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "translations";
        final String                     end2AttributeDescription     = "Translations of glossary term.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getISARelationshipRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ISA_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "classifies";
        final String                     end1AttributeDescription     = "More specific glossary terms.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "isA";
        final String                     end2AttributeDescription     = "More general glossary terms.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getValidValueRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.VALID_VALUE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "validValueFor";
        final String                     end1AttributeDescription     = "Glossary terms for data items that can be set to this value.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "validValues";
        final String                     end2AttributeDescription     = "Glossary terms for data values that can be used with data items represented by this glossary term.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0360 Contexts allows Glossary Terms to linked to specific contexts (also defined with Glossary Terms).
     */
    private void add0360Contexts()
    {
        this.archiveBuilder.addRelationshipDef(getUsedInContextRelationship());

        this.archiveBuilder.addClassificationDef(getContextDefinitionClassification());
    }

    private RelationshipDef getUsedInContextRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.USED_IN_CONTEXT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "contextRelevantTerms";
        final String                     end1AttributeDescription     = "Glossary terms used in this specific context.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "usedInContexts";
        final String                     end2AttributeDescription     = "Glossary terms describing the contexts where this term is used.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private ClassificationDef getContextDefinitionClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.CONTEXT_DEFINITION_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SCOPE));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0370 Semantic Assignment defines a relationship between a Glossary Term and an Asset
     */
    private void add0370SemanticAssignment()
    {
        this.archiveBuilder.addEnumDef(getTermAssignmentStatusEnum());

        this.archiveBuilder.addRelationshipDef(getSemanticAssignmentRelationship());
    }


    private EnumDef getTermAssignmentStatusEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(GlossaryTermAssignmentStatus.getOpenTypeGUID(),
                                                        GlossaryTermAssignmentStatus.getOpenTypeName(),
                                                        GlossaryTermAssignmentStatus.getOpenTypeDescription(),
                                                        GlossaryTermAssignmentStatus.getOpenTypeDescriptionGUID(),
                                                        GlossaryTermAssignmentStatus.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (GlossaryTermAssignmentStatus enumValues : GlossaryTermAssignmentStatus.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private RelationshipDef getSemanticAssignmentRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.SEMANTIC_ASSIGNMENT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "assignedElements";
        final String                     end1AttributeDescription     = "Elements identified as managing data that has the same meaning as this glossary term.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "meaning";
        final String                     end2AttributeDescription     = "Semantic definition for this element.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_ASSIGNMENT_STATUS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD_TYPE_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD_PROPERTY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0380 Spine Objects enables relationships to be established between objects and their attributes.
     */
    private void add0380SpineObjects()
    {
        this.archiveBuilder.addRelationshipDef(getTermHASARelationshipRelationship());
        this.archiveBuilder.addRelationshipDef(getTermTYPEDBYRelationshipRelationship());

        this.archiveBuilder.addClassificationDef(getSpineObjectClassification());
        this.archiveBuilder.addClassificationDef(getSpineAttributeClassification());
        this.archiveBuilder.addClassificationDef(getObjectIdentifierClassification());
    }


    private RelationshipDef getTermHASARelationshipRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.TERM_HAS_A_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "objects";
        final String                     end1AttributeDescription     = "Objects where this attribute may occur.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "attributes";
        final String                     end2AttributeDescription     = "Typical attributes for this object.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getTermTYPEDBYRelationshipRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.TERM_TYPED_BY_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "attributesTypedBy";
        final String                     end1AttributeDescription     = "Attributes of this type.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "types";
        final String                     end2AttributeDescription     = "Types for this attribute.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.TERM_RELATIONSHIP_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private ClassificationDef getSpineObjectClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.SPINE_OBJECT_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                  false);
    }


    private ClassificationDef getSpineAttributeClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.SPINE_ATTRIBUTE_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                  false);
    }


    private ClassificationDef getObjectIdentifierClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.OBJECT_IDENTIFIER_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                  false);
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0385 ControlledGlossaryDevelopment covers glossary term objects that are created and
     * maintained through a workflow process.
     */
    private void add0385ControlledGlossaryDevelopment()
    {
        this.archiveBuilder.addEntityDef(getControlledGlossaryTermEntity());
    }


    private EntityDef getControlledGlossaryTermEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.CONTROLLED_GLOSSARY_TERM,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName));

        ArrayList<InstanceStatus> validInstanceStatusList = new ArrayList<>();
        validInstanceStatusList.add(InstanceStatus.DRAFT);
        validInstanceStatusList.add(InstanceStatus.PROPOSED);
        validInstanceStatusList.add(InstanceStatus.APPROVED);
        validInstanceStatusList.add(InstanceStatus.ACTIVE);
        validInstanceStatusList.add(InstanceStatus.DELETED);
        entityDef.setValidInstanceStatusList(validInstanceStatusList);
        entityDef.setInitialStatus(InstanceStatus.DRAFT);

        return entityDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0390 Glossary Project provides a classification for a project to say it is updating glossary terms.
     */
    private void add0390GlossaryProject()
    {
        this.archiveBuilder.addClassificationDef(getGlossaryProjectClassification());
    }


    private ClassificationDef getGlossaryProjectClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.GLOSSARY_PROJECT_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT.typeName),
                                                  false);
    }


    /*
     * ========================================
     * AREA 4: governance
     */

    /**
     * Area 4 models cover the governance entities and relationships.
     */
    private void addArea4Types()
    {
        this.add0401GovernanceDefinitions();
        this.add0405GovernanceDrivers();
        this.add0415GovernanceResponses();
        this.add0417GovernanceProject();
        this.add0420GovernanceControls();
        this.add0422GovernanceActionClassifications();
        this.add0423SecurityTags();
        this.add0424GovernanceZones();
        this.add0430TechnicalControls();
        this.add0438NamingStandards();
        this.add0440OrganizationalControls();
        this.add0442ProjectCharter();
        this.add0445GovernanceRoles();
        this.add0450GovernanceRollout();
        this.add0455ExceptionManagement();
        this.add0460GovernanceControls();
        this.add0481Licenses();
        this.add0482Certifications();
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0401 The definitions that control the governance of data assets are authored in the metadata repository.
     * They are referenceable and they make use of external references for more information.
     */
    private void add0401GovernanceDefinitions()
    {
        this.archiveBuilder.addEnumDef(getGovernanceDomainEnum());

        this.archiveBuilder.addEntityDef(getGovernanceDefinitionEntity());
        this.archiveBuilder.addEntityDef(getGovernanceOfficerEntity());
    }

    /**
     * This enum is used to illustrate types of governance domains.
     *
     * @return enum definition
     */
    private EnumDef getGovernanceDomainEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(GovernanceDomain.getOpenTypeGUID(),
                                                        GovernanceDomain.getOpenTypeName(),
                                                        GovernanceDomain.getOpenTypeDescription(),
                                                        GovernanceDomain.getOpenTypeDescriptionGUID());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (GovernanceDomain enumValue : GovernanceDomain.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getGovernanceDefinitionEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_DEFINITION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TITLE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SUMMARY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SCOPE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IMPORTANCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IMPLICATIONS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.OUTCOMES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RESULTS));

        entityDef.setPropertiesDefinition(properties);

        ArrayList<InstanceStatus> validInstanceStatusList = new ArrayList<>();
        validInstanceStatusList.add(InstanceStatus.DRAFT);
        validInstanceStatusList.add(InstanceStatus.PROPOSED);
        validInstanceStatusList.add(InstanceStatus.APPROVED);
        validInstanceStatusList.add(InstanceStatus.ACTIVE);
        validInstanceStatusList.add(InstanceStatus.DEPRECATED);
        validInstanceStatusList.add(InstanceStatus.OTHER);
        validInstanceStatusList.add(InstanceStatus.DELETED);
        entityDef.setValidInstanceStatusList(validInstanceStatusList);
        entityDef.setInitialStatus(InstanceStatus.DRAFT);

        return entityDef;
    }


    private EntityDef getGovernanceOfficerEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_OFFICER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON_ROLE.typeName));
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0405 Governance Drivers defines the factors that drive the governance program.
     */
    private void add0405GovernanceDrivers()
    {
        this.archiveBuilder.addEntityDef(getGovernanceDriverEntity());
        this.archiveBuilder.addEntityDef(getGovernanceStrategyEntity());
        this.archiveBuilder.addEntityDef(getRegulationEntity());
    }


    private EntityDef getGovernanceDriverEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_DRIVER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_DEFINITION.typeName));
    }


    private EntityDef getGovernanceStrategyEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_STRATEGY,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_DRIVER.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.BUSINESS_IMPERATIVES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getRegulationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.REGULATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_DRIVER.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.JURISDICTION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0415 Governance Responses lay out the approaches, principles and obligations that follow from the
     * governance drivers.
     */
    private void add0415GovernanceResponses()
    {
        this.archiveBuilder.addEntityDef(getGovernancePolicyEntity());
        this.archiveBuilder.addEntityDef(getGovernancePrincipleEntity());
        this.archiveBuilder.addEntityDef(getGovernanceObligationEntity());
        this.archiveBuilder.addEntityDef(getGovernanceApproachEntity());

        this.archiveBuilder.addRelationshipDef(getGovernancePolicyLinkRelationship());
        this.archiveBuilder.addRelationshipDef(getGovernanceResponseRelationship());
    }


    private EntityDef getGovernancePolicyEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_POLICY,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_DEFINITION.typeName));
    }


    private EntityDef getGovernancePrincipleEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_PRINCIPLE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_POLICY.typeName));
    }


    private EntityDef getGovernanceObligationEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_OBLIGATION,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_POLICY.typeName));
    }


    private EntityDef getGovernanceApproachEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_APPROACH,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_POLICY.typeName));
    }


    private RelationshipDef getGovernancePolicyLinkRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.GOVERNANCE_POLICY_LINK_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "linkingPolicies";
        final String                     end1AttributeDescription     = "Policies that are dependent on this policy.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_POLICY.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "linkedPolicies";
        final String                     end2AttributeDescription     = "Policies that further define aspects of this policy.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_POLICY.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getGovernanceResponseRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.GOVERNANCE_RESPONSE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "drivers";
        final String                     end1AttributeDescription     = "Drivers that justify this policy.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_DRIVER.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "policies";
        final String                     end2AttributeDescription     = "Governance policies that support this governance driver.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_POLICY.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RATIONALE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0417 Governance Project provides a classification for a project
     */
    private void add0417GovernanceProject()
    {
        this.archiveBuilder.addClassificationDef(getGovernanceProjectClassification());
    }


    private ClassificationDef getGovernanceProjectClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.GOVERNANCE_PROJECT_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT.typeName),
                                                  false);
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0420 Governance Controls define the implementation of the governance policies
     */
    private void add0420GovernanceControls()
    {
        this.archiveBuilder.addEntityDef(getGovernanceControlEntity());
        this.archiveBuilder.addEntityDef(getTechnicalControlEntity());
        this.archiveBuilder.addEntityDef(getOrganizationalControlEntity());

        this.archiveBuilder.addRelationshipDef(getGovernanceImplementationRelationship());
        this.archiveBuilder.addRelationshipDef(getGovernanceControlLinkRelationship());
    }


    private EntityDef getGovernanceControlEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_CONTROL,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_DEFINITION.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IMPLEMENTATION_DESCRIPTION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getTechnicalControlEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.TECHNICAL_CONTROL,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_CONTROL.typeName));
    }


    private EntityDef getOrganizationalControlEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.ORGANIZATIONAL_CONTROL,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_CONTROL.typeName));
    }

    private RelationshipDef getGovernanceImplementationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.GOVERNANCE_IMPLEMENTATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "policies";
        final String                     end1AttributeDescription     = "The policies that are supported by this control.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_POLICY.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "implementations";
        final String                     end2AttributeDescription     = "The governance controls that implement this policy.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_CONTROL.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RATIONALE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }

    private RelationshipDef getGovernanceControlLinkRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.GOVERNANCE_CONTROL_LINK_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "linkingControls";
        final String                     end1AttributeDescription     = "Governance controls that ate dependent on this control.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_CONTROL.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "linkedControls";
        final String                     end2AttributeDescription     = "Governance controls that support the implementation of this control.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_CONTROL.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }



    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0422 Governance Action Classifications provide the key classification that drive information governance.
     */
    private void add0422GovernanceActionClassifications()
    {
        this.archiveBuilder.addEnumDef(getGovernanceClassificationStatusEnum());
        this.archiveBuilder.addEnumDef(getConfidentialityLevelEnum());
        this.archiveBuilder.addEnumDef(getConfidenceLevelEnum());
        this.archiveBuilder.addEnumDef(getRetentionBasisEnum());
        this.archiveBuilder.addEnumDef(getCriticalityLevelEnum());

        this.archiveBuilder.addClassificationDef(getConfidentialityClassification());
        this.archiveBuilder.addClassificationDef(getConfidenceClassification());
        this.archiveBuilder.addClassificationDef(getRetentionClassification());
        this.archiveBuilder.addClassificationDef(getCriticalityClassification());
    }


    private EnumDef getGovernanceClassificationStatusEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(GovernanceClassificationStatus.getOpenTypeGUID(),
                                                        GovernanceClassificationStatus.getOpenTypeName(),
                                                        GovernanceClassificationStatus.getOpenTypeDescription(),
                                                        GovernanceClassificationStatus.getOpenTypeDescriptionGUID(),
                                                        GovernanceClassificationStatus.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (CriticalityLevel enumValues : CriticalityLevel.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private EnumDef getConfidentialityLevelEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(ConfidentialityLevel.getOpenTypeGUID(),
                                                        ConfidentialityLevel.getOpenTypeName(),
                                                        ConfidentialityLevel.getOpenTypeDescription(),
                                                        ConfidentialityLevel.getOpenTypeDescriptionGUID(),
                                                        ConfidentialityLevel.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (ConfidentialityLevel enumValues : ConfidentialityLevel.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private EnumDef getConfidenceLevelEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(ConfidenceLevel.getOpenTypeGUID(),
                                                        ConfidenceLevel.getOpenTypeName(),
                                                        ConfidenceLevel.getOpenTypeDescription(),
                                                        ConfidenceLevel.getOpenTypeDescriptionGUID(),
                                                        ConfidenceLevel.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (ConfidenceLevel enumValues : ConfidenceLevel.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private EnumDef getRetentionBasisEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(RetentionBasis.getOpenTypeGUID(),
                                                        RetentionBasis.getOpenTypeName(),
                                                        RetentionBasis.getOpenTypeDescription(),
                                                        RetentionBasis.getOpenTypeDescriptionGUID(),
                                                        RetentionBasis.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (RetentionBasis enumValues : RetentionBasis.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private EnumDef getCriticalityLevelEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(CriticalityLevel.getOpenTypeGUID(),
                                                        CriticalityLevel.getOpenTypeName(),
                                                        CriticalityLevel.getOpenTypeDescription(),
                                                        CriticalityLevel.getOpenTypeDescriptionGUID(),
                                                        CriticalityLevel.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (CriticalityLevel enumValues : CriticalityLevel.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }

    private ClassificationDef getConfidentialityClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.CONFIDENTIALITY_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }

    private ClassificationDef getConfidenceClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.CONFIDENCE_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }

    private ClassificationDef getRetentionClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.RETENTION_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ASSOCIATED_GUID));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ARCHIVE_AFTER));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DELETE_AFTER));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }

    private ClassificationDef getCriticalityClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.CRITICALITY_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0423 Security Tags define the labels and properties used by rules in a security engine.
     */
    private void add0423SecurityTags()
    {
        this.archiveBuilder.addClassificationDef(getSecurityTagsClassification());
    }

    private ClassificationDef getSecurityTagsClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.SECURITY_TAGS_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SECURITY_LABELS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SECURITY_PROPERTIES));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0424 Governance Zones define the zones used to group assets according to their use.
     */
    private void add0424GovernanceZones()
    {
        this.archiveBuilder.addClassificationDef(getAssetZoneMembershipClassification());

        this.archiveBuilder.addEntityDef(getGovernanceZoneEntity());

        this.archiveBuilder.addRelationshipDef(getZoneHierarchyRelationship());
    }


    private ClassificationDef getAssetZoneMembershipClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.ASSET_ZONE_MEMBERSHIP_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ZONE_MEMBERSHIP));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private EntityDef getGovernanceZoneEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_ZONE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CRITERIA));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getZoneHierarchyRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ZONE_HIERARCHY_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "inheritsFromZone";
        final String                     end1AttributeDescription     = "The zone that provides additional governance requirements.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_ZONE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "controlsZone";
        final String                     end2AttributeDescription     = "The zones that are also governed in the same way.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_ZONE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);


        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0430 Technical Controls describe specific types of technical controls
     */
    private void add0430TechnicalControls()
    {
        this.archiveBuilder.addEntityDef(getGovernanceRuleEntity());
        this.archiveBuilder.addEntityDef(getGovernanceProcessEntity());

        this.archiveBuilder.addRelationshipDef(getGovernanceRuleImplementationRelationship());
        this.archiveBuilder.addRelationshipDef(getGovernanceProcessImplementationRelationship());
    }


    private EntityDef getGovernanceRuleEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_RULE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.TECHNICAL_CONTROL.typeName));
    }


    private EntityDef getGovernanceProcessEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_PROCESS,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.TECHNICAL_CONTROL.typeName));
    }


    private RelationshipDef getGovernanceRuleImplementationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.GOVERNANCE_RULE_IMPLEMENTATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "implementsGovernanceRules";
        final String                     end1AttributeDescription     = "The rules that are implemented by this component.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_RULE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "implementations";
        final String                     end2AttributeDescription     = "The software components that implement this governance rule.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DEPLOYED_SOFTWARE_COMPONENT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getGovernanceProcessImplementationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.GOVERNANCE_PROCESS_IMPLEMENTATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "implementsGovernanceProcesses";
        final String                     end1AttributeDescription     = "The processes that are implemented by this component.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_PROCESS.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "implementations";
        final String                     end2AttributeDescription     = "The processes that implement this governance process.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROCESS.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0438 Naming Standards provides definitions for laying our naming standards for schemas and assets.
     */
    private void add0438NamingStandards()
    {
        this.archiveBuilder.addEntityDef(getNamingStandardRuleEntity());
        this.archiveBuilder.addEntityDef(getNamingStandardRuleSetEntity());

        this.archiveBuilder.addClassificationDef(getPrimeWordClassification());
        this.archiveBuilder.addClassificationDef(getClassWordClassification());
    }


    private EntityDef getNamingStandardRuleEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.NAMING_STANDARD_RULE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_RULE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME_PATTERNS));


        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getNamingStandardRuleSetEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.NAMING_STANDARD_RULE_SET,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.COLLECTION.typeName));
    }


    private ClassificationDef getPrimeWordClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.PRIME_WORD_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                  false);
    }


    private ClassificationDef getClassWordClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.CLASS_WORD_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.GLOSSARY_TERM.typeName),
                                                  false);
    }



    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0440 Organizational Controls describe organizational roles and responsibilities.
     */
    private void add0440OrganizationalControls()
    {
        this.archiveBuilder.addEnumDef(getBusinessCapabilityTypeEnum());

        this.archiveBuilder.addEntityDef(getOrganizationEntity());
        this.archiveBuilder.addEntityDef(getBusinessCapabilityEntity());
        this.archiveBuilder.addEntityDef(getGovernanceResponsibilityEntity());
        this.archiveBuilder.addEntityDef(getGovernanceProcedureEntity());

        this.archiveBuilder.addClassificationDef(getAssetOriginClassification());

        this.archiveBuilder.addRelationshipDef(getOrganizationCapabilityRelationship());
    }


    private EnumDef getBusinessCapabilityTypeEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(BusinessCapabilityType.getOpenTypeGUID(),
                                                        BusinessCapabilityType.getOpenTypeName(),
                                                        BusinessCapabilityType.getOpenTypeDescription(),
                                                        BusinessCapabilityType.getOpenTypeDescriptionGUID());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (BusinessCapabilityType enumValue : BusinessCapabilityType.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getOrganizationEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.ORGANIZATION,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.TEAM.typeName));
    }


    private EntityDef getBusinessCapabilityEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.BUSINESS_CAPABILITY,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getGovernanceResponsibilityEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_RESPONSIBILITY,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.ORGANIZATIONAL_CONTROL.typeName));
    }


    private EntityDef getGovernanceProcedureEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_PROCEDURE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.ORGANIZATIONAL_CONTROL.typeName));
    }


    private ClassificationDef getAssetOriginClassification()
    {
        ClassificationDef classificationDef =  archiveHelper.getClassificationDef(OpenMetadataType.ASSET_ORIGIN_CLASSIFICATION,
                                                                                  null,
                                                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName),
                                                                                  false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ORGANIZATION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.BUSINESS_CAPABILITY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.OTHER_ORIGIN_VALUES));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private RelationshipDef getOrganizationCapabilityRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ORGANIZATIONAL_CAPABILITY_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "supportsBusinessCapabilities";
        final String                     end1AttributeDescription     = "The business capabilities that this team supports.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.BUSINESS_CAPABILITY.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "supportingTeams";
        final String                     end2AttributeDescription     = "The teams that support this business capability.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.TEAM.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0442ProjectCharter()
    {
        this.archiveBuilder.addEntityDef(getProjectCharterEntity());

        this.archiveBuilder.addRelationshipDef(getProjectCharterLinkRelationship());
    }


    private EntityDef getProjectCharterEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.PROJECT_CHARTER,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MISSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROJECT_TYPE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PURPOSES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getProjectCharterLinkRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PROJECT_CHARTER_LINK_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "projects";
        final String                     end1AttributeDescription     = "The projects guided by this charter.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "charter";
        final String                     end2AttributeDescription     = "The charter guiding this project.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROJECT_CHARTER.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0445GovernanceRoles()
    {
        this.archiveBuilder.addEntityDef(getGovernanceRoleEntity());
        this.archiveBuilder.addEntityDef(getAssetOwnerEntity());
        this.archiveBuilder.addEntityDef(getSubjectAreaOwnerEntity());

        this.archiveBuilder.addRelationshipDef(getGovernanceResponsibilityAssignmentRelationship());
    }


    private EntityDef getGovernanceRoleEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_ROLE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.PERSON_ROLE.typeName));
    }


    private EntityDef getAssetOwnerEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.ASSET_OWNER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_ROLE.typeName));
    }


    private EntityDef getSubjectAreaOwnerEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.SUBJECT_AREA_OWNER,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_ROLE.typeName));
    }


    private RelationshipDef getGovernanceResponsibilityAssignmentRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.GOVERNANCE_RESPONSIBILITY_ASSIGNMENT,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 2.
         */
        final String                     end1AttributeName            = "performedByRoles";
        final String                     end1AttributeDescription     = "The roles assigned to this responsibility.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_ROLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);


        /*
         * Set up end 1.
         */
        final String                     end2AttributeName            = "governanceResponsibilities";
        final String                     end2AttributeDescription     = "The responsibilities performed by this role.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_RESPONSIBILITY.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);

        return relationshipDef;
    }



    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0450GovernanceRollout()
    {
        this.archiveBuilder.addEntityDef(getGovernanceMetricEntity());

        this.archiveBuilder.addRelationshipDef(getGovernanceDefinitionMetricRelationship());
        this.archiveBuilder.addRelationshipDef(getGovernanceResultsRelationship());

        this.archiveBuilder.addClassificationDef(getGovernanceMeasurementsDataSetClassification());
    }


    private EntityDef getGovernanceMetricEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.GOVERNANCE_METRIC,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MEASUREMENT));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TARGET));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getGovernanceDefinitionMetricRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.GOVERNANCE_DEFINITION_METRIC_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 2.
         */
        final String                     end1AttributeName            = "metrics";
        final String                     end1AttributeDescription     = "The metrics that measure the landscape against this governance definition.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_METRIC.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);


        /*
         * Set up end 1.
         */
        final String                     end2AttributeName            = "measuredDefinitions";
        final String                     end2AttributeDescription     = "The governance definitions that are measured by this metric.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_DEFINITION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RATIONALE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getGovernanceResultsRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.GOVERNANCE_RESULTS_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "metrics";
        final String                     end1AttributeDescription     = "The governance metrics that are captured in this data set.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_METRIC.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "measurements";
        final String                     end2AttributeDescription     = "The data set that captures the measurements for this governance metric.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.QUERY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.QUERY_TYPE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private ClassificationDef getGovernanceMeasurementsDataSetClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.GOVERNANCE_MEASUREMENTS_RESULTS_DATA_SET_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0455ExceptionManagement()
    {
        this.archiveBuilder.addClassificationDef(getExceptionBacklogClassification());
        this.archiveBuilder.addClassificationDef(getAuditLogClassification());
        this.archiveBuilder.addClassificationDef(getMeteringLogClassification());
        this.archiveBuilder.addClassificationDef(getStewardshipServerClassification());
        this.archiveBuilder.addClassificationDef(getGovernanceDaemonClassification());
    }


    private ClassificationDef getExceptionBacklogClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.EXCEPTION_BACKLOG_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROCESS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private ClassificationDef getAuditLogClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.AUDIT_LOG_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROCESS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private ClassificationDef getMeteringLogClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.METERING_LOG_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_SET.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROCESS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private ClassificationDef getStewardshipServerClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.STEWARDSHIP_SERVER_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER.typeName),
                                                  false);
    }


    private ClassificationDef getGovernanceDaemonClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.GOVERNANCE_DAEMON_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.SOFTWARE_SERVER.typeName),
                                                  false);
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0460GovernanceControls()
    {
        this.archiveBuilder.addClassificationDef(getControlPointClassification());
        this.archiveBuilder.addClassificationDef(getVerificationPointClassification());
        this.archiveBuilder.addClassificationDef(getEnforcementPointClassification());
    }


    private ClassificationDef getControlPointClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.CONTROL_POINT_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                  false);
    }


    private ClassificationDef getVerificationPointClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.VERIFICATION_POINT_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                  false);
    }


    private ClassificationDef getEnforcementPointClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.ENFORCEMENT_POINT_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                  false);
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0481Licenses()
    {
        this.archiveBuilder.addEntityDef(getLicenseTypeEntity());

        this.archiveBuilder.addRelationshipDef(getLicenseRelationship());
    }


    private EntityDef getLicenseTypeEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.LICENSE_TYPE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_DEFINITION.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DETAILS));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getLicenseRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.LICENSE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "licensed";
        final String                     end1AttributeDescription     = "Items licensed by this type of license.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "licenses";
        final String                     end2AttributeDescription     = "The types of licenses that apply.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.LICENSE_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.LICENSE_GUID));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.START));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.END));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONDITIONS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.LICENSED_BY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CUSTODIAN));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.LICENSEE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0482Certifications()
    {
        this.archiveBuilder.addEntityDef(getCertificationTypeEntity());

        this.archiveBuilder.addRelationshipDef(getCertificationRelationship());
        this.archiveBuilder.addRelationshipDef(getRegulationCertificationTypeRelationship());
    }


    private EntityDef getCertificationTypeEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.CERTIFICATION_TYPE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.GOVERNANCE_DEFINITION.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DETAILS));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getCertificationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.CERTIFICATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "certifies";
        final String                     end1AttributeDescription     = "Items certified by this type of certification.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "certifications";
        final String                     end2AttributeDescription     = "The types of certifications that apply.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CERTIFICATION_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CERTIFICATE_GUID));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.START));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.END));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONDITIONS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CERTIFIED_BY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CUSTODIAN));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RECIPIENT));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NOTES));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getRegulationCertificationTypeRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.REGULATION_CERTIFICATION_TYPE,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "relatedRegulations";
        final String                     end1AttributeDescription     = "Regulations that require this type of certification.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REGULATION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "requiredCertifications";
        final String                     end2AttributeDescription     = "The certifications required by this regulation.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CERTIFICATION_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * ========================================
     * AREA 5: standards
     */


    /**
     * Area 5 covers information architecture models and schemas.
     */
    private void addArea5Types()
    {
        this.add0501SchemaElements();
        this.add0503AssetSchemas();
        this.add0504ImplementationSnippets();
        this.add0505SchemaAttributes();
        this.add0511SchemaMapElements();
        this.add0530TabularSchemas();
        this.add0531DocumentSchemas();
        this.add0532ObjectSchemas();
        this.add0533GraphSchemas();
        this.add0534RelationalSchemas();
        this.add0535EventSchemas();
        this.add0536APISchemas();
        this.add0540DataClasses();
        this.add0545ReferenceData();
        this.add0565DesignModelElements();
        this.add0566DesignModelOrganization();
        this.add0568DesignModelScoping();
        this.add0569DesignModelImplementation();
        this.add0570MetaModel();
        this.add0571ConceptModels();
        this.add0595DesignPatterns();
        this.add0598LineageRelationships();
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0501 Schema Elements define the structure of data is described by a schema.  Schemas are nested structures
     * of schema elements.
     */
    private void add0501SchemaElements()
    {
        this.archiveBuilder.addEntityDef(getSchemaElementEntity());
        this.archiveBuilder.addEntityDef(getSchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getSchemaTypeChoiceEntity());
        this.archiveBuilder.addEntityDef(getLiteralSchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getSimpleSchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getPrimitiveSchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getEnumSchemaTypeEntity());
        this.archiveBuilder.addRelationshipDef(getSchemaTypeOptionRelationship());
    }


    private EntityDef getSchemaElementEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.SCHEMA_ELEMENT,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getSchemaTypeEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.SCHEMA_TYPE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ELEMENT.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAMESPACE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.VERSION_NUMBER));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.AUTHOR));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ENCODING_STANDARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.USAGE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getSchemaTypeChoiceEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.SCHEMA_TYPE_CHOICE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName));
    }


    private EntityDef getLiteralSchemaTypeEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.LITERAL_SCHEMA_TYPE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DATA_TYPE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.FIXED_VALUE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getSimpleSchemaTypeEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.SIMPLE_SCHEMA_TYPE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DATA_TYPE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DEFAULT_VALUE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getPrimitiveSchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.PRIMITIVE_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SIMPLE_SCHEMA_TYPE.typeName));
    }


    private EntityDef getEnumSchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.ENUM_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SIMPLE_SCHEMA_TYPE.typeName));
    }


    private RelationshipDef getSchemaTypeOptionRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.SCHEMA_TYPE_OPTION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "schemaOptionalUses";
        final String                     end1AttributeDescription     = "Potential place where this schema type is used.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE_CHOICE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "schemaOptions";
        final String                     end2AttributeDescription     = "Possible structure of the content of this element.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0503 Asset Schemas shows how assets are linked to schemas
     */
    private void add0503AssetSchemas()
    {
        this.archiveBuilder.addRelationshipDef(getAssetSchemaTypeRelationship());
    }


    private RelationshipDef getAssetSchemaTypeRelationship()
    {
       RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ASSET_SCHEMA_TYPE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "describesAssets";
        final String                     end1AttributeDescription     = "Asset that conforms to the schema type.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "schema";
        final String                     end2AttributeDescription     = "Structure of the content of this asset.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0504 Implementation snippets enable code fragments defining data structures to be linked with the
     * relevant schema to show how the schema should be implemented.
     */
    private void add0504ImplementationSnippets()
    {
        this.archiveBuilder.addEntityDef(getImplementationSnippetEntity());

        this.archiveBuilder.addRelationshipDef(getSchemaTypeImplementationRelationship());
    }


    private EntityDef getImplementationSnippetEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.IMPLEMENTATION_SNIPPET,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SNIPPET));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IMPLEMENTATION_LANGUAGE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.USAGE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CURATOR));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getSchemaTypeImplementationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.SCHEMA_TYPE_IMPLEMENTATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "implementationSchemaTypes";
        final String                     end1AttributeDescription     = "Logical structure for the data.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ELEMENT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "implementations";
        final String                     end2AttributeDescription     = "Concrete implementation of the schema type.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PROCESS.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0505 Schema Attributes begins to fill out the structure of a schema.
     */
    private void add0505SchemaAttributes()
    {
        this.archiveBuilder.addEnumDef(getDataItemSortOrderEnum());

        this.archiveBuilder.addEntityDef(getSchemaAttributeEntity());
        this.archiveBuilder.addEntityDef(getComplexSchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getStructSchemaTypeEntity());

        this.archiveBuilder.addRelationshipDef(getAttributeForSchemaRelationship());
        this.archiveBuilder.addRelationshipDef(getSchemaAttributeTypeRelationship());
        this.archiveBuilder.addRelationshipDef(getNestedSchemaAttributeRelationship());

        this.archiveBuilder.addClassificationDef(getTypeEmbeddedAttributeClassification());
    }

    private EnumDef getDataItemSortOrderEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(DataItemSortOrder.getOpenTypeGUID(),
                                                        DataItemSortOrder.getOpenTypeName(),
                                                        DataItemSortOrder.getOpenTypeDescription(),
                                                        DataItemSortOrder.getOpenTypeDescriptionGUID(),
                                                        DataItemSortOrder.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (DataItemSortOrder enumValues : DataItemSortOrder.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getSchemaAttributeEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ELEMENT.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.POSITION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MIN_CARDINALITY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MAX_CARDINALITY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ALLOWS_DUPLICATE_VALUES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ORDERED_VALUES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NATIVE_CLASS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ALIASES));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.SORT_ORDER));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getComplexSchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.COMPLEX_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName));
    }


    private EntityDef getStructSchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.STRUCT_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.COMPLEX_SCHEMA_TYPE.typeName));
    }


    private RelationshipDef getAttributeForSchemaRelationship()
    {
         RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ATTRIBUTE_FOR_SCHEMA_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "parentSchemas";
        final String                     end1AttributeDescription     = "Schema types using this attribute.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.COMPLEX_SCHEMA_TYPE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "attributes";
        final String                     end2AttributeDescription     = "The attributes defining the internal structure of the schema type.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getSchemaAttributeTypeRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.SCHEMA_ATTRIBUTE_TYPE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "usedInSchemas";
        final String                     end1AttributeDescription     = "Occurrences of this schema type in other schemas.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "type";
        final String                     end2AttributeDescription     = "The structure of this attribute.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getNestedSchemaAttributeRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.NESTED_SCHEMA_ATTRIBUTE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "parentAttribute";
        final String                     end1AttributeDescription     = "Schema attribute containing this attribute.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "nestedAttributes";
        final String                     end2AttributeDescription     = "The attributes defining the internal structure of the parent attribute.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private ClassificationDef getTypeEmbeddedAttributeClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.TYPE_EMBEDDED_ATTRIBUTE_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ENCODING_STANDARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DATA_TYPE));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }




    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0511 Schema Map Elements defines how a map element is recorded in a schema.
     */
    private void add0511SchemaMapElements()
    {
        this.archiveBuilder.addEntityDef(getMapSchemaTypeEntity());

        this.archiveBuilder.addRelationshipDef(getMapFromElementTypeRelationship());
        this.archiveBuilder.addRelationshipDef(getMapToElementTypeRelationship());
    }


    private EntityDef getMapSchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.MAP_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName));
    }


    private RelationshipDef getMapFromElementTypeRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.MAP_FROM_ELEMENT_TYPE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "parentMapFrom";
        final String                     end1AttributeDescription     = "Used in map.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.MAP_SCHEMA_TYPE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "mapFromElement";
        final String                     end2AttributeDescription     = "Key for this attribute.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getMapToElementTypeRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.MAP_TO_ELEMENT_TYPE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "parentMapTo";
        final String                     end1AttributeDescription     = "Used in map.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.MAP_SCHEMA_TYPE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "mapToElement";
        final String                     end2AttributeDescription     = "Value for this map.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0530 describes table oriented schemas such as spreadsheets
     */
    private void add0530TabularSchemas()
    {
        this.archiveBuilder.addEntityDef(getTabularSchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getTabularColumnEntity());
    }


    private EntityDef getTabularSchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.TABULAR_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.COMPLEX_SCHEMA_TYPE.typeName));
    }


    private EntityDef getTabularColumnEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.TABULAR_COLUMN,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName));
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0531 Document Schema provide specialized entities for describing document oriented schemas such as JSON
     */
    private void add0531DocumentSchemas()
    {
        this.archiveBuilder.addEntityDef(getDocumentSchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getDocumentSchemaAttributeEntity());
    }


    private EntityDef getDocumentSchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DOCUMENT_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.COMPLEX_SCHEMA_TYPE.typeName));
    }


    private EntityDef getDocumentSchemaAttributeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DOCUMENT_SCHEMA_ATTRIBUTE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName));
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0532 Object Schemas provides the specialized entity for an object schema.
     */
    private void add0532ObjectSchemas()
    {
        this.archiveBuilder.addEntityDef(getObjectSchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getObjectAttributeEntity());
    }


    private EntityDef getObjectSchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.OBJECT_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.COMPLEX_SCHEMA_TYPE.typeName));
    }


    private EntityDef getObjectAttributeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.OBJECT_ATTRIBUTE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName));
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0533GraphSchemas()
    {
        this.archiveBuilder.addEntityDef(getGraphSchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getGraphVertexEntity());
        this.archiveBuilder.addEntityDef(getGraphEdgeEntity());

        this.archiveBuilder.addRelationshipDef(getGraphEdgeLinkRelationship());

    }


    private EntityDef getGraphSchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GRAPH_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName));
    }


    private EntityDef getGraphVertexEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GRAPH_VERTEX,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName));
    }


    private EntityDef getGraphEdgeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.GRAPH_EDGE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName));
    }


    private RelationshipDef getGraphEdgeLinkRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.GRAPH_EDGE_LINK_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "edges";
        final String                     end1AttributeDescription     = "Edges for this vertex.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GRAPH_EDGE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "vertices";
        final String                     end2AttributeDescription     = "Vertices for this edge.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.GRAPH_VERTEX.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.LINK_TYPE_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RELATIONSHIP_END));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RELATIONSHIP_END_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MIN_CARDINALITY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MAX_CARDINALITY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ADDITIONAL_PROPERTIES));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0534 Relational Schemas extend the tabular schemas to describe a relational database.
     */
    private void add0534RelationalSchemas()
    {
        this.archiveBuilder.addEntityDef(getRelationalDBSchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getRelationalTableTypeEntity());
        this.archiveBuilder.addEntityDef(getRelationalTableEntity());
        this.archiveBuilder.addEntityDef(getRelationalColumnEntity());

        this.archiveBuilder.addClassificationDef(getPrimaryKeyClassification());

        this.archiveBuilder.addRelationshipDef(getForeignKeyRelationship());
    }


    private EntityDef getRelationalDBSchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.RELATIONAL_DB_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.COMPLEX_SCHEMA_TYPE.typeName));
    }


    private EntityDef getRelationalTableTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.RELATIONAL_TABLE_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.TABULAR_SCHEMA_TYPE.typeName));
    }


    private EntityDef getRelationalTableEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.RELATIONAL_TABLE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName));
    }


    private EntityDef getRelationalColumnEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.RELATIONAL_COLUMN,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.TABULAR_COLUMN.typeName));
    }


    private ClassificationDef getPrimaryKeyClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.PRIMARY_KEY_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.RELATIONAL_COLUMN.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.KEY_PATTERN));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    private RelationshipDef getForeignKeyRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.FOREIGN_KEY_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "primaryKey";
        final String                     end1AttributeDescription     = "Relational column holding the primary key.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.RELATIONAL_COLUMN.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);

        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "foreignKey";
        final String                     end2AttributeDescription     = "Use of primary key from another table to enable table joins.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.RELATIONAL_COLUMN.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0535 Event Schemas describes event/message structures
     */
    private void add0535EventSchemas()
    {
        this.archiveBuilder.addEntityDef(getEventSetEntity());
        this.archiveBuilder.addEntityDef(getEventTypeEntity());
    }


    private EntityDef getEventSetEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.EVENT_SET,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.COLLECTION.typeName));
    }


    private EntityDef getEventTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.EVENT_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.COMPLEX_SCHEMA_TYPE.typeName));
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0536 API schemas define the structure of an API
     */
    private void add0536APISchemas()
    {
        this.archiveBuilder.addEntityDef(getAPISchemaTypeEntity());
        this.archiveBuilder.addEntityDef(getAPIOperationSchemaEntity());

        this.archiveBuilder.addRelationshipDef(getAPIOperationsRelationship());
        this.archiveBuilder.addRelationshipDef(getAPIHeaderRelationship());
        this.archiveBuilder.addRelationshipDef(getAPIRequestRelationship());
        this.archiveBuilder.addRelationshipDef(getAPIResponseRelationship());
    }


    private EntityDef getAPISchemaTypeEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.API_SCHEMA_TYPE,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName));
    }


    private EntityDef getAPIOperationSchemaEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.API_OPERATION,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName));
    }


    private RelationshipDef getAPIOperationsRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.API_OPERATIONS_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "usedInAPI";
        final String                     end1AttributeDescription     = "API that this operation belongs to.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.API_SCHEMA_TYPE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "containsOperations";
        final String                     end2AttributeDescription     = "Operations for this API type.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.API_OPERATION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getAPIHeaderRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.API_HEADER_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "usedAsAPIHeader";
        final String                     end1AttributeDescription     = "API operations using this structure as the header.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.API_OPERATION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "apiHeader";
        final String                     end2AttributeDescription     = "Header structure for this API operation.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getAPIRequestRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.API_REQUEST_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "usedAsAPIRequest";
        final String                     end1AttributeDescription     = "API operations using this structure as the request body.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.API_OPERATION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "apiRequest";
        final String                     end2AttributeDescription     = "Request structure for this API operation.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getAPIResponseRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.API_RESPONSE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "usedAsAPIResponse";
        final String                     end1AttributeDescription     = "API operations using this structure as the response.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.API_OPERATION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "apiResponse";
        final String                     end2AttributeDescription     = "Response structure for this API operation.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0540 Data Class definitions
     */
    private void add0540DataClasses()
    {
        this.archiveBuilder.addEnumDef(getDataClassAssignmentStatusEnum());

        this.archiveBuilder.addEntityDef(getDataClassEntity());

        this.archiveBuilder.addRelationshipDef(getDataClassHierarchyRelationship());
        this.archiveBuilder.addRelationshipDef(getDataClassCompositionRelationship());
        this.archiveBuilder.addRelationshipDef(getDataClassAssignmentRelationship());

    }


    private EnumDef getDataClassAssignmentStatusEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(DataClassAssignmentStatus.getOpenTypeGUID(),
                                                        DataClassAssignmentStatus.getOpenTypeName(),
                                                        DataClassAssignmentStatus.getOpenTypeDescription(),
                                                        DataClassAssignmentStatus.getOpenTypeDescriptionGUID(),
                                                        DataClassAssignmentStatus.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (CriticalityLevel enumValues : CriticalityLevel.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValues.getOrdinal(),
                                                         enumValues.getName(),
                                                         enumValues.getDescription(),
                                                         enumValues.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValues.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getDataClassEntity()
    {
       EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.DATA_CLASS,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAMESPACE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CLASS_CODE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.USER_DEFINED));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SPECIFICATION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SPECIFICATION_DETAILS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DATA_TYPE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DEFAULT_THRESHOLD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DEFAULT_VALUE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SAMPLE_VALUES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DATA_PATTERNS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME_PATTERNS));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getDataClassHierarchyRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.DATA_CLASS_HIERARCHY,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "superDataClass";
        final String                     end1AttributeDescription     = "Data class that is the more abstract.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_CLASS.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "subDataClasses";
        final String                     end2AttributeDescription     = "Data classes that are more concrete.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_CLASS.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getDataClassCompositionRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.DATA_CLASS_COMPOSITION,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "partOfDataClasses";
        final String                     end1AttributeDescription     = "Data classes that includes other data classes in its definition.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_CLASS.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "madeOfDataClasses";
        final String                     end2AttributeDescription     = "Data classes that provide part of another data class's definitions.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_CLASS.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getDataClassAssignmentRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.DATA_CLASS_ASSIGNMENT,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "elementsAssignedToDataClass";
        final String                     end1AttributeDescription     = "Elements identified as managing data values that match the specification of a data class.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "dataClassesAssignedToElement";
        final String                     end2AttributeDescription     = "Logical data type for this element.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_CLASS.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.METHOD));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.DATA_CLASS_ASSIGNMENT_STATUS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PARTIAL_MATCH));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.THRESHOLD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.VALUE_FREQUENCY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOURCE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0545ReferenceData()
    {
        this.archiveBuilder.addClassificationDef(getReferenceDataClassification());

        this.archiveBuilder.addEntityDef(getValidValueDefinitionEntity());
        this.archiveBuilder.addEntityDef(getValidValuesSetEntity());

        this.archiveBuilder.addRelationshipDef(getValidValuesAssignmentRelationship());
        this.archiveBuilder.addRelationshipDef(getValidValuesMemberRelationship());
        this.archiveBuilder.addRelationshipDef(getValidValuesImplementationRelationship());
    }

    private ClassificationDef getReferenceDataClassification()
    {
        return archiveHelper.getClassificationDef(OpenMetadataType.REFERENCE_DATA_CLASSIFICATION,
                                                  null,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName),
                                                  false);
    }


    private EntityDef getValidValueDefinitionEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.VALID_VALUE_DEFINITION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.USAGE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SCOPE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PREFERRED_VALUE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getValidValuesSetEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.VALID_VALUE_SET,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.VALID_VALUE_DEFINITION.typeName));
    }


    private RelationshipDef getValidValuesAssignmentRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.VALID_VALUES_ASSIGNMENT_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "validValuesConsumer";
        final String                     end1AttributeDescription     = "The valid values set that this element belongs to.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "validValues";
        final String                     end2AttributeDescription     = "A definition of the valid values for this element.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.VALID_VALUE_DEFINITION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STRICT_REQUIREMENT));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getValidValuesMemberRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.VALID_VALUE_MEMBER_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "validValuesSet";
        final String                     end1AttributeDescription     = "The valid values set that this element belongs to.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.VALID_VALUE_SET.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "memberOfValidValuesSet";
        final String                     end2AttributeDescription     = "Description of a single valid value.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.VALID_VALUE_DEFINITION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    private RelationshipDef getValidValuesImplementationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.VALID_VALUES_IMPL_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "validValues";
        final String                     end1AttributeDescription     = "The valid values set that this element implements.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.VALID_VALUE_DEFINITION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "validValuesImplementation";
        final String                     end2AttributeDescription     = "The asset where the valid values are implemented.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.IMPLEMENTATION_VALUE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }




    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0565DesignModelElements()
    {
        this.archiveBuilder.addEntityDef(getDesignModelElementEntity());
    }


    private EntityDef getDesignModelElementEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.DESIGN_MODEL_ELEMENT,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TECHNICAL_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.VERSION_NUMBER));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.AUTHOR));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0566DesignModelOrganization()
    {
        this.archiveBuilder.addEntityDef(getDesignModelEntity());
        this.archiveBuilder.addEntityDef(getDesignModelGroupEntity());

        this.archiveBuilder.addRelationshipDef(getDesignModelGroupMembershipRelationship());
    }


    private EntityDef getDesignModelEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.DESIGN_MODEL,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TECHNICAL_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.VERSION_NUMBER));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.AUTHOR));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getDesignModelGroupEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DESIGN_MODEL_GROUP,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DESIGN_MODEL_ELEMENT.typeName));
    }


    private RelationshipDef getDesignModelGroupMembershipRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.DESIGN_MODEL_GROUP_MEMBERSHIP_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "memberOfModelGroups";
        final String                     end1AttributeDescription     = "Link to a list of groups this element is a member of.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DESIGN_MODEL_GROUP.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "elementsInGroup";
        final String                     end2AttributeDescription     = "List of elements that belong to this group.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DESIGN_MODEL_ELEMENT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0568DesignModelScoping()
    {
        this.archiveBuilder.addEntityDef(getDesignModelScopeEntity());
        this.archiveBuilder.addRelationshipDef(getDesignModelElementsInScopeRelationship());
    }


    private EntityDef getDesignModelScopeEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.DESIGN_MODEL_SCOPE,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DISPLAY_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.TECHNICAL_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.VERSION_NUMBER));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.AUTHOR));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getDesignModelElementsInScopeRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.DESIGN_MODEL_ELEMENTS_IN_SCOPE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 2.
         */
        final String                     end1AttributeName            = "usedInScope";
        final String                     end1AttributeDescription     = "Link to a scope where this element is used.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DESIGN_MODEL_SCOPE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);


        /*
         * Set up end 1.
         */
        final String                     end2AttributeName            = "inScopeModelElements";
        final String                     end2AttributeDescription     = "List of elements that belong to this scope.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DESIGN_MODEL_ELEMENT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0569DesignModelImplementation()
    {
        this.archiveBuilder.addRelationshipDef(geDesignModelImplementationRelationship());
    }


    private RelationshipDef geDesignModelImplementationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.DESIGN_MODEL_IMPLEMENTATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "implementationFollowingModel";
        final String                     end1AttributeDescription     = "Definition of an implementation of the model.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "modelDescribingBehavior";
        final String                     end2AttributeDescription     = "Descriptive abstraction.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DESIGN_MODEL_ELEMENT.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0570MetaModel()
    {
        this.archiveBuilder.addClassificationDef(getMetamodelClassification());
    }


    private ClassificationDef getMetamodelClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.METAMODEL_INSTANCE_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DESIGN_MODEL_ELEMENT.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.METAMODEL_ELEMENT_GUID));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0571ConceptModels()
    {
        this.archiveBuilder.addEnumDef(getConceptModelAttributeCoverageCategoryEnum());
        this.archiveBuilder.addEnumDef(getConceptModelDecorationEnum());

        this.archiveBuilder.addEntityDef(getConceptModelElementEntity());
        this.archiveBuilder.addEntityDef(getConceptBeadEntity());
        this.archiveBuilder.addEntityDef(getConceptBeadLinkEntity());
        this.archiveBuilder.addEntityDef(getConceptBeadAttributeEntity());

        this.archiveBuilder.addRelationshipDef(getConceptBeadRelationshipEndRelationship());
        this.archiveBuilder.addRelationshipDef(getConceptBeadAttributeLinkRelationship());

        this.archiveBuilder.addClassificationDef(getConceptBeadAttributeCoverageClassification());
    }


    private EnumDef getConceptModelAttributeCoverageCategoryEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(ConceptModelAttributeCoverageCategory.getOpenTypeGUID(),
                                                        ConceptModelAttributeCoverageCategory.getOpenTypeName(),
                                                        ConceptModelAttributeCoverageCategory.getOpenTypeDescription(),
                                                        ConceptModelAttributeCoverageCategory.getOpenTypeDescriptionGUID(),
                                                        ConceptModelAttributeCoverageCategory.getOpenTypeDescriptionWiki());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (ConceptModelAttributeCoverageCategory enumValue : ConceptModelAttributeCoverageCategory.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EnumDef getConceptModelDecorationEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(ConceptModelDecoration.getOpenTypeGUID(),
                                                        ConceptModelDecoration.getOpenTypeName(),
                                                        ConceptModelDecoration.getOpenTypeDescription(),
                                                        ConceptModelDecoration.getOpenTypeDescriptionGUID());

        ArrayList<EnumElementDef> elementDefs = new ArrayList<>();
        EnumElementDef            elementDef;

        for (ConceptModelDecoration enumValue : ConceptModelDecoration.values())
        {
            elementDef = archiveHelper.getEnumElementDef(enumValue.getOrdinal(),
                                                         enumValue.getName(),
                                                         enumValue.getDescription(),
                                                         enumValue.getDescriptionGUID());

            elementDefs.add(elementDef);

            if (enumValue.isDefault())
            {
                enumDef.setDefaultValue(elementDef);
            }
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getConceptModelElementEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.CONCEPT_MODEL_ELEMENT,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DESIGN_MODEL_ELEMENT.typeName));
    }


    private EntityDef getConceptBeadEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.CONCEPT_BEAD,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.CONCEPT_MODEL_ELEMENT.typeName));
    }


    private EntityDef getConceptBeadLinkEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.CONCEPT_BEAD_LINK,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.CONCEPT_MODEL_ELEMENT.typeName));
    }


    private EntityDef getConceptBeadAttributeEntity()
    {
        return  archiveHelper.getDefaultEntityDef(OpenMetadataType.CONCEPT_BEAD_ATTRIBUTE,
                                                  this.archiveBuilder.getEntityDef(OpenMetadataType.CONCEPT_MODEL_ELEMENT.typeName));
    }


    private RelationshipDef getConceptBeadRelationshipEndRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.CONCEPT_BEAD_RELATIONSHIP_END,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "relationships";
        final String                     end1AttributeDescription     = "The relationships that the concept bead can be a part of.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CONCEPT_BEAD_LINK.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "endBeads";
        final String                     end2AttributeDescription     = "The concept beads that are linked via this relationship.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CONCEPT_BEAD.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ATTRIBUTE_NAME));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.DECORATION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.POSITION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MIN_CARDINALITY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MAX_CARDINALITY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.UNIQUE_VALUES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ORDERED_VALUES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NAVIGABLE));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private RelationshipDef getConceptBeadAttributeLinkRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.CONCEPT_BEAN_ATTRIBUTE_LINK,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "parentBead";
        final String                     end1AttributeDescription     = "Concept bead that this attribute belongs to.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CONCEPT_BEAD.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "attributes";
        final String                     end2AttributeDescription     = "Attribute detail for the concept bead.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.CONCEPT_BEAD_ATTRIBUTE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.POSITION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MIN_CARDINALITY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MAX_CARDINALITY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.UNIQUE_VALUES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ORDERED_VALUES));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private ClassificationDef getConceptBeadAttributeCoverageClassification()
    {
        ClassificationDef classificationDef = archiveHelper.getClassificationDef(OpenMetadataType.CONCEPT_BEAD_ATTRIBUTE_COVERAGE_CLASSIFICATION,
                                                                                 null,
                                                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.CONCEPT_BEAD_ATTRIBUTE.typeName),
                                                                                 false);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.COVERAGE_CATEGORY));

        classificationDef.setPropertiesDefinition(properties);

        return classificationDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    private void add0595DesignPatterns()
    {
        this.archiveBuilder.addEntityDef(getDesignPatternEntity());

        this.archiveBuilder.addRelationshipDef(getRelatedPatternRelationship());

    }


    private EntityDef getDesignPatternEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.DESIGN_PATTERN,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONTEXT));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.FORCES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROBLEM_STATEMENT));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROBLEM_EXAMPLE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOLUTION_DESCRIPTION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SOLUTION_EXAMPLE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.BENEFITS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.LIABILITIES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getRelatedPatternRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.RELATED_DESIGN_PATTERN_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "relatedDesignPattern";
        final String                     end1AttributeDescription     = "Another design pattern that operates in similar contexts.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DESIGN_PATTERN.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "relatedDesignPattern";
        final String                     end2AttributeDescription     = "Another design pattern that operates in similar contexts.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.DESIGN_PATTERN.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.DESCRIPTION));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    private void add0598LineageRelationships()
    {

        this.archiveBuilder.addRelationshipDef(getPortSchemaRelationship());
        this.archiveBuilder.addRelationshipDef(getLineageMappingRelationship());
    }

    /**
     * The PortSchema relationship describes the link between a Port and the SchemaType linked to the Port
     * @return PortSchema RelationshipDef
     */
    private RelationshipDef getPortSchemaRelationship()
    {
        /*
         * Build the relationship
         */
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.PORT_SCHEMA_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "port";
        final String                     end1AttributeDescription     = "Port";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.PORT.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "schemaType";
        final String                     end2AttributeDescription     = "Schema Type";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);


        return relationshipDef;
    }

    /**
     *  The LineageMapping relationship describes the directional mapping between SchemaTypes
     * @return LineageMapping RelationshipDef
     */
    private RelationshipDef getLineageMappingRelationship()
    {
        /*
         * Build the relationship
         */
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.LINEAGE_MAPPING_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "sourceElement";
        final String                     end1AttributeDescription     = "Source Attribute.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "targetElement";
        final String                     end2AttributeDescription     = "Target Attribute.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ATTRIBUTE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);


        return relationshipDef;
    }


    /*
     * ========================================
     * AREA 6: metadata discovery
     */

    /**
     * Area 6 are the types for the discovery server (and discovery pipelines
     * supporting the Open Discovery Framework (ODF)).
     */
    private void addArea6Types()
    {
        this.add0610Annotations();
        this.add0612AnnotationReviews();
        this.add0615SchemaExtraction();
        this.add0617DataFieldAnalysis();
        this.add0620DataProfiling();
        this.add0625DataClassDiscovery();
        this.add0630SemanticDiscovery();
        this.add0635ClassificationDiscovery();
        this.add0640QualityScores();
        this.add0650RelationshipDiscovery();
        this.add0660ResourceMeasures();
        this.add0690RequestForAction();

    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0610 Annotations describes the basic structure of an annotation created by a discovery service.
     */
    private void add0610Annotations()
    {
        this.archiveBuilder.addEntityDef(getAnnotationEntity());
        this.archiveBuilder.addRelationshipDef(getAnnotationExtensionRelationship());
    }


    private EntityDef getAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.ANNOTATION,
                                                                null);
        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ANNOTATION_TYPE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SUMMARY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE_LEVEL));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPLANATION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ANALYSIS_STEP));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.JSON_PROPERTIES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ADDITIONAL_PROPERTIES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getAnnotationExtensionRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ANNOTATION_EXTENSION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "extendedAnnotations";
        final String                     end1AttributeDescription     = "The annotations being extended.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ANNOTATION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "annotationExtensions";
        final String                     end2AttributeDescription     = "The annotations providing additional information.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ANNOTATION.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0612 Annotation Review defines the outcome of a stewardship review of the annotations in a discovery
     * analysis report.
     */
    private void add0612AnnotationReviews()
    {
        this.archiveBuilder.addEnumDef(getAnnotationStatusEnum());

        this.archiveBuilder.addEntityDef(getAnnotationReviewEntity());

        this.archiveBuilder.addRelationshipDef(getAnnotationReviewLinkRelationship());
    }


    private EnumDef getAnnotationStatusEnum()
    {
        EnumDef enumDef = archiveHelper.getEmptyEnumDef(AnnotationStatus.getOpenTypeGUID(),
                                                        AnnotationStatus.getOpenTypeName(),
                                                        AnnotationStatus.getOpenTypeDescription(),
                                                        AnnotationStatus.getOpenTypeDescriptionGUID(),
                                                        AnnotationStatus.getOpenTypeDescriptionWiki());

        List<EnumElementDef> elementDefs = new ArrayList<>();

        for (AnnotationStatus annotationStatus : AnnotationStatus.values())
        {
            elementDefs.add(archiveHelper.getEnumElementDef(annotationStatus.getOrdinal(),
                                                            annotationStatus.getName(),
                                                            annotationStatus.getDescription(),
                                                            annotationStatus.getDescriptionGUID()));
        }

        enumDef.setElementDefs(elementDefs);

        return enumDef;
    }


    private EntityDef getAnnotationReviewEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.ANNOTATION_REVIEW,
                                                                null);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.REVIEW_DATE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.STEWARD));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.COMMENT));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getAnnotationReviewLinkRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.ANNOTATION_REVIEW_LINK_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "reviewedAnnotations";
        final String                     end1AttributeDescription     = "The annotations being reviewed.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ANNOTATION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "annotationReviews";
        final String                     end2AttributeDescription     = "The feedback about the annotations.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ANNOTATION_REVIEW.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.ANNOTATION_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0615 Schema Extraction creates an annotation to describe a nested schema.
     */
    private void add0615SchemaExtraction()
    {
        this.archiveBuilder.addEntityDef(getSchemaAnalysisAnnotationEntity());
        this.archiveBuilder.addRelationshipDef(getDiscoveredSchemaTypeRelationship());
    }

    private EntityDef getSchemaAnalysisAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.SCHEMA_ANALYSIS_ANNOTATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.ANNOTATION.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SCHEMA_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SCHEMA_TYPE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getDiscoveredSchemaTypeRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.DISCOVERED_SCHEMA_TYPE_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "discoveringAnnotation";
        final String                     end1AttributeDescription     = "The analyser of the schema type.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_ANALYSIS_ANNOTATION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "discoveredSchema";
        final String                     end2AttributeDescription     = "Discovered schema structure.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.SCHEMA_TYPE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0617 Data Field Analysis defines the structures to record the individual data fields found in an asset.
     */
    private void add0617DataFieldAnalysis()
    {
        this.archiveBuilder.addEntityDef(getDataFieldAnnotationEntity());
    }


    private EntityDef getDataFieldAnnotationEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.DATA_FIELD_ANNOTATION,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.ANNOTATION.typeName));
    }

    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0620 Profiling describes an annotation that can be attached to a column to describe the profile of its
     * values.
     */
    private void add0620DataProfiling()
    {
        this.archiveBuilder.addEntityDef(getDataProfileAnnotationEntity());
        this.archiveBuilder.addEntityDef(getResourceProfileLogAnnotationEntity());

        this.archiveBuilder.addRelationshipDef(getResourceProfileLogFileRelationship());

    }


    private EntityDef getDataProfileAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.RESOURCE_PROFILE_ANNOTATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FIELD_ANNOTATION.typeName));
        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.LENGTH));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.INFERRED_DATA_TYPE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.INFERRED_FORMAT));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.INFERRED_LENGTH));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.INFERRED_PRECISION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.INFERRED_SCALE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROFILE_PROPERTIES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROFILE_FLAGS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROFILE_COUNTS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.VALUE_LIST));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.VALUE_COUNT));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.VALUE_RANGE_FROM));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.VALUE_RANGE_TO));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.AVERAGE_VALUE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROFILE_DOUBLES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROFILE_START_DATE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROFILE_END_DATE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROFILE_DATES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.PROFILE_PROPERTY_NAMES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getResourceProfileLogAnnotationEntity()
    {
        return archiveHelper.getDefaultEntityDef(OpenMetadataType.RESOURCE_PROFILE_LOG_ANNOTATION,
                                                 this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FIELD_ANNOTATION.typeName));
    }


    private RelationshipDef getResourceProfileLogFileRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.RESOURCE_PROFILE_DATA_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "resourceProfileAnnotations";
        final String                     end1AttributeDescription     = "The annotations that refer to this log file.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.RESOURCE_PROFILE_LOG_ANNOTATION.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "resourceProfileLogs";
        final String                     end2AttributeDescription     = "Location of the profile information.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.ASSET.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef2(relationshipEndDef);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0625 Data Class Discovery records potential data classes that match the data field, and the level of
     * error in the match.
     */
    private void add0625DataClassDiscovery()
    {
        this.archiveBuilder.addEntityDef(getDataClassAnnotationEntity());
    }


    private EntityDef getDataClassAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.DATA_CLASS_ANNOTATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FIELD_ANNOTATION.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CANDIDATE_DATA_CLASS_GUIDS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.MATCHING_VALUES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.NON_MATCHING_VALUES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0630 Semantic Discovery describes an annotation for a candidate glossary term assignment for a data element.
     */
    private void add0630SemanticDiscovery()
    {
        this.archiveBuilder.addEntityDef(getSemanticAnnotationEntity());
    }

    private EntityDef getSemanticAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.SEMANTIC_ANNOTATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FIELD_ANNOTATION.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.INFORMAL_TERM));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CANDIDATE_GLOSSARY_TERM_GUIDS));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.INFORMAL_CATEGORY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CANDIDATE_GLOSSARY_CATEGORY_GUIDS));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0635 Classification Discovery creates a base class for a classification annotation.
     */
    private void add0635ClassificationDiscovery()
    {
        this.archiveBuilder.addEntityDef(getClassificationAnnotationEntity());
    }


    private EntityDef getClassificationAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.CLASSIFICATION_ANNOTATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FIELD_ANNOTATION.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CANDIDATE_CLASSIFICATIONS));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */

    /**
     * 0640 Quality Scores records quality analysis results.  Quality has many different dimensions and
     * the dimension that this score reflects is also recorded with the score.
     */
    private void add0640QualityScores()
    {
        this.archiveBuilder.addEntityDef(getQualityAnnotationEntity());
    }


    private EntityDef getQualityAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.QUALITY_ANNOTATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FIELD_ANNOTATION.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.QUALITY_DIMENSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.QUALITY_SCORE));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0650 Relationship Discovery provides a base annotation for describing a relationship between two referenceables.
     */
    private void add0650RelationshipDiscovery()
    {
        this.archiveBuilder.addEntityDef(getRelationshipAdviceAnnotationEntity());

        this.archiveBuilder.addRelationshipDef(getRelationshipAnnotationRelationship());
    }


    private EntityDef getRelationshipAdviceAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.RELATIONSHIP_ADVICE_ANNOTATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FIELD_ANNOTATION.typeName));
        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RELATIONSHIP_TYPE_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RELATIONSHIP_PROPERTIES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RELATED_ENTITY_GUID));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private RelationshipDef getRelationshipAnnotationRelationship()
    {
        RelationshipDef relationshipDef = archiveHelper.getBasicRelationshipDef(OpenMetadataType.RELATIONSHIP_ANNOTATION_RELATIONSHIP,
                                                                                null,
                                                                                ClassificationPropagationRule.NONE);

        RelationshipEndDef relationshipEndDef;

        /*
         * Set up end 1.
         */
        final String                     end1AttributeName            = "relatedFromObjectAnnotations";
        final String                     end1AttributeDescription     = "The referenceables linked from.";
        final String                     end1AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end1AttributeName,
                                                                 end1AttributeDescription,
                                                                 end1AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.ANY_NUMBER);
        relationshipDef.setEndDef1(relationshipEndDef);


        /*
         * Set up end 2.
         */
        final String                     end2AttributeName            = "relatedToObjectAnnotations";
        final String                     end2AttributeDescription     = "The referenceables linked to.";
        final String                     end2AttributeDescriptionGUID = null;

        relationshipEndDef = archiveHelper.getRelationshipEndDef(this.archiveBuilder.getEntityDef(OpenMetadataType.REFERENCEABLE.typeName),
                                                                 end2AttributeName,
                                                                 end2AttributeDescription,
                                                                 end2AttributeDescriptionGUID,
                                                                 RelationshipEndCardinality.AT_MOST_ONE);
        relationshipDef.setEndDef2(relationshipEndDef);

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ANNOTATION_TYPE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SUMMARY));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.CONFIDENCE_LEVEL));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPRESSION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.EXPLANATION));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ANALYSIS_STEP));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.JSON_PROPERTIES));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ADDITIONAL_PROPERTIES));
        properties.add(archiveHelper.getEnumTypeDefAttribute(OpenMetadataProperty.ANNOTATION_STATUS));

        relationshipDef.setPropertiesDefinition(properties);

        return relationshipDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0660 Data Source Measurements describe annotations that are measuring characteristics of a data source.
     * This may be a DataSet, DataFeed or DataSource.
     */
    private void add0660ResourceMeasures()
    {
        this.archiveBuilder.addEntityDef(getResourceMeasureAnnotationEntity());
        this.archiveBuilder.addEntityDef(getDataSourcePhysicalStatusAnnotationEntity());
    }


    private EntityDef getResourceMeasureAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.RESOURCE_MEASURE_ANNOTATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.ANNOTATION.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RESOURCE_PROPERTIES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    private EntityDef getDataSourcePhysicalStatusAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.RESOURCE_PHYSICAL_STATUS_ANNOTATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.RESOURCE_MEASURE_ANNOTATION.typeName));
        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RESOURCE_CREATE_TIME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.RESOURCE_UPDATE_TIME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.SIZE));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ENCODING));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }


    /*
     * -------------------------------------------------------------------------------------------------------
     */


    /**
     * 0690 Request for Action creates an annotation for requesting a stewardship or governance action.
     */
    private void add0690RequestForAction()
    {
        this.archiveBuilder.addEntityDef(getRequestForActionAnnotationEntity());
    }


    private EntityDef getRequestForActionAnnotationEntity()
    {
        EntityDef entityDef = archiveHelper.getDefaultEntityDef(OpenMetadataType.REQUEST_FOR_ACTION_ANNOTATION,
                                                                this.archiveBuilder.getEntityDef(OpenMetadataType.DATA_FIELD_ANNOTATION.typeName));

        /*
         * Build the attributes
         */
        List<TypeDefAttribute> properties = new ArrayList<>();

        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ACTION_SOURCE_NAME));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ACTION_REQUESTED));
        properties.add(archiveHelper.getTypeDefAttribute(OpenMetadataProperty.ACTION_PROPERTIES));

        entityDef.setPropertiesDefinition(properties);

        return entityDef;
    }
}
