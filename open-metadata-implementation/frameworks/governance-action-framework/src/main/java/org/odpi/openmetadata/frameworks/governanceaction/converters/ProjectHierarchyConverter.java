/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.governanceaction.converters;

import org.odpi.openmetadata.frameworks.connectors.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.governanceaction.properties.OpenMetadataElement;
import org.odpi.openmetadata.frameworks.governanceaction.properties.RelatedMetadataElement;
import org.odpi.openmetadata.frameworks.governanceaction.search.ElementProperties;
import org.odpi.openmetadata.frameworks.governanceaction.search.PropertyHelper;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.ProjectElement;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.ProjectHierarchy;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.RelatedMetadataElementSummary;
import org.odpi.openmetadata.frameworks.openmetadata.properties.projects.ProjectProperties;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * ProjectConverter generates a ProjectHierarchy from a Project entity and related elements
 */
public class ProjectHierarchyConverter<B> extends ProjectConverter<B>
{
    private final List<ProjectHierarchy> children;

    /**
     * Constructor
     *
     * @param propertyHelper helper object to parse entity
     * @param serviceName name of this component
     * @param serverName local server name
     */
    public ProjectHierarchyConverter(PropertyHelper         propertyHelper,
                                     String                 serviceName,
                                     String                 serverName,
                                     List<ProjectHierarchy> children)
    {
        super(propertyHelper, serviceName, serverName);

        this.children = children;
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

            if (returnBean instanceof ProjectHierarchy bean)
            {
                bean.setElementHeader(super.getMetadataElementHeader(beanClass, primaryElement, methodName));


                /*
                 * The initial set of values come from the openMetadataElement.
                 */
                if (primaryElement == null)
                {
                    handleMissingMetadataInstance(beanClass.getName(), OpenMetadataElement.class.getName(), methodName);
                }
                else
                {
                    bean.setProperties(this.getProjectProperties(primaryElement));
                    bean.setResourceList(this.getResourceList(beanClass, relationships));
                    bean.setProjectManagers(this.getProjectManagers(beanClass, relationships));
                    bean.setProjectTeam(this.getProjectTeam(beanClass, relationships));
                    bean.setChildren(children);
                    bean.setDependentProjects(this.getDependentProjects(beanClass, relationships));
                    bean.setDependsOnProjects(this.getDependsOnProjects(beanClass, relationships));
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
        try
        {
            /*
             * This is initial confirmation that the generic converter has been initialized with an appropriate bean class.
             */
            B returnBean = beanClass.getDeclaredConstructor().newInstance();

            if (returnBean instanceof ProjectElement bean)
            {
                ProjectProperties    projectProperties    = new ProjectProperties();
                OpenMetadataElement  openMetadataElement  = primaryElement.getElement();

                bean.setElementHeader(super.getMetadataElementHeader(beanClass, openMetadataElement, methodName));

                ElementProperties elementProperties;

                /*
                 * The initial set of values come from the openMetadataElement.
                 */
                if (openMetadataElement != null)
                {
                    elementProperties = new ElementProperties(openMetadataElement.getElementProperties());

                    projectProperties.setQualifiedName(this.removeQualifiedName(elementProperties));
                    projectProperties.setAdditionalProperties(this.removeAdditionalProperties(elementProperties));
                    projectProperties.setIdentifier(this.removeIdentifier(elementProperties));
                    projectProperties.setName(this.removeName(elementProperties));
                    projectProperties.setDescription(this.removeDescription(elementProperties));
                    projectProperties.setProjectStatus(this.removeProjectStatus(elementProperties));
                    projectProperties.setProjectHealth(this.removeProjectHealth(elementProperties));
                    projectProperties.setProjectPhase(this.removeProjectPhase(elementProperties));
                    projectProperties.setPriority(this.removeIntPriority(elementProperties));
                    projectProperties.setStartDate(this.removeStartDate(elementProperties));
                    projectProperties.setPlannedEndDate(this.removePlannedEndDate(elementProperties));
                    projectProperties.setEffectiveFrom(openMetadataElement.getEffectiveFromTime());
                    projectProperties.setEffectiveTo(openMetadataElement.getEffectiveToTime());

                    /*
                     * Any remaining properties are returned in the extended properties.  They are
                     * assumed to be defined in a subtype.
                     */
                    projectProperties.setTypeName(bean.getElementHeader().getType().getTypeName());
                    projectProperties.setExtendedProperties(this.getRemainingExtendedProperties(elementProperties));
                }
                else
                {
                    handleMissingMetadataInstance(beanClass.getName(), OpenMetadataElement.class.getName(), methodName);
                }

                if (relationships != null)
                {
                    bean.setResourceList(this.getResourceList(beanClass, relationships));
                    bean.setProjectManagers(this.getProjectManagers(beanClass, relationships));
                    bean.setProjectTeam(this.getProjectTeam(beanClass, relationships));
                }

                bean.setProperties(projectProperties);
                bean.setRelatedBy(super.getRelatedBy(beanClass, primaryElement, methodName));
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
     * Summarize the projects that are dependent on this project.
     *
     * @param beanClass bean class
     * @param projectElements elements to summarize
     * @return list or null
     * @throws PropertyServerException problem in converter
     */
    protected List<RelatedMetadataElementSummary> getDependentProjects(Class<B>                     beanClass,
                                                                       List<RelatedMetadataElement> projectElements) throws PropertyServerException
    {
        final String methodName = "getDependentProjects";

        if (projectElements != null)
        {
            List<RelatedMetadataElementSummary> dependentProject = new ArrayList<>();

            for (RelatedMetadataElement projectElement: projectElements)
            {
                if ((projectElement != null) &&
                        (propertyHelper.isTypeOf(projectElement, OpenMetadataType.PROJECT_DEPENDENCY_RELATIONSHIP.typeName)) &&
                        (projectElement.getElementAtEnd1()))
                {
                    dependentProject.add(super.getRelatedElementSummary(beanClass, projectElement, methodName));
                }
            }

            return dependentProject;
        }

        return null;
    }


    /**
     * Summarize the projects that are dependent on this project.
     *
     * @param beanClass bean class
     * @param projectElements elements to summarize
     * @return list or null
     * @throws PropertyServerException problem in converter
     */
    protected List<RelatedMetadataElementSummary> getDependsOnProjects(Class<B>                     beanClass,
                                                                       List<RelatedMetadataElement> projectElements) throws PropertyServerException
    {
        final String methodName = "getDependsOnProjects";

        if (projectElements != null)
        {
            List<RelatedMetadataElementSummary> dependsOnProject = new ArrayList<>();

            for (RelatedMetadataElement projectElement: projectElements)
            {
                if ((projectElement != null) &&
                        (propertyHelper.isTypeOf(projectElement, OpenMetadataType.PROJECT_DEPENDENCY_RELATIONSHIP.typeName)) &&
                        (! projectElement.getElementAtEnd1()))
                {
                    dependsOnProject.add(super.getRelatedElementSummary(beanClass, projectElement, methodName));
                }
            }

            return dependsOnProject;
        }

        return null;
    }
}
