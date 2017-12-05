package controlBD;

import controlDashBoard.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskPreRequisitoDAOJDBC implements TaskPreRequisitoDAO{

    private Connection conexao;
    private PreparedStatement operacaoInsere;

    public TaskPreRequisitoDAOJDBC() {
         try {
            conexao = BdConnection.getConnection();
            operacaoInsere = conexao.prepareStatement("insert into prerequisito (fkid_tarefa, fkid_tarefaPreRequisito) values (?, ?)");
            } catch (Exception ex) {
            Logger.getLogger(ProjetoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void associar(Task tarefa, Task preRequisito) throws Exception {
        operacaoInsere.clearParameters();
        operacaoInsere.setInt(1, tarefa.getNumero_tarefa());
        operacaoInsere.setInt(2, preRequisito.getNumero_tarefa());
        operacaoInsere.executeUpdate();
    }
    
}
