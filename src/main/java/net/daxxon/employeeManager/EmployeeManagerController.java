package net.daxxon.employeeManager;

import net.daxxon.employeeManager.employee.Employee;
import net.daxxon.employeeManager.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeManagerController {

  @Autowired
  private EmployeeService employeeService;

  private ObjectMapper objectMapper = new ObjectMapper();

  @PostMapping("/api/employee")
  public String addEmployee(@RequestBody String json) throws IOException {
    Employee employee = objectMapper.readValue(json, Employee.class);
    employeeService.add(employee);

    return "ok";
  }

  @PutMapping("/api/employee/{id")


}
