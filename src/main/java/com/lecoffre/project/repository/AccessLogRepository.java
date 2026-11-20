package com.lecoffre.project.repository;

import com.lecoffre.project.model.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
}
