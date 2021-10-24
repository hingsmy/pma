package com.hingsmy.pma.controllers;

import com.hingsmy.pma.dao.ProjectRepository;
import com.hingsmy.pma.dao.StudentRepository;
import com.hingsmy.pma.entities.Project;
import com.hingsmy.pma.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String displayHome(Model model) {

        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);

        return "main/home";
    }


}
