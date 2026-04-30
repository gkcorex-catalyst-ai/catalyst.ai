package com.gkcorex.catalyst.ai.repositories;

import com.gkcorex.catalyst.ai.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
