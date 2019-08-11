package com.tomoya.dao;

import com.tomoya.domain.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiLogDao extends JpaRepository<ApiLog, Long> {
}
