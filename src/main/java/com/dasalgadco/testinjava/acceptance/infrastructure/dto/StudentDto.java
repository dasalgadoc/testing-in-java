package com.dasalgadco.testinjava.acceptance.infrastructure.dto;

import com.dasalgadco.testinjava.integration.domain.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDto {
  @JsonProperty("student_id")
  private String id;

  @JsonProperty("student_name")
  private String name;

  @JsonProperty("student_age")
  private Integer age;

  public StudentDto() {}

  public StudentDto(Student student) {
    this.id = student.getId().value();
    this.name = student.getName().value();
    this.age = student.getAge().value();
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
}
