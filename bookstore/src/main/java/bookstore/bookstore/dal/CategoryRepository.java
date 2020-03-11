package bookstore.bookstore.dal;

import bookstore.bookstore.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
