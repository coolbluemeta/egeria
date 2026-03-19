<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the ODPi Egeria project 2020. -->

# Open Metadata Security Connectors

The open metadata security connectors support plugins to
implement security authorization decisions in an OMAG Server Platform
or an OMAG Server.

They are optional and are specified in the platform or server's configuration.
The way they operate is described in the [Open Metadata Security Module Overview](..)
and their interfaces are described on the [Connector API](../metadata-security-apis) page.

Each connector has a base class that simply throws `UserNotAuthorizedException`.  These are:
* **OpenMetadataPlatformSecurityConnector** for the OMAG Server Platform
* **OpenMetadataServerSecurityConnector** for the OMAG Servers
* **OpenMetadataSecurityConnector** for both the OMAG Servers and Platforms

The [interfaces](../metadata-security-apis) for the connectors are broken down into functional groups.
A connector instance can choose to implement all, one or some of these interfaces.
If an interface is missing,
or no connector is implemented,
then no authorization check is made and the user's request is allowed to continue.
This has the effect that when there is no open metadata security connector
plugged into a server and/or platform, everything is permitted.
If just these base classes are added then nothing is permitted.
They provide reusable methods to report security exceptions and call them
in every connector method.

When you write your organization's implementation of these connectors,
you extend these classes and add the special checks for authorized use
in each method.
When an action is not authorized, your method can either call the appropriate reusable methods from the base class, or
call its equivalent superclass method to report the error.

----
  
* Return to [Open Metadata Security Module Overview](..)


----
License: [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/),
Copyright Contributors to the ODPi Egeria project.