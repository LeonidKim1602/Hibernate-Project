package edu.pja.kim.mas_final.model;

import edu.pja.kim.mas_final.model.Quiz.StudentQuiz;
import edu.pja.kim.mas_final.model.User.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Represents the result of a student's quiz attempt.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Result {
    /**
     * Minimum percentage required to pass a quiz.
     */
    private static Integer minPassPercentage = 50;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    @NotNull
    private LocalDateTime dateTaken;

    @OneToOne
    @JoinColumn(name = "student_quiz_id", nullable = false, unique = true)
    private StudentQuiz studentQuiz;


    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false, updatable = false)
    @NotNull
    private Student student;
}

