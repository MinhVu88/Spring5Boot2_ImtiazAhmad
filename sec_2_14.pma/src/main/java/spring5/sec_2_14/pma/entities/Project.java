package spring5.sec_2_14.pma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
// import javax.persistence.OneToMany;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = /*GenerationType.AUTO*/ GenerationType.IDENTITY)
  private long id;

  private String name;
  private String status;
  private String description;

  //@OneToMany(mappedBy = "assignedProject")
  @ManyToMany(
    cascade = {
      CascadeType.DETACH,
      CascadeType.MERGE,
      CascadeType.PERSIST,
      CascadeType.REFRESH
    },
    fetch = FetchType.LAZY
  )
  @JoinTable(
    name = "project_employee",
    joinColumns = @JoinColumn(name = "project_id"),
    inverseJoinColumns = @JoinColumn(name = "employee_id")
  )
  private List<Employee> employees;

  public Project() {}

  public Project(
    String name, 
    String status, 
    String description
  ) {
    super();
    this.name = name;
    this.status = status;
    this.description = description;
  }
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Employee> getEmployees() {
    return this.employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public void addEmployeeToProject(Employee emp) {
    if(employees == null) {
      employees = new ArrayList<>();
    }

    employees.add(emp);
  }
}
