package io.baris.projector.api.response;

public class SuccessResponse {

  private String message;

  public SuccessResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("SuccessResponse{");
    sb.append("message='").append(message).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
