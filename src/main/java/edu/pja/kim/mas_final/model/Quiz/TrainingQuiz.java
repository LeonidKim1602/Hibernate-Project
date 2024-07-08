package edu.pja.kim.mas_final.model.Quiz;

import edu.pja.kim.mas_final.model.validator.quiz.ValidTrainingQuizClosingDate;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@ValidTrainingQuizClosingDate
public class TrainingQuiz extends Quiz {
    @NotNull
    private LocalDate closingDate;
}
