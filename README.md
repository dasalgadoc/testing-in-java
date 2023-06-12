<h1 align="center">
  🚀 🍮 Testing techniques in Java 🍮 🚀
</h1>

<p align="center">
  This repository contains a project to explore basic test techniques in Java.
</p>

__Notes__:
- All test are passing, even the bad ones.
- To explore similar techniques in Go, please check [this repository](https://github.com/dasalgadoc/testing-in-go) also, you will find theoretical information about testing.
- If you'll use this repository for study. I strongly recommend to follow commit by commit.

## 🧲 Environment Setup

### 🛠️ Needed tools

1. Java 17
2. Maven
3. Docker and Docker compose (I use Docker version 23.01.1 and docker-compose v2.17.0)

### 🏃🏻 Application execution

1. Make sure to download all __Needed tools__
2. Clone the repository
3. Build up maven project
```bash
mvn dependency:resolve
```
4. Compile the project
```bash
mvn compile && mvn package
```
5. Run test, this step will start the docker environment (make sure ports 8080 and 3306 is not in use)
```bash
make all
```
5. Enjoy! 😎

## 📚 References

- [Mockito](https://site.mockito.org/)
- [Mockito Spy](https://www.baeldung.com/mockito-spy)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Boot Test](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing)
- [Cucumber](https://cucumber.io/)
- [Parallel testing Java using Maven](https://www.baeldung.com/maven-junit-parallel-tests)

## ✏️ Notes
Mockito spy allow to modify the behavior of a method in a class. It is useful when you want to test a method that calls other methods in the same class.

### 🥒 Cucumber instructions
1. Add dependencies
```xml
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.1.0</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>7.1.0</version>
    <scope>test</scope>
</dependency>
```
2. Create a feature file in `src/test/features`
3. Create a Java Class to receive steps
```java
// Annotations imports
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

@Given("I send a GET request to {string}")
public void i_send_a_get_request_to(String endpoint) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
```

4.Create a Test class to run the feature

```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/features",
    glue = "<PACKAGE WHERE STEP 2 CLASS EXISTS>")
@SpringBootTest
public class HttpStudentGetterTest {
    // No body needed
}
```

5. Run the test class

### 🙅🏻‍♂️ Exclude testing 

Using maven, exclude some test is easy, just subtract the suffix `Test` from the class name.
