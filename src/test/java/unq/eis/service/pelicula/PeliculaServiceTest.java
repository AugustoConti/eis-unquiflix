package unq.eis.service.pelicula;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unq.eis.model.Pelicula;
import unq.eis.service.ServiceFactory;
import unq.eis.service.runner.SessionFactoryProvider;
import unq.eis.service.test.TestService;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PeliculaServiceTest {
    private TestService testService = ServiceFactory.getTestService();
    private PeliculaService service = ServiceFactory.getPeliculaService();

    @Before
    public void setUp() {
        testService.save(new Pelicula("Volver al Futuro", LocalDate.of(1985, 7, 3),
                "Robert Zemeckis",
                "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson",
                "https://www.youtube.com/watch?v=qvsgGtivCgs"));
    }

    @After
    public void cleanup() {
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
