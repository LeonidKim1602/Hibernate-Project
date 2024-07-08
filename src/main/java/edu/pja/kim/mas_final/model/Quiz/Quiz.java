package edu.pja.kim.mas_final.model.Quiz;

import edu.pja.kim.mas_final.model.Category;
import edu.pja.kim.mas_final.model.Question;
import edu.pja.kim.mas_final.model.User.Teacher;
import edu.pja.kim.mas_final.model.validator.quiz.ValidEnumSet;
import edu.pja.kim.mas_final.model.validator.quiz.ValidQuizOverlapping;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;

/**
 * Represents a Quiz entity that can be created and managed by a Teacher.
 * Each quiz has a title, description, associated questions, category, and teacher.
 * Students can take quizzes, and their progress is tracked through StudentQuiz entities.
 */
@Entity
@Data
@Table(name = "quiz")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
//@ValidQuizOverlapping
//@ValidEnumSet
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum Type{
        TIMED, SURVIVAL
    }

    @ElementCollection
    @CollectionTable(name = "quiz_types", joinColumns = @JoinColumn(name = "quiz_id", nullable = false))
    @Enumerated(EnumType.STRING)
    private Set<Type> types;

    @Positive
    private Integer timeLimit; //in minutes

    @Positive
    @Max(5)
    private Integer attempts;

//    @NotNull
    @NotBlank
    private String title;

    @NotBlank
    /*@NotNull*/
    @Getter
    private String description;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<StudentQuiz> studentQuizzes = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "quiz_question",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;

    @ManyToOne(fetch = FetchType.LAZY)
//    @NotNull
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
//    @NotNull
    @JoinColumn(name = "teacher_id")
    @ToString.Exclude
    private Teacher teacher;



}
