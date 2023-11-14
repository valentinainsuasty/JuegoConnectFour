package logicaJuego;

public class Evaluador {
    public static boolean verificarDireccion(char[][] tablero, char jugador, int fil, int col, int filDir, int colDir) {
        int count = 0;

        for (int i = fil, j = col; i >= 0 && i < tablero.length && j >= 0 && j < tablero[0].length; i += filDir, j += colDir) {
            if (tablero[i][j] == jugador) {
                count++;
                if (count == 4) {
                    return true; // El jugador ha ganado
                }
            } else {
                break;
            }
        }

        return false; // No se encontró una secuencia ganadora en esta dirección
    }

    public static boolean ganador(char[][] tablero, char jugador) {
        int[][] direcciones = {
                {0, 1},  // Horizontal
                {1, 0},  // Vertical
                {1, 1},  // Diagonal principal
                {1, -1}  // Diagonal inversa
        };

        for (int fil = 0; fil < tablero.length; fil++) {
            for (int col = 0; col < tablero[0].length; col++) {
                for (int[] dir : direcciones) {
                    if (verificarDireccion(tablero, jugador, fil, col, dir[0], dir[1])) {
                        return true; // El jugador ha ganado en esta dirección
                    }
                }
            }
        }

        return false; // El jugador no ha ganado en ninguna dirección
    }
}