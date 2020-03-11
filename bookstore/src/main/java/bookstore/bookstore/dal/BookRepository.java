package bookstore.bookstore.dal;

import bookstore.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;

// tietokantakäsittelyn rajapinta
public interface BookRepository extends CrudRepository<Book, Long> {

}
