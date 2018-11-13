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

    private final PeliculaRepository peliRepository;

    @Autowired
    public PeliculaService(PeliculaRepository peliRepository) {
        this.peliRepository = peliRepository;
    }

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
                "https://m.media-amazon.com/images/M/MV5BNGE5MzIyNTAtNWFlMC00NDA2LWJiMjItMjc4Yjg1OWM5NzhhXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,684,1000_AL_.jpg"));

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
                "Ryan Reynolds, Morena Baccarin, T.J. Miller",
                "https://www.youtube.com/watch?v=0JnRdfiUMa8",
                "https://m.media-amazon.com/images/M/MV5BYzE5MjY1ZDgtMTkyNC00MTMyLThhMjAtZGI5OTE1NzFlZGJjXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        peliRepository.save(new Pelicula("Bohemian Rhapsody", Categoria.DRAMA, LocalDate.of(2018, 11, 12),
                "Bryan Singer",
                "Rami Malek, Gwilym Lee, Ben Hardy, Joseph Mazzello",
                "https://www.youtube.com/watch?v=pOYt7PmH_o8",
                "https://m.media-amazon.com/images/M/MV5BNDg2NjIxMDUyNF5BMl5BanBnXkFtZTgwMzEzNTE1NTM@._V1_SY1000_CR0,0,629,1000_AL_.jpg"));

        peliRepository.save(new Pelicula("Operación Overlord", Categoria.ACCION, LocalDate.of(2018, 11, 8),
                "Julius Avery",
                "Jovan Adepo, Wyatt Russell, Mathilde Ollivier",
                "https://www.youtube.com/watch?v=oAgsgbh-32s",
                "https://m.media-amazon.com/images/M/MV5BNzU0NTI1MTU2M15BMl5BanBnXkFtZTgwNTg4MDIzNjM@._V1_SY1000_CR0,0,639,1000_AL_.jpg"));

        peliRepository.save(new Pelicula("Nace una estrella", Categoria.DRAMA, LocalDate.of(2018, 11, 1),
                "Bradley Cooper",
                "Lady Gaga, Bradley Cooper, Sam Elliott",
                "https://www.youtube.com/watch?v=nSbzyEJ8X9E",
                "https://m.media-amazon.com/images/M/MV5BMjE3MDQ0MTA3M15BMl5BanBnXkFtZTgwMDMwNDY2NTM@._V1_SY1000_CR0,0,674,1000_AL_.jpg"));

        peliRepository.save(new Pelicula("Animales Fantásticos: Los crímenes de Grindelwald", Categoria.FICCION, LocalDate.of(2018, 11, 1),
                "David Yates",
                "Eddie Redmayne, Katherine Waterston, Dan Fogler",
                "https://www.youtube.com/watch?v=liHMfhux9M4",
                "https://m.media-amazon.com/images/M/MV5BMjAxMjM3NjAzM15BMl5BanBnXkFtZTgwNDQxNjA1NjM@._V1_SY1000_CR0,0,674,1000_AL_.jpg"));
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    Pelicula getPelicula(@PathVariable Integer id) {
        return peliRepository.findById(id).get();
    }

    @GetMapping(value = "/find/{title}")
    public @ResponseBody
    Pelicula getPeliculaByTitle(@PathVariable String title) {
        return peliRepository.findByTitulo(title);
    }

    @GetMapping(value = "/category/{categoria}")
    public @ResponseBody
    Iterable<Pelicula> getPeliculasByCategory(@PathVariable String categoria) {
        return peliRepository.findAllByCategoria(Categoria.valueOf(categoria));
    }

    @GetMapping(value = "/activacion/{id}")
    public @ResponseBody
    void cambiarActivacion(@PathVariable Integer id) {
        Pelicula peli = peliRepository.findById(id).get();
        peli.setActiva(!peli.getActiva());
        peliRepository.save(peli);
    }

    @GetMapping(value = "/categories")
    public @ResponseBody
    Iterable<Categoria> getAllCategories() {
        return Arrays.asList(Categoria.values());
    }

    @GetMapping("/")
    public @ResponseBody
    Iterable<Pelicula> getAllPeliculas() {
        return peliRepository.findAll();
    }
}
