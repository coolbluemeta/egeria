/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.archiveutilities.simplecatalogs.catalogcontent;


import org.odpi.openmetadata.frameworks.openmetadata.types.OpenMetadataType;
import org.odpi.openmetadata.opentypes.OpenMetadataTypesArchive;
import org.odpi.openmetadata.repositoryservices.archiveutilities.OMRSArchiveBuilder;
import org.odpi.openmetadata.repositoryservices.connectors.stores.archivestore.properties.OpenMetadataArchive;
import org.odpi.openmetadata.repositoryservices.connectors.stores.archivestore.properties.OpenMetadataArchiveType;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProvenanceType;
import org.odpi.openmetadata.samples.archiveutilities.SimpleCatalogArchiveHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * SimpleAPICatalogArchiveBuilder provides API metadata.
 */
public class SimpleAPICatalogArchiveBuilder
{
    /*
     * This is the header information for the archive.
     */
    private static final String                  archiveGUID        = "9e594f24-2494-4000-ac20-59f374eaa0e6";
    private static final String                  archiveLicense     = "Apache-2.0";
    private static final String                  archiveDescription = "Sample metadata showing API assets and their payloads.";
    private static final OpenMetadataArchiveType archiveType        = OpenMetadataArchiveType.REPOSITORY_BACKUP;
    private static final String                  originatorName     = "Egeria";
    private static final Date                    creationDate       = new Date(1632046251579L);

    /*
     * Names for API definitions
     */
    private static final String customerQualifiedName = "global-api-gateway/CustomerDomain/APIs/Customer";
    private static final String customerDisplayName   = "Customer API";
    private static final String customerDescription   = "API for interacting with customer master.";

    private static final String getCustomerQualifiedName  = "global-api-gateway/CustomerDomain/APIs/Customer/getCustomer";
    private static final String getCustomerDisplayName    = "Get Customer Operation";
    private static final String getCustomerDescription    = "API operation to retrieved details about the customer.";
    private static final String getCustomerPath           = "global-api-gateway/CustomerDomain/APIs/Customer/getCustomer";
    private static final String getCustomerCommand        = "GET";

    private static final String customerNoRequestQualifiedName  = "global-api-gateway/CustomerDomain/APIs/Customer/getCustomer/request/customerNo";
    private static final String customerNoResponseQualifiedName = "global-api-gateway/CustomerDomain/APIs/Customer/getCustomer/response/customerNo";
    private static final String customerNoDisplayName           = "customerNo";
    private static final String customerNoDescription           = "The unique identifier assigned internally for a customer.";
    private static final String customerNoDataType              = "string";
    private static final int    customerNoLength                = 12;

    private static final String customerNameQualifiedName = "global-api-gateway/CustomerDomain/APIs/Customer/getCustomer/response/customerName";
    private static final String customerNameDisplayName   = "customerName";
    private static final String customerNameDescription   = "The name for a customer - as supplied by the customer.";
    private static final String customerNameDataType      = "string";
    private static final int    customerNameLength        = 40;

    private static final String customerCardIdQualifiedName = "global-api-gateway/CustomerDomain/APIs/Customer/getCustomer/responses/customerCardId";
    private static final String customerCardIdDisplayName   = "customerCardId";
    private static final String customerCardIdDescription   = "The store card number for the customer.  Null if not issued.";
    private static final String customerCardIdDataType      = "string";
    private static final int    customerCardIdLength        = 10;

    /*
     * Additional AssetTypes for basic file connector
     */
    private static final String apiAssetTypeName       = "DeployedAPI";
    private static final String apiSchemaTypeTypeName  = "APISchemaType";
    private static final String apiSchemaAttributeTypeName  = "APIParameter";


    /*
     * Specific values for initializing TypeDefs
     */
    private static final long   versionNumber = 1L;
    private static final String versionName   = "1.0";

    private final OMRSArchiveBuilder         archiveBuilder;
    private final SimpleCatalogArchiveHelper archiveHelper;

    /**
     * Constructor pushes all archive header values to the superclass
     *
     * @param archiveName name of the open metadata archive metadata collection.
     * @param archiveRootName non-spaced root name of the open metadata GUID map.
     */
    public SimpleAPICatalogArchiveBuilder(String archiveName,
                                          String archiveRootName)
    {
        List<OpenMetadataArchive> dependentOpenMetadataArchives = new ArrayList<>();

        /*
         * This value allows the archive to be based on the existing open metadata types
         */
        dependentOpenMetadataArchives.add(new OpenMetadataTypesArchive().getOpenMetadataArchive());

        this.archiveBuilder = new OMRSArchiveBuilder(archiveGUID,
                                                     archiveName,
                                                     archiveDescription,
                                                     archiveType,
                                                     originatorName,
                                                     archiveLicense,
                                                     creationDate,
                                                     dependentOpenMetadataArchives);

        this.archiveHelper = new SimpleCatalogArchiveHelper(archiveBuilder,
                                                            archiveGUID,
                                                            archiveName,
                                                            archiveRootName,
                                                            originatorName,
                                                            creationDate,
                                                            versionNumber,
                                                            versionName,
                                                            InstanceProvenanceType.LOCAL_COHORT,
                                                            null);
    }


