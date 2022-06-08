package tddjunit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import tddjunit.domain.Book;
import tddjunit.service.BookService;
import tddjunit.web.rest.BookController;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
public class BookManagementControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddBook() throws Exception {
        // setup mock book returned the mock service component
        Book mockBook = new Book();
        mockBook.setTitle("Exemplo");

        when(bookService.save(any(Book.class))).thenReturn(mockBook);

        Book book = new Book();
        book.setTitle("techtalk");
        book.setAuthor("João");

        mockMvc
                .perform(post("/api/books", book))
                .andExpect(status().isCreated()).andReturn();

    }

    @Test
    public void testAddBookServiceRuleNotSatisfied() throws Exception {
        // setup mock book returned the mock service component
        Book mockBook = new Book();
        mockBook.setTitle("Exemplo");

        when(bookService.save(any(Book.class))).thenReturn(null);

        Book book = new Book();
        book.setTitle("techtalk");
        book.setAuthor("João");

        mockMvc
                .perform(post("/api/books", book))
                .andExpect(status().isCreated()).andReturn();

    }
}
