package unq.eis.service.test;

import unq.eis.dao.hibernate.GenericDAOHib;
import unq.eis.service.runner.Runner;

import java.io.Serializable;

public class TestServiceImpl extends GenericDAOHib implements TestService {

    public void save(Object object) {
        Runner.runInSession(() -> {
            super.save(object);
            return null;
        });
    }

    public void upd(Object object) {
        Runner.runInSession(() -> {
            super.upd(object);
            return null;
        });
    }

    public <T> T get(Class<T> tipo, Serializable key) {
        return Runner.runInSession(() -> super.get(tipo, key));
    }

    public <T> T getBy(Class<T> tipo, String param, Serializable value) {
        return Runner.runInSession(() -> super.getBy(tipo, param, value));
    }

    public <T> T getByName(Class<T> tipo, String name) {
        return Runner.runInSession(() -> super.getByName(tipo, name));
    }

    public <T> void delete(Class<T> tipo, Serializable key) {
        Runner.runInSession(() -> {
            super.delete(tipo, key);
            return null;
        });
    }

    public <T> void deleteByName(Class<T> tipo, String nombre) {
        Runner.runInSession(() -> {
            super.deleteByName(tipo, nombre);
            return null;
        });
    }
}
