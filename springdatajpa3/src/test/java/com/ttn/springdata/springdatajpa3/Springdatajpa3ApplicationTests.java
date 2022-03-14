package com.ttn.springdata.springdatajpa3;

import com.ttn.springdata.springdatajpa3.entities.Address;
import com.ttn.springdata.springdatajpa3.entities.Author;
import com.ttn.springdata.springdatajpa3.entities.Book;
import com.ttn.springdata.springdatajpa3.repos.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class Springdatajpa3ApplicationTests {

	@Autowired
	AuthorRepository repository;

	@Test
	void contextLoads() {}

	@Test
	public void testCreateAuthor()
	{
		Author author= new Author();
		author.setName("Alice");

		Set<Book> books=new HashSet<>();
		Book book=new Book();
		book.setBookName("Alchemist 2");
		author.addBook(book);

		book=new Book();
		book.setBookName("A Monk who sold his Bugatti");
		author.addBook(book);

		book=new Book();
		book.setBookName("Genius 2020");
		author.addBook(book);

		Address address=new Address();
		address.setStreetNumber(4299);
		address.setLocation("Ujjain");
		address.setState("MP");
		author.addAddress(address);

		repository.save(author);
	}

}
