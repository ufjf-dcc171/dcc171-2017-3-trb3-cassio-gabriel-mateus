package janelaProjeto;

import java.awt.Dimension;

public class DashboardMain extends javax.swing.JFrame {
    
    
    
    public DashboardMain() {
      super("DashBoard");
      initComponents();
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
        jlTarefas = new javax.swing.JLabel();
        btnDetails = new javax.swing.JButton();
        btnNewProject = new javax.swing.JButton();
        btnNewTask = new javax.swing.JButton();
        btAddPeople = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlProjetos.setText("Projetos:");

        jlTarefas.setText("Tarefas:");

        btnDetails.setText("Ver Detalhes");

        btnNewProject.setText("Novo Projeto");
        btnNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProjectActionPerformed(evt);
            }
        });

        btnNewTask.setText("Nova Tarefa");
        btnNewTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTaskActionPerformed(evt);
            }
        });

        btAddPeople.setText("Adicionar Pessoas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlProjetos)
                        .addGap(198, 198, 198)
                        .addComponent(jlTarefas))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewProject)
                        .addGap(68, 68, 68)
                        .addComponent(btnNewTask)
                        .addGap(96, 96, 96)
                        .addComponent(btnDetails)
                        .addGap(81, 81, 81)
                        .addComponent(btAddPeople)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlProjetos)
                    .addComponent(jlTarefas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewProject)
                    .addComponent(btnNewTask)
                    .addComponent(btAddPeople)
                    .addComponent(btnDetails))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewProjectActionPerformed

    private void btnNewTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTaskActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_btnNewTaskActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddPeople;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnNewProject;
    private javax.swing.JButton btnNewTask;
    private javax.swing.JLabel jlProjetos;
    private javax.swing.JLabel jlTarefas;
    // End of variables declaration//GEN-END:variables
}
