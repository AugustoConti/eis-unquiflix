package unq.eis.unquiflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import unq.eis.unquiflix.model.Categoria;
import unq.eis.unquiflix.repository.PeliculaRepository;
import unq.eis.unquiflix.model.Pelicula;

import java.time.LocalDate;
import java.util.Arrays;

@RestController
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        peliRepository.save(new Pelicula("Volver al Futuro", Categoria.FICCION, LocalDate.of(1985, 7, 3),
                "Robert Zemeckis",
                "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson",
                "https://www.youtube.com/watch?v=qvsgGtivCgs"));

        peliRepository.save(new Pelicula("Volver al Futuro II", Categoria.FICCION, LocalDate.of(1989, 12, 25),
                "Robert Zemeckis",
                "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson",
                "https://www.youtube.com/watch?v=MdENmefJRpw"));

        peliRepository.save(new Pelicula("Volver al Futuro III", Categoria.FICCION, LocalDate.of(1990, 8, 17),
                "Robert Zemeckis",
                "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson",
                "https://www.youtube.com/watch?v=3C8c3EoEfw4"));

        peliRepository.save(new Pelicula("El señor de los anillos: La comunidad del anillo", Categoria.DRAMA, LocalDate.of(2002, 1, 31),
                "Peter Jackson",
                "Elijah Wood, Ian McKellen, Orlando Bloom, Viggo Mortensen",
                "https://www.youtube.com/watch?v=V75dMMIW2B4"));

        peliRepository.save(new Pelicula("El señor de los anillos: Las dos torres", Categoria.DRAMA, LocalDate.of(2003, 1, 2),
                "Peter Jackson",
                "Elijah Wood, Ian McKellen, Orlando Bloom, Viggo Mortensen",
                "https://www.youtube.com/watch?v=LbfMDwc4azU"));

        peliRepository.save(new Pelicula("El señor de los anillos: El retorno del rey", Categoria.DRAMA, LocalDate.of(2003, 1, 2),
                "Peter Jackson",
                "Elijah Wood, Ian McKellen, Orlando Bloom, Viggo Mortensen",
                "https://www.youtube.com/watch?v=r5X-hFf6Bwo"));

        peliRepository.save(new Pelicula("Pulp Fiction", Categoria.ACCION, LocalDate.of(1995, 2, 16),
                "Quentin Tarantino",
                "John Travolta, Uma Thurman, Samuel L. Jackson",
                "https://www.youtube.com/watch?v=s7EdQ4FqbhY"));

        peliRepository.save(new Pelicula("Deadpool", Categoria.COMEDIA, LocalDate.of(2016, 2, 11),
                "Tim Miller",
                " Ryan Reynolds, Morena Baccarin, T.J. Miller",
                "https://www.youtube.com/watch?v=0JnRdfiUMa8"));
    }

    @GetMapping(value="/{id}")
    public @ResponseBody Pelicula getPelicula(@PathVariable Integer id) {
        return peliRepository.findById(id).get();
    }

    @GetMapping(value="/find/{title}")
    public @ResponseBody Pelicula getPeliculaByTitle(@PathVariable String title) {
        return peliRepository.findByTitulo(title);
    }

    @GetMapping(value="/category/{categoria}")
    public @ResponseBody Iterable<Pelicula> getPeliculasByCategory(@PathVariable String categoria) {
        return peliRepository.findAllByCategoria(Categoria.valueOf(categoria));
    }

    @GetMapping(value="/categories")
    public @ResponseBody Iterable<Categoria> getAllCategories() {
        return Arrays.asList(Categoria.values());
    }

    @GetMapping("/")
    public @ResponseBody
    Iterable<Pelicula> getAllPeliculas() {
        return peliRepository.findAll();
    }
}
