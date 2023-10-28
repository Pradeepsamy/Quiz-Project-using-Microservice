package com.pradeep.QuestionService.Service;

import com.pradeep.QuestionService.Entity.Question;
import com.pradeep.QuestionService.Entity.QuestionWrapper;
import com.pradeep.QuestionService.Entity.Response;
import com.pradeep.QuestionService.Repository.QuestionServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionServiceRepo questionServiceRepo;

    public ResponseEntity<Question> saveQuestion(Question question) {
        return new ResponseEntity<>(questionServiceRepo.save(question), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getAllQuestion() {
        return new ResponseEntity<>(questionServiceRepo.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getCatagoryQuestion(String category) {
        return new ResponseEntity<>((questionServiceRepo.findBycategory(category)),HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>>getRandomQuestion(String category){
        List<Question>questions =questionServiceRepo.findBycategory(category);
        List<QuestionWrapper>questionForUser=new ArrayList<>();
        for(Question q:questions){
            QuestionWrapper questionWrapper=new QuestionWrapper(q.getQno(),q.getQtitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(questionWrapper);
        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<List<Integer>> generateQuestion(String category) {
        return new ResponseEntity<>(questionServiceRepo.findRandomQuestionByCategory(category),HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionById(List<Integer> qno) {
        List<Question>questions=new ArrayList<>();
        List<QuestionWrapper>questionWrappers=new ArrayList<>();
        for(Integer i:qno){
          questions.add(questionServiceRepo.findById(i).get());
        }
        for (Question q:questions){
            QuestionWrapper questionWrapper=new QuestionWrapper(q.getQno(), q.getQtitle(), q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionWrappers.add(questionWrapper);
        }
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> response) {
        int right=0;
       for(Response responses:response){
          Question question= questionServiceRepo.findById(responses.getQno()).get();
          if(responses.getAnswer().equals(question.getAnswer())){
              right++;
          }
       }
       return new ResponseEntity<>(right,HttpStatus.OK);
    }
    }

