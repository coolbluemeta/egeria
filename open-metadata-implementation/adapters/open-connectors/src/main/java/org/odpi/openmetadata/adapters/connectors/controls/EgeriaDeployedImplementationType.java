/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.connectors.controls;

import org.odpi.openmetadata.frameworks.openmetadata.definitions.SolutionComponentDefinition;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.DeployedImplementationType;
import org.odpi.openmetadata.frameworks.openmetadata.definitions.DeployedImplementationTypeDefinition;
import org.odpi.openmetadata.frameworks.openmetadata.refdata.SolutionComponentType;
import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;

import java.util.Arrays;
import java.util.List;

/**
 * Describes the standard deployed implementation types supplied with Egeria for working with Apache Atlas.
 */
public enum EgeriaDeployedImplementationType implements DeployedImplementationTypeDefinition
{

    /**
     * An Open Metadata and Governance (OMAG) Server.
     */
    OMAG_SERVER("91abf546-f8f3-4d51-aa37-8839582a3ddc",
                "OMAG Server",
                DeployedImplementationType.SOFTWARE_SERVER,
                OpenMetadataType.SOFTWARE_SERVER.typeName,
                null,
                "A server providing Open Metadata and Governance (OMAG) services.",
                "https://egeria-project.org/concepts/omag-server/",
                "b8396306-9789-444b-ac44-48d9497d1164",
                SolutionComponentType.SOFTWARE_SERVICE.getSolutionComponentType(),
                "OMAG-SERVER",
                null),

    /**
     * A server that runs governance engines.
     */
    ENGINE_HOST("5cd74a31-9a1f-40c6-8ce2-f0d803b76db8",
                "Engine Host",
                OMAG_SERVER,
                OpenMetadataType.SOFTWARE_SERVER.typeName,
                null,
                "A server that runs governance engines.",
                "https://egeria-project.org/concepts/engine-host/",
                "ca709899-e15f-4552-a681-355f691fded4",
                SolutionComponentType.SOFTWARE_SERVICE.getSolutionComponentType(),
                "ENGINE-HOST",
                new SolutionComponentDefinition[]{
                        DeployedImplementationType.GOVERNANCE_ENGINE.getSolutionComponent()
    }),

    /**
     * A server that runs integration connectors that synchronize metadata between different types of technologies.
     */
    INTEGRATION_DAEMON("b2d8d57f-df68-4280-9a41-3df830c3444f",
                       "Integration Daemon",
                       OMAG_SERVER,
                       OpenMetadataType.SOFTWARE_SERVER.typeName,
                       null,
                       "A server that runs integration connectors that synchronize metadata between different types of technologies.",
                       "https://egeria-project.org/concepts/integration-daemon/",
                       "a0891ec7-7af3-43e4-b25a-0ba666b2bf0e",
                       SolutionComponentType.SOFTWARE_SERVICE.getSolutionComponentType(),
                       "INTEGRATION-DAEMON",
                       new SolutionComponentDefinition[]{DeployedImplementationType.INTEGRATION_CONNECTOR.getSolutionComponent()}),

    /**
     * A server that provides access to one or more open metadata repositories.
     */
    METADATA_ACCESS_SERVER("940dda2a-e86d-4ba2-b889-500431d47f70",
                           "Metadata Access Server",
                           OMAG_SERVER,
                           OpenMetadataType.SOFTWARE_SERVER.typeName,
                           null,
                           "A server that provides access to one or more open metadata repositories.",
                           "https://egeria-project.org/concepts/metadata-access-server/",
                           "4a3ee73b-1ece-4985-adb9-f9a067dd90c1",
                           SolutionComponentType.SOFTWARE_SERVICE.getSolutionComponentType(),
                           "METADATA-ACCESS-SERVER",
                           null),

