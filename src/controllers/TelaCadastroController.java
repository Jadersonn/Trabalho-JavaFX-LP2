package controllers;

import java.io.IOException;
import java.sql.SQLException;

import DAO.DepartamentoDAO;
import entidades.Departamento;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class TelaCadastroController {
	@FXML
	private TextField textFieldDepartamento;
	@FXML
	private BorderPane telaCadastroRoot;
		
	public void salvarDepartamento(){
			
			String nomeDepartamento = textFieldDepartamento.getText().trim();
			Departamento departamento = new Departamento(nomeDepartamento);
			DepartamentoDAO dao;
			try {
				dao = new DepartamentoDAO();
				dao.cadastrarDepartamento(departamento);
				((Stage) telaCadastroRoot.getScene().getWindow()).close();
				
				
			} catch (SQLException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Atenção!");
				a.setContentText("Houve um erro no banco de Dados: " + e.getMessage());
				a.show();
			}
			
		}
	
	public void clickVoltar() throws IOException {
		((Stage) telaCadastroRoot.getScene().getWindow()).close();
	}
	}

