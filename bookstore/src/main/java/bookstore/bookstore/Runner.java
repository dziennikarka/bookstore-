package bookstore.bookstore;

import bookstore.bookstore.domain.Book;
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
    }
}
