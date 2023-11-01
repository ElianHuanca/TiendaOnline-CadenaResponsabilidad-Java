
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
public class AlmacenCentral extends Manejador{
    private Map<String, Integer> inventarioCentral;

    public AlmacenCentral() {
        inventarioCentral = new HashMap<>();
        inventarioCentral.put("ProductoA", 6);
        inventarioCentral.put("ProductoB", 8);
    }

    public int getCantidad(String producto){        
        return inventarioCentral.getOrDefault(producto, 0);
    }
    
    @Override
    public String procesarCompra(Compra compra) {
        int cantidadDisponible = inventarioCentral.getOrDefault(compra.getProducto(), 0);
        //String s= "Detalle Compra:\n";
        String s="";
        if (cantidadDisponible >= compra.getCantidad()) {
            s+="Pedido de " + compra.getCantidad() + " " + compra.getProducto() + " enviado desde Almacén Central ";
            // Reducir la cantidad en el inventario
            inventarioCentral.put(compra.getProducto(), cantidadDisponible - compra.getCantidad());
        } else if (sucessor != null) {
            s+="El Almacen Central no cuenta con ese stock\n";
            s+=sucessor.procesarCompra(compra);
        } else {
            s+="El Almacen Central no cuenta con ese stock\n";
            s+="Por Ende El stock del producto no está disponible en ningún almacén.";
        }
        return s;
    }
}
