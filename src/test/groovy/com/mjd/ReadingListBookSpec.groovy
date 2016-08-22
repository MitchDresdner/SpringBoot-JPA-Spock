package com.mjd

import spock.lang.*

import java.util.List

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.boot.test.context.SpringBootTest

import com.mjd.model.Book
import com.mjd.model.Reader
import com.mjd.dao.ReaderRepository
import com.mjd.dao.ReadingListRepository


@Title("Unit test for Reading List")
@SpringBootTest
class ReadingListBookSpec extends spock.lang.Specification {

    @Autowired
    ApplicationContext context
    
    @Autowired
    private ReaderRepository readerRepo
    
    @Autowired
    private ReadingListRepository repo
    
    def "length of Spock's and his friends' names"() {
        
        expect:
            name.size() == length

        where:
            name     | length
            "Spock"  | 5
            "Kirk"   | 4
            "Scotty" | 6
    }
    

    def "test context loads"() {
        expect:
        context != null
        repo != null
        context.containsBean("readingListApplication")
        context.containsBean("readingListRepository")
    }


	def "A MySQL database for tracking reading lists"() {
		given: "an empty database"
        Reader reader = readerRepo.findByUsername("mitch")
		Book book = new Book(reader, "TITLE", "AUTHOR", "1234567890", "DESCRIPTION")

		when: "user wants to add a new book to reading list"                
		repo.save(book)
        List<Book> found = repo.findByReader(reader)

		then: "we are able to query for the book"               
		"TITLE" == found.get(0).getTitle()
        "DESCRIPTION" == found.get(0).getDescription()
        "AUTHOR" == found.get(0).getAuthor()
        "1234567890" == found.get(0).getIsbn()
        "mitch" == found.get(0).getReader().getUsername()
	}

}