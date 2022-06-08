package tddjunit.web.rest;

import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tddjunit.domain.Book;
import tddjunit.service.BookService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity createBook(Book book) throws URISyntaxException {
        Book result = bookService.save(book);
        return ResponseEntity.created(new URI("/api/books/" + result.getId()))
                .headers(HttpHeaders.EMPTY)
                .body(result);
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.findAll();
    }


}
