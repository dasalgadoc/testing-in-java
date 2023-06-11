package com.dasalgadco.testinjava.instances.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Vanilla implementation of the builder pattern. Lombok can be used to reduce boilerplate code.
public class UserBuilder {
  private static List<String> testNames =
      List.of("John Doe", "Jane Doe", "Foo Bar", "Bar Foo", "Lorem Ipsum", "Ipsum Lorem");
  private UserId id;
  private UserName name;
  private UserAccessLevel accessLevel;

  public static UserBuilder builder() {
    return new UserBuilder();
  }

  public UserBuilder withId(String id) {
    UserId userId = UserId.create(id);
    this.id = userId;

    return this;
  }

  public UserBuilder withName(String name) {
    UserName userName = new UserName(name);
    this.name = userName;

    return this;
  }

  public UserBuilder withAccessLevel(Integer accessLevel) {
    UserAccessLevel userAccessLevel = new UserAccessLevel(accessLevel);
    this.accessLevel = userAccessLevel;

    return this;
  }

  public User build() {
    return new User(this.id, this.name, this.accessLevel);
  }

  public User buildWithDefaults() {
    if (this.id == null) {
      this.id = new UserId();
    }
    if (this.name == null) {
      this.name = new UserName(randomName());
    }
    if (this.accessLevel == null) {
      this.accessLevel = new UserAccessLevel(randomAccessLevel());
    }
    return new User(this.id, this.name, this.accessLevel);
  }

  private Integer randomAccessLevel() {
    List<String> keys = new ArrayList<>(new AccessLevelMap().value.keySet());
    Random random = new Random();
    int randomIndex = random.nextInt(keys.size());
    String randomKey = keys.get(randomIndex);

    return new AccessLevelMap().value.get(randomKey);
  }

  private String randomName() {
    Random random = new Random();
    int randomIndex = random.nextInt(testNames.size());
    return testNames.get(randomIndex);
  }
}
