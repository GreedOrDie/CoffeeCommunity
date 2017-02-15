package com.theironyard.Repositories;

import com.theironyard.Entities.Coffee;
import com.theironyard.Entities.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by darionmoore on 1/26/17.
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    Coffee findFirstByName(String name);
    Coffee findBySubmitted(LocalDateTime submitted);
    List<Coffee> findByNameContainingIgnoreCase(String search);
    List<Coffee> findByTags(Tag tags);
    Page<Coffee> findAll(Pageable pageable);  //GET THIS WORKING

}
