
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
public class AlmacenLocal extends Manejador{
    private Map<String, Integer> inventarioLocal;

    public AlmacenLocal() {
        inventarioLocal = new HashMap<>();
        inventarioLocal.put("ProductoA", 2);
        inventarioLocal.put("ProductoB", 4);
    }
    
    public int getCantidad(String producto){        
        return inventarioLocal.getOrDefault(producto, 0);
    }

    @Override
    public String procesarCompra(Compra compra) {
        int cantidadDisponible = inventarioLocal.getOrDefault(compra.getProducto(), 0);
        String s= "Detalle Compra:\n";
        if (cantidadDisponible >= compra.getCantidad()) {
            s+="Pedido de " + compra.getCantidad() + " " + compra.getProducto() + " enviado desde Almacén Local ";
            // Reducir la cantidad en el inventario
            inventarioLocal.put(compra.getProducto(), cantidadDisponible - compra.getCantidad());
        } else if (sucessor != null) {
            s+="El Almacen local no cuenta con ese stock\n";
            s+=sucessor.procesarCompra(compra);
        } else {
            System.out.println("El producto no está disponible en ningún almacén.");
        }
        return s;
    }
}
