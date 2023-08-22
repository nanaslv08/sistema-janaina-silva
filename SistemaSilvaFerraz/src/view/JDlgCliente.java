/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Cliente;
import dao.Cliente_DAO;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Janaina
 */
public class JDlgCliente extends javax.swing.JDialog {

        private boolean incluindo;
        MaskFormatter mascaraCpf;
        MaskFormatter mascaraRg;
        MaskFormatter mascaraData;
        MaskFormatter mascaraCelular;
        MaskFormatter mascaraCep;
        MaskFormatter mascaraNumCasa;

    /**
     * Creates new form JDlgCliente
     */
    public JDlgCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desabilitar();
        setTitle("Cadastro de Cliente");
        setLocationRelativeTo(null);
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraRg = new MaskFormatter("#.###.###");
            mascaraData = new MaskFormatter("##/##/####");
            mascaraCelular = new MaskFormatter("(##) #########");
            mascaraCep = new MaskFormatter("#####-###");
            mascaraNumCasa = new MaskFormatter("#########"); //falar com o marcos pra ver como fica
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        jFmtRG.setFormatterFactory(new DefaultFormatterFactory(mascaraRg));
        jFmtDataNasc.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
        jFmtCelular.setFormatterFactory(new DefaultFormatterFactory(mascaraCelular));
        jFmtCEP.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));
        jFmtNumCasa.setFormatterFactory(new DefaultFormatterFactory(mascaraNumCasa));  
    }

    public void habilitar(){
    jTxtCodigo.setEnabled(true);
    jTxtGenero.setEnabled(true);
    jFmtCEP.setEnabled(true);
    jFmtCPF.setEnabled(true);
    jFmtCelular.setEnabled(true);
    jFmtDataNasc.setEnabled(true);
    jFmtNumCasa.setEnabled(true);
    jFmtRG.setEnabled(true);
    jTxtRua.setEnabled(true);
    jTxtBairro.setEnabled(true);
    jTxtCidade.setEnabled(true);
    jTxtEmail.setEnabled(true);
    jTxtEstado.setEnabled(true);
    jTxtNaturalidade.setEnabled(true);
    jTxtNome.setEnabled(true);
    
    jBtnConfirmar.setEnabled(true);
    jBtnCancelar.setEnabled(true);
    
    //vão desabilitar
    jBtnIncluir.setEnabled(false);
    jBtnAlterar.setEnabled(false);
    jBtnExcluir.setEnabled(false);
    jBtnPesquisar.setEnabled(false);
    }
    
    public void desabilitar(){
    jTxtCodigo.setEnabled(false);
    jTxtGenero.setEnabled(false);
    jFmtCEP.setEnabled(false);
    jFmtCPF.setEnabled(false);
    jFmtCelular.setEnabled(false);
    jFmtDataNasc.setEnabled(false);
    jFmtNumCasa.setEnabled(false);
    jFmtRG.setEnabled(false);
    jTxtRua.setEnabled(false);
    jTxtBairro.setEnabled(false);
    jTxtCidade.setEnabled(false);
    jTxtEmail.setEnabled(false);
    jTxtEstado.setEnabled(false);
    jTxtNaturalidade.setEnabled(false);
    jTxtNome.setEnabled(false);
    
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

    
    jTxtCodigo.setEnabled(true);
    jTxtGenero.setEnabled(true);
    jFmtCEP.setEnabled(true);
    jFmtCPF.setEnabled(true);
    jFmtCelular.setEnabled(true);
    jFmtDataNasc.setEnabled(true);
    jFmtNumCasa.setEnabled(true);
    jFmtRG.setEnabled(true);
    jTxtRua.setEnabled(true);
    jTxtBairro.setEnabled(true);
    jTxtCidade.setEnabled(true);
    jTxtEmail.setEnabled(true);
    jTxtEstado.setEnabled(true);
    jTxtNaturalidade.setEnabled(true);
    jTxtNome.setEnabled(true);
    
    }
    
     public void limparCampos(){
        jTxtCodigo.setText("");
        jTxtNome.setText("");
        jFmtCPF.setText("");
        jFmtRG.setText("");
        jFmtDataNasc.setText("");
        jTxtGenero.setText("");
        jTxtEmail.setText("");
        jTxtNaturalidade.setText("");
        jFmtCelular.setText("");
        jTxtRua.setText("");
        jTxtBairro.setText("");
        jTxtCidade.setText("");
        jTxtEstado.setText("");
        jFmtNumCasa.setText("");
    }
    
    public Cliente ViewBean(){
        Cliente cliente = new Cliente();
        int id = Integer.valueOf(jTxtCodigo.getText());
        cliente.setIdcliente(id);
        cliente.setNome(jTxtNome.getText());
        cliente.setCpf(jFmtCPF.getText());
        cliente.setRg(jFmtRG.getText());
//        cliente.setData_nasc(jFmtDataNasc.getText());
        cliente.setGenero(jTxtGenero.getText());
        cliente.setEmail(jTxtEmail.getText());
        cliente.setNaturalidade(jTxtNaturalidade.getText());
        cliente.setCelular(jFmtCelular.getText());
        cliente.setCep(jFmtCEP.getText());
        cliente.setRua(jTxtRua.getText());
        cliente.setBairro(jTxtBairro.getText());
        cliente.setCidade(jTxtCidade.getText());
        cliente.setEstado(jTxtEstado.getText());
        cliente.setNumcasa(jFmtNumCasa.getText());
        return cliente;
    }
    
    public void beanView(Cliente cliente){
        String valor = String.valueOf(cliente.getIdcliente());
        jTxtCodigo.setText(valor);
        jTxtNome.setText(cliente.getNome());
        jFmtCPF.setText(cliente.getCpf());
        jFmtRG.setText(cliente.getRg());
//        jFmtDataNasc.setText(cliente.getData_nasc());
        jTxtGenero.setText(cliente.getGenero());
        jTxtEmail.setText(cliente.getEmail());
        jTxtNaturalidade.setText(cliente.getNaturalidade());
        jFmtCelular.setText(cliente.getCelular());
        jFmtCEP.setText(cliente.getCep());
        jTxtRua.setText(cliente.getRua());
        jTxtBairro.setText(cliente.getBairro());
        jTxtCidade.setText(cliente.getCidade());
        jTxtEstado.setText(cliente.getEstado());
        jFmtNumCasa.setText(cliente.getNumcasa());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jFmtCelular = new javax.swing.JFormattedTextField();
        jFmtNumCasa = new javax.swing.JFormattedTextField();
        jFmtCEP = new javax.swing.JFormattedTextField();
        jLabelNome = new javax.swing.JLabel();
        jTxtBairro = new javax.swing.JTextField();
        jLabelCPF = new javax.swing.JLabel();
        jTxtCidade = new javax.swing.JTextField();
        jLabelRG = new javax.swing.JLabel();
        jTxtEstado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtNaturalidade = new javax.swing.JTextField();
        jLabelGenero = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelNaturalidade = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jFmtCPF = new javax.swing.JFormattedTextField();
        jFmtRG = new javax.swing.JFormattedTextField();
        jFmtDataNasc = new javax.swing.JFormattedTextField();
        jTxtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTxtRua = new javax.swing.JTextField();
        jTxtGenero = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabelNome.setText("Nome");

        jLabelCPF.setText("CPF");

        jLabelRG.setText("RG");

        jLabel4.setText("Data de Nascimento");

        jLabel5.setText("Celular");

        jLabelGenero.setText("Genêro");

        jLabelEmail.setText("Email");

        jLabelNaturalidade.setText("Naturalidade");

        jLabel9.setText("Rua");

        jLabel10.setText("Bairro");

        jLabel11.setText("Número da Casa");

        jLabel12.setText("Cidade ");

        jLabel13.setText("Estado");

        jLabel14.setText("CEP");

        jTxtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeActionPerformed(evt);
            }
        });

        jFmtRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtRGActionPerformed(evt);
            }
        });

        jTxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigoActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jTxtRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtRuaActionPerformed(evt);
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
                        .addComponent(jBtnIncluir)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnPesquisar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(117, 117, 117)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelGenero)
                                    .addComponent(jTxtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jFmtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFmtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNome)
                                    .addComponent(jLabelCPF))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTxtNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNaturalidade)
                                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelEmail)
                                    .addComponent(jLabel14)
                                    .addComponent(jFmtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelRG))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtBairro)
                            .addComponent(jTxtCidade)
                            .addComponent(jTxtEstado)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jFmtNumCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13)
                                    .addComponent(jTxtRua))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelGenero)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabel10)
                            .addComponent(jLabelNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNaturalidade)
                            .addComponent(jLabel12)
                            .addComponent(jLabelCPF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRG)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFmtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel4))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFmtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jFmtNumCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnIncluir)
                        .addComponent(jBtnAlterar)
                        .addComponent(jBtnExcluir)
                        .addComponent(jBtnPesquisar)
                        .addComponent(jBtnCancelar)))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed

        habilitar();
        limparCampos();
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed

        habilitar();
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed

        Cliente_DAO cliente_DAO = new Cliente_DAO();
        if(incluindo == true){
          cliente_DAO.insert(ViewBean());//bean com bean retorna bean
        } else {
          cliente_DAO.update(ViewBean());
        }
        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
