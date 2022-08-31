package practica.pkg2;

import java.io.Serializable;

/**
 *
 * @author Allen Román
 */
public class ConfiguracionObjeto implements Serializable {

    private int n1;
    private int segundos1;

    public ConfiguracionObjeto(int n1, int segundos1) {
        this.n1 = n1;
        this.segundos1 = segundos1;

    }

    public int getn1() {
        return n1;
    }

    public void setn1(int n1) {
        this.n1 = n1;
    }

    public int getsegundos1() {
        return segundos1;
    }

    public void setsegundos1(int segundos1) {
        this.segundos1 = segundos1;
    }

}
