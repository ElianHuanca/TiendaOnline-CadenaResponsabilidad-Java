/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elian
 */
public abstract class Manejador {
    protected Manejador sucessor;
    
    public void setSucessor(Manejador sucessor) {
        this.sucessor = sucessor;
    }
    
    public abstract String procesarCompra(Compra compra);            
}
