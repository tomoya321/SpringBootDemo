package com.tomoya.apilog.service;

import org.springframework.stereotype.Service;

@Service
public interface ApiLogService {
    void saveLog(String type, String request, String response, String error);
    void testEx();

    String changBindPhone(String oldPhone, String newPhone, String code, String bizUserId);

}
