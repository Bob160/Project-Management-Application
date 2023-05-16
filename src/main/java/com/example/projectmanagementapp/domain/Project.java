package com.example.projectmanagementapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Please enter a project name")
    private String projectName;
    @NotBlank(message = "Please enter a project identifier")
    @Size(min = 4, max = 6, message = "Project Identifier must be 4 - 20 characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message = "Please enter a project description")
    private String description;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date start_date;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date end_date;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDateTime created_At;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDateTime updated_At;

    public Project() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getProjectName() {
//        return projectName;
//    }
//
//    public void setProjectName(String projectName) {
//        this.projectName = projectName;
//    }
//
//    public String getProjectIdentifier() {
//        return projectIdentifier;
//    }
//
//    public void setProjectIdentifier(String projectIdentifier) {
//        this.projectIdentifier = projectIdentifier;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Date getStart_date() {
//        return start_date;
//    }
//
//    public void setStart_date(Date start_date) {
//        this.start_date = start_date;
//    }
//
//    public Date getEnd_date() {
//        return end_date;
//    }
//
//    public void setEnd_date(Date end_date) {
//        this.end_date = end_date;
//    }
//
//    public Date getCreated_At() {
//        return created_At;
//    }
//
//    public void setCreated_At(Date created_At) {
//        this.created_At = created_At;
//    }
//
//    public Date getUpdated_At() {
//        return updated_At;
//    }
//
//    public void setUpdated_At(Date updated_At) {
//        this.updated_At = updated_At;
//    }
//
//    @PrePersist
//    protected void onCreate() {
//        this.created_At = new Date();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updated_At = new Date();
//    }

}
