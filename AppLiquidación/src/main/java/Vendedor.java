package main.java;

public class Vendedor {
    //variables de la clase Vendedor
private String nombre;

// constructor de la clase Vendedor
public Vendedor(String nombreVendedor) {
    this.nombre = nombreVendedor;
}

// Metodos para encapsulamiento 
public String getNombre() {
    return this.nombre;
}

public void setNombre(String nuevoNombre) {
    this.nombre = nuevoNombre;
}


}
