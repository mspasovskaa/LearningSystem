package com.makeuplab.service.impl;

import com.makeuplab.model.Quiz;
import com.makeuplab.model.QuizScore;
import com.makeuplab.model.User;
import com.makeuplab.model.exceptions.QuizNotFoundException;
import com.makeuplab.repository.QuizRepository;
import com.makeuplab.repository.QuizScoreRepository;
import com.makeuplab.repository.UserRepository;
import com.makeuplab.service.QuizScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizScoreServiceImpl implements QuizScoreService {
    private final QuizScoreRepository quizScoreRepository;
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;

    public QuizScoreServiceImpl(QuizScoreRepository quizScoreRepository, QuizRepository quizRepository, UserRepository userRepository) {
        this.quizScoreRepository = quizScoreRepository;
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
    }

    @Override
    public QuizScore findById(Long id) {
        return this.quizScoreRepository.findById(id).orElseThrow(()->new QuizNotFoundException());
    }

    @Override
    public List<QuizScore> findAll() {
        return this.quizScoreRepository.findAll();
    }

    @Override
    public QuizScore add(User user, Quiz quiz,double score) {
        QuizScore quizScore=new QuizScore(user,quiz,score);

        return this.quizScoreRepository.save(quizScore);
    }

    @Override
    public QuizScore update(Long id, User user, Quiz quiz,double score) {
        QuizScore quizScore=this.findById(id);
        quizScore.setQuiz(quiz);
        quizScore.setUser(user);
        quizScore.setScore(score);
        return this.quizScoreRepository.save(quizScore);
    }

    @Override
    public void delete(Long id) {
        QuizScore quizScore=this.findById(id);
        this.quizScoreRepository.delete(quizScore);
    }
}
