package edu.pja.kim.mas_final.model.validator.quiz;

import edu.pja.kim.mas_final.model.Quiz.TrainingQuiz;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class TrainingQuizClosingDateValidator implements ConstraintValidator<ValidTrainingQuizClosingDate, TrainingQuiz> {
    @Override
    public void initialize(ValidTrainingQuizClosingDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TrainingQuiz trainingQuiz, ConstraintValidatorContext constraintValidatorContext) {
        return !trainingQuiz.getClosingDate().isBefore(LocalDate.now());
    }
}
