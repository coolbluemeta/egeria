/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.connectors.apacheatlas.survey;


import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.ApacheAtlasRESTConnector;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasAttributeDef;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasBusinessMetadataDef;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasCardinality;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasClassification;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasClassificationDef;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasEntity;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasEntityDef;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasEntityHeader;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasEntityWithExtInfo;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasMetrics;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasMetricsGeneral;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasMetricsTag;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasRelationship;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasRelationshipDef;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasRelationshipEndDef;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasStructDef;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasTypesDef;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.resource.properties.AtlasVersion;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.survey.ffdc.AtlasSurveyAuditCode;
import org.odpi.openmetadata.adapters.connectors.apacheatlas.survey.ffdc.AtlasSurveyErrorCode;
import org.odpi.openmetadata.frameworks.connectors.Connector;
import org.odpi.openmetadata.frameworks.connectors.ffdc.ConnectorCheckedException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.UserNotAuthorizedException;
import org.odpi.openmetadata.frameworks.connectors.properties.AssetUniverse;
import org.odpi.openmetadata.frameworks.connectors.properties.NestedSchemaType;
import org.odpi.openmetadata.frameworks.connectors.properties.SchemaAttributes;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.ElementStatus;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.SchemaAttribute;
import org.odpi.openmetadata.frameworks.governanceaction.OpenMetadataStore;
import org.odpi.openmetadata.frameworks.governanceaction.mapper.OpenMetadataProperty;
import org.odpi.openmetadata.frameworks.governanceaction.mapper.OpenMetadataType;
import org.odpi.openmetadata.frameworks.governanceaction.search.ElementProperties;
import org.odpi.openmetadata.frameworks.governanceaction.search.PropertyHelper;
import org.odpi.openmetadata.frameworks.surveyaction.AnnotationStore;
import org.odpi.openmetadata.frameworks.surveyaction.SurveyActionServiceConnector;
import org.odpi.openmetadata.frameworks.surveyaction.SurveyAssetStore;
import org.odpi.openmetadata.frameworks.surveyaction.properties.DataProfileAnnotation;
import org.odpi.openmetadata.frameworks.surveyaction.properties.DataSourceMeasurementAnnotation;
import org.odpi.openmetadata.frameworks.surveyaction.properties.SchemaAnalysisAnnotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This connector builds a profile of the types and instances in an Apache Atlas server.
 */
public class SurveyApacheAtlasConnector extends SurveyActionServiceConnector
{
    final static PropertyHelper propertyHelper = new PropertyHelper();

    /**
     * This map allows the discovery service to look up the data field that corresponds to
     * a specific Apache Atlas Type.
     */
    private final Map<String, String> typeNameToDataFieldGUIDMap = new HashMap<>();

    /**
     * This is the point after which the processing stops.  The default is PROFILE - which
     * is the last analysis step.  It can be changed through configuration properties or
     * analysis properties passed when this discovery service is called.
     */
    private String finalAnalysisStep = SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE;

    private final static String measurementsAnnotationTypeName                  = "Apache Atlas Server Metrics";
    private final static String schemaAnalysisAnnotationTypeName                = "Apache Atlas Type Analysis";
    private final static String attachedEntityTypesAnnotationTypeName           = "Apache Atlas Attached Entity Types";
    private final static String attachedClassificationTypesAnnotationTypeName   = "Apache Atlas Attached Classification Types";
    private final static String attachedRelationshipTypesEnd1AnnotationTypeName = "Apache Atlas End 1 Attached Relationship Types";
    private final static String attachedRelationshipTypesEnd2AnnotationTypeName = "Apache Atlas End 2 Attached Relationship Types";
    private final static String attachedLabelsAnnotationTypeName                = "Apache Atlas Attached Labels";
    private final static String attachedBusinessMetadataTypesAnnotationTypeName = "Apache Atlas Attached Business Metadata Types";
    private final static String attachedEnd1EntityTypesAnnotationTypeName       = "Apache Atlas Attached End 1 Entity Types";
    private final static String attachedEnd2EntityTypesAnnotationTypeName       = "Apache Atlas Attached End 2 Entity Types";
    private final static String attachedPairedEntityTypesAnnotationTypeName     = "Apache Atlas Attached Entity Type Pairs";

    /**
     * Indicates that the discovery service is completely configured and can begin processing.
     * This is where the function of the discovery service is implemented.
     * This is a standard method from the Open Connector Framework (OCF) so
     * be sure to call super.start() in your version.
     *
     * @throws ConnectorCheckedException there is a problem within the discovery service.
     */
    @Override
    public void start() throws ConnectorCheckedException
    {
        super.start();

        final String methodName = "start";

        if (connectionProperties.getConfigurationProperties() != null)
        {
            Object finalAnalysisStepPropertyObject = connectionProperties.getConfigurationProperties().get(SurveyApacheAtlasProvider.FINAL_ANALYSIS_STEP_PROPERTY_NAME);

            if (finalAnalysisStepPropertyObject != null)
            {
                String finalAnalysisProperty = finalAnalysisStepPropertyObject.toString();

                if ((finalAnalysisProperty.equals(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_STATS)) ||
                    (finalAnalysisProperty.equals(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_SCHEMA)))
                {
                    finalAnalysisStep = finalAnalysisProperty;
                }
            }
        }

        /*
         * The finalAnalysisStep property in analysisProperties takes precedent over the value in the
         * configuration properties.
         */
        if (surveyContext.getRequestParameters() != null)
        {
            String finalAnalysisProperty = surveyContext.getRequestParameters().get(SurveyApacheAtlasProvider.FINAL_ANALYSIS_STEP_PROPERTY_NAME);

            if ((finalAnalysisProperty.equals(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_STATS)) ||
                (finalAnalysisProperty.equals(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_SCHEMA)))
            {
                finalAnalysisStep = finalAnalysisProperty;
            }
        }

        try
        {
            String           assetGUID  = surveyContext.getAssetGUID();
            SurveyAssetStore assetStore = surveyContext.getAssetStore();

            Connector connectorToAsset  = assetStore.getConnectorToAsset();
            AssetUniverse assetUniverse = assetStore.getAssetProperties();

            if (connectorToAsset instanceof ApacheAtlasRESTConnector atlasConnector)
            {
                AnnotationStore   annotationStore   = surveyContext.getAnnotationStore();
                OpenMetadataStore openMetadataStore = surveyContext.getOpenMetadataStore();

                /*
                 * The STATS analysis step gathers simple statistics from Apache Atlas
                 */
                annotationStore.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_STATS);

                AtlasVersion  atlasVersion = atlasConnector.getAtlasVersion();
                AtlasMetrics  atlasMetrics = atlasConnector.getAtlasMetrics();

                if ((atlasMetrics != null) && (atlasMetrics.getData() != null))
                {
                    AtlasMetricsGeneral atlasMetricsGeneral = atlasMetrics.getData().getGeneral();
                    AtlasMetricsTag     atlasMetricsTag     = atlasMetrics.getData().getTag();
                    AtlasTypesDef       atlasTypes          = atlasConnector.getAllTypes();

                    DataSourceMeasurementAnnotation measurementAnnotation = new DataSourceMeasurementAnnotation();
                    measurementAnnotation.setAnnotationType(measurementsAnnotationTypeName);
                    measurementAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_STATS);
                    measurementAnnotation.setExplanation("Metrics maintained by the Apache Atlas server.");

                    Map<String, String> metrics = new HashMap<>();

                    if (atlasMetricsGeneral != null)
                    {
                        metrics.put("entityInstanceCount", Integer.toString(atlasMetricsGeneral.getEntityCount()));
                        metrics.put("classificationCount", Integer.toString(atlasMetricsGeneral.getTagCount()));
                        metrics.put("typeUnusedCount", Integer.toString(atlasMetricsGeneral.getTypeUnusedCount()));
                        metrics.put("typeCount", Integer.toString(atlasMetricsGeneral.getTypeCount()));
                    }

                    if ((atlasMetricsTag != null) && (atlasMetricsTag.getTagEntities() != null))
                    {
                        addMapMetrics(atlasMetricsTag.getTagEntities(), "classifiedEntityCount", metrics);
                    }

                    if (atlasMetrics.getData().getEntity() != null)
                    {
                        addMapMetrics(atlasMetrics.getData().getEntity().get("entityActive"), "entityInstanceCount", metrics);
                        addMapMetrics(atlasMetrics.getData().getEntity().get("entityActive-typeAndSubTypes"), "entityWithSubtypesInstanceCount", metrics);
                    }

                    if (atlasTypes != null)
                    {
                        metrics.put("entityDefs",         Integer.toString(atlasTypes.getEntityDefs().size()));
                        metrics.put("relationshipDefs",   Integer.toString(atlasTypes.getRelationshipDefs().size()));
                        metrics.put("classificationDefs", Integer.toString(atlasTypes.getClassificationDefs().size()));

                        if (atlasTypes.getBusinessMetadataDefs() != null)
                        {
                            metrics.put("businessMetadataDefs", Integer.toString(atlasTypes.getBusinessMetadataDefs().size()));
                        }
                    }

                    measurementAnnotation.setDataSourceProperties(metrics);

                    annotationStore.addAnnotation(measurementAnnotation, null);
                }

                if (! SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_STATS.equals(finalAnalysisStep))
                {
                    /*
                     * The SCHEMA analysis step is starting now.  It uses the Apache Atlas types to perform a schema analysis that shows how the
                     * Apache Atlas types are linked.
                     */
                    annotationStore.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_SCHEMA);

                    SchemaAnalysisAnnotation schemaAnalysisAnnotation = new SchemaAnalysisAnnotation();

                    schemaAnalysisAnnotation.setAnnotationType(schemaAnalysisAnnotationTypeName);
                    schemaAnalysisAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_SCHEMA);
                    schemaAnalysisAnnotation.setExplanation("Linked data fields describing the types defined in the Apache Atlas Server.");
                    schemaAnalysisAnnotation.setSchemaName("Apache Atlas Types: " + atlasVersion.getVersion());
                    schemaAnalysisAnnotation.setSchemaTypeName(atlasVersion.getName());

