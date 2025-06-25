/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.converters;

import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.ConnectorTypeElement;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.AttributedMetadataElement;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.SolutionRoleElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.OpenMetadataElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.RelatedMetadataElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.actors.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.connections.ConnectorTypeProperties;
import org.odpi.openmetadata.frameworks.openmetadata.search.ElementProperties;
import org.odpi.openmetadata.frameworks.openmetadata.search.PropertyHelper;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataProperty;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;


/**
 * ConnectorTypeConverter provides common methods for transferring relevant properties from an Open Metadata Element
 * object into a bean that inherits from ConnectorTypeElement.
 */
public class ConnectorTypeConverter<B> extends AttributedElementConverterBase<B>
{
    /**
     * Constructor
     *
     * @param propertyHelper helper object to parse entity
     * @param serviceName name of this component
     * @param serverName local server name
     */
    public ConnectorTypeConverter(PropertyHelper propertyHelper,
                                  String         serviceName,
                                  String         serverName)
    {
        super(propertyHelper, serviceName, serverName);
    }


    /**
     * Uses the type of the entity to determine the type of bean to use for the properties.
     *
     * @param beanClass element bean class
     * @param openMetadataElement element retrieved
     * @param methodName calling method
     * @return properties
     * @throws PropertyServerException problem in conversion
     */
    protected ConnectorTypeProperties getConnectorTypeProperties(Class<B>            beanClass,
                                                                 OpenMetadataElement openMetadataElement,
                                                                 String              methodName) throws PropertyServerException
    {
        if (openMetadataElement != null)
        {
            ElementProperties elementProperties = new ElementProperties(openMetadataElement.getElementProperties());

            ConnectorTypeProperties connectorTypeProperties = new ConnectorTypeProperties();

            /*
             * These are the standard properties for an actor role.
             */
            connectorTypeProperties.setQualifiedName(this.removeQualifiedName(elementProperties));
            connectorTypeProperties.setAdditionalProperties(this.removeAdditionalProperties(elementProperties));
            connectorTypeProperties.setDisplayName(this.removeDisplayName(elementProperties));
            connectorTypeProperties.setDescription(this.removeDescription(elementProperties));
            connectorTypeProperties.setSupportedAssetTypeName(this.removeSupportedAssetTypeName(elementProperties));

            /*
             * Any remaining properties are returned in the extended properties.  They are
             * assumed to be defined in a subtype.
             */
            connectorTypeProperties.setTypeName(openMetadataElement.getType().getTypeName());
            connectorTypeProperties.setExtendedProperties(this.getRemainingExtendedProperties(elementProperties));

            return connectorTypeProperties;
        }
        else
        {
            handleMissingMetadataInstance(beanClass.getName(), OpenMetadataElement.class.getName(), methodName);
        }

        return null;
    }


    /**
     * Using the supplied entity, return a new instance of the bean. This is used for most beans that have
     * a one to one correspondence with the repository instances.
     *
     * @param beanClass name of the class to create
     * @param openMetadataElement openMetadataElement containing the properties
     * @param methodName calling method
     * @return bean populated with properties from the entity supplied
     * @throws PropertyServerException there is a problem instantiating the bean
     */
    @Override
    public B getNewBean(Class<B>            beanClass,
                        OpenMetadataElement openMetadataElement,
                        String              methodName) throws PropertyServerException
    {
        try
        {
            /*
             * This is initial confirmation that the generic converter has been initialized with an appropriate bean class.
             */
            B returnBean = beanClass.getDeclaredConstructor().newInstance();

            if (returnBean instanceof ConnectorTypeElement bean)
            {
                bean.setElementHeader(super.getMetadataElementHeader(beanClass, openMetadataElement, methodName));
                bean.setProperties(getConnectorTypeProperties(beanClass, openMetadataElement, methodName));
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
     * Using the supplied instances, return a new instance of the bean.  It is used for beans such as
     * an Annotation or To Do bean which combine knowledge from the element and its linked relationships.
     *
     * @param beanClass name of the class to create
     * @param primaryElement element that is the root of the collection of entities that make up the
     *                      content of the bean
     * @param relationships relationships linking the entities
     * @param methodName calling method
     * @return bean populated with properties from the instances supplied
     * @throws PropertyServerException there is a problem instantiating the bean
     */
    public B getNewComplexBean(Class<B>                     beanClass,
                               OpenMetadataElement          primaryElement,
                               List<RelatedMetadataElement> relationships,
                               String                       methodName) throws PropertyServerException
    {
        B returnBean = this.getNewBean(beanClass, primaryElement, methodName);

        if (returnBean instanceof SolutionRoleElement bean)
        {
            if (relationships != null)
            {
                bean.setExternalReferences(super.getAttribution(beanClass, relationships));
                bean.setSolutionComponents(super.getRelatedElements(beanClass,
                                                                    OpenMetadataType.SOLUTION_COMPONENT_ACTOR_RELATIONSHIP.typeName,
                                                                    relationships));
                bean.setOtherRelatedElements(this.getOtherRelatedElements(beanClass,
                                                                          relationships,
                                                                          Arrays.asList(OpenMetadataType.EXTERNAL_REFERENCE_LINK_RELATIONSHIP.typeName,
                                                                                        OpenMetadataType.SOLUTION_COMPONENT_ACTOR_RELATIONSHIP.typeName)));
            }
        }
        else if (returnBean instanceof AttributedMetadataElement bean)
        {
            if (relationships != null)
            {
                bean.setExternalReferences(super.getAttribution(beanClass, relationships));
                bean.setOtherRelatedElements(this.getOtherRelatedElements(beanClass,
                                                                          relationships,
                                                                          null));
            }
        }

        return returnBean;
    }


    /**
     * Using the supplied instances, return a new instance of the bean.  It is used for beans such as
     * an Annotation or To Do bean which combine knowledge from the element and its linked relationships.
     *
     * @param beanClass name of the class to create
     * @param primaryElement element that is the root of the collection of entities that make up the
     *                      content of the bean
     * @param relationships relationships linking the entities
     * @param methodName calling method
     * @return bean populated with properties from the instances supplied
     * @throws PropertyServerException there is a problem instantiating the bean
     */
    @SuppressWarnings(value = "unused")
    public B getNewComplexBean(Class<B>                     beanClass,
                               RelatedMetadataElement       primaryElement,
                               List<RelatedMetadataElement> relationships,
                               String                       methodName) throws PropertyServerException
    {
        B returnBean = this.getNewBean(beanClass, primaryElement, methodName);

        if (returnBean instanceof SolutionRoleElement bean)
        {
            if (relationships != null)
            {
                bean.setExternalReferences(super.getAttribution(beanClass, relationships));
                bean.setSolutionComponents(super.getRelatedElements(beanClass,
                                                                    OpenMetadataType.SOLUTION_COMPONENT_ACTOR_RELATIONSHIP.typeName,
                                                                    relationships));
                bean.setOtherRelatedElements(this.getOtherRelatedElements(beanClass,
                                                                          relationships,
                                                                          Arrays.asList(OpenMetadataType.EXTERNAL_REFERENCE_LINK_RELATIONSHIP.typeName,
                                                                                        OpenMetadataType.SOLUTION_COMPONENT_ACTOR_RELATIONSHIP.typeName)));
            }
        }
        else if (returnBean instanceof AttributedMetadataElement bean)
        {
            if (relationships != null)
            {
                bean.setExternalReferences(super.getAttribution(beanClass, relationships));
                bean.setOtherRelatedElements(this.getOtherRelatedElements(beanClass,
                                                                          relationships,
                                                                          null));
            }
        }

        return returnBean;
    }
}
