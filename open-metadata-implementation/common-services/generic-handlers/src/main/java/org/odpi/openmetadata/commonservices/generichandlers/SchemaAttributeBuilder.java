/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.commonservices.generichandlers;

import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.openmetadata.enums.DataItemSortOrder;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataProperty;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.InvalidParameterException;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Classification;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.ClassificationOrigin;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProperties;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProvenanceType;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryHelper;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.TypeErrorException;

import java.util.List;
import java.util.Map;

/**
 * SchemaAttributeBuilder creates instance properties for a schema attribute.
 */
public class SchemaAttributeBuilder extends ReferenceableBuilder
{
    private String            displayName           = null;
    private String            description           = null;
    private int               elementPosition       = 0;
    private int               minCardinality        = 0;
    private int               maxCardinality        = 0;
    private boolean           isDeprecated          = false;
    private boolean           allowsDuplicateValues = false;
    private boolean           orderedValues         = false;
    private int               sortOrder             = 0;
    private int               minimumLength         = 0;
    private int     length     = 0;
    private int     precision  = 0;
    private boolean isNullable = true;
    private String            defaultValueOverride  = null;
    private String            nativeJavaClass       = null;
    private List<String>      aliases               = null;

    private SchemaTypeBuilder schemaTypeBuilder     = null;


    /**
     * Template constructor
     *
     * @param qualifiedName unique name
     * @param displayName new value for the display name
     * @param description description of the schema attribute
     * @param repositoryHelper helper methods
     * @param serviceName name of this OMAS
     * @param serverName name of local server
     */
    public SchemaAttributeBuilder(String               qualifiedName,
                                  String               displayName,
                                  String               description,
                                  OMRSRepositoryHelper repositoryHelper,
                                  String               serviceName,
                                  String               serverName)
    {
        super(qualifiedName,
              OpenMetadataType.SCHEMA_ATTRIBUTE.typeGUID,
              OpenMetadataType.SCHEMA_ATTRIBUTE.typeName,
              repositoryHelper,
              serviceName,
              serverName);

        this.displayName = displayName;
        this.description = description;
    }


    /**
     * Template constructor
     *
     * @param repositoryHelper helper methods
     * @param serviceName name of this OMAS
     * @param serverName name of local server
     */
    public SchemaAttributeBuilder(OMRSRepositoryHelper repositoryHelper,
                                  String               serviceName,
                                  String               serverName)
    {
        super(OpenMetadataType.SCHEMA_ATTRIBUTE.typeGUID,
              OpenMetadataType.SCHEMA_ATTRIBUTE.typeName,
              repositoryHelper,
              serviceName,
              serverName);
    }


    /**
     * Constructor supporting all properties for a schema attribute entity.
     *
     * @param qualifiedName unique name
     * @param displayName new value for the display name.
     * @param description new value for the description.
     * @param elementPosition position of the attribute in the parent schemaType.
     * @param minCardinality is the attribute optional?
     * @param maxCardinality does the attribute repeat?
     * @param isDeprecated is this element deprecated?
     * @param defaultValueOverride override for the Type's default value.
     * @param allowsDuplicateValues unique values ?
     * @param orderedValues ordered values ?
     * @param sortOrder sort order if ordered
     * @param minimumLength minimum length of data in field
     * @param length size of data field
     * @param precision Number of digits after the decimal point.
     * @param isNullable can the value be null?
     * @param nativeJavaClass name of implementation class for Java
     * @param aliases aliases for the field
     * @param additionalProperties additional properties
     * @param typeName name of the type for this schema element
     * @param typeId unique identifier of the type for this schema element
     * @param extendedProperties  properties from the subtype.
     * @param repositoryHelper helper methods
     * @param serviceName name of this OMAS
     * @param serverName name of local server
     */
    public SchemaAttributeBuilder(String               qualifiedName,
                                  String               displayName,
                                  String               description,
                                  int                  elementPosition,
                                  int                  minCardinality,
                                  int                  maxCardinality,
                                  boolean              isDeprecated,
                                  String               defaultValueOverride,
                                  boolean              allowsDuplicateValues,
                                  boolean              orderedValues,
                                  int                  sortOrder,
                                  int                  minimumLength,
                                  int                  length,
                                  int                  precision,
                                  boolean              isNullable,
                                  String               nativeJavaClass,
                                  List<String>         aliases,
                                  Map<String, String>  additionalProperties,
                                  String               typeId,
                                  String               typeName,
                                  Map<String, Object>  extendedProperties,
                                  OMRSRepositoryHelper repositoryHelper,
                                  String               serviceName,
                                  String               serverName)
    {
        super(qualifiedName,
              additionalProperties,
              typeId,
              typeName,
              extendedProperties,
              repositoryHelper,
              serviceName,
              serverName);

        this.displayName           = displayName;
        this.description           = description;
        this.elementPosition       = elementPosition;
        this.minCardinality        = minCardinality;
        this.maxCardinality        = maxCardinality;
        this.isDeprecated          = isDeprecated;
        this.defaultValueOverride  = defaultValueOverride;
        this.allowsDuplicateValues = allowsDuplicateValues;
        this.orderedValues         = orderedValues;
        this.sortOrder             = sortOrder;
        this.minimumLength         = minimumLength;
        this.length     = length;
        this.precision  = precision;
        this.isNullable = isNullable;
        this.nativeJavaClass       = nativeJavaClass;
        this.aliases               = aliases;
    }


