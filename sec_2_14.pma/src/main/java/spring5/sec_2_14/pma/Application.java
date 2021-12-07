package spring5.sec_2_14.pma;

// import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

import spring5.sec_2_14.pma.dao.EmployeeRepo;
import spring5.sec_2_14.pma.dao.ProjectRepo;
// import spring5.sec_2_14.pma.entities.Employee;
// import spring5.sec_2_14.pma.entities.Project;

@SpringBootApplication
public class Application {
	@Autowired
	ProjectRepo projectRepo;

	@Autowired
	EmployeeRepo employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// seed the db using java
	// @Bean
	// CommandLineRunner clr() {
	// 	return args -> {
	// 		Employee e1 = new Employee("Maynard", "Keenan", "keenan@tool.com");
	// 		Employee e2 = new Employee("Adam", "Jones", "jones@tool.com");
	// 		Employee e3 = new Employee("Dan", "Carey", "carey@tool.com");
	// 		Employee e4 = new Employee("Paul", "D'Amour", "damour@tool.com");
	// 		Employee e5 = new Employee("Justin", "Chancellor", "chancellor@tool.com");

	// 		Project p1 = new Project("CAD", "not started", "project #1");
	// 		Project p2 = new Project("Tool", "in progress", "project #2");
	// 		Project p3 = new Project("APC", "in progress", "project #3");
	// 		Project p4 = new Project("puscifer", "completed", "project #4");

	// 		// set up many-to-many relationship between project table & employee table in db
	// 		p1.addEmployeeToProject(e1);
	// 		p1.addEmployeeToProject(e2);
	// 		p2.addEmployeeToProject(e2);
	// 		p2.addEmployeeToProject(e3);
	// 		p3.addEmployeeToProject(e3);
	// 		p3.addEmployeeToProject(e4);
	// 		p4.addEmployeeToProject(e4);
	// 		p4.addEmployeeToProject(e5);

	// 		e1.setAssignedProjects(Arrays.asList(p1));
	// 		e2.setAssignedProjects(Arrays.asList(p1, p2));
	// 		e3.setAssignedProjects(Arrays.asList(p2, p3));
	// 		e4.setAssignedProjects(Arrays.asList(p3, p4));
	// 		e5.setAssignedProjects(Arrays.asList(p4));

	// 		employeeRepo.save(e1);
	// 		employeeRepo.save(e2);
	// 		employeeRepo.save(e3);
	// 		employeeRepo.save(e4);
	// 		employeeRepo.save(e5);

	// 		projectRepo.save(p1);
	// 		projectRepo.save(p2);
	// 		projectRepo.save(p3);
	// 		projectRepo.save(p4);
	// 	};
	// }
}
