package a.vkube.control;

import a.vkube.dao.DAO;
import a.vkube.daoimpl.ClientDaoImpl;
import a.vkube.daoimpl.GenderDaoImpl;
import a.vkube.model.Client;
import a.vkube.model.Gender;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateController {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ClientDaoImpl clientDAO = new ClientDaoImpl(factory);
    GenderDaoImpl genderDAO = new GenderDaoImpl(factory);
    ObservableList<Client> observableList = FXCollections.observableArrayList();
    ObservableList<Gender> genders = FXCollections.observableArrayList();

    @FXML
    private TextField nameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField patronymicText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField phoneText;

    @FXML
    private TextField photoPathText;

    @FXML
    private ComboBox<Gender> genderBox;

    @FXML
    private DatePicker birthdayPicker;

    @FXML
    private DatePicker regDatePicker;

    @FXML
    private Button buttonOk;

    @FXML
    void initialize(){
        observableList.addAll(clientDAO.findByAll());
        genders.addAll(genderDAO.findByAll());
        genderBox.setItems(genders);
    }

    @FXML
    void actionOk(ActionEvent event) {
        Client client = new Client();
                client.setFirstName(nameText.getText());
                client.setLastName(lastNameText.getText());
                client.setPatronymic(patronymicText.getText());
                client.setEmail(emailText.getText());
                client.setPhone(phoneText.getText());
                client.setPhotoPath(photoPathText.getText());
                client.setGender(genderBox.getValue());
                client.setBirthday(birthdayPicker.getValue());
                client.setRegistrationDate(regDatePicker.getValue());

        clientDAO.create(client);
        observableList.addAll(client);
        buttonOk.getScene().getWindow().hide();
    }
}