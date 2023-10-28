package com.pradeep.QuizService.Controller;

import com.pradeep.QuizService.Entity.QuestionWrapper;
import com.pradeep.QuizService.Entity.QuizDto;
import com.pradeep.QuizService.Entity.Response;
import com.pradeep.QuizService.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("create")
    public ResponseEntity<String>getQuestions(@RequestParam String category,@RequestParam String title){
        return quizService.getQuestion(category,title);
    }

    @GetMapping("getQuestion/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuestionById(@PathVariable Integer id){
        return quizService.getQuestionById(id);
    }

    @PostMapping("getScore/{id}")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response> response,@PathVariable Integer id){
        return quizService.getScore(response,id);
    }
}