    /**
     * The schema type can be stored in the TypeEmbeddedAttribute classification for the schema attribute entity.
     * Depending on the type of schema, the schema type may require additional entities and relationships.  The
     * schemaTypeBuilder has this knowledge which is why the schemaTypeBuilder is saved.
     * This method overrides any previously defined TypeEmbeddedAttribute classification for this entity.
     *
     * @param userId calling user
     * @param schemaTypeBuilder builder containing the properties of the schema type
     * @param methodName calling method
     * @throws InvalidParameterException TypeEmbeddedAttribute is not supported in the local repository, or any repository
     *                                   connected by an open metadata repository cohort
     */
    public void setSchemaType(String            userId,
                              SchemaTypeBuilder schemaTypeBuilder,
                              String            methodName) throws InvalidParameterException
    {
        this.schemaTypeBuilder = schemaTypeBuilder;

        try
        {
            Classification classification = repositoryHelper.getNewClassification(serviceName,
                                                                                  null,
                                                                                  null,
                                                                                  InstanceProvenanceType.LOCAL_COHORT,
                                                                                  userId,
                                                                                  OpenMetadataType.TYPE_EMBEDDED_ATTRIBUTE_CLASSIFICATION.typeName,
                                                                                  typeName,
                                                                                  ClassificationOrigin.ASSIGNED,
                                                                                  null,
                                                                                  schemaTypeBuilder.getTypeEmbeddedInstanceProperties(methodName));
            newClassifications.put(classification.getName(), classification);
        }
        catch (TypeErrorException error)
        {
            errorHandler.handleUnsupportedType(error, methodName, OpenMetadataType.TYPE_EMBEDDED_ATTRIBUTE_CLASSIFICATION.typeName);
        }
    }

    /**
     * Set up the "Anchors" classification for this entity.  This is used when a new entity is being created, and it is known to be
     * connected to a specific anchor.
     *
     * @param userId calling user
     * @param anchorGUID unique identifier of the anchor entity that this entity is linked to directly or indirectly
     * @param anchorTypeName unique name of the anchor entity's type
     * @param anchorDomainName unique name of the anchor entity's domain
     * @param anchorScopeGUID unique identifier of the anchor's scope
     * @param methodName calling method
     * @throws PropertyServerException a null anchors GUID has been supplied
     */
    public void setAnchors(String userId,
                           String anchorGUID,
                           String anchorTypeName,
                           String anchorDomainName,
                           String anchorScopeGUID,
                           String methodName) throws PropertyServerException
    {
        super.setAnchors(userId, anchorGUID, anchorTypeName, anchorDomainName, anchorScopeGUID, methodName);

        if (schemaTypeBuilder != null)
        {
            schemaTypeBuilder.setAnchors(userId, anchorGUID, anchorTypeName, anchorDomainName, anchorScopeGUID, methodName);
        }
    }

