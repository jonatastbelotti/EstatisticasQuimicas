package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Jônatas T Belotti
 */
public class Arquivo {

  public String lerArquivo(String caminho) {
    String resposta = "";

    try {
      FileReader arq = new FileReader(caminho);
      BufferedReader lerArq = new BufferedReader(arq);

      String linha = lerArq.readLine();
      while (linha != null) {
        resposta += linha;
        linha = lerArq.readLine();
      }
      arq.close();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.toString());
    }

    return resposta;
  }

  public void salvarArquivo(String caminhoArquivo, String textoArquivo) {
    try {
      FileWriter arq = new FileWriter(caminhoArquivo);
      PrintWriter gravarArq = new PrintWriter(arq);

      gravarArq.printf(textoArquivo);
      arq.close();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}
