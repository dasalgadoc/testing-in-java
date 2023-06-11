package com.dasalgadco.testinjava.instances.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
  // Traditional instance
  @Test
  public void user_should_edit_with_enough_access_level() {
    // Given
    User user = traditionalInstance("John Doe", 2);
    // When
    // Then
    assertTrue(user.canEdit());
  }

  @Test
  public void user_should_be_unable_to_edit_with_user_access_level() {
    // Given
    User user = traditionalInstance("John Doe", 1);
    // When
    // Then
    assertFalse(user.canEdit());
  }

  // Builder instance
  @Test
  public void user_should_edit_with_enough_access_level_builder() {
    // Given
    User user = UserBuilder.builder().withAccessLevel(2).build();
    // When
    // Then
    assertTrue(user.canEdit());
  }

  @Test
  public void user_should_be_unable_to_edit_with_user_access_level_builder() {
    // Given
    User user = UserBuilder.builder().withAccessLevel(1).build();
    // When
    // Then
    assertFalse(user.canEdit());
  }

  // Object mother
  @Test
  public void user_should_edit_with_enough_access_level_object_mother() {
    // Given
    User user = UserMother.withAccessLevel(2);
    // When
    // Then
    assertTrue(user.canEdit());
  }

  @Test
  public void user_should_be_unable_to_edit_with_user_access_level_object_mother() {
    // Given
    User user = UserMother.withAccessLevel(1);
    // When
    // Then
    assertFalse(user.canEdit());
  }

  @Test
  public void user_should_edit_with_enough_access_level_builder_with_default() {
    // Given
    User user = UserBuilder.builder().withAccessLevel(2).buildWithDefaults();
    // When
    // Then
    assertTrue(user.canEdit());

    assertNotEquals("", user.id().value());
    assertNotEquals("", user.name().value());
  }

  @Test
  public void user_should_be_unable_to_edit_with_user_access_level_builder_with_default() {
    // Given
    User user = UserBuilder.builder().withAccessLevel(1).buildWithDefaults();
    // When
    // Then
    assertFalse(user.canEdit());

    assertNotEquals("", user.id().value());
    assertNotEquals("", user.name().value());
  }

  public User traditionalInstance(String userName, Integer userAccessLevel) {
    return new User(new UserName(userName), new UserAccessLevel(userAccessLevel));
  }
}
