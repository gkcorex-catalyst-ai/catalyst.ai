package com.gkcorex.catalyst.ai.repositories;

import com.gkcorex.catalyst.ai.entities.Project;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

  @Query(
      """
            SELECT p from Project p
            WHERE p.deletedAt IS NULL
            AND p.owner.id = :userId
            ORDER BY p.updatedAt DESC
            """)
  List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

  @Query(
      """
            SELECT p from Project p
            LEFT JOIN FETCH p.owner
            WHERE p.deletedAt IS NULL
            AND p.id = :projectId
            AND p.owner.id = :userId
            """)
  Optional<Project> findAccessibleProjectById(
      @Param("userId") Long userId, @Param("projectId") Long projectId);
}
