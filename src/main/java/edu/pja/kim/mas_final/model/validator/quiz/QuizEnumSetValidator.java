package edu.pja.kim.mas_final.model.validator.quiz;

import edu.pja.kim.mas_final.model.Quiz.Quiz;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class QuizEnumSetValidator implements ConstraintValidator<ValidEnumSet, Quiz> {
    @Override
    public void initialize(ValidEnumSet constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Quiz quiz, ConstraintValidatorContext constraintValidatorContext) {
        if(quiz.getTypes().isEmpty())
            return false;
        return true;
    }
}
