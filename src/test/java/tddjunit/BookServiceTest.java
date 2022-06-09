package tddjunit;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tddjunit.service.BookService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TddJunitApplicationTests
public class BookServiceTest {

    @DisplayName("Valida ISBN Success")
    @Test
    public void validateIsbn() {
        BookService bookService = mock(BookService.class);
        when(bookService.isValidIsbn10(anyString())).thenReturn(true);
        assertTrue(bookService.isValidIsbn10("123456678433"));
    }

}
