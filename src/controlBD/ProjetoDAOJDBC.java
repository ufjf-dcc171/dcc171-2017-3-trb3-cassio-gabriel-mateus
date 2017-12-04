package controlBD;

import controlDashBoard.Project;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjetoDAOJDBC implements ProjetoDAO {

    private Integer contadorDeProjetos = 0;
    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoAlterar0;
    private PreparedStatement operacaoAlterar1;
    private PreparedStatement operacaoAlterar2;
    
    public ProjetoDAOJDBC() {
        try {
            conexao = BdConnection.getConnection();
            operacaoInsere = conexao.prepareStatement("insert into projeto (nome, descricao) values"
                    + "(?, ?)");
            operacaoListar = conexao.prepareStatement("select id_projeto, nome, descricao, dataInicio, dataFinal from projeto");
            operacaoAlterar0 = conexao.prepareStatement("update projeto set dataInicio=? where id_projeto=?");
            operacaoAlterar1 = conexao.prepareStatement("update projeto set dataFinal=? where id_projeto=?");
            operacaoAlterar2 = conexao.prepareStatement("update projeto set descricao=? where id_projeto=? ");
        } catch (Exception ex) {
            Logger.getLogger(ProjetoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void criar(Project proj) throws Exception {
        proj.setId(contadorDeProjetos);
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
            contadorDeProjetos++;
            Project p = new Project();
            p.setId(resultado.getInt(1));
            p.setProjectNome(resultado.getString(2));
            p.setProjectDescricao(resultado.getString(3));
            p.setProjectDateIni(resultado.getDate(4));
            p.setProjectDateEnd(resultado.getDate(5));
            projeto.add(p);
        }
        return projeto;
    }

    @Override
    public void excluir(Project prod) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscar(Project prod) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Project produ, Integer i) throws Exception {
        switch (i)
        {
            case 0:
            {
                java.util.Date dataUtil = produ.getProjectDateIniBD();
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                operacaoAlterar0.clearParameters();
                operacaoAlterar0.setDate(1, dataSql);
                operacaoAlterar0.setInt(2, produ.getId());
                operacaoAlterar0.executeUpdate();
                break;
            }
            case 1:
            {
                java.util.Date dataUtil = produ.getProjectDateEndBD();
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                operacaoAlterar1.clearParameters();
                operacaoAlterar1.setDate(1, dataSql);
                operacaoAlterar1.setInt(2, produ.getId());
                operacaoAlterar1.executeUpdate();
                break;
            }
            case 2:
            {
                operacaoAlterar2.clearParameters();
                operacaoAlterar2.setString(1, produ.getProjectDescricao());
                operacaoAlterar2.setInt(2, produ.getId());
                operacaoAlterar2.executeUpdate();
                break;
            }
        }
    }
    
}
