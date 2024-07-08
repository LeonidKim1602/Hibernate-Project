package edu.pja.kim.mas_final.repository;

import edu.pja.kim.mas_final.model.User.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface MyUserRepository extends CrudRepository<MyUser, Long> {
}
