package com.dasalgadco.testinjava.shared.domain;

import java.util.UUID;

public class UUIDValueObject {
  protected UUID value;

  public UUIDValueObject() {
    this.value = UUID.randomUUID();
  }

  public UUIDValueObject(String value) {
    this.value = UUID.fromString(value);
  }

  public String value() {
    return value.toString();
  }
}
