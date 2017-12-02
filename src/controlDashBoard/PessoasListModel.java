
package controlDashBoard;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListDataListener;


public class PessoasListModel {
    
     private final List<Pessoa> pessoas;
     private final List<ListDataListener> dataListeners;

    public PessoasListModel(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
        this.dataListeners = new ArrayList<>();
    }

    public int getSize() {
        return pessoas.size();
    }

    public Pessoa getElementAt(int index) {
        return pessoas.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
   
}
