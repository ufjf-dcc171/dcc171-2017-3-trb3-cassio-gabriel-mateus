package controlBD;

import controlDashBoard.Project;
import controlDashBoard.Task;
import java.util.List;

public interface TaskDAO {
    public void criar (Task tarefa, Project prod) throws Exception;
    public void buscar (Task tarefa) throws Exception;
    public List<Task> listarTodos() throws Exception;
    public void alterar (Task tarefa, Integer i) throws Exception;
    public void excluir (Task tarefa) throws Exception;
}
