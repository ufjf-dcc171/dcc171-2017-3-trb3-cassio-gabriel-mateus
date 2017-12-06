package controlBD;

import controlDashBoard.Pessoa;
import controlDashBoard.Task;
import java.util.List;

public interface TaskPreRequisitoDAO {
    public void associar (Task tarefa, Task preRequisito) throws Exception;
    public void buscar (Task tarefa, List<Task> tarefas) throws Exception;
}
