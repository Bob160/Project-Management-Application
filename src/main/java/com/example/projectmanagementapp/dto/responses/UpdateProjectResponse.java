package com.example.projectmanagementapp.dto.responses;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProjectResponse {
    private String projectName;
    private String description;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;
    private Date start_date;
    private Date end_date;
}
