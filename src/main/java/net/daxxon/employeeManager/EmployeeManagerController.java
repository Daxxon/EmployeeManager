package net.daxxon.employeeManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeManagerController {

  @RequestMapping("/")
  public String index(Model model) {
    return "index";
  }
}
