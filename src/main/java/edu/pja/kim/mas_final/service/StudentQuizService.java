package edu.pja.kim.mas_final.service;


import edu.pja.kim.mas_final.dto.QuizDTO;
import edu.pja.kim.mas_final.dto.StudentDTO;
import edu.pja.kim.mas_final.model.Quiz.Quiz;
import edu.pja.kim.mas_final.model.Quiz.StudentQuiz;
import edu.pja.kim.mas_final.model.User.Student;
import edu.pja.kim.mas_final.repository.QuizRepository;
import edu.pja.kim.mas_final.repository.StudentQuizRepository;
import edu.pja.kim.mas_final.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentQuizService {

    private final StudentQuizRepository studentQuizRepository;
    private final QuizRepository quizRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentQuizService(StudentQuizRepository studentQuizRepository, QuizRepository quizRepository, StudentRepository studentRepository) {
        this.studentQuizRepository = studentQuizRepository;
        this.quizRepository = quizRepository;
        this.studentRepository = studentRepository;
    }

    public void assignQuizToStudent(Long studentId, Long quizId) {
        Student student = studentRepository.findById(studentId).get();
        Quiz quiz = quizRepository.findById(quizId).get();

        StudentQuiz studentQuiz = StudentQuiz.builder().student(student).quiz(quiz).assignedAt(LocalDate.now()).build();
        studentQuizRepository.save(studentQuiz);

    }

    public List<QuizDTO> getStudentQuizzesByStudentId(Long studentId) {
        /*List<Quiz> quizzes = quizRepository.findByStudentId(studentId);
        return quizzes.stream().map(this::convertToDTO).toList();*/
        Student student = studentRepository.findById(studentId).get();
        List<Quiz> quizzes = student.getStudentQuizzes().stream().map(StudentQuiz::getQuiz).toList();
        return quizzes.stream().map(this::convertToDTO).toList();
    }

    public List<QuizDTO> getAllQuizzes() {
        return quizRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private QuizDTO convertToDTO(Quiz quiz) {
        QuizDTO dto = new QuizDTO();
        dto.setId(quiz.getId());
        dto.setTitle(quiz.getTitle());
        dto.setCategoryName(quiz.getCategory().getName());
        dto.setTimeLimit(quiz.getTimeLimit());
        dto.setAttempts(quiz.getAttempts());
        return dto;
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setUsername(student.getUsername());
        dto.setEmail(student.getEmail());
        dto.setEnrollmentDate(student.getEnrollmentDate());
        return dto;
    }
}