package com.pradeep.QuizService.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer quizId;
    private String quizTitle;

    @ElementCollection
    private List<Integer> QuestionIds;
}
