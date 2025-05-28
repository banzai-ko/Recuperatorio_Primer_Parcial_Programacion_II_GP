/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author gpennone
 */
public class PeliculaAccion extends Pelicula implements IAlquilable {

    private GeneroAccion tipoAccion;   
    
    public PeliculaAccion(String titulo, double precio, Director director, GeneroAccion tipoAccion) {
        super(titulo, precio, director);
        this.tipoAccion = tipoAccion;
    }

    public PeliculaAccion(String titulo, double precio, String nombre, String apellido, String dni, GeneroAccion tipoAccion) {
        this(titulo, precio, new Director(nombre, apellido, dni), tipoAccion);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Tipo: ").append(tipoAccion).append("\n");
        
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof PeliculaAccion)) return false;
        PeliculaAccion otra = (PeliculaAccion) obj;
        
        return this.tipoAccion == otra.tipoAccion;
    }
    
    @Override
    public double getPrecioAlquiler() {
        if (tipoAccion == GeneroAccion.AVENTURA) {
            return precio * 1.4;
        }
        if (tipoAccion == GeneroAccion.BELICA) {
            return precio * 1.3;
        }
        if (tipoAccion == GeneroAccion.SUPERHEROES) {
            return precio * 1.5;
        }
        return precio;
    }
}
