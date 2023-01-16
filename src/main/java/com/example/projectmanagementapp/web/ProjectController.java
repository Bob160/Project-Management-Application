package com.example.projectmanagementapp.web;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.repositories.ProjectRepository;
import com.example.projectmanagementapp.services.MapValidationErrorService;
import com.example.projectmanagementapp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) {
            return errorMap;

        } else {
            Project project1 = projectService.saveOrUpdateProject(project);
            return new ResponseEntity<Project>(project, HttpStatus.CREATED);
        }

    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
        Project project = projectService.findProjectByIdentifier(projectId);

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project> getAllProjects() {
        return projectService.findAll();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?>deleteProject(@PathVariable String projectId) {
        projectService.deleteProjectByIdentifier(projectId);

        return new ResponseEntity<String>("Project with ID: '"+projectId+"' was deleted",HttpStatus.OK);
    }

//    @PutMapping("/update/{projectId}")
//    public ResponseEntity<?> updateProject(@PathVariable String projectId) {
//        Project project = projectService.updateProjectByIdentifier(projectId);
//
//        return new ResponseEntity<Project>(project, HttpStatus.OK);
//    }
}
