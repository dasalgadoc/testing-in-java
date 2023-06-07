package com.dasalgadco.testinjava.integration.domain;

import com.dasalgadco.testinjava.shared.domain.AggregateRoot;
import java.util.ArrayList;

public class Student extends AggregateRoot {
  private final StudentId id;
  private final StudentName name;
  private final StudentAge age;

  public Student(StudentName name, StudentAge age) {
    super(new ArrayList<>());
    this.id = new StudentId();
    this.name = name;
    this.age = age;
  }

  public Student(StudentId id, StudentName name, StudentAge age) {
    super(new ArrayList<>());
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public static Student create(StudentName name, StudentAge age) {
    Student student = new Student(name, age);
    student.recordEvent(new StudentCreated(student.id.value()));

    return student;
  }

  public StudentId getId() {
    return id;
  }

  public StudentName getName() {
    return name;
  }

  public StudentAge getAge() {
    return age;
  }
}
