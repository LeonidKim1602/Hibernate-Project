package edu.pja.kim.mas_final.model.Quiz;

import edu.pja.kim.mas_final.model.Result;
import edu.pja.kim.mas_final.model.User.Student;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Bag;

import java.time.LocalDate;

/**
 * Represents the association between a Student and a Quiz.
 * Each StudentQuiz instance tracks when the quiz was assigned to the student and holds the result.
 */
@Entity
@Table(name = "student_quiz")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDate assignedAt;


    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @ToString.Exclude
    private Student student;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id", nullable = false)
    @ToString.Exclude
    private Quiz quiz;


    @OneToOne(mappedBy = "studentQuiz", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    private Result result;


}
