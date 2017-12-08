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
    private PreparedStatement operacaoAlterar;
    private PreparedStatement operacaoAlterar2;
    private PreparedStatement operacaoExcluir;
    private PreparedStatement operacaoVarrerProjeto;

    public PessoaDAOJDBC() {
     
        try {
            try {
                conexao = BdConnection.getConnection();
                operacaoInserePessoas = conexao.prepareStatement("insert into pessoa (pesnome, pesmail) values"
                        + "(?,?)");
                operacaoListar = conexao.prepareStatement("select pesid, pesnome, pesmail from pessoa");
                operacaoAlterar = conexao.prepareStatement("update pessoa set PESNOME=? where PESID = ?");
                operacaoAlterar2 = conexao.prepareStatement("update pessoa set PESMAIL=? where PESID = ?");
                operacaoExcluir = conexao.prepareStatement("delete from pessoa where PESID = ?");
                operacaoVarrerProjeto = conexao.prepareStatement("select PESID from pessoa");
            } catch (Exception ex) {
                Logger.getLogger(PessoaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProjetoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void criar(Pessoa pessoa) throws Exception {
        operacaoInserePessoas.clearParameters();
        operacaoInserePessoas.setString(1, pessoa.getPesNome());
        operacaoInserePessoas.setString(2, pessoa.getPesEmail());
        operacaoInserePessoas.executeUpdate();
    }

    @Override
    public List<Pessoa> listarTodos() throws Exception {
        List<Pessoa> pessoas = new ArrayList<>();
        operacaoListar.clearParameters();
        ResultSet resultado = operacaoListar.executeQuery();
        while (resultado.next()) {
            Pessoa p = new Pessoa();
            p.setPesId(resultado.getInt(1));
            p.setPesNome(resultado.getString(2));
            p.setPesEmail(resultado.getString(3));
            pessoas.add(p);
        }
        return pessoas;
    }

    @Override
    public void alterar(Pessoa pessoa) throws Exception {
        operacaoAlterar.clearParameters();
        operacaoAlterar2.clearParameters();
        operacaoAlterar.setString(1, pessoa.getPesNome());
        operacaoAlterar.setInt(2, pessoa.getPesId());
        operacaoAlterar.executeUpdate();
        operacaoAlterar2.setString(1, pessoa.getPesEmail());
        operacaoAlterar2.setInt(2, pessoa.getPesId());
        operacaoAlterar2.executeUpdate();
    }

    @Override
    public void excluir(Pessoa pessoa) throws Exception {
        operacaoExcluir.clearParameters();
        operacaoExcluir.setInt(1, pessoa.getPesId());
        operacaoExcluir.execute();
    }

    @Override
    public Integer varrerPessoa() throws Exception {
        Integer i = 0;
        ResultSet resultado = operacaoVarrerProjeto.executeQuery();
        while (resultado.next())
        {
            i = resultado.getInt(1);
        }
        return i;   
    }

}
