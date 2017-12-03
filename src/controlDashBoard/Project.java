
package controlDashBoard;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Project {
    
    private Integer id;
    private String projectNome;
    private Date projectDateIni;
    private Date projectDateEnd;
    private String projectDescricao;
    private ArrayList<Task> tarefas = new ArrayList<>();

    public Project(String projectNome, String projectDescricao) {
        this.projectNome = projectNome;
        this.projectDescricao = projectDescricao;
    }
    
    public String getProjectDescricao() {
        return projectDescricao;
    }

    public void setProjectDescricao(String projectDescricao) {
        this.projectDescricao = projectDescricao;
    }

    public Project(String projectNome, Date projectDateIni, Date projectDateEnd) {
        this.projectNome = projectNome;
        this.projectDateIni = projectDateIni;
        this.projectDateEnd = projectDateEnd;
    }

    public Project() {
    }
    
    
    public String getProjectNome() {
        return projectNome;
    }

    public void setProjectNome(String projectNome) {
        this.projectNome = projectNome;
    }

    public String getProjectDateIni() {
        if (projectDateIni == null)
        {
            return null;
        }
        else
        {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");     
            String str = fmt.format(projectDateIni);
            return str;
        }
    }
    
    public Date getProjectDateIniBD() {
        return projectDateIni;
    }

    public void setProjectDateIni(Date projectDateIni) {
        this.projectDateIni = projectDateIni;
    }

    @Override
    public String toString() {
        return this.projectNome;
    }

    public String getProjectDateEnd() {
        if (projectDateEnd == null)
        {
            return null;
        }
        else
        {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");     
            String str = fmt.format(projectDateEnd);
            return str;
        }
    }
    
    public Date getProjectDateEndBD() {
        return projectDateEnd;
    }

    public void setProjectDateEnd(Date projectDateEnd) {
        this.projectDateEnd = projectDateEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Task> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Task> tarefas) {
        this.tarefas = tarefas;
    }
    
    
}
