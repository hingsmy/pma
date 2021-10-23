package com.hingsmy.pma.dao;

import com.hingsmy.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();
}
