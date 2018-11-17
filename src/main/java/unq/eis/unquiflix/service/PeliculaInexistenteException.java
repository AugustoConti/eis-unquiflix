package unq.eis.unquiflix.service;

public class PeliculaInexistenteException extends RuntimeException {
    public PeliculaInexistenteException(Integer id) {
        super("Inexistente pelicula con ID: " + id.toString());
    }
}
