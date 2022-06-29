package com.makeuplab.service;

import com.makeuplab.model.Quiz;
import com.makeuplab.model.QuizScore;
import com.makeuplab.model.User;

import java.util.List;

public interface QuizScoreService {
    QuizScore findById(Long id);
    List<QuizScore> findAll();
    QuizScore add(User user, Quiz quiz,double score);
    QuizScore update(Long id,User user,Quiz quiz,double score);
    void delete(Long id);
}