//        habilitar();
//        String pesquisar = JOptionPane.showInputDialog(null, "Entre com o código (FK)");
//        Cliente_DAO cliente_DAO = new Cliente_DAO();
//        int id = Integer.valueOf(pesquisar);
//        Cliente cliente = (Cliente) cliente_DAO.list(id); //list retorna o bean e ttansforma o bean em objeto
//        beanView(cliente);
//        ALterarExcluir();
        JDlgClientePesquisa jDlgClientePesquisa = new JDlgClientePesquisa(null, true);
        jDlgClientePesquisa.setTelaAnterior(this);
        jDlgClientePesquisa.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed

        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jTxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNomeActionPerformed

    private void jFmtRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtRGActionPerformed

    private void jTxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoActionPerformed

    private void jTxtRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtRuaActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        habilitar();
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION){
        Cliente_DAO cliente_DAO = new Cliente_DAO();
        cliente_DAO.delete(ViewBean()); //bean com bean retorna bean / sbean ao quadrado
        }else{
            JOptionPane.showMessageDialog(null, "Exclusão cancelada", "Alerta", 2);
        }
        limparCampos();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCliente dialog = new JDlgCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JFormattedTextField jFmtCEP;
    private javax.swing.JFormattedTextField jFmtCPF;
    private javax.swing.JFormattedTextField jFmtCelular;
    private javax.swing.JFormattedTextField jFmtDataNasc;
    private javax.swing.JFormattedTextField jFmtNumCasa;
    private javax.swing.JFormattedTextField jFmtRG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelNaturalidade;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelRG;
    private javax.swing.JTextField jTxtBairro;
    private javax.swing.JTextField jTxtCidade;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEstado;
    private javax.swing.JTextField jTxtGenero;
    private javax.swing.JTextField jTxtNaturalidade;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtRua;
    // End of variables declaration//GEN-END:variables
}
