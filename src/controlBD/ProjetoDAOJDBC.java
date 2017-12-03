package controlBD;

import controlDashBoard.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjetoDAOJDBC implements ProjetoDAO {

    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoListar;
    
    public ProjetoDAOJDBC() {
        try {
            conexao = BdConnection.getConnection();
            operacaoInsere = conexao.prepareStatement("insert into projeto (nome, descricao) values"
                    + "(?, ?)");
            operacaoListar = conexao.prepareStatement("select nome, descricao, dataInicio, dataFinal from projeto");
        } catch (Exception ex) {
            Logger.getLogger(ProjetoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void criar(Project proj) throws Exception {
        operacaoInsere.clearParameters();
        operacaoInsere.setString(1, proj.getProjectNome());
        operacaoInsere.setString(2, proj.getProjectDescricao());
        operacaoInsere.executeUpdate();
    }

    @Override
    public List<Project> listarTodos() throws Exception {
        List<Project> projeto = new ArrayList<>();
        operacaoListar.clearParameters();
        ResultSet resultado = operacaoListar.executeQuery();
        while (resultado.next())
        {
            Project p = new Project();
            p.setProjectNome(resultado.getString(1));
            p.setProjectDescricao(resultado.getString(2));
            p.setProjectDateIni(resultado.getDate(3));
            p.setProjectDateEnd(resultado.getDate(4));
            projeto.add(p);
        }
        return projeto;
    }

    @Override
    public void excluir(Project prod) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Project produ) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscar(Project prod) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
