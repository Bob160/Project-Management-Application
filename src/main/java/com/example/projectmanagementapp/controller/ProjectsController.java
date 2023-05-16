package com.example.projectmanagementapp.controller;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.dto.requests.CreateProjectRequest;
import com.example.projectmanagementapp.dto.responses.CreateProjectResponse;
import com.example.projectmanagementapp.services.ProjectService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    private final ProjectService projectService;

    @PostMapping("/check")
    public String checkIt() {
        return "I am alright";
    }

    @PostMapping("/create")
    public ResponseEntity<CreateProjectResponse> createProject(@RequestBody CreateProjectRequest createProjectRequest) {
        CreateProjectResponse newResponse = projectService.createProject(createProjectRequest);
        return new ResponseEntity<>(newResponse, HttpStatus.CREATED);
    }
    @PostMapping("/save")
    @ApiOperation("Save and Update Project")
    public ResponseEntity<?> saveOrUpdateProject(@RequestBody Project project) {
        String newProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    @ApiOperation("Find a project by its Id")
    public ResponseEntity<?> findById(@PathVariable String projectId) {
        projectService.findProjectByIdentifier(projectId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
