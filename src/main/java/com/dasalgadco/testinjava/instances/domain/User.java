package com.dasalgadco.testinjava.instances.domain;

import com.dasalgadco.testinjava.shared.domain.AggregateRoot;
import java.util.ArrayList;

public class User extends AggregateRoot {
  private UserId id;
  private UserName name;
  private UserAccessLevel accessLevel;

  public User(String id, String name, Integer accessLevel) {
    super(new ArrayList<>());
    this.id = UserId.create(id);
    this.name = new UserName(name);
    this.accessLevel = new UserAccessLevel(accessLevel);
  }

  public User(String name, Integer accessLevel) {
    super(new ArrayList<>());
    this.id = new UserId();
    this.name = new UserName(name);
    this.accessLevel = new UserAccessLevel(accessLevel);
  }

  public static User create(String name, Integer accessLevel) {
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

  public boolean canEdit() {
    return accessLevel.value() >= UserAccessLevel.MIN_EDITOR_ACCESS_LEVEL;
  }
}
