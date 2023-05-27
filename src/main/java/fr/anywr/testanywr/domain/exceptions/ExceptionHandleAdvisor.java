package fr.anywr.testanywr.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Severin Mbekou <mbekou99@gmail.com>
 */
@RestControllerAdvice
public class ExceptionHandleAdvisor {

  @ExceptionHandler(UsernameNotFoundException.class)
  public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException exception, WebRequest request) {
    ErrorDetails errorDetails = ErrorDetails.builder().code(String.valueOf(HttpStatus.NOT_FOUND.value()))
        .message(exception.getMessage())
        .details(request.getDescription(false)).build();
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler(CustomRuntimeException.class)
  public ResponseEntity<?> handleTechnicalRuntimeException(CustomRuntimeException exception, WebRequest request) {
    ErrorDetails errorDetails = ErrorDetails.builder().code(String.valueOf(exception.getStatusCode()))
        .message(exception.getMessage())
        .details(request.getDescription(false)).build();
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleException(Exception exception, WebRequest request) {
    ErrorDetails errorDetails = ErrorDetails.builder().code("400")
        .message(exception.getMessage())
        .details(request.getDescription(false)).build();
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }
}
