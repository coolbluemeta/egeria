/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.commonservices.generichandlers;

import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.DataFileElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.assets.filesandfolders.DataFileProperties;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;
import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EntityDetail;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProperties;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Relationship;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefCategory;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryHelper;

import java.lang.reflect.InvocationTargetException;

/**
 * DataFileConverter transfers the relevant properties from an Open Metadata Repository Services (OMRS)
 * EntityDetail object into a DataFileElement bean.
 */
public class DataFileConverter<B> extends OMFConverter<B>
{
    /**
     * Constructor
     *
     * @param repositoryHelper helper object to parse entity/relationship objects
     * @param serviceName name of this component
     * @param serverName local server name
     */
    public DataFileConverter(OMRSRepositoryHelper repositoryHelper,
                             String               serviceName,
                             String               serverName)
    {
        super(repositoryHelper, serviceName, serverName);
    }


    /**
     * Using the supplied instances, return a new instance of the bean. This is used for beans that
     * contain a combination of the properties from an entity and that of a connected relationship.
     *
     * @param beanClass name of the class to create
     * @param entity entity containing the properties
     * @param methodName calling method
     * @return bean populated with properties from the instances supplied
     * @throws PropertyServerException there is a problem instantiating the bean
     */
    @Override
    public B getNewBean(Class<B>     beanClass,
                        EntityDetail entity,
                        String       methodName) throws PropertyServerException
    {
        try
        {
            /*
             * This is initial confirmation that the generic converter has been initialized with an appropriate bean class.
             */
            B returnBean = beanClass.getDeclaredConstructor().newInstance();

            if (returnBean instanceof DataFileElement bean)
            {
                DataFileProperties fileProperties = new DataFileProperties();

                bean.setElementHeader(super.getMetadataElementHeader(beanClass, entity, methodName));

                InstanceProperties instanceProperties;

                /*
                 * The initial set of values come from the entity.
                 */
                if (entity != null)
                {
                    instanceProperties = new InstanceProperties(entity.getProperties());

                    fileProperties.setQualifiedName(this.removeQualifiedName(instanceProperties));
                    fileProperties.setAdditionalProperties(this.removeAdditionalProperties(instanceProperties));
                    fileProperties.setName(this.removeName(instanceProperties));
                    fileProperties.setResourceName(this.removeResourceName(instanceProperties));
                    fileProperties.setVersionIdentifier(this.removeVersionIdentifier(instanceProperties));
                    fileProperties.setResourceDescription(this.removeDescription(instanceProperties));
                    fileProperties.setPathName(this.removePathName(instanceProperties));
                    fileProperties.setCreateTime(this.removeStoreCreateTime(instanceProperties));
                    fileProperties.setModifiedTime(this.removeStoreUpdateTime(instanceProperties));
                    fileProperties.setDeployedImplementationType(this.removeDeployedImplementationType(instanceProperties));
                    fileProperties.setFileName(this.removeFileName(instanceProperties));
                    fileProperties.setFileType(this.removeFileType(instanceProperties));
                    fileProperties.setFileExtension(this.removeFileExtension(instanceProperties));

                    /*
                     * Any remaining properties are returned in the extended properties.  They are
                     * assumed to be defined in a subtype.
                     */
                    fileProperties.setTypeName(bean.getElementHeader().getType().getTypeName());
                    fileProperties.setExtendedProperties(this.getRemainingExtendedProperties(instanceProperties));

                    instanceProperties = super.getClassificationProperties(OpenMetadataType.DATA_ASSET_ENCODING_CLASSIFICATION.typeName, entity);

                    fileProperties.setEncodingType(this.getDataStoreEncodingType(instanceProperties));
                    fileProperties.setEncodingLanguage(this.getDataStoreEncodingLanguage(instanceProperties));
                    fileProperties.setEncodingDescription(this.getDataStoreEncodingDescription(instanceProperties));
                    fileProperties.setEncodingProperties(this.getEncodingProperties(instanceProperties));

                    bean.setProperties(fileProperties);
                }
                else
                {
                    handleMissingMetadataInstance(beanClass.getName(), TypeDefCategory.ENTITY_DEF, methodName);
                }
            }

            return returnBean;
        }
        catch (IllegalAccessException | InstantiationException | ClassCastException | NoSuchMethodException | InvocationTargetException error)
        {
            super.handleInvalidBeanClass(beanClass.getName(), error, methodName);
        }

        return null;
    }


    /**
     * Using the supplied instances, return a new instance of the bean. This is used for beans that
     * contain a combination of the properties from an entity and that of a connected relationship.
     *
     * @param beanClass name of the class to create
     * @param entity entity containing the properties
     * @param relationship relationship containing the properties
     * @param methodName calling method
     * @return bean populated with properties from the instances supplied
     * @throws PropertyServerException there is a problem instantiating the bean
     */
    @Override
    public B getNewBean(Class<B>     beanClass,
                        EntityDetail entity,
                        Relationship relationship,
                        String       methodName) throws PropertyServerException
    {
        return getNewBean(beanClass, entity, methodName);
    }
}
