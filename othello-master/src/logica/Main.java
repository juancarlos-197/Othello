/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String J1 ="";
        String J2="";
        System.out.println("BIENVENIDO");
        System.out.println("Nombre Jugador 1:");
        J1=sc.nextLine();                
        System.out.println("Nombre Jugador 2:");
        J2=sc.nextLine();
        Juego othello = new  Juego(J1,J2);
        othello.jugar();
    }
    
}
