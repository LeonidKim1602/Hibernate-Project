package edu.pja.kim.mas_final.repository;

import edu.pja.kim.mas_final.model.User.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
