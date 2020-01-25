package di_t01p01_e02_DelaPascuaSergio;


import java.io.*;
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
public class CentroIngles {
    
    protected static TreeMap<Integer, Clase> horario;
    private Profesor[] listaProfesores;
    public static final String ruta ="/DiscoDuro/NetBeansProjects/diseñoInterfaces/horario.dat";
    
    public final static Niveles[][] matrizHorario = {{Niveles.A1,Niveles.B1,Niveles.C1,Niveles.A2,Niveles.C2},
                                {Niveles.C1,Niveles.C2,Niveles.A2,Niveles.C2,Niveles.A1},
                                {Niveles.B1,Niveles.A2,Niveles.A1,Niveles.B1,Niveles.C1},
                                {Niveles.B1,Niveles.A2,Niveles.A1,Niveles.B1,Niveles.C1},
                                {Niveles.A1,Niveles.B1,Niveles.C1,Niveles.A2,Niveles.C2},
                                {Niveles.C1,Niveles.C2,Niveles.A2,Niveles.C2,Niveles.A1}};
    
    public CentroIngles(){
        horario = new TreeMap<>();

        listaProfesores = listarProfesores();
        
        try {
            File f = new File(ruta);
            if(!f.exists()) 
                throw new FileNotFoundException();
            else
                horario = leerHorarioDeFichero();
        } catch (FileNotFoundException e) {
           crearHorarioEnFichero();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public static TreeMap<Integer, Clase> getHorario() {
        return horario;
    }

    public Profesor[] getListaProfesores() {
        return listaProfesores;
    }
    
    public String comprobarDia(int dia){
        switch(dia){
            case 0:
            case 5:
            case 10:
            case 15:
            case 20:
            case 25:
                return"Lunes";
            case 1:
            case 6:
            case 11:
            case 16:
            case 21:
            case 26:
                return "Martes";
            case 2:
            case 7:
            case 12:
            case 17:
            case 22:
            case 27:
                return "Miercoles";
            case 3:
            case 8:
            case 13:
            case 18:
            case 23:
            case 28:
                return "Jueves";
            case 4:
            case 9:
            case 14:
            case 19:
            case 24:
            case 29:
                return "Viernes";
            default:
                System.out.println("Fallo a la hora de setear el dia.");                    
        }
        return "";
    }
    
    public String comprobarAula(int num){
        switch(num){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return "Aula 1";          
            default:
                return "Aula 2";                    
        }
    }
    
    public String comprobarHora(int hora){
        switch(hora){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:          
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return "16:00 pm";
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:  
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                return "18:00 pm";
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:      
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                return "20:00 pm";      
            default:
                return "Fallo al devolver la hora.";                    
        }
    }
    
    public Profesor[] listarProfesores(){
        Profesor p1 = new Profesor("Catelyn", Niveles.A1,"Stark");
        crearHorarioProfesor(p1);
        Profesor p2 = new Profesor("Arya", Niveles.A2,"Stark");
        crearHorarioProfesor(p2);
        Profesor p3 = new Profesor("Aegon", Niveles.B1,"Targaryen");
        crearHorarioProfesor(p3);
        Profesor p4 = new Profesor("Margery", Niveles.C1,"Tyrell");
        crearHorarioProfesor(p4);
        Profesor p5 = new Profesor("Daenerys", Niveles.C2,"Targaryen");
        crearHorarioProfesor(p5);
        Profesor[] profes = {p1,p2,p3,p4,p5};
        return profes;
    }
    
    public void mostrarClasesProfesor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("De que profesor deseas ver sus clases y alumnos: ");
        int cont = 1;
        for(Profesor profe: listaProfesores){
            System.out.println(cont+" "+profe.dameNombre());
            cont++;
        }
        int opcionProfes = sc.nextInt();
        switch(opcionProfes){
            case 1:
                mostrarClasesProfesor(listaProfesores[0]);
                break;
            case 2:
                mostrarClasesProfesor(listaProfesores[1]);
                break;
            case 3:
                mostrarClasesProfesor(listaProfesores[2]);
                break;
            case 4:
                mostrarClasesProfesor(listaProfesores[3]);
                break;
            case 5:
                mostrarClasesProfesor(listaProfesores[4]);
                break;
            default :
                System.out.println("Ud no ha escogido una opción válida");
                break;
        }
    }
    
    public void mostrarClasesProfesor(Profesor p){
        int[] clases = p.clases();
        for (int i = 0; i < clases.length; i++) {  
            Clase clas = getHorario().get(clases[i]);
            String aula = comprobarAula(clases[i]);
            String dia = comprobarDia(clases[i]);
            String hora = comprobarHora(clases[i]);
            System.out.println("-----------------------------");
            System.out.println("           "+aula);
            System.out.println("Dia: "+dia);
            System.out.println("Hora: "+hora);
            int conta = 1;
            for(Alumno a : clas.getAlumnosMatriculado()){
                System.out.println(conta +" "+a.dameNombre());
                conta++;
            }
        }
    }
    
    public void mostrarHorarioProfesor(){
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("De que profesor deseas ver el horario: ");
        int cont = 1;
        for(Profesor profe: listaProfesores){
            System.out.println(cont+" "+profe.dameNombre());
            cont++;
        }
        opcion = sc.nextInt();
        switch(opcion){
            case 1:
                listaProfesores[0].mostrarHorario();
                break;
            case 2:
                listaProfesores[1].mostrarHorario();
                break;
            case 3:
                listaProfesores[2].mostrarHorario();
                break;
            case 4:
                listaProfesores[3].mostrarHorario();
                break;
            case 5:
                listaProfesores[4].mostrarHorario();
                break;
            default :
                System.out.println("Ud no ha escogido una opción válida");
                break;
        }
    }
    
    public void añadirAlumno(int nClase, String nombreAlum, String apellido){
        horario.get(nClase).getAlumnosMatriculado().add(new Alumno (nombreAlum, 
                horario.get(nClase).getNivel(),apellido) );
    }
    
    public void añadirAlumno(int nClase, Alumno a){
        horario.get(nClase).getAlumnosMatriculado().add(a);
    }
    
    public Alumno registrarNuevoAlumno(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Bienvenido!, ¿cómo te llamas?");
        String nombre = sc.nextLine();

        System.out.println("¿Y cuál es tu apellido "+nombre+"?");
        String apellido = sc.nextLine();
        String niv ="";
        Niveles nive = null;
        do{
            System.out.println("¿A qué nivel deseas asistir? (A1,A2,B1,B2,C1,C2)");
            niv = sc.nextLine().toUpperCase();
        }while(!niv.equalsIgnoreCase("A1") && !niv.equalsIgnoreCase("A2") && !niv.equalsIgnoreCase("B1") &&
                !niv.equalsIgnoreCase("B2") && !niv.equalsIgnoreCase("C1") && !niv.equalsIgnoreCase("C2"));

        for (Niveles d: Niveles.values()){
            if(d.toString().equalsIgnoreCase(niv))
                nive = d;
        }
        return new Alumno(nombre,nive,apellido);
    }
    
    public void inscribirAlumno(Alumno a){
        Scanner sc = new Scanner(System.in);
        int nClase1=-1;
        int nClase2;
        boolean bandera = true;
        System.out.println("\nEste es el horario que tenemos disponible: ");
        do{ 
            if(!mostrarHorarioDisponible(a.getNivel())){
                System.out.println("\033[31mNo existe disponibilidad del clase del nivel : "+a.getNivel()+"\033[30m\n\n");
                bandera = false;
                break;
            } 
            do {                
                System.out.println("A que hora deseas asistir?");
                nClase1 = sc.nextInt();
            } while (nClase1 <0||nClase1>29);
        }while((!(horario.get(nClase1).getAlumnosMatriculado().size()<8 && 
                horario.get(nClase1).getNivel() == a.getNivel()))|| !bandera);
        if(bandera){
            añadirAlumno(nClase1,a);
            do{ 
                System.out.println("A que otra clase deseas asistir, "+a.getNombre());
                nClase2 = sc.nextInt();
            }while(!(horario.get(nClase2).getAlumnosMatriculado().size()<8 && 
                    horario.get(nClase2).getNivel() == a.getNivel()) || nClase2 == nClase1);
            añadirAlumno(nClase2,a);
        }
    }
    
    public void crearHorarioProfesor(Profesor profe){
        Niveles suNivel = profe.getNivel();
        Integer cont = 0;
        
        for (int i = 0; i < matrizHorario.length; i++) {
            for (int j = 0; j < matrizHorario[0].length; j++) {
                if(suNivel == matrizHorario[i][j])
                    profe.getHorario().put(cont,suNivel.name());
                else    
                    profe.getHorario().put(cont,"\033[31mX\033[30m");
                cont++;
            }
        }
    }
    
    public boolean mostrarHorarioDisponible(Niveles nivel){
        boolean bandera = false;
        System.out.print("\tLunes\tMartes\tMierc\tJueves\tViernes\n");
        System.out.print("16:00");
        for (int i = 0; i < 5; i++) {
            if(horario.get(i).getNivel() == nivel && horario.get(i).getAlumnosMatriculado().size() <8){
                System.out.print("\t"+i+"  "+nivel.name());
                bandera = true;
            }else
                System.out.print("\t"+i+"\033[31m  X\033[30m");
        }
        System.out.print("\n18:00");
        for (int i = 5; i < 10; i++) {
            if(horario.get(i).getNivel() == nivel && horario.get(i).getAlumnosMatriculado().size() <8){
                System.out.print("\t"+i+"  "+nivel.name());
                bandera = true;
            }else
                System.out.print("\t"+i+"\033[31m  X\033[30m");
        }
        System.out.print("\n20:00");
        for (int i = 10; i < 15; i++) {
            if(horario.get(i).getNivel() == nivel && horario.get(i).getAlumnosMatriculado().size() <8)
                System.out.print("\t"+i+" "+nivel.name());
            else
                System.out.print("\t"+i+"\033[31m X\033[30m");
        }
        System.out.println("\n--------------------AULA 2--------------------");
        System.out.print("16:00");
        for (int i = 15; i < 20; i++) {
            if(horario.get(i).getNivel() == nivel && horario.get(i).getAlumnosMatriculado().size() <8){
                System.out.print("\t"+i+" "+nivel.name());
                bandera = true;
            }else
                System.out.print("\t"+i+"\033[31m X\033[30m");
        }
        System.out.print("\n18:00");
        for (int i = 20; i < 25; i++) {
            if(horario.get(i).getNivel() == nivel && horario.get(i).getAlumnosMatriculado().size() <8){
                System.out.print("\t"+i+" "+nivel.name());
                bandera = true;
            }else
                System.out.print("\t"+i+"\033[31m X\033[30m");
        }
        System.out.print("\n20:00");
        for (int i = 25; i < 30; i++) {
            if(horario.get(i).getNivel() == nivel && horario.get(i).getAlumnosMatriculado().size() <8){
                System.out.print("\t"+i+" "+nivel.name());
                bandera = true;
            }else
                System.out.print("\t"+i+"\033[31m X\033[30m");
        }
        System.out.println("\n");
        return bandera;
    }
    
    public void mostrarAlumnoMatriculado(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("¿Como te llamas?");
        String nombre = sc.nextLine();
        System.out.println("¿Y cual es tu apellido?");
        String apellido = sc.nextLine();
        Niveles nivel = null;
        String niv ="";
        
        do{
            System.out.println("¿A qué nivel asistes? (A1,A2,B1,B2,C1,C2)");
            niv = sc.nextLine().toUpperCase();
        }while(!niv.equalsIgnoreCase("A1") && !niv.equalsIgnoreCase("A2") && !niv.equalsIgnoreCase("B1") &&
                !niv.equalsIgnoreCase("B2") && !niv.equalsIgnoreCase("C1") && !niv.equalsIgnoreCase("C2"));

        for (Niveles d: Niveles.values()){
            if(d.toString().equalsIgnoreCase(niv))
                nivel = d;
        }
        boolean encontrado = false;
        for (int i = 0; i < horario.size(); i++) {
            if(horario.get(i).getAlumnosMatriculado().contains(new Alumno(nombre, nivel, apellido))){
                String aula = comprobarAula(i);
                String dia = comprobarDia(i);
                String hora = comprobarHora(i);
                System.out.println("-----------------------------");
                System.out.println("           "+aula);
                System.out.println("Dia: "+dia);
                System.out.println("Hora: "+hora);  
                encontrado = true;
            }
        }
        
        if(!encontrado)System.out.println("No hemos encontrado que estés matriculado en ninguna clase, "+nombre+".");
        System.out.println("\n");
    }
    
    public void crearHorarioEnFichero(){
        
        int cont = 0;
        Niveles nivelClase =null;
        
        for (int i = 0; i < matrizHorario.length; i++) {
            for (int j = 0; j < matrizHorario[0].length; j++) {
                nivelClase = matrizHorario[i][j];
                horario.put(cont, new Clase(nivelClase, cont));
                cont++;
            }
        }
        
        //GUARDAR EL HORARIO EN EL DISCO
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream(ruta));
            oos.writeObject(horario);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            try {
                if(oos!=null) oos.close();
            } catch (IOException e) {
                System.err.println("Ha ocurrido un error al cerrar el flujo.");
            }
        }
    }
    
    public void guardarHorarioEnFichero(){
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream(ruta));
            oos.writeObject(horario);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            try {
                if(oos!=null) oos.close();
            } catch (IOException e) {
                System.err.println("Ha ocurrido un error al cerrar el flujo.");
            }
        }
    }
    
    
    public TreeMap<Integer,Clase> leerHorarioDeFichero(){  
        TreeMap<Integer,Clase> hor = new TreeMap<Integer,Clase>();
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(ruta);
            ois = new ObjectInputStream(fis);
            hor = (TreeMap<Integer,Clase>) ois.readObject();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(ClassNotFoundException ioe){
            ioe.printStackTrace();
        }finally{
            try {
                if(fis!=null)fis.close();
                if(ois!=null) ois.close();
            } catch (IOException e) {
                System.err.println("Ha ocurrido un error al cerrar el flujo.");
            }
        }
        return hor;
    }
}
