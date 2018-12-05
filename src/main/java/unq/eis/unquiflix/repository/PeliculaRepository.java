package unq.eis.unquiflix.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import unq.eis.unquiflix.model.Categoria;
import unq.eis.unquiflix.model.Pelicula;

public interface PeliculaRepository extends PagingAndSortingRepository<Pelicula, Integer> {
    Pelicula findByTitulo(String titulo);

    Iterable<Pelicula> findAllByCategoria(Categoria categoria);
}
