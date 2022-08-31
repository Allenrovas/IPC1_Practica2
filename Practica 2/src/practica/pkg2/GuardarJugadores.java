package practica.pkg2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Allen Román
 */
public class GuardarJugadores extends JFrame implements ActionListener {
    
    JTextField ingreso1;
    JButton agregar;
    static int TiempoJugador;
    
    public GuardarJugadores(){
        TiempoJugador = Practica2.segundos;
        this.setTitle("Guardar Jugador");
        this.setBounds(1000, 500, 500, 250);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);
        
        JLabel titulo = new JLabel();
        titulo.setText("¡Felicitaciones ha ganado el juego!");
        titulo.setBounds(80, 25, 300, 25);
        titulo.setFont(new Font("Century Gothic", 1, 15));
        this.add(titulo);

        JLabel titulo1 = new JLabel();
        titulo1.setText("Guarda tu puntuación");
        titulo1.setBounds(125, 65, 200, 25);
        titulo1.setFont(new Font("Century Gothic", 1, 15));
        this.add(titulo1);
        
        JLabel label1 = new JLabel();
        label1.setText("Nombre");
        label1.setBounds(50, 100, 75, 25);
        label1.setFont(new Font("Century Gothic", 1, 15));
        this.add(label1);
        
        ingreso1 = new JTextField();
        ingreso1.setBounds(150,100,200,25);
        ingreso1.setFont(new Font("Century Gothic", 1, 15));
        this.add(ingreso1);
        
                
        agregar = new JButton();
        agregar.setBounds(150, 150, 200, 25);
        agregar.setText("Agregar");
        agregar.setFont(new Font("Century Gothic", 1, 15));
        agregar.addActionListener(this);
        this.add(agregar);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == agregar) {
            Practica2.jugadores[10] = null;
            for (int i = 0; i < Practica2.jugadores.length; i++) {
                if (Practica2.jugadores[i] == null) {
                    int MovimientosJugador = Interfaz.numeroDePasos;
                    String NombreJugador = ingreso1.getText();
                    Jugadores nuevo = new Jugadores(MovimientosJugador, TiempoJugador, NombreJugador);
                    Practica2.jugadores[i] = nuevo;
                    break;
                }
            }
            this.dispose();
            Herramientas.serialize("Jugadores.bin", Practica2.jugadores);
            Herramientas.BurbujaDesc1(Practica2.jugadores);
            Login ventana = new Login();
            ventana.setVisible(true);
        }
        
    }
    
}
