package com.pradeep.QuizService.Fiegn;

import com.pradeep.QuizService.Entity.QuestionWrapper;
import com.pradeep.QuizService.Entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("api/Question/generate")
    public ResponseEntity<List<Integer>> generateQuestion(@RequestParam String category);

    @PostMapping("api/Question/getQuestion")
    public ResponseEntity<List<QuestionWrapper>>getQuestionById(@RequestBody List<Integer>qno);

    @PostMapping("api/Question/getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response> responses);
}
