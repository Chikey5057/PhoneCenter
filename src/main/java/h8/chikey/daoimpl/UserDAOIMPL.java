package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAOIMPL implements DAO<User,Integer> {
    SessionFactory factory;


    @Override
    public void create(User user) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(User user) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(User user) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public User read(Integer integer) {
        try(Session session = factory.openSession()){
            return  session.get(User.class,integer);
        }
    }

    @Override
    public List<User> readAll() {
        try(Session session = factory.openSession()){
            return  session.createQuery("FROM User").list();
        }
    }
}
