package com.example.projectmanagementapp.serviceImpl;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.dto.requests.CreateProjectRequest;
import com.example.projectmanagementapp.dto.responses.CreateProjectResponse;
import com.example.projectmanagementapp.repositories.ProjectRepository;
import com.example.projectmanagementapp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public CreateProjectResponse createProject(CreateProjectRequest createProjectRequest) {
        Project project = Project.builder()
                .projectIdentifier(createProjectRequest.getProjectIdentifier())
                .projectName(createProjectRequest.getProjectName())
                .description(createProjectRequest.getDescription())
                .start_date(createProjectRequest.getStart_date())
                .created_At(LocalDateTime.now())
                .build();
        projectRepository.save(project);
        CreateProjectResponse newProject = CreateProjectResponse.builder()
                .projectIdentifier(createProjectRequest.getProjectIdentifier())
                .projectName(createProjectRequest.getProjectName())
                .description(createProjectRequest.getDescription())
                .start_date(createProjectRequest.getStart_date())
                .created_At(LocalDateTime.now())
                .build();
        return newProject;
    }

    @Override
    public String saveOrUpdateProject(Project project){
        project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
        projectRepository.save(project);
        return "Project saved/ updated successfully";
    }

    @Override
    public Project findProjectByIdentifier(String projectId) {
        Project newProject = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        return newProject;
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        projectRepository.delete(project);
    }
}
