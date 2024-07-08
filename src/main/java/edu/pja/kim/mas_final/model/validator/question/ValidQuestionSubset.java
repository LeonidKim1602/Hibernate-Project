package edu.pja.kim.mas_final.model.validator.question;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = QuestionSubsetValidator.class)
public @interface ValidQuestionSubset {
    String message() default "Invalid question subset/Question does not contain correct answer.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
