package Entidades;


import Entidades.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gpennone
 */
public class PeliculaDrama extends Pelicula implements IAlquilable {

    private GeneroDrama tipoDrama;
    
    public PeliculaDrama(String titulo, double precio, Director director, GeneroDrama tipoDrama) {
        super(titulo, precio, director);
        this.tipoDrama = tipoDrama;
    }

    public PeliculaDrama(String titulo, double precio, String nombre, String apellido, String dni, GeneroDrama tipoDrama) {
        this(titulo, precio, new Director(nombre, apellido, dni), tipoDrama);
    }
    
    @Override
    public double getPrecioAlquiler() {
        if (tipoDrama == GeneroDrama.ROMANTICO) {
            return precio * 1.5;
        }
        if (tipoDrama == GeneroDrama.SOCIAL) {
            return precio * 1.4;
        }
        if (tipoDrama == GeneroDrama.HISTORICO) {
            return precio * 1.2;
        }
        return precio;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo de drama: " + tipoDrama;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PeliculaDrama)) return false;
        PeliculaDrama otra = (PeliculaDrama) obj;
        return super.equals(otra) && this.tipoDrama == otra.tipoDrama;
    }
}

