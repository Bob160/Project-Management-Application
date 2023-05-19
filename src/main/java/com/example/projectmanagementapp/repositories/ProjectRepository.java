package com.example.projectmanagementapp.repositories;

import com.example.projectmanagementapp.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    Optional<Project> findById (Long id);
    Project findByProjectIdentifier(String projectIdentifier);
    @Override
    Iterable<Project> findAll();
}
