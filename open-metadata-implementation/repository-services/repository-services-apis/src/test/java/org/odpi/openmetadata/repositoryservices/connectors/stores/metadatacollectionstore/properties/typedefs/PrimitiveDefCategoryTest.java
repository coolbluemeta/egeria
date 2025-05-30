/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Verify the PrimitiveDefCategory enum contains unique ordinals, non-null names and descriptions and can be
 * serialized to JSON and back again.
 */
public class PrimitiveDefCategoryTest
{
    private List<Integer> existingOrdinals = null;

    /**
     * Validate that a supplied ordinal is unique.
     *
     * @param ordinal value to test
     * @return boolean result
     */
    private boolean isUniqueOrdinal(int  ordinal)
    {
        Integer       newOrdinal = ordinal;

        if (existingOrdinals.contains(newOrdinal))
        {
            return false;
        }
        else
        {
            existingOrdinals.add(newOrdinal);
            return true;
        }
    }


    /**
     * Validated the values of the enum.
     */
    @Test public void testEnumValues()
    {
        existingOrdinals = new ArrayList<>();

        PrimitiveDefCategory  testValue;

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_UNKNOWN;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_BOOLEAN;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_BYTE;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_CHAR;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_SHORT;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_INT;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_LONG;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_FLOAT;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_DOUBLE;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_BIGINTEGER;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_BIGDECIMAL;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);

        testValue = PrimitiveDefCategory.OM_PRIMITIVE_TYPE_DATE;
        assertTrue(isUniqueOrdinal(testValue.getOrdinal()));
        assertTrue(testValue.getName() != null);
        assertTrue(testValue.getJavaClassName() != null);
        assertTrue(testValue.getGUID() != null);
    }



    /**
     * Validate that an object generated from a JSON String has the same content as the object used to
     * create the JSON String.
     */
    @Test public void testJSON()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String       jsonString   = null;

        try
        {
            jsonString = objectMapper.writeValueAsString(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING);
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            assertTrue(objectMapper.readValue(jsonString, PrimitiveDefCategory.class) == PrimitiveDefCategory.OM_PRIMITIVE_TYPE_STRING);
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }
    }


    /**
     * Test that toString is overridden.
     */
    @Test public void testToString()
    {
        assertTrue(PrimitiveDefCategory.OM_PRIMITIVE_TYPE_SHORT.toString().contains("PrimitiveDefCategory"));
    }
}
