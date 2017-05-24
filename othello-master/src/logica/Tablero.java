/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Usuario
 */
public class Tablero {

    private Fichas[][] tablero;
    private Fichas ficha;
    int fichasGanadas;
    int fichasPuestas;

    public Tablero() {
        tablero = new Fichas[8][8];
        llenarInicial();
    }

    public int getFichasPuestas() {
        return fichasPuestas;
    }

    public void setFichasPuestas(int fichasPuestas) {
        this.fichasPuestas = fichasPuestas;
    }

    public int getFichasGanadas() {
        return fichasGanadas;
    }

    public void setFichasGanadas(int fichasGanadas) {
        this.fichasGanadas = fichasGanadas;
    }

    public void llenarInicial() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ficha = new Fichas();
                tablero[i][j] = ficha;
            }
        }

        ficha = new Fichas();
        ficha.setCaraActual("b");
        tablero[3][3] = ficha;

        ficha = new Fichas();
        ficha.setCaraActual("n");
        tablero[3][4] = ficha;

        ficha = new Fichas();
        ficha.setCaraActual("n");
        tablero[4][3] = ficha;

        ficha = new Fichas();
        ficha.setCaraActual("b");
        tablero[4][4] = ficha;
    }

    public boolean ponerFicha(Fichas ficha, int i, int j) {
        
        this.fichasGanadas = 0;
        this.fichasPuestas = 0;

        if (posicionCorrecta(i, j)) {
            if (casillaVacia(tablero[i][j])) {
                tablero[i][j] = ficha;
                this.fichasPuestas++;
                for (int x = i-1; x <= i+1; x++) {
                    for (int y = j-1; y <= j+1; y++) {
                        if (posicionCorrecta(x, y)) {
                            if (x == i && y == j) {
                                //no hace nada no se compara con el mismo
                            } else {
                                if (casillaVacia(tablero[x][y])) {
                                    //no hace nada 
                                } else {
                                    if (tablero[x][y].getCaraActual() == ficha.getCaraActual()) {
                                        //no hace nada si las caras iguales
                                    } else {
                                        tablero[x][y].setCaraActual(ficha.getCaraActual());
                                        this.fichasGanadas++;
                                       
                                    }
                                }
                            }

                        } else {
                            //no hace nada pasa al siguiente
                        }
                    }
                }
                System.out.println("");
                imprimirTablero();
                System.out.println("");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean posicionCorrecta(int i, int j) {
        if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
            return true;
        } else {
            //System.out.println("Posicion Incorrecta");
            return false;
        }
    }

    public boolean casillaVacia(Fichas ficha) {
        if (ficha.getCaraActual() == "") {
            return true;
        } else {
            //System.out.println("Posicion Ocupada");
            return false;
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < 8; i++) {
            System.out.println(" ");
            for (int j = 0; j < 8; j++) {
                if (this.tablero[i][j].getCaraActual() == "") {
                    System.out.print(" - ");
                } else {
                    System.out.print(" "+this.tablero[i][j].getCaraActual()+" ");
                }
            }
        }
    }

}
