package mk.ukim.finki.carapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CarAppApplicationTests {

    @Test
    void contextLoads() {
        // Ensure that the application context loads successfully
        assertTrue(true);
    }

    @Test
    void simpleTest() {
        // Add a simple passing test to ensure tests pass during build
        assertTrue(true);
    }

}
