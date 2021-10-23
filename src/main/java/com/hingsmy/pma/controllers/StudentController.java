package com.hingsmy.pma.controllers;

import com.hingsmy.pma.dao.StudentRepository;
import com.hingsmy.pma.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/new")
    public String displayStudentForm(Model model) {

        Student aStudent = new Student();
        model.addAttribute("student", aStudent);
        return "new-student";
    }

    @PostMapping("/save")
    public String createStudent(Model model, Student student) {

        // 使用student crudRepository保存到数据库
        studentRepository.save(student);

        return "redirect:/students/new";
    }
}
