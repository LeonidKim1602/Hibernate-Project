package edu.pja.kim.mas_final.dto;

import lombok.Data;

@Data
public class QuizDTO {
    private Long id;
    private String title;
    private Integer attempts;
    private String categoryName;
    private Integer timeLimit;

    @Override
    public String toString() {
        return title + " - " + attempts + " - " + categoryName + " - " + timeLimit;
    }
}
