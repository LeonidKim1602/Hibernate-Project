package edu.pja.kim.mas_final.model.validator.quiz;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = QuizEnumSetValidator.class)
public @interface ValidEnumSet {
    String message() default "Invalid Enum Set";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
