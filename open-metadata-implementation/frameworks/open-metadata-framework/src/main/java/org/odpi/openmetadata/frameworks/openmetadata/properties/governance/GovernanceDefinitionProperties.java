/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.openmetadata.properties.governance;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.odpi.openmetadata.frameworks.openmetadata.properties.OpenMetadataRootProperties;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;


/**
 * GovernanceDefinitionProperties provides the base class for many of the definitions that define the data strategy
 * and governance program.  It includes many of the common fields:
 *
 * <ul>
 *     <li>Document id</li>
 *     <li>Title</li>
 *     <li>Summary</li>
 *     <li>Description</li>
 *     <li>Scope</li>
 *     <li>Domain identifier</li>
 *     <li>Status</li>
 *     <li>Priority</li>
 *     <li>Implications</li>
 *     <li>Outcomes</li>
 *     <li>Results</li>
 *     <li>AdditionalProperties</li>
 * </ul>
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = LicenseTypeProperties.class, name = "LicenseTypeProperties"),
                @JsonSubTypes.Type(value = CertificationTypeProperties.class, name = "CertificationTypeProperties"),
                @JsonSubTypes.Type(value = GovernanceControlProperties.class, name = "GovernanceControlProperties"),
                @JsonSubTypes.Type(value = GovernanceStrategyProperties.class, name = "GovernanceStrategyProperties"),
                @JsonSubTypes.Type(value = RegulationProperties.class, name = "RegulationProperties"),
        })
public class GovernanceDefinitionProperties extends OpenMetadataRootProperties
{
    private String              documentIdentifier   = null;
    private Map<String, String> additionalProperties = null;
    private String              title                = null;
    private String              summary              = null;
    private String              description          = null;
    private String              scope                = null;
    private int                 domainIdentifier     = 0;
    private String              importance           = null;
    private List<String>        implications         = null;
    private List<String>        outcomes             = null;
    private List<String>        results              = null;


    /**
     * Default Constructor
     */
    public GovernanceDefinitionProperties()
    {
        super();
    }


    /**
     * Copy/clone Constructor
     *
     * @param template object being copied
     */
    public GovernanceDefinitionProperties(GovernanceDefinitionProperties template)
    {
        super(template);
        if (template != null)
        {
            this.documentIdentifier = template.getDocumentIdentifier();
            this.additionalProperties = template.getAdditionalProperties();
            this.title = template.getTitle();
            this.summary = template.getSummary();
            this.description = template.getDescription();
            this.scope = template.getScope();
            this.domainIdentifier = template.getDomainIdentifier();
            this.importance       = template.getImportance();
            this.implications     = template.getImplications();
            this.outcomes = template.getOutcomes();
            this.results = template.getResults();
        }
    }


    /**
     * Returns the stored qualified name property for the metadata entity.
     * If no qualified name is available then the empty string is returned.
     *
     * @return documentIdentifier
     */
    public String getDocumentIdentifier()
    {
        return documentIdentifier;
    }


    /**
     * Set up the fully qualified name.
     *
     * @param documentIdentifier String name
     */
    public void setDocumentIdentifier(String documentIdentifier)
    {
        this.documentIdentifier = documentIdentifier;
    }


    /**
     * Return a copy of the additional properties.  Null means no additional properties are available.
     *
     * @return AdditionalProperties
     */
    public Map<String, String> getAdditionalProperties()
    {
        return additionalProperties;
    }


    /**
     * Set up additional properties.
     *
     * @param additionalProperties Additional properties object
     */
    public void setAdditionalProperties(Map<String, String> additionalProperties)
    {
        this.additionalProperties = additionalProperties;
    }


    /**
     * Return the title associated with this governance definition.
     *
     * @return String title
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * Set up the title associated with this governance definition.
     *
     * @param title String title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }



    /**
     * Return the summary for this governance definition. This should cover its essence.  Think of it as
     * the executive summary.
     *
     * @return String short description
     */
    public String getSummary()
    {
        return summary;
    }


    /**
     * Set up the summary of the governance definition.  This should cover its essence.  Think of it as
     * the executive summary.
     *
     * @param summary String description
     */
    public void setSummary(String summary)
    {
        this.summary = summary;
    }


    /**
     * Return the full description of the governance definition.
     *
     * @return String description
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Set up the full description of the governance definition.
     *
     * @param description String description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }


    /**
     * Return the organizational scope that this governance definition applies to.
     *
     * @return String organization, department or team name
     */
    public String getScope()
    {
        return scope;
    }


    /**
     * Set up the organizational scope that this governance definition applies to.
     *
     * @param scope String organization, department or team name
     */
    public void setScope(String scope)
    {
        this.scope = scope;
    }


    /**
     * Return the identifier of the governance domain that this definition belongs to (0=all).
     *
     * @return int
     */
    public int getDomainIdentifier()
    {
        return domainIdentifier;
    }


    /**
     * Set up the identifier of the governance domain that this definition belongs to (0=all).
     *
     * @param domainIdentifier int
     */
    public void setDomainIdentifier(int domainIdentifier)
    {
        this.domainIdentifier = domainIdentifier;
    }


    /**
     * Return the priority of the governance definition.  This may be something like high, medium or low,
     * or maybe a time frame or more detailed explanation.
     *
     * @return String priority
     */
    public String getImportance()
    {
        return importance;
    }


    /**
     * Set up the priority of this governance definition.  This may be something like high, medium or low,
     * or maybe a time frame or more detailed explanation.
     *
     * @param importance String priority
     */
    public void setImportance(String importance)
    {
        this.importance = importance;
    }


    /**
     * Return the list of implications for the organization that this governance definition brings.
     * This is often the first enumeration of the changes that that need to be implemented to bring
     * the governance definition into effect.
     *
     * @return list of descriptions
     */
    public List<String> getImplications()
    {
        return implications;
    }


    /**
     * Set up the list of implications for the organization that this governance definition brings.
     * This is often the first enumeration of the changes that that need to be implemented to bring
     * the governance definition into effect.
     *
     * @param implications list of descriptions
     */
    public void setImplications(List<String> implications)
    {
        this.implications = implications;
    }


    /**
     * Return the list of expected outcomes from implementing this governance definition.
     *
     * @return list of outcome descriptions
     */
    public List<String> getOutcomes()
    {
        return outcomes;
    }


    /**
     * Set up the list of expected outcomes from implementing this governance definition.
     *
     * @param outcomes list of descriptions of outcomes
     */
    public void setOutcomes(List<String> outcomes)
    {
        this.outcomes = outcomes;
    }


    /**
     * Return the list of actual results from implementing this governance definition.
     *
     * @return list of result descriptions
     */
    public List<String> getResults()
    {
        return results;
    }


    /**
     * Set up the list of actual results from implementing this governance definition.
     *
     * @param results list of description of results
     */
    public void setResults(List<String> results)
    {
        this.results = results;
    }


    /**
     * JSON-style toString.
     *
     * @return list of properties and their values.
     */
    @Override
    public String toString()
    {
        return "GovernanceDefinitionProperties{" +
                "documentIdentifier='" + documentIdentifier + '\'' +
                ", additionalProperties=" + additionalProperties +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", scope='" + scope + '\'' +
                ", domainIdentifier=" + domainIdentifier +
                ", importance='" + importance + '\'' +
                ", implications=" + implications +
                ", outcomes=" + outcomes +
                ", results=" + results +
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
        GovernanceDefinitionProperties that = (GovernanceDefinitionProperties) objectToCompare;
        return domainIdentifier == that.domainIdentifier &&
                Objects.equals(documentIdentifier, that.documentIdentifier) &&
                Objects.equals(additionalProperties, that.additionalProperties) &&
                Objects.equals(title, that.title) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(description, that.description) &&
                Objects.equals(scope, that.scope) &&
                Objects.equals(importance, that.importance) &&
                Objects.equals(implications, that.implications) &&
                Objects.equals(outcomes, that.outcomes) &&
                Objects.equals(results, that.results);
    }


    /**
     * Return hash code based on properties.
     *
     * @return int
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), documentIdentifier, additionalProperties, title, summary, description, scope, domainIdentifier, importance, implications, outcomes, results);
    }
}
