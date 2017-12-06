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

public class TaskDAOJDBC implements TaskDAO {

    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoLista;
    private PreparedStatement operacaoAlterar0;
    private PreparedStatement operacaoAlterar1;
    private PreparedStatement operacaoAlterar2;
    private PreparedStatement operacaoAlterar3;
    private PreparedStatement operacaoAlterar4;

    public TaskDAOJDBC() {
        try {
            conexao = BdConnection.getConnection();
            operacaoInsere = conexao.prepareStatement("insert into tarefa (nome, descricao, duracao, progresso, fkid_projeto) values"
                    + "(?, ?, ?, ?, ?)");
            operacaoLista = conexao.prepareStatement("select id_tarefa, nome, status, descricao, duracao, progresso, dataInicio, dataFinal, fkid_projeto from tarefa where fkid_projeto = ?");
            operacaoAlterar0 = conexao.prepareStatement("update tarefa set dataInicio=? where id_tarefa=?");
            operacaoAlterar1 = conexao.prepareStatement("update tarefa set dataFinal=? where id_tarefa=?");
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
        while (resultado.next()) {
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
        switch (i) {
            case 0: {
                java.util.Date dataUtil = tarefa.getTaskDateIniBD();
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                operacaoAlterar0.clearParameters();
                operacaoAlterar0.setDate(1, dataSql);
                operacaoAlterar0.setInt(2, tarefa.getNumero_tarefa());
                operacaoAlterar0.executeUpdate();
                break;
            }
            case 1: {
                java.util.Date dataUtil = tarefa.getTaskDateEndBD();
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                operacaoAlterar1.clearParameters();
                operacaoAlterar1.setDate(1, dataSql);
                operacaoAlterar1.setInt(2, tarefa.getNumero_tarefa());
                operacaoAlterar1.executeUpdate();
                break;
            }
            case 2: {
                operacaoAlterar2.clearParameters();
                operacaoAlterar2.setString(1, tarefa.getDescricao());
                operacaoAlterar2.setInt(2, tarefa.getNumero_tarefa());
                operacaoAlterar2.executeUpdate();
                break;
            }
            case 3: {
                operacaoAlterar3.clearParameters();
                operacaoAlterar3.setInt(1, tarefa.getDuracao());
                operacaoAlterar3.setInt(2, tarefa.getNumero_tarefa());
                operacaoAlterar3.executeUpdate();
                break;
            }
            case 4: {
                operacaoAlterar4.clearParameters();
                operacaoAlterar4.setInt(1, tarefa.getProgresso());
                operacaoAlterar4.setInt(2, tarefa.getNumero_tarefa());
                operacaoAlterar4.executeUpdate();
                break;
            }
            
        }
    }

    @Override
    public void excluir(Task tarefa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
