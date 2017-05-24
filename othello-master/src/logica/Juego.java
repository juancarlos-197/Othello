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
public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private int cantFichas;
    private int fichasJ1;
    private int fichasJ2;
    private Fichas ficha;
    private int i, j;
    private Scanner sc = new Scanner(System.in);

    public Juego(String jugador1, String jugador2) {
        this.tablero = new Tablero();
        this.cantFichas = 60;
        this.jugador1 = new Jugador(jugador1);
        this.jugador2 = new Jugador(jugador2);
        this.fichasJ1 = 2;
        this.fichasJ2 = 2;
    }

    public void jugar() {
        tablero.imprimirTablero();
        System.out.println("");
        this.jugador1.setTurno(true);
        this.jugador2.setTurno(false);
        while (cantFichas != 0 && fichasJ1 != 0 && fichasJ2 != 0) {
            
            if (this.jugador1.isTurno()) {
                System.out.println("Turno actual: " + this.jugador1.getNombre());
                this.ficha = new Fichas("b");
                System.out.println("Fila: ");
                i = sc.nextInt();
                System.out.println("Columna: ");
                j = sc.nextInt();
                if (tablero.ponerFicha(ficha, i-1, j-1)) {
                    this.fichasJ1 = fichasJ1 + tablero.fichasGanadas+tablero.fichasPuestas;
                    this.fichasJ2 = fichasJ2 - tablero.fichasGanadas;
                    this.cantFichas--;
                    this.jugador1.setTurno(false);
                    this.jugador2.setTurno(true);
                    System.out.println(this.jugador1.getNombre() + " : " + this.fichasJ1 + " - " + this.jugador2.getNombre() + " : " + this.fichasJ2);
                } else {
                    System.out.println("Ponga la ficha de nuevo");
                }

            } else {
                if (this.jugador2.isTurno()) {
                    System.out.println("Turno actual: " + this.jugador2.getNombre());
                    this.ficha = new Fichas("n");
                    System.out.println("Fila: ");
                    i = sc.nextInt();
                    System.out.println("Columna: ");
                    j = sc.nextInt();
                    if (tablero.ponerFicha(ficha, i-1, j-1)) {
                        this.fichasJ2 = fichasJ2 + tablero.fichasGanadas+tablero.fichasPuestas;
                        this.fichasJ1 = fichasJ1 - tablero.fichasGanadas;
                        this.cantFichas--;
                        this.jugador1.setTurno(true);
                        this.jugador2.setTurno(false);
                        System.out.println(this.jugador1.getNombre() + " : " + this.fichasJ1 + " - " + this.jugador2.getNombre() + " : " + this.fichasJ2);
                    } else {
                        System.out.println("Ponga la ficha de nuevo");
                    }

                } else {
                    System.out.print("Error de turno");
                }
            }
        }
        System.out.println("Juego Finalizado");
        System.out.println("Puntaje ");
        System.out.println(this.jugador1.getNombre() + " : " + this.fichasJ1 + " - " + this.jugador2.getNombre() + " : " + this.fichasJ2);
        if (this.fichasJ1 > this.fichasJ2) {
            System.out.println("Ganador " + this.jugador1.getNombre());
        } else {
            if (this.fichasJ1 < this.fichasJ2) {
                System.out.println("Ganador " + this.jugador2.getNombre());
            } else {
                if (this.fichasJ1 == this.fichasJ2) {
                    System.out.println("Empate ");
                }
            }
        }
    }
    
   
}
