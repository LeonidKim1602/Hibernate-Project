package edu.pja.kim.mas_final.model.User;

import edu.pja.kim.mas_final.model.Quiz.StudentQuiz;
import edu.pja.kim.mas_final.model.Result;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Student entity, extending the functionality of the MyUser class.
 * Students are users enrolled in the educational system with specific attributes such as enrollment date,
 * quizzes taken, and results obtained.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Student extends MyUser {

    @NotNull
    private LocalDate enrollmentDate;


    @Override
    public void login() {
        System.out.println("Student logged in");
    }

    @Override
    public void register() {
        System.out.println("Student registered");
    }

    @Override
    public void resetPassword() {
        System.out.println("Student changed password");
    }


    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    private List<StudentQuiz> studentQuizzes = new ArrayList<>();


    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    private List<Result> results = new ArrayList<>();



}

