package com.cap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cap.model.BookOrder;


@Repository
public interface BookOrderRepository extends MongoRepository<BookOrder, String> {

}
