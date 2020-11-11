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

        final Publisher firstPublisher = new Publisher();
        firstPublisher.setName("Main publisher");
        firstPublisher.setAddressLine1("address");
        firstPublisher.setCity("Moscow");
        firstPublisher.setState("state");
        firstPublisher.setZip("3534546");
        firstPublisher.getBooks().add(firstBook);
        firstPublisher.getBooks().add(secondBook);
        publisherRepository.save(firstPublisher);

        firstBook.setPublisher(firstPublisher);
        bookRepository.save(firstBook);

        secondBook.setPublisher(firstPublisher);
        bookRepository.save(secondBook);

        System.out.println("Saving authors and books is finished");
        System.out.println("Saved books count = " + bookRepository.count());
        System.out.println("Books count for the first publisher = " + firstPublisher.getBooks().size());
    }
}
