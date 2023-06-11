package com.dasalgadco.testinjava.instances.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class UserMother {
  private static List<String> testNames =
      List.of("John Doe", "Jane Doe", "Foo Bar", "Bar Foo", "Lorem Ipsum", "Ipsum Lorem");

  public static User withName(String name) {
    UserId userId = new UserId();
    UserName userName = new UserName(name);
    UserAccessLevel userAccessLevel = new UserAccessLevel(randomAccessLevel());

    return new User(userId, userName, userAccessLevel);
  }

  public static User withAccessLevel(Integer accessLevel) {
    UserId userId = new UserId();
    UserName userName = new UserName(randomName());
    UserAccessLevel userAccessLevel = new UserAccessLevel(accessLevel);

    return new User(userId, userName, userAccessLevel);
  }

  public static User withId(String id) {
    UserId userId = UserId.create(id);
    UserName userName = new UserName(randomName());
    UserAccessLevel userAccessLevel = new UserAccessLevel(randomAccessLevel());

    return new User(userId, userName, userAccessLevel);
  }

  public static User userWithArguments(Optional<User> user) {
    UserName name = new UserName(randomName());
    UserId id = new UserId();
    UserAccessLevel accessLevel = new UserAccessLevel(randomAccessLevel());

    if (user.isPresent()) {
      User userValue = user.get();
      if (userValue.name() != null) {
        name = userValue.name();
      }
      if (userValue.id() != null) {
        id = userValue.id();
      }
      if (userValue.accessLevel() != null) {
        accessLevel = userValue.accessLevel();
      }
    }

    return new User(id, name, accessLevel);
  }

  private static Integer randomAccessLevel() {
    List<String> keys = new ArrayList<>(new AccessLevelMap().value.keySet());
    Random random = new Random();
    int randomIndex = random.nextInt(keys.size());
    String randomKey = keys.get(randomIndex);

    return new AccessLevelMap().value.get(randomKey);
  }

  private static String randomName() {
    Random random = new Random();
    int randomIndex = random.nextInt(testNames.size());
    return testNames.get(randomIndex);
  }
}
