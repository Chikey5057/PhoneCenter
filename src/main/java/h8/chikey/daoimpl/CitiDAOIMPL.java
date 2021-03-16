package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Citi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CitiDAOIMPL implements DAO<Citi,Integer> {

    SessionFactory factory;

    public CitiDAOIMPL(SessionFactory factory) {
        this.factory=factory;
    }

    @Override
    public void create(Citi citi) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(citi);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Citi citi) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(citi);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Citi citi) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(citi);
            session.getTransaction().commit();
        }
    }

    @Override
    public Citi read(Integer integer) {
        try(Session session = factory.openSession()){
            return session.get(Citi.class,integer);
        }
    }

    @Override
    public List<Citi> readAll() {
        try(Session session = factory.openSession()){
            return  session.createQuery("FROM Citi").list();
        }
    }
}
