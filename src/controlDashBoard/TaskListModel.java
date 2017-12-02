
package controlDashBoard;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListDataListener;

public class TaskListModel {
    private final List<Task> tarefas;
    private final List<ListDataListener> dataListeners;

    public TaskListModel(List<Task> tarefas) {
        this.tarefas = tarefas;
        this.dataListeners = new ArrayList<>();
    }

    public int getSize() {
        return tarefas.size();
    }

    public Task getElementAt(int index) {
        return tarefas.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
    
}
