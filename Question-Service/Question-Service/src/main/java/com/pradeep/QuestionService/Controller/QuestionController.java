package com.pradeep.QuestionService.Controller;

import com.pradeep.QuestionService.Entity.Question;
import com.pradeep.QuestionService.Entity.QuestionWrapper;
import com.pradeep.QuestionService.Entity.Response;
import com.pradeep.QuestionService.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Question")
public class QuestionController {

    Question question;

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    @PostMapping("add")
    public ResponseEntity<Question>save(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }

    @GetMapping("allQuestion")
    public ResponseEntity<List<Question>>getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("{category}")
    public ResponseEntity<List<Question>>getCQuestion(@PathVariable String category){
        return questionService.getCatagoryQuestion(category);
    }

    @GetMapping("random/{category}")
    public ResponseEntity<List<QuestionWrapper>>getRandomQuestion(@PathVariable String category){
        return questionService.getRandomQuestion(category);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>>generateQuestion(@RequestParam String category){
        return questionService.generateQuestion(category);
    }

    @PostMapping("getQuestion")
    public ResponseEntity<List<QuestionWrapper>>getQuestionById(@RequestBody List<Integer>qno){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionById(qno);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}
