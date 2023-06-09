package com.dasalgadco.testinjava.shared.domain;

import java.util.Objects;

public class IntegerValueObject {
  protected Integer value;

  public IntegerValueObject(Integer value) {
    this.value = value;
  }

  public Integer value() {
    return value;
  }

  public boolean isBiggerThan(IntegerValueObject other) {
    return this.value > other.value();
  }

  public boolean isBiggerThanZero() {
    return this.value > 0;
  }

  public boolean isZero() {
    return this.value == 0;
  }

  public boolean isLessThanZero() {
    return this.value < 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof IntegerValueObject)) return false;
    IntegerValueObject that = (IntegerValueObject) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
