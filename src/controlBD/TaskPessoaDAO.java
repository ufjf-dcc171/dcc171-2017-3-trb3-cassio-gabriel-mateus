//TaskPessoaDAO

package controlBD;

import controlDashBoard.Task;
import controlDashBoard.Pessoa;
import java.util.ArrayList;
import java.util.List;

public interface TaskDAO {
    public void associar (Task tarefa, Pessoa Pessoa) throws Exception;
       
}
