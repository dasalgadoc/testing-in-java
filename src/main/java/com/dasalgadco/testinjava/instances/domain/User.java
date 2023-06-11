package com.dasalgadco.testinjava.instances.domain;

import com.dasalgadco.testinjava.shared.domain.AggregateRoot;
import java.util.ArrayList;

public class User extends AggregateRoot {
  private UserId id;
  private UserName name;
  private UserAccessLevel accessLevel;

  public User(UserId id, UserName name, UserAccessLevel accessLevel) {
    super(new ArrayList<>());
    this.id = id;
    this.name = name;
    this.accessLevel = accessLevel;
  }

  public User(UserName name, UserAccessLevel accessLevel) {
    super(new ArrayList<>());
    this.id = new UserId();
    this.name = name;
    this.accessLevel = accessLevel;
  }

  public static User create(UserName name, UserAccessLevel accessLevel) {
    User user = new User(name, accessLevel);

    // No domain events are recorded here.

    return user;
  }

  public UserId id() {
    return id;
  }

  public UserName name() {
    return name;
  }

  public UserAccessLevel accessLevel() {
    return accessLevel;
  }
}
