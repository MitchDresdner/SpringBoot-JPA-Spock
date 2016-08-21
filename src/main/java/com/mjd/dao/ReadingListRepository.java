package com.mjd.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mjd.model.Book;

public interface ReadingListRepository extends CrudRepository<Book, Long> {
	
	List<Book> findByReader(String reader);

}
