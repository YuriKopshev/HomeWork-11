package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book = new Book(2, "Война и Мир", 200, "Толстой");
    private Book book1 = new Book(3, "Код Да Винчи", 250, "Дэн Браун");



    @Test
    void shouldMatchesByAuthor() {
      String search = "Толстой";
      assertTrue(book.matches(search));
    }

    @Test
    void shouldMatchesByName() {
        String search = "Код Да Винчи";
        assertTrue(book1.matches(search));
    }
    @Test
    void shouldNoMatches() {
        String search = "Братья Карамазовы";
        assertFalse(book1.matches(search));

    }
}