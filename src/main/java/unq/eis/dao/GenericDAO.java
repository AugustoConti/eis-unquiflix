package unq.eis.dao;

import java.io.Serializable;

public interface GenericDAO {

    void save(Object object);

    void upd(Object object);

    <T> T get(Class<T> tipo, Serializable key);

    <T> T getBy(Class<T> tipo, String param, Serializable value);

    <T> T getByName(Class<T> tipo, String name);

    <T> void delete(Class<T> tipo, Serializable key);

    <T> void deleteByName(Class<T> tipo, String name);
}
