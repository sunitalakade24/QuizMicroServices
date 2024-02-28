package com.Quiz.QuizService.repository;

import com.Quiz.QuizService.entitie.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Long> {
}
