
package controlBD;

import controlDashBoard.Pessoa;
import java.util.ArrayList;
import java.util.List;


public interface PessoaDAO {
  
    public void criar (Pessoa pessoa) throws Exception;
    public List<Pessoa> listarTodos() throws Exception;
    public void alterar (Pessoa pessoa) throws Exception;
    public void excluir (Pessoa pessoa) throws Exception; 
    public Integer varrerPessoa () throws Exception;
}
