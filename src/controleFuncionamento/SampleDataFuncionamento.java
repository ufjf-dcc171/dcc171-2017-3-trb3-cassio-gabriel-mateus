package controleFuncionamento;

import controlBD.PessoaDAO;
import controlBD.PessoaDAOJDBC;
import controlBD.ProjetoDAO;
import controlBD.ProjetoDAOJDBC;
import controlBD.TaskDAO;
import controlBD.TaskDAOJDBC;
import controlBD.TaskPessoaDAO;
import controlBD.TaskPessoaDAOJDBC;
import controlBD.TaskPreRequisitoDAO;
import controlBD.TaskPreRequisitoDAOJDBC;
import controlDashBoard.Pessoa;
import controlDashBoard.Project;
import controlDashBoard.Task;
import java.util.List;

public class SampleDataFuncionamento {
    private List<Project> projeto;
    private List<Pessoa> pessoa;
    private ProjetoDAO daoProjeto;
    private TaskDAO daoTask;
    private PessoaDAO daoPessoa;
    private TaskPreRequisitoDAO daoTaskPreRequisito;
    private TaskPessoaDAO daoTaskPessoa;

    public SampleDataFuncionamento() throws Exception {
        daoProjeto = new ProjetoDAOJDBC();
        daoPessoa = new PessoaDAOJDBC();
        daoTask = new TaskDAOJDBC();
        daoTaskPessoa = new TaskPessoaDAOJDBC();
        daoTaskPreRequisito = new TaskPreRequisitoDAOJDBC();
        iniciar();
    }

    public List<Project> getProjeto() {
        return projeto;
    }

    public void setProjeto(List<Project> projeto) {
        this.projeto = projeto;
    }

    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

    public ProjetoDAO getDaoProjeto() {
        return daoProjeto;
    }

    public void setDaoProjeto(ProjetoDAO daoProjeto) {
        this.daoProjeto = daoProjeto;
    }

    public TaskDAO getDaoTask() {
        return daoTask;
    }

    public void setDaoTask(TaskDAO daoTask) {
        this.daoTask = daoTask;
    }

    public PessoaDAO getDaoPessoa() {
        return daoPessoa;
    }

    public void setDaoPessoa(PessoaDAO daoPessoa) {
        this.daoPessoa = daoPessoa;
    }

    public TaskPreRequisitoDAO getDaoTaskPreRequisito() {
        return daoTaskPreRequisito;
    }

    public void setDaoTaskPreRequisito(TaskPreRequisitoDAO daoTaskPreRequisito) {
        this.daoTaskPreRequisito = daoTaskPreRequisito;
    }

    public TaskPessoaDAO getDaoTaskPessoa() {
        return daoTaskPessoa;
    }

    public void setDaoTaskPessoa(TaskPessoaDAO daoTaskPessoa) {
        this.daoTaskPessoa = daoTaskPessoa;
    }
     private void iniciar() throws Exception {
        this.projeto = daoProjeto.listarTodos();
        this.pessoa = daoPessoa.listarTodos();
        for (Project p : projeto)
        {
            p.setTarefas(daoTask.listarTodos(p.getId()));
            for (Task t: p.getTarefas())
            {
                daoTaskPreRequisito.buscar(t, p.getTarefas());
                daoTaskPessoa.buscar(t, pessoa);
            }            
        }
    } 
}
