package com.Quiz.QuizService.services;

import com.Quiz.QuizService.entitie.Quiz;

import java.util.List;

public interface QuizServicesI {

    Quiz createQuiz(Quiz q);
    List<Quiz> getAllQuiz();
     Quiz singleQuiz(Long id);
     void deleteQuiz(Long id);

}
