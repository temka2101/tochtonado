package a.vkube.control;

import a.vkube.dao.DAO;
import a.vkube.daoimpl.ClientDaoImpl;
import a.vkube.model.Client;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.time.LocalDate;

public class MainWindowController {

    ObservableList<Client> clientList = FXCollections.observableArrayList();
    Client client = new Client();

    @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableColumn<Client, Integer> idClient;

    @FXML
    private TableColumn<Client, String> firstName;

    @FXML
    private TableColumn<Client, String> lastName;

    @FXML
    private TableColumn<Client, String> patronymic;

    @FXML
    private TableColumn<Client, LocalDate> birthday;

    @FXML
    private TableColumn<Client, LocalDate> regDate;

    @FXML
    private TableColumn<Client, String> email;

    @FXML
    private TableColumn<Client, String> phone;

    @FXML
    private TableColumn<Client, String> genderCode;

    @FXML
    private TableColumn<Client, String> photoPath;

    @FXML
    private Button closeButton;

    @FXML
    private Button buttonCreate;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonDelete;

    @FXML
    public void initialize(){
        initData();

        clientTable.setItems(clientList);

        idClient.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getClientID()));
        firstName.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getFirstName()));
        lastName.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getLastName()));
        patronymic.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getPatronymic()));
        birthday.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getBirthday()));
        regDate.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getRegistrationDate()));
        email.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getEmail()));
        phone.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getPhone()));
        photoPath.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getPhotoPath()));
        genderCode.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getGender().getName()));
        closeButton.setOnAction(event -> closeButton.getScene().getWindow().hide());
        clientTable.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
            client = newValue;
        });
    }
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public void initData(){
        ClientDaoImpl clientIMPL = new ClientDaoImpl(factory);
        clientList.addAll(clientIMPL.findByAll());
    }
    @FXML
    void onActionCreate(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/createWindow.fxml"));
        stage.setTitle("CREATE");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void onActionDelete(ActionEvent event) {
        client = clientTable.getSelectionModel().getSelectedItem();
        clientTable.getItems().remove(client);
        ClientDaoImpl dao = new ClientDaoImpl(factory);
        dao.delete(client);
    }

    @FXML
    void onActionUpdate(ActionEvent event) {

    }
}