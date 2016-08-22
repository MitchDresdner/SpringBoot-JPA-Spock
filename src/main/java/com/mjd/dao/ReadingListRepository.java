package com.mjd.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mjd.model.Book;
import com.mjd.model.Reader;


public interface ReadingListRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByReader(Reader reader);

}
