package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(3, "Nokia", 1000, "Microsoft");
    Smartphone smartphone1 = new Smartphone(5, "Apple", 1500, "Apple Inc");

    @Test
    void ShouldMatchesByManufacturer() {
        String search = "Microsoft";
        Boolean actual =  smartphone.matches(search);
        assertEquals(true,actual);
    }

    @Test
    void ShouldMatchesByName() {
        String search = "Apple";
        Boolean actual = smartphone1.matches(search);
        assertEquals(true,actual);

    }
}