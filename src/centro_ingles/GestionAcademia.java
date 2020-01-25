package di_t01p01_e02_DelaPascuaSergio;

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
public class GestionAcademia {
    
    //matricular alumno,, mostrar alumno su clase, mostrar profesor horario, profesor clases de dai X
    private static void menu(){
        System.out.println("\n---------------Menu Alumno--------------");
        System.out.println(" 1.Matricular Alumno.");
        System.out.println(" 2.Mostrar horario de un Alumno.");
        System.out.println("-------------Menu Profesores------------");
        System.out.println(" 3.Mostrar su horario.");
        System.out.println(" 4.Mostrar alumnos por horas de clase.");
        System.out.println(" 5.Salir");
    }
        
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        CentroIngles centro = new CentroIngles();
        /*System.out.println("HORARIO CREADO XD: ");
        for(Map.entry m:centro.getHorario())*/
        
        //BATERIA DE DATOS PARA COMPROBAR COSAS
        /*Alumno a1 = new Alumno("A",Niveles.A1,"a");
        Alumno a2 = new Alumno("B",Niveles.A1,"b");
        Alumno a3 = new Alumno("C",Niveles.A1,"c");
        Alumno a4 = new Alumno("D",Niveles.A1,"d");
        Alumno a5 = new Alumno("E",Niveles.A1,"e");
        Alumno a6 = new Alumno("F",Niveles.A1,"f");
        Alumno a7 = new Alumno("G",Niveles.A1,"g");
        Alumno a8 = new Alumno("H",Niveles.A1,"h");
        Alumno a9 = new Alumno("i",Niveles.A1,"i");
        
        centro.añadirAlumno(0, a1);
        centro.añadirAlumno(0, a2);
        centro.añadirAlumno(0, a3);
        centro.añadirAlumno(0, a4);
        centro.añadirAlumno(0, a5);
        centro.añadirAlumno(0, a6);
        centro.añadirAlumno(0, a7);
        centro.añadirAlumno(0, a8);
        centro.añadirAlumno(29, a1);
        centro.añadirAlumno(29, a2);
        centro.añadirAlumno(29, a3);
        centro.añadirAlumno(29, a4);
        centro.añadirAlumno(20, a5);
        centro.añadirAlumno(20, a6);
        centro.añadirAlumno(20, a7);
        centro.añadirAlumno(20, a8);*/
        
        
        int opcionMenu = -1;
        try {
            while(opcionMenu != 5){
                menu();
                    opcionMenu = sc.nextInt();
                    sc.nextLine();

                switch(opcionMenu){
                    case 1:
                        Alumno a = centro.registrarNuevoAlumno();
                        centro.inscribirAlumno(a);                        
                        break;
                    case 2:
                        centro.mostrarAlumnoMatriculado();                   
                        break;
                    case 3:
                        centro.mostrarHorarioProfesor();
                        break;
                    case 4: 
                        centro.mostrarClasesProfesor();
                        break;
                    case 5: 
                        System.out.println("Cerrando aplicación.");
                        break;
                    default: 
                        System.out.println("Por favor, elige una opción válida.");
                }
            }
        } catch (InputMismatchException e) {
        }
        
        centro.guardarHorarioEnFichero();
    }
}
