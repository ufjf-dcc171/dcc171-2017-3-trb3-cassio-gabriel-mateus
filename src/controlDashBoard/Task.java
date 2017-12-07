
package controlDashBoard;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Task {
    
    private Integer numero_tarefa;
    private String descricao;
    private String taskName;
    private String status;
    private Integer duracao;
    private Integer progresso;
    private Date taskDateIni;
    private Date taskDateEnd;
    private Integer id_projeto;
    private ArrayList <Task> preRequisito;
    private ArrayList <Pessoa> pessoa;
    
    public Task(String descricao, String taskName, Integer duracao, Integer id) {
        this.descricao = descricao;
        this.taskName = taskName;
        this.duracao = duracao;
        this.progresso = 0;
        this.id_projeto = id;
        preRequisito = new ArrayList<>();
        pessoa = new ArrayList<>();
    }

    public Task() {
        preRequisito = new ArrayList<>();
        pessoa = new ArrayList<>();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDateIni() {
        if (taskDateIni == null)
        {
            return null;
        }
        else
        {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");     
            String str = fmt.format(taskDateIni);
            return str;
        }
    }

    public void setTaskDateIni(Date taskDateIni) {
        this.taskDateIni = taskDateIni;
    }

    public String getTaskDateEnd() {
        if (taskDateEnd == null)
        {
            return null;
        }
        else
        {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");     
            String str = fmt.format(taskDateEnd);
            return str;
        }
    }

    public void setTaskDateEnd(Date taskDateEnd) {
        this.taskDateEnd = taskDateEnd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getProgresso() {
        return progresso;
    }

    public void setProgresso(Integer progresso) {
        this.progresso = progresso;
    }

    public Integer getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(Integer id_projeto) {
        this.id_projeto = id_projeto;
    }

    public Integer getNumero_tarefa() {
        return numero_tarefa;
    }

    public void setNumero_tarefa(Integer numero_tarefa) {
        this.numero_tarefa = numero_tarefa;
    }

    @Override
    public String toString() {
        return this.taskName;
    }

    public ArrayList <Task> getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(ArrayList <Task> preRequisito) {
        this.preRequisito = preRequisito;
    }

    public ArrayList <Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(ArrayList <Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Date getTaskDateIniBD() {
        return taskDateIni;
    }

    public Date getTaskDateEndBD() {
        return taskDateEnd;
    }
}
