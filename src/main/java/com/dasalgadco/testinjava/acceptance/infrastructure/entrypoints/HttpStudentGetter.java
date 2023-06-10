package com.dasalgadco.testinjava.acceptance.infrastructure.entrypoints;

import com.dasalgadco.testinjava.acceptance.application.StudentSearcher;
import com.dasalgadco.testinjava.acceptance.infrastructure.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpStudentGetter {

  @Autowired private StudentSearcher studentSearcher;

  @GetMapping("/student/{studentId}")
  public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") String studentId) {
    return ResponseEntity.ok(new StudentDto(studentSearcher.invoke(studentId)));
  }
}
