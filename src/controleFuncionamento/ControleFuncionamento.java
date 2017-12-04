package controleFuncionamento;

import controlBD.PessoaDAO;
import controlBD.PessoaDAOJDBC;
import controlBD.ProjetoDAOJDBC;
import controlBD.ProjetoDAO;
import controlBD.TaskDAO;
import controlDashBoard.Pessoa;
import controlDashBoard.Project;
import janelaControleProjeto.Dashboard;
import janelaDetalhesProjeto.JanelaDetalhesProjeto;
import janelaPessoas.JanelaPessoas;
import janelaTarefa.JanelaAdicionarTarefa;
import java.util.List;
import javax.swing.JFrame;

public class ControleFuncionamento {

    private final List<Project> projeto;
    private final List<Pessoa> pessoa;
    private final ProjetoDAO daoProjeto;
    private TaskDAO daoTask;
    private PessoaDAO daoPessoa;
    private final Dashboard dbm;
    private JanelaDetalhesProjeto jdp;
    private JanelaAdicionarTarefa jat;
    private JanelaPessoas jp;
    
    public ControleFuncionamento() throws Exception {
        daoProjeto = new ProjetoDAOJDBC();
        daoPessoa = new PessoaDAOJDBC();
        projeto = daoProjeto.listarTodos();
        pessoa = daoPessoa.listarTodos();
        dbm = new Dashboard(daoProjeto, projeto, jdp, jat, daoTask, daoPessoa, jp, pessoa);
        dbm.setVisible(true);
        dbm.setLocationRelativeTo(null);
        dbm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
