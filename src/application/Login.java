package application;

import com.hoal.controller.LoginController;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;


public class Login extends Application {

	public static Stage rootStage;

	public static Scene scence;

	public static LoginController loginController;


	@Override
	public void start(Stage primaryStage) {
		try {

			//Set up instance instead of using static load() method
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hoal/ui/Login.fxml"));
			Parent root = loader.load();
			//assign controller context
			loginController = (LoginController)loader.getController();
			//assign primaryStage 
			rootStage=primaryStage;
			primaryStage.setTitle("Tool Convert");
			scence=new Scene(root);
			scence.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
			primaryStage.setScene(scence);
			primaryStage.show();
			scence.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					switch (event.getCode()) {
					case ENTER: {
						loginController.onHandleLoginClick();
						System.out.println("enter clicked");
					}
					default:
						break;
					}
				}
			});
			//access LoginControlelr
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}



}
