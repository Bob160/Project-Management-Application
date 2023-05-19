package com.example.projectmanagementapp.services;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.dto.requests.CreateProjectRequest;
import com.example.projectmanagementapp.dto.requests.UpdateProjectRequest;
import com.example.projectmanagementapp.dto.responses.CreateProjectResponse;
import com.example.projectmanagementapp.dto.responses.ProjectResponseDto;
import com.example.projectmanagementapp.dto.responses.UpdateProjectResponse;


public interface ProjectService {

    public CreateProjectResponse createProject(CreateProjectRequest createProjectRequest);

    public UpdateProjectResponse updateProject(Long id, UpdateProjectRequest updateProjectRequest);

    public ProjectResponseDto findProjectByIdentifier(String projectIdentifier);

    public Iterable<Project> findAll();

    public void deleteProjectByIdentifier(String projectIdentifier);

}