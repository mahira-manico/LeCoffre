package com.lecoffre.project.repository;

import com.lecoffre.project.model.Share;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<Share, Long> {
}
