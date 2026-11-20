package com.lecoffre.project.repository;

import com.lecoffre.project.model.Secret;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretRepository extends JpaRepository<Secret, Long> {
}
