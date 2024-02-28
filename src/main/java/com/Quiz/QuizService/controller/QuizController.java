package com.Quiz.QuizService.controller;

import com.Quiz.QuizService.entitie.Quiz;
import com.Quiz.QuizService.services.QuizServicesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizServicesI quizServicesI;
    @PostMapping("")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz q) {
        Quiz quiz = this.quizServicesI.createQuiz(q);
        return new ResponseEntity<Quiz>(quiz, HttpStatus.CREATED);
    }
   @GetMapping("")
    public ResponseEntity<List<Quiz>> getAllQuiz()
   {
       List<Quiz> allQuiz = this.quizServicesI.getAllQuiz();
       return new ResponseEntity<List<Quiz>>(allQuiz,HttpStatus.OK);


   }
   @GetMapping("/{id}")
   public ResponseEntity<Quiz> getSingleQuizId(@PathVariable Long id)
   {
       Quiz quiz = this.quizServicesI.singleQuiz(id);
       return new ResponseEntity<Quiz>(quiz,HttpStatus.OK);


   }
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteQuiz(@PathVariable Long id)
   {
       this.quizServicesI.deleteQuiz(id);
       return new ResponseEntity<>("Delete Quiz Successfully::",HttpStatus.OK);
   }

}
