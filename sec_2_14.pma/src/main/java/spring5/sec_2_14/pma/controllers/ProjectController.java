package spring5.sec_2_14.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

import spring5.sec_2_14.pma.dao.EmployeeRepo;
import spring5.sec_2_14.pma.dao.ProjectRepo;
import spring5.sec_2_14.pma.entities.Employee;
import spring5.sec_2_14.pma.entities.Project;

@Controller
@RequestMapping("projects")
public class ProjectController {
  @Autowired
  ProjectRepo projectRepo;

  @Autowired
  EmployeeRepo employeeRepo;

  @GetMapping
  public String showProjects(Model model) {
    List<Project> projects = projectRepo.findAll();

    model.addAttribute("projects", projects);

    return "projects/list";
  }

  @GetMapping("/form")
  public String showForm(Model model) {
    Project newProject = new Project();

    model.addAttribute("project", newProject);

    List<Employee> employees = employeeRepo.findAll();

    model.addAttribute("allEmployees", employees);

    return "projects/form";
  }

  @PostMapping("/save")
  public String saveNewProjectToDb(
    Model model, 
    Project project 
    // @RequestParam List<Long> employees
  ) {
    projectRepo.save(project);

    // Iterable<Employee> team = employeeRepo.findAllById(employees);

    // for(Employee employee : team) {
    //   employee.setAssignedProject(project);

    //   employeeRepo.save(employee);
    // }

    // after saving a new entity/Project instance to db
    // user will be redirected to "/form" to prevent duplicate submissions
    return "redirect:/projects/form";
  }
}
