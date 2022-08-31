package practica.pkg2;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static practica.pkg2.Practica2.config;
import static practica.pkg2.Practica2.segundos;

/**
 *
 * @author Allen Román
 */
class Login extends JFrame implements ActionListener {

    JButton inicio;
    JButton automatico;
    JButton top;
    JButton configuracion;
    JButton salir;
    static Thread cuenta;
    static CuentaRegresiva temporizador;
    static Potenciadores botonAbajo;
    static int segundos1;
    static Interfaz Juego;
    static int potenciadores;

    public Login() {
        this.setTitle("Torres de Hanoi");
        this.setBounds(1000, 500, 1000, 500);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);

        JLabel titulo = new JLabel();
        titulo.setText("Torres de Hanoi");
        titulo.setBounds(300, 20, 1000, 50);
        titulo.setFont(new Font("Century Gothic", 1, 50));
        this.add(titulo);

        inicio = new JButton();
        inicio.setText("Nuevo juego");
        inicio.setBounds(400, 100, 200, 50);
        inicio.setFont(new Font("Century Gothic", 1, 15));
        inicio.addActionListener(this);
        this.add(inicio);

        automatico = new JButton();
        automatico.setText("Juego automático");
        automatico.setBounds(400, 175, 200, 50);
        automatico.setFont(new Font("Century Gothic", 1, 15));
        automatico.addActionListener(this);
        this.add(automatico);

        top = new JButton();
        top.setText("Top 5");
        top.setBounds(400, 250, 200, 50);
        top.setFont(new Font("Century Gothic", 1, 15));
        top.addActionListener(this);
        this.add(top);

        configuracion = new JButton();
        configuracion.setText("Configuracion");
        configuracion.setBounds(400, 325, 200, 50);
        configuracion.setFont(new Font("Century Gothic", 1, 15));
        configuracion.addActionListener(this);
        this.add(configuracion);

        salir = new JButton();
        salir.setText("Salir");
        salir.setBounds(750, 350, 200, 50);
        salir.setFont(new Font("Century Gothic", 1, 15));
        salir.setBackground(new Color(241, 148, 138));
        salir.addActionListener(this);
        this.add(salir);
        
        segundos1 = Practica2.segundos;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == salir){
            System.exit(0);
        }
        
        if(ae.getSource() == configuracion){
        this.dispose();
        Configuracion ventana = new Configuracion();
            ventana.setVisible(true);
        }

        if (ae.getSource() == automatico) {
            this.dispose();
            Automatico ventana = new Automatico();
            ventana.setVisible(true);
        }

        if (ae.getSource() == inicio) {
            this.dispose();
            Interfaz Juego = null;
            Interfaz.alturaBoton = 50;
            try {
                Juego = new Interfaz();

                temporizador = new CuentaRegresiva();
                temporizador.start();
                
                botonAbajo = new Potenciadores();
                botonAbajo.start();

                if (Practica2.segundos == 0) {
                    Practica2.segundos = Configuracion.segundos1;
                } else {
                    for (int i = 0; i < 1; i++) {
                        segundos = config[i].getsegundos1();
                        Configuracion.n1 = config[i].getn1();
                    }
                }
                potenciadores = Practica2.segundos;

            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            Juego.setVisible(true);
        }

        if(ae.getSource() == top){
        this.dispose();
        Top ventana = new Top();
        ventana.setVisible(true);
        }
    }

}
