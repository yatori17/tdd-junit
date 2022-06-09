package tddjunit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tddjunit.domain.Book;
import tddjunit.repository.BookRepository;

import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public boolean isValidIsbn10(String value) {
        String isbn = value.replace("-", "");
        if (isbn.length() != 10) {
            return false;
        }
        Integer sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = isbn.charAt(i) - '0';
            if (0 > digit || 9 < digit) {
                return false;
            }
            sum += (digit * (10 - i));
        }

        char last = isbn.charAt(9);
        if (last != 'X' && (last < '0' || last > '9')) {
            return false;
        }
        return (sum % 11 == 0);
    }
}
