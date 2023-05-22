package com.example.projectmanagementapp.dto.requests;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProjectRequest implements Serializable {
    private String projectName;
    private LocalDateTime updated_At;
    private String description;
    private Date end_date;
    private LocalDateTime created_At;
    private Date start_date;
}
