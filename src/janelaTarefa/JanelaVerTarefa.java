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
import janelaDetalhesProjeto.JanelaDetalhesProjeto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class JanelaVerTarefa extends javax.swing.JFrame {

    private TaskPessoaDAO daoTaskPessoa;
    private TaskPreRequisitoDAO daoTaskPreRequisito;
    private List<Pessoa> pessoas;
    private List<Task> tarefas;
    private Task tarefa;
    public TaskDAO daoTask;

    public JanelaVerTarefa(Task tarefa, List<Pessoa> pessoas, List<Task> tarefas) throws Exception {
        super("Ver tarefas");
        initComponents();
        nomeTarefa.setText(tarefa.getTaskName());
        duracao.setText(Integer.toString(tarefa.getDuracao()) + " dias");
        progresso.setValue(tarefa.getProgresso());
        porcentagem.setText(Integer.toString(tarefa.getProgresso()) + "%");
        areaDescricao.setText(tarefa.getDescricao());
        this.pessoas = pessoas;
        this.tarefas = tarefas;
        this.tarefa = tarefa;
        if (tarefa.getTaskDateIni() == null) {
            dataInicio.setText("Ainda não iniciado");
            dataFinal.setText("Ainda não terminado");
        } else if (tarefa.getTaskDateEnd() == null) {
            dataInicio.setText(tarefa.getTaskDateIni());
            dataFinal.setText("Ainda não terminado");
        } else {
            dataInicio.setText(tarefa.getTaskDateIni());
            dataFinal.setText(tarefa.getTaskDateEnd());
        }
        daoTask = new TaskDAOJDBC();
        daoTaskPessoa = new TaskPessoaDAOJDBC();
        daoTaskPessoa.buscar(tarefa, pessoas);
        daoTaskPreRequisito = new TaskPreRequisitoDAOJDBC();
        daoTaskPreRequisito.buscar(tarefa, this.tarefas);
        if (tarefa.getPreRequisito().size() > 0) {
            listaPreRequisito.setModel(new TaskListModel(tarefa.getPreRequisito()));
        }
        if (tarefa.getPessoa().size() > 0) {
            listaPessoa.setModel(new PessoasListModel(tarefa.getPessoa()));
        }
        if (tarefa.getTaskDateIni() != null) {
            btnIniciar.setEnabled(false);
        }
        if (tarefa.getTaskDateEnd() != null) {
            tarefa.setProgresso(100);
            btnFinalizar.setEnabled(false);
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

        jLabel6.setText("Pré-requisito");

        jLabel7.setText("Pessoas");

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
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
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
                                        .addComponent(duracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlterarEstimativa)
                            .addComponent(btnAterarProgresso))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8)
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
                            .addComponent(btnFinalizar))
                        .addComponent(jScrollPane3))
                    .addComponent(btnAlterarDescricao, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterarDescricao))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (tarefa.getTaskDateIni() == null) {
            JOptionPane.showMessageDialog(null, "Você não pode finalizar uma tarefa que não foi iniciada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            int resposta = JOptionPane.showConfirmDialog(null, "Uma vez finalizada, não será possível alterar os dados da tarefa.", "Tem certeza que deseja finalizar?", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                Integer i = 1;
                Integer j = 4;
                Integer k = 5;
                Date data = new Date();
                tarefa.setStatus("Concluída");
                tarefa.setProgresso(100);
                tarefa.setTaskDateEnd(data);
                try {
                    daoTask.alterar(tarefa, i);
                    daoTask.alterar(tarefa, j);
                    daoTask.alterar(tarefa, k);
                    dataFinal.setText(tarefa.getTaskDateEnd());
                    btnFinalizar.setEnabled(false);
                    btnAlterarEstimativa.setEnabled(false);
                    btnAterarProgresso.setEnabled(false);
                    progresso.setValue(tarefa.getProgresso());
                    porcentagem.setText(Integer.toString(tarefa.getProgresso()) + "%");
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
            if (tarefa.getPreRequisito().size() > 0)
            {
                 ArrayList<Task> tar = tarefa.getPreRequisito();
                for (Task t : tar)
                {
                    if ("Concluída".equals(t.getStatus()))
                    {
                        podeIniciar = true;
                    }
                }
                if (podeIniciar)
                {
                    Date data = new Date();
                    tarefa.setStatus("Iniciada");
                    tarefa.setTaskDateIni(data);
                    daoTask.alterar(tarefa, i);
                    daoTask.alterar(tarefa, j);
                    dataInicio.setText(tarefa.getTaskDateIni());
                    btnIniciar.setEnabled(false);
                    pack();
                }
                else
                {
                    tarefa.setStatus("Pré-requisito");
                    daoTask.alterar(tarefa, j);
                }
            }
            else
            {
                Date data = new Date();
                tarefa.setStatus("Iniciada");
                tarefa.setTaskDateIni(data);
                daoTask.alterar(tarefa, i);
                daoTask.alterar(tarefa, j);
                dataInicio.setText(tarefa.getTaskDateIni());
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
                tarefa.setDuracao(d);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe um valor numérico para a estimativa.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            daoTask.alterar(tarefa, i);
            duracao.setText(tarefa.getDuracao().toString() + " dias");
            pack();
        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarEstimativaActionPerformed

    private void btnAterarProgressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAterarProgressoActionPerformed
        Integer i = 4;
        try {
            Integer p = Integer.parseInt(JOptionPane.showInputDialog("Qual a porcentagem de progresso da tarefa?"));
            if (p < 0) {
                JOptionPane.showMessageDialog(null, "Informe um valor inteiro positivo ou 0.", "Valor inválido", JOptionPane.INFORMATION_MESSAGE);
            } else {
                tarefa.setProgresso(p);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe um valor numérico para o progresso.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            daoTask.alterar(tarefa, i);
            porcentagem.setText(Integer.toString(tarefa.getProgresso()) + "%");
            progresso.setValue(tarefa.getProgresso());
            pack();
        } catch (Exception ex) {
            Logger.getLogger(JanelaDetalhesProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAterarProgressoActionPerformed

    private void btnAlterarDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDescricaoActionPerformed
        Integer i = 2;
        tarefa.setDescricao(areaDescricao.getText());
        try {
            daoTask.alterar(tarefa, i);
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
