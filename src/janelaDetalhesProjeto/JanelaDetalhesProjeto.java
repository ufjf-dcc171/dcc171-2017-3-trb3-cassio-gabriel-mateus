package janelaDetalhesProjeto;

import controlDashBoard.Pessoa;
import controlDashBoard.Project;
import controlDashBoard.Task;
import controlDashBoard.TaskListModel;
import controleFuncionamento.SampleDataFuncionamento;
import janelaTarefa.JanelaAdicionarTarefa;
import janelaTarefa.JanelaVerTarefa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JanelaDetalhesProjeto extends javax.swing.JFrame {
    
    private SampleDataFuncionamento sp;
    private List<Task> tarefas;
    private Project projeto;
    private List<Pessoa> pessoas;
    private JanelaAdicionarTarefa jat;
    private JanelaVerTarefa jvt;
    
    public JanelaDetalhesProjeto(Project projeto, JanelaAdicionarTarefa jat,
             JanelaVerTarefa jvt, SampleDataFuncionamento sp) throws Exception {
        super("Detalhes do Projeto");
        initComponents();
        this.jat = jat;
        this.sp = sp;
        this.projeto = projeto;;        
        this.tarefas = projeto.getTarefas();
        textoDescricao.setText(this.projeto.getProjectDescricao());
        nomeProjeto.setText(this.projeto.getProjectNome());
        for (Task t : tarefas)
        {
            sp.getDaoTaskPreRequisito().buscar(t, this.tarefas);
        }
        if (projeto.getProjectDateIni() == null) {
            dataInicio.setText("Ainda não iniciado");
            dataFinal.setText("Ainda não terminado");
        } else if (projeto.getProjectDateEnd() == null) {
            dataInicio.setText(projeto.getProjectDateIni());
            dataFinal.setText("Ainda não terminado");
        } else {
            dataInicio.setText(projeto.getProjectDateIni());
            dataFinal.setText(projeto.getProjectDateEnd());
        }
        if(projeto.getProjectDateIni() != null)
        {
            btnIniciar.setEnabled(false);
        }
        if(projeto.getProjectDateEnd() != null)
        {
            btnFinalizar.setEnabled(false);
        }
        defaultTela();
        ComboBoxSelecionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (ComboBoxSelecionar.getSelectedIndex())
                {
                    case 0:
                    {
                        try {
                            defaultTela();
                        } catch (Exception ex) {
                            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                    case 1:
                    {
                        defaultTelaConcluida();
                        break;
                    }
                    case 2:
                    {
                        defaultTelaIniciada();
                        break;
                    }
                    case 3:
                    {
                        defaultPodeSerIniciada();
                        break;
                    }
                    case 4:
                    {
                        defaultAguardandoPreRequisito();
                        break;
                    }
                }
            }
        });       
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
        ComboBoxSelecionar = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTarefas = new javax.swing.JList<>();
        btnAdicionarTarefa = new javax.swing.JButton();
        btnVerTarefa = new javax.swing.JToggleButton();
        btnExcluirTarefa = new javax.swing.JButton();

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

        ComboBoxSelecionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Concluídas", "Iniciadas", "Podem ser iniciadas", "Aguardando Pré-Requisito" }));

        listaTarefas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listaTarefas);

        btnAdicionarTarefa.setText("Adicionar Tarefa");
        btnAdicionarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarTarefaActionPerformed(evt);
            }
        });

        btnVerTarefa.setText("Ver Tarefa");
        btnVerTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTarefaActionPerformed(evt);
            }
        });

        btnExcluirTarefa.setText("Excluir Tarefa");
        btnExcluirTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTarefaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alterarDescricao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nomeProjeto)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dataInicio)
                                            .addComponent(dataFinal))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComboBoxSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionarTarefa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluirTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVerTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
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
                    .addComponent(ComboBoxSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarTarefa)
                    .addComponent(btnVerTarefa)
                    .addComponent(btnExcluirTarefa))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        Integer i = 0;
        Date data = new Date();
        projeto.setProjectDateIni(data);
        try {
            sp.getDaoProjeto().alterar(projeto, i);
            dataInicio.setText(projeto.getProjectDateIni());
            btnIniciar.setEnabled(false);
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
            sp.getDaoProjeto().alterar(projeto, i);
            dataFinal.setText(projeto.getProjectDateEnd());
            btnFinalizar.setEnabled(false);
            pack();
        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void alterarDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarDescricaoActionPerformed
        Integer i = 2;
        projeto.setProjectDescricao(textoDescricao.getText());
        try {
            sp.getDaoProjeto().alterar(projeto, i);
            textoDescricao.setText(textoDescricao.getText());
            JOptionPane.showMessageDialog(null, "A tarefa foi alterada com sucesso!", "Alteração feita", JOptionPane.INFORMATION_MESSAGE);
            pack();
        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_alterarDescricaoActionPerformed

    private void btnAdicionarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarTarefaActionPerformed
        try {
            jat = new JanelaAdicionarTarefa(projeto, sp);
            jat.setVisible(true);
            jat.setLocationRelativeTo(null);
            jat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jat.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                listaTarefas.updateUI();
            }
        });
        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdicionarTarefaActionPerformed

    private void btnVerTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTarefaActionPerformed
        Task selected = listaTarefas.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma tarefa.", "Selecione uma tarefa.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                jvt = new JanelaVerTarefa(selected, tarefas, sp, btnIniciar, btnFinalizar);
                jvt.setLocationRelativeTo(null);
                jvt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jvt.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnVerTarefaActionPerformed

    private void btnExcluirTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTarefaActionPerformed
        Task selected = listaTarefas.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma tarefa.", "Selecione uma tarefa.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            
        }
    }//GEN-LAST:event_btnExcluirTarefaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxSelecionar;
    private javax.swing.JButton alterarDescricao;
    private javax.swing.JButton btnAdicionarTarefa;
    private javax.swing.JButton btnExcluirTarefa;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JToggleButton btnVerTarefa;
    private javax.swing.JLabel dataFinal;
    private javax.swing.JLabel dataInicio;
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

    private void defaultTela() throws Exception {
        listaTarefas.setModel(new TaskListModel(tarefas));
        listaTarefas.updateUI();
        pack();
    }
    
    private void defaultTelaConcluida()
    {
        Task task = new Task();
        task.setTaskName("Não há tarefas concluídas");
        Integer i = 0;
        List<Task> tar = new ArrayList<>();
        if (this.projeto.getTarefas().size() > 0)
        {
            for (Task t : this.projeto.getTarefas())
            {
                if ("Concluída".equals(t.getStatus()))
                {
                    tar.add(t);
                }
            }
        }
        if (tar.size() > 0)
        {
            this.listaTarefas.setModel(new TaskListModel(tar));
            listaTarefas.updateUI();
        }
        else
        {
            tar.add(task);
            this.listaTarefas.setModel(new TaskListModel(tar));
        }
    }
    
    private void defaultTelaIniciada() {
        Task task = new Task();
        task.setTaskName("Não há tarefas iniciadas");
        Integer i = 0;
        List<Task> tar = new ArrayList<>();
        if (this.projeto.getTarefas().size() > 0)
        {
            for (Task t : this.projeto.getTarefas())
            {
                if ("Iniciada".equals(t.getStatus()))
                {
                    tar.add(t);
                }
            }
        }
        if (tar.size() > 0)
        {
            this.listaTarefas.setModel(new TaskListModel(tar));
            listaTarefas.updateUI();
        }
        else
        {
            tar.add(task);
            this.listaTarefas.setModel(new TaskListModel(tar));
        }
    }
   
    private void defaultPodeSerIniciada() {
        Task task = new Task();
        task.setTaskName("Nenhuma tarefa para ser iniciada");
        Integer i = 0;
        Boolean preRequisito = false;
        List<Task> tar = new ArrayList<>();
        if (this.projeto.getTarefas().size() > 0)
        {
            for (Task t : this.projeto.getTarefas())
            {
                if (t.getPreRequisito().size() > 0)
                {
                    for (Task tasks : t.getPreRequisito())
                    {
                        if (tasks.getStatus().equals("Concluída"))
                        {
                            
                        }
                        else 
                        {
                            preRequisito = true;
                        }
                    }
                    if (preRequisito)
                    {
                        
                    }
                    else
                    {
                        tar.add(t);
                    }
                }
                else 
                {
                    if (t.getStatus().equals("Concluída") || t.getStatus().equals("Iniciada") || t.getStatus().equals("Pré-requisito"))
                    {}
                    else
                        tar.add(t);
                }
            }
        }
        if (tar.size() > 0)
        {
            this.listaTarefas.setModel(new TaskListModel(tar));
        }
        else
        {
            tar.add(task);
            this.listaTarefas.setModel(new TaskListModel(tar));
        }
    }

    private void defaultAguardandoPreRequisito() {
        Task task = new Task();
        task.setTaskName("Nenhuma tarefa aguardando pré-requisito");
        Integer i = 0;
        Boolean preRequisito = false;
        List<Task> tar = new ArrayList<>();
        if (this.projeto.getTarefas().size() > 0)
        {
            for (Task t : this.projeto.getTarefas())
            {
                                            
                if (t.getPreRequisito().size() > 0)
                {
                    for (Task tasks : t.getPreRequisito())
                    {
                        if (tasks.getStatus().equals("Não iniciada") || tasks.getStatus().equals("Iniciada"))
                        {
                            preRequisito = true;
                        }
                    }
                    if (preRequisito)
                    {
                        tar.add(t);
                    }
                }
            }
        }
        if (tar.size() > 0)
        {
            this.listaTarefas.setModel(new TaskListModel(tar));
        }
        else
        {
            tar.add(task);
            this.listaTarefas.setModel(new TaskListModel(tar));
        }
    }
}