    /**
     * Return the schema type builder to the handler to add any extra elements.
     *
     * @return schema type builder object
     */
    public SchemaTypeBuilder getSchemaTypeBuilder()
    {
        return schemaTypeBuilder;
    }


    /**
     * Set up the CalculatedValue classification for this entity.
     * This method overrides any previously defined CalculatedValue classification for this entity.
     *
     * @param userId calling user
     * @param externalSourceGUID        guid of the software capability entity that represented the external source - null for local
     * @param externalSourceName        name of the software capability entity that represented the external source
     * @param formula                   details of how this value is calculated
     * @param methodName                calling method
     * @throws InvalidParameterException calculated value is not supported in the local repository, or any repository
     *                                   connected by an open metadata repository cohort
     */
    void setCalculatedValue(String userId,
                            String externalSourceGUID,
                            String externalSourceName,
                            String formula,
                            String methodName) throws InvalidParameterException
    {
        this.setCalculatedValue(userId, externalSourceGUID,externalSourceName, getCalculatedValueProperties(formula, methodName), methodName);
    }
    /**
     * Set up the CalculatedValue classification for this entity.
     * This method overrides any previously defined CalculatedValue classification for this entity.
     *
     * @param userId calling user
     * @param externalSourceGUID        guid of the software capability entity that represented the external source - null for local
     * @param externalSourceName        name of the software capability entity that represented the external source
     * @param instanceProperties        properties for the calculated value classification
     * @param methodName calling method
     * @throws InvalidParameterException calculated value is not supported in the local repository, or any repository
     *                                   connected by an open metadata repository cohort
     */
    void setCalculatedValue(String userId,
                            String externalSourceGUID,
                            String externalSourceName,
                            InstanceProperties instanceProperties,
                            String methodName) throws InvalidParameterException
    {
        try
        {
            InstanceProvenanceType instanceProvenanceType = InstanceProvenanceType.LOCAL_COHORT;

            if (externalSourceGUID != null)
            {
                instanceProvenanceType = InstanceProvenanceType.EXTERNAL_SOURCE;
            }

            Classification classification = repositoryHelper.getNewClassification(serviceName,
                                                                                  externalSourceGUID,
                                                                                  externalSourceName,
                                                                                  instanceProvenanceType,
                                                                                  userId,
                                                                                  OpenMetadataType.CALCULATED_VALUE_CLASSIFICATION.typeName,
                                                                                  typeName,
                                                                                  ClassificationOrigin.ASSIGNED,
                                                                                  null,
                                                                                  instanceProperties);
            newClassifications.put(classification.getName(), classification);
        }
        catch (TypeErrorException error)
        {
            errorHandler.handleUnsupportedType(error, methodName, OpenMetadataType.CALCULATED_VALUE_CLASSIFICATION.typeName);
        }
    }


    /**
     * Return the schema type properties in an InstanceProperties object.
     *
     * @param formula details of how this value is calculated
     * @param methodName name of the calling method
     * @return InstanceProperties object
     */
    public InstanceProperties getCalculatedValueProperties(String formula,
                                                           String methodName)
    {
        InstanceProperties properties = null;

        if (formula != null)
        {
            properties = repositoryHelper.addStringPropertyToInstance(serviceName,
                                                                      null,
                                                                      OpenMetadataProperty.FORMULA.name,
                                                                      formula,
                                                                      methodName);
        }

        return properties;
    }


