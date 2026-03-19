<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the Egeria project. -->

# Sample secrets stores

This directory provides the sample YAML files used in the default runtime created by the gradle build
and the [egeria-workspaces](https://github.com/odpi/egeria-workspaces).



## Coco User Directory (coco-user-directory.omsecrets)

The `coco-user-directory.omsecrets` file is a sample secrets store coded in YAML to allow editing using a text editor.

The sample YAML file is based on the [Coco Pharmaceuticals persona](https://egeria-project.org/practices/coco-pharmaceuticals).

### Security Groups

Security groups are used to organize the users according to the department they work in.
Their purpose is to simplify the management of the security roles - where permissions are assigned.
The sample YAML file defines the following security groups that are dynamically populated by the YAML Secrets Store Connector.

* allUsers - anyone with an active user account.
* employeeUsers - anyone with an active metadata account and an accountType of EMPLOYEE.
* externalUsers - anyone with an active metadata account and an accountType of EXTERNAL.
* contractorUsers - anyone with an active metadata account and an accountType of CONTRACTOR.
* digitalUsers - anyone with an active metadata account and an accountType of DIGITAL.

The next list of security groups are explicitly modelled in the YAML file:

* researchTeam - Members of the research team.
* clinicalTrialsTeam - Cross-organizational team supporting clinical trials.
* hrTeam - Members of the Human Resources (HR) team.
* marketingTeam - Members of the Human Resources (HR) team.
* financeTeam - Members of the finance team.
* securityTeam - Members of the security team.
* salesTeam - Members of the sales team.
* itTeam - Members of one of the IT teams.
  * infrastructureTeam - Members of the IT Infrastructure team.
  * softwareDevTeam - Members of the IT Software Development team.
  * devOpsTeam - Members of the IT DevOps team.
* dataManagementTeam - Members of the Data Management team.
* manufacturingTeam - Members of the manufacturing team.

### Security Roles

A security role represents a group of users that need specific permissions to access the services and the metadata within each of the governance zones.  The security roles are therefore quite different to an actor role that describes the type of work a person performs within a scope.

These are the security roles defined in the YAML file:

* openMetadataMember - A security role describing the members of the open metadata ecosystem.
* founder - People who started Coco Pharmaceuticals.
* boardMember - People who provide strategic direction and oversight to Coco Pharmaceuticals.
* manager - People who manage other people in the Coco Pharmaceuticals organization.
* externalAccessUser - People from partner companies that have access to the Coco Pharmaceuticals open metadata ecosystem.
* researchLeader - Researchers that are responsible for managing one of the research teams.
* researchStaff - Researchers that are responsible for research at Coco Pharmaceuticals.
* researchProcess - Automated processes that work with research data at Coco Pharmaceuticals.
* labLeader - People who are responsible for managing one of the lab teams.
* labStaff - People who are working in one of the research labs at Coco Pharmaceuticals.
* labProcess - Automated processes that work with research lab data at Coco Pharmaceuticals.
* officeLeader - People who are responsible for managing one of the office teams.
* officeStaff - People who are working in one of the offices at Coco Pharmaceuticals.
* officeProcess - Automated processes that work with office data at Coco Pharmaceuticals.
* hrLeader - People who are responsible for managing one of the HR teams.
* hrStaff - People who are working in one of the HR departments at Coco Pharmaceuticals.
* hrProcess - Automated processes that work with HR data at Coco Pharmaceuticals.
* securityLeader - People who are responsible for managing one of the security teams.
* securityStaff - People who are responsible for operating security at Coco Pharmaceuticals.
* securityProcess - Automated processes that work with security data at Coco Pharmaceuticals.
* salesLeader - People who are responsible for managing one of the sales teams.
* salesStaff - People who are responsible for sales at Coco Pharmaceuticals.
* salesProcess - Automated processes that work with sales data at Coco Pharmaceuticals.
* clinicalTrialsLeader - People who are responsible for managing one of the clinical trials teams.
* clinicalTrialsStaff - People who are responsible for operating clinical trials at Coco Pharmaceuticals.
* clinicalTrialsProcess - Automated processes that work with clinical trials data at Coco Pharmaceuticals.
* marketingLeader - People who are responsible for managing one of the marketing teams.
* marketingStaff - People who are responsible for marketing at Coco Pharmaceuticals.
* marketingProcess - Automated processes that work with marketing data at Coco Pharmaceuticals.
* financeLeader - People who are responsible for managing one of the finance teams.
* financeStaff - People who are responsible for financial operations at Coco Pharmaceuticals.
* financeProcess - Automated processes that work with finance data at Coco Pharmaceuticals.
* itLeader - People who are responsible for managing one of the IT teams.
* itStaff - People who are working in one of the IT teams at Coco Pharmaceuticals.
* itProcess - Automated processes that work with IT data at Coco Pharmaceuticals.
* devOpsLeader - People who are responsible for managing one of the devOps teams.
* devOpsStaff - People who are responsible for devOps at Coco Pharmaceuticals.
* devOpsProcess - Automated processes that work with devOps data at Coco Pharmaceuticals.
* softwareDevelopmentLeader - People who are responsible for managing one of the software development teams.
* softwareDevelopmentStaff - People who are responsible for software development at Coco Pharmaceuticals.
* softwareDevelopmentProcess - Automated processes that work with software development data at Coco Pharmaceuticals.
* infrastructureLeader - People who are responsible for managing one of the infrastructure teams.
* infrastructureStaff - People who are working in one of the infrastructure teams at Coco Pharmaceuticals.
* infrastructureProcess - Automated processes that work with infrastructure data at Coco Pharmaceuticals.
* dataManagementLeader - People who are responsible for managing one of the data management teams.
* dataManagementStaff - People who are responsible for data management at Coco Pharmaceuticals.
* dataManagementProcess - Automated processes that work with data management data at Coco Pharmaceuticals.
* dataOnboarder - People who are responsible for onboarding third-party data into the Coco Pharmaceuticals ecosystem.
* dataOnboarderProcess - Automated processes that onboard third party data at Coco Pharmaceuticals.
* metadataArchitect - People who are responsible for customize the open metadata types and instances.
* manufacturingLeader - People who are responsible for managing one of the manufacturing teams.
* manufacturingStaff - People who are working in one of the manufacturing teams at Coco Pharmaceuticals.
* manufacturingProcess - Automated processes that work with manufacturing data at Coco Pharmaceuticals.
* sustainabilityLeader - People who are responsible for leading one of the sustainability projects at Coco Pharmaceuticals.
* sustainabilityStaff - People who are working in one of the sustainability projects at Coco Pharmaceuticals.
* sustainabilityProcess - Automated processes that work with sustainability projects at Coco Pharmaceuticals.
* governanceLeader - People who are responsible for managing one of the governance teams.
* governanceStaff - People who are working in one of the governance teams at Coco Pharmaceuticals.
* governanceProcess - Automated processes that work with governance data at Coco Pharmaceuticals.
* serverAdministrator - People who are responsible for managing one of the servers at Coco Pharmaceuticals.
* serverOperator - People who are responsible for operating one of the servers at Coco Pharmaceuticals.
* serverInvestigator - People who are responsible for investigating the status of the servers running on the OMAG Server Platform.


### Governance Zones

The sample YAML file defines the following zones.
These zones are security access controls determining the actions that can be performed on elements that are members of an associated governance zone.



* **data-lake** zone - Elements that are read-only to all employees of Coco Pharmaceuticals with access to the open metadata services.
  The non-personal accounts (NPAs) used by the engines that manage the data lake are the only users that can update or delete these elements.
* **external-access** - Assets that can be seen by external collaborators, such as partners from the hospitals.
* **research** zone - Assets for the research team Callie Quartile (`calliequartile`) and Tessa Tube (`tessatube`).
* **human-resources** zone - Assets for the HR team, currently just Faith Broker (`faithbroker`).
* **finance** zone - Assets for the finance team Reggie Mint (`reggiemint`), Tom Tally (`tomtally`) and Sally Counter (`sallycounter`).
* **clinical-trials** zone - Assets dedicated to supporting clinical trials which are managed by Tanya Tidie (`tanyatidie`).
* **infrastructure** zone - Assets describing the IT infrastructure that supports Coco Pharmaceuticals.  These are accessible by Gary Geeke (`garygeeke`) alone.
* **development** zone - Assets in use by the development team including Polly Tasker (`pollytasker`), Bob Nitter (`bobnitter`), Lemmie Stage (`lemmiestage`), Nancy Noah (`nancynoah`) and Des Signa (`dessigna`)
* **manufacturing** zone - Assets used in the manufacturing process currently managed by Stew Faster (`stewfaster`).
* **governance** zone - Assets used to govern the organization.  These are effectively the governance leadership team of Jules Keeper (`juleskeeper`),
  Erin Overview (`erinoverview`), Gary Geeke (`garygeeke`), Polly Tasker (`pollytasker`), Faith Broker (`faithbroker`), Ivor Padlock (`ivorpadlock`) and Reggie Mint (`reggiemint`).
* **trash-can** zone - Assets that are waiting to be deleted or archived - this is handled by their archiver processes.  All the NPA accounts have access to this zone to
  enable processes to retrieve files from the trash can and restore them to their original zones.

An element may be in multiple zones, and a person is typically able to access the element if any of its zones permit access to them.
However, the implementation of your connector may also look for specific combinations of zones and apply special rules.
For example, the **quarantine** zone rules override any other zone's rules
to allow the onboarding team to set up the zones as part of the onboarding process.
Only when the **quarantine** zone is removed, do the other zones take effect.

## Controlling access to services

It is also possible to have special rules for particular services.  
Coco Pharmaceuticals have decided that the **assetDelete** method from Asset Owner OMAS is too powerful
to use, and so they have disabled it using this connector.
Only non-personal accounts (NPA) can use this method.
Coco Pharmaceutical's staff delete an asset by moving it to the
"trash-can" zone where it is cleaned up by automated archiver
processes the next day.



----
License: [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/),
Copyright Contributors to the ODPi Egeria project.