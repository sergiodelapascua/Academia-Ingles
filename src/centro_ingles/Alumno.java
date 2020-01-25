package di_t01p01_e02_DelaPascuaSergio;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergio
 */
public class Alumno extends Persona implements Serializable, Comparable<Alumno>{
    
    private String nombrePadre;
    private int tefPadre;

    public Alumno(String nombre, Niveles nivel, String apellido) {
        super(nombre, nivel, apellido);
        nombrePadre = "";
        tefPadre = 00;
    }
    
    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public void setTefPadre(int tefPadre) {
        this.tefPadre = tefPadre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public int getTefPadre() {
        return tefPadre;
    }
    
    @Override
    public int compareTo(Alumno a) {
        return this.getNombre().compareTo(a.getNombre());
    }
    
}
