package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Phonecall implements DAO<Phonecall,Integer> {
    SessionFactory factory;
    @Override
    public void create(Phonecall phonecall) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(phonecall);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Phonecall phonecall) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(phonecall);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Phonecall phonecall) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(phonecall);
            session.getTransaction().commit();
        }
    }

    @Override
    public Phonecall read(Integer integer) {
        try(Session session = factory.openSession()){
            return  session.get(Phonecall.class,integer);
        }
    }

    @Override
    public List<Phonecall> readAll() {
        try(Session session = factory.openSession()){
            return  session.createQuery("FROM Phonecall").list();
        }
    }
}
