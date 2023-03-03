package emiione.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import emiione.springframework.spring5webapp.domain.Author;
import emiione.springframework.spring5webapp.domain.Book;
import emiione.springframework.spring5webapp.repositories.AuthorRepository;
import emiione.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception{
		Author author1 = new Author("Eric", "Vanderguard");
		Book book1 = new Book("Domain Driven Design", "11245567");
		
		author1.getBooks().add(book1);
		book1.getAuthors().add(author1);
		
		// Save to DB
		authorRepository.save(author1);
		bookRepository.save(book1);
		
		Author author2 = new Author("Rod", "Jonson");
		Book book2 = new Book("J2EE Development without EJB", "23341556");
		
		author2.getBooks().add(book2);
		book2.getAuthors().add(author2);
		
		authorRepository.save(author2);
		bookRepository.save(book2);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
	}

}