                    annotationStore.addAnnotation(schemaAnalysisAnnotation,null);

                    /*
                     * The schemaType is the root of the graph schema that describes the apache Atlas types.
                     * This schema type is of type GraphSchemaType, and it is connected to the asset via the
                     * AssetSchemaType Relationship. This call either confirms the root schema type is in place or
                     * creates a new one.
                     */
                    this.upsertRootSchemaType(assetGUID, assetUniverse, openMetadataStore);

                    /*
                     * Refresh the asse universe to be sure the schema type is present.
                     */
                    assetUniverse = assetStore.getAssetProperties();

                    /*
                     * Load the existing schema attributes representing the Atlas types.
                     */
                    if ((assetUniverse != null) && (assetUniverse.getRootSchemaType() != null))
                    {
                        if (assetUniverse.getRootSchemaType() instanceof NestedSchemaType graphSchemaType)
                        {
                            SchemaAttributes existingTypeSchemaAttributes = graphSchemaType.getSchemaAttributes();

                            if (existingTypeSchemaAttributes != null)
                            {
                                while (existingTypeSchemaAttributes.hasNext())
                                {
                                    SchemaAttribute existingType = existingTypeSchemaAttributes.next();

                                    typeNameToDataFieldGUIDMap.put(existingType.getDisplayName(), existingType.getGUID());
                                }
                            }
                        }
                    }

                    /*
                     * Retrieve all the type definitions from Apache Atlas.  They are organized by category.
                     */
                    AtlasTypesDef atlasTypesDef = atlasConnector.getAllTypes();

                    /*
                     * Step through the entity types
                     */
                    for (AtlasEntityDef atlasEntityDef : atlasTypesDef.getEntityDefs())
                    {
                        if (atlasEntityDef != null)
                        {
                            this.getSchemaAttributeForAtlasEntityDef(atlasEntityDef,
                                                                     assetUniverse,
                                                                     openMetadataStore);
                        }
                    }

                    /*
                     * Step through the classifications
                     */
                    for (AtlasClassificationDef atlasClassificationDef : atlasTypesDef.getClassificationDefs())
                    {
                        if (atlasClassificationDef != null)
                        {
                            this.getSchemaAttributeForAtlasClassificationDef(atlasClassificationDef,
                                                                             assetUniverse,
                                                                             openMetadataStore);
                        }
                    }

                    /*
                     * Step through the relationships
                     */
                    for (AtlasRelationshipDef atlasRelationshipDef : atlasTypesDef.getRelationshipDefs())
                    {
                        if (atlasRelationshipDef != null)
                        {
                            this.getSchemaAttributeForAtlasRelationshipDef(atlasRelationshipDef,
                                                                           assetUniverse,
                                                                           openMetadataStore);
                        }
                    }

                    /*
                     * Step through the business metadata
                     */
                    if (atlasTypesDef.getBusinessMetadataDefs() != null)
                    {
                        for (AtlasBusinessMetadataDef atlasBusinessMetadataDef : atlasTypesDef.getBusinessMetadataDefs())
                        {
                            if (atlasBusinessMetadataDef != null)
                            {
                                this.getSchemaAttributeForAtlasBusinessMetadataDef(atlasBusinessMetadataDef,
                                                                                   assetUniverse,
                                                                                   openMetadataStore);
                            }
                        }
                    }

                    if (SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE.equals(finalAnalysisStep))
                    {
                        /*
                         * The final step in the analysis is to retrieve each entity instance from the Apache Atlas repository and
                         * create data profile annotations based on the number of instances of each type discovered.
                         */
                        annotationStore.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);

                        Map<String, EntityTypeMetrics>       entityTypeMetricsMap         = new HashMap<>();
                        Map<String, TagTypeMetrics>          classificationTypeMetricsMap = new HashMap<>();
                        Map<String, TagTypeMetrics>          businessMetadataMetricsMap   = new HashMap<>();
                        Map<String, RelationshipTypeMetrics> relationshipTypeMetricsMap   = new HashMap<>();


                        final int maxPageSize = 100;

                        /*
                         * Gather data in the maps
                         */
                        for (AtlasEntityDef entityType : atlasTypesDef.getEntityDefs())
                        {
                            /*
                             * Only process entity types that are top level (ie no subtypes) - this stops us counting an entity that has
                             * multiple subtypes.
                             */
                            if ((entityType.getSuperTypes() == null) || (entityType.getSuperTypes().isEmpty()))
                            {
                                int                     startFrom = 0;
                                List<AtlasEntityHeader> entities  = atlasConnector.getEntitiesForType(entityType.getName(), startFrom, maxPageSize);

                                while ((entities != null) && (! entities.isEmpty()))
                                {
                                    for (AtlasEntityHeader entityHeader : entities)
                                    {
                                        AtlasEntityWithExtInfo atlasEntityWithExtInfo = atlasConnector.getEntityByGUID(entityHeader.getGuid());

                                        this.addEntityProfile(atlasEntityWithExtInfo.getEntity(),
                                                              this.getAtlasRelationships(atlasEntityWithExtInfo.getEntity(), atlasConnector),
                                                              entityTypeMetricsMap,
                                                              classificationTypeMetricsMap,
                                                              businessMetadataMetricsMap,
                                                              relationshipTypeMetricsMap);
                                    }

                                    startFrom = startFrom + maxPageSize;
                                    entities  = atlasConnector.getEntitiesForType(entityType.getName(), startFrom, maxPageSize);
                                }
                            }
                        }

