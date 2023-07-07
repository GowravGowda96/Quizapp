package com.telusko.quizapp.dao;

import com.telusko.quizapp.model.Names;
import com.telusko.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NamesDao extends JpaRepository<Names, Integer> {
}
