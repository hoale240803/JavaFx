package com.hoal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Login;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;

public class LoginController implements Initializable, EventHandler<KeyEvent> {

	@FXML
	private Button loginBtn;

	@FXML
	private TextField emailTxt;

	@FXML
	private Label loginLabel;

	@FXML
	private PasswordField passwordTxt;

	@FXML
	void onLoginClick(ActionEvent event) {
		onHandleLoginClick();
	}
	

	public void onHandleLoginClick(){
		String username=emailTxt.getText();
		String password=passwordTxt.getText();
		
		if(username.isEmpty()|| password.isEmpty()) {
			Alert a=new Alert(AlertType.ERROR);
			a.setContentText("Email or Password not allowed empty. Please try again!");
			a.show();
			return;
		}
		boolean emailPasswordFlag=validEmailPassword(username, password);
		if(emailPasswordFlag) {
//			Alert a=new Alert(AlertType.INFORMATION);
//			a.setContentText("clicked");
//			a.show();
			
			try {
				// new window
				Parent root = FXMLLoader.load(getClass()
						.getResource("/com/hoal/ui/Admin.fxml"));				
				Stage stage= new Stage();
				stage.setTitle("Admin Dashboard");
				Scene scene=new Scene(root);
				stage.setScene(scene);
				stage.show();
				stage.setMinHeight(750);
				stage.setMinWidth(1200);
				
				System.out.println(stage.getHeight()+":"+stage.getWidth());

				Login.rootStage.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			Alert a=new Alert(AlertType.ERROR);
			a.setContentText("Email or Password not true. Please try again!");
			a.show();
			return;
		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub


	}
	public boolean validEmailPassword(String email, String password) {
		boolean emailFlag,passwordFlag;
		if(email.contains("admin") || email.contains("manager")|| email.contains("user")) {
			emailFlag=true;
		}else {
			emailFlag=false;
		}
		if(password.length()<4) {
			passwordFlag=false;
		}else {
			passwordFlag=true;
		}
		if(emailFlag==true && passwordFlag==true) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void handle(KeyEvent event) {
		switch (event.getCode()) {
		case SPACE:{
//			onHandleLoginClick();
			System.out.println("enter clicked");
		}
		default:
			break;
			
		}
		
	}
}
