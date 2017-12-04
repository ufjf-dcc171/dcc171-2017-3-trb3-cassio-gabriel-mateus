
package controlBD;

import controlDashBoard.Pessoa;
import java.util.List;


public interface PessoaDAO {
  
    public void criar (Pessoa pessoa) throws Exception;
    public List<Pessoa> listarTodos() throws Exception;
    
}
