package logicaJuego;

import java.util.Scanner;
/**
 * clase Tablero
 */
public class Tablero {
    /**
     * Atributos
     */
    private int tamano;
    private char simbolo_Jugador_1;
    private char simbolo_Jugador_2;
    private boolean turno1;
    private char[][] matriz;
    private int[] cantidadFichas;
    private Scanner lector;

    /**
     * Constructor para inicializar atributos
     *
     * @param tamano
     * @param simboloJugador1
     * @param simboloJugador2
     *
     * Complejidad temporal: 0(1) tiempo constante
     */
    public Tablero(int tamano, char simboloJugador1, char simboloJugador2) {
        this.tamano = tamano;
        this.simbolo_Jugador_1 = simboloJugador1;
        this.simbolo_Jugador_2 = simboloJugador2;
        this.turno1 = true;
        this.matriz = new char[tamano][tamano];
        this.cantidadFichas = new int[tamano];
        this.lector = new Scanner(System.in);
    }

    /**
     * Metodo que permite imprimir matriz
     *
     * Complejida temporal: 0(N^2) tiempo cuadratico
     */
    public void imprimirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Metodo que intercambia los turnos e ingresa las posiciones
     *
     * Complejidad temporal: 0(1) tiempo constante
     */
    public void jugar() {
        char simbolo = turno1 ? simbolo_Jugador_1 : simbolo_Jugador_2;
        System.out.println("Ingresa tu posición");
        int x = lector.nextInt();
        int y = tamano - 1 - cantidadFichas[x];
        cantidadFichas[x] += 1;
        matriz[y][x] = simbolo;
        turno1 = !turno1;
    }

    /**
     * Metodo que obtiene la matriz
     * @return
     */
    public char[][] getMatriz() {
        return matriz;
    }

    /**
     * Metodo que obtiene el tamaño de la matriz
     * @return
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * Metodo que obtiene el simbolo del jugador 1
     * @return
     */
    public char getSimbolo_Jugador_1() {
        return simbolo_Jugador_1;
    }

    /**
     * Metodo que obtiene el simbolo del jugador 2
     * @return
     */
    public char getSimbolo_Jugador_2() {
        return simbolo_Jugador_2;
    }

    /**
     * Metodo que obtiene el turno del jugador
     * @return
     */
    public boolean getTurno1() {
        return turno1;
    }

    /**
     * Metodo que permite intercambiar los turnos
     * @param turno1
     */
    public void setTurno1(boolean turno1) {
        turno1 = turno1;
    }

    /**
     * Metodo que permite cambiar la matriz
     * @param matriz
     */
    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * Metodo que permite cambiar el tamaño del tablero
     * @param tamano
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }


}


