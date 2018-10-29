package unq.eis.unquiflix.repository;

import org.springframework.data.repository.CrudRepository;
import unq.eis.unquiflix.model.Categoria;
import unq.eis.unquiflix.model.Pelicula;

public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {
    Pelicula findByTitulo(String titulo);
    Iterable<Pelicula> findAllByCategoria(Categoria categoria);
}
