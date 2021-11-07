package com.hingsmy.pma.controllers;

import com.hingsmy.pma.dao.ProjectRepository;
import com.hingsmy.pma.dao.StudentRepository;
import com.hingsmy.pma.entities.Project;
import com.hingsmy.pma.entities.Student;
import com.hingsmy.pma.services.ProjectService;
import com.hingsmy.pma.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    StudentService studentService;

    @GetMapping
    public String displayProjects(Model model) {

        List<Project> projects = projectService.getAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();
        List<Student> students = studentService.getAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allStudents", students);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model, @RequestParam List<Long> students, Project project) {

        // 处理保存到数据库的行为
        projectService.save(project);

        // 使用重定位防止重复提交
        return "redirect:/projects/new";
    }
}
