package bookstore.bookstore;

import bookstore.bookstore.dal.CategoryRepository;
import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.Category;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@SpringBootApplication
public class Runner implements CommandLineRunner {
    @Autowired
    private EntityManager em;
    @Autowired
    private CategoryRepository categories;
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Book bookOne = new Book("Dean Koonz", "Eyes of the night", 1981, "123456", new BigDecimal("14.95"));
        em.persist(bookOne);

        Book bookTWo = new Book("Steven King", "It", 1985, "234567", new BigDecimal("25.00"));
        em.persist(bookTWo);

        Book bookThree = new Book("Howard Lovecraft", "Call of Ctulhu",1927, "456789", new BigDecimal("55.00"));
        em.persist(bookThree);

        Category categoryOne = new Category();
        categoryOne.setName("comic");
        categories.save(categoryOne);

        Category categoryTwo = new Category();
        categoryTwo.setName("scifi");
        categories.save(categoryTwo);

        Category categoryThree = new Category();
        categoryThree.setName("crime story");
        categories.save(categoryThree);

    }


}
