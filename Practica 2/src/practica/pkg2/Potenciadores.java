package practica.pkg2;

import java.awt.Color;
import static practica.pkg2.Interfaz.alturaBoton;
import static practica.pkg2.Login.potenciadores;
import static practica.pkg2.Practica2.segundos;

/**
 *
 * @author Allen Román
 */
public class Potenciadores extends Thread {

    @Override
    public void run() {
        try {
            while (true && potenciadores >= 0) {
             
                Thread.sleep(1000);
                alturaBoton=alturaBoton+3;
                potenciadores--;
                if (potenciadores % 2 == 0) {
                    Interfaz.boton.setBackground(new Color(241, 148, 138));
                    Interfaz.boton.setBounds(25, alturaBoton, 25, 25);
                }
                else{
                    Interfaz.boton.setBackground(new Color(130, 224, 170));
                    Interfaz.boton.setBounds(25, alturaBoton, 25, 25);
                }
                
            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
