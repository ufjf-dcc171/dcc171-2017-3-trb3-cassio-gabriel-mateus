package JanelaPessoas;
 
 import controlBD.PessoaDAO;
 import controlDashBoard.Pessoa;
 import janelaControleProjeto.Dashboard;
 import java.util.List;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javax.swing.JOptionPane;
 
 public class JanelaPessoas extends javax.swing.JFrame {
 
     private List<Pessoa> pessoas;
     private final PessoaDAO daoPessoa;
 
     public JanelaPessoas(PessoaDAO daoPessoa, List<Pessoa> pessoas) {
         super("Detalhes");
         initComponents();
         this.daoPessoa = daoPessoa;
         this.pessoas = pessoas;
     }
 
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {
 
         jLabel1 = new javax.swing.JLabel();
         txtEmail = new javax.swing.JTextField();
         jLabel2 = new javax.swing.JLabel();
         txtNome1 = new javax.swing.JTextField();
         btnCadastrar = new javax.swing.JButton();
 
         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
         jLabel1.setText("Email:");
 
         txtEmail.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 txtEmailActionPerformed(evt);
             }
         });
 
         jLabel2.setText("Nome:");
 
         txtNome1.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 txtNome1ActionPerformed(evt);
             }
         });
 
         btnCadastrar.setText("Cadastrar");
         btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnCadastrarActionPerformed(evt);
             }
         });
 
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addGap(21, 21, 21)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jLabel1)
                         .addComponent(txtNome1)
                         .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                     .addComponent(btnCadastrar))
                 .addContainerGap(36, Short.MAX_VALUE))
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                     .addGap(22, 22, 22)
                     .addComponent(jLabel2)
                     .addContainerGap(274, Short.MAX_VALUE)))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addGap(78, 78, 78)
                 .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(18, 18, 18)
                 .addComponent(jLabel1)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                 .addComponent(btnCadastrar)
                 .addGap(80, 80, 80))
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                     .addGap(52, 52, 52)
                     .addComponent(jLabel2)
                     .addContainerGap(234, Short.MAX_VALUE)))
         );
 
         pack();
     }// </editor-fold>//GEN-END:initComponents
 
     private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_txtEmailActionPerformed
 
     private void txtNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome1ActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_txtNome1ActionPerformed
 
     private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
 
         Pessoa pessoa;
 
         try {
             if (txtEmail.getText() == null || txtNome1.getText() == null) {
                 JOptionPane.showMessageDialog(null, "Preencher todos os campos.", "Por favor preencha todos os campos.", JOptionPane.INFORMATION_MESSAGE);
             } else {
                 pessoa = new Pessoa(txtNome1.getText(), txtEmail.getText());
                 daoPessoa.criar(pessoa);
                 pessoas.add(pessoa);
                 JOptionPane.showMessageDialog(null, "Foi adicionado uma pessoa", "Pessoa criada com sucesso", JOptionPane.INFORMATION_MESSAGE);
             }
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }
 
 
     }//GEN-LAST:event_btnCadastrarActionPerformed
 
 
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton btnCadastrar;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JTextField txtEmail;
     private javax.swing.JTextField txtNome1;
     // End of variables declaration//GEN-END:variables
 }