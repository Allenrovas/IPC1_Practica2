package practica.pkg2;

import java.io.File;
import java.io.IOException;

/**
 *Practica Torres de Hanoi 
 * @author Allen Román
 */
public class Practica2 {

    static int segundos;
    public static Jugadores[] jugadores = new Jugadores[50];
    public static ConfiguracionObjeto[] config = new ConfiguracionObjeto[1];

    public static void main(String[] args) throws IOException {
        segundos = 120;
        Configuracion.n1=3;
        if (new File("Jugadores.bin").exists()) {
            Practica2.jugadores = (Jugadores[]) Herramientas.deserialize("Jugadores.bin");
        }
        if (new File("Configuracion.bin").exists()) {
            Practica2.config = (ConfiguracionObjeto[]) Herramientas.deserialize("Configuracion.bin");
            for (int i = 0; i < 1; i++) {
                segundos = config[i].getsegundos1();
                Configuracion.n1 = config[i].getn1();
            }
        }

        Login ventana = new Login();
        ventana.setVisible(true);

    }

}
