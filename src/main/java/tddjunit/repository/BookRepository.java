package tddjunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tddjunit.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByAuthor(String author);

    @Override
    <S extends Book> S save(S entity);
}
