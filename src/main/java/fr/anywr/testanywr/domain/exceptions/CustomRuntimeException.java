package fr.anywr.testanywr.domain.exceptions;

public class CustomRuntimeException extends RuntimeException {
  private static final long serialVersionUID = -7661881974219233311L;

  private String statusCode;

  public CustomRuntimeException(String message, String statusCode) {
    super(message);
    this.statusCode = statusCode;
  }

  public CustomRuntimeException(String message) {
    super(message);
  }

  public String getStatusCode() {
    return statusCode;
  }
}
