package h8.chikey;

import h8.chikey.dao.DAO;
import h8.chikey.daoimpl.AbonentDAOIMPL;
import h8.chikey.model.Abonent;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainConsole {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Abonent, Integer> abonentIntegerDAO = new AbonentDAOIMPL(factory);
////        List<Abonent> abonents = abonentIntegerDAO.readAll();
//
        Abonent read = abonentIntegerDAO.read(1);

        System.out.println(read);



//        abonents.forEach(System.out::println);
    }
}
