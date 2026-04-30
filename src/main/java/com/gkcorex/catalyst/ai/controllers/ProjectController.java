package com.gkcorex.catalyst.ai.controllers;

import com.gkcorex.catalyst.ai.dtos.project.ProjectRequest;
import com.gkcorex.catalyst.ai.dtos.project.ProjectResponse;
import com.gkcorex.catalyst.ai.dtos.project.ProjectSummaryResponse;
import com.gkcorex.catalyst.ai.services.ProjectService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectController {

  ProjectService projectService;

  @GetMapping("/{projectId}")
  public ResponseEntity<ProjectResponse> getProject(@PathVariable Long projectId) {
    Long userId = 1L;
    return ResponseEntity.ok(projectService.getUserProject(userId, projectId));
  }

  @GetMapping
  public ResponseEntity<List<ProjectSummaryResponse>> getAllProjects() {
    Long userId = 1L;
    return ResponseEntity.ok(projectService.getUserProjects(userId));
  }

  @PostMapping
  public ResponseEntity<ProjectResponse> createProject(
      @RequestBody @Valid ProjectRequest projectRequest) {
    Long userId = 1L;
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(projectService.createProject(userId, projectRequest));
  }

  @PatchMapping("/{projectId}")
  public ResponseEntity<ProjectResponse> updateProject(
      @PathVariable Long projectId, @RequestBody @Valid ProjectRequest projectRequest) {
    Long userId = 1L;
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(projectService.updateProject(userId, projectId, projectRequest));
  }

  @DeleteMapping("/{projectId}")
  public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
    Long userId = 1L;
    projectService.softDelete(userId, projectId);
    return ResponseEntity.noContent().build();
  }
}
