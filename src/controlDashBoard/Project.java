
package controlDashBoard;

import java.util.Date;


public class Project {
    
    private String projectNome;
    private Date projectDateIni;
    private Date projectDateEnd;

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

    public Date getProjectDateIni() {
        return projectDateIni;
    }

    public void setProjectDateIni(Date projectDateIni) {
        this.projectDateIni = projectDateIni;
    }

    public Date getProjectDateEnd() {
        return projectDateEnd;
    }

    public void setProjectDateEnd(Date projectDateEnd) {
        this.projectDateEnd = projectDateEnd;
    }

    
}