    METADATA_ACCESS_STORE("1ae11a7d-cdef-48d2-bbad-1177366c6fb6",
                          "Metadata Access Store",
                          EgeriaDeployedImplementationType.METADATA_ACCESS_SERVER,
                          EgeriaDeployedImplementationType.METADATA_ACCESS_SERVER.getAssociatedTypeName(),
                          null,
                          EgeriaDeployedImplementationType.METADATA_ACCESS_SERVER.getDescription(),
                          "https://egeria-project.org/concepts/metadata-access-store/",
                          "74385479-73a1-4e61-9c2f-a98be526acc7",
                          SolutionComponentType.SOFTWARE_SERVICE.getSolutionComponentType(),
                          "METADATA-ACCESS-STORE",
                          new SolutionComponentDefinition[]{
                                  DeployedImplementationType.OPEN_METADATA_REPOSITORY.getSolutionComponent()
    }),

    /**
     * A server that provides access to end user open metadata and governance services.
     */
    VIEW_SERVER("aa29cd35-c14a-4998-ab53-acc09a363d4b",
                "View Server",
                OMAG_SERVER,
                OpenMetadataType.SOFTWARE_SERVER.typeName,
                null,
                "A server that provides access to end user open metadata and governance services.",
                "https://egeria-project.org/concepts/metadata-access-server/",
                "32a9a713-1676-4796-95c6-568eeaa00ecc",
                SolutionComponentType.SOFTWARE_SERVICE.getSolutionComponentType(),
                "VIEW-SERVER",
                null),

    /**
     * An Open Metadata and Governance (OMAG) platform for running one to many OMAG Servers.
     */
    OMAG_SERVER_PLATFORM("e76e450d-9533-4e98-b83d-c3ea7f8b0a08",
                         "OMAG Server Platform",
                         DeployedImplementationType.SOFTWARE_SERVER,
                         OpenMetadataType.SOFTWARE_SERVER_PLATFORM.typeName,
                         null,
                         "An Open Metadata and Governance (OMAG) runtime for running one to many OMAG Servers.",
                         "https://egeria-project.org/concepts/omag-server-platform/",
                         "1442a1bc-f791-4fda-a3be-56fb68934a4c",
                         SolutionComponentType.SOFTWARE_SERVICE.getSolutionComponentType(),
                         "OMAG-SERVER-PLATFORM",
                         new SolutionComponentDefinition[]{
                                 METADATA_ACCESS_STORE.getSolutionComponent(),
                                 VIEW_SERVER.getSolutionComponent(),
                                 INTEGRATION_DAEMON.getSolutionComponent(),
                                 ENGINE_HOST.getSolutionComponent()
    }),

    ;


    /**
     * Return the matching ENUM to make use of the full definition for the deployed implementation type.
     *
     * @param deployedImplementationType value to match on
     * @return DeployedImplementationType definition
     */
    public static DeployedImplementationTypeDefinition getDefinitionFromDeployedImplementationType(String deployedImplementationType)
    {
        if (deployedImplementationType != null)
        {
            for (EgeriaDeployedImplementationType definition : EgeriaDeployedImplementationType.values())
            {
                if (definition.getDeployedImplementationType().equals(deployedImplementationType))
                {
                    return definition;
                }
            }
        }

        return null;
    }


    private final String                               guid;
    private final String                               deployedImplementationType;
    private final DeployedImplementationTypeDefinition isATypeOf;
    private final String                               associatedTypeName;
    private final String                               associatedClassification;
    private final String                               description;
    private final String                               wikiLink;
    private final String                               solutionComponentGUID;
    private final String                               solutionComponentType;
    private final String                               solutionComponentIdentifier;
    private final SolutionComponentDefinition[]        subComponents;


