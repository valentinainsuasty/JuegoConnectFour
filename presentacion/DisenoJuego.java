import logicaJuego.Tablero;
import logicaJuego.Evaluador;

import javax.swing.*;

public class DisenoJuego extends JFrame {
    private Tablero tablero;

    public DisenoJuego(int tamano, char simboloJugador1, char simboloJugador2) {
        tablero = new Tablero(tamano, simboloJugador1, simboloJugador2);
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Connect Four");
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(tablero.getTamano(), tablero.getTamano()));
        JButton[][] buttons = new JButton[tablero.getTamano()][tablero.getTamano()];

        for (int i = 0; i < tablero.getTamano(); i++) {
            for (int j = 0; j < tablero.getTamano(); j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 30));
                buttons[i][j].setPreferredSize(new Dimension(80, 80));
                final int column = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jugarEnColumna(column);
                    }
                });
                boardPanel.add(buttons[i][j]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void jugarEnColumna(int columna) {
        char simbolo = tablero.getTurno1() ? tablero.getSimbolo_Jugador_1() : tablero.getSimbolo_Jugador_2();
        tablero.jugarEnColumna(columna);

        // Actualizar la interfaz gráfica
        JButton[][] buttons = getButtons();
        actualizarInterfaz(buttons);
    }

    private JButton[][] getButtons() {
        JButton[][] buttons = new JButton[tablero.getTamano()][tablero.getTamano()];
        Component[] components = ((JPanel) getContentPane().getComponent(0)).getComponents();

        int index = 0;
        for (int i = 0; i < tablero.getTamano(); i++) {
            for (int j = 0; j < tablero.getTamano(); j++) {
                buttons[i][j] = (JButton) components[index++];
            }
        }

        return buttons;
    }

    private void actualizarInterfaz(JButton[][] buttons) {
        char[][] matriz = tablero.getMatriz();

        for (int i = 0; i < tablero.getTamano(); i++) {
            for (int j = 0; j < tablero.getTamano(); j++) {
                buttons[i][j].setText(String.valueOf(matriz[i][j]));
            }
        }
    }

    public static void main(String[] args) {
        // Configuración del juego
        int TAMANO = 7;
        char Simbolo_Jugador_1 = 'X';
        char Simbolo_Jugador_2 = 'Y';

        // Crear y mostrar la interfaz gráfica
        DisenoJuego juego = new DisenoJuego(TAMANO, Simbolo_Jugador_1, Simbolo_Jugador_2);
    }
}