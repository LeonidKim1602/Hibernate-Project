package edu.pja.kim.mas_final.model.validator.teacher;

import edu.pja.kim.mas_final.model.User.Teacher;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class TeacherDateValidator implements ConstraintValidator<ValidTeacherDate, Teacher> {
    @Override
    public void initialize(ValidTeacherDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Teacher teacher, ConstraintValidatorContext constraintValidatorContext) {
        return !teacher.getHireDate().isAfter(LocalDate.now());
    }
}
