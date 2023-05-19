package com.example.projectmanagementapp.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProjectResponseDto {
    private CreateProjectResponse projectResponse;
}
