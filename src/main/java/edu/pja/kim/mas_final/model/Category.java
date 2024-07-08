package edu.pja.kim.mas_final.model;

import edu.pja.kim.mas_final.model.Quiz.Quiz;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

/**
 * Represents a category for organizing quizzes within a subject.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    @NotBlank
    @Getter
    @Setter
    private String name;


    @Nullable
    private String description;


    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Quiz> quizzes;
}

