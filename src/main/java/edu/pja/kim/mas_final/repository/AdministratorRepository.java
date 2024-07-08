package edu.pja.kim.mas_final.repository;

import edu.pja.kim.mas_final.model.User.Administrator;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
}
