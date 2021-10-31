package com.hingsmy.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hingsmy.pma.dao.ProjectRepository;
import com.hingsmy.pma.dao.StudentRepository;
import com.hingsmy.pma.dto.ChartData;
import com.hingsmy.pma.dto.StudentProject;
import com.hingsmy.pma.entities.Project;
import com.hingsmy.pma.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectStatusData = projectRepository.getProjectStatus();
        // 转换projectStatusData为JSON结构，方便在JS脚本中使用
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectStatusData);
        // [{"未开始", 1}, {"进行中", 2}, {"已完成", 1}]
        model.addAttribute("projectStatusData", jsonString);

        List<StudentProject> studentProjects = studentRepository.studentProjects();
        model.addAttribute("studentProjects", studentProjects);

        return "main/home";
    }


}
