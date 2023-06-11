package com.dasalgadco.testinjava.tips.domain.error;

public class InvalidBook extends RuntimeException {
  public InvalidBook(String message) {
    super(message);
  }
}
