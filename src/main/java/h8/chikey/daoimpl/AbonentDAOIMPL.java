package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Abonent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.util.List;

public class AbonentDAOIMPL implements DAO<Abonent, Integer> {

    SessionFactory factory;

    public AbonentDAOIMPL(SessionFactory factory) {
        this.factory=factory;
    }

    public void create(Abonent abonent) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(abonent);
            session.getTransaction().commit();
        }
    }
    public void update(Abonent abonent) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(abonent);
            session.getTransaction().commit();
        }
    }
    public void delete(Abonent abonent) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(abonent);
            session.getTransaction().commit();
        }
    }

    public Abonent read(Integer integer) {
        try(Session session = factory.openSession()){
            return session.get(Abonent.class, integer);
        }
    }

    public List<Abonent> readAll() {
        try(Session session = factory.openSession()) {
            Query<Abonent> query = session.createQuery("FROM Abonent");
            return query.list();
        }
    }
}
