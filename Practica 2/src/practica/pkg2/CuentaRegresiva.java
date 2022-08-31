package practica.pkg2;


import javax.swing.JOptionPane;
import static practica.pkg2.Practica2.segundos;
import static practica.pkg2.Login.Juego;

/**
 *
 * @author Allen Román
 */
public class CuentaRegresiva extends Thread {

    private String tiempo;
    

    
    @Override
    public void run() {
       try {
            while(true && segundos>=0){
                tiempo = ("Tiempo: "+ segundos ); 
                Interfaz.lbl_time.setText(tiempo);
               Thread.sleep(1000);
                segundos--;
                if (segundos == 0) {
                    finalizar();
                }
            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
    
    public void finalizar() {
        JOptionPane.showMessageDialog(null, "Ha finalizado el juego, ingrese de nuevo por favor");
        System.exit(0);
    }

}
