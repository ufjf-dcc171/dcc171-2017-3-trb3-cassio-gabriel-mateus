package janelaTarefa;

import controlBD.TaskDAO;
import controlBD.TaskDAOJDBC;
import controlBD.TaskPessoaDAO;
import controlBD.TaskPessoaDAOJDBC;
import controlBD.TaskPreRequisitoDAO;
import controlBD.TaskPreRequisitoDAOJDBC;
import controlDashBoard.Pessoa;
import controlDashBoard.PessoasListModel;
import controlDashBoard.Task;
import controlDashBoard.TaskListModel;
import controleFuncionamento.SampleDataFuncionamento;
import janelaDetalhesProjeto.JanelaDetalhesProjeto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class JanelaVerTarefa extends javax.swing.JFrame {

    private SampleDataFuncionamento sp;
    private List<Task> tarefas;
    private Task tarefa;

    public JanelaVerTarefa(Task tarefa, List<Task> tarefas, SampleDataFuncionamento sp, JButton btnIniciar, JButton btnFinalizar) throws Exception {
        super("Ver tarefas");
        initComponents();
        this.sp = sp;
        this.tarefas = tarefas;
        this.tarefa = tarefa;
        nomeTarefa.setText(this.tarefa.getTaskName());
        duracao.setText(Integer.toString(tarefa.getDuracao()) + " dias");
        progresso.setValue(this.tarefa.getProgresso());
        porcentagem.setText(Integer.toString(tarefa.getProgresso()) + "%");
        areaDescricao.setText(this.tarefa.getDescricao());
        if (this.tarefa.getTaskDateIni() == null) {
            dataInicio.setText("Ainda não iniciado");
            dataFinal.setText("Ainda não terminado");
        } else if (this.tarefa.getTaskDateEnd() == null) {
            dataInicio.setText(this.tarefa.getTaskDateIni());
            dataFinal.setText("Ainda não terminado");
        } else {
            dataInicio.setText(this.tarefa.getTaskDateIni());
            dataFinal.setText(this.tarefa.getTaskDateEnd());
        }
        sp.getDaoTaskPessoa().buscar(tarefa, sp.getPessoa());
        sp.getDaoTaskPreRequisito().buscar(tarefa, this.tarefas);
        if (this.tarefa.getPreRequisito().size() > 0) {
            listaPreRequisito.setModel(new TaskListModel(this.tarefa.getPreRequisito()));
        }
        if (this.tarefa.getPessoa().size() > 0) {
            listaPessoa.setModel(new PessoasListModel(this.tarefa.getPessoa()));
        }
        if (this.tarefa.getTaskDateIni() != null) {
            this.btnIniciar.setEnabled(false);
        }
        if (this.tarefa.getTaskDateEnd() != null) {
            this.tarefa.setProgresso(100);
            this.btnFinalizar.setEnabled(false);
            btnAlterarEstimativa.setEnabled(false);
            btnAterarProgresso.setEnabled(false);
            btnAlterarDescricao.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFinalizar = new javax.swing.JButton();
        btnAterarProgresso = new javax.swing.JButton();
        btnAlterarEstimativa = new javax.swing.JButton();
        progresso = new javax.swing.JProgressBar();
        nomeTarefa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        duracao = new javax.swing.JLabel();
        dataInicio = new javax.swing.JLabel();
        dataFinal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaDescricao = new javax.swing.JTextArea();
        btnAlterarDescricao = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaPessoa = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaPreRequisito = new javax.swing.JList<>();
        porcentagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnAterarProgresso.setText("Alterar Progresso");
        btnAterarProgresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAterarProgressoActionPerformed(evt);
            }
        });

        btnAlterarEstimativa.setText("Alterar Estimativa");
        btnAlterarEstimativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarEstimativaActionPerformed(evt);
            }
        });

        nomeTarefa.setText("(colocar nome)");

        jLabel1.setText("Tarefa nome:");

        jLabel2.setText("Progresso:");

        jLabel3.setText("Duração:");

        jLabel4.setText("Data início:");

        jLabel5.setText("Data final:");

        jLabel6.setText("Pré-requisito da tarefa");

        jLabel7.setText("Pessoas da tarefa");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        duracao.setText("Duração");

        dataInicio.setText("Data de Início");

        dataFinal.setText("Data de Término");

        jLabel8.setText("Descrição");

        areaDescricao.setColumns(20);
        areaDescricao.setRows(5);
        jScrollPane3.setViewportView(areaDescricao);

        btnAlterarDescricao.setText("Alterar Descrição");
        btnAlterarDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDescricaoActionPerformed(evt);
            }
        });

        listaPessoa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(listaPessoa);

        listaPreRequisito.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(listaPreRequisito);

        porcentagem.setText("% concluída");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomeTarefa))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(porcentagem)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(progresso, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                        .addComponent(duracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlterarEstimativa)
                            .addComponent(btnAterarProgresso)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataInicio)
                                .addGap(18, 18, 18)
                                .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataFinal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFinalizar)))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarDescricao)))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeTarefa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(btnIniciar)
                        .addComponent(btnAterarProgresso)
                        .addComponent(dataInicio)))
                .addGap(1, 1, 1)
                .addComponent(porcentagem)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(btnAlterarEstimativa)
                    .addComponent(duracao)
                    .addComponent(dataFinal)
                    .addComponent(btnFinalizar))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlterarDescricao))
                        .addGap(37, 37, 37))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (this.tarefa.getTaskDateIni() == null) {
            JOptionPane.showMessageDialog(null, "Você não pode finalizar uma tarefa que não foi iniciada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            int resposta = JOptionPane.showConfirmDialog(null, "Uma vez finalizada, não será possível alterar os dados da tarefa.", "Tem certeza que deseja finalizar?", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                Integer i = 1;
                Integer j = 4;
                Integer k = 5;
                Date data = new Date();
                this.tarefa.setStatus("Concluída");
                this.tarefa.setProgresso(100);
                this.tarefa.setTaskDateEnd(data);
                try {
                    sp.getDaoTask().alterar(this.tarefa, i);
                    sp.getDaoTask().alterar(this.tarefa, j);
                    sp.getDaoTask().alterar(this.tarefa, k);
                    dataFinal.setText(this.tarefa.getTaskDateEnd());
                    btnFinalizar.setEnabled(false);
                    btnAlterarEstimativa.setEnabled(false);
                    btnAterarProgresso.setEnabled(false);
                    progresso.setValue(this.tarefa.getProgresso());
                    porcentagem.setText(Integer.toString(this.tarefa.getProgresso()) + "%");
                    pack();
                } catch (Exception ex) {
                    Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        Integer i = 0;
        Integer j = 5;
        Boolean podeIniciar = false;
        try {
            if (this.tarefa.getPreRequisito().size() > 0) {
                ArrayList<Task> tar = this.tarefa.getPreRequisito();
                for (Task t : tar) {
                    if ("Concluída".equals(t.getStatus())) {
                        podeIniciar = true;
                    }
                }
                if (podeIniciar) {
                    Date data = new Date();
                    this.tarefa.setStatus("Iniciada");
                    this.tarefa.setTaskDateIni(data);
                    sp.getDaoTask().alterar(this.tarefa, i);
                    sp.getDaoTask().alterar(this.tarefa, j);
                    dataInicio.setText(this.tarefa.getTaskDateIni());
                    btnIniciar.setEnabled(false);
                    pack();
                } else {
                    this.tarefa.setStatus("Pré-requisito");
                    sp.getDaoTask().alterar(this.tarefa, j);
                    JOptionPane.showMessageDialog(null, "A tarefa não pode ser inciada pois está esperando pré-requisitos.", "Falta pré-requisitos.", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                Date data = new Date();
                this.tarefa.setStatus("Iniciada");
                this.tarefa.setTaskDateIni(data);
                sp.getDaoTask().alterar(this.tarefa, i);
                sp.getDaoTask().alterar(this.tarefa, j);
                dataInicio.setText(this.tarefa.getTaskDateIni());
                btnIniciar.setEnabled(false);
                pack();
            }

        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnAlterarEstimativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarEstimativaActionPerformed
        Integer i = 3;
        try {
            Integer d = Integer.parseInt(JOptionPane.showInputDialog("Qual a nova estimativa de duração?"));
            if (d < 0) {
                JOptionPane.showMessageDialog(null, "Informe um valor inteiro positivo ou 0.", "Valor inválido", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.tarefa.setDuracao(d);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe um valor numérico para a estimativa.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            sp.getDaoTask().alterar(this.tarefa, i);
            duracao.setText(this.tarefa.getDuracao().toString() + " dias");
            pack();
        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarEstimativaActionPerformed

    private void btnAterarProgressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAterarProgressoActionPerformed
        Integer i = 4;
        if (this.tarefa.getTaskDateIni() == null) {
            JOptionPane.showMessageDialog(null, "Você não pode alterar o progresso de uma tarefa que ainda não foi inciada.", "Inicie a tarefa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Integer p = Integer.parseInt(JOptionPane.showInputDialog("Qual a porcentagem de progresso da tarefa?"));
                if (p < 0)
                {
                    JOptionPane.showMessageDialog(null, "Informe um valor inteiro positivo ou 0.", "Valor inválido", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(p > 100)
                {
                    JOptionPane.showMessageDialog(null, "Informe um valor entre 0 e 100.", "Valor inválido.", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    this.tarefa.setProgresso(p);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Informe um valor numérico para o progresso.", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
            try {
                sp.getDaoTask().alterar(tarefa, i);
                porcentagem.setText(Integer.toString(this.tarefa.getProgresso()) + "%");
                progresso.setValue(this.tarefa.getProgresso());
                pack();
            } catch (Exception ex) {
                Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAterarProgressoActionPerformed

    private void btnAlterarDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDescricaoActionPerformed
        Integer i = 2;
        tarefa.setDescricao(areaDescricao.getText());
        try {
            sp.getDaoTask().alterar(this.tarefa, i);
            pack();
        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarDescricaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricao;
    private javax.swing.JButton btnAlterarDescricao;
    private javax.swing.JButton btnAlterarEstimativa;
    private javax.swing.JButton btnAterarProgresso;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel dataFinal;
    private javax.swing.JLabel dataInicio;
    private javax.swing.JLabel duracao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<Pessoa> listaPessoa;
    private javax.swing.JList<Task> listaPreRequisito;
    private javax.swing.JLabel nomeTarefa;
    private javax.swing.JLabel porcentagem;
    private javax.swing.JProgressBar progresso;
    // End of variables declaration//GEN-END:variables
}
