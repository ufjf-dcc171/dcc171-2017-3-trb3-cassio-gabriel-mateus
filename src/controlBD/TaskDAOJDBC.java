package controlBD;

import controlDashBoard.Project;
import controlDashBoard.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskDAOJDBC implements TaskDAO{

    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoLista;
    
    public TaskDAOJDBC() {
        try {
            conexao = BdConnection.getConnection();
            operacaoInsere = conexao.prepareStatement("insert into tarefa (nome, descricao, duracao, progresso, fkid_projeto) values"
                    + "(?, ?, ?, ?, ?)");
            operacaoLista = conexao.prepareStatement("select id_tarefa, nome, status, descricao, duracao, progresso, dataInicio, dataFinal, fkid_projeto from tarefa where fkid_projeto = ?");
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
    public ArrayList<Task> listarTodos(Integer id) throws Exception {
        ArrayList<Task> tarefa = new ArrayList<>();
        operacaoLista.clearParameters();
        operacaoLista.setInt(1, id);
        ResultSet resultado = operacaoLista.executeQuery();
        while (resultado.next())
        {
            Task t = new Task();
            t.setNumero_tarefa(resultado.getInt(1));
            t.setTaskName(resultado.getString(2));
            t.setStatus(resultado.getString(3));
            t.setDescricao(resultado.getString(4));
            t.setDuracao(resultado.getInt(5));
            t.setProgresso(resultado.getInt(6));
            t.setTaskDateIni(resultado.getDate(7));
            t.setTaskDateEnd(resultado.getDate(8));
            t.setId_projeto(resultado.getInt(9));
            tarefa.add(t);
        }
        return tarefa;
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
