package edu.pja.kim.mas_final.model.User;

import edu.pja.kim.mas_final.model.Quiz.Quiz;
import edu.pja.kim.mas_final.model.validator.teacher.ValidTeacherDate;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@ValidTeacherDate
public class Teacher extends MyUser {

    @OneToMany(mappedBy = "teacher")
    private List<Quiz> quizzes;


    @NotNull
    private LocalDate hireDate;


    @Override
    public void login() {
        System.out.println("Teacher logged in");
    }

    @Override
    public void register() {
        System.out.println("Teacher registered");
    }

    @Override
    public void resetPassword() {
        System.out.println("Teacher reset password");
    }

}
