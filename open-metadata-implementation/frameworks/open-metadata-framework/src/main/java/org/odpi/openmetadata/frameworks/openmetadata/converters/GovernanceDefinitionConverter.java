/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.converters;

import org.odpi.openmetadata.frameworks.openmetadata.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.GovernanceDefinitionElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.OpenMetadataElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.OpenMetadataRelationship;
import org.odpi.openmetadata.frameworks.openmetadata.properties.RelatedMetadataElement;
import org.odpi.openmetadata.frameworks.openmetadata.properties.governance.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.security.SecurityGroupProperties;
import org.odpi.openmetadata.frameworks.openmetadata.search.ElementProperties;
import org.odpi.openmetadata.frameworks.openmetadata.search.PropertyHelper;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


/**
 * GovernanceDefinitionConverter provides common methods for transferring relevant properties from an Open Metadata Repository Services (OMRS)
 * EntityDetail object into a bean that inherits from GovernanceDefinitionElement.
 */
public class GovernanceDefinitionConverter<B>  extends OpenMetadataConverterBase<B>
{
    /**
     * Constructor
     *
     * @param propertyHelper helper object to parse entity
     * @param serviceName name of this component
     * @param serverName local server name
     */
    public GovernanceDefinitionConverter(PropertyHelper propertyHelper,
                                         String         serviceName,
                                         String         serverName)
    {
        super(propertyHelper, serviceName, serverName);
    }


    protected  GovernanceDefinitionProperties getGovernanceDefinitionProperties(Class<B>            beanClass,
                                                                                OpenMetadataElement openMetadataElement,
                                                                                String              methodName) throws PropertyServerException
    {
        if (openMetadataElement != null)
        {
            GovernanceDefinitionProperties governanceDefinitionProperties;

            /*
             * The initial set of values come from the entity.
             */
            ElementProperties elementProperties = new ElementProperties(openMetadataElement.getElementProperties());

            if (propertyHelper.isTypeOf(openMetadataElement, OpenMetadataType.CERTIFICATION_TYPE.typeName))
            {
                governanceDefinitionProperties = new CertificationTypeProperties();

                ((CertificationTypeProperties) governanceDefinitionProperties).setDetails(this.removeDetails(elementProperties));
            }
            else if (propertyHelper.isTypeOf(openMetadataElement, OpenMetadataType.LICENSE_TYPE.typeName))
            {
                governanceDefinitionProperties = new LicenseTypeProperties();

                ((LicenseTypeProperties) governanceDefinitionProperties).setDetails(this.removeDetails(elementProperties));
            }
            else if (propertyHelper.isTypeOf(openMetadataElement, OpenMetadataType.REGULATION.typeName))
            {
                governanceDefinitionProperties = new RegulationProperties();

                ((RegulationProperties) governanceDefinitionProperties).setJurisdiction(this.removeJurisdiction(elementProperties));
            }
            else if (propertyHelper.isTypeOf(openMetadataElement, OpenMetadataType.GOVERNANCE_STRATEGY.typeName))
            {
                governanceDefinitionProperties = new GovernanceStrategyProperties();

                ((GovernanceStrategyProperties) governanceDefinitionProperties).setBusinessImperatives(this.removeBusinessImperatives(elementProperties));
            }
            else if (propertyHelper.isTypeOf(openMetadataElement, OpenMetadataType.GOVERNANCE_CONTROL.typeName))
            {
                if (propertyHelper.isTypeOf(openMetadataElement, OpenMetadataType.SECURITY_GROUP.typeName))
                {
                    governanceDefinitionProperties = new SecurityGroupProperties();

                    ((SecurityGroupProperties) governanceDefinitionProperties).setDistinguishedName(this.removeDistinguishedName(elementProperties));
                }
                else if (propertyHelper.isTypeOf(openMetadataElement, OpenMetadataType.NAMING_STANDARD_RULE.typeName))
                {
                    governanceDefinitionProperties = new NamingStandardRuleProperties();

                    ((NamingStandardRuleProperties) governanceDefinitionProperties).setNamePatterns(this.removeNamePatterns(elementProperties));
                }
                else
                {
                    governanceDefinitionProperties = new GovernanceControlProperties();
                }
            }
            else
            {
                governanceDefinitionProperties = new GovernanceDefinitionProperties();
            }

            governanceDefinitionProperties.setDocumentIdentifier(this.removeQualifiedName(elementProperties));
            governanceDefinitionProperties.setAdditionalProperties(this.removeAdditionalProperties(elementProperties));
            governanceDefinitionProperties.setTitle(this.removeTitle(elementProperties));
            governanceDefinitionProperties.setScope(this.removeScope(elementProperties));
            governanceDefinitionProperties.setDomainIdentifier(this.removeDomainIdentifier(elementProperties));
            governanceDefinitionProperties.setImportance(this.removeImportance(elementProperties));
            governanceDefinitionProperties.setOutcomes(this.removeOutcomes(elementProperties));
            governanceDefinitionProperties.setResults(this.removeResults(elementProperties));

            /*
             * Any remaining properties are returned in the extended properties.  They are
             * assumed to be defined in a subtype.
             */
            governanceDefinitionProperties.setTypeName(openMetadataElement.getType().getTypeName());
            governanceDefinitionProperties.setExtendedProperties(this.getRemainingExtendedProperties(elementProperties));

            return governanceDefinitionProperties;
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

            if (returnBean instanceof GovernanceDefinitionElement bean)
            {
                bean.setElementHeader(super.getMetadataElementHeader(beanClass, openMetadataElement, methodName));
                bean.setProperties(getGovernanceDefinitionProperties(beanClass, openMetadataElement, methodName));
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
     * Using the supplied relatedMetadataElement, return a new instance of the bean. This is used for most beans that have
     * a one to one correspondence with the repository instances.
     *
     * @param beanClass name of the class to create
     * @param relatedMetadataElement relatedMetadataElement containing the properties
     * @param methodName calling method
     * @return bean populated with properties from the relatedMetadataElement supplied
     * @throws PropertyServerException there is a problem instantiating the bean
     */
    @SuppressWarnings(value = "unused")
    public B getNewBean(Class<B>               beanClass,
                        RelatedMetadataElement relatedMetadataElement,
                        String                 methodName) throws PropertyServerException
    {
        final String thisMethodName = "getNewBean(relatedMetadataElement)";

        B returnBean = this.getNewBean(beanClass, relatedMetadataElement.getElement(), methodName);

        if (returnBean instanceof GovernanceDefinitionElement bean)
        {
            bean.setRelatedBy(super.getRelatedBy(beanClass, relatedMetadataElement, methodName));
        }

        return returnBean;
    }


    /**
     * Using the supplied instances, return a new instance of the bean. This is used for beans that
     * contain a combination of the properties from an element and that of a connected relationship.
     *
     * @param beanClass name of the class to create
     * @param element element containing the properties
     * @param relationship relationship containing the properties
     * @param methodName calling method
     * @return bean populated with properties from the instances supplied
     * @throws PropertyServerException there is a problem instantiating the bean
     */
    @SuppressWarnings(value = "unused")
    public B getNewBean(Class<B>                 beanClass,
                        OpenMetadataElement      element,
                        OpenMetadataRelationship relationship,
                        String                   methodName) throws PropertyServerException
    {
        final String thisMethodName = "getNewBean(entity, relationship)";

        B returnBean = this.getNewBean(beanClass, element, methodName);

        if (returnBean instanceof GovernanceDefinitionElement bean)
        {
            bean.setRelatedBy(super.getRelatedBy(beanClass, relationship, methodName));
        }

        return returnBean;
    }
}
