/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.metadatasecurity;

import org.odpi.openmetadata.frameworks.openmetadata.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.UserNotAuthorizedException;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.*;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.AttributeTypeDef;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDef;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefPatch;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefSummary;

import java.util.List;

/**
 * OpenMetadataRepositorySecurity defines security checks for accessing and maintaining open metadata types
 * and instances in the local repository.
 * An instance is an entity or a relationship.  There are also special methods for changing classifications
 * added to an entity.
 */
public interface OpenMetadataRepositorySecurity
{
    /**
     * Tests for whether a specific user should have the right to create a type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param typeDef type details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForTypeCreate(String  userId,
                                    String  metadataCollectionName,
                                    TypeDef typeDef) throws UserNotAuthorizedException,
                                                            InvalidParameterException,
                                                            PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to create a type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param attributeTypeDef type details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForTypeCreate(String           userId,
                                    String           metadataCollectionName,
                                    AttributeTypeDef attributeTypeDef) throws UserNotAuthorizedException,
                                                                              InvalidParameterException,
                                                                              PropertyServerException;


    /**
     * Tests for whether a specific user should have read access to a specific type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param typeDef type details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForTypeRead(String  userId,
                                  String  metadataCollectionName,
                                  TypeDef typeDef) throws UserNotAuthorizedException,
                                                          InvalidParameterException,
                                                          PropertyServerException;


    /**
     * Tests for whether a specific user should have read access to a specific type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param attributeTypeDef type details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForTypeRead(String           userId,
                                  String           metadataCollectionName,
                                  AttributeTypeDef attributeTypeDef) throws UserNotAuthorizedException,
                                                                            InvalidParameterException,
                                                                            PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to update a type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param typeDef current type details
     * @param patch proposed changes to type
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForTypeUpdate(String       userId,
                                    String       metadataCollectionName,
                                    TypeDef      typeDef,
                                    TypeDefPatch patch) throws UserNotAuthorizedException,
                                                               InvalidParameterException,
                                                               PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to delete a type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param typeDef type details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForTypeDelete(String  userId,
                                    String  metadataCollectionName,
                                    TypeDef typeDef) throws UserNotAuthorizedException,
                                                            InvalidParameterException,
                                                            PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to delete a type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param attributeTypeDef type details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForTypeDelete(String           userId,
                                    String           metadataCollectionName,
                                    AttributeTypeDef attributeTypeDef) throws UserNotAuthorizedException,
                                                                              InvalidParameterException,
                                                                              PropertyServerException;

    /**
     * Tests for whether a specific user should have the right to change the identifiers for a type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param originalTypeDef type details
     * @param newTypeDefGUID the new identifier for the type.
     * @param newTypeDefName new name for this type.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForTypeReIdentify(String  userId,
                                        String  metadataCollectionName,
                                        TypeDef originalTypeDef,
                                        String  newTypeDefGUID,
                                        String  newTypeDefName) throws UserNotAuthorizedException,
                                                                       InvalidParameterException,
                                                                       PropertyServerException;

    /**
     * Tests for whether a specific user should have the right to change the identifiers for a type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param originalAttributeTypeDef type details
     * @param newTypeDefGUID the new identifier for the type.
     * @param newTypeDefName new name for this type.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForTypeReIdentify(String           userId,
                                        String           metadataCollectionName,
                                        AttributeTypeDef originalAttributeTypeDef,
                                        String           newTypeDefGUID,
                                        String           newTypeDefName) throws UserNotAuthorizedException,
                                                                                InvalidParameterException,
                                                                                PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to create an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param entityTypeGUID unique identifier (guid) for the new entity's type.
     * @param initialProperties initial list of properties for the new entity null means no properties.
     * @param initialClassifications initial list of classifications for the new entity null means no classifications.
     * @param initialStatus initial status typically DRAFT, PREPARED or ACTIVE.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityCreate(String               userId,
                                      String               metadataCollectionName,
                                      String               entityTypeGUID,
                                      InstanceProperties   initialProperties,
                                      List<Classification> initialClassifications,
                                      InstanceStatus       initialStatus) throws UserNotAuthorizedException,
                                                                                 InvalidParameterException,
                                                                                 PropertyServerException;


    /**
     * Tests for whether a specific user should have read access to a specific instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @return entity to return (maybe altered by the connector)
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    EntityDetail validateUserForEntityRead(String       userId,
                                           String       metadataCollectionName,
                                           EntityDetail instance) throws UserNotAuthorizedException,
                                                                         InvalidParameterException,
                                                                         PropertyServerException;


    /**
     * Tests for whether a specific user should have read access to a specific instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntitySummaryRead(String        userId,
                                           String        metadataCollectionName,
                                           EntitySummary instance) throws UserNotAuthorizedException,
                                                                          InvalidParameterException,
                                                                          PropertyServerException;


    /**
     * Tests for whether a specific user should have read access to a specific instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityProxyRead(String      userId,
                                         String      metadataCollectionName,
                                         EntityProxy instance) throws UserNotAuthorizedException,
                                                                      InvalidParameterException,
                                                                      PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to update an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityUpdate(String       userId,
                                      String       metadataCollectionName,
                                      EntityDetail instance) throws UserNotAuthorizedException,
                                                                    InvalidParameterException,
                                                                    PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to add a classification to an entity instance
     * within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @param classificationName String name for the classification.
     * @param properties list of properties for the classification.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityClassificationAdd(String               userId,
                                                 String               metadataCollectionName,
                                                 EntitySummary        instance,
                                                 String               classificationName,
                                                 InstanceProperties   properties) throws UserNotAuthorizedException,
                                                                                         InvalidParameterException,
                                                                                         PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to update a classification for an entity instance
     * within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @param classificationName String name for the classification.
     * @param properties list of properties for the classification.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityClassificationUpdate(String               userId,
                                                    String               metadataCollectionName,
                                                    EntitySummary        instance,
                                                    String               classificationName,
                                                    InstanceProperties   properties) throws UserNotAuthorizedException,
                                                                                            InvalidParameterException,
                                                                                            PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to delete a classification from an entity instance
     * within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @param classificationName String name for the classification.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityClassificationDelete(String               userId,
                                                    String               metadataCollectionName,
                                                    EntitySummary        instance,
                                                    String               classificationName) throws UserNotAuthorizedException,
                                                                                                    InvalidParameterException,
                                                                                                    PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to delete an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityDelete(String       userId,
                                      String       metadataCollectionName,
                                      EntityDetail instance) throws UserNotAuthorizedException,
                                                                    InvalidParameterException,
                                                                    PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to restore an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param deletedEntityGUID String unique identifier (guid) for the entity.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityRestore(String       userId,
                                       String       metadataCollectionName,
                                       String       deletedEntityGUID) throws UserNotAuthorizedException,
                                                                              InvalidParameterException,
                                                                              PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to change the guid on an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @param newGUID the new guid for the instance.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityReIdentification(String       userId,
                                                String       metadataCollectionName,
                                                EntityDetail instance,
                                                String       newGUID) throws UserNotAuthorizedException,
                                                                             InvalidParameterException,
                                                                             PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to change an instance's type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @param newTypeDefSummary details of this instance's new TypeDef.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityReTyping(String         userId,
                                        String         metadataCollectionName,
                                        EntityDetail   instance,
                                        TypeDefSummary newTypeDefSummary) throws UserNotAuthorizedException,
                                                                                 InvalidParameterException,
                                                                                 PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to change the home of an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @param newHomeMetadataCollectionId unique identifier for the new home metadata collection/repository.
     * @param newHomeMetadataCollectionName display name for the new home metadata collection/repository.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForEntityReHoming(String         userId,
                                        String         metadataCollectionName,
                                        EntityDetail   instance,
                                        String         newHomeMetadataCollectionId,
                                        String         newHomeMetadataCollectionName) throws UserNotAuthorizedException,
                                                                                             InvalidParameterException,
                                                                                             PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to create an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param relationshipTypeGUID unique identifier (guid) for the new relationship's type.
     * @param initialProperties initial list of properties for the new entity null means no properties.
     * @param entityOneSummary the unique identifier of one of the entities that the relationship is connecting together.
     * @param entityTwoSummary the unique identifier of the other entity that the relationship is connecting together.
     * @param initialStatus initial status typically DRAFT, PREPARED or ACTIVE.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForRelationshipCreate(String               userId,
                                            String               metadataCollectionName,
                                            String               relationshipTypeGUID,
                                            InstanceProperties   initialProperties,
                                            EntitySummary        entityOneSummary,
                                            EntitySummary        entityTwoSummary,
                                            InstanceStatus       initialStatus) throws UserNotAuthorizedException,
                                                                                       InvalidParameterException,
                                                                                       PropertyServerException;


    /**
     * Tests for whether a specific user should have read access to a specific instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @return relationship to return (maybe altered by the connector)
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    Relationship  validateUserForRelationshipRead(String       userId,
                                                  String       metadataCollectionName,
                                                  Relationship instance) throws UserNotAuthorizedException,
                                                                                InvalidParameterException,
                                                                                PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to update an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForRelationshipUpdate(String       userId,
                                            String       metadataCollectionName,
                                            Relationship instance) throws UserNotAuthorizedException,
                                                                          InvalidParameterException,
                                                                          PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to delete an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForRelationshipDelete(String       userId,
                                            String       metadataCollectionName,
                                            Relationship instance) throws UserNotAuthorizedException,
                                                                          InvalidParameterException,
                                                                          PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to restore an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param deletedRelationshipGUID String unique identifier (guid) for the relationship.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForRelationshipRestore(String       userId,
                                             String       metadataCollectionName,
                                             String       deletedRelationshipGUID) throws UserNotAuthorizedException,
                                                                                          InvalidParameterException,
                                                                                          PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to change the guid on an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @param newGUID the new guid for the instance.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForRelationshipReIdentification(String       userId,
                                                      String       metadataCollectionName,
                                                      Relationship instance,
                                                      String       newGUID) throws UserNotAuthorizedException,
                                                                                   InvalidParameterException,
                                                                                   PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to change an instance's type within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @param newTypeDefSummary details of this instance's new TypeDef.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForRelationshipReTyping(String         userId,
                                              String         metadataCollectionName,
                                              Relationship   instance,
                                              TypeDefSummary newTypeDefSummary) throws UserNotAuthorizedException,
                                                                                       InvalidParameterException,
                                                                                       PropertyServerException;


    /**
     * Tests for whether a specific user should have the right to change the home of an instance within a repository.
     *
     * @param userId identifier of user
     * @param metadataCollectionName configurable name of the metadata collection
     * @param instance instance details
     * @param newHomeMetadataCollectionId unique identifier for the new home metadata collection/repository.
     * @param newHomeMetadataCollectionName display name for the new home metadata collection/repository.
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    void  validateUserForRelationshipReHoming(String         userId,
                                              String         metadataCollectionName,
                                              Relationship   instance,
                                              String         newHomeMetadataCollectionId,
                                              String         newHomeMetadataCollectionName) throws UserNotAuthorizedException,
                                                                                                   InvalidParameterException,
                                                                                                   PropertyServerException;


    /**
     * Tests for whether a reference copy should be saved to the repository.
     *
     * @param userId identifier of user
     * @param instance instance details
     * @return flag indicating whether the reference copy should be saved
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    boolean  validateEntityReferenceCopySave(String       userId,
                                             EntityDetail instance) throws UserNotAuthorizedException,
                                                                           InvalidParameterException,
                                                                           PropertyServerException;


    /**
     * Tests for whether a reference copy should be saved to the repository.
     *
     * @param userId identifier of user
     * @param instance instance details
     * @return flag indicating whether the reference copy should be saved
     * @throws InvalidParameterException  one of the elements is invisible to the requesting user.
     * @throws UserNotAuthorizedException the requesting user is not authorized to issue this request.
     * @throws PropertyServerException unable to retrieve necessary information to make the decision.
     */
    boolean  validateRelationshipReferenceCopySave(String       userId,
                                                   Relationship instance) throws UserNotAuthorizedException,
                                                                                 InvalidParameterException,
                                                                                 PropertyServerException;
}

