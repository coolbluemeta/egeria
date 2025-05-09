/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.connectors.properties.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.ElementClassification;
import org.odpi.openmetadata.frameworks.openmetadata.metadataelements.ElementType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Validate that the ValidValue bean can be cloned, compared, serialized, deserialized and printed as a String.
 */
public class TestValidValue
{
    private ElementType                 type            = new ElementType();
    private List<ElementClassification> classifications = new ArrayList<>();


    /**
     * Default constructor
     */
    public TestValidValue()
    {

    }


    /**
     * Set up an example object to test.
     *
     * @return filled in object
     */
    private ValidValue getTestObject()
    {
        ValidValue testObject = new ValidValue();

        testObject.setType(type);
        testObject.setGUID("TestGUID");
        testObject.setClassifications(classifications);

        testObject.setDisplayName("TestName");
        testObject.setDescription("TestDescription");
        testObject.setUsage("TestUsage");
        testObject.setScope("TestScope");
        testObject.setPreferredValue("TestPreferredValue");
        testObject.setDataType("TestDataType");

        return testObject;
    }


    /**
     * Set up an example object to test.
     *
     * @return filled in object
     */
    private ValidValueDefinition getDefinitionTestObject()
    {
        ValidValueDefinition testObject = new ValidValueDefinition();

        testObject.setType(type);
        testObject.setGUID("TestGUID");
        testObject.setClassifications(classifications);

        testObject.setDisplayName("TestName");
        testObject.setDescription("TestDescription");
        testObject.setUsage("TestUsage");
        testObject.setScope("TestScope");
        testObject.setPreferredValue("TestPreferredValue");
        testObject.setDataType("TestDataType");

        return testObject;
    }


    /**
     * Set up an example object to test.
     *
     * @return filled in object
     */
    private ValidValueSet getSetTestObject()
    {
        ValidValueSet testObject = new ValidValueSet();

        testObject.setType(type);
        testObject.setGUID("TestGUID");
        testObject.setClassifications(classifications);

        testObject.setDisplayName("TestName");
        testObject.setDescription("TestDescription");
        testObject.setUsage("TestUsage");
        testObject.setScope("TestScope");
        testObject.setPreferredValue("TestPreferredValue");
        testObject.setDataType("TestDataType");

        return testObject;
    }


    /**
     * Validate that the object that comes out of the test has the same content as the original test object.
     *
     * @param resultObject object returned by the test
     */
    private void validateResultObject(ValidValue  resultObject)
    {
        assertTrue(resultObject.getType().equals(type));
        assertTrue(resultObject.getGUID().equals("TestGUID"));
        assertTrue(resultObject.getClassifications() != null);

        assertTrue(resultObject.getDisplayName().equals("TestName"));
        assertTrue(resultObject.getDescription().equals("TestDescription"));
        assertTrue(resultObject.getScope().equals("TestScope"));
        assertTrue(resultObject.getUsage().equals("TestUsage"));
        assertTrue(resultObject.getPreferredValue().equals("TestPreferredValue"));
        assertTrue(resultObject.getDataType().equals("TestDataType"));
    }


    /**
     * Validate that the object that comes out of the test has the same content as the original test object.
     *
     * @param resultObject object returned by the test
     */
    private void validateDefinitionResultObject(ValidValueDefinition  resultObject)
    {
        assertTrue(resultObject.getType().equals(type));
        assertTrue(resultObject.getGUID().equals("TestGUID"));
        assertTrue(resultObject.getClassifications() != null);

        assertTrue(resultObject.getDisplayName().equals("TestName"));
        assertTrue(resultObject.getDescription().equals("TestDescription"));
        assertTrue(resultObject.getScope().equals("TestScope"));
        assertTrue(resultObject.getUsage().equals("TestUsage"));
        assertTrue(resultObject.getPreferredValue().equals("TestPreferredValue"));
        assertTrue(resultObject.getDataType().equals("TestDataType"));
    }


    /**
     * Validate that the object that comes out of the test has the same content as the original test object.
     *
     * @param resultObject object returned by the test
     */
    private void validateSetResultObject(ValidValueSet  resultObject)
    {
        assertTrue(resultObject.getType().equals(type));
        assertTrue(resultObject.getGUID().equals("TestGUID"));
        assertTrue(resultObject.getClassifications() != null);

        assertTrue(resultObject.getDisplayName().equals("TestName"));
        assertTrue(resultObject.getDescription().equals("TestDescription"));
        assertTrue(resultObject.getScope().equals("TestScope"));
        assertTrue(resultObject.getUsage().equals("TestUsage"));
        assertTrue(resultObject.getPreferredValue().equals("TestPreferredValue"));
        assertTrue(resultObject.getDataType().equals("TestDataType"));
    }


    /**
     * Validate that the object is initialized properly
     */
    @Test public void testNullObject()
    {
        ValidValue    nullObject = new ValidValue();

        assertTrue(nullObject.getType() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getClassifications() == null);

        assertTrue(nullObject.getDisplayName() == null);
        assertTrue(nullObject.getDescription() == null);
        assertTrue(nullObject.getScope() == null);
        assertTrue(nullObject.getUsage() == null);
        assertTrue(nullObject.getPreferredValue() == null);
        assertTrue(nullObject.getDataType() == null);

        nullObject = new ValidValue(null);

        assertTrue(nullObject.getType() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getClassifications() == null);

        assertTrue(nullObject.getDisplayName() == null);
        assertTrue(nullObject.getDescription() == null);
        assertTrue(nullObject.getScope() == null);
        assertTrue(nullObject.getUsage() == null);
        assertTrue(nullObject.getPreferredValue() == null);
        assertTrue(nullObject.getDataType() == null);
    }


