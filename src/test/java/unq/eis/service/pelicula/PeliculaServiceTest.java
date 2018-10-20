package unq.eis.service.pelicula;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import unq.eis.model.Pelicula;
import unq.eis.service.ServiceFactory;
import unq.eis.service.runner.SessionFactoryProvider;
import unq.eis.service.test.TestService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeliculaServiceTest {
    private static TestService testService = ServiceFactory.getTestService();
    private PeliculaService service = ServiceFactory.getPeliculaService();

    @BeforeAll
    static void setUp() {
        testService.save(new Pelicula("Volver al Futuro", LocalDate.of(1985, 7, 3),
                "Robert Zemeckis",
                "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson",
                "https://www.youtube.com/watch?v=qvsgGtivCgs"));
    }

    @AfterAll
    static void cleanup() {
        SessionFactoryProvider.clear();
    }

    @Test
    public void buscarPeliculaVolverAlFuturo() {
        Pelicula volverAlFuturo = service.buscar("Volver al Futuro");
        assertEquals("Volver al Futuro", volverAlFuturo.getTitulo());
        assertTrue(volverAlFuturo.getEstreno().isEqual(LocalDate.of(1985, 7, 3)));
        assertEquals("Robert Zemeckis", volverAlFuturo.getDirectores());
        assertEquals("Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson", volverAlFuturo.getActores());
        assertEquals("https://www.youtube.com/watch?v=qvsgGtivCgs", volverAlFuturo.getLink());
    }
}
