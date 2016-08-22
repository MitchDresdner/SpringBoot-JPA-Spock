package com.mjd;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mjd.ReadingListApplication;
import com.mjd.model.Book;
import com.mjd.model.Reader;
import com.mjd.dao.ReaderRepository;
import com.mjd.dao.ReadingListRepository;


import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringApplicationConfiguration(classes=ReadingListApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReadingListApplicationTests {

    @Autowired
    private ReaderRepository readerRepo;
    
    @Autowired
    private ReadingListRepository repo;
    
	@Test
	public void contextLoads() {
	}

    //    @Transactional
    @Test
    public void saveABook() throws Exception {
        
        //assertEquals(0, repo.findAll().size());
        
        Reader reader = readerRepo.findByUsername("mitch");
        
        Book saved = repo.save(new Book(reader, "TITLE", "AUTHOR", "1234567890", "DESCRIPTION"));

        saved = repo.save(new Book(reader, "TITLE1", "AUTHOR1", "1234567890-1", "DESCRIPTION1"));
        saved = repo.save(new Book(reader, "TITLE2", "AUTHOR2", "1234567890-2", "DESCRIPTION2"));
        saved = repo.save(new Book(reader, "TITLE3", "AUTHOR3", "1234567890-3", "DESCRIPTION3"));

        Book bk = repo.findOne(1L);                         //repo.findOne(saved.getId());

        List<Book> found = repo.findByReader(reader);

        //assertEquals(saved.getId(), found.getId());
        assertEquals("TITLE", found.get(0).getTitle());
        assertEquals("DESCRIPTION", found.get(0).getDescription());
        assertEquals("AUTHOR", found.get(0).getAuthor());
        assertEquals("1234567890", found.get(0).getIsbn());
        assertEquals("mitch", found.get(0).getReader().getUsername());
    }
    
}
