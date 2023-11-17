package presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logicaJuego.Evaluador;
import logicaJuego.Tablero;


public class Diseno extends JFrame {
    private Tablero tablero;
    private JButton[][] botones;

    public Diseno(int tamano, char simboloJugador1, char simboloJugador2) {
        tablero = new Tablero(tamano, simboloJugador1, simboloJugador2);

        setTitle("Conecta 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(tamano, tamano));
        setSize(500, 500);

        botones = new JButton[tamano][tamano];

        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                botones[i][j] = new JButton("");
                botones[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                botones[i][j].setFocusPainted(false);
                final int columna = j;
                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jugar(columna);
                    }
                });
                add(botones[i][j]);
            }
        }

        setVisible(true);
    }

    private void jugar(int columna) {
        tablero.jugar(columna);
        actualizarInterfaz();
        if (Evaluador.ganador(tablero.getMatriz(), tablero.getSimbolo_Jugador_1())) {
            JOptionPane.showMessageDialog(this, tablero.getSimbolo_Jugador_1() + " ha ganado.");
            reiniciarJuego();
        } else if (Evaluador.ganador(tablero.getMatriz(), tablero.getSimbolo_Jugador_2())) {
            JOptionPane.showMessageDialog(this, tablero.getSimbolo_Jugador_2() + " ha ganado.");
            reiniciarJuego();
        }
    }

    private void actualizarInterfaz() {
        char[][] matriz = tablero.getMatriz();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                botones[i][j].setText(String.valueOf(matriz[i][j]));
            }
        }
    }

    private void reiniciarJuego() {
        tablero = new Tablero(tablero.getTamano(), tablero.getSimbolo_Jugador_1(), tablero.getSimbolo_Jugador_2());
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Diseno(6, 'X', 'Y');
            }
        });
    }
}

