package com.dasalgadco.testinjava.instances.domain;

import com.dasalgadco.testinjava.instances.domain.error.InvalidUser;
import com.dasalgadco.testinjava.shared.domain.IntegerValueObject;

public class UserAccessLevel extends IntegerValueObject {
  private AccessLevelMap state = new AccessLevelMap();

  public UserAccessLevel(Integer value) {
    super(value);
    if (!isValidUserAccessLevel(value)) {
      throw new InvalidUser("Invalid user access level");
    }
  }

  public UserAccessLevel(String accessLevel) {
    super(0);
    if (!isValidUserAccessLevel(accessLevel)) {
      throw new InvalidUser("Invalid user access level");
    }
    this.value = state.accessLevelMap.get(accessLevel);
  }

  private boolean isValidUserAccessLevel(Integer value) {
    return state.accessLevelMap.containsValue(value);
  }

  private boolean isValidUserAccessLevel(String accessLevel) {
    return state.accessLevelMap.containsKey(accessLevel);
  }
}