    /**
     * Constructor for individual enum value.
     *
     * @param guid unique identifier of technology type (deployedImplementationType)
     * @param deployedImplementationType value for deployedImplementationType
     * @param isATypeOf optional deployed implementation type that this type "inherits" from
     * @param associatedTypeName the open metadata type where this value is used
     * @param associatedClassification the open metadata classification where this value is used
     * @param description description of the type
     * @param wikiLink url link to more information (optional)
     * @param solutionComponentGUID unique identifier of the solution component that this deployed implementation type is associated with (optional)
     * @param solutionComponentType type of the solution component that this deployed implementation type is associated with (optional)
     * @param solutionComponentIdentifier  identifier of the solution component that this deployed implementation type is associated with (optional)
     * @param subComponents optional subcomponents of the solution
     */
    EgeriaDeployedImplementationType(String                               guid,
                                     String                               deployedImplementationType,
                                     DeployedImplementationTypeDefinition isATypeOf,
                                     String                               associatedTypeName,
                                     String                               associatedClassification,
                                     String                               description,
                                     String                               wikiLink,
                                     String                               solutionComponentGUID,
                                     String                               solutionComponentType,
                                     String                               solutionComponentIdentifier,
                                     SolutionComponentDefinition[]        subComponents)
    {
        this.guid                        = guid;
        this.deployedImplementationType  = deployedImplementationType;
        this.isATypeOf                   = isATypeOf;
        this.associatedTypeName          = associatedTypeName;
        this.associatedClassification    = associatedClassification;
        this.description                 = description;
        this.wikiLink                    = wikiLink;
        this.solutionComponentGUID       = solutionComponentGUID;
        this.solutionComponentType       = solutionComponentType;
        this.solutionComponentIdentifier = solutionComponentIdentifier;
        this.subComponents               = subComponents;
    }


    /**
     * Return a list of definitions for this set of deployed implementation types.
     *
     * @return array of definitions
     */
    public static DeployedImplementationTypeDefinition[] getDefinitions()
    {
        DeployedImplementationTypeDefinition[] definitions = new DeployedImplementationTypeDefinition[values().length];

        for (EgeriaDeployedImplementationType definition : EgeriaDeployedImplementationType.values())
        {
            definitions[definition.ordinal()] = definition;
        }

        return definitions;
    }


    /**
     * Return the guid for the deployed technology type - can be null.
     *
     * @return string
     */
    @Override
    public String getGUID()
    {
        return guid;
    }


    /**
     * Return preferred value for deployed implementation type.
     * 
     * @return string
     */
    @Override
    public String getDeployedImplementationType()
    {
        return deployedImplementationType;
    }


    /**
     * Return the optional deployed implementation type that this technology is a tye of.
     *
     * @return deployed implementation type enum
     */
    @Override
    public DeployedImplementationTypeDefinition getIsATypeOf()
    {
        return isATypeOf;
    }


    /**
     * Return the type name that this deployed implementation type is associated with.
     * 
     * @return string
     */
    @Override
    public String getAssociatedTypeName()
    {
        return associatedTypeName;
    }


    /**
     * Return the optional classification name that this deployed implementation type is associated with.
     *
     * @return string
     */
    @Override
    public String getAssociatedClassification()
    {
        return associatedClassification;
    }


    /**
     * Return the description for this value.
     * 
     * @return string
     */
    @Override
    public String getDescription()
    {
        return description;
    }


    /**
     * Return the URL to more information.
     *
     * @return string url
     */
    @Override
    public String getWikiLink()
    {
        return wikiLink;
    }


    /**
     * Return the optional unique identifier of the solution component that this deployed implementation type is associated with.
     *
     * @return string
     */
    @Override
    public String getSolutionComponentGUID()
    {
        return solutionComponentGUID;
    }


    /**
     * Return the solution component type that this deployed implementation type is associated with.
     *
     * @return string
     */
    @Override
    public String getSolutionComponentType()
    {
        return solutionComponentType;
    }


    /**
     * Return the solution component identifier that this deployed implementation type is associated with.
     *
     * @return string
     */
    @Override
    public String getSolutionComponentIdentifier()
    {
        return solutionComponentIdentifier;
    }


    /**
     * Return the optional list of subcomponents.
     *
     * @return null or list
     */
    @Override
    public List<SolutionComponentDefinition> getSubComponents()
    {
        return subComponents == null ? null : Arrays.asList(subComponents);
    }


    /**
     * Output of this enum class and main value.
     *
     * @return string showing enum value
     */
    @Override
    public String toString()
    {
        return "EgeriaDeployedImplementationType{" + deployedImplementationType + '}';
    }
}
