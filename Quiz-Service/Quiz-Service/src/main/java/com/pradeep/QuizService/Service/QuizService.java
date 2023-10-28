package com.pradeep.QuizService.Service;

import com.pradeep.QuizService.Entity.QuestionWrapper;
import com.pradeep.QuizService.Entity.Quiz;
import com.pradeep.QuizService.Entity.Response;
import com.pradeep.QuizService.Fiegn.QuizInterface;
import com.pradeep.QuizService.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizInterface quizInterface;

    @Autowired
    QuizRepository quizRepository;

    public ResponseEntity<String> getQuestion(String category, String title) {
       List<Integer>questions= quizInterface.generateQuestion(category).getBody();
        Quiz quiz=new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestionIds(questions);
        quizRepository.save(quiz);
    return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(Integer id) {
        Quiz quiz=quizRepository.findById(id).get();
        List<Integer>questionId=quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>>questionWrappers=quizInterface.getQuestionById(questionId);
        return questionWrappers;
    }

    public ResponseEntity<Integer> getScore(List<Response> response, Integer id) {
        ResponseEntity<Integer> right=quizInterface.getScore(response);
        return right;
    }
}
