/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworkservices.gaf.converters;

import org.odpi.openmetadata.frameworks.openmetadata.enums.DeleteMethod;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataProperty;
import org.odpi.openmetadata.frameworks.governanceaction.properties.GovernanceServiceElement;
import org.odpi.openmetadata.frameworks.governanceaction.properties.RegisteredGovernanceService;
import org.odpi.openmetadata.frameworks.governanceaction.properties.RegisteredGovernanceServiceElement;
import org.odpi.openmetadata.frameworks.governanceaction.properties.RegisteredGovernanceServiceProperties;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProperties;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Relationship;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * RegisteredGovernanceServiceConverter transfers the relevant properties from a GovernanceServiceElement bean
 * and the Open Metadata Repository Services (OMRS) Relationship object into a RegisteredGovernanceService bean.
 */
public class RegisteredGovernanceServiceConverter
{
    private final OMRSRepositoryHelper       repositoryHelper;
    private final String                     serviceName;

    /**
     * Constructor captures the repository content needed to create the endpoint object.
     *
     * @param repositoryHelper helper object to parse entity/relationship objects
     * @param serviceName name of this component
     */
    public RegisteredGovernanceServiceConverter(OMRSRepositoryHelper       repositoryHelper,
                                                String                     serviceName)
    {
        this.repositoryHelper = repositoryHelper;
        this.serviceName = serviceName;
    }


    /**
     * Request the bean is extracted from the repository entity.
     *
     * @param governanceService properties to convert
     * @param relationships list of relationships with the request types
     * @return output bean
     */
    public RegisteredGovernanceServiceElement getBean(GovernanceServiceElement governanceService,
                                                      List<Relationship>       relationships)
    {
        final String  methodName = "getBean";

        RegisteredGovernanceServiceElement bean = new RegisteredGovernanceServiceElement(governanceService);

        if (relationships != null)
        {
            Map<String, RegisteredGovernanceServiceProperties> requestTypeMappings = new HashMap<>();

            for (Relationship relationship : relationships)
            {
                if (relationship != null)
                {
                    /*
                     * The properties are removed from the instance properties and stowed in the bean.
                     * Any remaining properties are stored in extendedProperties.
                     */
                    InstanceProperties instanceProperties = relationship.getProperties();

                    if (instanceProperties != null)
                    {
                        String requestType = repositoryHelper.getStringProperty(serviceName,
                                                                                OpenMetadataProperty.REQUEST_TYPE.name,
                                                                                instanceProperties,
                                                                                methodName);

                        RegisteredGovernanceServiceProperties registeredGovernanceServiceProperties = new RegisteredGovernanceServiceProperties();

                        registeredGovernanceServiceProperties.setRequestType(requestType);

                        String serviceRequestType = repositoryHelper.getStringProperty(serviceName,
                                                                                       OpenMetadataProperty.SERVICE_REQUEST_TYPE.name,
                                                                                       instanceProperties,
                                                                                       methodName);


                        if (requestType != null)
                        {
                            if (serviceRequestType == null)
                            {
                                registeredGovernanceServiceProperties.setServiceRequestType(requestType);
                            }
                            else
                            {
                                registeredGovernanceServiceProperties.setServiceRequestType(serviceRequestType);
                            }

                            registeredGovernanceServiceProperties.setRequestParameters(repositoryHelper.getStringMapFromProperty(serviceName,
                                                                                                                                 OpenMetadataProperty.REQUEST_PARAMETERS.name,
                                                                                                                                 instanceProperties,
                                                                                                                                 methodName));

                            registeredGovernanceServiceProperties.setGenerateIntegrationReports(repositoryHelper.getBooleanProperty(serviceName,
                                                                                                                                    OpenMetadataProperty.GENERATE_INTEGRATION_REPORT.name,
                                                                                                                                    instanceProperties,
                                                                                                                                    methodName));

                            int deleteMethodOrdinal = repositoryHelper.getEnumPropertyOrdinal(serviceName,
                                                                                              OpenMetadataProperty.DELETE_METHOD.name,
                                                                                              relationship.getProperties(),
                                                                                              methodName);

                            for (DeleteMethod deleteMethod : DeleteMethod.values())
                            {
                                if (deleteMethod.getOrdinal() == deleteMethodOrdinal)
                                {
                                    registeredGovernanceServiceProperties.setDeleteMethod(deleteMethod);
                                }
                            }
                            requestTypeMappings.put(requestType, registeredGovernanceServiceProperties);
                        }
                    }
                }
            }

            if (! requestTypeMappings.isEmpty())
            {
                RegisteredGovernanceService properties = bean.getProperties();

                if (properties != null)
                {
                    properties.setRequestTypes(requestTypeMappings);
                    bean.setProperties(properties);
                }
            }
        }

        return bean;

    }
}
