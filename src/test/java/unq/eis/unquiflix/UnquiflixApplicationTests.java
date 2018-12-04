package unq.eis.unquiflix;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import unq.eis.unquiflix.model.Categoria;
import unq.eis.unquiflix.model.Pelicula;
import unq.eis.unquiflix.model.Usuario;
import unq.eis.unquiflix.service.PeliculaInexistenteException;
import unq.eis.unquiflix.service.PeliculaService;
import unq.eis.unquiflix.service.UsuarioIncorrectoException;
import unq.eis.unquiflix.service.UsuarioService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;


import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UnquiflixApplicationTests {

    @Autowired
    private PeliculaService peliService;

    @Autowired
    private UsuarioService userService;

    @Test
    public void contextLoads() {
    }

    private void assertVolverAlFuturo(Pelicula vaf) {
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
        assertEquals(1, vaf.getPuntuacion().size());
    }

    @Test
    public void getPeliculaVolverAlFuturoByTitulo() {
        assertVolverAlFuturo(peliService.getPeliculaByTitle("Volver al Futuro"));
    }

    @Test
    public void getPeliculaVolverAlFuturoByID() {
        assertVolverAlFuturo(peliService.getPelicula(1));
    }

    @Test(expected = PeliculaInexistenteException.class)
    public void getPeliculaInexistenteByID() {
        peliService.getPelicula(-1);
    }

    @Test
    public void peliculaInicializaActivada() {
        assertTrue(peliService.getPelicula(1).getActiva());
    }

    @Test
    public void desactivoPelicula() {
        peliService.cambiarActivacion(1);
        assertFalse(peliService.getPelicula(1).getActiva());
    }

    @Test
    public void desactivoYVuelvoAActivarPelicula() {
        peliService.cambiarActivacion(2);
        assertFalse(peliService.getPelicula(2).getActiva());
        peliService.cambiarActivacion(2);
        assertTrue(peliService.getPelicula(2).getActiva());
    }

    @Test
    public void todasLasCategorias() {
        assertEquals(Arrays.asList(Categoria.values()), peliService.getAllCategories());
    }

    @Test
    public void peliculasPorCategoria() {
        assertEquals(1, Lists.newArrayList(peliService.getPeliculasByCategory("COMEDIA")).size());
    }

    @Test
    public void allPeliculas() {
        assertEquals(12, Lists.newArrayList(peliService.getAllPeliculas()).size());
    }

    @Test
    public void savePelicula() {
        Pelicula nueva = new Pelicula("prueba", Categoria.FICCION, LocalDate.now(),
                "desc", "director", "actor",
                "link", "portada", Collections.emptyList());
        peliService.savePelicula(nueva);
        Pelicula peli = peliService.getPeliculaByTitle("prueba");
        assertEquals(Categoria.FICCION, peli.getCategoria());
        assertEquals("desc", peli.getDescripcion());
        assertEquals("director", peli.getDirectores());
        assertEquals("link", peli.getLink());
        assertEquals("portada", peli.getLinkPortada());
        peliService.delete(nueva.getID());
    }

    private void assertUsuario(Usuario usuario, String nombre, boolean esAdmin) {
        assertEquals(nombre, usuario.getNombre());
        assertEquals(esAdmin, usuario.getEsAdmin());
    }

    @Test
    public void getUsuarioAdmin() {
        assertUsuario(userService.getUsuario("quique","123"), "Enrique Alonso", true);
    }

    @Test
    public void getUsuarioComun() {
        assertUsuario(userService.getUsuario("augusto","456"), "Augusto Conti", false);
    }

    @Test(expected = UsuarioIncorrectoException.class)
    public void getUsuarioInexistente() {
        userService.getUsuario("rodolfo","");
    }

    @Test
    public void agregoUnaPuntuacionAUnaPeliculaYObtengoDosPuntuaciones(){
        Pelicula peli = peliService.getPeliculaByTitle("Volver al Futuro");
        peliService.puntuarPelicula(peli.getID(),5);
        assertEquals(2, peliService.getPelicula(peli.getID()).getPuntuacion().size());
    }
    @Test (expected = UsuarioIncorrectoException.class)
    public void verificoQueLaClaveDeUnUsuarioNoSeaCorrectaYArrojeUnaExcepcion(){
        userService.getUsuario("quique","passwordErronea").validarPassword("123");
    }


}
