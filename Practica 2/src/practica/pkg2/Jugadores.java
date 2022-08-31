package practica.pkg2;

import java.io.Serializable;

/**
 *
 * @author Allen Román
 */
public class Jugadores implements Serializable {
    private int MovimientosJugador; 
    private int TiempoJugador;
    private String NombreJugador;
    
    public Jugadores(int MovimientosJugador, int TiempoJugador, String NombreJugador){
        this.MovimientosJugador = MovimientosJugador;
        this.TiempoJugador= TiempoJugador;
        this.NombreJugador= NombreJugador;
        
    }

    public int getMovimientosJugador() {
        return MovimientosJugador;
    }

    public void setMovimientosJugador(int MovimientosJugador) {
        this.MovimientosJugador = MovimientosJugador;
    }

    public int getTiempoJugador() {
        return TiempoJugador;
    }

    public void setTiempoJugador(int TiempoJugador) {
        this.TiempoJugador = TiempoJugador;
    }

    public String getNombreJugador() {
        return NombreJugador;
    }

    public void setNombreJugador(String NombreJugador) {
        this.NombreJugador = NombreJugador;
    }
    
    
}
