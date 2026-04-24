
package com.mendez.examen;

/**
 *
 * @author Usuario
 */

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    // Uso obligatorio de List (Interfaz) y ArrayList (Implementación)
    private List<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    public void agregar(Producto producto) {
        listaProductos.add(producto);
    }

    public void mostrarTodo() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            // Usamos un bucle for-each tradicional (Sin lambdas)
            for (Producto p : listaProductos) {
                System.out.println(p.toString());
            }
        }
    }

    // Método adicional para buscar (útil para el examen)
    public Producto buscar(String nombre) {
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto p = listaProductos.get(i);
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
}
