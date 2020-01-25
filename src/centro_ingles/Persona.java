package di_t01p01_e02_DelaPascuaSergio;

import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergio
 */
public abstract class Persona implements Serializable{
    
    private String nombre;
    private Niveles nivel;
    private String apellido; 
    //private String horario;

    public Persona(String nombre, Niveles nivel, String apellido) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.apellido = apellido;
    }


    public String getNombre() {
        return nombre;
    }

    public Niveles getNivel() {
        return nivel;
    }

    public String getApellido() {
        return apellido;
    }

    /*public String getHorario() {
        return horario;
    }*/

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(Niveles nivel) {
        this.nivel = nivel;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String dameNombre(){
        return (nombre + " " + apellido);
    }
        
}
