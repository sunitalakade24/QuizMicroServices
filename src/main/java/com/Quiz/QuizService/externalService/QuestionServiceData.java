package com.Quiz.QuizService.externalService;

import com.Quiz.QuizService.entitie.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8082",value = "question-client")
public interface QuestionServiceData {
    @GetMapping("/question/quiz/{id}")
    public List<Question> getQuestion(@PathVariable Long id);
}
