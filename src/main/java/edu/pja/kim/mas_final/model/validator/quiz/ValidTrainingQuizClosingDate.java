package edu.pja.kim.mas_final.model.validator.quiz;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TrainingQuizClosingDateValidator.class)
public @interface ValidTrainingQuizClosingDate {
    String message() default "Invalid training quiz closing date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
