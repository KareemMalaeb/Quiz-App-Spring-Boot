package com.example.Quiz1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Quiz1.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

    
} 