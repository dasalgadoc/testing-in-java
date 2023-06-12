package com.dasalgadco.testinjava.instances.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class UserMother {
  private static List<String> testNames =
      List.of("John Doe", "Jane Doe", "Foo Bar", "Bar Foo", "Lorem Ipsum", "Ipsum Lorem");

  public static User withName(String name) {
    String userId = new UserId().value();
    return new User(userId, name, randomAccessLevel());
  }

  public static User withAccessLevel(Integer accessLevel) {
    String userId = new UserId().value();
    return new User(userId, randomName(), accessLevel);
  }

  public static User withId(String id) {
    String userId = UserId.create(id).value();
    return new User(userId, randomName(), randomAccessLevel());
  }

  public static User userWithArguments(Optional<User> user) {
    String name = randomName();
    String id = new UserId().value();
    Integer accessLevel = randomAccessLevel();

    if (user.isPresent()) {
      User userValue = user.get();
      if (userValue.name() != null) {
        name = userValue.name().value();
      }
      if (userValue.id() != null) {
        id = userValue.id().value();
      }
      if (userValue.accessLevel() != null) {
        accessLevel = userValue.accessLevel().value();
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
