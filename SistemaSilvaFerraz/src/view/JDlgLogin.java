package view;

import bean.Usuario;
import dao.Usuario_DAO;
import view.JFrmPrincipal;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author u10840155107
 */
public class JDlgLogin extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public JDlgLogin(java.awt.Frame parent, boolean modal) {
        initComponents();
        setTitle("Login");
        setLocationRelativeTo(null);
    }

    int contagem;

    public void entrar() {
        System.out.println(jTxtUsuario.getText());
        System.out.println(jPwfSenha.getPassword());
        System.out.println(jTxtUsuario.getText());
        System.out.println(jPwfSenha.getPassword());
        
        String apelido = jTxtUsuario.getText();
        String senha = new String(jPwfSenha.getPassword());

        Usuario_DAO usuario_DAO = new Usuario_DAO();
        
        if (usuario_DAO.logar(apelido, senha) != null) {
            JFrmPrincipal jFrmPrincipal = new JFrmPrincipal();
            jFrmPrincipal.setVisible(true);
            JDlgLogin.this.dispose();
            contagem = 0;
        } else {
             contagem++;
             JOptionPane.showMessageDialog(null, "Usuário ou senha está incorreto" + contagem + "/3", "ERRO!", JOptionPane.ERROR_MESSAGE);
        } 
        if (contagem >= 3){
                JOptionPane.showMessageDialog(null, "Não é um usuário, o sistema será fechado", "ERRO!", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                }
            
            
//            if (jTxtUsuario.getText().equalsIgnoreCase("roupa") && jPwfSenha.getText().equalsIgnoreCase("roupa")) {
//            JFrmPrincipal jFrmPrincipal = new JFrmPrincipal();
//            jFrmPrincipal.setVisible(true);
//        } else if(jTxtUsuario.getText().equalsIgnoreCase("ferraz") && jPwfSenha.getText().equalsIgnoreCase("ferraz")) {
//        JFrmPrincipal jFrmPrincipal = new JFrmPrincipal();
//        jFrmPrincipal.setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(this, "Não é um usuário, ou há algo errado", "ERRO!", JOptionPane.ERROR_MESSAGE);
//        }
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
        jTxtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPwfSenha = new javax.swing.JPasswordField();
        jBtnAcessar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuário");

        jTxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Senha");

        jPwfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPwfSenhaActionPerformed(evt);
            }
        });

        jBtnAcessar.setText("Acessar");
        jBtnAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAcessarActionPerformed(evt);
            }
        });

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jPwfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnAcessar)
                        .addGap(73, 73, 73)
                        .addComponent(jBtnCancelar)))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPwfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAcessar)
                    .addComponent(jBtnCancelar))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtUsuarioActionPerformed

    private void jPwfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPwfSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPwfSenhaActionPerformed

    private void jBtnAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAcessarActionPerformed
        // TODO add your handling code here:
        entrar();
    }//GEN-LAST:event_jBtnAcessarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDlgLogin(null, true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAcessar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPwfSenha;
    private javax.swing.JTextField jTxtUsuario;
    // End of variables declaration//GEN-END:variables
}