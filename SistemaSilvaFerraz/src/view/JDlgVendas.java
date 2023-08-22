/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

//import bean.Vendas;
import bean.Cliente;
import bean.Venda;
import bean.Vendedor;
import dao.Cliente_DAO;
import dao.Venda_DAO;
import dao.Vendedor_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Janaína B da Silva
 */
public class JDlgVendas extends javax.swing.JDialog {

    private boolean incluindo;
    private Venda_DAO venda_DAO;
    Venda venda;
    MaskFormatter mascaraData;


    /**
     * Creates new form vendas
     */
    public JDlgVendas(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
        desabilitar();
        jBtnAlterarProd.setEnabled(false);
        jBtnExcluirProd.setEnabled(false);
        jBtnIncluirProd.setEnabled(false);
        setTitle("Cadastro de Vendas");
        setLocationRelativeTo(null);
        venda_DAO = new Venda_DAO();
        List lista = new ArrayList();
        
        Cliente_DAO cliente_DAO = new Cliente_DAO();
        List lista1 = cliente_DAO.listAll();
        for (int c = 0; c < lista1.size(); c++) {
        jCboCliente.addItem((Cliente)lista1.get(c));
        }
        
        Vendedor_DAO vendedor_DAO = new Vendedor_DAO();
        List lista2 = vendedor_DAO.listAll();
        for (int v = 0; v < lista2.size(); v++) {
        jCboVendedor.addItem((Vendedor)lista2.get(v));
        }
        
        
        try {
            mascaraData = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtDataVenda.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
    }

    
    public void habilitar(){
    jTxtNumOs.setEnabled(true);
    jFmtDataVenda.setEnabled(true);
    jCboCliente.setEnabled(true);
    jCboVendedor.setEnabled(true);
    jTxtTotal.setEnabled(true);
    
    jBtnConfirmar.setEnabled(true);
    jBtnCancelar.setEnabled(true);
    
    //vão desabilitar
    jBtnIncluir.setEnabled(false);
    jBtnAlterar.setEnabled(false);
    jBtnExcluir.setEnabled(false);
    jBtnPesquisar.setEnabled(false);
    }
    
    public void desabilitar(){
    jTxtNumOs.setEnabled(false);
    jFmtDataVenda.setEnabled(false);
    jCboCliente.setEnabled(false);
    jCboVendedor.setEnabled(false);
    jTxtTotal.setEnabled(false);
    
    jBtnConfirmar.setEnabled(false);
    jBtnCancelar.setEnabled(false);
        
    jBtnIncluir.setEnabled(true);
    jBtnAlterar.setEnabled(true);
    jBtnExcluir.setEnabled(true);
    jBtnPesquisar.setEnabled(true);
    }
    
    public void ALterarExcluir(){
    jBtnAlterar.setEnabled(true);
    jBtnExcluir.setEnabled(true);
    jBtnPesquisar.setEnabled(false);
    jBtnIncluir.setEnabled(false);
    jBtnConfirmar.setEnabled(false);
    jBtnCancelar.setEnabled(true);

    
    jTxtNumOs.setEnabled(true);
    jFmtDataVenda.setEnabled(true);
    jCboCliente.setEnabled(true);
    jCboVendedor.setEnabled(true);
    jTxtTotal.setEnabled(true);
    }
    
    public void limparCampos(){
        jTxtNumOs.setText("");
        jFmtDataVenda.setText("");
        jCboCliente.setSelectedIndex(-1);
        jCboVendedor.setSelectedItem(-1);
        jTxtTotal.setText("");
    }
    
    public Venda ViewBean(){
        Venda vendas = new Venda();
        int id = Integer.valueOf(jTxtNumOs.getText());
        vendas.setIdvenda(id);
//        vendas.setTotal(jTxtTotal.getText());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            vendas.setData(formato.parse(jFmtDataVenda.getText()));
        } catch (ParseException ex) {
            //Logger.getLogger(JDlgVendass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("por favor funciona: " + ex.getMessage());
        }
        
        venda.setCliente(jCboCliente.getSelectedIndex());
        venda.setVendedor(jCboVendedor.getSelectedIndex());
        
//        Cliente cliente1 = (Cliente) jCboCliente.getSelectedItem();
//        venda.setCliente(cliente1.getIdcliente());
//        
//        Vendedor vendedor1 = (Vendedor) jCboVendedor.getSelectedItem();
//        venda.setVendedor(vendedor1.getIdvendedor());
//        
//        venda.setTotal(Double.parseDouble(jTxtTotal.getText()));
        
        String txtTotal = jTxtTotal.getText();
        double total = Double.parseDouble(txtTotal);
        vendas.setTotal(total);
        
        return vendas;
    }
    
