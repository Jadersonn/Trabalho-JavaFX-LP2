package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import interfaces.DepartamentoInterface;
import entidades.Departamento;

public class DepartamentoDAO implements DepartamentoInterface {
private Connection connection;

public DepartamentoDAO() throws SQLException {
    this.connection = ConnectionFactory.getConexao();
}

@Override
public void cadastrarDepartamento(Departamento departamento) {
    String sql = "INSERT INTO departamento (id, nome) VALUES (?, ?)";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, departamento.getId());
        statement.setString(2, departamento.getNome());

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public void atualizarDepartamento(Departamento departamento, int id) {
    String sql = "UPDATE departamento SET nome = ? WHERE id = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, departamento.getNome());
        statement.setInt(2, id);

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public void excluirDepartamento(int id) {
    String sql = "DELETE FROM departamento WHERE id = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public List<Departamento> buscarDepartamento(String nome) {
    String sql = "SELECT * FROM departamento WHERE nome = ?";
    
    List<Departamento> departamentos = new ArrayList<>();
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
    	statement.setString(1, nome);
    	ResultSet resultSet = statement.executeQuery(); // Correção aqui: use executeQuery() em vez de executeUpdate()

        while (resultSet.next()) {
            int departamentoId = resultSet.getInt("id");
            String nome1 = resultSet.getString("nome");
            Departamento departamento = new Departamento(departamentoId, nome1);
            departamentos.add(departamento);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return departamentos;
}


@Override
public List<Departamento> listarDepartamentos() {
    List<Departamento> departamentos = new ArrayList<>();

    String sql = "SELECT * FROM departamento";

    try (Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");

            Departamento departamento = new Departamento(id, nome);
            departamentos.add(departamento);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return departamentos;
}

}