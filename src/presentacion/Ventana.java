package presentacion;
import logicaJuego.Tablero;
import logicaJuego.Evaluador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Conecta 4");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JuegoPanel juegoPanel = new JuegoPanel();
            frame.getContentPane().add(juegoPanel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

class JuegoPanel extends JPanel {

    private Tablero tablero;

    public JuegoPanel() {
        // Configuración del juego
        int TAMANO = 6;
        char Simbolo_Jugador_1 = 'X';
        char Simbolo_Jugador_2 = 'Y';

        tablero = new Tablero(TAMANO, Simbolo_Jugador_1, Simbolo_Jugador_2);

        setLayout(new BorderLayout());

        // Panel para el tablero
        TableroPanel tableroPanel = new TableroPanel();
        add(tableroPanel, BorderLayout.CENTER);

        // Botón para jugar
        JButton jugarButton = new JButton("Jugar");
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablero.jugar();
                tableroPanel.actualizar();
                if (Evaluador.ganador(tablero.getMatriz(), Simbolo_Jugador_1)) {
                    JOptionPane.showMessageDialog(JuegoPanel.this, Simbolo_Jugador_1 + " ha ganado.");
                } else if (Evaluador.ganador(tablero.getMatriz(), Simbolo_Jugador_2)) {
                    JOptionPane.showMessageDialog(JuegoPanel.this, Simbolo_Jugador_2 + " ha ganado.");
                }
            }
        });

        add(jugarButton, BorderLayout.SOUTH);
    }

    class TableroPanel extends JPanel {

        public TableroPanel() {
            setPreferredSize(new Dimension(400, 400));
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        public void actualizar() {
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            char[][] matriz = tablero.getMatriz();
            int tamano = tablero.getTamano();
            int cuadroSize = getWidth() / tamano;

            for (int i = 0; i < tamano; i++) {
                for (int j = 0; j < tamano; j++) {
                    g.drawRect(j * cuadroSize, i * cuadroSize, cuadroSize, cuadroSize);
                    g.drawString(String.valueOf(matriz[i][j]), j * cuadroSize + cuadroSize / 2, i * cuadroSize + cuadroSize / 2);
                }
            }
        }
    }
}
