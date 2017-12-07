package controlBD;

import controlDashBoard.Project;
import controlDashBoard.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private PreparedStatement operacaoAlterar5;
    private PreparedStatement operacaoExcluir;
    private PreparedStatement operacaoVarrerTarefa;

    public TaskDAOJDBC() {
        try {
            conexao = BdConnection.getConnection();
            operacaoInsere = conexao.prepareStatement("insert into tarefa (nome, status, descricao, duracao, progresso, fkid_projeto) values"
                    + "(?, ?, ?, ?, ?, ?)");
            operacaoLista = conexao.prepareStatement("select id_tarefa, nome, status, descricao, duracao, progresso, dataInicio, dataFinal, fkid_projeto from tarefa where fkid_projeto = ?");
            operacaoAlterar0 = conexao.prepareStatement("update tarefa set dataInicio=? where id_tarefa=?");
            operacaoAlterar1 = conexao.prepareStatement("update tarefa set dataFinal=? where id_tarefa=?");
            operacaoAlterar2 = conexao.prepareStatement("update tarefa set descricao=? where id_tarefa=?");
            operacaoAlterar3 = conexao.prepareStatement("update tarefa set duracao=? where id_tarefa=?");
            operacaoAlterar4 = conexao.prepareStatement("update tarefa set progresso=? where id_tarefa=?");
            operacaoAlterar5 = conexao.prepareStatement("update tarefa set status=? where id_tarefa=?");
            operacaoExcluir = conexao.prepareStatement("delete from tarefa where id_tarefa = ?");
            operacaoVarrerTarefa = conexao.prepareStatement("select id_tarefa from tarefa");
        } catch (Exception ex) {
            Logger.getLogger(ProjetoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void criar(Task tarefa, Project prod) throws Exception {
        tarefa.setId_projeto(prod.getId());
        operacaoInsere.clearParameters();
        operacaoInsere.setString(1, tarefa.getTaskName());
        operacaoInsere.setString(2, tarefa.getStatus());
        operacaoInsere.setString(3, tarefa.getDescricao());
        operacaoInsere.setInt(4, tarefa.getDuracao());
        operacaoInsere.setInt(5, tarefa.getProgresso());
        operacaoInsere.setInt(6, tarefa.getId_projeto());
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
            case 5:
            {
                operacaoAlterar5.clearParameters();
                operacaoAlterar5.setString(1, tarefa.getStatus());
                operacaoAlterar5.setInt(2, tarefa.getNumero_tarefa());
                operacaoAlterar5.executeUpdate();
                break;
            }
            
        }
    }

    @Override
    public void excluir(Task tarefa) throws Exception {
        operacaoExcluir.clearParameters();
        System.out.println(tarefa.getNumero_tarefa());
        operacaoExcluir.setInt(1, tarefa.getNumero_tarefa());
        operacaoExcluir.executeUpdate();
    }

    @Override
    public Integer varrerTarefa() throws SQLException{
        Integer i = 0;
        ResultSet resultado = operacaoVarrerTarefa.executeQuery();
        while (resultado.next())
        {
            i = resultado.getInt(1);
        }
        return i;    
    }

}
