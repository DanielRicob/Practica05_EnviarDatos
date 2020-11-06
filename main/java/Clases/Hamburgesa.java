package Clases;

import java.io.Serializable;
import java.security.PrivateKey;

public class Hamburgesa implements Serializable {
    private String tipo;
    private boolean cebolla;

public Hamburgesa(String tipo, boolean cebolla){
    this.tipo =tipo;
    this.cebolla = cebolla;
}

public String getTipo() { return tipo; }
public boolean getCebolla() { return cebolla ;}

}








