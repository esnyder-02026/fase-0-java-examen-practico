
package com.mycompany.proyectomaven;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario miInventario = new Inventario();
        boolean continuar = true;

        System.out.println("--- BIENVENIDO AL SISTEMA DE GESTION ---");

        while (continuar) {
            try {
                System.out.println("\n1. Agregar Producto");
                System.out.println("2. Mostrar Inventario");
                System.out.println("3. Buscar Producto");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");
                
                // Usamos Integer.parseInt para evitar problemas con el buffer del Scanner
                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del producto: ");
                        String nombre = sc.nextLine();
                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(sc.nextLine());
                        System.out.print("Cantidad: ");
                        int cantidad = Integer.parseInt(sc.nextLine());
                        
                        miInventario.agregar(new Producto(nombre, precio, cantidad));
                        System.out.println("¡Producto agregado con exito!");
                        break;

                    case 2:
                        System.out.println("\n--- LISTA DE PRODUCTOS ---");
                        miInventario.mostrarTodo();
                        break;

                    case 3:
                        System.out.print("Ingrese el nombre a buscar: ");
                        String busqueda = sc.nextLine();
                        Producto encontrado = miInventario.buscar(busqueda);
                        if (encontrado != null) {
                            System.out.println("Resultado: " + encontrado.toString());
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                        break;

                    case 4:
                        continuar = false;
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no valida, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Debes ingresar un numero valido. Intenta otra vez.");
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR DE VALIDACION: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado: " + e.getMessage());
            }
        }
        sc.close();
    }
}