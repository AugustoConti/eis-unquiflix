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
import java.util.Collections;

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
        peliRepository.save(new Pelicula("Volver al Futuro", Categoria.FICCION, LocalDate.of(1985, 7, 3), "Marty McFly, un estudiante de secundaria de 17 años, es enviado accidentalmente treinta años al pasado en un DeLorean que viaja en el tiempo inventado por su amigo cercano, el científico disidente Doc Brown.", "Robert Zemeckis", "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson", "https://www.youtube.com/watch?v=qvsgGtivCgs", "https://m.media-amazon.com/images/M/MV5BZmU0M2Y1OGUtZjIxNi00ZjBkLTg1MjgtOWIyNThiZWIwYjRiXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,643,1000_AL_.jpg", Collections.singletonList(4)));
        peliRepository.save(new Pelicula("Volver al Futuro II", Categoria.FICCION, LocalDate.of(1989, 12, 25), "Un adolescente y un inventor extravagante viajan al pasado y al futuro para alterar una serie de eventos desastrosos.", "Robert Zemeckis", "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson", "https://www.youtube.com/watch?v=MdENmefJRpw", "https://m.media-amazon.com/images/M/MV5BZTMxMGM5MjItNDJhNy00MWI2LWJlZWMtOWFhMjI5ZTQwMWM3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg", Collections.emptyList()));
        peliRepository.save(new Pelicula("Volver al Futuro III", Categoria.FICCION, LocalDate.of(1990, 8, 17), "El último capítulo de esta trilogía, donde Marty McFly y Doc Brown se enfrentan a pistoleros en el viejo Oeste.", "Robert Zemeckis", "Michael J. Fox, Christopher Lloyd, Crispin Glover, Lea Thompson", "https://www.youtube.com/watch?v=3C8c3EoEfw4", "https://m.media-amazon.com/images/M/MV5BYjhlMGYxNmMtOWFmMi00Y2M2LWE5NWYtZTdlMDRlMGEzMDA3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,676,1000_AL_.jpg",Arrays.asList(4,5,4)));
        peliRepository.save(new Pelicula("El señor de los anillos: La comunidad del anillo", Categoria.DRAMA, LocalDate.of(2002, 1, 31), "Basada en la primer historia épica de J.R.R. Tolkien, sobre la búsqueda para poseer o destruir todo el poder del Anillo.", "Peter Jackson", "Elijah Wood, Ian McKellen, Orlando Bloom, Viggo Mortensen", "https://www.youtube.com/watch?v=V75dMMIW2B4", "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SY999_CR0,0,673,999_AL_.jpg",Arrays.asList(3,5,1)));
        peliRepository.save(new Pelicula("El señor de los anillos: Las dos torres", Categoria.DRAMA, LocalDate.of(2003, 1, 2), "Gollum guía a Frodo y Sam a Mordor mientras Aragorn y sus compañeros defienden a Rohan del bestial ejército de Saruman.", "Peter Jackson", "Elijah Wood, Ian McKellen, Orlando Bloom, Viggo Mortensen", "https://www.youtube.com/watch?v=LbfMDwc4azU", "https://m.media-amazon.com/images/M/MV5BNGE5MzIyNTAtNWFlMC00NDA2LWJiMjItMjc4Yjg1OWM5NzhhXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,684,1000_AL_.jpg",Arrays.asList(4,1,1)));
        peliRepository.save(new Pelicula("El señor de los anillos: El retorno del rey", Categoria.DRAMA, LocalDate.of(2003, 1, 2), "El viaje de La Comunidad del Anillo está llegando a su fin.", "Peter Jackson", "Elijah Wood, Ian McKellen, Orlando Bloom, Viggo Mortensen", "https://www.youtube.com/watch?v=r5X-hFf6Bwo", "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,675,1000_AL_.jpg",Arrays.asList(4,5,5)));
        peliRepository.save(new Pelicula("Pulp Fiction", Categoria.ACCION, LocalDate.of(1995, 2, 16), "Quentin Tarantino se enfoca en un grupo de violentos personajes en esta historia sobre la vida criminal.", "Quentin Tarantino", "John Travolta, Uma Thurman, Samuel L. Jackson", "https://www.youtube.com/watch?v=s7EdQ4FqbhY", "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,686,1000_AL_.jpg",Arrays.asList(4,5,1)));
        peliRepository.save(new Pelicula("Deadpool", Categoria.COMEDIA, LocalDate.of(2016, 2, 11), "Un ex mercenario quien, tras haber sido sometido a un cruel experimento adquiere el súper poder de sanar rápidamente, pretende vengarse del hombre que destrozó su vida.", "Tim Miller", "Ryan Reynolds, Morena Baccarin, T.J. Miller", "https://www.youtube.com/watch?v=0JnRdfiUMa8", "https://m.media-amazon.com/images/M/MV5BYzE5MjY1ZDgtMTkyNC00MTMyLThhMjAtZGI5OTE1NzFlZGJjXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg",Arrays.asList(2,5,3)));
        peliRepository.save(new Pelicula("Bohemian Rhapsody", Categoria.DRAMA, LocalDate.now(), "Una crónica de los años previos a la legendaria aparición de Queen en el concierto de Live Aid (1985).", "Bryan Singer", "Rami Malek, Gwilym Lee, Ben Hardy, Joseph Mazzello", "https://www.youtube.com/watch?v=pOYt7PmH_o8", "https://m.media-amazon.com/images/M/MV5BNDg2NjIxMDUyNF5BMl5BanBnXkFtZTgwMzEzNTE1NTM@._V1_SY1000_CR0,0,629,1000_AL_.jpg",Arrays.asList(4,1,1)));
        peliRepository.save(new Pelicula("Operación Overlord", Categoria.ACCION, LocalDate.now().minusDays(5), "Un pequeño grupo de soldados estadounidenses encuentra horror detrás de las líneas enemigas en la víspera del Día D.", "Julius Avery", "Jovan Adepo, Wyatt Russell, Mathilde Ollivier", "https://www.youtube.com/watch?v=oAgsgbh-32s", "https://m.media-amazon.com/images/M/MV5BNzU0NTI1MTU2M15BMl5BanBnXkFtZTgwNTg4MDIzNjM@._V1_SY1000_CR0,0,639,1000_AL_.jpg",Arrays.asList(5,5,3)));
        peliRepository.save(new Pelicula("Nace una estrella", Categoria.DRAMA, LocalDate.now().minusDays(20), "Un músico ayuda a un joven cantante a encontrar la fama, incluso cuando la edad y el alcoholismo envían a su propia carrera a una espiral descendente.", "Bradley Cooper", "Lady Gaga, Bradley Cooper, Sam Elliott", "https://www.youtube.com/watch?v=nSbzyEJ8X9E", "https://m.media-amazon.com/images/M/MV5BMjE3MDQ0MTA3M15BMl5BanBnXkFtZTgwMDMwNDY2NTM@._V1_SY1000_CR0,0,674,1000_AL_.jpg",Arrays.asList(5,5,5)));
        peliRepository.save(new Pelicula("Animales Fantásticos: Los crímenes de Grindelwald", Categoria.FICCION, LocalDate.of(2018, 11, 1), "La segunda entrega de la serie \"Fantastic Beasts\" ambientada en J.K. El mundo mágico de Rowling con las aventuras del magizoólogo Newt Scamander.", "David Yates", "Eddie Redmayne, Katherine Waterston, Dan Fogler", "https://www.youtube.com/watch?v=liHMfhux9M4", "https://m.media-amazon.com/images/M/MV5BMjAxMjM3NjAzM15BMl5BanBnXkFtZTgwNDQxNjA1NjM@._V1_SY1000_CR0,0,674,1000_AL_.jpg",Arrays.asList(1,1,1)));
    }

    public void delete(Integer id) {
        peliRepository.deleteById(id);
    }

    private Pelicula getPeli(Integer id) {
        return peliRepository.findById(id).orElseThrow(() -> new PeliculaInexistenteException(id));
    }

    @GetMapping(value = "/{id}")
    public Pelicula getPelicula(@PathVariable Integer id) {
        return getPeli(id);
    }

    @GetMapping(value = "/find/{title}")
    public Pelicula getPeliculaByTitle(@PathVariable String title) {
        return peliRepository.findByTitulo(title);
    }

    @GetMapping(value = "/category/{categoria}")
    public Iterable<Pelicula> getPeliculasByCategory(@PathVariable String categoria) {
        return peliRepository.findAllByCategoria(Categoria.valueOf(categoria));
    }

    @GetMapping(value = "/activacion/{id}")
    public void cambiarActivacion(@PathVariable Integer id) {
        Pelicula peli = getPeli(id);
        peli.setActiva(!peli.getActiva());
        peliRepository.save(peli);
    }

    @GetMapping(value = "/categories")
    public Iterable<Categoria> getAllCategories() {
        return Arrays.asList(Categoria.values());
    }

    @GetMapping("/")
    public Iterable<Pelicula> getAllPeliculas() {
        return peliRepository.findAll();
    }

    @PostMapping("/pelicula")
    @PutMapping("/pelicula")
    public void savePelicula(@RequestBody Pelicula peli) {
        peliRepository.save(peli);
    }
}
