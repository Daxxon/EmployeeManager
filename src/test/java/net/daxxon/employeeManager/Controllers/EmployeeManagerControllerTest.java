package net.daxxon.employeeManager.Controllers;

import net.daxxon.employeeManager.employee.Employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeManagerControllerTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void addEmployeeTest() throws Exception {
    Employee myEmployee = new Employee();
    myEmployee.setFirstName("Joe");
    myEmployee.setLastName("Farkins");
    myEmployee.setPosition("Final Boss");
    HttpEntity<Employee> httpEntity = new HttpEntity(myEmployee);
    ResponseEntity<String> responseEntity = testRestTemplate.exchange("/api/add/employee", HttpMethod.POST, httpEntity, String.class);
    assertTrue(responseEntity.hasBody());
    String expected = "{\n" +
        "  \"id\": 1,\n" +
        "  \"firstName\": \"Joe\",\n" +
        "  \"lastName\": \"Farkins\",\n" +
        "  \"position\": \"Final Boss\"\n" +
        "}";

    String actual = responseEntity.getBody();
    System.out.println(actual);
    JSONAssert.assertEquals(expected, actual, false);

  }
}