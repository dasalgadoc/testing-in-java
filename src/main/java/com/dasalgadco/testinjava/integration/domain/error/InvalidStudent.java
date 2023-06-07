package com.dasalgadco.testinjava.integration.domain.error;

public class InvalidStudent extends RuntimeException {
  public InvalidStudent(String message) {
    super(message);
  }
}
