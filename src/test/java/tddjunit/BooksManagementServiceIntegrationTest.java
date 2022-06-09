package tddjunit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tddjunit.domain.Book;
import tddjunit.service.BookService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TddJunitApplicationTests
public class BooksManagementServiceIntegrationTest {

    @Autowired
    BookService bookService;

    @Test
    @DisplayName("Salvando um livro no banco de dados")
    public void testAddBookToWishList() {
        Book book = new Book();
        book.setTitle("Fundamentos da Computação Gráfica");
        book.setAuthor("Jonas Gomes da Silva Lima Gomes");
        book.setIsbn13("978-85-244-0200-5");
        Book newBook = bookService.save(book);

        assertNotNull(newBook);
        assertNotNull(newBook.getId());
        assertEquals("Jonas Gomes da Silva Lima Gomes", newBook.getAuthor());
    }
}
