package tddjunit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tddjunit.domain.Book;
import tddjunit.repository.BookRepository;
import tddjunit.service.BookService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TddJunitApplicationTests
public class BookServiceInjectMockTest {

    @Spy
    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setUp(@Mock BookRepository bookRepository) {
        MockitoAnnotations.openMocks(this);
        bookService = new BookService(bookRepository);
        Book book = new Book();
        book.setAuthor("Chris Richardson");
        when(bookRepository.save(any())).thenReturn(book);
    }

    @DisplayName("Registro de um novo livro")
    @Test
    public void registerBookSuccess() {
        Book book = new Book();
        book.setTitle("Microservices Patterns");
        book.setIsbn13("9781617294549");
        Book bookSaved = bookService.save(book);
        assertEquals("Chris Richardson", bookSaved.getAuthor());
        assertEquals(null, bookSaved.getTitle());

    }

//    @Test
//    public void registerBookSuccessVerify() {
//        BookService bookService = mock(BookService.class);
//
//        //when(bookService.isValidIsbn10(anyString())).thenCallRealMethod();
//        Book book = new Book();
//        book.setTitle("Microservices Patterns");
//        book.setIsbn13("9781617294549");
//        Book bookSaved = bookService.save(book);
//
//        verify(bookService, times(1)).save(book);
//        verifyNoMoreInteractions(bookService);
//    }

}
