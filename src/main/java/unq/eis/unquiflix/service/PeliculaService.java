package unq.eis.unquiflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import unq.eis.unquiflix.model.Categoria;
import unq.eis.unquiflix.model.Pelicula;
import unq.eis.unquiflix.repository.PeliculaRepository;

import java.time.LocalDate;
import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        peliRepository.save(new Pelicula("Volver al Futuro", Categoria.FICCION, LocalDate.of(1985, 7, 3),
                "Robert Zemeckis",
                "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson",
                "https://www.youtube.com/watch?v=qvsgGtivCgs",
                "https://m.media-amazon.com/images/M/MV5BZmU0M2Y1OGUtZjIxNi00ZjBkLTg1MjgtOWIyNThiZWIwYjRiXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,643,1000_AL_.jpg"));

        peliRepository.save(new Pelicula("Volver al Futuro II", Categoria.FICCION, LocalDate.of(1989, 12, 25),
                "Robert Zemeckis",
                "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson",
                "https://www.youtube.com/watch?v=MdENmefJRpw",
                "https://m.media-amazon.com/images/M/MV5BZTMxMGM5MjItNDJhNy00MWI2LWJlZWMtOWFhMjI5ZTQwMWM3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg"));

        peliRepository.save(new Pelicula("Volver al Futuro III", Categoria.FICCION, LocalDate.of(1990, 8, 17),
                "Robert Zemeckis",
                "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson",
                "https://www.youtube.com/watch?v=3C8c3EoEfw4",
                "https://m.media-amazon.com/images/M/MV5BYjhlMGYxNmMtOWFmMi00Y2M2LWE5NWYtZTdlMDRlMGEzMDA3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,676,1000_AL_.jpg"));

        peliRepository.save(new Pelicula("El señor de los anillos: La comunidad del anillo", Categoria.DRAMA, LocalDate.of(2002, 1, 31),
                "Peter Jackson",
                "Elijah Wood, Ian McKellen, Orlando Bloom, Viggo Mortensen",
                "https://www.youtube.com/watch?v=V75dMMIW2B4",
                "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SY999_CR0,0,673,999_AL_.jpg"));

        peliRepository.save(new Pelicula("El señor de los anillos: Las dos torres", Categoria.DRAMA, LocalDate.of(2003, 1, 2),
                "Peter Jackson",
                "Elijah Wood, Ian McKellen, Orlando Bloom, Viggo Mortensen",
                "https://www.youtube.com/watch?v=LbfMDwc4azU",
                "https://m.media-amazon.com/images/M/MV5BMDY0NmI4ZjctN2VhZS00YzExLTkyZGItMTJhOTU5NTg4MDU4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg"));

        peliRepository.save(new Pelicula("El señor de los anillos: El retorno del rey", Categoria.DRAMA, LocalDate.of(2003, 1, 2),
                "Peter Jackson",
                "Elijah Wood, Ian McKellen, Orlando Bloom, Viggo Mortensen",
                "https://www.youtube.com/watch?v=r5X-hFf6Bwo",
                "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,675,1000_AL_.jpg"));

        peliRepository.save(new Pelicula("Pulp Fiction", Categoria.ACCION, LocalDate.of(1995, 2, 16),
                "Quentin Tarantino",
                "John Travolta, Uma Thurman, Samuel L. Jackson",
                "https://www.youtube.com/watch?v=s7EdQ4FqbhY",
                "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,686,1000_AL_.jpg"));

        peliRepository.save(new Pelicula("Deadpool", Categoria.COMEDIA, LocalDate.of(2016, 2, 11),
                "Tim Miller",
                " Ryan Reynolds, Morena Baccarin, T.J. Miller",
                "https://www.youtube.com/watch?v=0JnRdfiUMa8",
                "https://m.media-amazon.com/images/M/MV5BYzE5MjY1ZDgtMTkyNC00MTMyLThhMjAtZGI5OTE1NzFlZGJjXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg"));
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
