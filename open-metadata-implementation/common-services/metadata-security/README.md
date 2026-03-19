<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the ODPi Egeria project. -->

![Stable](../../../images/egeria-content-status-released.png#pagewidth)

# Metadata Security

The *Metadata Security* module provides fine-grained authorization services for open metadata services, types and instances.
Since each organization will have different security requirements, the support is implemented through connectors.
Egeria defines the interfaces for the connectors and when it will call the connector.  You define the behavior
performed when the connector is called and Egeria acts on the returned decision.

Metadata security is optional.  If the appropriate connector is not present, then all operations are permitted for all validated users.

## Connector interfaces

The [metadata-security-apis](metadata-security-apis) module defines the connector interfaces
and [metadata-security-connectors](metadata-security-connectors) defines the connector base classes and default implementations.

The connector installed into the OMAG Server Platform by default is implemented by the
[Open Metadata Access Security Connector](../../adapters/open-connectors/metadata-security-connectors/open-metadata-access-security-connector) module.
This connector uses a [secrets store connector](../../adapters/open-connectors/secrets-store-connectors) to retrieve secrets
for authorization decisions.

## How it works

The principle purpose of the [metadata-security-server](metadata-security-server)
module is to act as a fixed set of security services that other components can call
for authorization decisions.
If the appropriate security connectors is not installed, permission is granted.
If the security connector is present, the decision is delegated to the connector.

----
* Return to [Common Services](..)
* Find out more about metadata security in the [Metadata Security](https://egeria-project.org/features/metadata-security/overview/) feature.
* Find out more about setting up security in the [Administration Guide](https://egeria-project.org/guides/admin/)
    

----
License: [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/),
Copyright Contributors to the ODPi Egeria project.