package Clases;

import java.io.Serializable;

 public class Cantidad implements Serializable {
     private String Valor;
     private int Numero;

     public Cantidad(String Valor, Integer Numero){
         this.Valor =Valor;
         this.Numero = Numero;
     }

     public String getValor() { return Valor; }
     public Integer getNumero() { return Numero;}

 }
