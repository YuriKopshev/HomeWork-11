package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;
    Book book = new Book(2, "Война и Мир", 200, "Толстой");
    Book book1 = new Book(3, "Код Да Винчи", 250, "Дэн Браун");
    Book book2 = new Book(3, "Инферно", 250, "Дэн Браун");
    Book book3 = new Book(3, "Инферно", 250, "Рейнард Сильвейн");
    Smartphone smartphone = new Smartphone(3, "Nokia", 1000, "Microsoft");
    Smartphone smartphone1 = new Smartphone(5, "Apple", 1500, "Apple Inc");




    @Test
    void shouldSearchSmartphoneByName() {
        String text = "Nokia";
        Product[] returned = new Product[]{smartphone};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{smartphone};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {
        String text = "Apple Inc";
        Product[] returned = new Product[]{smartphone1};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        String text = "Толстой";
        Product[] returned = new Product[]{book};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{book};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookBySameAuthor() {
        String text = "Дэн Браун";
        Product[] returned = new Product[]{book1,book2};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{book1,book2};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchBookBySameName() {
        String text = "Инферно";
        Product[] returned = new Product[]{book2,book3};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{book2,book3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);

    }


    @Test
    void shouldSearchBookByName() {
        String text = "Код Да Винчи";
        Product[] returned = new Product[]{book1};
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchNoObject() {
        String text = "Доктор Живаго";
        Product[] returned = new Product[0];
        doReturn(returned).when(repository).findAll();

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);

    }

}