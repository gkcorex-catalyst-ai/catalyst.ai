package com.gkcorex.catalyst.ai.advices;

import com.gkcorex.catalyst.ai.exceptions.BadRequestException;
import com.gkcorex.catalyst.ai.exceptions.ResourceNotFoundException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ApiError> handleBadRequest(BadRequestException ex) {
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
    log.error(apiError.toString(), ex);
    return ResponseEntity.status(apiError.status()).body(apiError);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex) {
    ApiError apiError =
        new ApiError(
            HttpStatus.NOT_FOUND, ex.getResourceName() + " with Id: " + ex.getResourceId());
    log.error(apiError.toString(), ex);
    return ResponseEntity.status(apiError.status()).body(apiError);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiError> handleResourceNotFound(MethodArgumentNotValidException ex) {
    List<ApiFieldError> errorList =
        ex.getBindingResult().getFieldErrors().stream()
            .map(error -> new ApiFieldError(error.getField(), error.getDefaultMessage()))
            .toList();

    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Input Validation Failed", errorList);

    log.error(apiError.toString(), ex);
    return ResponseEntity.status(apiError.status()).body(apiError);
  }
}
