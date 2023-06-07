package com.dasalgadco.testinjava.integration.domain;

import com.dasalgadco.testinjava.integration.domain.error.InvalidStudent;
import com.dasalgadco.testinjava.shared.domain.UUIDValueObject;

public class StudentId extends UUIDValueObject {
  public StudentId(String value) throws Exception {
    super(value);
  }

  public StudentId() {
    super();
  }

  public static StudentId create(String value) {
    StudentId id;
    try {
      id = new StudentId(value);
    } catch (Exception e) {
      throw new InvalidStudent("Invalid student id");
    }
    return id;
  }
}
