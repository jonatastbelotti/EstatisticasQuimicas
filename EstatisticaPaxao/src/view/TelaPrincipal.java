/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.FileDialog;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import utilidades.Arquivo;

/**
 *
 * @author Jônatas T Belotti
 */
public class TelaPrincipal extends javax.swing.JFrame {

  /**
   * Creates new form TelaPrincipal
   */
  public TelaPrincipal() {
    initComponents();
    setLocationRelativeTo(null);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTxtArquivo = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jBtnSelecionarArquivo = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTxtResposta = new javax.swing.JTextPane();
    jTxtCalcular = new javax.swing.JButton();
    jBtnSalvarArquivo = new javax.swing.JButton();
    jBtnLimpar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Estatística  da Paxão s2");
    setResizable(false);

    jLabel1.setText("Arquivo:");

    jBtnSelecionarArquivo.setText("Procurar");
    jBtnSelecionarArquivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBtnSelecionarArquivoActionPerformed(evt);
      }
    });

    jScrollPane1.setViewportView(jTxtResposta);

    jTxtCalcular.setText("Calcular");
    jTxtCalcular.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTxtCalcularActionPerformed(evt);
      }
    });

    jBtnSalvarArquivo.setText("SALVAR");
    jBtnSalvarArquivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBtnSalvarArquivoActionPerformed(evt);
      }
    });

    jBtnLimpar.setText("Limpar");
    jBtnLimpar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBtnLimparActionPerformed(evt);
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
            .addComponent(jLabel1)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(jScrollPane1)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jTxtCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSalvarArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
              .addComponent(jTxtArquivo))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jBtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jBtnSelecionarArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(13, 13, 13)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTxtArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jBtnSelecionarArquivo))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTxtCalcular)
          .addComponent(jBtnSalvarArquivo)
          .addComponent(jBtnLimpar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jBtnSelecionarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelecionarArquivoActionPerformed
    FileDialog janelaArquivo;
    String caminho, nome;
    
    janelaArquivo= new FileDialog(this, "Selecone o arquivo", FileDialog.LOAD);
    janelaArquivo.setMultipleMode(false);
    janelaArquivo.setFile("*.txt");
    janelaArquivo.setVisible(true);
    caminho = janelaArquivo.getDirectory();
    nome = janelaArquivo.getFile();
    
    if (caminho != null && nome != null) {
      jTxtArquivo.setText(caminho + nome);
    }
  }//GEN-LAST:event_jBtnSelecionarArquivoActionPerformed

  private void jTxtCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCalcularActionPerformed
    Estatistica estatistica = new Estatistica();
    Arquivo arquivo = new Arquivo();

    if (jTxtArquivo.getText().equals("") == false) {
      jTxtResposta.setText(estatistica.calcular(arquivo.lerArquivo(jTxtArquivo.getText())));
    }
  }//GEN-LAST:event_jTxtCalcularActionPerformed

  private void jBtnSalvarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarArquivoActionPerformed
    FileDialog janelaSalvar = new FileDialog(this, "Salvar arquivo", FileDialog.SAVE);
    janelaSalvar.setVisible(true);
    String caminhoArquivo = "";

    if (!jTxtResposta.getText().equals("")) {
      Arquivo arquivo = new Arquivo();
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "TXT");
      chooser.setFileFilter(filter);
      chooser.setDialogTitle("Salvar arquivo");
      chooser.setApproveButtonText("Salvar");

      int op = chooser.showOpenDialog(this);
      if (op == JFileChooser.APPROVE_OPTION) {
        File arq = chooser.getSelectedFile();
        caminhoArquivo = arq.toString();

        if (caminhoArquivo.indexOf(".") == -1) {
          caminhoArquivo += ".txt";
        }

        arquivo.salvarArquivo(caminhoArquivo, jTxtResposta.getText());
      }
    }
  }//GEN-LAST:event_jBtnSalvarArquivoActionPerformed

  private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
    jTxtResposta.setText("");
  }//GEN-LAST:event_jBtnLimparActionPerformed

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
      java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new TelaPrincipal().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jBtnLimpar;
  private javax.swing.JButton jBtnSalvarArquivo;
  private javax.swing.JButton jBtnSelecionarArquivo;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField jTxtArquivo;
  private javax.swing.JButton jTxtCalcular;
  private javax.swing.JTextPane jTxtResposta;
  // End of variables declaration//GEN-END:variables
}
