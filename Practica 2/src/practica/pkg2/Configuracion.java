package practica.pkg2;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Allen Román
 */
class Configuracion extends JFrame implements ActionListener {
    JComboBox NumeroDiscos;
    JTextField Tiempo;
    JButton GuardarConfiguracion;
    JButton SalirConfiguracion;
    static int n1;
    static int segundos1;
    
    

    public Configuracion() {
        this.setTitle("Configuración");
        this.setBounds(1000, 500, 1000, 500);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));
        this.setLayout(null);

        JLabel titulo = new JLabel();
        titulo.setText("Configuración");
        titulo.setBounds(300, 20, 400, 50);
        titulo.setFont(new Font("Century Gothic", 1, 40));
        this.add(titulo);
        
        JLabel Titulodiscos = new JLabel();
        Titulodiscos.setText("Cantidad de Discos");
        Titulodiscos.setBounds(200, 150, 200, 50);
        Titulodiscos.setFont(new Font("Century Gothic", 1, 20));
        this.add(Titulodiscos); 
      
        NumeroDiscos = new JComboBox();
        NumeroDiscos.setBounds(200,225,200,50);
        for (int i = 3; i <= 7; i++) {
            NumeroDiscos.addItem(i);
        }
        NumeroDiscos.setFont(new Font("Century Gothic", 1, 20));
        this.add(NumeroDiscos); 
        
        JLabel TituloTiempo = new JLabel();
        TituloTiempo.setText("Tiempo de partida");
        TituloTiempo.setBounds(600, 150, 200, 50);
        TituloTiempo.setFont(new Font("Century Gothic", 1, 20));
        this.add(TituloTiempo); 
        
        Tiempo = new JTextField();
        Tiempo.setText("120");
        Tiempo.setFont(new Font("Century Gothic", 1, 20));
        Tiempo.setBounds(600, 225, 200, 50);
        this.add(Tiempo);
        
        GuardarConfiguracion = new JButton();
        GuardarConfiguracion.setBounds(400,325,200,50);
        GuardarConfiguracion.setText("Guardar");
        GuardarConfiguracion.setFont(new Font("Century Gothic",1,15));
        GuardarConfiguracion.setBackground(new Color(130, 224, 170));
        GuardarConfiguracion.addActionListener(this);
        this.add(GuardarConfiguracion);
        
        SalirConfiguracion = new JButton();
        SalirConfiguracion.setBounds(700,375,200,50);
        SalirConfiguracion.setText("Salir");
        SalirConfiguracion.setFont(new Font("Century Gothic",1,15));
        SalirConfiguracion.setBackground(new Color(241, 148, 138));
        SalirConfiguracion.addActionListener(this);
        this.add(SalirConfiguracion);
      

        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==SalirConfiguracion){
        this.dispose();
        Login ventana = new Login();
        ventana.setVisible(true);
        }
        
        if(ae.getSource() == GuardarConfiguracion) {

            n1 = (int) NumeroDiscos.getSelectedItem();
            String tiempoconfig = Tiempo.getText();
            segundos1 = Integer.parseInt(tiempoconfig);
            Practica2.segundos = Configuracion.segundos1;
            for (int i = 0; i < Practica2.config.length; i++) {
                ConfiguracionObjeto nuevo1 = new ConfiguracionObjeto(n1, segundos1);
                Practica2.config[i] = nuevo1;
                Herramientas.serialize("Configuracion.bin", Practica2.config);

            }

        }
    }

}
