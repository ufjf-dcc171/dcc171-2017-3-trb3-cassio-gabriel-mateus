//TaskPessoaDAO

package controlBD;

import controlDashBoard.Task;
import controlDashBoard.Pessoa;
import java.util.ArrayList;
import java.util.List;

public interface TaskPessoaDAO {
    public void associar (Task tarefa, Pessoa Pessoa) throws Exception;
    public void buscar (Task tarefa, List<Pessoa> pessoas) throws Exception;
    public void excluir (Integer i) throws Exception;
}
