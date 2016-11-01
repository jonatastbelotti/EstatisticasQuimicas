/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import utilidades.Amostra;

/**
 *
 * @author Jônatas T Belotti
 */
public class Estatistica {

  ArrayList<Amostra> amostras;

  public Estatistica() {
    amostras = new ArrayList<>();
  }

  public String calcular(String texto) {
    String resposta = "",
            nome = "",
            a = "",
            b = "",
            l = "",
            amostras[];

    amostras = texto.split("Color Analysis Report");

    for (String linha : amostras) {
      nome = "";
      a = "";
      b = "";
      l = "";

      if (linha.indexOf("Sample name :") > -1) {
        nome = linha.substring(linha.indexOf("Sample name :") + 13, linha.indexOf("File name")).replaceAll(" ", "");
      }      
      if (linha.indexOf("a* =") > -1) {
        a = linha.substring(linha.indexOf("a* =") + 4, linha.indexOf("b* =")).replaceAll(" ", "");
      }
      if (linha.indexOf("b* =") > -1) {
        b = linha.substring(linha.indexOf("b* =") + 4).replaceAll(" ", "");
      }
      if (linha.indexOf("L* =") > -1) {
        l = linha.substring(linha.indexOf("L* =") + 4, linha.indexOf("a* =")).replaceAll(" ", "");
      }
      
      inserir(nome, a, b, l);
    }
    
    for (int i = 0; i < this.amostras.size(); i++) {
      resposta += this.amostras.get(i).calcularMedias() + "\n";
    }

    return resposta;
  }
  
  private void inserir (String nome, String a, String b, String l){
    if (nome.equals("")) {
      return;
    }
    
    if (nome.indexOf("-") > -1) {
      nome = nome.substring(0, nome.indexOf("-"));
    }
    
    
    criarNovaAmostra(nome);
    
    for (int i = 0; i < this.amostras.size(); i++){
      if (amostras.get(i).getNome().equals(nome)) {
        if (!a.equals("")) {
          amostras.get(i).getListaA().add(Double.parseDouble(a));
        }        
        if (!b.equals("")) {
          amostras.get(i).getListaB().add(Double.parseDouble(b));
        }        
        if (!l.equals("")) {
          amostras.get(i).getListaL().add(Double.parseDouble(l));
        }        
      }
    }
  }
  
  private void criarNovaAmostra(String nome){
    for (int i = 0; i < this.amostras.size(); i++){
      if (amostras.get(i).getNome().equals(nome)) {
        return;
      }
    }
    
    Amostra amostra =  new Amostra();
    amostra.setNome(nome);
    amostras.add(amostra);
  }

}
