package com.dasalgadco.testinjava.integration.infrastructure.database;

import com.dasalgadco.testinjava.integration.domain.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Table(name = "student")
@EnableAutoConfiguration
public class StudentEntity {
  @Id private String id;
  private String name;
  private Integer age;

  public StudentEntity() {}

  public StudentEntity(String id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Student entityToAggregate() {
    return new Student(id, name, age);
  }

  public static StudentEntity aggregateToEntity(Student student) {
    return new StudentEntity(
        student.getId().value(), student.getName().value(), student.getAge().value());
  }
}
