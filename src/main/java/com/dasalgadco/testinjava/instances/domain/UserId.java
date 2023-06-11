package com.dasalgadco.testinjava.instances.domain;

import com.dasalgadco.testinjava.instances.domain.error.InvalidUser;
import com.dasalgadco.testinjava.shared.domain.UUIDValueObject;

public class UserId extends UUIDValueObject {
  private UserId(String value) throws Exception {
    super(value);
  }

  public UserId() {
    super();
  }

  public static UserId create(String value) {
    UserId id;
    try {
      id = new UserId(value);
    } catch (Exception e) {
      throw new InvalidUser("Invalid user id");
    }
    return id;
  }
}
