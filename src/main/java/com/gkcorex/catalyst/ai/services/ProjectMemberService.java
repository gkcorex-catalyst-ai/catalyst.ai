package com.gkcorex.catalyst.ai.services;

import com.gkcorex.catalyst.ai.dtos.member.InviteMemberRequest;
import com.gkcorex.catalyst.ai.dtos.member.MemberResponse;
import com.gkcorex.catalyst.ai.dtos.member.UpdateMemberRoleRequest;
import java.util.List;

public interface ProjectMemberService {

  List<MemberResponse> getProjectMembers(Long projectId);

  MemberResponse inviteMember(Long projectId, InviteMemberRequest inviteMemberRequest);

  MemberResponse updateMemberRole(
      Long projectId, Long memberId, UpdateMemberRoleRequest updateMemberRoleRequest);

  void deleteMember(Long projectId, Long memberId);
}
