package com.example.projectmanagementapp.controller;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/save")
    public ResponseEntity<?> saveOrUpdateProject(@RequestBody Project project) {
        Project newProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
