package com.gkcorex.catalyst.ai.repositories;

import com.gkcorex.catalyst.ai.entities.ProjectMember;
import com.gkcorex.catalyst.ai.entities.ProjectMemberId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {
  List<ProjectMember> findByIdProjectId(Long projectId);
}
