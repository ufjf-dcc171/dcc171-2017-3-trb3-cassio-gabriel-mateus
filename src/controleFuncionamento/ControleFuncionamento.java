package controleFuncionamento;

import controlBD.BdConnection;
import controlBD.ProjetoDAOJDBC;
import controlBD.ProjetoDAO;
import controlDashBoard.Project;
import janelaControleProjeto.Dashboard;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class ControleFuncionamento {

    private List<Project> projeto;
    private final ProjetoDAO daoProjeto;
    private Dashboard dbm;
    
    public ControleFuncionamento() throws Exception {
        daoProjeto = new ProjetoDAOJDBC();
        projeto = daoProjeto.listarTodos();
        dbm = new Dashboard(daoProjeto, projeto);
        dbm.setVisible(true);
        dbm.setLocationRelativeTo(null);
        dbm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
