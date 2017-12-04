package controlBD;

import controlDashBoard.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAOJDBC implements PessoaDAO {


    private Connection conexao;
    private PreparedStatement operacaoInserePessoas;
    private PreparedStatement operacaoListar;
   

    public PessoaDAOJDBC() {

        
        /*mateus verifica isso pra mim, nao sei porque esta dando um erro ao gerarm talvez resolva fazendo como voce fez nas tarefas*/
        try {
            try {
                conexao = BdConnection.getConnection();
                operacaoInserePessoas = conexao.prepareStatement("insert into pessoas (pescod,pesnome, pesmail) values"
                        + "(?,?)");
                operacaoListar = conexao.prepareStatement("select pesnome, pesmail from pessoas");
               
            } catch (Exception ex) {
                Logger.getLogger(PessoaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProjetoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    /*#VERIFICAR*/
    public void criar(Pessoa pessoa) throws Exception {
        operacaoInserePessoas.setString(2, pessoa.getPesNome());
        operacaoInserePessoas.setString(3, pessoa.getPesEmail());
        operacaoInserePessoas.executeUpdate();
    }

    public List<Pessoa> listarTodos() throws Exception {
        List<Pessoa> pessoas = new ArrayList<>();
        operacaoListar.clearParameters();
        ResultSet resultado = operacaoListar.executeQuery();
        while (resultado.next()) {
            Pessoa p = new Pessoa();
            p.setPesNome(resultado.getString(1));
            p.setPesEmail(resultado.getString(2));
            pessoas.add(p);
        }
        return pessoas;
    }

}
