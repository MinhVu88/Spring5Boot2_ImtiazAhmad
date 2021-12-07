package spring5.sec_2_14.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring5.sec_2_14.pma.dao.EmployeeRepo;
import spring5.sec_2_14.pma.dao.ProjectRepo;
import spring5.sec_2_14.pma.entities.Employee;
import spring5.sec_2_14.pma.entities.Project;

@Controller
public class HomeController {
  @Autowired
  ProjectRepo projectRepo;

  @Autowired
  EmployeeRepo employeeRepo;

  @GetMapping("/")
  public String showHomePage(Model model) {
    List<Project> projects = projectRepo.findAll();

    model.addAttribute("projects", projects);

    List<Employee> employees = employeeRepo.findAll();

    model.addAttribute("employees", employees);
    
    return "main/index";
  }
}
