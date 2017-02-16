package com.theironyard.Repositories;

import com.theironyard.Entities.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by darionmoore on 2/15/17.
 */
public interface RecentCoffeeRepository extends JpaRepository<Coffee, Integer> {

}
