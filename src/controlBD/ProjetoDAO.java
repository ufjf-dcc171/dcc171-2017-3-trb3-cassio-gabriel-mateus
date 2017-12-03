package controlBD;

import controlDashBoard.Project;
import java.util.List;

public interface ProjetoDAO {
    public void criar (Project prod) throws Exception;
    public void buscar (Project prod) throws Exception;
    public List<Project> listarTodos() throws Exception;
    public void alterar (Project produ, Integer i) throws Exception;
    public void excluir (Project prod) throws Exception;
}