                        /*
                         * Once the counting is complete, build the data profile annotations to attach to the data fields.
                         * Not all types will have instances, so this logic is driven by the metrics map that only includes types with instances.
                         */
                        for (String entityTypeName : entityTypeMetricsMap.keySet())
                        {
                            EntityTypeMetrics entityTypeMetrics = entityTypeMetricsMap.get(entityTypeName);

                            String dataFieldGUID = typeNameToDataFieldGUIDMap.get(entityTypeName);

                            Map<String, String> additionalProperties = new HashMap<>();
                            additionalProperties.put("entityInstanceCount", Integer.toString(entityTypeMetrics.instanceCount));

                            /*
                             * Attached classifications
                             */
                            DataProfileAnnotation dataProfileAnnotation = new DataProfileAnnotation();

                            dataProfileAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);
                            dataProfileAnnotation.setAnnotationType(attachedClassificationTypesAnnotationTypeName);
                            dataProfileAnnotation.setExplanation("Count of classification types attached to this type of entity.");
                            dataProfileAnnotation.setValueCount(entityTypeMetrics.classificationCount);
                            dataProfileAnnotation.setAdditionalProperties(additionalProperties);

                            annotationStore.addAnnotation(dataProfileAnnotation, dataFieldGUID);

                            /*
                             * Attached to Relationship At End 1
                             */
                            dataProfileAnnotation = new DataProfileAnnotation();

