/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.properties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.odpi.openmetadata.frameworks.openmetadata.properties.actions.ActionSponsorProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.actions.ActionTargetProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.actions.ActionsProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.actions.ActionRequesterProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.actors.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.assets.apis.APIEndpointProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.assets.filesandfolders.FolderHierarchyProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.assets.filesandfolders.LinkedFileProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.assets.filesandfolders.NestedFileProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.assets.infrastructure.DeployedOnProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.connections.ConnectionConnectorTypeProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.connections.ConnectionEndpointProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.connections.ServerEndpointProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.datadictionaries.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.digitalbusiness.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.externalidentifiers.ExternalIdLinkProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.externalidentifiers.ExternalIdScopeProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.feedback.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.governance.PeerDefinitionProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.connections.AssetConnectionProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.assets.DataSetContentProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.assets.infrastructure.CapabilityAssetUseProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.assets.processes.ProcessHierarchyProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.collections.CollectionMembershipProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.communities.CommunityMembershipProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.connections.EmbeddedConnectionProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.contextevents.DependentContextEventProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.contextevents.RelatedContextEventProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.externalreferences.ExternalReferenceLinkProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.glossaries.GlossaryTermRelationship;
import org.odpi.openmetadata.frameworks.openmetadata.properties.governance.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.informationsupplychains.InformationSupplyChainLinkProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.lineage.ControlFlowProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.lineage.DataFlowProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.lineage.LineageMappingProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.lineage.ProcessCallProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.locations.AdjacentLocationProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.locations.AssetLocationProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.locations.NestedLocationProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.locations.ProfileLocationProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.projects.ProjectDependencyProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.projects.ProjectHierarchyProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.projects.ProjectManagementProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.projects.ProjectTeamProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.resources.MoreInformationProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.resources.ResourceListProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.schema.*;
import org.odpi.openmetadata.frameworks.openmetadata.properties.security.AssociatedGroupProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.implementations.ImplementationResourceProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.implementations.ImplementedByProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.solutions.SolutionCompositionProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.solutions.SolutionDesignProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.solutions.SolutionLinkingWireProperties;
import org.odpi.openmetadata.frameworks.openmetadata.properties.validvalues.*;

