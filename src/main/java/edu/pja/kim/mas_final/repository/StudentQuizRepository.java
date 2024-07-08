package edu.pja.kim.mas_final.repository;

import edu.pja.kim.mas_final.model.Quiz.StudentQuiz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentQuizRepository extends CrudRepository<StudentQuiz, Long> {
    @Query(value = "SELECT * FROM student_quiz  WHERE student_id = :studentId", nativeQuery = true)
    List<StudentQuiz> findByStudentId(Long studentId);
}
