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
import JanelaPessoas.JanelaPessoas;
import controlBD.TaskDAOJDBC;
import controlBD.TaskPessoaDAO;
import controlBD.TaskPessoaDAOJDBC;
import controlBD.TaskPreRequisitoDAO;
import controlBD.TaskPreRequisitoDAOJDBC;
import controlDashBoard.Task;
import janelaTarefa.JanelaAdicionarTarefa;
import java.util.List;
import janelaTarefa.JanelaVerTarefa;
import java.util.ArrayList;
import javax.swing.JFrame;

public class ControleFuncionamento {

    private SampleDataFuncionamento sp;
    private Dashboard dbm;
    private JanelaDetalhesProjeto jdp;
    private JanelaAdicionarTarefa jat;
    private JanelaPessoas jp;
    private JanelaVerTarefa jvt;
    
    public ControleFuncionamento() throws Exception {
        sp = new SampleDataFuncionamento();
        dbm = new Dashboard(jdp, jat, jp, jvt, sp);
        //dbm = new Dashboard();
        dbm.setVisible(true);
        dbm.setLocationRelativeTo(null);
        dbm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}
