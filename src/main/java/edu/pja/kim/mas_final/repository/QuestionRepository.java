package edu.pja.kim.mas_final.repository;

import edu.pja.kim.mas_final.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
