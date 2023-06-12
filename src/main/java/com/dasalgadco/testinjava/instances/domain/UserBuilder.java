package com.dasalgadco.testinjava.instances.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Vanilla implementation of the builder pattern. Lombok can be used to reduce boilerplate code.
public class UserBuilder {
  private static List<String> testNames =
      List.of("John Doe", "Jane Doe", "Foo Bar", "Bar Foo", "Lorem Ipsum", "Ipsum Lorem");
  private String id;
  private String name;
  private Integer accessLevel;

  public static UserBuilder builder() {
    return new UserBuilder();
  }

  public UserBuilder withId(String id) {
    this.id = id;
    return this;
  }

  public UserBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public UserBuilder withAccessLevel(Integer accessLevel) {
    this.accessLevel = accessLevel;
    return this;
  }

  // Before the VO refactor, this method has an academic background.
  // Now I decided to refactor to better VO implementation, the power of a well-designed domain
  // prevents me to be academic.
  // If you want to check the old implementation, please check look-up the git history for this
  // class.
  public User build() {
    if (this.id == null) {
      this.id = new UserId().value();
    }
    if (this.name == null) {
      this.name = randomName();
    }
    return new User(this.id, this.name, this.accessLevel);
  }

  public User buildWithDefaults() {
    if (this.id == null) {
      this.id = new UserId().value();
    }
    if (this.name == null) {
      this.name = randomName();
    }
    if (this.accessLevel == null) {
      this.accessLevel = randomAccessLevel();
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
