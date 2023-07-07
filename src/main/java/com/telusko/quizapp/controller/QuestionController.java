package com.telusko.quizapp.controller;


import com.telusko.quizapp.model.Names;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.model.Response;
import com.telusko.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("allQuestion")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllQuestions();
    }


    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> fetchByCategory(@PathVariable String category) {
        return questionService.fetchByCategory(category);
    }

    @PostMapping("add/questions")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestions(question);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        return questionService.deleteByMainId(id);
    }

    @PutMapping("update/category/{id}")
    public Question updateCategory(@PathVariable Integer id, @RequestBody Question question) throws Exception {
        return questionService.updateByCategory(id, question);
    }
}
