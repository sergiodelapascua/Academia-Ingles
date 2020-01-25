/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t01p01_e02_DelaPascuaSergio;

import java.util.HashMap;

/**
 *
 * @author sergio
 */
public class Profesor extends Persona{
    
    protected HashMap<Integer, String> horario;

    public Profesor(String nombre, Niveles nivel, String apellido) {
        super(nombre, nivel, apellido);
        horario = new HashMap<Integer, String>();
    }

    public HashMap<Integer, String> getHorario() {
        return horario;
    }

    
    public void mostrarHorario(){
        System.out.print("\tLunes\tMartes\tMierc\tJueves\tViernes\n");
        System.out.print("16:00");
        for (int i = 0; i < 5; i++) {
            System.out.print("\t  "+horario.get(i));
        }
        System.out.print("\n18:00");
        for (int i = 5; i < 10; i++) {
            System.out.print("\t  "+horario.get(i));
        }
        System.out.print("\n20:00");
        for (int i = 10; i < 15; i++) {
            System.out.print("\t  "+horario.get(i));
        }
        System.out.println("\n--------------------AULA 2--------------------");
        System.out.print("16:00");
        for (int i = 15; i < 20; i++) {
            System.out.print("\t  "+horario.get(i));
        }
        System.out.print("\n18:00");
        for (int i = 20; i < 25; i++) {
            System.out.print("\t  "+horario.get(i));
        }
        System.out.print("\n20:00");
        for (int i = 25; i < 30; i++) {
            System.out.print("\t  "+horario.get(i));
        }
        System.out.println();
    }
    
    public int[] clases(){
        int cont = 0;
        int[] clases = new int[6];
        for (int i = 0; i < horario.size(); i++) {
            if(horario.get(i).equals(this.getNivel().name())){
                clases[cont] = i;
                cont++;
            }
        }
        
        return clases;
    }
}
