package controlBD;

import controlDashBoard.Pessoa;
import controlDashBoard.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskPreRequisitoDAOJDBC implements TaskPreRequisitoDAO{

    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoBuscar;
    private PreparedStatement operacaoExcluir;
    private PreparedStatement operacaoPresenca;

    public TaskPreRequisitoDAOJDBC() {
         try {
            conexao = BdConnection.getConnection();
            operacaoInsere = conexao.prepareStatement("insert into prerequisito (fkid_tarefa, fkid_tarefaPreRequisito) values (?, ?)");       
            operacaoBuscar = conexao.prepareStatement("select fkid_tarefaPreRequisito from prerequisito where fkid_tarefa = ?");
            operacaoExcluir = conexao.prepareStatement("delete from prerequisito where fkid_tarefa=?");
            operacaoPresenca = conexao.prepareStatement("select * from Tarefa_pessoa where fkid_pessoa = ?");
         } catch (Exception ex) {
            Logger.getLogger(ProjetoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void associar(Task tarefa, List<Task> preRequisito) throws Exception {
        if (preRequisito.size() >= 1)
        {
            for (Task t : preRequisito)
            {
                operacaoInsere.clearParameters();
                operacaoInsere.setInt(1, tarefa.getNumero_tarefa());
                operacaoInsere.setInt(2, t.getNumero_tarefa());
                operacaoInsere.executeUpdate();
            }
        }
        else
        {
            
        }
    }

    @Override
    public void buscar(Task tarefa, List<Task> tarefas) throws Exception {
        ArrayList<Task> tarefaPreRequisito = new ArrayList<>();
        operacaoBuscar.clearParameters();
        operacaoBuscar.setInt(1, tarefa.getNumero_tarefa());
        ResultSet resultado = operacaoBuscar.executeQuery();
        while (resultado.next())
        {
            int i = resultado.getInt(1);
            for (Task t : tarefas)
            {
                if (i == t.getNumero_tarefa())
                {
                    tarefaPreRequisito.add(t);
                }
            }
        }
        tarefa.setPreRequisito(tarefaPreRequisito);
    }

    @Override
    public void excluir(Integer id) throws Exception {
        operacaoExcluir.clearParameters();
        operacaoExcluir.setInt(1, id);
        operacaoExcluir.executeUpdate();
    }

    @Override
    public Boolean preesnca(Task t) throws Exception {
        Boolean presenca = false;
        operacaoPresenca.clearParameters();
        operacaoPresenca.setInt(1, t.getNumero_tarefa());
        ResultSet resultado = operacaoPresenca.executeQuery();
        while (resultado.next())
        {
            presenca = true;
        }
        return presenca;
    }
    
}
