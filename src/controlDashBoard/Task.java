
package controlDashBoard;

import java.util.Date;


public class Task {
    
    private Integer numero;
    private String descricao;
    private String taskName;
    private Integer duracao;
    private Integer progresso;
    private Date taskDateIni;
    private Date taskDateEnd;
    private Integer id_projeto;
    
    public Task(Integer numero, String descricao, String taskName, Integer duracao, Integer id) {
        this.numero = numero;
        this.descricao = descricao;
        this.taskName = taskName;
        this.duracao = duracao;
        this.progresso = 0;
        this.id_projeto = id;
    }

    public Task() {
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskDateIni() {
        return taskDateIni;
    }

    public void setTaskDateIni(Date taskDateIni) {
        this.taskDateIni = taskDateIni;
    }

    public Date getTaskDateEnd() {
        return taskDateEnd;
    }

    public void setTaskDateEnd(Date taskDateEnd) {
        this.taskDateEnd = taskDateEnd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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
    
    
    
    
}
