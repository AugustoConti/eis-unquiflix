package unq.eis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaTest {

    @Test
    void test_uno() {
        Prueba p = new Prueba();
        assertEquals(3, p.sumar(1, 2));
    }
}
