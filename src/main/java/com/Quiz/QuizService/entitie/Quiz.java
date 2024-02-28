package com.Quiz.QuizService.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Transient
   private List<Question> question;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestionList() {
        return question;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestionList(List<Question> questionList) {
        this.question = questionList;
    }
}
