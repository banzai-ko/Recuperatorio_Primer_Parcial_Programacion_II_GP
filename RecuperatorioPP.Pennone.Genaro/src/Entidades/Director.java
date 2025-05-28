/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author gpennone
 */
public class Director {
    private String nombre;
    private String dni;
    private String apellido;  

    public Director(String nombre, String dni, String apellido) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
    }
    
     public static boolean sonIguales(Director a, Director b) {
        if (a == null || b == null) {
            return false;
        }
        return a.nombre.equals(b.nombre) &&
               a.apellido.equals(b.apellido) &&
               a.dni.equals(b.dni);
    }
     
    public String toString() {
        return this.nombre + " " + this.apellido;
    }
    
}
