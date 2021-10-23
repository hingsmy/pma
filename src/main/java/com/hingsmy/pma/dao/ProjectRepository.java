package com.hingsmy.pma.dao;

import com.hingsmy.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
