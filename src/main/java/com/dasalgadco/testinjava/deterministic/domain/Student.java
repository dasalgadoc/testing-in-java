package com.dasalgadco.testinjava.deterministic.domain;

import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.shared.domain.AggregateRoot;
import java.util.ArrayList;

public class Student extends AggregateRoot {
  private final StudentId id;
  private final StudentShift shift;

  public Student(String shift) {
    super(new ArrayList<>());
    this.id = new StudentId();
    this.shift = new StudentShift(shift);
  }

  public Student(Integer hour) {
    super(new ArrayList<>());
    this.id = new StudentId();
    this.shift = new StudentShift(hour);
  }

  public Student(String id, String shift) {
    super(new ArrayList<>());
    this.id = StudentId.create(id);
    this.shift = new StudentShift(shift);
  }

  public Student(String id, Integer hour) {
    super(new ArrayList<>());
    this.id = StudentId.create(id);
    this.shift = new StudentShift(hour);
  }

  public static Student create(String shift) {
    Student student = new Student(shift);

    // No domain event is recorded here

    return student;
  }

  public static Student create(Integer hour) {
    Student student = new Student(hour);

    // No domain event is recorded here

    return student;
  }

  public StudentId getId() {
    return id;
  }

  public StudentShift getShift() {
    return shift;
  }

  public boolean isHourBetweenShifts(Integer hour) {
    String hourShift = new TimeShifts().getShift(hour);
    return hourShift.equals(shift.value());
  }
}
