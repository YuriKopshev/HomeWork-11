package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product(1, "DVD", 80);

    @Test
    void shouldMatchesByName() {
        String search = "DVD";
        assertTrue(product.matches(search));
    }
    @Test
    void shouldNotMatchesByName() {
        String search = "Video";
        assertFalse(product.matches(search));

    }


}