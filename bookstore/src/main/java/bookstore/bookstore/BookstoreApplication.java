package bookstore.bookstore;

import bookstore.bookstore.dal.CategoryRepository;
import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
    @Autowired
    private EntityManager em;
    @Autowired
    private CategoryRepository categories;
    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        log.info("creating categories");
        Category categoryOne = new Category();
        categoryOne.setName("comic");
        categories.save(categoryOne);


        Category categoryTwo = new Category();
        categoryTwo.setName("scifi");
        categories.save(categoryTwo);

        Category categoryThree = new Category();
        categoryThree.setName("crime story");
        categories.save(categoryThree);

        log.info("creating couple of books");
        Book bookOne = new Book();
        bookOne.setAuthor("Dean Koonz");
        bookOne.setTitle("Eyes of the night");
        bookOne.setYear(1981);
        bookOne.setIsbn("123456");
        bookOne.setPrice(new BigDecimal("14.95"));
        bookOne.setCategory(categoryOne);
        em.persist(bookOne);

        Book bookTWo = new Book();
        bookTWo.setAuthor("Steven King");
        bookTWo.setTitle("It");
        bookTWo.setYear(1985);
        bookTWo.setIsbn("234567");
        bookTWo.setPrice(new BigDecimal("25.00"));
        bookTWo.setCategory(categoryTwo);
        em.persist(bookTWo);

        Book bookThree = new Book();
        bookThree.setAuthor("Howard Lovecraft");
        bookThree.setTitle("Call of Ctulhu");
        bookThree.setYear(1927);
        bookThree.setIsbn("456789");
        bookThree.setPrice(new BigDecimal("55.00"));
        bookThree.setCategory(categoryThree);
        em.persist(bookThree);


    }


}
