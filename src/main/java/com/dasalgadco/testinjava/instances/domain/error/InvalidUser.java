package com.dasalgadco.testinjava.instances.domain.error;

public class InvalidUser extends RuntimeException {
  public InvalidUser(String message) {
    super(message);
  }
}
