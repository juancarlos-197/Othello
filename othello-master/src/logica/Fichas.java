/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Usuario
 */
public class Fichas {
    
    private String caraActual;
    
    public Fichas(){
        this.caraActual = "";
    }
    
    public Fichas(String cara){
        this.caraActual = cara;
    }

    public String getCaraActual() {
        return caraActual;
    }

    public void setCaraActual(String caraActual) {
        this.caraActual = caraActual;
    }
    
    
}
