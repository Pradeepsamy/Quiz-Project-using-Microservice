package com.pradeep.QuizService.Entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWrapper {

    private Integer qno;
    private String qtitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
