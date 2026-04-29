package com.gkcorex.catalyst.ai.controllers;

import com.gkcorex.catalyst.ai.dtos.project.ProjectRequest;
import com.gkcorex.catalyst.ai.dtos.project.ProjectResponse;
import com.gkcorex.catalyst.ai.dtos.project.ProjectSummaryResponse;
import com.gkcorex.catalyst.ai.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/(projectId}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getUserProject(userId, projectId));
    }

    @GetMapping
    public ResponseEntity<List<ProjectSummaryResponse>> getAllProjects(){
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest){
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(userId, projectRequest));
    }

    @PatchMapping("/(projectId}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long projectId, @RequestBody ProjectRequest projectRequest){
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.updateProject(userId, projectId, projectRequest));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId){
        Long userId = 1L;
        projectService.deleteProject(userId, projectId);
        return ResponseEntity.noContent().build();
    }
 }