import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * RelationshipBeanProperties provides the base class for relationship beans.
 * This provides extended properties to allow the existing types to be extended.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = AcceptedAnswerProperties.class, name = "AcceptedAnswerProperties"),
                @JsonSubTypes.Type(value = ActionRequesterProperties.class, name = "ActionRequesterProperties"),
                @JsonSubTypes.Type(value = ActionSponsorProperties.class, name = "ActionSponsorProperties"),
                @JsonSubTypes.Type(value = ActionsProperties.class, name = "ActionsProperties"),
                @JsonSubTypes.Type(value = ActionTargetProperties.class, name = "ActionTargetProperties"),
                @JsonSubTypes.Type(value = AdjacentLocationProperties.class, name = "AdjacentLocationProperties"),
                @JsonSubTypes.Type(value = AgreementActorProperties.class, name = "AgreementActorProperties"),
                @JsonSubTypes.Type(value = AgreementItemProperties.class, name = "AgreementItemProperties"),
                @JsonSubTypes.Type(value = APIEndpointProperties.class, name = "APIEndpointProperties"),
                @JsonSubTypes.Type(value = AssetConnectionProperties.class, name = "AssetConnectionProperties"),
                @JsonSubTypes.Type(value = AssetLocationProperties.class, name = "AssetLocationProperties"),
                @JsonSubTypes.Type(value = AssetSchemaTypeProperties.class, name = "AssetSchemaTypeProperties"),
                @JsonSubTypes.Type(value = AssignmentScopeProperties.class, name = "AssignmentScopeProperties"),
                @JsonSubTypes.Type(value = AssociatedGroupProperties.class, name = "AssociatedGroupProperties"),
                @JsonSubTypes.Type(value = AttachedCommentProperties.class, name = "AttachedCommentProperties"),
                @JsonSubTypes.Type(value = AttachedLikeProperties.class, name = "AttachedLikeProperties"),
                @JsonSubTypes.Type(value = AttachedRatingProperties.class, name = "AttachedRatingProperties"),
                @JsonSubTypes.Type(value = AttachedTagProperties.class, name = "AttachedTagProperties"),
                @JsonSubTypes.Type(value = AttributeForSchemaProperties.class, name = "AttributeForSchemaProperties"),
                @JsonSubTypes.Type(value = BusinessCapabilityTeamProperties.class, name = "BusinessCapabilityTeamProperties"),
                @JsonSubTypes.Type(value = CapabilityAssetUseProperties.class, name = "CapabilityAssetUseProperties"),
                @JsonSubTypes.Type(value = CertificationProperties.class, name = "CertificationProperties"),
                @JsonSubTypes.Type(value = CollectionMembershipProperties.class, name = "CollectionMembershipProperties"),
                @JsonSubTypes.Type(value = CommunityMembershipProperties.class, name = "CommunityMembershipProperties"),
                @JsonSubTypes.Type(value = ConnectionConnectorTypeProperties.class, name = "ConnectionConnectorTypeProperties"),
                @JsonSubTypes.Type(value = ConnectionEndpointProperties.class, name = "ConnectionEndpointProperties"),
                @JsonSubTypes.Type(value = ConsistentValidValuesProperties.class, name = "ConsistentValidValuesProperties"),
                @JsonSubTypes.Type(value = ContactThroughProperties.class, name = "ContactThroughProperties"),
                @JsonSubTypes.Type(value = ContractLinkProperties.class, name = "ContractLinkProperties"),
                @JsonSubTypes.Type(value = ContributionProperties.class, name = "ContributionProperties"),
                @JsonSubTypes.Type(value = ControlFlowProperties.class, name = "ControlFlowProperties"),
                @JsonSubTypes.Type(value = DataClassAssignmentProperties.class, name = "DataClassAssignmentProperties"),
                @JsonSubTypes.Type(value = DataClassCompositionProperties.class, name = "DataClassCompositionProperties"),
                @JsonSubTypes.Type(value = DataClassDefinitionProperties.class, name = "DataClassDefinitionProperties"),
                @JsonSubTypes.Type(value = DataClassHierarchyProperties.class, name = "DataClassHierarchyProperties"),
                @JsonSubTypes.Type(value = DataFlowProperties.class, name = "DataFlowProperties"),
                @JsonSubTypes.Type(value = DataSetContentProperties.class, name = "DataSetContentProperties"),
                @JsonSubTypes.Type(value = DataStructureDefinitionProperties.class, name = "DataStructureDefinitionProperties"),
                @JsonSubTypes.Type(value = DependentContextEventProperties.class, name = "DependentContextEventProperties"),
                @JsonSubTypes.Type(value = DeployedOnProperties.class, name = "DeployedOnProperties"),
                @JsonSubTypes.Type(value = DerivedSchemaTypeQueryTargetProperties.class, name = "DerivedSchemaTypeQueryTargetProperties"),
                @JsonSubTypes.Type(value = DigitalProductDependencyProperties.class, name = "DigitalProductDependencyProperties"),
                @JsonSubTypes.Type(value = DigitalProductManagementProperties.class, name = "DigitalProductManagementProperties"),
                @JsonSubTypes.Type(value = DigitalSubscriberProperties.class, name = "DigitalSubscriberProperties"),
                @JsonSubTypes.Type(value = DigitalSupportProperties.class, name = "DigitalSupportProperties"),
                @JsonSubTypes.Type(value = DuplicateProperties.class, name = "DuplicateProperties"),
                @JsonSubTypes.Type(value = EmbeddedConnectionProperties.class, name = "EmbeddedConnectionProperties"),
                @JsonSubTypes.Type(value = ExternalIdLinkProperties.class, name = "ExternalIdLinkProperties"),
                @JsonSubTypes.Type(value = ExternalIdScopeProperties.class, name = "ExternalIdScopeProperties"),
                @JsonSubTypes.Type(value = ExternalReferenceLinkProperties.class, name = "ExternalReferenceLinkProperties"),
                @JsonSubTypes.Type(value = FeedbackProperties.class, name = "FeedbackProperties"),
                @JsonSubTypes.Type(value = FolderHierarchyProperties.class, name = "FolderHierarchyProperties"),
                @JsonSubTypes.Type(value = ForeignKeyProperties.class, name = "ForeignKeyProperties"),
                @JsonSubTypes.Type(value = GlossaryTermRelationship.class, name = "GlossaryTermRelationship"),
                @JsonSubTypes.Type(value = GovernanceDefinitionMetricProperties.class, name = "GovernanceDefinitionMetricProperties"),
                @JsonSubTypes.Type(value = GovernanceResultsProperties.class, name = "GovernanceResultsProperties"),
                @JsonSubTypes.Type(value = GovernedByProperties.class, name = "GovernedByProperties"),
                @JsonSubTypes.Type(value = GraphEdgeLinkProperties.class, name = "GraphEdgeLinkProperties"),
                @JsonSubTypes.Type(value = ImplementedByProperties.class, name = "ImplementedByProperties"),
                @JsonSubTypes.Type(value = ImplementationResourceProperties.class, name = "ImplementationResourceProperties"),
                @JsonSubTypes.Type(value = InformationSupplyChainLinkProperties.class, name = "InformationSupplyChainLinkProperties"),
                @JsonSubTypes.Type(value = ITInfrastructureProfileProperties.class, name = "ITInfrastructureProfileProperties"),
                @JsonSubTypes.Type(value = ITProfileRoleAppointmentProperties.class, name = "ITProfileRoleAppointmentProperties"),
                @JsonSubTypes.Type(value = LicenseProperties.class, name = "LicenseProperties"),
                @JsonSubTypes.Type(value = LineageMappingProperties.class, name = "LineageMappingProperties"),
                @JsonSubTypes.Type(value = LinkedExternalSchemaTypeProperties.class, name = "LinkedExternalSchemaTypeProperties"),
                @JsonSubTypes.Type(value = LinkedFileProperties.class, name = "LinkedFileProperties"),
                @JsonSubTypes.Type(value = MapFromElementTypeProperties.class, name = "MapFromElementTypeProperties"),
                @JsonSubTypes.Type(value = MapToElementTypeProperties.class, name = "MapToElementTypeProperties"),
                @JsonSubTypes.Type(value = MemberDataFieldProperties.class, name = "MemberDataFieldProperties"),
                @JsonSubTypes.Type(value = MoreInformationProperties.class, name = "MoreInformationProperties"),
                @JsonSubTypes.Type(value = NestedFileProperties.class, name = "NestedFileProperties"),
                @JsonSubTypes.Type(value = NestedLocationProperties.class, name = "NestedLocationProperties"),
                @JsonSubTypes.Type(value = NestedSchemaAttributeProperties.class, name = "NestedSchemaAttributeProperties"),
                @JsonSubTypes.Type(value = PeerProperties.class, name = "PeerProperties"),
                @JsonSubTypes.Type(value = PeerDefinitionProperties.class, name = "PeerDefinitionProperties"),
                @JsonSubTypes.Type(value = PortSchemaProperties.class, name = "PortSchemaProperties"),
                @JsonSubTypes.Type(value = PersonRoleAppointmentProperties.class, name = "PersonRoleAppointmentProperties"),
                @JsonSubTypes.Type(value = ProcessCallProperties.class, name = "ProcessCallProperties"),
                @JsonSubTypes.Type(value = ProcessHierarchyProperties.class, name = "ProcessHierarchyProperties"),
                @JsonSubTypes.Type(value = ProfileIdentityProperties.class, name = "ProfileIdentityProperties"),
                @JsonSubTypes.Type(value = ProfileLocationProperties.class, name = "ProfileLocationProperties"),
                @JsonSubTypes.Type(value = ProjectDependencyProperties.class, name = "ProjectDependencyProperties"),
                @JsonSubTypes.Type(value = ProjectHierarchyProperties.class, name = "ProjectHierarchyProperties"),
                @JsonSubTypes.Type(value = ProjectManagementProperties.class, name = "ProjectManagementProperties"),
                @JsonSubTypes.Type(value = ProjectTeamProperties.class, name = "ProjectTeamProperties"),
                @JsonSubTypes.Type(value = ReferenceValueAssignmentProperties.class, name = "ReferenceValueAssignmentProperties"),
                @JsonSubTypes.Type(value = RelatedContextEventProperties.class, name = "RelatedContextEventProperties"),
                @JsonSubTypes.Type(value = ResourceListProperties.class, name = "ResourceListProperties"),
                @JsonSubTypes.Type(value = SchemaAttributeRelationshipProperties.class, name = "SchemaAttributeRelationshipProperties"),
                @JsonSubTypes.Type(value = SchemaTypeOptionProperties.class, name = "SchemaTypeOptionProperties"),
                @JsonSubTypes.Type(value = ScopedByProperties.class, name = "ScopedByProperties"),
                @JsonSubTypes.Type(value = SearchKeywordLinkProperties.class, name = "SearchKeywordLinkProperties"),
                @JsonSubTypes.Type(value = SemanticAssignmentProperties.class, name = "SemanticAssignmentProperties"),
                @JsonSubTypes.Type(value = SemanticDefinitionProperties.class, name = "SemanticDefinitionProperties"),
                @JsonSubTypes.Type(value = ServerEndpointProperties.class, name = "ServerEndpointProperties"),
                @JsonSubTypes.Type(value = SolutionCompositionProperties.class, name = "SolutionCompositionProperties"),
                @JsonSubTypes.Type(value = SolutionDesignProperties.class, name = "SolutionDesignProperties"),
                @JsonSubTypes.Type(value = SolutionLinkingWireProperties.class, name = "SolutionLinkingWireProperties"),
                @JsonSubTypes.Type(value = StakeholderProperties.class, name = "StakeholderProperties"),
                @JsonSubTypes.Type(value = SubjectAreaHierarchyProperties.class, name = "SubjectAreaHierarchyProperties"),
                @JsonSubTypes.Type(value = SupplementaryProperties.class, name = "SupplementaryProperties"),
                @JsonSubTypes.Type(value = SupportingDefinitionProperties.class, name = "SupportingDefinitionProperties"),
                @JsonSubTypes.Type(value = TeamLeadershipProperties.class, name = "TeamLeadershipProperties"),
                @JsonSubTypes.Type(value = TeamMembershipProperties.class, name = "TeamMembershipProperties"),
                @JsonSubTypes.Type(value = TeamStructureProperties.class, name = "TeamStructureProperties"),
                @JsonSubTypes.Type(value = TeamRoleAppointmentProperties.class, name = "TeamRoleAppointmentProperties"),
                @JsonSubTypes.Type(value = ValidValueAssignmentProperties.class, name = "ValidValueAssignmentProperties"),
                @JsonSubTypes.Type(value = ValidValueAssociationProperties.class, name = "ValidValueAssociationProperties"),
                @JsonSubTypes.Type(value = ValidValueMemberProperties.class, name = "ValidValueMemberProperties"),
                @JsonSubTypes.Type(value = ValidValuesImplementationProperties.class, name = "ValidValuesImplementationProperties"),
                @JsonSubTypes.Type(value = ValidValuesMappingProperties.class, name = "ValidValuesMappingProperties"),
                @JsonSubTypes.Type(value = ZoneHierarchyProperties.class, name = "ZoneHierarchyProperties"),

        })
