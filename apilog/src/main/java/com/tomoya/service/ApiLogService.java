package com.tomoya.service;

public interface ApiLogService {
    void saveLog(String type, String request, String response, String error);
}
