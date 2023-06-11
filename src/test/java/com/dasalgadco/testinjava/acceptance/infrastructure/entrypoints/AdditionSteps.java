package com.dasalgadco.testinjava.acceptance.infrastructure.entrypoints;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dasalgadco.testinjava.acceptance.infrastructure.dto.StudentDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AdditionSteps {

  private final RestTemplate restTemplate = new RestTemplate();
  private ResponseEntity<StudentDto> response;

  @Given("I send a GET request to {string}")
  public void i_send_a_get_request_to(String endpoint) {
    String endpointUrl = "http://localhost:8080" + endpoint;
    response = restTemplate.getForEntity(endpointUrl, StudentDto.class);
  }

  @Then("the response status should be {int}")
  public void then_response_status_should_be(int statusCode) {
    assertEquals(statusCode, response.getStatusCode().value());
  }
}
