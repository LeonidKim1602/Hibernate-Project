package edu.pja.kim.mas_final.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.pja.kim.mas_final.model.Quiz.Quiz;
import edu.pja.kim.mas_final.model.validator.question.ValidQuestionSubset;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a question entity in the system, associated with quizzes and answers.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ValidQuestionSubset
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    @NotBlank
    private String text;


    @Builder.Default
    @ManyToMany(mappedBy = "questions")
    private Set<Quiz> quizzes = new HashSet<>();


    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Answer> has = new HashSet<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "correct_answer_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Answer correctAnswer;

    public Question addAnswer(Answer answer) {
        answer.setQuestion(this);
        this.has.add(answer);
        return this;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return id != null && id.equals(question.getId());
    }
}
