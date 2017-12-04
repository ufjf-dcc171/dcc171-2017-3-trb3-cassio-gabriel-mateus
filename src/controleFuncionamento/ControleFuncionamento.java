package controleFuncionamento;

import controlBD.BdConnection;
import controlBD.ProjetoDAOJDBC;
import controlBD.ProjetoDAO;
import controlBD.TaskDAO;
import controlDashBoard.Project;
import janelaControleProjeto.Dashboard;
import janelaDetalhesProjeto.JanelaDetalhesProjeto;
import janelaTarefa.JanelaAdicionarTarefa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class ControleFuncionamento {

    private JanelaAdicionarTarefa jat;
    private final List<Project> projeto;
    private final ProjetoDAO daoProjeto;
    private TaskDAO daoTask;
    private final Dashboard dbm;
    private JanelaDetalhesProjeto jdp;
    
    public ControleFuncionamento() throws Exception {
        daoProjeto = new ProjetoDAOJDBC();
        projeto = daoProjeto.listarTodos();
        dbm = new Dashboard(daoProjeto, projeto, jdp, jat, daoTask);
        dbm.setVisible(true);
        dbm.setLocationRelativeTo(null);
        dbm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