public class RelationshipBeanProperties extends RelationshipProperties
{
    private String               typeName             = null;
    private Map<String, Object>  extendedProperties   = null;

    /**
     * Default constructor
     */
    public RelationshipBeanProperties()
    {
        super();
    }


    /**
     * Copy/clone constructor.  Retrieves values from the supplied template
     *
     * @param template element to copy
     */
    public RelationshipBeanProperties(RelationshipBeanProperties template)
    {
        super(template);

        if (template != null)
        {
            typeName             = template.getTypeName();
            extendedProperties   = template.getExtendedProperties();
        }
    }


    /**
     * Return the name of the open metadata type for this metadata element.
     *
     * @return string name
     */
    public String getTypeName()
    {
        return typeName;
    }


    /**
     * Set up the name of the open metadata type for this element.
     *
     * @param typeName string name
     */
    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }


    /**
     * Return the properties that have been defined for a subtype of this object that are not supported explicitly
     * by this bean.
     *
     * @return property map
     */
    public Map<String, Object> getExtendedProperties()
    {
        return extendedProperties;
    }


    /**
     * Set up the properties that have been defined for a subtype of this object that are not supported explicitly
     * by this bean.
     *
     * @param extendedProperties property map
     */
    public void setExtendedProperties(Map<String, Object> extendedProperties)
    {
        this.extendedProperties = extendedProperties;
    }


    /**
     * Standard toString method.
     *
     * @return print out of variables in a JSON-style
     */
    @Override
    public String toString()
    {
        return "RelationshipBeanProperties{" +
                "typeName='" + typeName + '\'' +
                ", extendedProperties=" + extendedProperties +
                "} " + super.toString();
    }



    /**
     * Compare the values of the supplied object with those stored in the current object.
     *
     * @param objectToCompare supplied object
     * @return boolean result of comparison
     */
    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare) return true;
        if (objectToCompare == null || getClass() != objectToCompare.getClass()) return false;
        if (!super.equals(objectToCompare)) return false;
        RelationshipBeanProperties that = (RelationshipBeanProperties) objectToCompare;
        return Objects.equals(typeName, that.typeName) && Objects.equals(extendedProperties, that.extendedProperties);
    }

    /**
     * Return hash code based on properties.
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), typeName, extendedProperties);
    }
}