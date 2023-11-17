import logicaJuego.Evaluador;
import logicaJuego.Tablero;

import java.util.Scanner;

/**
 * clase Juego
 */
public class Juego{
    /**
     * Primera clase que se ejecuta
     *
     * @param args
     *
     * Complejidad temporal: 0(1) timepo constante
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configuración del juego
        int TAMANO = 6;
        char Simbolo_Jugador_1 = 'X';
        char Simbolo_Jugador_2 = 'Y';

        Tablero tablero = new Tablero(TAMANO, Simbolo_Jugador_1, Simbolo_Jugador_2);

        // Jugar el juego Conecta 4
        System.out.println("Para jugar, ingresa la columna donde deseas colocar tu ficha");

        tablero.imprimirMatriz();
        while (true) {
            int columna = 0;
            tablero.jugar(columna);
            if (Evaluador.ganador(tablero.getMatriz(), Simbolo_Jugador_1)) {
                System.out.println(Simbolo_Jugador_1 + " ha ganado.");
                break;
            } else if (Evaluador.ganador(tablero.getMatriz(), Simbolo_Jugador_2)) {
                System.out.println(Simbolo_Jugador_2 + " ha ganado.");
                break;
            }
            tablero.imprimirMatriz();
        }

        System.out.println("¡Juego terminado!");
    }
}

