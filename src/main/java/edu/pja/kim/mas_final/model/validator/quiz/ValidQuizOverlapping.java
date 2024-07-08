package edu.pja.kim.mas_final.model.validator.quiz;

import edu.pja.kim.mas_final.model.validator.teacher.TeacherDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = QuizOverlappingValidator.class)
public @interface ValidQuizOverlapping {
    String message() default "Something.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
