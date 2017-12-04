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

public class TaskDAOJDBC implements TaskPessoaDAO{

    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoLista;
    
    public TaskDAOJDBC() {
        try {
            conexao = BdConnection.getConnection();
            operacaoInsere = conexao.prepareStatement("insert into Tarefa_pessoa (id_pessoa, id_tarefa) values"
                    + "(?, ?, ?, ?, ?)");
    //        operacaoLista = conexao.prepareStatement("select id_tarefa, nome, descricao, duracao, progresso, dataInicio, dataFinal, fkid_projeto from tarefa where fkid_projeto = ?");
        } catch (Exception ex) {
            Logger.getLogger(ProjetoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void associar(Task tarefa, Pessoa pessoa) throws Exception {
        operacaoInsere.clearParameters();
        operacaoInsere.setString(1, pessoa.getPesId());
        operacaoInsere.setString(2, tarefa.getNumero());
        operacaoInsere.executeUpdate();
    }

   
}
