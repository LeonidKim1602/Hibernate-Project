package edu.pja.kim.mas_final.model.validator.question;


import edu.pja.kim.mas_final.model.Question;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class QuestionSubsetValidator implements ConstraintValidator<ValidQuestionSubset, Question> {
    @Override
    public void initialize(ValidQuestionSubset constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Question question, ConstraintValidatorContext constraintValidatorContext) {
        return question.getHas().contains(question.getCorrectAnswer());
    }
}
