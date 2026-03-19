/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.platformchassis.springboot.ffdc;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import org.odpi.openmetadata.commonservices.ffdc.rest.FFDCResponseBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception handler for Jackson serialization/deserialization errors.
 */
@RestControllerAdvice
public class JacksonExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(JacksonExceptionHandler.class);


    /**
     * Handler for all read-side streaming processing problems,
     * including parsing and input value coercion problems.
     *
     * @param streamReadException the exception that occurred during parsing
     * @return 400 Bad Request
     */
    @ExceptionHandler(StreamReadException.class)
    public ResponseEntity<FFDCResponseBase> handleStreamReadException(StreamReadException streamReadException)
    {
        log.error("JSON read error: {}", streamReadException.getMessage(), streamReadException); // Log exception with stack trace

        FFDCResponseBase error = new FFDCResponseBase();
        error.setRelatedHTTPCode(HttpStatus.BAD_REQUEST.value());
        error.setExceptionClassName(streamReadException.getClass().getName());
        error.setExceptionErrorMessage(streamReadException.getMessage());
        error.setExceptionSystemAction("The system is unable to decipher the request and returns with an error.");
        error.setExceptionUserAction("Check your JSON format (e.g., missing braces, unescaped quotes).");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    /**
     * Handle all databind level processing problems, as distinct from
     * stream-level problems or I/O issues above.
     *
     * @param databindException the databind exception that occurred
     * @return 400 Bad Request
     */
    @ExceptionHandler(DatabindException.class)
    public ResponseEntity<FFDCResponseBase> handleDatabindException(DatabindException databindException)
    {
        log.error("JSON mapping error: {}", databindException.getMessage(), databindException); // Log exception details

        FFDCResponseBase error = new FFDCResponseBase();
        error.setRelatedHTTPCode(HttpStatus.BAD_REQUEST.value());
        error.setExceptionClassName(databindException.getClass().getName());
        error.setExceptionErrorMessage(databindException.getMessage());
        error.setExceptionSystemAction("The system is unable to map the request to Egeria's implementation and returns with an error.");
        error.setExceptionUserAction("Ensure JSON fields match the expected Java object structure and types.");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
