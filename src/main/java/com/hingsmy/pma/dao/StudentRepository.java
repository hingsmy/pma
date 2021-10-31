package com.hingsmy.pma.dao;

import com.hingsmy.pma.dto.StudentProject;
import com.hingsmy.pma.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Override
    List<Student> findAll();

    @Query(nativeQuery = true, value = "SELECT s.name, s.wechat_id as wechatId, COUNT(ps.student_id) as projectCount " +
            "FROM student s left join project_student ps ON ps.student_id = s.student_id " +
            "GROUP BY s.name, s.wechat_id ORDER BY 3 DESC;")
    List<StudentProject> studentProjects();
}
