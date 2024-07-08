package edu.pja.kim.mas_final.repository;

import edu.pja.kim.mas_final.model.User.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends CrudRepository<Student, Long> {
    @Override
    List<Student> findAll();

}
