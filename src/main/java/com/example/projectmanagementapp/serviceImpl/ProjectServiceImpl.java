package com.example.projectmanagementapp.serviceImpl;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.repositories.ProjectRepository;
import com.example.projectmanagementapp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public Project saveOrUpdateProject(Project project){
        project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
        return projectRepository.save(project);
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
