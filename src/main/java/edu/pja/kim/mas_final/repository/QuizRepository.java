package edu.pja.kim.mas_final.repository;

import edu.pja.kim.mas_final.model.Quiz.Quiz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
    List<Quiz> findAllByIdIn(List<Long> ids);
    List<Quiz> findAll();

    @Query(value = "SELECT q.* FROM quiz q " +
            "JOIN student_quiz sq ON q.id = sq.quiz_id " +
            "WHERE sq.student_id = :studentId", nativeQuery = true)
    List<Quiz> findByStudentId(@Param("studentId") Long studentId);
}
