package tddjunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tddjunit.domain.Book;
import tddjunit.repository.BookRepository;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    public BookRepository bookRepository;

    public Book save(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
