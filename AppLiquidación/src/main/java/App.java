package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // PASO 1: Ingresar el nombre del vendedor
        System.out.println("--- Liquidación de Vendedor ---");
        System.out.print("Ingresa el nombre del vendedor: ");
        String nombreVendedor = scanner.nextLine(); 
        Vendedor vendedorSeleccionado = new Vendedor(nombreVendedor);
        System.out.println("\nHas seleccionado a: " + vendedorSeleccionado.getNombre());

        // PASO 2: LISTA DE PRODUCTOS PREDEFINIDA (con 3 parámetros)
        List<Producto> productosBase = new ArrayList<>();
        productosBase.add(new Producto("Papa Natural x 60 G", "Sexta", 14.400));
        productosBase.add(new Producto("Papas Limón x 60 G", "Sexta", 14.400));
        productosBase.add(new Producto("Papas Pimienta x 60 G", "Sexta", 14.400));
       /* productosBase.add(new Producto("Papas BBQ dulce x 60 G", "Sexta", 14.400));
        productosBase.add(new Producto("Platano verde natural x 70 G", "Sexta", 14.400));
        productosBase.add(new Producto("Platano verde natural x 70 G", "Sexta", 14.400));
        productosBase.add(new Producto("Platano verde limón x 70 G", "Sexta", 14.400));
        productosBase.add(new Producto("Cicharrón natural x 30 G", "Docena", 28.800));
        productosBase.add(new Producto("Cicharrón limón x 30 G", "Docena", 28.800));
        productosBase.add(new Producto("Platano maduro natural x 60 G", "Docena", 28.800));
        productosBase.add(new Producto("Platano maduro limón x 60 G", "Docena", 28.800));
        productosBase.add(new Producto("Chicharrin natural x 60 G", "Octava", 14.400));
        productosBase.add(new Producto("Chicharrin limón x 60 G", "Octava", 14.400));
        productosBase.add(new Producto("Rosquilla x 50 G", "Octava", 19.200));
        productosBase.add(new Producto("Aros de cebolla limón x 60 G", "Sexta", 13.800));
         */
        
        // PASO 3: RECORRER LA LISTA PARA OBTENER LAS CANTIDADES
        List<Producto> productosFinales = new ArrayList<>();
        
        System.out.println("\n--- Ingreso de Cantidades ---");
        for (Producto producto : productosBase) {
            try {
                System.out.println("Producto: " + producto.getNombreProducto());
                System.out.print("Cantidad cargada: ");
                int cantidadCargada = scanner.nextInt();
                
                System.out.print("Cantidad vendida: ");
                int cantidadVendida = scanner.nextInt();
                
                // IMPORTANTE: Consumir el salto de línea para el próximo ciclo
                scanner.nextLine();

                // Crear un nuevo objeto Producto con todos los datos
                productosFinales.add(new Producto(
                    producto.getNombreProducto(),
                    producto.getUnidadEmpaque(),
                    cantidadCargada,
                    cantidadVendida,
                    producto.getCosto()
                ));
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                scanner.nextLine(); // Consumir la entrada incorrecta para evitar un bucle
            }
        }

        // PASO 4: Ingresar el nombre del generador
        System.out.print("\nIngresa el nombre de la persona que genera la liquidación: ");
        String nombreGenerador = scanner.nextLine();
        
        // PASO 5: CALCULAR Y EXPORTAR
        Liquidacion liquidacionDelDia = new Liquidacion(vendedorSeleccionado, (ArrayList<Producto>) productosFinales, nombreGenerador);

        double totalAPagar = liquidacionDelDia.calcularLiquidacion();
        
        liquidacionDelDia.exportarInforme();

        System.out.println("\n--- Reporte de liquidación de " + vendedorSeleccionado.getNombre() + " ---");
        System.out.println("Valor total a pagar: $" + totalAPagar);
        
        System.out.println("\nEl programa ha finalizado. Presiona Enter para salir.");
        scanner.nextLine();
        scanner.close();
    }
}