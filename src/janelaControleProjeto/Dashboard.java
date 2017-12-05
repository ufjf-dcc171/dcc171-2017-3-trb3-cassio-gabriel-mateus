package janelaControleProjeto;

import controlBD.PessoaDAO;
import controlBD.ProjetoDAO;
import controlBD.TaskDAO;
import controlDashBoard.Pessoa;
import controlDashBoard.Project;
import controlDashBoard.ProjectListModel;
import janelaDetalhesProjeto.JanelaDetalhesProjeto;
import JanelaPessoas.JanelaPessoas;
import janelaTarefa.JanelaAdicionarTarefa;
import janelaTarefa.JanelaVerTarefa;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dashboard extends javax.swing.JFrame {

    public ProjetoDAO daoProjeto;
    public TaskDAO daoTask;
    public PessoaDAO daoPessoa;
    private final List<Project> project;
    private JanelaDetalhesProjeto jdp;
    private JanelaAdicionarTarefa jat;
    private JanelaPessoas jp;
    private List<Pessoa> pessoas;
    private JanelaVerTarefa jvt;

    public Dashboard(ProjetoDAO daoProjeto, List<Project> projeto, JanelaDetalhesProjeto jdp, 
            JanelaAdicionarTarefa jat, TaskDAO daoTask, PessoaDAO daoPessoa, JanelaPessoas jp,
            List<Pessoa> pessoas, JanelaVerTarefa jvt) {
        super("DashBoard");
        initComponents();
        this.daoProjeto = daoProjeto;
        this.daoTask = daoTask;
        this.daoPessoa = daoPessoa;
        this.project = projeto;
        this.jdp = jdp;
        this.jat = jat;
        this.jp = jp;
        this.jvt = jvt;
        this.pessoas = pessoas;
        listaProjetos.setModel(new ProjectListModel(this.project));
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

        jlProjetos = new javax.swing.JLabel();
        txtProjectTitulo = new javax.swing.JTextField();
        btNewProject = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProjetos = new javax.swing.JList<>();
        btDetailsProject = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtProjectDescrition = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnAdicionarPessoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlProjetos.setText("Projeto:");

        txtProjectTitulo.setText("Digite aqui o nome do novo projeto...");
        txtProjectTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProjectTituloActionPerformed(evt);
            }
        });

        btNewProject.setText("Criar Projeto");
        btNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewProjectActionPerformed(evt);
            }
        });

        listaProjetos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaProjetos.setToolTipText("");
        jScrollPane1.setViewportView(listaProjetos);

        btDetailsProject.setText("Ver detalhes");
        btDetailsProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetailsProjectActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição:");

        txtProjectDescrition.setColumns(20);
        txtProjectDescrition.setRows(5);
        jScrollPane2.setViewportView(txtProjectDescrition);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("Projetos Existentes");

        btnAdicionarPessoa.setText("Adicionar Pessoa");
        btnAdicionarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPessoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProjectTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btNewProject))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdicionarPessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDetailsProject)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlProjetos)
                    .addComponent(txtProjectTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 57, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(btNewProject)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDetailsProject)
                    .addComponent(btnAdicionarPessoa))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProjectTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProjectTituloActionPerformed

    }//GEN-LAST:event_txtProjectTituloActionPerformed

    private void btNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewProjectActionPerformed

        Project projeto;
        try {
            if (txtProjectTitulo.getText() == null || txtProjectTitulo.getText().equals("Digite aqui o nome do novo projeto...")) {
                JOptionPane.showMessageDialog(null, "Você deveria ter digitado um nome correto.", "Digite um nome correto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                projeto = new Project(txtProjectTitulo.getText(), txtProjectDescrition.getText());
                project.add(projeto);
                listaProjetos.updateUI();
                daoProjeto.criar(projeto);
            }
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btNewProjectActionPerformed

    private void btDetailsProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetailsProjectActionPerformed
        Project selecionado = listaProjetos.getSelectedValue();
        if (selecionado == null) {
            JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um projeto.", "Selecione um projeto.", JOptionPane.INFORMATION_MESSAGE);

        } else {
            try {
            jdp = new JanelaDetalhesProjeto(selecionado, daoProjeto, jat, daoTask, jvt, daoPessoa);
            jdp.setVisible(true);
            jdp.setLocationRelativeTo(null);
            jdp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } catch (Exception ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btDetailsProjectActionPerformed

    private void btnAdicionarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPessoaActionPerformed
        jp = new JanelaPessoas(daoPessoa, pessoas);
        jp.setVisible(true);
        jp.setLocationRelativeTo(null);
        jp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnAdicionarPessoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDetailsProject;
    private javax.swing.JButton btNewProject;
    private javax.swing.JButton btnAdicionarPessoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlProjetos;
    private javax.swing.JList<Project> listaProjetos;
    private javax.swing.JTextArea txtProjectDescrition;
    private javax.swing.JTextField txtProjectTitulo;
    // End of variables declaration//GEN-END:variables
}
