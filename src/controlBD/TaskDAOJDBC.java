package controlBD;

import controlDashBoard.Project;
import controlDashBoard.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskDAOJDBC implements TaskDAO{

    private Connection conexao;
    private PreparedStatement operacaoInsere;
    
    public TaskDAOJDBC() {
        try {
            conexao = BdConnection.getConnection();
            operacaoInsere = conexao.prepareStatement("insert into tarefa (nome, descricao, duracao, progresso, fkid_projeto) values"
                    + "(?, ?, ?, ?, ?)");    
        } catch (Exception ex) {
            Logger.getLogger(ProjetoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void criar(Task tarefa, Project prod) throws Exception {
        operacaoInsere.clearParameters();
        operacaoInsere.setString(1, tarefa.getTaskName());
        operacaoInsere.setString(2, tarefa.getDescricao());
        operacaoInsere.setInt(3, tarefa.getDuracao());
        operacaoInsere.setInt(4, tarefa.getProgresso());
        operacaoInsere.setInt(5, tarefa.getId_projeto());
        operacaoInsere.executeUpdate();
    }

    @Override
    public void buscar(Task tarefa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Task> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Task tarefa, Integer i) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Task tarefa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
