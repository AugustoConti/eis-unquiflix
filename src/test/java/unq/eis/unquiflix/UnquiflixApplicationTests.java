package unq.eis.unquiflix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import unq.eis.unquiflix.model.Categoria;
import unq.eis.unquiflix.model.Pelicula;
import unq.eis.unquiflix.service.PeliculaService;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnquiflixApplicationTests {

    @Autowired
    private PeliculaService peliService;

    @Test
    public void contextLoads() {
    }

    private void assertVolverAlFuturo(Pelicula vaf){
        assertEquals(Integer.valueOf(1), vaf.getID());
        assertEquals("Volver al Futuro", vaf.getTitulo());
        assertEquals(Categoria.FICCION, vaf.getCategoria());
        assertTrue(vaf.getEstreno().isEqual(LocalDate.of(1985, 7, 3)));
        assertEquals("Marty McFly, un estudiante de secundaria de 17 años, es enviado accidentalmente treinta años al pasado en un DeLorean que viaja en el tiempo inventado por su amigo cercano, el científico disidente Doc Brown.",
                vaf.getDescripcion());
        assertEquals("Robert Zemeckis", vaf.getDirectores());
        assertEquals("Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson", vaf.getActores());
        assertEquals("https://www.youtube.com/watch?v=qvsgGtivCgs", vaf.getLink());
        assertEquals("https://m.media-amazon.com/images/M/MV5BZmU0M2Y1OGUtZjIxNi00ZjBkLTg1MjgtOWIyNThiZWIwYjRiXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,643,1000_AL_.jpg",
                vaf.getLinkPortada());
    }

    @Test
    public void getPeliculaVolverAlFuturoByTitulo() {
        assertVolverAlFuturo(peliService.getPeliculaByTitle("Volver al Futuro"));
    }

    @Test
    public void getPeliculaVolverAlFuturoByID() {
        assertVolverAlFuturo(peliService.getPelicula(1));
    }

    @Test
    public void peliculaInicializaActivada() {
        assertTrue(peliService.getPelicula(1).getActiva());
    }

    @Test
    public void descativoPelicula() {
        peliService.cambiarActivacion(1);
        assertFalse(peliService.getPelicula(1).getActiva());
    }

    @Test
    public void todasLasCategorias() {
        assertEquals(Arrays.asList(Categoria.values()), peliService.getAllCategories());
    }
}
