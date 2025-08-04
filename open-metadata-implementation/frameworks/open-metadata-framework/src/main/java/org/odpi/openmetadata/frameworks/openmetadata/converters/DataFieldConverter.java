/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.converters;

import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.DataFieldElement;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.RelatedMetadataElementSummary;
import org.odpi.openmetadata.frameworks.openmetadata.properties.OpenMetadataElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.RelatedMetadataElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.datadictionaries.DataFieldProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.datadictionaries.MemberDataFieldProperties;
import org.odpi.openmetadata.frameworks.openmetadata.search.ElementProperties;
import org.odpi.openmetadata.frameworks.openmetadata.search.PropertyHelper;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * DataFieldConverter generates a DataFieldElement from a DataField entity
 * and related elements.
 */
public class DataFieldConverter<B> extends DataDefinitionConverterBase<B>
{
    /**
     * Constructor
     *
     * @param propertyHelper helper object to parse entity
     * @param serviceName name of this component
     * @param serverName local server name
     */
    public DataFieldConverter(PropertyHelper propertyHelper,
                              String         serviceName,
                              String         serverName)
    {
        super(propertyHelper, serviceName, serverName);
    }


    /**
     * Using the supplied instances, return a new instance of the bean.  It is used for beans such as
     * an Annotation or To Do bean which combine knowledge from the element and its linked relationships.
     *
     * @param beanClass name of the class to create
     * @param primaryElement element that is the root of the collection of entities that make up the
     *                      content of the bean
     * @param methodName calling method
     * @return bean populated with properties from the instances supplied
     * @throws PropertyServerException there is a problem instantiating the bean
     */
    public B getNewBean(Class<B>                     beanClass,
                        OpenMetadataElement          primaryElement,
                        String                       methodName) throws PropertyServerException
    {
        try
        {
            /*
             * This is initial confirmation that the generic converter has been initialized with an appropriate bean class.
             */
            B returnBean = beanClass.getDeclaredConstructor().newInstance();

            if (returnBean instanceof DataFieldElement bean)
            {
                bean.setElementHeader(super.getMetadataElementHeader(beanClass, primaryElement, methodName));

                if (primaryElement == null)
                {
                    handleMissingMetadataInstance(beanClass.getName(), OpenMetadataElement.class.getName(), methodName);
                }
                else
                {
                    bean.setProperties(this.getDataFieldProperties(primaryElement));
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
     * Retrieve the data field properties from the retrieved element.
     *
     * @param primaryElement element
     *
     * @return dataStructure properties
     */
    protected DataFieldProperties getDataFieldProperties(OpenMetadataElement primaryElement)
    {
        if (primaryElement.getElementProperties() != null)
        {
            ElementProperties   elementProperties   = new ElementProperties(primaryElement.getElementProperties());
            DataFieldProperties dataFieldProperties = new DataFieldProperties();

            dataFieldProperties.setQualifiedName(this.removeQualifiedName(elementProperties));
            dataFieldProperties.setAdditionalProperties(this.removeAdditionalProperties(elementProperties));
            dataFieldProperties.setDisplayName(this.removeDisplayName(elementProperties));
            dataFieldProperties.setNamespace(this.removeNamespace(elementProperties));
            dataFieldProperties.setAliases(this.removeAliases(elementProperties));
            dataFieldProperties.setNamePatterns(this.removeNamePatterns(elementProperties));
            dataFieldProperties.setDescription(this.removeDescription(elementProperties));
            dataFieldProperties.setUserDefinedStatus(this.removeUserDefinedStatus(elementProperties));
            dataFieldProperties.setVersionIdentifier(this.removeVersionIdentifier(elementProperties));
            dataFieldProperties.setDefaultValue(this.removeDefaultValue(elementProperties));
            dataFieldProperties.setIsNullable(this.removeIsNullable(elementProperties));
            dataFieldProperties.setDataType(this.removeDataType(elementProperties));
            dataFieldProperties.setUnits(this.removeUnits(elementProperties));
            dataFieldProperties.setMinimumLength(this.removeMinimumLength(elementProperties));
            dataFieldProperties.setLength(this.removeLength(elementProperties));
            dataFieldProperties.setPrecision(this.removePrecision(elementProperties));
            dataFieldProperties.setOrderedValues(this.removeOrderedValues(elementProperties));
            dataFieldProperties.setSortOrder(this.removeDataItemSortOrder(elementProperties));
            dataFieldProperties.setEffectiveFrom(primaryElement.getEffectiveFromTime());
            dataFieldProperties.setEffectiveTo(primaryElement.getEffectiveToTime());

            /*
             * Any remaining properties are returned in the extended properties.  They are
             * assumed to be defined in a subtype.
             */
            dataFieldProperties.setTypeName(primaryElement.getType().getTypeName());
            dataFieldProperties.setExtendedProperties(this.getRemainingExtendedProperties(elementProperties));

            return dataFieldProperties;
        }

        return null;
    }


    /**
     * Retrieve the member data field properties from the retrieved relationship.
     *
     * @param relatedMetadataElement element
     *
     * @return member data field properties
     */
    public MemberDataFieldProperties getMemberDataFieldProperties(RelatedMetadataElement relatedMetadataElement)
    {
        if (relatedMetadataElement.getRelationshipProperties() != null)
        {
            ElementProperties         elementProperties   = new ElementProperties(relatedMetadataElement.getRelationshipProperties());
            MemberDataFieldProperties dataFieldProperties = new MemberDataFieldProperties();

            dataFieldProperties.setPosition(this.removePosition(elementProperties));
            dataFieldProperties.setMaxCardinality(this.removeMaxCardinality(elementProperties));
            dataFieldProperties.setMinCardinality(this.removeMinCardinality(elementProperties));

            dataFieldProperties.setEffectiveFrom(relatedMetadataElement.getEffectiveFromTime());
            dataFieldProperties.setEffectiveTo(relatedMetadataElement.getEffectiveToTime());

            /*
             * Any remaining properties are returned in the extended properties.  They are
             * assumed to be defined in a subtype.
             */
            dataFieldProperties.setExtendedProperties(this.getRemainingExtendedProperties(elementProperties));

            return dataFieldProperties;
        }

        return null;
    }


    /**
     * Summarize the relationships that have no special processing by the subtype.
     *
     * @param beanClass bean class
     * @param relatedMetadataElements elements to summarize
     * @throws PropertyServerException problem in converter
     */
    private void addRelationshipsToBean(Class<B>                     beanClass,
                                        List<RelatedMetadataElement> relatedMetadataElements,
                                        DataFieldElement             dataFieldElement) throws PropertyServerException
    {
        final String methodName = "addRelationshipToBean";

        if (relatedMetadataElements != null)
        {
            /*
             * These are the relationships for the data definition element
             */
            List<RelatedMetadataElementSummary> dataClassDefinitions = new ArrayList<>();
            List<RelatedMetadataElement>        others               = new ArrayList<>();

            /*
             * Step through the relationships processing those that relate directly to attributed elements
             */
            for (RelatedMetadataElement relatedMetadataElement: relatedMetadataElements)
            {
                if (relatedMetadataElement != null)
                {
                    if ((propertyHelper.isTypeOf(relatedMetadataElement, OpenMetadataType.DATA_CLASS_DEFINITION_RELATIONSHIP.typeName)) && (! relatedMetadataElement.getElementAtEnd1()))
                    {
                        dataClassDefinitions.add(this.getRelatedElementSummary(beanClass, relatedMetadataElement, methodName));
                    }
                    else
                    {
                        others.add(relatedMetadataElement);
                    }
                }
            }

            if (! dataClassDefinitions.isEmpty())
            {
                dataFieldElement.setAssignedDataClasses(dataClassDefinitions);
            }

            super.addRelationshipsToBean(beanClass, others, dataFieldElement);
        }
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
        try
        {
            /*
             * This is initial confirmation that the generic converter has been initialized with an appropriate bean class.
             */
            B returnBean = beanClass.getDeclaredConstructor().newInstance();

            if (returnBean instanceof DataFieldElement bean)
            {

                /*
                 * The initial set of values come from the openMetadataElement.
                 */
                if (primaryElement != null)
                {
                    bean.setElementHeader(super.getMetadataElementHeader(beanClass, primaryElement, methodName));
                    bean.setProperties(this.getDataFieldProperties(primaryElement));
                }
                else
                {
                    handleMissingMetadataInstance(beanClass.getName(), OpenMetadataElement.class.getName(), methodName);
                }

                if (relationships != null)
                {
                    this.addRelationshipsToBean(beanClass, relationships, bean);
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
}
