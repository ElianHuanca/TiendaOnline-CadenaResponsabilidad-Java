
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elian
 */
public class AlmacenRegional extends Manejador{
    private Map<String, Integer> inventarioRegional;

    public AlmacenRegional() {
        inventarioRegional = new HashMap<>();
        inventarioRegional.put("ProductoA", 4);
        inventarioRegional.put("ProductoB", 6);
    }

    public int getCantidad(String producto){        
        return inventarioRegional.getOrDefault(producto, 0);
    }
    
    @Override
    public String procesarCompra(Compra compra) {
        int cantidadDisponible = inventarioRegional.getOrDefault(compra.getProducto(), 0);
        //String s= "Detalle Compra:\n";
        String s="";
        if (cantidadDisponible >= compra.getCantidad()) {
            s+="Pedido de " + compra.getCantidad() + " " + compra.getProducto() + " enviado desde Almacén Regional ";
            // Reducir la cantidad en el inventario
            inventarioRegional.put(compra.getProducto(), cantidadDisponible - compra.getCantidad());
        } else if (sucessor != null) {
            s+="El Almacen Regional no cuenta con ese stock\n";
            s+=sucessor.procesarCompra(compra);
        } else {
            System.out.println("El producto no está disponible en ningún almacén.");
        }
        return s;
    }
}
