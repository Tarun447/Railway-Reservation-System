package com.cap.train.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cap.train.model.Train;

@Repository
public interface TrainRepository extends MongoRepository<Train, Integer> {

}

