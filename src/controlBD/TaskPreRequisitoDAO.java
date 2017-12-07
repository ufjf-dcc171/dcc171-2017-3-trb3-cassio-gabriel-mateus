package controlBD;

import controlDashBoard.Pessoa;
import controlDashBoard.Task;
import java.util.List;

public interface TaskPreRequisitoDAO {
    public void associar (Task tarefa, List<Task> preRequisito) throws Exception;
    public void buscar (Task tarefa, List<Task> tarefas) throws Exception;
    public void excluir (Integer id) throws Exception;
}
