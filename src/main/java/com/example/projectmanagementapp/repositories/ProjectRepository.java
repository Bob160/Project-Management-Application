package com.example.projectmanagementapp.repositories;

import com.example.projectmanagementapp.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
//    @Override
    //List<Project> findAll();

    Project findByProjectIdentifier(String projectId);

//    Project findById(Long id);

    @Override
    Iterable<Project> findAll();
}
