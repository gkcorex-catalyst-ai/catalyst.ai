package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.project.ProjectRequest;
import com.gkcorex.catalyst.ai.dtos.project.ProjectResponse;
import com.gkcorex.catalyst.ai.dtos.project.ProjectSummaryResponse;
import com.gkcorex.catalyst.ai.entities.Project;
import com.gkcorex.catalyst.ai.entities.User;
import com.gkcorex.catalyst.ai.mappers.ProjectMapper;
import com.gkcorex.catalyst.ai.repositories.ProjectRepository;
import com.gkcorex.catalyst.ai.repositories.UserRepository;
import com.gkcorex.catalyst.ai.services.ProjectService;
import jakarta.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

  ProjectRepository projectRepository;

  UserRepository userRepository;

  ProjectMapper projectMapper;

  @Override
  public List<ProjectSummaryResponse> getUserProjects(Long userId) {
    List<Project> projects = projectRepository.findAllAccessibleByUser(userId);
    return projectMapper.mapEntitiesToSummaryResponses(projects);
  }

  @Override
  public ProjectResponse getUserProject(Long userId, Long projectId) {
    Project project = getAccessibleProjectById(userId, projectId);
    return projectMapper.mapEntityToResponse(project);
  }

  @Override
  public ProjectResponse createProject(Long userId, ProjectRequest projectRequest) {
    User user = userRepository.findById(userId).orElseThrow();
    Project project =
        Project.builder().name(projectRequest.name()).owner(user).isPublic(true).build();

    project = projectRepository.save(project);
    return projectMapper.mapEntityToResponse(project);
  }

  @Override
  public ProjectResponse updateProject(Long userId, Long projectId, ProjectRequest projectRequest) {
    Project project = getAccessibleProjectById(userId, projectId);
    project.setName(projectRequest.name());
    project = projectRepository.save(project);
    return projectMapper.mapEntityToResponse(project);
  }

  @Override
  public void softDelete(Long userId, Long projectId) {
    Project project = getAccessibleProjectById(userId, projectId);
    if (!project.getOwner().getId().equals(userId))
      throw new ResponseStatusException(
          HttpStatus.FORBIDDEN, "User not allowed to delete project with Id: " + projectId);
    project.setDeletedAt(Instant.now());
    projectRepository.save(project);
  }

  //    INTERNAL FUNCTIONS

  private Project getAccessibleProjectById(Long userId, Long projectId) {
    return projectRepository.findAccessibleProjectById(userId, projectId).orElseThrow();
  }
}
