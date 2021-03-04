package com.maxmendes.pocbackend.lines.repository;

import com.maxmendes.pocbackend.lines.model.Line;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LineRepository extends MongoRepository<Line, String> {
}
