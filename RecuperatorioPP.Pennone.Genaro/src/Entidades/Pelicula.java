/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Random;

/**
 *
 * @author gpennone
 */
public class Pelicula {
    protected Director director;
    protected int cantidadDeEscenas;
    protected String titulo;
    protected double precio;
    protected static Random generadorDeEscenas;
    
    static {
        generadorDeEscenas = new Random();
    }

    public Pelicula(String titulo, double precio, Director director) {
        this.titulo = titulo;
        this.precio = precio;
        this.director = director;
        this.cantidadDeEscenas = 0;
    }


    public Pelicula(String titulo, double precio, String nombre, String apellido, String dni) {
        this(titulo, precio, new Director(nombre, apellido, dni));
    }
    
    public int getCantidadDeEscenas() {
        if (this.cantidadDeEscenas == 0) {
            this.cantidadDeEscenas = 20 + generadorDeEscenas.nextInt(31); // 20 a 50 inclusive
        }
        return this.cantidadDeEscenas;
    }
    
    private static String mostrarPelicula(Pelicula movie) {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula: ").append(movie.titulo).append("\n");
        sb.append("Director: ").append(movie.director.toString()).append("\n");
        sb.append("Cant Escenas: ").append(movie.getCantidadDeEscenas()).append("\n");
        
        return sb.toString();
    }
    
    public static boolean sonIguales(Pelicula p1, Pelicula p2) {
        if (p1 == null || p2 == null) {
        return false;
        }
        return p1.titulo.equals(p2.titulo) &&
               Director.sonIguales(p1.director, p2.director);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pelicula)) return false;
        Pelicula otra = (Pelicula) obj;
        return Pelicula.sonIguales(this, otra);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mostrarPelicula(this)).append("\n");
        sb.append("Precio: ").append(this.precio).append("\n");
        return sb.toString();
}
}
