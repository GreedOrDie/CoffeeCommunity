package com.theironyard.Repositories;

import com.theironyard.Entities.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by darionmoore on 1/26/17.
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    Coffee findFirstByName(String name);
}
