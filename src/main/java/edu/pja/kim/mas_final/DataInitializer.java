package edu.pja.kim.mas_final;

import edu.pja.kim.mas_final.model.*;
import edu.pja.kim.mas_final.model.Quiz.Quiz;
import edu.pja.kim.mas_final.model.Quiz.StudentQuiz;
import edu.pja.kim.mas_final.model.Quiz.TrainingQuiz;
import edu.pja.kim.mas_final.model.User.Student;
import edu.pja.kim.mas_final.model.User.Teacher;
import edu.pja.kim.mas_final.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;
    private final GradedQuizRepository gradedQuizRepository;
    private final MyUserRepository myUserRepository;
    private final QuizRepository quizRepository;
    private final ResultRepository resultRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;
    private final TrainingQuizRepository trainingQuizRepository;
    private final StudentQuizRepository studentQuizRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(myUserRepository.findById(1L).isEmpty())
            initData();
    }

    public void initData() {
        Subject math = Subject.builder().name("Mathematics").build();
        Subject science = Subject.builder().name("Science").build();
        subjectRepository.saveAll(List.of(math, science));

        Category algebra = Category.builder().name("Algebra").subject(math).build();
        Category physics = Category.builder().name("Physics").subject(science).build();
        categoryRepository.saveAll(List.of(algebra, physics));

        Teacher teacher1 = Teacher.builder()
                .username("teacher1")
                .password("password1")
                .email("teacher1@example.com")
                .hireDate(LocalDate.now())
                .build();
        teacherRepository.save(teacher1);

        Student student1 = Student.builder()
                .username("student1")
                .password("password1")
                .email("student1@example.com")
                .enrollmentDate(LocalDate.now())
                .build();
        Student student2 = Student.builder()
                .username("student2")
                .password("password2")
                .email("student2@example.com")
                .enrollmentDate(LocalDate.now())
                .build();
        Student student3 = Student.builder()
                .username("student3")
                .password("password3")
                .email("student3@example.com")
                .enrollmentDate(LocalDate.now())
                .build();
        studentRepository.saveAll(List.of(student1, student2, student3));

        Answer answer1 = Answer.builder().text("2").build();
        Answer answer2 = Answer.builder().text("4").build();
        Answer answer3 = Answer.builder().text("6").build();
        Answer answer4 = Answer.builder().text("8").build();

        Answer answer5 = Answer.builder().text("10").build();
        Answer answer6 = Answer.builder().text("20").build();
        Answer answer7 = Answer.builder().text("30").build();
        Answer answer8 = Answer.builder().text("40").build();

        Answer answer9 = Answer.builder().text("3").build();
        Answer answer10 = Answer.builder().text("6").build();
        Answer answer11 = Answer.builder().text("9").build();
        Answer answer12 = Answer.builder().text("12").build();

        Question question1 = Question.builder()
                .text("What is 2 + 2?")
                .build();
        Question question2 = Question.builder()
                .text("What is 5 + 5?")
                .build();
        Question question3 = Question.builder()
                .text("What is 3 + 3?")
                .build();

        question1.addAnswer(answer1);
        question1.addAnswer(answer2);
        question1.addAnswer(answer3);
        question1.addAnswer(answer4);

        question2.addAnswer(answer5);
        question2.addAnswer(answer6);
        question2.addAnswer(answer7);
        question2.addAnswer(answer8);

        question3.addAnswer(answer9);
        question3.addAnswer(answer10);
        question3.addAnswer(answer11);
        question3.addAnswer(answer12);
        question3.setCorrectAnswer(answer10);

        question1.setCorrectAnswer(answer2);
        question2.setCorrectAnswer(answer6);
        question3.setCorrectAnswer(answer10);


        questionRepository.saveAll(List.of(question1, question2, question3));

        Quiz quiz1 = Quiz.builder()
                .title("Simple Math Quiz")
                .description("A basic quiz on simple math")
                .category(algebra)
                .teacher(teacher1)
                .questions(List.of(question1))
                .types(EnumSet.of(Quiz.Type.TIMED, Quiz.Type.SURVIVAL))
                .timeLimit(10)
                .attempts(3)
                .build();
        Quiz quiz2 = Quiz.builder()
                .title("Intermediate Math Quiz")
                .description("A quiz on intermediate math concepts")
                .category(algebra)
                .teacher(teacher1)
                .questions(List.of(question2))
                .types(EnumSet.of(Quiz.Type.TIMED, Quiz.Type.SURVIVAL))
                .timeLimit(20)
                .attempts(3)
                .build();
        Quiz quiz3 = Quiz.builder()
                .title("Advanced Math Quiz")
                .description("A quiz on advanced math concepts")
                .category(algebra)
                .teacher(teacher1)
                .questions(List.of(question3))
                .types(EnumSet.of(Quiz.Type.TIMED, Quiz.Type.SURVIVAL))
                .timeLimit(30)
                .attempts(3)
                .build();
        TrainingQuiz quiz4 = TrainingQuiz.builder()
                .title("Training Advanced Math Quiz")
                .description("A quiz on advanced math concepts")
                .category(algebra)
                .teacher(teacher1)
                .questions(List.of(question3))
                .types(EnumSet.of(Quiz.Type.TIMED, Quiz.Type.SURVIVAL))
                .timeLimit(30)
                .attempts(3)
                .closingDate(LocalDate.now().plusDays(10))
                .build();
        quizRepository.saveAll(List.of(quiz1, quiz2, quiz3));
        trainingQuizRepository.save(quiz4);

        StudentQuiz studentQuiz1 = StudentQuiz.builder()
                .student(student1)
                .quiz(quiz1)
                .assignedAt(LocalDate.now())
                .build();
        StudentQuiz studentQuiz2 = StudentQuiz.builder()
                .student(student2)
                .quiz(quiz2)
                .assignedAt(LocalDate.now())
                .build();

        StudentQuiz studentQuiz3 = StudentQuiz.builder()
                .student(student3)
                .quiz(quiz3)
                .assignedAt(LocalDate.now())
                .build();

        StudentQuiz studentQuiz4 = StudentQuiz.builder()
                .student(student1)
                .quiz(quiz2)
                .assignedAt(LocalDate.now())
                .build();
        studentQuizRepository.saveAll(List.of(studentQuiz1, studentQuiz2, studentQuiz3, studentQuiz4));

        Result result1 = Result.builder()
                .score(80)
                .studentQuiz(studentQuiz1)
                .student(student1).dateTaken(LocalDateTime.now())
                .build();
        Result result2 = Result.builder()
                .score(90)
                .studentQuiz(studentQuiz2)
                .student(student2).dateTaken(LocalDateTime.now())
                .build();

        Result result3 = Result.builder()
                .score(85)
                .studentQuiz(studentQuiz3)
                .student(student3).dateTaken(LocalDateTime.now())
                .build();

        Result result4 = Result.builder()
                .score(75)
                .studentQuiz(studentQuiz4)
                .student(student1).dateTaken(LocalDateTime.now())
                .build();
        resultRepository.saveAll(List.of(result1, result2, result3, result4));

    }
}
