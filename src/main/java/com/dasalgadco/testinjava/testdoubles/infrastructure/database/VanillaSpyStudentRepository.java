package com.dasalgadco.testinjava.testdoubles.infrastructure.database;

import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component("VanillaSpyStudentRepository")
public class VanillaSpyStudentRepository implements StudentRepository {
  private boolean saveWasCalled;
  private int saveCalls;
  private boolean searchWasCalled;
  private int searchCalls;

  public VanillaSpyStudentRepository() {
    this.saveWasCalled = false;
    this.saveCalls = 0;
    this.searchWasCalled = false;
    this.searchCalls = 0;
  }

  @Override
  public void save(Student student) {
    this.saveWasCalled = true;
    this.saveCalls++;
  }

  @Override
  public Student search(StudentId id) {
    this.searchWasCalled = true;
    this.searchCalls++;

    throw new RuntimeException("Student not found");
  }
}
