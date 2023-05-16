package com.example.projectmanagementapp.dto.requests;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProjectRequest {
    private String projectName;
    private String projectIdentifier;
    private String description;
    private Date start_date;
}
