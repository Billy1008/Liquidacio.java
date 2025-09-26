package main.java;

public class Producto {
    private String nombreProducto;
    private String unidadEmpaque;
    private int cantidadCargue;
    private int cantidadVendida;
    private double costo;

    // Constructor 1: para la lista predefinida (sin cantidades)
    public Producto(String nombreProducto, String unidadEmpaque, double costo) {
        this.nombreProducto = nombreProducto;
        this.unidadEmpaque = unidadEmpaque;
        this.costo = costo;
        this.cantidadCargue = 0; // Inicializa en 0
        this.cantidadVendida = 0; // Inicializa en 0
    }

    // Constructor 2: para los productos finales (con todas las cantidades)
    public Producto(String nombreProducto, String unidadEmpaque, int cantidadCargue, int cantidadVendida, double costo) {
        this.nombreProducto = nombreProducto;
        this.unidadEmpaque = unidadEmpaque;
        this.cantidadCargue = cantidadCargue;
        this.cantidadVendida = cantidadVendida;
        this.costo = costo;
    }
    
    // Métodos Getters
    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getUnidadEmpaque() {
        return unidadEmpaque;
    }

    public int getCantidadCargue() {
        return cantidadCargue;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }
    
    public double getCosto() {
        return costo;
    }
    
    // **ESTE ES EL MÉTODO QUE FALTA EN TU CÓDIGO ACTUAL**
    public double getValorTotalProducto(){
        return this.cantidadVendida * this.costo;
    }
}