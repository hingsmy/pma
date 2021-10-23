package com.hingsmy.pma.dao;

import com.hingsmy.pma.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Override
    List<Student> findAll();
}
