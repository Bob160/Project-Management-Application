package com.example.projectmanagementapp.services;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.dto.requests.CreateProjectRequest;
import com.example.projectmanagementapp.dto.responses.CreateProjectResponse;


public interface ProjectService {

    public CreateProjectResponse createProject(CreateProjectRequest createProjectRequest);

    public String saveOrUpdateProject(Project project);

    public CreateProjectResponse findProjectByIdentifier(String projectIdentifier);

    public Iterable<Project> findAll();

    public void deleteProjectByIdentifier(String projectIdentifier);

}