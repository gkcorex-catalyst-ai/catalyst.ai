package com.gkcorex.catalyst.ai.services;

import com.gkcorex.catalyst.ai.dtos.project.ProjectRequest;
import com.gkcorex.catalyst.ai.dtos.project.ProjectResponse;
import com.gkcorex.catalyst.ai.dtos.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProject(Long userId, Long projectId);

    ProjectResponse createProject(Long userId, ProjectRequest projectRequest);

    ProjectResponse updateProject(Long userId, Long projectId, ProjectRequest projectRequest);

    void deleteProject(Long userId, Long projectId);
}
