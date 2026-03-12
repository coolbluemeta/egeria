/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.frameworks.opensurvey.measurements;

import org.odpi.openmetadata.frameworks.openmetadata.types.DataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * RelationalDatabaseMetric describes the metrics for a Relational Database.
 */
public enum RelationalDatabaseMetric implements SurveyMetric
{
    /**
     * Name of the database
     */
    DATABASE_NAME("databaseName", DataType.STRING.getDisplayName(), "Database Name", "Name of the database"),

    /**
     * Number of schemas found in the surveyed resource.
     */
    SCHEMA_COUNT  ("schemaCount", DataType.LONG.getDisplayName(), "Number of schemas", "Number of schemas found in the database."),

    /**
     * Number of tables found in the database.
     */
    TABLE_COUNT   ("tableCount", DataType.LONG.getDisplayName(), "Number of tables", "Number of tables found in the database."),

    /**
     * Count of views in the database.
     */
    VIEW_COUNT ("viewCount", DataType.LONG.getDisplayName(), "Number of views", "Count of views in the database."),

    /**
     * Count of materialized views in the database.
     */
    MAT_VIEW_COUNT ("materializedViewCount", DataType.LONG.getDisplayName(), "Number of materialized views", "Count of materialized views in the database."),

    /**
     * Count of all columns in the tables/views.
     */
    COLUMN_COUNT  ("columnCount", DataType.LONG.getDisplayName(), "Number of columns", "Count of all columns in the tables/views."),

    /**
     * Number of stored bytes of data in the surveyed resource.
     */
    DATA_SIZE     ("dataSize", DataType.LONG.getDisplayName(), "Data size", "Number of stored bytes of data in the surveyed resource."),

    /**
     * Number of rows retrieved from any table in the database.
     */
    ROWS_FETCHED  ("rowsFetched", DataType.LONG.getDisplayName(), "Rows Fetched", "Number of rows retrieved from any table in the database."),

    /**
     * Number of rows inserted from any table in the database.
     */
    ROWS_INSERTED ("rowsInserted", DataType.LONG.getDisplayName(), "Rows Inserted", "Number of rows inserted from any table in the database."),

    /**
     * Number of rows updated from any table in the database.
     */
    ROWS_UPDATED  ("rowsUpdated", DataType.LONG.getDisplayName(), "Rows Updated", "Number of rows updated from any table in the database."),

    /**
     * Number of rows deleted from any table in the database.
     */
    ROWS_DELETED  ("rowsDeleted", DataType.LONG.getDisplayName(), "Rows Deleted", "Number of rows deleted from any table in the database."),

    /**
     * The length of time (milliseconds) that the database had at least one open session from an external client.
     */
    SESSION_TIME  ("totalSessionTime", DataType.DOUBLE.getDisplayName(), "Session Time", "The length of time (milliseconds) that the database had at least one open session from an external client."),

    /**
     * The length of time (milliseconds) that the database was being actively queried.
     */
    ACTIVE_TIME   ("totalActiveTime", DataType.DOUBLE.getDisplayName(), "Active Time", "The length of time (milliseconds) that the database was being actively queried."),

    /**
     * Last time that the statistics were reset in the database.
     */
    LAST_STATISTICS_RESET ("lastStatisticsReset", DataType.DATE.getDisplayName(), "Last statistics reset", "Last time that the statistics were reset in the database."),

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
    RelationalDatabaseMetric(String propertyName,
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
        return new ArrayList<>(Arrays.asList(RelationalDatabaseMetric.values()));
    }


    /**
     * Output of this enum class and main value.
     *
     * @return string showing enum value
     */
    @Override
    public String toString()
    {
        return "RelationalDatabaseMetric{" + displayName + "}";
    }
}
