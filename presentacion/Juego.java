package presentacion;

public class Juego {
    public static void main(String[] args) {
        // Configuración del juego
        int TAMANO = 6;
        char Simbolo_Jugador_1 = 'X';
        char Simbolo_Jugador_2 = 'Y';

        // Crear y mostrar la interfaz gráfica
        DisenoJuego juego = new DisenoJuego(TAMANO, Simbolo_Jugador_1, Simbolo_Jugador_2);
    }
}
