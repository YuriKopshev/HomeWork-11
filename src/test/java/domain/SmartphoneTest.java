package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(3, "Nokia", 1000, "Microsoft");
    Smartphone smartphone1 = new Smartphone(5, "Apple", 1500, "Apple Inc");

    @Test
    void shouldMatchesByManufacturer() {
        String search = "Microsoft";
        assertTrue(smartphone.matches(search));
    }

    @Test
    void shouldMatchesByName() {
        String search = "Apple";
        assertTrue(smartphone1.matches(search));

    }

    @Test
    void shouldNoMatches() {
        String search = "Sony";
        assertFalse(smartphone1.matches(search));

    }

}