package emiione.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import emiione.springframework.spring5webapp.domain.Author;
import emiione.springframework.spring5webapp.domain.Book;
import emiione.springframework.spring5webapp.domain.Publisher;
import emiione.springframework.spring5webapp.repositories.AuthorRepository;
import emiione.springframework.spring5webapp.repositories.BookRepository;
import emiione.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception{
		
		System.out.println("Started in Bootstrap");
		
		Publisher publisher1 = new Publisher("Carturesti", "Park Lake", "Bucharest", "Romania", "12345");
		publisherRepository.save(publisher1);
		
		Author author1 = new Author("Eric", "Vanderguard");
		Book book1 = new Book("Domain Driven Design", "11245567");
		author1.getBooks().add(book1);
		book1.getAuthors().add(author1);
		
		book1.setPublisher(publisher1);
		publisher1.getBooks().add(book1);
		
		// Save to H2 memory DB
		authorRepository.save(author1);
		bookRepository.save(book1);
		publisherRepository.save(publisher1);
		
		Author author2 = new Author("Rod", "Jonson");
		Book book2 = new Book("J2EE Development without EJB", "23341556");
		author2.getBooks().add(book2);
		book2.getAuthors().add(author2);
		
		book2.setPublisher(publisher1);
		publisher1.getBooks().add(book2);	

		
		// Save to H2 memory DB
		authorRepository.save(author2);
		bookRepository.save(book2);
		publisherRepository.save(publisher1);
		
		// Some output
		System.out.println("Number of authors: " + authorRepository.count());
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of publishers: " + publisherRepository.count());
		System.out.println("Publisher1 number of books: " + publisher1.getBooks().size());
	}

}
