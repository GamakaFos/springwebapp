package guru.springframework.springwebapp.bootstrap;

import guru.springframework.springwebapp.domain.Author;
import guru.springframework.springwebapp.domain.Book;
import guru.springframework.springwebapp.domain.Publisher;
import guru.springframework.springwebapp.repositories.AuthorRepository;
import guru.springframework.springwebapp.repositories.BookRepository;
import guru.springframework.springwebapp.repositories.PublisherRepository;
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
        Author eric = new Author("Eric", "Evans");
        Author piz = new Author("Alan", "Piz");
        Book bodyLanguage = new Book("Body language", "isbn 1231245");
        Book noEJB = new Book("noEJB book", "isbn123444");
        Publisher kievBook = new Publisher("KievBook", "Hreshatik", "Kiev", "Kiev province", "12401");

        eric.getBooks().add(noEJB);
        noEJB.getAuthors().add(eric);
        kievBook.getPublishedBooks().add(noEJB);
        noEJB.setPublisher(kievBook);

        authorRepository.save(eric);
        bookRepository.save(noEJB);
        publisherRepository.save(kievBook);


        piz.getBooks().add(bodyLanguage);
        bodyLanguage.getAuthors().add(piz);
        bodyLanguage.setPublisher(kievBook);
        kievBook.getPublishedBooks().add(bodyLanguage);

        authorRepository.save(piz);
        bookRepository.save(bodyLanguage);
        publisherRepository.save(kievBook);



        System.out.println("Started bootstrap");
        System.out.println("Number of books:" + bookRepository.count());

        System.out.println("Our publisher- " + kievBook.getPublisherName());
        System.out.println("Published books- " + kievBook.getPublishedBooks().size());
    }
}
