package com.example.projectmanagementapp.services;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.dto.requests.CreateProjectRequest;
import com.example.projectmanagementapp.dto.responses.CreateProjectResponse;


public interface ProjectService {

    public CreateProjectResponse createProject(CreateProjectRequest createProjectRequest);

    public String saveOrUpdateProject(Project project);

    public Project findProjectByIdentifier(String projectId);

    public Iterable<Project> findAll();

    public void deleteProjectByIdentifier(String projectId);

}