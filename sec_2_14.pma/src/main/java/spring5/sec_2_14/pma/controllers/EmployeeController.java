package spring5.sec_2_14.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5.sec_2_14.pma.dao.EmployeeRepo;
import spring5.sec_2_14.pma.entities.Employee;

@Controller
@RequestMapping("employees")
public class EmployeeController {
  @Autowired
  EmployeeRepo employeeRepo;

  @GetMapping
  public String showEmployees(Model model) {
    List<Employee> employees = employeeRepo.findAll();

    model.addAttribute("employees", employees);

    return "employees/list";
  }

  @GetMapping("/form")
  public String showForm(Model model) {
    Employee newEmployee = new Employee();

    model.addAttribute("employee", newEmployee);

    return "employees/form";
  }

  @PostMapping("/save")
  public String saveNewEmployeeToDb(Model model, Employee employee) {
    employeeRepo.save(employee);

    return "redirect:/employees/form";
  }
}