    /**
     * Validate that the object is initialized properly
     */
    @Test public void testNullObjectDefinition()
    {
        ValidValueDefinition    nullObject = new ValidValueDefinition();

        assertTrue(nullObject.getType() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getClassifications() == null);

        assertTrue(nullObject.getDisplayName() == null);
        assertTrue(nullObject.getDescription() == null);
        assertTrue(nullObject.getScope() == null);
        assertTrue(nullObject.getUsage() == null);
        assertTrue(nullObject.getPreferredValue() == null);

        nullObject = new ValidValueDefinition(null);

        assertTrue(nullObject.getType() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getClassifications() == null);

        assertTrue(nullObject.getDisplayName() == null);
        assertTrue(nullObject.getDescription() == null);
        assertTrue(nullObject.getScope() == null);
        assertTrue(nullObject.getUsage() == null);
        assertTrue(nullObject.getPreferredValue() == null);
        assertTrue(nullObject.getDataType() == null);
    }


    /**
     * Validate that the object is initialized properly
     */
    @Test public void testNullObjectSet()
    {
        ValidValueSet    nullObject = new ValidValueSet();

        assertTrue(nullObject.getType() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getClassifications() == null);

        assertTrue(nullObject.getDisplayName() == null);
        assertTrue(nullObject.getDescription() == null);
        assertTrue(nullObject.getScope() == null);
        assertTrue(nullObject.getUsage() == null);
        assertTrue(nullObject.getPreferredValue() == null);

        nullObject = new ValidValueSet(null);

        assertTrue(nullObject.getType() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getClassifications() == null);

        assertTrue(nullObject.getDisplayName() == null);
        assertTrue(nullObject.getDescription() == null);
        assertTrue(nullObject.getScope() == null);
        assertTrue(nullObject.getUsage() == null);
        assertTrue(nullObject.getPreferredValue() == null);
    }


    /**
     * Validate that 2 different objects with the same content are evaluated as equal.
     * Also that different objects are considered not equal.
     */
    @Test public void testEquals()
    {
        assertFalse(getTestObject().equals(null));
        assertFalse(getTestObject().equals("DummyString"));
        assertTrue(getTestObject().equals(getTestObject()));

        ValidValue  sameObject = getTestObject();
        assertTrue(sameObject.equals(sameObject));

        ValidValue  differentObject = getTestObject();
        differentObject.setDisplayName("Different");
        assertFalse(getTestObject().equals(differentObject));

        differentObject = getTestObject();
        differentObject.setGUID("Different");
        assertFalse(getTestObject().equals(differentObject));
    }


    /**
     *  Validate that 2 different objects with the same content have the same hash code.
     */
    @Test public void testHashCode()
    {
        assertTrue(getTestObject().hashCode() == getTestObject().hashCode());
    }


    /**
     *  Validate that an object cloned from another object has the same content as the original
     */
    @Test public void testClone()
    {
        validateResultObject(new ValidValue(getTestObject()));
    }


    /**
     * Validate that an object generated from a JSON String has the same content as the object used to
     * create the JSON String.
     */
    @Test public void testJSON()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String       jsonString   = null;

        /*
         * This class
         */
        try
        {
            jsonString = objectMapper.writeValueAsString(getTestObject());
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject(objectMapper.readValue(jsonString, ValidValue.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        ElementBase elementBase = getTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(elementBase);
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject((ValidValue) objectMapper.readValue(jsonString, ElementBase.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        ElementBase  propertyBase = getTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(propertyBase);
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject((ValidValue) objectMapper.readValue(jsonString, ElementBase.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }
    }


    /**
     * Validate that an object generated from a JSON String has the same content as the object used to
     * create the JSON String.
     */
    @Test public void testSetJSON()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String       jsonString   = null;

        /*
         * This class
         */
        try
        {
            jsonString = objectMapper.writeValueAsString(getSetTestObject());
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject(objectMapper.readValue(jsonString, ValidValue.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superClass
         */
        try
        {
            jsonString = objectMapper.writeValueAsString(getSetTestObject());
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateSetResultObject((ValidValueSet)objectMapper.readValue(jsonString, ValidValue.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }


        /*
         * Through superclass
         */
        ValidValue validValue = getSetTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(validValue);
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateSetResultObject((ValidValueSet) objectMapper.readValue(jsonString, ValidValue.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }


        /*
         * Through superclass
         */
        ElementBase elementBase = getSetTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(elementBase);
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateSetResultObject((ValidValueSet) objectMapper.readValue(jsonString, ElementBase.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        ElementBase  propertyBase = getSetTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(propertyBase);
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateSetResultObject((ValidValueSet) objectMapper.readValue(jsonString, ElementBase.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }
    }


    /**
     * Validate that an object generated from a JSON String has the same content as the object used to
     * create the JSON String.
     */
    @Test public void testDefinitionJSON()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String       jsonString   = null;

        /*
         * This class
         */
        try
        {
            jsonString = objectMapper.writeValueAsString(getDefinitionTestObject());
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateDefinitionResultObject(objectMapper.readValue(jsonString, ValidValueDefinition.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        ValidValue validValue = getDefinitionTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(validValue);
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateDefinitionResultObject((ValidValueDefinition) objectMapper.readValue(jsonString, ValidValue.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        ElementBase elementBase = getDefinitionTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(elementBase);
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateDefinitionResultObject((ValidValueDefinition) objectMapper.readValue(jsonString, ElementBase.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        ElementBase  propertyBase = getDefinitionTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(propertyBase);
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateDefinitionResultObject((ValidValueDefinition) objectMapper.readValue(jsonString, ElementBase.class));
        }
        catch (Exception   exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }
    }
}
