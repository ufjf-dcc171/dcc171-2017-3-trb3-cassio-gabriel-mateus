package controleFuncionamento;

import controlBD.BdConnection;
import controlBD.ProjetoDAOJDBC;
import controlBD.ProjetoDAO;
import controlDashBoard.Project;
import janelaControleProjeto.Dashboard;
import janelaDetalhesProjeto.JanelaDetalhesProjeto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class ControleFuncionamento {

    private final List<Project> projeto;
    private final ProjetoDAO daoProjeto;
    private final Dashboard dbm;
    private final JanelaDetalhesProjeto jdp = new JanelaDetalhesProjeto();
    
    public ControleFuncionamento() throws Exception {
        daoProjeto = new ProjetoDAOJDBC();
        projeto = daoProjeto.listarTodos();
        dbm = new Dashboard(daoProjeto, projeto, jdp);
        dbm.setVisible(true);
        dbm.setLocationRelativeTo(null);
        dbm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
