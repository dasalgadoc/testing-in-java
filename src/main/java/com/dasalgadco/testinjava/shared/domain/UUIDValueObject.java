package com.dasalgadco.testinjava.shared.domain;

import java.util.Objects;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UUIDValueObject)) return false;
    UUIDValueObject that = (UUIDValueObject) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
