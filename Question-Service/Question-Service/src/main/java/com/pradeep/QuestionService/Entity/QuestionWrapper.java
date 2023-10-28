package com.pradeep.QuestionService.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionWrapper {

    private Integer qno;
    private String qtitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
