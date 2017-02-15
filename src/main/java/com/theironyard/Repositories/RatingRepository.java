package com.theironyard.Repositories;

import com.theironyard.Entities.Coffee;
import com.theironyard.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by darionmoore on 2/7/17.
 */
public interface RatingRepository extends JpaRepository <Rating, Integer> {
        List<Rating> findByCoffeeId(Coffee id);

}
