/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Jônatas T Belotti
 */
public class Amostra {

  private String nome;
  ArrayList<Double> listaL;
  ArrayList<Double> listaA;
  ArrayList<Double> listaB;

  public Amostra() {
    listaA = new ArrayList<>();
    listaB = new ArrayList<>();
    listaL = new ArrayList<>();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ArrayList<Double> getListaL() {
    return listaL;
  }

  public void setListaL(ArrayList<Double> listaL) {
    this.listaL = listaL;
  }

  public ArrayList<Double> getListaA() {
    return listaA;
  }

  public void setListaA(ArrayList<Double> listaA) {
    this.listaA = listaA;
  }

  public ArrayList<Double> getListaB() {
    return listaB;
  }

  public void setListaB(ArrayList<Double> listaB) {
    this.listaB = listaB;
  }
  
  public String calcularMedias(){
    String resposta = "";
    DecimalFormat df = new DecimalFormat("0.#####");
    
    resposta += this.nome;    
    for (int i = resposta.length(); i < 15; i++){
      resposta += " ";
    }
    
    resposta += df.format(this.media(listaL));
    for (int i = resposta.length(); i < 30; i++){
      resposta += " ";
    }
    
    resposta += df.format(this.media(listaA));
    for (int i = resposta.length(); i < 45; i++){
      resposta += " ";
    }
    
    resposta += df.format(this.media(listaB));
    
    
    return resposta;
  }
  
  private Double media(ArrayList<Double> valores){
    Double soma = 0D;
    
    for (int i = 0; i < valores.size(); i++){
      soma += valores.get(i);
    }
    
    soma = soma / valores.size();
    
    return soma;
  }

}