    /**
     * Return the supplied bean properties in an InstanceProperties object.
     *
     * @param methodName name of the calling method
     * @return InstanceProperties object
     * @throws InvalidParameterException there is a problem with the properties
     */
    @Override
    public InstanceProperties getInstanceProperties(String  methodName) throws InvalidParameterException
    {
        InstanceProperties properties = super.getInstanceProperties(methodName);

        properties = repositoryHelper.addStringPropertyToInstance(serviceName,
                                                                  properties,
                                                                  OpenMetadataProperty.DISPLAY_NAME.name,
                                                                  displayName,
                                                                  methodName);

        properties = repositoryHelper.addStringPropertyToInstance(serviceName,
                                                                  properties,
                                                                  OpenMetadataProperty.DESCRIPTION.name,
                                                                  description,
                                                                  methodName);

        properties = repositoryHelper.addBooleanPropertyToInstance(serviceName,
                                                                   properties,
                                                                   OpenMetadataProperty.IS_DEPRECATED.name,
                                                                   isDeprecated,
                                                                   methodName);

        properties = repositoryHelper.addStringPropertyToInstance(serviceName,
                                                                  properties,
                                                                  OpenMetadataProperty.DEFAULT_VALUE_OVERRIDE.name,
                                                                  defaultValueOverride,
                                                                  methodName);

        properties = repositoryHelper.addBooleanPropertyToInstance(serviceName,
                                                                   properties,
                                                                   OpenMetadataProperty.ALLOWS_DUPLICATE_VALUES.name,
                                                                   allowsDuplicateValues,
                                                                   methodName);

        properties = repositoryHelper.addBooleanPropertyToInstance(serviceName,
                                                                   properties,
                                                                   OpenMetadataProperty.ORDERED_VALUES.name,
                                                                   orderedValues,
                                                                   methodName);

        try
        {
            properties = repositoryHelper.addEnumPropertyToInstance(serviceName,
                                                                    properties,
                                                                    OpenMetadataProperty.SORT_ORDER.name,
                                                                    DataItemSortOrder.getOpenTypeGUID(),
                                                                    DataItemSortOrder.getOpenTypeName(),
                                                                    sortOrder,
                                                                    methodName);
        }
        catch (TypeErrorException error)
        {
            throw new InvalidParameterException(error, OpenMetadataProperty.SORT_ORDER.name);
        }

        properties = repositoryHelper.addIntPropertyToInstance(serviceName,
                                                               properties,
                                                               OpenMetadataProperty.MINIMUM_LENGTH.name,
                                                               minimumLength,
                                                               methodName);

        properties = repositoryHelper.addIntPropertyToInstance(serviceName,
                                                               properties,
                                                               OpenMetadataProperty.LENGTH.name,
                                                               length,
                                                               methodName);

        properties = repositoryHelper.addIntPropertyToInstance(serviceName,
                                                               properties,
                                                               OpenMetadataProperty.PRECISION.name,
                                                               precision,
                                                               methodName);

        properties = repositoryHelper.addBooleanPropertyToInstance(serviceName,
                                                                   properties,
                                                                   OpenMetadataProperty.IS_NULLABLE.name,
                                                                   isNullable,
                                                                   methodName);

        properties = repositoryHelper.addStringPropertyToInstance(serviceName,
                                                                  properties,
                                                                  OpenMetadataProperty.NATIVE_CLASS.name,
                                                                  nativeJavaClass,
                                                                  methodName);

        properties = repositoryHelper.addStringArrayPropertyToInstance(serviceName,
                                                                       properties,
                                                                       OpenMetadataProperty.ALIASES.name,
                                                                       aliases,
                                                                       methodName);

        return properties;
    }


    /**
     * Return the supplied parent relationship properties in an InstanceProperties object.
     *
     * @param methodName name of the calling method
     * @return InstanceProperties object
     */
    public InstanceProperties getParentRelationshipProperties(String  methodName)
    {
        InstanceProperties properties = null;

        properties = repositoryHelper.addIntPropertyToInstance(serviceName,
                                                               properties,
                                                               OpenMetadataProperty.POSITION.name,
                                                               elementPosition,
                                                               methodName);

        properties = repositoryHelper.addIntPropertyToInstance(serviceName,
                                                               properties,
                                                               OpenMetadataProperty.MIN_CARDINALITY.name,
                                                               minCardinality,
                                                               methodName);

        properties = repositoryHelper.addIntPropertyToInstance(serviceName,
                                                               properties,
                                                               OpenMetadataProperty.MAX_CARDINALITY.name,
                                                               maxCardinality,
                                                               methodName);


        return properties;
    }
}
