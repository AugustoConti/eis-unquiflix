package unq.eis.dao.hibernate;

import org.hibernate.query.Query;
import unq.eis.dao.GenericDAO;
import unq.eis.service.runner.Runner;

import java.io.Serializable;

public class GenericDAOHib implements GenericDAO {
    @Override
    public void save(Object object) {
        Runner.getCurrentSession().save(object);
    }

    @Override
    public void upd(Object object) {
        Runner.getCurrentSession().update(object);
    }

    @Override
    public <T> T get(Class<T> tipo, Serializable key) {
        return Runner.getCurrentSession().get(tipo, key);
    }

    @Override
    public <T> T getBy(Class<T> tipo, String param, Serializable value) {
        String hq1 = String.format("from %s i where i.%s = :val", tipo.getName(), param);
        Query<T> query = Runner.getCurrentSession().createQuery(hq1, tipo);
        query.setParameter("val", value);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    @Override
    public <T> T getByName(Class<T> tipo, String name) {
        return this.getBy(tipo, "nombre", name);
    }

    @Override
    public <T> void delete(Class<T> tipo, Serializable key) {
        Runner.getCurrentSession().delete(this.get(tipo, key));
    }

    @Override
    public <T> void deleteByName(Class<T> tipo, String name) {
        Runner.getCurrentSession().delete(this.getByName(tipo, name));
    }
}
