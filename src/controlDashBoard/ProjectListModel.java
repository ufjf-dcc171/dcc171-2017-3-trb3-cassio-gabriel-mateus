
package controlDashBoard;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListDataListener;


public class ProjectListModel {
    private final List<Project> projetos;
    private final List<ListDataListener> dataListeners;

    public ProjectListModel(List<Project> tarefas) {
        this.projetos = tarefas;
        this.dataListeners = new ArrayList<>();
    }

    public int getSize() {
        return projetos.size();
    }

    public Project getElementAt(int index) {
        return projetos.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
   
    
}
