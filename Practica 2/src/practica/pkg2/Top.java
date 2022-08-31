package practica.pkg2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Allen Román
 */
public class Top extends JFrame implements ActionListener {

    static JTextField tabla;
    static JTable tablajugadores;
    JButton SalirTop;

    public Top() {

        this.setTitle("Top 5");
        this.setBounds(1000, 500, 1000, 500);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);

        JLabel titulo = new JLabel();
        titulo.setText("Top 5 Jugadores");
        titulo.setBounds(300, 20, 400, 50);
        titulo.setFont(new Font("Century Gothic", 1, 40));
        this.add(titulo);

        tabla = new JTextField();
        tabla.setBounds(225, 100, 550, 105);
        this.add(tabla);
        TablaJugadores();

        SalirTop = new JButton();
        SalirTop.setBounds(700, 375, 200, 50);
        SalirTop.setText("Salir");
        SalirTop.setFont(new Font("Century Gothic", 1, 15));
        SalirTop.setBackground(new Color(241, 148, 138));
        SalirTop.addActionListener(this);
        this.add(SalirTop);

    }

    public static void TablaJugadores() {
        tabla.removeAll();
        String[] columnas = {"Nombre", "Movimientos", "Tiempo (s)"};
        Object[][] datos = new Object[5][3];

        for (int i = 0; i < Practica2.jugadores.length; i++) {
            if (Practica2.jugadores[i] != null) {

                datos[i][0] = Practica2.jugadores[i].getNombreJugador();
                datos[i][1] = Practica2.jugadores[i].getMovimientosJugador();
                datos[i][2] = Practica2.jugadores[i].getTiempoJugador();
                
            }

        }
        tablajugadores = new JTable(datos, columnas);
        tablajugadores.setFont(new Font("Century Gothic", 1, 15));
        tablajugadores.setEnabled(false);
        JScrollPane scroll = new JScrollPane(tablajugadores);
        scroll.setBounds(0, 0, 550, 675);
        scroll.setVisible(true);
        tabla.add(scroll);
        Practica2.jugadores[10] = null;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SalirTop) {
            this.dispose();
            Login ventana = new Login();
            ventana.setVisible(true);
        }
    }
}
