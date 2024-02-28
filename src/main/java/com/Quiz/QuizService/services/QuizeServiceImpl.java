package com.Quiz.QuizService.services;

import com.Quiz.QuizService.entitie.Quiz;
import com.Quiz.QuizService.externalService.QuestionServiceData;
import com.Quiz.QuizService.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QuizeServiceImpl implements  QuizServicesI{
    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuestionServiceData questionServiceData;
    @Override
    public Quiz createQuiz(Quiz q) {

        return quizRepo.save(q);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> allQuiz = this.quizRepo.findAll();
       List<Quiz> newQuiz=  allQuiz.stream().map(q ->
        {
            q.setQuestionList(questionServiceData.getQuestion(q.getId()));
            return q;
        }).collect(Collectors.toList());

        return newQuiz;
    }

    @Override
    public Quiz singleQuiz(Long id) {
        Quiz quiz = quizRepo.findById(id).orElseThrow(() -> new RuntimeException("Quiz not present"));
        quiz.setQuestionList(questionServiceData.getQuestion(quiz.getId()));
        return quiz;
    }

    @Override
    public void deleteQuiz(Long id) {
    Quiz quiz= this.quizRepo.findById(id).orElseThrow(()->new RuntimeException("Quiz not present"));
    this.quizRepo.delete(quiz);
    }
}
