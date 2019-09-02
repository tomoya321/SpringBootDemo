package com.tomoya.excelmodule.dao;

import com.tomoya.excelmodule.domain.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiLogDao extends JpaRepository<ApiLog, Long> {
}

