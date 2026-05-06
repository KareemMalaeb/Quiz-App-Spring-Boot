package com.example.Quiz1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Quiz1.dao.QuesRepository;
import com.example.Quiz1.model.Ques;
@Service
public class QuesService {
    @Autowired
    private QuesRepository questionRepository;
    public ResponseEntity<List<Ques>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<List<Ques>> getQuestionByCategory(String category) {
        try{
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addQuestion(Ques question) {
        questionRepository.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
    public ResponseEntity<String> deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    
}
