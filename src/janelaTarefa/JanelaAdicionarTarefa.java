package janelaTarefa;

import controlBD.PessoaDAO;
import controlBD.PessoaDAOJDBC;
import controlBD.TaskDAO;
import controlBD.TaskDAOJDBC;
import controlBD.TaskPessoaDAO;
import controlBD.TaskPessoaDAOJDBC;
import controlBD.TaskPreRequisitoDAO;
import controlBD.TaskPreRequisitoDAOJDBC;
import controlDashBoard.Pessoa;
import controlDashBoard.PessoasListModel;
import controlDashBoard.Project;
import controlDashBoard.Task;
import controlDashBoard.TaskListModel;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JanelaAdicionarTarefa extends javax.swing.JFrame {
   
    private List<Pessoa> pessoasTarefas = new ArrayList<>();
    private List<Pessoa> pessoasSemTarefas = new ArrayList<>();
    private List<Pessoa> pessoas;
    private PessoaDAO daoPessoa;
    private TaskDAO daoTask;
    private TaskPessoaDAO daoTaskPessoa;
    private TaskPreRequisitoDAO daoTaskPreRequisito;
    private Project projeto;
    private ArrayList<Task> tarefas;
    private ArrayList<Task> tarefasSemRequisitos = new ArrayList<>();
    private ArrayList<Task> tarefasPreRequisitos = new ArrayList<>();
    
    public JanelaAdicionarTarefa(Project projeto, List<Pessoa> pessoas) throws Exception {
        super("Detalhes");
        initComponents();
        daoTask = new TaskDAOJDBC();
        daoPessoa = new PessoaDAOJDBC();
        daoTaskPessoa = new TaskPessoaDAOJDBC();
        daoTaskPreRequisito = new TaskPreRequisitoDAOJDBC();
        this.projeto = projeto;
        this.pessoas = pessoas;
        this.tarefas = projeto.getTarefas();
        for (Pessoa p : pessoas)
        {
            pessoasSemTarefas.add(p);
        }
        for (Task t : tarefas)
        {
            tarefasSemRequisitos.add(t);
        }
        listaPessoas.setModel(new PessoasListModel(pessoasSemTarefas));
        listaTarefaProjeto.setModel(new TaskListModel(tarefasSemRequisitos));
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        duracaoTarefa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descricaoTarefa = new javax.swing.JTextArea();
        nomeTarefa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTarefaProjeto = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTarefaPreRequisito = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        adicionarPreRequisito = new javax.swing.JButton();
        removerPreRequisito = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaPessoas = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaPessoasTarefas = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        adicionarPessoaTarefa = new javax.swing.JButton();
        removerPessoaTarefa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tarefa nome:");

        jLabel2.setText("Duração:");

        duracaoTarefa.setText("(Aproximado) Duração em dias...");
        duracaoTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracaoTarefaActionPerformed(evt);
            }
        });

        jLabel3.setText("Tarefas pré-requisito");

        jLabel4.setText("Pessoas");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel5.setText("Descrição:");

        descricaoTarefa.setColumns(20);
        descricaoTarefa.setRows(5);
        jScrollPane3.setViewportView(descricaoTarefa);

        listaTarefaProjeto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaTarefaProjeto);

        listaTarefaPreRequisito.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listaTarefaPreRequisito);

        jLabel6.setText("Tarefa");

        adicionarPreRequisito.setText(">>");
        adicionarPreRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarPreRequisitoActionPerformed(evt);
            }
        });

        removerPreRequisito.setText("<<");
        removerPreRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerPreRequisitoActionPerformed(evt);
            }
        });

        listaPessoas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaPessoas.setToolTipText("");
        jScrollPane4.setViewportView(listaPessoas);

        jScrollPane5.setViewportView(listaPessoasTarefas);

        jLabel7.setText("Pessoas na tarefa");

        adicionarPessoaTarefa.setText(">>");
        adicionarPessoaTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarPessoaTarefaActionPerformed(evt);
            }
        });

        removerPessoaTarefa.setText("<<");
        removerPessoaTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerPessoaTarefaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnConfirmar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3)
                                    .addComponent(nomeTarefa)
                                    .addComponent(duracaoTarefa))))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removerPreRequisito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(adicionarPreRequisito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adicionarPessoaTarefa)
                                    .addComponent(removerPessoaTarefa))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3))
                                .addGap(0, 11, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(duracaoTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(adicionarPreRequisito)
                        .addGap(18, 18, 18)
                        .addComponent(removerPreRequisito)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(adicionarPessoaTarefa)
                        .addGap(18, 18, 18)
                        .addComponent(removerPessoaTarefa))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addComponent(btnConfirmar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void duracaoTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracaoTarefaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracaoTarefaActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if ("".equals(duracaoTarefa.getText())) {
            JOptionPane.showMessageDialog(null, "Informe um valor inteiro para a duração da tarefa.", "Valor inválido.", JOptionPane.INFORMATION_MESSAGE);
        } else if ("".equals(nomeTarefa.getText())) {
            JOptionPane.showMessageDialog(null, "Informe o nome da tarefa.", "Nome inválido.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Integer durac = null;
            try {
                durac = parseInt(duracaoTarefa.getText());
                Task tarefa = new Task(projeto.getTarefas().size() + 1, descricaoTarefa.getText(), nomeTarefa.getText(), durac, projeto.getId());
                tarefa.setStatus("Não iniciada");
                for (Task t : tarefasPreRequisitos)
                {
                    tarefa.getPreRequisito().add(t);
                }
                for (Pessoa p : pessoasTarefas)
                {
                    tarefa.getPessoa().add(p);
                }
                try {
                    daoTask.criar(tarefa, projeto);
                    ArrayList<Task> tarefasAssociar = tarefa.getPreRequisito();
                    for (Task tar : tarefasAssociar)
                        daoTaskPreRequisito.associar(tarefa, tar);
                    
                    ArrayList<Pessoa> pessoasAssociar = tarefa.getPessoa();
                    for (Pessoa pes : pessoasAssociar)
                        daoTaskPessoa.associar(tarefa, pes);
                    
                    projeto.getTarefas().add(tarefa);
                    JOptionPane.showMessageDialog(null, "A tarefa foi criada com sucesso!", "Tarefa criada", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(JanelaAdicionarTarefa.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Deve ser informado um valor inteiro para a duração.", "Valor Inválido", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void adicionarPreRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarPreRequisitoActionPerformed
        Task selecionada = listaTarefaProjeto.getSelectedValue();
        if (selecionada == null)
        {
            
        }
        else
        {
            tarefasPreRequisitos.add(selecionada);
            tarefasSemRequisitos.remove(selecionada);
            listaTarefaPreRequisito.setModel(new TaskListModel(tarefasPreRequisitos));
            listaTarefaProjeto.updateUI();
            listaTarefaPreRequisito.updateUI();
        }
    }//GEN-LAST:event_adicionarPreRequisitoActionPerformed

    private void removerPreRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerPreRequisitoActionPerformed
        Task selecionada = listaTarefaPreRequisito.getSelectedValue();
        if (selecionada == null)
        {
            
        }
        else
        {
            tarefasPreRequisitos.remove(selecionada);
            tarefasSemRequisitos.add(selecionada);
            listaTarefaProjeto.updateUI();
            listaTarefaPreRequisito.updateUI();
        }
    }//GEN-LAST:event_removerPreRequisitoActionPerformed

    private void adicionarPessoaTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarPessoaTarefaActionPerformed
        Pessoa selecionado = listaPessoas.getSelectedValue();
        if (selecionado == null)
        {
            
        }
        else
        {
            pessoasTarefas.add(selecionado);
            pessoasSemTarefas.remove(selecionado);
            listaPessoasTarefas.setModel(new PessoasListModel(pessoasTarefas));
            listaPessoas.updateUI();
            listaPessoasTarefas.updateUI();
        }
    }//GEN-LAST:event_adicionarPessoaTarefaActionPerformed

    private void removerPessoaTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerPessoaTarefaActionPerformed
        Pessoa selecionado = listaPessoasTarefas.getSelectedValue();
        if (selecionado == null)
        {
            
        }
        else
        {
            pessoasTarefas.remove(selecionado);
            pessoasSemTarefas.add(selecionado);
            listaPessoas.updateUI();
            listaPessoasTarefas.updateUI();
        }
    }//GEN-LAST:event_removerPessoaTarefaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarPessoaTarefa;
    private javax.swing.JButton adicionarPreRequisito;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JTextArea descricaoTarefa;
    private javax.swing.JTextField duracaoTarefa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<Pessoa> listaPessoas;
    private javax.swing.JList<Pessoa> listaPessoasTarefas;
    private javax.swing.JList<Task> listaTarefaPreRequisito;
    private javax.swing.JList<Task> listaTarefaProjeto;
    private javax.swing.JTextField nomeTarefa;
    private javax.swing.JButton removerPessoaTarefa;
    private javax.swing.JButton removerPreRequisito;
    // End of variables declaration//GEN-END:variables
}