    /**
     * Construct the builder using a shared archive builder and helper.  Used to create a
     * combination archive.
     *
     * @param archiveBuilder archive builder
     * @param archiveHelper archive helper
     */
    public SimpleAPICatalogArchiveBuilder(OMRSArchiveBuilder         archiveBuilder,
                                          SimpleCatalogArchiveHelper archiveHelper)
    {
        this.archiveBuilder = archiveBuilder;
        this.archiveHelper = archiveHelper;
    }


    /**
     * Fills the archive builder with all the elements for this catalog.
     */
    public void fillBuilder()
    {
        String assetGUID = archiveHelper.addAsset(apiAssetTypeName,
                                                  customerQualifiedName,
                                                  customerDisplayName,
                                                  customerDescription,
                                                  null,
                                                  null);

        String apiSchemaTypeGUID = archiveHelper.addTopLevelSchemaType(assetGUID,
                                                                       apiAssetTypeName,
                                                                       apiSchemaTypeTypeName,
                                                                       customerQualifiedName + "_api_schema_type",
                                                                       customerDisplayName + " API Schema Type",
                                                                       null,
                                                                       null);

        String apiOperationGUID = archiveHelper.addAPIOperation(assetGUID,
                                                                apiAssetTypeName,
                                                                apiSchemaTypeGUID,
                                                                getCustomerQualifiedName,
                                                                getCustomerDisplayName,
                                                                getCustomerDescription,
                                                                getCustomerPath,
                                                                getCustomerCommand,
                                                                null);

        String requestGUID = archiveHelper.addAPIParameterList(assetGUID,
                                                               apiAssetTypeName,
                                                               apiOperationGUID,
                                                               OpenMetadataType.API_REQUEST_RELATIONSHIP.typeName,
                                                               getCustomerQualifiedName + "_request",
                                                               getCustomerDisplayName + " Request Parameter List",
                                                               null,
                                                               true,
                                                               null);

        String parameterGUID = archiveHelper.addSchemaAttribute(assetGUID,
                                                                apiAssetTypeName,
                                                                apiSchemaAttributeTypeName,
                                                                null,
                                                                customerNoRequestQualifiedName,
                                                                customerNoDisplayName,
                                                                customerNoDescription,
                                                                customerNoDataType,
                                                                customerNoLength,
                                                                null,
                                                                null);

        archiveHelper.addAttributeForSchemaType(requestGUID, 1, 1, 1, parameterGUID);

        String responseGUID = archiveHelper.addAPIParameterList(assetGUID,
                                                                apiAssetTypeName,
                                                                apiOperationGUID,
                                                                OpenMetadataType.API_RESPONSE_RELATIONSHIP.typeName,
                                                                getCustomerQualifiedName + "_response",
                                                                getCustomerDisplayName + " Response Parameter List",
                                                                null,
                                                                true,
                                                                null);

        parameterGUID = archiveHelper.addSchemaAttribute(assetGUID,
                                                         apiAssetTypeName,
                                                         apiSchemaAttributeTypeName,
                                                         null,
                                                         customerNoResponseQualifiedName,
                                                         customerNoDisplayName,
                                                         customerNoDescription,
                                                         customerNoDataType,
                                                         customerNoLength,
                                                         null,
                                                         null);

        archiveHelper.addAttributeForSchemaType(responseGUID, 2, 1, 1, parameterGUID);

        parameterGUID = archiveHelper.addSchemaAttribute(assetGUID,
                                                         apiAssetTypeName,
                                                         apiSchemaAttributeTypeName,
                                                         null,
                                                         customerNameQualifiedName,
                                                         customerNameDisplayName,
                                                         customerNameDescription,
                                                         customerNameDataType,
                                                         customerNameLength,
                                                         null,
                                                         null);

        archiveHelper.addAttributeForSchemaType(responseGUID, 3, 1, 1, parameterGUID);

        parameterGUID = archiveHelper.addSchemaAttribute(assetGUID,
                                                         apiAssetTypeName,
                                                         apiSchemaAttributeTypeName,
                                                         null,
                                                         customerCardIdQualifiedName,
                                                         customerCardIdDisplayName,
                                                         customerCardIdDescription,
                                                         customerCardIdDataType,
                                                         customerCardIdLength,
                                                         null,
                                                         null);

        archiveHelper.addAttributeForSchemaType(responseGUID, 4, 1, 1, parameterGUID);

        archiveHelper.saveGUIDs();
    }


    /**
     * Returns the open metadata type archive containing all the for this catalog.
     *
     * @return populated open metadata archive object
     */
    public OpenMetadataArchive getOpenMetadataArchive()
    {
        fillBuilder();

        return archiveBuilder.getOpenMetadataArchive();
    }
}
