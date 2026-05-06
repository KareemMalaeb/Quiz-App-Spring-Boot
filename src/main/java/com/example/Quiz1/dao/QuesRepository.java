package com.example.Quiz1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Quiz1.model.Ques;
@Repository
public interface QuesRepository extends JpaRepository<Ques, Integer> {

    List<Ques> findByCategory(String category);

    @Query(value = "SELECT * FROM ques WHERE category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Ques> findRandomQuestionsByCategory(String category, int numQ);
    
    
}
