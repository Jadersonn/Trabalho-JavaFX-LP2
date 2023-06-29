package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable{
	@FXML
	private BorderPane telaInicial;
	//private Stage stage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void clickMenuDepartamento() throws IOException {
		Stage stage = (Stage) this.telaInicial.getScene().getWindow();
		BorderPane bp = new FXMLLoader(getClass().getResource("/views/TelaDepartamento.fxml")).load();
		Scene cena = new Scene(bp);
		stage.setScene(cena);
		stage.show();
		
	}
	
}
