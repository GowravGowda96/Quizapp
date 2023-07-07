package com.telusko.quizapp.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "questiontable")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String difficulty_level;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String right_answer;
    private String question;
    private String category;
}
