/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author box
 */
public class VideoClub implements Iterable<Pelicula>, Iterator<Pelicula> {

    private int capacidad;
    private int posicion;
    private ArrayList<Pelicula> peliculas;
    private int iteradorPos;
    
    
      public VideoClub() {
        this(3);
    }
      
      public VideoClub(int capacidad) {
        this.capacidad = capacidad;
        this.peliculas = new ArrayList<>();
        this.posicion = 0;
        this.iteradorPos = 0;
    }
      private boolean sonIguales(Pelicula p) {
        for (Pelicula existente : peliculas) {
            if (existente.equals(p)) {
                return true;
            }
        }
        return false;
    }
      
     public void agregar(Pelicula p) {
        if (peliculas.size() >= capacidad) {
            System.out.println("No hay más capacidad en el videoclub.");
        } else if (this.sonIguales(p)) {
            System.out.println("La película ya está en el videoclub.");
        } else {
            peliculas.add(p);
            System.out.println("Película agregada exitosamente.");
        }
    }
     
     @Override
    public boolean hasNext() {
        return iteradorPos < peliculas.size();
    }

    @Override
    public Pelicula next() {
        return peliculas.get(iteradorPos++);
    }

    @Override
    public Iterator<Pelicula> iterator() {
        iteradorPos = 0;
        return this;
    }
     private double getPrecio(TipoPelicula tipo) {
        double total = 0.0;
        for (Pelicula p : peliculas) {
            if (tipo == TipoPelicula.DRAMA && p instanceof PeliculaDrama) {
                total += ((PeliculaDrama) p).getPrecioAlquiler();
            } else if (tipo == TipoPelicula.ACCION && p instanceof PeliculaAccion) {
                total += ((PeliculaAccion) p).getPrecioAlquiler();
            }
        }
        return total;
    }

    public double getPrecioPeliculasDrama() {
        return getPrecio(TipoPelicula.DRAMA);
    }

    public double getPrecioPeliculasAccion() {
        return getPrecio(TipoPelicula.ACCION);
    }

    public double getPrecioTotal() {
        return getPrecioPeliculasDrama() + getPrecioPeliculasAccion();
    }
    
    public static String mostrarTotales(VideoClub vc) {
        int cantidad = vc.peliculas.size();
        double drama = vc.getPrecioPeliculasDrama();
        double accion = vc.getPrecioPeliculasAccion();
        double total = vc.getPrecioTotal();
        return "Películas: " + cantidad + ", Total Drama: " + drama + ", Total Acción: " + accion + ", Total General: " + total;
    }
}
