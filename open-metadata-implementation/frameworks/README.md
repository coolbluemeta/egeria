<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the ODPi Egeria project. -->

  
# Open Metadata and Governance Frameworks

The open metadata and governance frameworks define the interfaces for pluggable components.  These
components provide much of the customization and technology integration points offered by the open metadata and governance
implementation.  

The open metadata and governance frameworks supported by Egeria are as follows:
  
* **[Audit Log Framework (ALF)](audit-log-framework)** provides interfaces and classes to
enable connectors of all types to support natural language diagnostic messages for both
exceptions and the audit log.

* **[Open Metadata Framework (OMF)](open-metadata-framework)** provides basic definitions for the open metadata types.

* **[Open Connector Framework (OCF)](open-connector-framework)** provides the interfaces and base implementations for components
(called [connectors](https://egeria-project.org/concepts/connector/)) that access real-world
[digital resources](https://egeria-project.org/concepts/resource).
OCF connectors also provide detailed metadata about the resources they access.

* **[open-integration-framework](open-integration-framework)** - provides the interfaces and services for
[integration connectors](https://egeria-project.org/concepts/integration-connector/).

* **[Open Governance Framework (OGF)](open-governance-framework)** provides the interfaces and base implementations for components
(called governance action services) that take action to assess and correct a situation that is harmful to the data,
or the organization in some way.

* **[Open Survey Framework (OSF)](open-survey-framework)** provides the interfaces and base implementations for components
(called survey action services) that survey and extract characteristics
about the real-world resources and stores them in an open metadata repository.

* **[Open Watchdog Framework (OWF)](open-watchdog-framework)** provides the interfaces and base implementations for components
(called watchdog action services) that monitor for situations/events and issue notifications/actions to subscribers.


----
Return to [open-metadata-implementation](..).

----
License: [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/),
Copyright Contributors to the ODPi Egeria project.