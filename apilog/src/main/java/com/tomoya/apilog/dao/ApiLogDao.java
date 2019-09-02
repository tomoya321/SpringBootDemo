package com.tomoya.apilog.dao;

import com.tomoya.apilog.domain.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiLogDao extends JpaRepository<ApiLog, Long> {
}
