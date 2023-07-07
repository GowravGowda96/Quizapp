package com.telusko.quizapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "names")
public class Names {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
}
