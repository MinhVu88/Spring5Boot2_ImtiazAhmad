package spring5.sec_2_14.pma.entities;

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
// import javax.persistence.ManyToOne;

@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = /*GenerationType.AUTO*/ GenerationType.IDENTITY)
  private long id;

  private String firstName;
  private String lastName;
  private String email;

  // @ManyToOne(
  //   cascade = {
  //     CascadeType.DETACH,
  //     CascadeType.MERGE,
  //     CascadeType.PERSIST,
  //     CascadeType.REFRESH
  //   },
  //   fetch = FetchType.LAZY
  // )
  // @JoinColumn(name = "project_id")
  // private Project assignedProject;

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
    joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "project_id")
  )
  private List<Project> assignedProjects;

  public Employee() {}

  public Employee(
    String firstName, 
    String lastName, 
    String email
  ) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // public Project getAssignedProject() {
  //   return this.assignedProject;
  // }

  // public void setAssignedProject(Project assignedProject) {
  //   this.assignedProject = assignedProject;
  // }

  public List<Project> getAssignedProjects() {
    return this.assignedProjects;
  }

  public void setAssignedProjects(List<Project> assignedProjects) {
    this.assignedProjects = assignedProjects;
  }
}
