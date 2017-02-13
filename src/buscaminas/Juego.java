/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author marc
 */
public class Juego {
    private Tabla tabla;
    boolean terminar = false;
    boolean ganar = false;
    int turno=0;
    
    public Juego(){
        tabla = new Tabla();
        Jugar(tabla);
    }
    
    public void Jugar(Tabla tabla){
        do{
            turno++;
            System.out.println("Turn "+turno);
            tabla.ensenia(); //ensenia es = a enseña
            terminar = tabla.setPosition();
            
            if(!terminar){
                tabla.ensenia();
                terminar = tabla.ganar();
            }
            
        }while(!terminar);
        
        if(tabla.ganar()){
            System.out.println("Enhorabuena, has dejado los diez campos con las minas "+turno+" turnos");
            tabla.enseniaMines();
        } else {
            System.out.println("Mina! Has perdido la partida!");
            tabla.enseniaMines();
        }
    }

}