                            dataProfileAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);
                            dataProfileAnnotation.setAnnotationType(attachedRelationshipTypesEnd1AnnotationTypeName);
                            dataProfileAnnotation.setExplanation("Count of different types of relationships attached to this type of entity at End 1.");
                            dataProfileAnnotation.setValueCount(entityTypeMetrics.relationshipEnd1Count);
                            dataProfileAnnotation.setAdditionalProperties(additionalProperties);

                            annotationStore.addAnnotation(dataProfileAnnotation, dataFieldGUID);

                            /*
                             * Attached to Relationship At End 2
                             */
                            dataProfileAnnotation = new DataProfileAnnotation();

                            dataProfileAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);
                            dataProfileAnnotation.setAnnotationType(attachedRelationshipTypesEnd2AnnotationTypeName);
                            dataProfileAnnotation.setExplanation("Count of different types of relationships attached to this type of entity at End 2.");
                            dataProfileAnnotation.setValueCount(entityTypeMetrics.relationshipEnd2Count);
                            dataProfileAnnotation.setAdditionalProperties(additionalProperties);

                            annotationStore.addAnnotation(dataProfileAnnotation, dataFieldGUID);

                            /*
                             * Attached Labels
                             */
                            dataProfileAnnotation = new DataProfileAnnotation();

                            dataProfileAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);
                            dataProfileAnnotation.setAnnotationType(attachedLabelsAnnotationTypeName);
                            dataProfileAnnotation.setExplanation("Count of the different labels attached to this type of entity.");
                            dataProfileAnnotation.setValueCount(entityTypeMetrics.labelCount);
                            dataProfileAnnotation.setAdditionalProperties(additionalProperties);

                            annotationStore.addAnnotation(dataProfileAnnotation, dataFieldGUID);

                            /*
                             * Attached Business Metadata
                             */
                            dataProfileAnnotation = new DataProfileAnnotation();

                            dataProfileAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);
                            dataProfileAnnotation.setAnnotationType(attachedBusinessMetadataTypesAnnotationTypeName);
                            dataProfileAnnotation.setExplanation("Count of the different types of business metadata properties attached to this type of entity.");
                            dataProfileAnnotation.setValueCount(entityTypeMetrics.labelCount);
                            dataProfileAnnotation.setAdditionalProperties(additionalProperties);

                            annotationStore.addAnnotation(dataProfileAnnotation, dataFieldGUID);
                        }

                        /*
                         * Each classification data field for classifications in use has a single "Attached Entity Types" data profile annotation.
                         */
                        for (String classificationName : classificationTypeMetricsMap.keySet())
                        {
                            TagTypeMetrics classificationTypeMetrics = classificationTypeMetricsMap.get(classificationName);

                            DataProfileAnnotation dataProfileAnnotation = new DataProfileAnnotation();

                            dataProfileAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);
                            dataProfileAnnotation.setAnnotationType(attachedEntityTypesAnnotationTypeName);
                            dataProfileAnnotation.setExplanation("Count of entities by type where this classification is attached, organized by entity type.");

                            dataProfileAnnotation.setValueCount(classificationTypeMetrics.entityCount);

                            Map<String, String> additionalProperties = new HashMap<>();
                            additionalProperties.put("classificationInstanceCount", Integer.toString(classificationTypeMetrics.instanceCount));
                            dataProfileAnnotation.setAdditionalProperties(additionalProperties);

                            annotationStore.addAnnotation(dataProfileAnnotation, typeNameToDataFieldGUIDMap.get(classificationName));
                        }

                        /*
                         * Similarly, the data field for each business metadata properties in use has a single "Attached Entity Types"
                         * data profile annotation.
                         */
                        for (String businessMetadataName : businessMetadataMetricsMap.keySet())
                        {
                            TagTypeMetrics businessMetadataMetrics = businessMetadataMetricsMap.get(businessMetadataName);

                            DataProfileAnnotation dataProfileAnnotation = new DataProfileAnnotation();

                            dataProfileAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);
                            dataProfileAnnotation.setAnnotationType(attachedEntityTypesAnnotationTypeName);
                            dataProfileAnnotation.setExplanation("Count of entities where this type of business metadata properties are attached, organized by entity type.");
                            dataProfileAnnotation.setValueCount(businessMetadataMetrics.entityCount);

                            Map<String, String> additionalProperties = new HashMap<>();
                            additionalProperties.put("businessMetadataInstanceCount", Integer.toString(businessMetadataMetrics.instanceCount));
                            dataProfileAnnotation.setAdditionalProperties(additionalProperties);

                            annotationStore.addAnnotation(dataProfileAnnotation, typeNameToDataFieldGUIDMap.get(businessMetadataName));
                        }

                        /*
                         * Each relationship data field has two attached data profile annotation: one for end1 and the other for end2.
                         * Each annotation provides details of the number of each type of entity attached to that end of the relationship.
                         */
                        for (String relationshipTypeName : relationshipTypeMetricsMap.keySet())
                        {
                            RelationshipTypeMetrics relationshipTypeMetrics = relationshipTypeMetricsMap.get(relationshipTypeName);

                            String dataFieldGUID = typeNameToDataFieldGUIDMap.get(relationshipTypeName);

                            Map<String, String> additionalProperties = new HashMap<>();
                            additionalProperties.put("relationshipInstanceCount", Integer.toString(relationshipTypeMetrics.instanceCount));

                            /*
                             * End 1
                             */
                            DataProfileAnnotation dataProfileAnnotation = new DataProfileAnnotation();

                            dataProfileAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);
                            dataProfileAnnotation.setAnnotationType(attachedEnd1EntityTypesAnnotationTypeName);
                            dataProfileAnnotation.setExplanation("Count of entity types attached at end 1 of this type of relationship.");
                            dataProfileAnnotation.setValueCount(relationshipTypeMetrics.entityAtEnd1Count);
                            dataProfileAnnotation.setAdditionalProperties(additionalProperties);

                            annotationStore.addAnnotation(dataProfileAnnotation, dataFieldGUID);

                            /*
                             * End 2
                             */
                            dataProfileAnnotation = new DataProfileAnnotation();

                            dataProfileAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);
                            dataProfileAnnotation.setAnnotationType(attachedEnd2EntityTypesAnnotationTypeName);
                            dataProfileAnnotation.setExplanation("Count of entity types attached at end 2 of this type of relationship.");
                            dataProfileAnnotation.setValueCount(relationshipTypeMetrics.entityAtEnd2Count);
                            dataProfileAnnotation.setAdditionalProperties(additionalProperties);

                            annotationStore.addAnnotation(dataProfileAnnotation, dataFieldGUID);

                            /*
                             * Pair
                             */
                            dataProfileAnnotation = new DataProfileAnnotation();

                            dataProfileAnnotation.setAnalysisStep(SurveyApacheAtlasProvider.ANALYSIS_STEP_NAME_PROFILE);
                            dataProfileAnnotation.setAnnotationType(attachedPairedEntityTypesAnnotationTypeName);
                            dataProfileAnnotation.setExplanation("Count of entity type pairs for this type of relationship.");
                            dataProfileAnnotation.setValueCount(relationshipTypeMetrics.entityPairCount);
                            dataProfileAnnotation.setAdditionalProperties(additionalProperties);

                            annotationStore.addAnnotation(dataProfileAnnotation, dataFieldGUID);
                        }
                    }
                }
            }
            else
            {
                String connectorToAssetClassName = "null";

                if (connectorToAsset != null)
                {
                    connectorToAssetClassName = connectorToAsset.getClass().getName();
                }

                if (auditLog != null)
                {
                    auditLog.logMessage(methodName,
                                        AtlasSurveyAuditCode.WRONG_REST_CONNECTOR.getMessageDefinition(surveyActionServiceName,
                                                                                                       connectorToAssetClassName,
                                                                                                       ApacheAtlasRESTConnector.class.getName(),
                                                                                                       assetGUID));
                }

                throw new ConnectorCheckedException(AtlasSurveyErrorCode.WRONG_REST_CONNECTOR.getMessageDefinition(surveyActionServiceName,
                                                                                                                   connectorToAssetClassName,
                                                                                                                   ApacheAtlasRESTConnector.class.getName(),
                                                                                                                   assetGUID),
                                                    this.getClass().getName(),
                                                    methodName);
            }
        }
        catch (ConnectorCheckedException error)
        {
            throw error;
        }
        catch (Exception error)
        {
            throw new ConnectorCheckedException(AtlasSurveyErrorCode.UNEXPECTED_EXCEPTION.getMessageDefinition(surveyActionServiceName,
                                                                                                               error.getClass().getName(),
                                                                                                               methodName,
                                                                                                               error.getMessage()),
                                                this.getClass().getName(),
                                                methodName);
        }
    }


    /**
     * Retrieve all the relationships for an Apache Atlas entity.
     *
     * @param atlasEntity starting entity
     * @param atlasConnector client to Apache Atlas
     * @return list of relationships or null
     * @throws PropertyServerException problem communicating with Apache Atlas
     */
    private List<AtlasRelationship> getAtlasRelationships(AtlasEntity              atlasEntity,
                                                          ApacheAtlasRESTConnector atlasConnector) throws PropertyServerException
    {
        if ((atlasEntity.getRelationshipAttributes() != null) || (! atlasEntity.getRelationshipAttributes().isEmpty()))
        {
            List<AtlasRelationship> relationships = new ArrayList<>();

            for (String relationshipAttribute : atlasEntity.getRelationshipAttributes().keySet())
            {
                if (atlasEntity.getRelationshipAttributes().get(relationshipAttribute) instanceof Map<?,?> relationshipProperties)
                {
                    Object relationshipGUID = relationshipProperties.get("relationshipGuid");

                    if (relationshipGUID != null)
                    {
                        AtlasRelationship relationship = atlasConnector.getRelationshipByGUID(relationshipGUID.toString());

                        if (relationship != null)
                        {
                            relationships.add(relationship);
                        }
                    }
                }
            }

            if (! relationships.isEmpty())
            {
                return relationships;
            }
        }

        return null;
    }


    /**
     * Add counts to the profile maps for a specific Apache Atlas entity and its relationships.
     *
     * @param atlasEntity atlas entity
     * @param atlasRelationships list of its relationships
     * @param entityTypeMetricsMap map of counts for entity types
     * @param classificationTypeMetricsMap map of counts for classification types
     * @param businessMetadataTypeMetricsMap map of counts for business metadata types
     * @param relationshipTypeMetricsMap map of counts for relationship types
     */
    private void addEntityProfile(AtlasEntity                            atlasEntity,
                                  List<AtlasRelationship>                atlasRelationships,
                                  Map<String, EntityTypeMetrics>         entityTypeMetricsMap,
                                  Map<String, TagTypeMetrics>            classificationTypeMetricsMap,
                                  Map<String, TagTypeMetrics>            businessMetadataTypeMetricsMap,
                                  Map<String, RelationshipTypeMetrics>   relationshipTypeMetricsMap)
    {
        if (atlasEntity != null)
        {
            String entityTypeName = atlasEntity.getTypeName();

            EntityTypeMetrics entityTypeMetrics = entityTypeMetricsMap.get(entityTypeName);

            if (entityTypeMetrics == null)
            {
                entityTypeMetrics = new EntityTypeMetrics();
                entityTypeMetricsMap.put(entityTypeName, entityTypeMetrics);
            }

            entityTypeMetrics.incrementInstanceCount();

            if (atlasEntity.getLabels() != null)
            {
                for (String label : atlasEntity.getLabels())
                {
                    entityTypeMetrics.incrementLabelCount(label);
                }
            }

            if (atlasEntity.getClassifications() != null)
            {
                for (AtlasClassification classification : atlasEntity.getClassifications())
                {
                    String classificationName = classification.getTypeName();

                    entityTypeMetrics.incrementClassificationCount(classificationName);

                    TagTypeMetrics classificationTypeMetrics = classificationTypeMetricsMap.get(classificationName);

                    if (classificationTypeMetrics == null)
                    {
                        classificationTypeMetrics = new TagTypeMetrics();
                        classificationTypeMetricsMap.put(classificationName, classificationTypeMetrics);
                    }

                    classificationTypeMetrics.incrementInstanceCount();
                    classificationTypeMetrics.incrementEntityCount(entityTypeName);
                }
            }

            if (atlasEntity.getBusinessAttributes() != null)
            {
                for (String businessMetadataName : atlasEntity.getBusinessAttributes().keySet())
                {
                    entityTypeMetrics.incrementBusinessMetadataCount(businessMetadataName);

                    TagTypeMetrics businessMetadataMetrics = businessMetadataTypeMetricsMap.get(businessMetadataName);

                    if (businessMetadataMetrics == null)
                    {
                        businessMetadataMetrics = new TagTypeMetrics();
                        classificationTypeMetricsMap.put(businessMetadataName, businessMetadataMetrics);
                    }

                    businessMetadataMetrics.incrementInstanceCount();
                    businessMetadataMetrics.incrementEntityCount(entityTypeName);
                }
            }


            /*
             * Process the relationships attached to the entity.  Notice that because we are processing relationships from an entity perspective,
             * each relationship is processed twice.  Therefore, the relationship oriented counts are only incremented when the entity is at end 1.
             */
            if ((atlasRelationships != null) && (! atlasRelationships.isEmpty()))
            {
                for (AtlasRelationship relationship : atlasRelationships)
                {
                    String relationshipTypeName = relationship.getTypeName();

                    RelationshipTypeMetrics relationshipTypeMetrics = relationshipTypeMetricsMap.get(relationshipTypeName);

                    if (relationshipTypeMetrics == null)
                    {
                        relationshipTypeMetrics = new RelationshipTypeMetrics();
                        relationshipTypeMetricsMap.put(relationshipTypeName, relationshipTypeMetrics);
                    }

                    if (relationship.getEnd1().getGuid().equals(atlasEntity.getGuid()))
                    {
                        relationshipTypeMetrics.incrementInstanceCount(); // only count relationship once
                        relationshipTypeMetrics.incrementEntityPairCount(relationship.getEnd1().getTypeName(),
                                                                         relationship.getEnd2().getTypeName());

                        relationshipTypeMetrics.incrementEntityAtEnd1Count(entityTypeName);
                        entityTypeMetrics.incrementRelationshipEnd1Count(relationshipTypeName);
                    }
                    else
                    {
                        relationshipTypeMetrics.incrementEntityAtEnd2Count(entityTypeName);
                        entityTypeMetrics.incrementRelationshipEnd2Count(relationshipTypeName);
                    }
                }
            }
        }
    }


    /**
     * Add a map of metrics to the consolidated metrics.
     *
     * @param namedMetrics raw metrics map
     * @param metricNamePrefix name of the group of metrics
     * @param consolidatedMetrics consolidated metrics map
     */
    private void addMapMetrics(Map<String, Integer> namedMetrics,
                               String               metricNamePrefix,
                               Map<String, String>  consolidatedMetrics)
    {
        int elementCount = 0;

        for (String elementName : namedMetrics.keySet())
        {
            elementCount ++;
            consolidatedMetrics.put(metricNamePrefix + ": " + elementName, Integer.toString(namedMetrics.get(elementName)));
        }

        consolidatedMetrics.put(metricNamePrefix, Integer.toString(elementCount));
    }


    /**
     * Validate there is a root schema type of the correct type attached to the asset.  If so return its guid.
     * It there is a schema type, but it is the wrong type then throw an exception.
     * If no schema type exists then create a new schema type and attach it to the asset.  Return the GUID of the new schema type.
     *
     * @param assetGUID unique identifier of the asset
     * @param assetUniverse details of the asset from the open metadata repository
     * @param openMetadataStore access to the open metadata repository to use if the schema type needs defining.
     *
     * @throws InvalidParameterException one of the properties passed oto the open metadata store is invalid
     * @throws PropertyServerException problem communicating with the open metadata store
     * @throws UserNotAuthorizedException not authorized to access the open metadata store
     * @throws ConnectorCheckedException the connector is not able to process because the existing asset information is invalid
     */
    private void upsertRootSchemaType(String            assetGUID,
                                      AssetUniverse     assetUniverse,
                                      OpenMetadataStore openMetadataStore) throws InvalidParameterException,
                                                                                  PropertyServerException,
                                                                                  UserNotAuthorizedException,
                                                                                  ConnectorCheckedException
    {
        final String methodName = "addRootSchemaType";

        if (assetUniverse != null)
        {
            if (assetUniverse.getRootSchemaType() != null)
            {
                /*
                 * The root schema type is already in place - check it is of the correct type.
                 */
                if (propertyHelper.isTypeOf(assetUniverse.getRootSchemaType(), OpenMetadataType.GRAPH_SCHEMA_TYPE.typeName))
                {
                    /*
                     * The root schema type is already defined and set up.
                     */
                    return;
                }

                /*
                 * There is a root schema type, but it is of the wrong type.
                 */
                if (auditLog != null)
                {
                    auditLog.logMessage(methodName,
                                        AtlasSurveyAuditCode.WRONG_ROOT_SCHEMA_TYPE.getMessageDefinition(assetGUID,
                                                                                                         assetUniverse.getRootSchemaType().getType().getTypeName(),
                                                                                                         OpenMetadataType.GRAPH_SCHEMA_TYPE.typeName,
                                                                                                         surveyActionServiceName,
                                                                                                         assetUniverse.getRootSchemaType().toString()));
                }

                throw new ConnectorCheckedException(AtlasSurveyErrorCode.WRONG_ROOT_SCHEMA_TYPE.getMessageDefinition(assetGUID,
                                                                                                                     assetUniverse.getRootSchemaType().getType().getTypeName(),
                                                                                                                     OpenMetadataType.GRAPH_SCHEMA_TYPE.typeName,
                                                                                                                     surveyActionServiceName,
                                                                                                                     assetUniverse.getRootSchemaType().toString()),
                                                    this.getClass().getName(),
                                                    methodName);
            }
            else
            {
                /*
                 * The root schema type is not set up yet.
                 */
                ElementProperties properties = propertyHelper.addStringProperty(null,
                                                                                OpenMetadataProperty.QUALIFIED_NAME.name,
                                                                                assetUniverse.getQualifiedName() + "_rootSchemaType");

                properties = propertyHelper.addStringProperty(properties,
                                                              OpenMetadataProperty.DISPLAY_NAME.name,
                                                              "Root schema type for " + assetUniverse.getResourceName());

                properties = propertyHelper.addStringProperty(properties,
                                                              OpenMetadataProperty.DESCRIPTION.name,
                                                              "Graph schema showing the Apache Atlas Types and how they link together.");

                openMetadataStore.createMetadataElementInStore(OpenMetadataType.GRAPH_SCHEMA_TYPE.typeName,
                                                               ElementStatus.ACTIVE,
                                                               null,
                                                               assetGUID,
                                                               false,
                                                               null,
                                                               null,
                                                               properties,
                                                               assetGUID,
                                                               OpenMetadataType.ASSET_TO_SCHEMA_TYPE_TYPE_NAME,
                                                               null,
                                                               true);
            }
        }
        else
        {
            if (auditLog != null)
            {
                auditLog.logMessage(methodName,
                                    AtlasSurveyAuditCode.MISSING_ASSET_UNIVERSE.getMessageDefinition(surveyActionServiceName));
            }

            throw new ConnectorCheckedException(AtlasSurveyErrorCode.MISSING_ASSET_UNIVERSE.getMessageDefinition(surveyActionServiceName),
                                                this.getClass().getName(),
                                                methodName);
        }
    }



    /**
     * Create a schema that represents the entity def and attach it to the schema analysis annotation.
     *
     * @param atlasEntityDef atlas entity type definition
     * @param assetUniverse details about the Apache atlas Server
     * @param openMetadataStore  store for saving new schema attribute
     * @throws InvalidParameterException the dataField is invalid or the annotation GUID points to an annotation
     *                                   that can not be associated with a data field.
     * @throws UserNotAuthorizedException the user id not authorized to issue this request
     * @throws PropertyServerException there was a problem  adding the data field to the Annotation store.
     */
    private void getSchemaAttributeForAtlasEntityDef(AtlasEntityDef    atlasEntityDef,
                                                     AssetUniverse     assetUniverse,
                                                     OpenMetadataStore openMetadataStore) throws InvalidParameterException,
                                                                                             PropertyServerException,
                                                                                             UserNotAuthorizedException
    {
        this.getSchemaAttributeForTypeDef(OpenMetadataType.GRAPH_VERTEX.typeName,
                                          assetUniverse,
                                          atlasEntityDef,
                                          "ENTITY",
                                          atlasEntityDef.getSuperTypes(),
                                          openMetadataStore);
    }


    /**
     * Create a data field that represents the classification def and attach it to the schema analysis annotation.
     *
     * @param atlasClassificationDef atlas classification type definition
     * @param assetUniverse details about the Apache atlas Server
     * @param openMetadataStore  store for saving new schema attribute
     * @throws InvalidParameterException the schema attribute is invalid
     * @throws UserNotAuthorizedException the user id not authorized to issue this request
     * @throws PropertyServerException there was a problem  adding the schema attribute to the open metadata repository.
     */
    private void getSchemaAttributeForAtlasClassificationDef(AtlasClassificationDef atlasClassificationDef,
                                                             AssetUniverse          assetUniverse,
                                                             OpenMetadataStore      openMetadataStore) throws InvalidParameterException,
                                                                                                              PropertyServerException,
                                                                                                              UserNotAuthorizedException
    {
        String schemaAttributeGUID = this.getSchemaAttributeForTypeDef(OpenMetadataType.GRAPH_VERTEX.typeName,
                                                                       assetUniverse,
                                                                       atlasClassificationDef,
                                                                       "CLASSIFICATION",
                                                                       atlasClassificationDef.getSuperTypes(),
                                                                       openMetadataStore);

        if (atlasClassificationDef.getEntityTypes() != null)
        {
            for (String entityType : atlasClassificationDef.getEntityTypes())
            {
                if ((entityType != null) && (typeNameToDataFieldGUIDMap.get(entityType) != null))
                {
                    openMetadataStore.createRelatedElementsInStore(OpenMetadataType.GRAPH_EDGE_LINK_RELATIONSHIP.typeName,
                                                                   schemaAttributeGUID,
                                                                   typeNameToDataFieldGUIDMap.get(entityType),
                                                                   null,
                                                                   null,
                                                                   null);
                }
            }
        }
    }


    /**
     * Create a data field that represents the classification def and attach it to the schema analysis annotation.
     *
     * @param atlasBusinessMetadataDef atlas classification type definition
     * @param assetUniverse details about the Apache atlas Server
     * @param openMetadataStore  store for saving new schema attribute
     * @throws InvalidParameterException the schema attribute is invalid
     * @throws UserNotAuthorizedException the user id not authorized to issue this request
     * @throws PropertyServerException there was a problem  adding the schema attribute to the open metadata repository.
     */
    private void getSchemaAttributeForAtlasBusinessMetadataDef(AtlasBusinessMetadataDef atlasBusinessMetadataDef,
                                                               AssetUniverse            assetUniverse,
                                                               OpenMetadataStore        openMetadataStore) throws InvalidParameterException,
                                                                                                                PropertyServerException,
                                                                                                                UserNotAuthorizedException
    {
        this.getSchemaAttributeForTypeDef(OpenMetadataType.GRAPH_VERTEX.typeName,
                                          assetUniverse,
                                          atlasBusinessMetadataDef,
                                          "BUSINESS_METADATA",
                                          null,
                                          openMetadataStore);
    }


    /**
     * Create a data field that represents the relationship def and attach it to the schema analysis annotation.
     *
     * @param atlasRelationshipDef atlas classification type definition
     * @param assetUniverse details about the Apache atlas Server
     * @param openMetadataStore  store for saving new schema attribute
     * @throws InvalidParameterException the schema attribute is invalid
     * @throws UserNotAuthorizedException the user id not authorized to issue this request
     * @throws PropertyServerException there was a problem  adding the schema attribute to the open metadata repository.
     */
    private void getSchemaAttributeForAtlasRelationshipDef(AtlasRelationshipDef     atlasRelationshipDef,
                                                           AssetUniverse            assetUniverse,
                                                           OpenMetadataStore        openMetadataStore) throws InvalidParameterException,
                                                                                                              PropertyServerException,
                                                                                                              UserNotAuthorizedException
    {
        String dataFieldGUID = this.getSchemaAttributeForTypeDef(OpenMetadataType.GRAPH_EDGE.typeName,
                                                                 assetUniverse,
                                                                 atlasRelationshipDef,
                                                                 "RELATIONSHIP",
                                                                 null,
                                                                 openMetadataStore);

        this.addRelationshipEnd(dataFieldGUID, true, atlasRelationshipDef.getEndDef1(), openMetadataStore);
        this.addRelationshipEnd(dataFieldGUID, false, atlasRelationshipDef.getEndDef2(), openMetadataStore);
    }


    /**
     * Add a data field link between a relationship data field and an entity data field.
     *
     * @param relationshipSchemaAttributeGUID unique identifier of the relationship data field
     * @param isEnd1 which end is the entity attached to?
     * @param endDef what is the entity?
     * @param openMetadataStore annotation store for saving new data field link
     * @throws InvalidParameterException one of the  dataFields is invalid.
     * @throws UserNotAuthorizedException the user id not authorized to issue this request
     * @throws PropertyServerException there was a problem adding the data field link to the Annotation store.
     */
    private void addRelationshipEnd(String                   relationshipSchemaAttributeGUID,
                                    boolean                  isEnd1,
                                    AtlasRelationshipEndDef  endDef,
                                    OpenMetadataStore        openMetadataStore) throws InvalidParameterException,
                                                                                       PropertyServerException,
                                                                                       UserNotAuthorizedException
    {
        if (endDef != null)
        {
            ElementProperties linkProperties = propertyHelper.addStringProperty(null,
                                                                                OpenMetadataProperty.NAME.name,
                                                                                endDef.getName());
            linkProperties = propertyHelper.addStringProperty(linkProperties,
                                                              OpenMetadataProperty.TYPE_NAME.name,
                                                              endDef.getType());

            linkProperties = propertyHelper.addStringProperty(linkProperties,
                                                              OpenMetadataProperty.DESCRIPTION.name,
                                                              endDef.getDescription());

            if (isEnd1)
            {
                linkProperties = propertyHelper.addIntProperty(linkProperties,
                                                               OpenMetadataProperty.RELATIONSHIP_END.name,
                                                               1);
            }
            else
            {
                linkProperties = propertyHelper.addIntProperty(linkProperties,
                                                               OpenMetadataProperty.RELATIONSHIP_END.name,
                                                               2);
            }

            if (endDef.getCardinality() == AtlasCardinality.SINGLE)
            {
                linkProperties = propertyHelper.addIntProperty(linkProperties,
                                                               OpenMetadataProperty.MAX_CARDINALITY.name,
                                                               1);
            }

            openMetadataStore.createRelatedElementsInStore(OpenMetadataType.GRAPH_EDGE_LINK_RELATIONSHIP.typeName,
                                                           relationshipSchemaAttributeGUID,
                                                           typeNameToDataFieldGUIDMap.get(endDef.getType()),
                                                           null,
                                                           null,
                                                           linkProperties);
        }
    }


    /**
     * Create a schema attribute that represents the type def and attach it to the schema analysis annotation.
     *
     * @param openMetadataTypeName the type of graph node to use in the Schema Attribute
     * @param assetUniverse details of the asset describing the Apache Atlas Server
     * @param atlasTypeDef atlas type definition
     * @param atlasCategoryName the category of Atlas type
     * @param atlasSuperTypes the set of super types
     * @param openMetadataStore annotation store for saving new data field
     * @return schema Attribute GUID
     * @throws InvalidParameterException the dataField is invalid or the annotation GUID points to an annotation
     *                                   that can not be associated with a data field.
     * @throws UserNotAuthorizedException the user id not authorized to issue this request
     * @throws PropertyServerException there was a problem  adding the data field to the Annotation store.
     */
    private String getSchemaAttributeForTypeDef(String                   openMetadataTypeName,
                                                AssetUniverse            assetUniverse,
                                                AtlasStructDef           atlasTypeDef,
                                                String                   atlasCategoryName,
                                                Set<String>              atlasSuperTypes,
                                                OpenMetadataStore        openMetadataStore) throws InvalidParameterException,
                                                                                                   PropertyServerException,
                                                                                                   UserNotAuthorizedException
    {
        if (atlasTypeDef != null)
        {
            String typeAttributeGUID = typeNameToDataFieldGUIDMap.get(atlasTypeDef.getName());

            if (typeAttributeGUID == null)
            {
                /*
                 * This is a new type
                 */
                String qualifiedName = assetUniverse.getQualifiedName() + "_" + atlasCategoryName + "_" + atlasTypeDef.getName();
                ElementProperties elementProperties = propertyHelper.addStringProperty(null,
                                                                                       OpenMetadataProperty.QUALIFIED_NAME.name,
                                                                                       qualifiedName);

                elementProperties = propertyHelper.addStringProperty(elementProperties,
                                                                     OpenMetadataProperty.DISPLAY_NAME.name,
                                                                     atlasTypeDef.getName());

                elementProperties = propertyHelper.addStringProperty(elementProperties,
                                                                     OpenMetadataProperty.DESCRIPTION.name,
                                                                     atlasTypeDef.getDescription());

                elementProperties = propertyHelper.addStringProperty(elementProperties,
                                                                     OpenMetadataProperty.DESCRIPTION.name,
                                                                     atlasTypeDef.getDescription());

                elementProperties = propertyHelper.addStringArrayProperty(elementProperties,
                                                                          OpenMetadataType.ALIASES_PROPERTY_NAME,
                                                                          new ArrayList<>(atlasSuperTypes));


                ElementProperties typeProperties = propertyHelper.addStringProperty(null,
                                                                                    OpenMetadataProperty.QUALIFIED_NAME.name,
                                                                                    qualifiedName + "_type");

                typeProperties = propertyHelper.addStringProperty(typeProperties,
                                                                  OpenMetadataProperty.SCHEMA_TYPE_NAME.name,
                                                                  OpenMetadataType.COMPLEX_SCHEMA_TYPE_TYPE_NAME);

                typeProperties = propertyHelper.addStringProperty(typeProperties,
                                                                  OpenMetadataProperty.DISPLAY_NAME.name,
                                                                  atlasCategoryName);

                typeProperties = propertyHelper.addStringProperty(typeProperties,
                                                                  OpenMetadataType.NAMESPACE_PROPERTY_NAME,
                                                                  atlasTypeDef.getServiceType());

                typeProperties = propertyHelper.addStringProperty(typeProperties,
                                                                  OpenMetadataType.VERSION_NUMBER_PROPERTY_NAME,
                                                                  atlasTypeDef.getTypeVersion());

                Map<String, ElementProperties> initialClassifications = new HashMap<>();

                initialClassifications.put(OpenMetadataType.TYPE_EMBEDDED_ATTRIBUTE_CLASSIFICATION_TYPE_NAME,
                                           typeProperties);

                typeAttributeGUID = openMetadataStore.createMetadataElementInStore(openMetadataTypeName,
                                                                                   ElementStatus.ACTIVE,
                                                                                   initialClassifications,
                                                                                   assetUniverse.getGUID(),
                                                                                   false,
                                                                                   null,
                                                                                   null,
                                                                                   elementProperties,
                                                                                   assetUniverse.getRootSchemaType().getGUID(),
                                                                                   OpenMetadataType.TYPE_TO_ATTRIBUTE_RELATIONSHIP_TYPE_NAME,
                                                                                   null,
                                                                                   true);

                typeNameToDataFieldGUIDMap.put(atlasTypeDef.getName(), typeAttributeGUID);

                this.setUpAttributeSchemaAttributes(typeAttributeGUID,
                                                    qualifiedName,
                                                    assetUniverse.getGUID(),
                                                    atlasTypeDef.getAttributeDefs(),
                                                    openMetadataStore);
            }

            return typeAttributeGUID;
        }

        return null;
    }


    /**
     * Retrieve the list of attributes for this type and create a primitive schema attribute for each, attaching it
     * to the type schema attribute using the NestedSchemaAttribute relationship.
     *
     * @param typeSchemaAttributeGUID unique identifier of the schema attribute that describes the Atlas Type
     * @param typeSchemaAttributeQualifiedName unique name of the schema attribute that describes the Atlas Type
     * @param anchorGUID unique identifier of the Asset for the Apache Atlas Server
     * @param attributeDefs list of attributes from the Atlas TypeDef
     * @param openMetadataStore annotation store for saving new data field
     */
    private void setUpAttributeSchemaAttributes(String                  typeSchemaAttributeGUID,
                                                String                  typeSchemaAttributeQualifiedName,
                                                String                  anchorGUID,
                                                List<AtlasAttributeDef> attributeDefs,
                                                OpenMetadataStore       openMetadataStore) throws InvalidParameterException,
                                                                                                  PropertyServerException,
                                                                                                  UserNotAuthorizedException
    {
        if (attributeDefs != null)
        {
            for (AtlasAttributeDef attributeDef : attributeDefs)
            {
                if (attributeDef != null)
                {
                    setUpAttributeSchemaAttribute(typeSchemaAttributeGUID,
                                                  typeSchemaAttributeQualifiedName,
                                                  anchorGUID,
                                                  attributeDef,
                                                  openMetadataStore);
                }
            }
        }
    }


    /**
     *Create a primitive schema attribute for an Atlas Attribute Type, attaching it
     * to the type schema attribute using the NestedSchemaAttribute relationship.
     *
     * @param typeSchemaAttributeGUID unique identifier of the schema attribute that describes the Atlas Type
     * @param typeSchemaAttributeQualifiedName unique name of the schema attribute that describes the Atlas Type
     * @param anchorGUID unique identifier of the Asset for the Apache Atlas Server
     * @param attributeDef attribute from the Atlas TypeDef
     * @param openMetadataStore annotation store for saving new data field
     */
    private void setUpAttributeSchemaAttribute(String            typeSchemaAttributeGUID,
                                               String            typeSchemaAttributeQualifiedName,
                                               String            anchorGUID,
                                               AtlasAttributeDef attributeDef,
                                               OpenMetadataStore openMetadataStore) throws InvalidParameterException,
                                                                                           PropertyServerException,
                                                                                           UserNotAuthorizedException
    {
        ElementProperties elementProperties = propertyHelper.addStringProperty(null,
                                                                               OpenMetadataProperty.QUALIFIED_NAME.name,
                                                                               typeSchemaAttributeQualifiedName + "_attribute_" + attributeDef.getName());

        elementProperties = propertyHelper.addStringProperty(elementProperties,
                                                             OpenMetadataProperty.DISPLAY_NAME.name,
                                                             attributeDef.getName());

        elementProperties = propertyHelper.addStringProperty(elementProperties,
                                                             OpenMetadataProperty.DESCRIPTION.name,
                                                             attributeDef.getDescription());

        elementProperties = propertyHelper.addIntProperty(elementProperties,
                                                          OpenMetadataType.MIN_CARDINALITY_PROPERTY_NAME,
                                                          attributeDef.getValuesMinCount());

        elementProperties = propertyHelper.addIntProperty(elementProperties,
                                                          OpenMetadataType.MAX_CARDINALITY_PROPERTY_NAME,
                                                          attributeDef.getValuesMaxCount());

        Map<String, ElementProperties> initialClassifications = new HashMap<>();

        ElementProperties classificationProperties = propertyHelper.addStringProperty(null,
                                                                                      OpenMetadataProperty.SCHEMA_TYPE_NAME.name,
                                                                                      OpenMetadataType.PRIMITIVE_SCHEMA_TYPE_TYPE_NAME);

        classificationProperties = propertyHelper.addStringProperty(classificationProperties,
                                                                    OpenMetadataProperty.DATA_TYPE.name,
                                                                    attributeDef.getTypeName());

        classificationProperties = propertyHelper.addStringProperty(classificationProperties,
                                                                    OpenMetadataType.DEFAULT_VALUE_PROPERTY_NAME,
                                                                    attributeDef.getDefaultValue());

        initialClassifications.put(OpenMetadataType.TYPE_EMBEDDED_ATTRIBUTE_CLASSIFICATION_TYPE_NAME,
                                   classificationProperties);

        String schemaAttributeGUID = openMetadataStore.createMetadataElementInStore(OpenMetadataType.SCHEMA_ATTRIBUTE_TYPE_NAME,
                                                                                    ElementStatus.ACTIVE,
                                                                                    initialClassifications,
                                                                                    anchorGUID,
                                                                                    false,
                                                                                    null,
                                                                                    null,
                                                                                    elementProperties,
                                                                                    typeSchemaAttributeGUID,
                                                                                    OpenMetadataType.NESTED_ATTRIBUTE_RELATIONSHIP_TYPE_NAME,
                                                                                    null,
                                                                                    true);

        openMetadataStore.createRelatedElementsInStore(OpenMetadataType.NESTED_ATTRIBUTE_RELATIONSHIP_TYPE_NAME,
                                                       typeSchemaAttributeGUID,
                                                       schemaAttributeGUID,
                                                       null,
                                                       null,
                                                       null);
    }


    /**
     * EntityTypeMetrics maintains counts about entity instances of a certain type.
     */
    public static class EntityTypeMetrics
    {
        private       int                  instanceCount         = 0;
        private final Map<String, Integer> classificationCount   = new HashMap<>();
        private final Map<String, Integer> businessMetadataCount = new HashMap<>();
        private final Map<String, Integer> labelCount            = new HashMap<>();
        private final Map<String, Integer> relationshipEnd1Count = new HashMap<>();
        private final Map<String, Integer> relationshipEnd2Count = new HashMap<>();


        /**
         * Increment the number of instances of entities of a particular type.
         */
        void incrementInstanceCount()
        {
            instanceCount = instanceCount + 1;
        }


        /**
         * Increment the count of a particular classification's attachment to this type of entity.
         *
         * @param classificationName name of the classification.
         */
        void incrementClassificationCount(String classificationName)
        {
            Integer currentCount = classificationCount.get(classificationName);

            if (currentCount == null)
            {
                classificationCount.put(classificationName, 0);
            }
            else
            {
                classificationCount.put(classificationName, currentCount + 1);
            }
        }


        /**
         * Increment the count of a particular business metadata attachment to this type of entity.
         *
         * @param businessMetadataName name of the business metadata properties.
         */
        void incrementBusinessMetadataCount(String businessMetadataName)
        {
            Integer currentCount = businessMetadataCount.get(businessMetadataName);

            if (currentCount == null)
            {
                businessMetadataCount.put(businessMetadataName, 0);
            }
            else
            {
                businessMetadataCount.put(businessMetadataName, currentCount + 1);
            }
        }


        /**
         * Increment the count of a particular label attached to this type of entity.
         *
         * @param label label name
         */
        void incrementLabelCount(String label)
        {
            Integer currentCount = labelCount.get(label);

            if (currentCount == null)
            {
                labelCount.put(label, 0);
            }
            else
            {
                labelCount.put(label, currentCount + 1);
            }
        }


        /**
         * Increment the count of the number of entities of this type that are connected to a particular relationship at end1.
         *
         * @param relationshipTypeName name of attached relationship
         */
        void incrementRelationshipEnd1Count(String relationshipTypeName)
        {
            Integer currentCount = relationshipEnd1Count.get(relationshipTypeName);

            if (currentCount == null)
            {
                relationshipEnd1Count.put(relationshipTypeName, 0);
            }
            else
            {
                relationshipEnd1Count.put(relationshipTypeName, currentCount + 1);
            }
        }


        /**
         * Increment the count of the number of entities of this type that are connected to a particular relationship at end2.
         *
         * @param relationshipTypeName name of attached relationship
         */
        void incrementRelationshipEnd2Count(String relationshipTypeName)
        {
            Integer currentCount = relationshipEnd2Count.get(relationshipTypeName);

            if (currentCount == null)
            {
                relationshipEnd2Count.put(relationshipTypeName, 0);
            }
            else
            {
                relationshipEnd2Count.put(relationshipTypeName, currentCount + 1);
            }
        }
    }


    /**
     * TagTypeMetrics maintains counts of the classifications or business metadata attached to this type of entity.
     */
    public static class TagTypeMetrics
    {
        private int                        instanceCount = 0;
        private final Map<String, Integer> entityCount = new HashMap<>();


        /**
         * Increment the count of the instances of this classification
         */
        void incrementInstanceCount()
        {
            instanceCount = instanceCount + 1;
        }


        /**
         * Increment the count of the attachment of this type of classification to a particular entity.
         *
         * @param entityTypeName entity type name
         */
        void incrementEntityCount(String entityTypeName)
        {
            Integer currentCount = entityCount.get(entityTypeName);

            if (currentCount == null)
            {
                entityCount.put(entityTypeName, 0);
            }
            else
            {
                entityCount.put(entityTypeName, currentCount + 1);
            }
        }
    }


    /**
     * RelationshipTypeMetrics manages counts of the usage of a particular relationship type
     */
    public static class RelationshipTypeMetrics
    {
        private int                        instanceCount = 0;
        private final Map<String, Integer> entityAtEnd1Count = new HashMap<>();
        private final Map<String, Integer> entityAtEnd2Count = new HashMap<>();
        private final Map<String, Integer> entityPairCount   = new HashMap<>();


        /**
         * Increment the count of the number of instances of this relationship.
         */
        void incrementInstanceCount()
        {
            instanceCount = instanceCount + 1;
        }


        /**
         * Increment the count of entities of a particular type connected at end 1 of this relationship.
         *
         * @param entityTypeName entity type
         */
        void incrementEntityAtEnd1Count(String entityTypeName)
        {
            Integer currentCount = entityAtEnd1Count.get(entityTypeName);

            if (currentCount == null)
            {
                entityAtEnd1Count.put(entityTypeName, 0);
            }
            else
            {
                entityAtEnd1Count.put(entityTypeName, currentCount + 1);
            }
        }


        /**
         * Increment the count of entities of a particular type connected at end 2 of this relationship.
         *
         * @param entityTypeName entity type
         */
        void incrementEntityAtEnd2Count(String entityTypeName)
        {
            Integer currentCount = entityAtEnd2Count.get(entityTypeName);

            if (currentCount == null)
            {
                entityAtEnd2Count.put(entityTypeName, 0);
            }
            else
            {
                entityAtEnd2Count.put(entityTypeName, currentCount + 1);
            }
        }


        /**
         * Increment the count of entities of particular types connected via this relationship.
         *
         * @param entityOneTypeName entity type
         * @param entityTwoTypeName entity type
         */
        void incrementEntityPairCount(String entityOneTypeName,
                                      String entityTwoTypeName)
        {
            String pairName = entityOneTypeName + ":" + entityTwoTypeName;

            Integer currentCount = entityPairCount.get(pairName);

            if (currentCount == null)
            {
                entityPairCount.put(pairName, 0);
            }
            else
            {
                entityPairCount.put(entityOneTypeName, currentCount + 1);
            }
        }
    }
}