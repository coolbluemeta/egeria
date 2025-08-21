/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.opensurvey.measurements;

import org.odpi.openmetadata.frameworks.openmetadata.types.DataType;

import java.util.ArrayList;
import java.util.List;

/**
 * RelationalColumnMetric describes the metrics for a Relational Column.
 */
public enum RelationalColumnMetric implements SurveyMetric
{
    /**
     * Qualified name of the column showing the database name, schema name and table name.
     */
    COLUMN_QNAME ("columnQualifiedName", DataType.STRING.getName(), "Column qualified name", "Qualified name of the column showing the database name, schema name and table name."),

    /**
     * Name of the column within the table.
     */
    COLUMN_NAME ("columnName", DataType.STRING.getName(), "Column name", "Name of the column within the table."),

    /**
     * Number of stored bytes in the column.
     */
    COLUMN_SIZE ("columnSize", DataType.LONG.getName(), "Column size", "Number of stored bytes in the column."),

    /**
     * Data type of column.
     */
    COLUMN_TYPE ("columnDataType", DataType.STRING.getName(),"Column data type", "Data type of column."),

    /**
     * Average width of the values in this column.
     */
    AVERAGE_WIDTH("averageColumnWidth", DataType.INT.getName(), "Average Column Width", "Average width of the values in this column."),

    /**
     * Number of distinct values stored in this column.
     */
    NUMBER_OF_DISTINCT_VALUES("numberOfDistinctValues", DataType.LONG.getName(), "Number Of Distinct Values", "Number of distinct values stored in this column."),

    /**
     * List of the most common values stored in this column.
     */
    MOST_COMMON_VALUES("mostCommonValues", DataType.STRING.getName(), "Most Common Values", "List of the most common values stored in this column."),

    /**
     * The frequency that each of the most common values occur.
     */
    MOST_COMMON_VALUES_FREQUENCY("mostCommonValuesFrequency", DataType.STRING.getName(), "Most Common Values Frequency", "The frequency that each of the most common values occur."),

    /**
     * Is a null value prohibited in this column?
     */
    COLUMN_NOT_NULL("columnNotNull", DataType.BOOLEAN.getName(), "Not Null", "Is a null value prohibited in this column?"),
    ;

    public final String propertyName;
    public final String dataType;
    public final String displayName;
    public final String description;



    /**
     * Create a specific Enum constant.
     *
     * @param propertyName name of the property used to store the measurement
     * @param dataType data type of property
     * @param displayName name of the request type
     * @param description description of the request type
     */
    RelationalColumnMetric(String propertyName,
                           String dataType,
                           String displayName,
                           String description)
    {
        this.propertyName = propertyName;
        this.dataType     = dataType;
        this.displayName  = displayName;
        this.description  = description;
    }


    /**
     * Return the property name used to store the measurement.
     *
     * @return name
     */
    @Override
    public String getPropertyName()
    {
        return propertyName;
    }


    /**
     * Return the data type of the property used to store the measure.
     *
     * @return data type name
     */
    @Override
    public String getDataType()
    {
        return dataType;
    }


    /**
     * Return the name of the metric.
     *
     * @return string name
     */
    @Override
    public String getDisplayName()
    {
        return displayName;
    }


    /**
     * Return the description of the metric.
     *
     * @return text
     */
    @Override
    public String getDescription()
    {
        return description;
    }


    /**
     * Return the defined metrics as a list
     *
     * @return list
     */
    public static List<SurveyMetric> getMetrics()
    {
        return new ArrayList<>(List.of(RelationalColumnMetric.values()));
    }


    /**
     * Output of this enum class and main value.
     *
     * @return string showing enum value
     */
    @Override
    public String toString()
    {
        return "RelationalColumnMetric{" + displayName + "}";
    }
}
