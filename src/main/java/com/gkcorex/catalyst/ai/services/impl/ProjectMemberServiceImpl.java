package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.member.InviteMemberRequest;
import com.gkcorex.catalyst.ai.dtos.member.MemberResponse;
import com.gkcorex.catalyst.ai.dtos.member.UpdateMemberRoleRequest;
import com.gkcorex.catalyst.ai.entities.Project;
import com.gkcorex.catalyst.ai.entities.ProjectMember;
import com.gkcorex.catalyst.ai.entities.ProjectMemberId;
import com.gkcorex.catalyst.ai.entities.User;
import com.gkcorex.catalyst.ai.exceptions.ResourceNotFoundException;
import com.gkcorex.catalyst.ai.mappers.ProjectMemberMapper;
import com.gkcorex.catalyst.ai.repositories.ProjectMemberRepository;
import com.gkcorex.catalyst.ai.repositories.ProjectRepository;
import com.gkcorex.catalyst.ai.repositories.UserRepository;
import com.gkcorex.catalyst.ai.security.JwtAuthUtil;
import com.gkcorex.catalyst.ai.services.ProjectMemberService;
import jakarta.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
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
public class ProjectMemberServiceImpl implements ProjectMemberService {

  ProjectRepository projectRepository;

  ProjectMemberMapper projectMemberMapper;

  ProjectMemberRepository projectMemberRepository;

  UserRepository userRepository;

  JwtAuthUtil jwtAuthUtil;

  @Override
  public List<MemberResponse> getProjectMembers(Long projectId) {
    List<MemberResponse> memberResponseList = new ArrayList<>();
    return projectMemberRepository.findByIdProjectId(projectId).stream()
        .map(projectMemberMapper::mapProjectMemberToMemberResponse)
        .toList();
  }

  @Override
  public MemberResponse inviteMember(Long projectId, InviteMemberRequest inviteMemberRequest) {
    Long userId = jwtAuthUtil.getCurrentUserId();
    Project project = getAccessibleProjectById(userId, projectId);
    User invitee =
        userRepository
            .findByUsername(inviteMemberRequest.username())
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "User not found", inviteMemberRequest.username()));
    if (invitee.getId().equals(userId))
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Cannot Invite Yourself");
    ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());
    if (projectMemberRepository.existsById(projectMemberId))
      throw new ResponseStatusException(
          HttpStatus.FORBIDDEN, "Already Invited Member with Id: " + invitee.getId());
    ProjectMember member =
        ProjectMember.builder()
            .id(projectMemberId)
            .project(project)
            .user(invitee)
            .projectRole(inviteMemberRequest.role())
            .invitedAt(Instant.now())
            .build();
    member = projectMemberRepository.save(member);
    return projectMemberMapper.mapProjectMemberToMemberResponse(member);
  }

  @Override
  public MemberResponse updateMemberRole(
      Long projectId, Long memberId, UpdateMemberRoleRequest updateMemberRoleRequest) {
    ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
    ProjectMember member =
        projectMemberRepository
            .findById(projectMemberId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException("Member not found", projectMemberId.toString()));
    member.setProjectRole(updateMemberRoleRequest.role());
    member = projectMemberRepository.save(member);
    return projectMemberMapper.mapProjectMemberToMemberResponse(member);
  }

  @Override
  public void deleteMember(Long projectId, Long memberId) {
    ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
    if (!projectMemberRepository.existsById(projectMemberId))
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, "Cannot Delete Uninvited Member with Id: " + memberId);
    projectMemberRepository.deleteById(projectMemberId);
  }

  //    INTERNAL FUNCTIONS
  private Project getAccessibleProjectById(Long userId, Long projectId) {
    return projectRepository
        .findAccessibleProjectById(userId, projectId)
        .orElseThrow(
            () -> new ResourceNotFoundException("Project not found", projectId.toString()));
  }
}
