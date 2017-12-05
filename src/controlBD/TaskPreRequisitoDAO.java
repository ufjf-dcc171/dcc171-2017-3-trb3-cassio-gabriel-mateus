package controlBD;

import controlDashBoard.Pessoa;
import controlDashBoard.Task;

public interface TaskPreRequisitoDAO {
    public void associar (Task tarefa, Task preRequisito) throws Exception;
    
}
