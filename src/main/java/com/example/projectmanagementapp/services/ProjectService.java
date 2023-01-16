package com.example.projectmanagementapp.services;

import com.example.projectmanagementapp.domain.Project;
import com.example.projectmanagementapp.exceptions.ProjectIdException;
import com.example.projectmanagementapp.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }

    }

    public Project findProjectByIdentifier(String projectId) {
       Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

       if (project == null) {
           throw new ProjectIdException("Project ID '"+projectId+"'does not exist");
       }
       return project;
    }

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

//    public List<Project> findAll() {
//        return projectRepository.findAll();
//    }

    public void deleteProjectByIdentifier(String projectId) throws ProjectIdException{
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null) {
            throw new ProjectIdException("Project with id '"+projectId+"' does not exist.");
        }
        projectRepository.delete(project);
    }

//    public Project updateProjectByIdentifier(String projectId) throws ProjectIdException{
//        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
//        if (project != null) {
//            project.setId(project.getId());
//            project.setProjectName(project.getProjectName());
//            project.setDescription(project.getDescription());
//            project.setUpdated_At(new Date());
//
//            return projectRepository.save(project);
//        }
//
//        throw new ProjectIdException("Project with id '"+projectId+"' does not exist.");
//    }
}
