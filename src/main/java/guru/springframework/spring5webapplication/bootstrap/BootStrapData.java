package guru.springframework.spring5webapplication.bootstrap;

import guru.springframework.spring5webapplication.model.Author;
import guru.springframework.spring5webapplication.model.Book;
import guru.springframework.spring5webapplication.model.Publisher;
import guru.springframework.spring5webapplication.repositories.AuthorRepository;
import guru.springframework.spring5webapplication.repositories.BookRepository;
import guru.springframework.spring5webapplication.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    public void run(String... args) throws Exception {
        final Author firstAuthor = new Author("Harry", "Ray");
        final Book firstBook = new Book("First book", "12345678");
        firstAuthor.getBooks().add(firstBook);
        firstBook.getAuthors().add(firstAuthor);

        authorRepository.save(firstAuthor);
        bookRepository.save(firstBook);

        final Author secondAuthor = new Author("Alice", "Jey");
        final Book secondBook = new Book("Second book", "7454645623");
        secondAuthor.getBooks().add(secondBook);
        secondBook.getAuthors().add(secondAuthor);

        authorRepository.save(secondAuthor);
        bookRepository.save(secondBook);

        final Publisher firstPublisher = new Publisher("Main publisher", "address", "Moscow", "state", "213354");
        publisherRepository.save(firstPublisher);

        System.out.println("Saving authors and books is finished");
        System.out.println("Saved books count = " + bookRepository.count());
    }
}
