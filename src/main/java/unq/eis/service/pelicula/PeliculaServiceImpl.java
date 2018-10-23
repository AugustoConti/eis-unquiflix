package unq.eis.service.pelicula;

import unq.eis.dao.GenericDAO;
import unq.eis.model.Pelicula;
import unq.eis.service.runner.Runner;

public class PeliculaServiceImpl implements PeliculaService {

    private GenericDAO genericDAO;

    public PeliculaServiceImpl(GenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    @Override
    public Pelicula buscar(String titulo) {
        return Runner.runInSession(() -> genericDAO.getBy(Pelicula.class, "titulo", titulo));
    }
}
