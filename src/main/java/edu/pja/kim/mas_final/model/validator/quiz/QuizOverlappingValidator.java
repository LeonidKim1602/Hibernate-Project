package edu.pja.kim.mas_final.model.validator.quiz;

import edu.pja.kim.mas_final.model.Quiz.Quiz;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class QuizOverlappingValidator implements ConstraintValidator<ValidQuizOverlapping, Quiz> {
    @Override
    public void initialize(ValidQuizOverlapping constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Quiz quiz, ConstraintValidatorContext constraintValidatorContext) {
        if (quiz.getTypes().contains(Quiz.Type.TIMED)) {
            if (quiz.getTimeLimit() == null)
                return false;
        }
        if (quiz.getTypes().contains(Quiz.Type.SURVIVAL)) {
            if (quiz.getAttempts() == null)
                return false;
        }
        return true;
    }
}
