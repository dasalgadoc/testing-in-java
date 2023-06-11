package com.dasalgadco.testinjava.instances.domain;

import com.dasalgadco.testinjava.shared.domain.StringValueObject;

public class UserName extends StringValueObject {
  public UserName(String value) {
    super(value);
    if (value.length() < 3) {
      throw new IllegalArgumentException("The user name must be at least 3 characters long.");
    }
  }
}
