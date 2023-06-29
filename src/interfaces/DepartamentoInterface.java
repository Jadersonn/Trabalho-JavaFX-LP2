package interfaces;
import 	entidades.Departamento;
import 	java.util.List;

public interface DepartamentoInterface {
    void cadastrarDepartamento(Departamento departamento);
    void excluirDepartamento(int id);
    List<Departamento> buscarDepartamento(String nome);
    List<Departamento> listarDepartamentos();
	void atualizarDepartamento(Departamento departamento, int id);
}
