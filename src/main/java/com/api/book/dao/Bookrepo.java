package com.api.book.dao;

  //import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.api.book.entities.Book;
import org.springframework.stereotype.Service;


@Service
public interface Bookrepo extends CrudRepository<Book, Integer> {
	
	public Book findById(int id);
	
}
// dependency for junit
// h2 required to