    public void beanView(Venda venda){
        String valor = String.valueOf(venda.getIdvenda());
        jTxtNumOs.setText(valor);
        jTxtTotal.setText(String.valueOf(venda.getTotal()));
//        jTxtTotal.setText(venda.getTotal());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        String dataStr = formato.format();
        jFmtDataVenda.setText(formato.format(venda.getData()));
        jCboCliente.setSelectedIndex(venda.getCliente());
        jCboVendedor.setSelectedIndex(venda.getVendedor());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTxtNumOs = new javax.swing.JTextField();
        jTxtTotal = new javax.swing.JTextField();
        jCboCliente = new javax.swing.JComboBox<Cliente>();
        jCboVendedor = new javax.swing.JComboBox<Vendedor>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBtnIncluirProd = new javax.swing.JButton();
        jBtnAlterarProd = new javax.swing.JButton();
        jBtnExcluirProd = new javax.swing.JButton();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jFmtDataVenda = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTxtNumOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNumOsActionPerformed(evt);
            }
        });

        jLabel1.setText("Num OS");

        jLabel2.setText("Cliente");

        jLabel3.setText("Vendedor");

        jLabel4.setText("Total");

        jLabel5.setText("Data");

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirProdActionPerformed(evt);
            }
        });

        jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarProdActionPerformed(evt);
            }
        });

        jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProdActionPerformed(evt);
            }
        });

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jFmtDataVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtDataVendaActionPerformed(evt);
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
                            .addComponent(jTxtNumOs, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFmtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(96, 96, 96)
                                .addComponent(jLabel2)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnExcluirProd)
                                    .addComponent(jBtnIncluirProd)
                                    .addComponent(jBtnAlterarProd)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnIncluir)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnPesquisar)))
                        .addContainerGap(54, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNumOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluirProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterarProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluirProd)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnIncluir)
                        .addComponent(jBtnAlterar)
                        .addComponent(jBtnExcluir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jBtnCancelar)
                        .addComponent(jBtnPesquisar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        habilitar();
        limparCampos();
        incluindo = true;
        jBtnAlterarProd.setEnabled(false);
        jBtnExcluirProd.setEnabled(false);
        jBtnIncluirProd.setEnabled(false);
        //Double.parseDouble(String string);
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed

        habilitar();
        incluindo = false;
        jBtnAlterarProd.setEnabled(false);
        jBtnExcluirProd.setEnabled(false);
        jBtnIncluirProd.setEnabled(false);
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        habilitar();
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?",
            "Confirmar", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION){
            Venda_DAO vendas_DAO = new Venda_DAO();
            vendas_DAO.delete(ViewBean()); //bean com bean retorna bean / sbean ao quadrado
        }else{
            JOptionPane.showMessageDialog(null, "Exclusão cancelada", "Alerta", 2);
        }
        limparCampos();
        jBtnAlterarProd.setEnabled(false);
        jBtnExcluirProd.setEnabled(false);
        jBtnIncluirProd.setEnabled(false);
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        Venda_DAO vendas_DAO = new Venda_DAO();
        if(incluindo == true){
            vendas_DAO.insert(ViewBean());//bean com bean retorna bean
        } else {
            vendas_DAO.update(ViewBean());
        }
        desabilitar();
        limparCampos();
        jBtnAlterarProd.setEnabled(false);
        jBtnExcluirProd.setEnabled(false);
        jBtnIncluirProd.setEnabled(false);          
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        //habilitar();
//        String pesquisar = JOptionPane.showInputDialog(null, "Entre com o código (FK)");
//        Venda_DAO vendas_DAO = new Venda_DAO();
//        int id = Integer.valueOf(pesquisar);
//        Venda vendas = (Venda) vendas_DAO.list(id); //list retorna o bean e ttansforma o bean em objeto
//        beanView(vendas);
//        ALterarExcluir();
        //
        JDlgVendasPesquisa jDlgVendasPesquisa = new JDlgVendasPesquisa(null, true);
        jDlgVendasPesquisa.setTelaAnterior(this);
        jDlgVendasPesquisa.setVisible(true);
        jBtnAlterarProd.setEnabled(true);
        jBtnExcluirProd.setEnabled(true);
        jBtnIncluirProd.setEnabled(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed

        desabilitar();
        limparCampos();
        jBtnAlterarProd.setEnabled(false);
        jBtnExcluirProd.setEnabled(false);
        jBtnIncluirProd.setEnabled(false);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jTxtNumOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNumOsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNumOsActionPerformed

    private void jBtnAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarProdActionPerformed
        // TODO add your handling code here:
        JDlgVendasProduto jDlgVendasProduto = new JDlgVendasProduto(null, true);
        jDlgVendasProduto.setTitle("Alterar Venda");
        jDlgVendasProduto.setVisible(true);
    }//GEN-LAST:event_jBtnAlterarProdActionPerformed

    private void jFmtDataVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtDataVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtDataVendaActionPerformed

    private void jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirProdActionPerformed
        // TODO add your handling code here:
        JDlgVendasProduto jDlgVendasProduto = new JDlgVendasProduto(null, true);
        jDlgVendasProduto.setTitle("Incluir Venda");
        jDlgVendasProduto.setVisible(true);
        
        
    }//GEN-LAST:event_jBtnIncluirProdActionPerformed

    private void jBtnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProdActionPerformed
        // TODO add your handling code here:
        JDlgVendasProduto jDlgVendasProduto = new JDlgVendasProduto(null, true);
        jDlgVendasProduto.setTitle("Excluir Venda");
        jDlgVendasProduto.setVisible(true);
    }//GEN-LAST:event_jBtnExcluirProdActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendas dialog = new JDlgVendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterarProd;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirProd;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<Cliente> jCboCliente;
    private javax.swing.JComboBox<Vendedor> jCboVendedor;
    private javax.swing.JFormattedTextField jFmtDataVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtNumOs;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
