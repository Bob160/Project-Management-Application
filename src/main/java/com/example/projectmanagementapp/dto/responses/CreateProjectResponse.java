package com.example.projectmanagementapp.dto.responses;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProjectResponse {
    private String projectName;
    private String projectIdentifier;
    private String description;
    private Date start_date;
    private LocalDateTime created_At;

}
