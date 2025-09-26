package main.java;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Liquidacion {
    // Variables de la clase Liquidacion
    private Vendedor vendedor;
    private ArrayList <Producto> productosVendedor = new ArrayList<>();
    private LocalDate fechaLiquidacion;
    private String generadorLiquidacion;
    
    // constructor de la clase Liquidacion
// Constructor corregido
public Liquidacion(Vendedor vendedor, List<Producto> productosVendidos, String generadorLiquidacion) {
    this.vendedor = vendedor;
    this.productosVendedor = new ArrayList<>(productosVendidos); // Se inicializa el ArrayList aquí
    this.fechaLiquidacion = LocalDate.now();
    this.generadorLiquidacion = generadorLiquidacion;
}
    
    // Metodos de encapsulamienyo
 public String getAdministrador() {
        return generadorLiquidacion;
    }

    public LocalDate getFechaLiquidacion() {
        return fechaLiquidacion;
    }

    // Metodo para calcular la liquidacion 
public double calcularLiquidacion(){
    double total = 0.0; 

    //ciclo para recorrer el ArrayList
    for(Producto producto: productosVendedor){
        total += producto.getValorTotalProducto();
    }
    return total;
}
    //  Metodo para exportar el reporte 
public void exportarInforme(){
    String nombreArchivo = "Liquidación" + this.vendedor.getNombre() + ".txt";
    try (FileWriter escritor = new FileWriter(nombreArchivo)) {
        // Escribe los detalles del encabezado
        escritor.write("--- Reporte de Liquidación ---\n");
        escritor.write("Vendedor: " + this.vendedor.getNombre() + "\n");
        escritor.write("Revisor: " + this.generadorLiquidacion + "\n");
        escritor.write("Fecha de Liquidación: " + this.fechaLiquidacion + "\n\n");

        // Escribe la tabla de detalles de productos
        escritor.write(String.format("%-25s | %-15s | %-15s | %-15s | %-15s\n", 
            "Producto", "Cant. Cargada", "Cant. Vendida", "Costo Unitario", "Valor a Pagar"));
        escritor.write("--------------------------------------------------------------------------------------------------\n");
       DecimalFormat formato = new DecimalFormat("#,###.###");   
        for (Producto p : productosVendedor) {
           escritor.write(String.format("%-25s | %-15d | %-15d | $%-15.3f | $%-15.3f\n",
        p.getNombreProducto(),
        p.getCantidadCargue(),
        p.getCantidadVendida(),
        p.getCosto(),
        p.getValorTotalProducto()
            ));
        }
        
        // Escribe el total
        escritor.write("--------------------------------------------------------------------------------------------------\n");
        escritor.write(String.format("%-80s | $%-15.3f\n", "TOTAL LIQUIDACIÓN:", this.calcularLiquidacion()));
        
        System.out.print("Liquidación exportada exitosamente a: " + nombreArchivo);

    } catch (IOException e) {
        System.out.println("Ocurrió un error al exportar la liquidación.");
        e.printStackTrace();
    }
}

public void exportarLiquidacion() {
    throw new UnsupportedOperationException("Unimplemented method 'exportarLiquidacion'");
}
}








