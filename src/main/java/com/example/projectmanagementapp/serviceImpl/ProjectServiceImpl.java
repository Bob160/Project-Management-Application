package com.example.projectmanagementapp.serviceImpl;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.dto.requests.CreateProjectRequest;
import com.example.projectmanagementapp.dto.requests.UpdateProjectRequest;
import com.example.projectmanagementapp.dto.responses.CreateProjectResponse;
import com.example.projectmanagementapp.dto.responses.ProjectResponseDto;
import com.example.projectmanagementapp.dto.responses.UpdateProjectResponse;
import com.example.projectmanagementapp.repositories.ProjectRepository;
import com.example.projectmanagementapp.services.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

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
    public UpdateProjectResponse updateProject(Long id, UpdateProjectRequest updateProjectRequest) {
        Project project = projectRepository.findById(id).orElse(null);

        if (project != null) {
            Project.builder()
                    .updated_At(LocalDateTime.now())
                    .end_date(updateProjectRequest.getEnd_date())
                    .projectName(updateProjectRequest.getProjectName())
                    .description(updateProjectRequest.getDescription())
                    .start_date(updateProjectRequest.getStart_date())
                    .created_At(updateProjectRequest.getCreated_At())
                    .build();
            projectRepository.save(project);

            UpdateProjectResponse updateProjectResponse = UpdateProjectResponse.builder()
                    .updated_At(LocalDateTime.now())
                    .end_date(updateProjectRequest.getEnd_date())
                    .projectName(updateProjectRequest.getProjectName())
                    .description(updateProjectRequest.getDescription())
                    .created_At(updateProjectRequest.getCreated_At())
                    .build();
            return updateProjectResponse;
        }
        return null;
    }

    @Override
    public ProjectResponseDto findProjectByIdentifier(String projectIdentifier) {
        Project newProject = projectRepository.findByProjectIdentifier(projectIdentifier);
        if (newProject != null) {
            ProjectResponseDto foundProject = ProjectResponseDto.builder()
                    .projectResponse(CreateProjectResponse.builder()
                            .start_date(newProject.getStart_date())
                            .projectIdentifier(newProject.getProjectIdentifier())
                            .projectName(newProject.getProjectName())
                            .description(newProject.getDescription())
                            .created_At(newProject.getCreated_At())
                            .build())
                    .build();
            return foundProject;
        }
        return null;
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProjectByIdentifier(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
        projectRepository.delete(project);
    }
}
