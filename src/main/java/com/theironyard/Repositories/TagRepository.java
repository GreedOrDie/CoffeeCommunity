package com.theironyard.Repositories;

import com.theironyard.Entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by darionmoore on 1/26/17.
 */
public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findByDescription(String description);
}
