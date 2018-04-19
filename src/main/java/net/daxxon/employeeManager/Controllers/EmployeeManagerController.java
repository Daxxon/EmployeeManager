package net.daxxon.employeeManager.Controllers;

import net.daxxon.employeeManager.employee.Employee;
import net.daxxon.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeManagerController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @PostMapping(value = "/api/add/employee", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public @ResponseBody void addEmployee(Employee employee) throws IOException {
    employeeRepository.save(employee);
  }

  @RequestMapping("/api/list/employees")
  public Iterable<Employee> list() throws IOException {
    return employeeRepository.findAll();
  }
}
