package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import DAO.DepartamentoDAO;
import entidades.Departamento;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaBuscaController {

	@FXML
	private BorderPane telaBuscaRoot;
	@FXML
	private TableView<Departamento> tabela;
	@FXML
	private TableColumn<Departamento,Integer> colunaId;
	@FXML
	private TableColumn<Departamento, String> colunaNome;
	@FXML
	private TextField textFieldBuscaDepartamento;
	
	public void buscarDepartamento() {
		String nomeDepartamento = textFieldBuscaDepartamento.getText().trim();
		DepartamentoDAO dao;
		try {
			
			dao = new DepartamentoDAO();
			List<Departamento> departamentos = dao.buscarDepartamento(nomeDepartamento);
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
	
	public void clickVoltar() throws IOException {
		Stage stage = (Stage) this.telaBuscaRoot.getScene().getWindow();
		BorderPane bp = new FXMLLoader(getClass().getResource("/views/TelaDepartamento.fxml")).load();
		Scene cena = new Scene(bp);
		stage.setScene(cena);
		stage.show();
	}
	
	
}
