package tddjunit;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tddjunit.domain.Book;
import tddjunit.web.rest.BookController;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BooksManagementControllerIntegrationTest {

    @Autowired
    BookController bookController;

    @Test
    public void testAddBook() throws URISyntaxException {
        Book book = new Book();
        book.setTitle("Fundamentos da Computação Gráfica");
        book.setAuthor("Jonas Gomes");
        book.setIsbn13("978-85-244-0200-5");
        ResponseEntity response = bookController.createBook(book);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}
