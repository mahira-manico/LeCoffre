package com.lecoffre.project.repository;

import com.lecoffre.project.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
