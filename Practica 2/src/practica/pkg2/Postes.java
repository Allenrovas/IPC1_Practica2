package practica.pkg2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Allen Román
 */
public class Postes extends JPanel {
    
    public Postes(){
        this.setLayout(null);
    }
    
        @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setBackground(new Color(174, 214, 241));

        g.setColor(Color.BLACK);
        
        //base
        g.fillRect(10, 270, 200,5);
        
        //asta
        g.fillRect(110, 30, 5, 240);
        
    }
    
}
