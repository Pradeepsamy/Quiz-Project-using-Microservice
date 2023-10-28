package com.pradeep.QuestionService.Repository;

import com.pradeep.QuestionService.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionServiceRepo extends JpaRepository<Question,Integer> {

    @Query(value ="SELECT * from servicequestion q where q.category=?1 order by rand() limit 4",nativeQuery = true)
    List<Question> findBycategory(String category);

    @Query(value = "select s.qno from servicequestion s where s.category=?1 order by rand() limit 4")
    List<Integer> findRandomQuestionByCategory(String category);
}
