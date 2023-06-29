package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DepartamentoDAO;
import entidades.Departamento;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaDepartamentoController {
	@FXML
	private BorderPane telaDepartamentoRoot;
	@FXML
	private TableView<Departamento> tabela;
	@FXML
	private TableColumn<Departamento,Integer> colunaId;
	@FXML
	private TableColumn<Departamento, String> colunaNome;
	
	public void clickBuscar() throws IOException {
		Stage stage = (Stage) this.telaDepartamentoRoot.getScene().getWindow();
		BorderPane bp = new FXMLLoader(getClass().getResource("/views/TelaBusca.fxml")).load();
		Scene cena = new Scene(bp);
		stage.setScene(cena);
		stage.show();
		
	}
	
	public void clickVoltar() throws IOException {
		Stage stage = (Stage) this.telaDepartamentoRoot.getScene().getWindow();
		BorderPane bp = new FXMLLoader(getClass().getResource("/views/TelaInicial.fxml")).load();
		Scene cena = new Scene(bp);
		stage.setScene(cena);
		stage.show();
	}
	
	public void clickMostrarDepartamentos(){
		DepartamentoDAO dao;
		try {
			dao = new DepartamentoDAO();
			List<Departamento> departamentos = dao.listarDepartamentos();
			colunaId.setCellValueFactory( new PropertyValueFactory<>("id") );
			colunaNome.setCellValueFactory( new PropertyValueFactory<>("nome") );
			
			tabela.setItems( FXCollections.observableArrayList( departamentos ) );
		} catch (SQLException e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("Atenção!");
			a.setContentText("Erro ao carregar banco de dados: " + e.getMessage());
			
			a.show();
		}
		
		
	}
	public void clickCadastrarDepartamento() throws IOException{
		
		Stage stage = new Stage();
		BorderPane bp = new FXMLLoader(getClass().getResource("/views/TelaCadastro.fxml")).load();
		Scene cena = new Scene(bp);
		stage.setScene(cena);
		stage.setAlwaysOnTop(true);
		stage.show();
	}
	
	
	
	public void clickBuscarDepartamento(){
		
	}
}
