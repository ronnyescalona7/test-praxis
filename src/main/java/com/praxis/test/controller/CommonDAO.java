package com.praxis.test.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CommonDAO<T> {

    List<T> getAll();

    ResponseEntity<T> getById(Long id) throws Exception;

    Map<String, Boolean> delete(Long studentId) throws Exception;
}
