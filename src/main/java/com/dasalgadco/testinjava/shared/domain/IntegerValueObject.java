package com.dasalgadco.testinjava.shared.domain;

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
}
