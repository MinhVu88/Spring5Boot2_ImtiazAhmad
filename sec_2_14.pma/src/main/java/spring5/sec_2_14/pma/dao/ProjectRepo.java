package spring5.sec_2_14.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import spring5.sec_2_14.pma.entities.Project;

public interface ProjectRepo extends CrudRepository<Project, Long> {
  @Override
  public List<Project> findAll();
}
