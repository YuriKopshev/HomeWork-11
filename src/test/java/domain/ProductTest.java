package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product(1, "DVD", 80);

    @Test
    void ShouldMatchesByName() {
        String search = "DVD";
        assertEquals(true, product.matches(search));

    }
}