package com.dasalgadco.testinjava.integration.domain;

import com.dasalgadco.testinjava.integration.domain.error.InvalidStudent;
import com.dasalgadco.testinjava.shared.domain.StringValueObject;

public class StudentName extends StringValueObject {
  public StudentName(String value) {
    super(value);
    if (value.length() < 3) {
      throw new InvalidStudent("The student name must be at least 3 characters long");
    }
  }
}
