package controlBD;

import controlDashBoard.Pessoa;
import controlDashBoard.Project;
import controlDashBoard.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskPessoaDAOJDBC implements TaskPessoaDAO{

    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoBuscar;
    private PreparedStatement operacaoExcluir;
    private PreparedStatement operacaoPresenca;
    
    public TaskPessoaDAOJDBC() {
        try {
            conexao = BdConnection.getConnection();
            operacaoInsere = conexao.prepareStatement("insert into Tarefa_pessoa (fkid_pessoa, fkid_tarefa) values"
                    + "(?, ?)");
            operacaoBuscar = conexao.prepareStatement("select fkid_pessoa from tarefa_pessoa where fkid_tarefa = ?");
            operacaoExcluir = conexao.prepareStatement("delete from Tarefa_pessoa where  fkid_tarefa= ?");
            operacaoPresenca = conexao.prepareStatement("select * from prerequisito where fkid_tarefaprerequisito = ?");
        } catch (Exception ex) {
            Logger.getLogger(ProjetoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void associar(Task tarefa, List<Pessoa> pessoa) throws Exception {
        if (pessoa.size() >= 1)
        {
            for (Pessoa p: pessoa)
            {
                operacaoInsere.clearParameters();
                System.out.println(p.getPesId());
                operacaoInsere.setInt(1, p.getPesId());
                System.out.println(tarefa.getNumero_tarefa());
                operacaoInsere.setInt(2, tarefa.getNumero_tarefa());
                operacaoInsere.executeUpdate();
            }
        }
    }

    @Override
    public void buscar(Task tarefa, List<Pessoa> pessoas) throws Exception {
        ArrayList<Pessoa> pTarefa = new ArrayList<>();
        operacaoBuscar.clearParameters();
        operacaoBuscar.setInt(1, tarefa.getNumero_tarefa());
        ResultSet resultado = operacaoBuscar.executeQuery();
        while (resultado.next())
        {
            int i = resultado.getInt(1);
            for (Pessoa p : pessoas)
            {
                if (i == p.getPesId())
                {
                    pTarefa.add(p);
                }
            }
        }
        tarefa.setPessoa(pTarefa);
    }

    @Override
    public void excluir(Integer i) throws Exception {
        operacaoExcluir.clearParameters();
        operacaoExcluir.setInt(1,i);
        operacaoExcluir.executeUpdate();
    }

    @Override
    public boolean presenca(Pessoa p) throws Exception {
        Boolean presenca = false;
        operacaoPresenca.clearParameters();
        operacaoPresenca.setInt(1, p.getPesId());
        ResultSet resultado = operacaoPresenca.executeQuery();
        while (resultado.next())
        {
            presenca = true;
        }
        return presenca;
    }
}
