package h8.chikey.controller;

import h8.chikey.dao.DAO;
import h8.chikey.daoimpl.AbonentDAOIMPL;
import h8.chikey.daoimpl.CitiDAOIMPL;
import h8.chikey.model.Abonent;
import h8.chikey.model.Citi;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainWindowContraller {

    @FXML
    private TableView<Abonent> tableAbonent;

    @FXML
    private TableColumn<Abonent, String> columnPhone;

    @FXML
    private TableColumn<Abonent, Integer> columnInn;

    @FXML
    private TableView<Citi> tableCiti;

    @FXML
    private TableColumn<Citi, String> columnName;

    @FXML
    private TableColumn<Citi, Integer> columnDay;

    @FXML
    private TableColumn<Citi, Integer> columnNight;

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    ObservableList<Abonent> listAbonent = FXCollections.observableArrayList();
//    ObservableList<Citi> listCiti = FXCollections.observableArrayList();

    @FXML
    void  initialize(){
        DAO<Abonent,Integer> daoAbonent = new AbonentDAOIMPL(factory);
//        DAO<Citi,Integer> daoCiti = new CitiDAOIMPL(factory);
        List<Abonent> abonentslist = daoAbonent.readAll();

        listAbonent.addAll(abonentslist);


        columnPhone.setCellValueFactory(abonentStringCellDataFeatures -> new SimpleObjectProperty<String>(abonentStringCellDataFeatures.getValue().getPhone()));
        columnInn.setCellValueFactory(abonentStringCellDataFeatures -> new SimpleObjectProperty<Integer>(abonentStringCellDataFeatures.getValue().getInn()));
        tableAbonent.setItems(listAbonent);





    }

}