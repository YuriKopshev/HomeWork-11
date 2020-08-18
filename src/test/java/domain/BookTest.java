package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book = new Book(2, "Война и Мир", 200, "Толстой");
    private Book book1 = new Book(3, "Код Да Винчи", 250, "Дэн Браун");



    @Test
    void ShouldMatchesByAuthor() {
      String search = "Толстой";
      Boolean actual =  book.matches(search);
      assertEquals(true,actual);
    }

    @Test
    void ShouldMatchesByName() {
        String search = "Код Да Винчи";
        Boolean actual = book1.matches(search);
        assertEquals(true,actual);

    }
}