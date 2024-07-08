package edu.pja.kim.mas_final.repository;

import edu.pja.kim.mas_final.model.Result;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Long> {
    List<Result> findResultsByScoreLessThan(Integer score);

    default List<Result> findFailedResults(){
        return findResultsByScoreLessThan(50);
    }
}
