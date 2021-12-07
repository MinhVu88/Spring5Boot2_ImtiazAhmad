package spring5.sec_2_14.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import spring5.sec_2_14.pma.entities.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
  @Override
  public List<Employee> findAll();
}
