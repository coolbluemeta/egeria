<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the ODPi Egeria project 2020. -->

# API for the open metadata security connectors

This module provides the definition of the Metadata Security Connector interfaces.
The interfaces each cover the authorization decisions for a different functional area of Egeria and, except user security, they are all optional.
This allows you to tailor the security decisions to your environment,
operating without authorization checks,
to using course-grained access to servers,
to right down to fine-grained control of access to specific metadata instances.

The connector interfaces are as follows:

* **OpenMetadataUserSecurity** - support user authentication requests and management of user accounts.
* **OpenMetadataPlatformSecurity** - secure requests to the OMAG Server Platform.
  Specifically the [platform-services](../../../platform-services), [admin-services](../../../admin-services),
  and [server-operations](../../../server-operations).
* **OpenMetadataServerSecurity** - secure any request to an OMAG Server.
* **OpenMetadataServiceSecurity** - secure requests to specific OMAG Server's services.
* **OpenMetadataElementSecurity** - secure requests to specific open metadata elements depending on their type, the requested operation, who created the element and the settings of their classifications such as Governance Zones or Ownership.
* **OpenMetadataRepositorySecurity** - secure all requests to the open metadata repositories.  This allows a repository to redact sensitive properties for specific users.
* **OpenMetadataEventsSecurity** - secure sending and receiving of instance events between the open metadata repositories connected via an [open metadata repository cohort](https://egeria-project.org/concepts/cohort-member/).  This allows a repository to withold sensitive instances from the rest of the cohort, or prevent local caching of specific instances.

The [Metadata Security Feature](https://egeria-project.org/features/metadata-security/overview/) describes when these interfaces are called.

----
* For information on how these APIs are implemented, see the [Metadata Security Connector](../metadata-security-connectors) module.
* Return to [Module Overview](..)

----
License: [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/),
Copyright Contributors to the ODPi Egeria project.