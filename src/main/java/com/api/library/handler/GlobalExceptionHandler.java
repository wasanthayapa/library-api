package com.api.library.handler;

import com.api.library.exception.RecodeNotFoundException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /***
     *
     * Collect Recode not found Exception
     * @param ex
     * @param request
     * @return ResponseEntity
     *
     */
    @ExceptionHandler(RecodeNotFoundException.class)
    public ResponseEntity<?> handleRecodeNotFoundException(RecodeNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    /***
     *
     * Collect Common Exception
     * @param ex
     * @param request
     * @return ResponseEntity
     *
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
