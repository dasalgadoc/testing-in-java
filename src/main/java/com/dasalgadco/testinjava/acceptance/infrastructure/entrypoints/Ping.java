package com.dasalgadco.testinjava.acceptance.infrastructure.entrypoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {
  @GetMapping("/ping")
  public String ping() {
    return "Pong from test-in-java";
  }
}
