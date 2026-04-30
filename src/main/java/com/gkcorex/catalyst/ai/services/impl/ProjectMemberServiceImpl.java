package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.member.InviteMemberRequest;
import com.gkcorex.catalyst.ai.dtos.member.MemberResponse;
import com.gkcorex.catalyst.ai.dtos.member.UpdateMemberRoleRequest;
import com.gkcorex.catalyst.ai.services.ProjectMemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {
  @Override
  public List<MemberResponse> getProjectMembers(Long userId, Long projectId) {
    return List.of();
  }

  @Override
  public MemberResponse inviteMember(
      Long userId, Long projectId, InviteMemberRequest inviteMemberRequest) {
    return null;
  }

  @Override
  public MemberResponse updateMemberRole(
      Long userId, Long projectId, Long memberId, UpdateMemberRoleRequest updateMemberRoleRequest) {
    return null;
  }

  @Override
  public void deleteMember(Long userId, Long projectId, Long memberId) {}
}
