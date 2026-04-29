package com.gkcorex.catalyst.ai.controllers;

import com.gkcorex.catalyst.ai.dtos.member.InviteMemberRequest;
import com.gkcorex.catalyst.ai.dtos.member.MemberResponse;
import com.gkcorex.catalyst.ai.dtos.member.UpdateMemberRoleRequest;
import com.gkcorex.catalyst.ai.entities.ProjectMember;
import com.gkcorex.catalyst.ai.services.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<ProjectMember>> getMembers(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(userId, projectId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(
            @PathVariable Long projectId,
            @RequestBody InviteMemberRequest inviteMemberRequest
    ){
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectMemberService.inviteMember(userId, projectId, inviteMemberRequest));
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(
            @PathVariable Long projectId,
            @PathVariable Long memberId,
            @RequestBody UpdateMemberRoleRequest updateMemberRoleRequest
    ){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(userId, projectId, memberId, updateMemberRoleRequest));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteProjectMember(@PathVariable Long projectId, @PathVariable Long memberId){
        Long userId = 1L;
        projectMemberService.deleteMember(userId, projectId, memberId);
        return ResponseEntity.noContent().build();
    }
}
