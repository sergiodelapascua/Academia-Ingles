package di_t01p01_e02_DelaPascuaSergio;


import java.io.Serializable;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergio
 */
public class Clase implements Serializable{
    
    private Niveles nivel;
    private int aula;
    private TreeSet<Alumno> alumnosMatriculado; //maximo 8
    
    public Clase(Niveles niv, int aul){
        this.nivel = niv;
        if(aul <15)
            this.aula = 1;
        else
            this.aula = 2;
        alumnosMatriculado = new TreeSet<Alumno>();
    }

    public TreeSet<Alumno> getAlumnosMatriculado() {
        return alumnosMatriculado;
    }

    public Niveles getNivel() {
        return nivel;
    }  

    @Override
    public String toString() {
        return "Clase{ Nivel=" + nivel + ", aula=" + aula + ", alumnosMatriculado=" + alumnosMatriculado + '}';
    }
    
}
