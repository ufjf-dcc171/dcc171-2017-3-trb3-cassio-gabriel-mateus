package janelaDetalhesProjeto;

import controlBD.ProjetoDAO;
import controlBD.TaskDAO;
import controlBD.TaskDAOJDBC;
import controlDashBoard.Project;
import controlDashBoard.Task;
import controlDashBoard.TaskListModel;
import janelaTarefa.JanelaAdicionarTarefa;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JanelaDetalhesProjeto extends javax.swing.JFrame {

    private Project projeto;
    private ProjetoDAO daoProjeto;
    private JanelaAdicionarTarefa jat;
    public TaskDAO daoTask;
    
    public JanelaDetalhesProjeto(Project projeto, ProjetoDAO daoProjeto, JanelaAdicionarTarefa jat, TaskDAO daoTask) throws Exception {
        initComponents();
        this.projeto = projeto;
        this.daoProjeto = daoProjeto;
        this.daoTask = daoTask;
        this.jat = jat;
        nomeProjeto.setText(this.projeto.getProjectNome());
        if (projeto.getProjectDateIni() == null)
        {
            dataInicio.setText("Ainda não iniciado");
            dataFinal.setText("Ainda não terminado");
        }
        else if (projeto.getProjectDateEnd() == null)
        {
            dataInicio.setText(projeto.getProjectDateIni());
            dataFinal.setText("Ainda não terminado"); 
        }
        else
        {
           dataInicio.setText(projeto.getProjectDateIni());
           dataFinal.setText(projeto.getProjectDateEnd());
        }
        textoDescricao.setText(projeto.getProjectDescricao());
        daoTask = new TaskDAOJDBC();
        projeto.setTarefas(daoTask.listarTodos(projeto.getId()));
        List<Task> tarefa = projeto.getTarefas();
        listaTarefas.setModel(new TaskListModel (tarefa));
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
        nomeProjeto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataInicio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dataFinal = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescricao = new javax.swing.JTextArea();
        alterarDescricao = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTarefas = new javax.swing.JList<>();
        btnAdicionarTarefa = new javax.swing.JButton();
        btnVerTarefa = new javax.swing.JToggleButton();
        btnExcluirTarefa = new javax.swing.JButton();
        btnAlterarTarefa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome do Projeto:");

        nomeProjeto.setText("Preencher com nome do projeto");

        jLabel3.setText("Data início:");

        dataInicio.setText("Preencher com a data inicial");

        jLabel5.setText("Data final:");

        dataFinal.setText("Preencher com a data final");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        textoDescricao.setColumns(20);
        textoDescricao.setRows(5);
        textoDescricao.setText("Descrição...\n");
        jScrollPane1.setViewportView(textoDescricao);

        alterarDescricao.setText("Alterar Descrição");
        alterarDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarDescricaoActionPerformed(evt);
            }
        });

        jLabel7.setText("Tarefas do Projeto");

        listaTarefas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listaTarefas);

        btnAdicionarTarefa.setText("Adicionar Tarefa");
        btnAdicionarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarTarefaActionPerformed(evt);
            }
        });

        btnVerTarefa.setText("Ver Tarefa");
        btnVerTarefa.setPreferredSize(new java.awt.Dimension(111, 23));

        btnExcluirTarefa.setText("Excluir Tarefa");

        btnAlterarTarefa.setText("Alterar Tarefa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alterarDescricao, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(119, 119, 119)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeProjeto)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataInicio)
                                    .addComponent(dataFinal))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdicionarTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlterarTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnExcluirTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeProjeto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dataInicio)
                    .addComponent(btnIniciar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dataFinal)
                    .addComponent(btnFinalizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alterarDescricao)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarTarefa)
                    .addComponent(btnVerTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirTarefa)
                    .addComponent(btnAlterarTarefa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        Integer i = 0;
        Date data = new Date();
        projeto.setProjectDateIni(data);
        try {
            daoProjeto.alterar(projeto, i);
            dataInicio.setText(projeto.getProjectDateIni());
            pack();
        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        Integer i = 1;
        Date data = new Date();
        projeto.setProjectDateEnd(data);
        try {
            daoProjeto.alterar(projeto, i);
            dataFinal.setText(projeto.getProjectDateEnd());
            pack();
        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void alterarDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarDescricaoActionPerformed
        Integer i = 2;
        projeto.setProjectDescricao(textoDescricao.getText());
        try {
            daoProjeto.alterar(projeto, i);
            textoDescricao.setText(textoDescricao.getText());
            JOptionPane.showMessageDialog(null, "A tarefa foi alterada com sucesso!", "Alteração feita", JOptionPane.INFORMATION_MESSAGE);                   
            pack();
        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_alterarDescricaoActionPerformed

    private void btnAdicionarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarTarefaActionPerformed
        jat = new JanelaAdicionarTarefa(daoTask, projeto);
        jat.setVisible(true);
        jat.setLocationRelativeTo(null);
        jat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jat.addWindowListener(new WindowAdapter() {
                    @Override
                        public void windowClosing(WindowEvent evt) {
                            listaTarefas.updateUI();
                        }
        });

    }//GEN-LAST:event_btnAdicionarTarefaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarDescricao;
    private javax.swing.JButton btnAdicionarTarefa;
    private javax.swing.JButton btnAlterarTarefa;
    private javax.swing.JButton btnExcluirTarefa;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JToggleButton btnVerTarefa;
    private javax.swing.JLabel dataFinal;
    private javax.swing.JLabel dataInicio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Task> listaTarefas;
    private javax.swing.JLabel nomeProjeto;
    private javax.swing.JTextArea textoDescricao;
    // End of variables declaration//GEN-END:variables

    public Project getProjeto() {
        return projeto;
    }

    public void setProjeto(Project projeto) {
        this.projeto = projeto;
    }
}
