
package controlDashBoard;

import java.util.Date;


public class Task {
    
    private String taskName;
    private Date taskDateIni;
    private Date taskDateEnd;

    public Task(String taskName, Date taskDateIni, Date taskDateEnd) {
        this.taskName = taskName;
        this.taskDateIni = taskDateIni;
        this.taskDateEnd = taskDateEnd;
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
    
    
    
    
}
