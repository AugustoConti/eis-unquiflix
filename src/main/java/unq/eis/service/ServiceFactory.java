package unq.eis.service;

import unq.eis.dao.hibernate.GenericDAOHib;
import unq.eis.service.pelicula.PeliculaService;
import unq.eis.service.pelicula.PeliculaServiceImpl;
import unq.eis.service.test.TestService;
import unq.eis.service.test.TestServiceImpl;

public class ServiceFactory {
    public static TestService getTestService() {
        return new TestServiceImpl();
    }

    public static PeliculaService getPeliculaService() {
        return new PeliculaServiceImpl(new GenericDAOHib());
    }
}
