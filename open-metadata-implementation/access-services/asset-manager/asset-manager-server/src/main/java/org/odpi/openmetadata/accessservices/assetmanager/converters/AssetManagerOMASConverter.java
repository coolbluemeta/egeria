/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.assetmanager.converters;

import org.odpi.openmetadata.commonservices.generichandlers.OMFConverter;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryHelper;


/**
 * AssetManagerOMASConverter provides the generic methods for the Asset Manager beans' converters.  Generic classes
 * have limited knowledge of the classes these are working on and this means creating a new instance of a
 * class from within a generic is a little involved.  This class provides the generic method for creating
 * and initializing an Asset Manager bean.
 */
public abstract class AssetManagerOMASConverter<B> extends OMFConverter<B>
{
    /**
     * Constructor
     *
     * @param repositoryHelper helper object to parse entity
     * @param serviceName name of this component
     * @param serverName name of this server
     */
    public AssetManagerOMASConverter(OMRSRepositoryHelper   repositoryHelper,
                                     String                 serviceName,
                                     String                 serverName)
    {
        super (repositoryHelper, serviceName, serverName);
    }


}
