package com.dasalgadco.testinjava.testdoubles.application.error;

public class StudentSignUpException extends RuntimeException {
  public StudentSignUpException(String message) {
    super(message);
  }
}
