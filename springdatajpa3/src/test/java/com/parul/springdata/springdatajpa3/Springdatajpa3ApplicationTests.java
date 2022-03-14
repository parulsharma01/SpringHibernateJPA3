package com.parul.springdata.springdatajpa3;

import com.parul.springdata.springdatajpa3.entities.Address;
import com.parul.springdata.springdatajpa3.entities.Author;
import com.parul.springdata.springdatajpa3.entities.Book;
import com.parul.springdata.springdatajpa3.repos.AuthorRepository;
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
		author.setName("J K Rowling");

		Set<Book> books=new HashSet<>();
		Book book=new Book();
		book.setBookName("Harry Potter");
		author.addBook(book);

		book=new Book();
		book.setBookName("An Indian Girl");
		author.addBook(book);

		Address address=new Address();
		address.setStreetNumber(63);
		address.setLocation("ALwar");
		address.setState("Rajasthan");
		author.addAddress(address);

		repository.save(author);
	}

}
