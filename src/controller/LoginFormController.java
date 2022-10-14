package controller;

import dao.LoginDao;
import dto.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public TextField usernameTxt;
    public TextField passwordTxt;
    public AnchorPane context;

    public void login(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        String username=usernameTxt.getText();
        String password=passwordTxt.getText();

        LoginDTO loginDTO=new LoginDTO(); // DTO Means - data transfer object
        loginDTO.setUsername(username);
        loginDTO.setPassword(password);


        LoginDao loginDao=new LoginDao();
        String dbPassword= loginDao.login(loginDTO);

        if (password.equals(dbPassword)){
            // redirect next ui
            setUi("Dashboard");
        }else {
            // error
        }


    }

    public void setUi(String location) throws IOException {
        context.getChildren().clear();// clear the children User interface
        context.getChildren().add(FXMLLoader.
                load(this.getClass().
                        getResource("../view/" + location + ".fxml")));
    }

}
