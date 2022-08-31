package practica.pkg2;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Allen Román
 */
public class Automatico extends JFrame implements ActionListener {

    int contador;
    JButton SalirAutomatico;
    TextArea Procedimiento;

    public Automatico()     {
        this.setTitle("Automático");
        this.setBounds(1000, 500, 1000, 500);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);

        JLabel titulo = new JLabel();
        titulo.setText("Juego Automático");
        titulo.setBounds(300, 20, 400, 50);
        titulo.setFont(new Font("Century Gothic", 1, 40));
        this.add(titulo);

        JLabel discos = new JLabel("Discos: " + Configuracion.n1);
        discos.setBounds(25, 90, 150, 25);
        discos.setFont(new Font("Century Gothic", 1, 15));
        this.add(discos);

        Procedimiento = new TextArea();
        Procedimiento.setBounds(50, 150, 800, 200);
        Procedimiento.setFont(new Font("Century Gothic", 1, 15));
        this.add(Procedimiento);

        Hanoi(Configuracion.n1, 1, 2, 3);

        SalirAutomatico = new JButton();
        SalirAutomatico.setBounds(700, 375, 200, 50);
        SalirAutomatico.setText("Salir");
        SalirAutomatico.setFont(new Font("Century Gothic", 1, 15));
        SalirAutomatico.setBackground(new Color(241, 148, 138));
        SalirAutomatico.addActionListener(this);
        this.add(SalirAutomatico);

        JLabel movs = new JLabel("Movimientos: " + contador);
        movs.setBounds(200, 90, 150, 25);
        movs.setFont(new Font("Century Gothic", 1, 15));
        this.add(movs);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SalirAutomatico) {
            this.dispose();
            Login ventana = new Login();
            ventana.setVisible(true);
        }

    }

    public void Hanoi(int n, int origen, int auxiliar, int destino) {
        if (n == 1) {
            Procedimiento.append("Mover disco "+n+ " de poste " + origen + " a poste " + destino);
            Procedimiento.append(System.getProperty("line.separator"));
            contador++;

        } else {
            Hanoi(n - 1, origen, destino, auxiliar);
            Procedimiento.append("Mover disco "+n+ " de poste " + origen + " a poste " + destino);
            Procedimiento.append(System.getProperty("line.separator"));
            Hanoi(n - 1, auxiliar, origen, destino);
            contador++;
        }
    }

}
