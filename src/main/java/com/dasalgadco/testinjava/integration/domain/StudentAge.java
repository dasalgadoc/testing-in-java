package com.dasalgadco.testinjava.integration.domain;

import com.dasalgadco.testinjava.integration.domain.error.InvalidStudent;
import com.dasalgadco.testinjava.shared.domain.IntegerValueObject;

public class StudentAge extends IntegerValueObject {
  public StudentAge(Integer value) {
    super(value);
    if (value < 0) {
      throw new InvalidStudent("The student age can not be less than zero");
    }
  }
}
