/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controller.ControladorComanda;
import Controller.ControladorProduto;
import model.Comanda;
import model.Produto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joao Maggi
 */
public class TelaRealizarPedido extends javax.swing.JFrame {

    private static TelaRealizarPedido TelaRealizarPedidoUnic;
     
    public static TelaRealizarPedido geraRealizarPed() {
        if (TelaRealizarPedidoUnic == null) {
            TelaRealizarPedidoUnic = new TelaRealizarPedido();
        }
        return TelaRealizarPedidoUnic;
    }
    
    /**
     * Creates new form TelaRealizarPedido
     */
    public TelaRealizarPedido() {
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

        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        textIdPedido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textCpfPedido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textQntPedido = new javax.swing.JTextField();
        btnConfirmarPedido = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        VerItensButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("REALIZAR PEDIDO");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SERVE UP");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "PRECO", "DESCRIÇÃO", "CODIGO"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Qual item deseja pedir:");

        textIdPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIdPedidoActionPerformed(evt);
            }
        });

        jLabel4.setText("CPF cadastrado:");

        textCpfPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCpfPedidoActionPerformed(evt);
            }
        });

        jLabel5.setText("Quantidade");

        textQntPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textQntPedidoActionPerformed(evt);
            }
        });

        btnConfirmarPedido.setText("CONFIRMAR PEDIDO");
        btnConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPedidoActionPerformed(evt);
            }
        });

        jLabel6.setText("Itens disponiveis:");

        jButton1.setText("VOLTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        VerItensButton.setText("Ver Itens");
        VerItensButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerItensButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textCpfPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(btnConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textQntPedido))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(242, 242, 242)
                                        .addComponent(VerItensButton))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(VerItensButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(textQntPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textCpfPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarPedido)
                    .addComponent(jButton1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textIdPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIdPedidoActionPerformed
        
    }//GEN-LAST:event_textIdPedidoActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    sair(); 
    limparText();
    }//GEN-LAST:event_jButton1ActionPerformed
  
    private void textCpfPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCpfPedidoActionPerformed
        
    }//GEN-LAST:event_textCpfPedidoActionPerformed


    private void textQntPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textQntPedidoActionPerformed
      
    }//GEN-LAST:event_textQntPedidoActionPerformed

    private void btnConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPedidoActionPerformed
       btnConfirmarPedidoActionPerformed();
    }//GEN-LAST:event_btnConfirmarPedidoActionPerformed

    private void VerItensButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerItensButtonActionPerformed
        carregarTabelaProdutos();
    }//GEN-LAST:event_VerItensButtonActionPerformed
    
   
    
    private void carregarTabelaProdutos() {
            DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
            modelo.setNumRows(0); // Limpa a tabela

            ControladorProduto ctrlProduto = new ControladorProduto();
            List<Produto> listaProdutos = ctrlProduto.listarTodos();

            // Ajuste as colunas para "Código", "Nome", "Preço", "Descrição"
            for (Produto p : listaProdutos) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getPreco(),
                    p.getDescricao(),
                    p.getCodigoProduto()
                });
            }
        }
    
    public void btnConfirmarPedidoActionPerformed() {                                                  
        
        try {
            
            String cpf = textCpfPedido.getText();
            String codigoProdutoStr = textIdPedido.getText(); // Usando o nome da variável do NetBeans
            String quantidadeStr = textQntPedido.getText();

            if (cpf.trim().isEmpty() || codigoProdutoStr.trim().isEmpty() || quantidadeStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos (CPF, Código do Item, Quantidade) são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int codigoProduto = Integer.parseInt(codigoProdutoStr);
            int quantidade = Integer.parseInt(quantidadeStr);

            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ControladorProduto ctrlProduto = new ControladorProduto();
            
            Produto produtoSelecionado = ctrlProduto.buscarPorCodigo(codigoProduto);

            if (produtoSelecionado == null) {
                JOptionPane.showMessageDialog(this, "Nenhum produto encontrado com o código informado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ControladorComanda ctrlComanda = new ControladorComanda();
            Comanda comandaAtual = ctrlComanda.buscarOuAbrirComandaPorCpf(cpf);

            if (comandaAtual == null) {
                JOptionPane.showMessageDialog(this, "Não foi possível abrir ou encontrar uma comanda. Verifique se o cliente está cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ctrlComanda.adicionarItemNaComanda(comandaAtual.getId(), produtoSelecionado.getId(), quantidade);
            JOptionPane.showMessageDialog(this, "Item '" + produtoSelecionado.getNome() + "' adicionado à comanda " + comandaAtual.getId(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            limparText();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código do produto e quantidade devem ser números válidos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro no sistema: " + e.getMessage(), "Erro Inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }                                         
 
    
    public void sair(){
       this.dispose();
    }
    
    public void limparText(){
        textIdPedido.setText("");
        textQntPedido.setText("");
        textCpfPedido.setText("");
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VerItensButton;
    private javax.swing.JButton btnConfirmarPedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textCpfPedido;
    private javax.swing.JTextField textIdPedido;
    private javax.swing.JTextField textQntPedido;
    // End of variables declaration//GEN-END:variables
}
