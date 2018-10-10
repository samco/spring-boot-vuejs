package au.id.couter.springbootvuejs.repository;

import au.id.couter.springbootvuejs.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
