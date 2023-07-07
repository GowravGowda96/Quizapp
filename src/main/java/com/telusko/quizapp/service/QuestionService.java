package com.telusko.quizapp.service;

import com.telusko.quizapp.dao.NamesDao;
import com.telusko.quizapp.dao.QuestionDao;
import com.telusko.quizapp.model.Names;
import com.telusko.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    NamesDao namesDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public List<Names> getNames() {
       return namesDao.findAll();
    }

    public ResponseEntity<List<Question>> fetchByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestions(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("data has been created", HttpStatus.CREATED);
        } catch (Exception e) {
        e.printStackTrace();
        }
        return new ResponseEntity<>("FAILED ", HttpStatus.BAD_REQUEST);
    }

    public String deleteByMainId(Integer id) {
        questionDao.deleteById(id);
        return "successfully deleted";
    }

    public Question updateByCategory(Integer id, Question question) throws Exception {
       Question questionOptional = questionDao.findById(id).orElseThrow(()-> new Exception("id not found"));
         questionOptional.setCategory(question.getCategory());
         return questionDao.save(questionOptional);

    }
}
