package com.example.projectmanagementapp.controller;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.dto.requests.CreateProjectRequest;
import com.example.projectmanagementapp.dto.requests.UpdateProjectRequest;
import com.example.projectmanagementapp.dto.responses.CreateProjectResponse;
import com.example.projectmanagementapp.dto.responses.ProjectResponseDto;
import com.example.projectmanagementapp.dto.responses.UpdateProjectResponse;
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
    @PutMapping ("/save/{id}")
    @ApiOperation("Save and Update Project")
    public ResponseEntity<UpdateProjectResponse> updateProject(@PathVariable Long id, @RequestBody UpdateProjectRequest updateProjectRequest) {
        UpdateProjectResponse updatedProjectResponse = projectService.updateProject(id, updateProjectRequest);
        return new ResponseEntity<>(updatedProjectResponse, HttpStatus.OK);
    }

    @GetMapping("/{projectIdentifier}")
    @ApiOperation("Find a project by its Id")
    public ResponseEntity<ProjectResponseDto> findByIdentifier(@PathVariable String projectIdentifier) {
        ProjectResponseDto responseDto = projectService.findProjectByIdentifier(projectIdentifier);
        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{projectIdentifier}")
    public ResponseEntity<String> deleteProject (@PathVariable String projectIdentifier) {
        projectService.deleteProjectByIdentifier(projectIdentifier);
        return new ResponseEntity<>("Project deleted successfully!", HttpStatus.OK);
    }
}
