package practica.pkg2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import static practica.pkg2.Login.potenciadores;
import static practica.pkg2.Login.temporizador;
import static practica.pkg2.Practica2.config;
import static practica.pkg2.Practica2.segundos;

public class Interfaz extends JFrame implements ActionListener {

    static int aros;
    static int arosJuego;

    //postes
    static Postes torre1;
    static Postes torre2;
    static Postes torre3;

    public static JLabel lbl_time = new JLabel();
    public static JButton boton = new JButton();
    public static int alturaBoton = 50;

    static JLabel pasosEchos;
    JLabel numeroDeAros;
    JLabel nombreTorre1;
    JLabel nombreTorre2;
    JLabel nombreTorre3;

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton SalirInterfaz;

    static int numeroDePasos;
    boolean seleccionado;
    Discos aroMover;

    public Interfaz() throws IOException {

        this.setLayout(null);
        this.setTitle("Nuevo Juego");
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(174, 214, 241));

        numeroDePasos = 0;
        aros = 3;
        aroMover = null;
        seleccionado = false;
        arosJuego = 3;

        this.setBackground(Color.WHITE);
        this.setLayout(null);

        pasosEchos = new JLabel("Movimientos: ");
        pasosEchos.setBounds(125, 0, 150, 25);
        pasosEchos.setFont(new Font("Century Gothic", 1, 15));
        this.add(pasosEchos);

        lbl_time.setVisible(true);
        lbl_time.setText("Tiempo: ");
        lbl_time.setBounds(10, 0, 125, 25);
        lbl_time.setFont(new Font("Century Gothic", 1, 15));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(lbl_time);

        boton.setVisible(true);
        boton.setBounds(25, alturaBoton, 25, 25);
        boton.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(boton);

        torre1 = new Postes();
        torre1.setBounds(100, 75, 220, 300);
        switch (Configuracion.n1) {
            case 3:
                agregarAros(3);
                aros = 3;
                break;
            case 4:
                agregarAros(4);
                aros = 4;
                break;
            case 5:
                agregarAros(5);
                aros = 5;
                break;
            case 6:
                agregarAros(6);
                aros = 6;
                break;
            case 7:
                agregarAros(7);
                aros = 7;
                break;
            default:
                agregarAros(3);
                break;
        }
        this.add(torre1);

        nombreTorre1 = new JLabel("POSTE UNO");
        nombreTorre1.setFont(new Font("Century Gothic", 1, 15));
        nombreTorre1.setBounds(160, 55, 150, 20);
        this.add(nombreTorre1);

        b1 = new JButton();
        b1.setText("<");
        b1.setBounds(120, 375, 50, 25);
        b1.setFont(new Font("Century Gothic", 1, 15));
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton();
        b2.setText(">");
        b2.setBounds(250, 375, 50, 25);
        b2.setFont(new Font("Century Gothic", 1, 15));
        b2.addActionListener(this);
        this.add(b2);

        //torre2
        torre2 = new Postes();
        torre2.setBounds(320, 75, 220, 300);
        //torre2.addMouseListener(this);
        this.add(torre2);

        nombreTorre2 = new JLabel("POSTE DOS");
        nombreTorre2.setFont(new Font("Century Gothic", 1, 15));
        nombreTorre2.setBounds(380, 55, 150, 20);
        this.add(nombreTorre2);

        b3 = new JButton();
        b3.setText("<");
        b3.setBounds(340, 375, 50, 25);
        b3.setFont(new Font("Century Gothic", 1, 15));
        b3.addActionListener(this);
        this.add(b3);

        b4 = new JButton();
        b4.setText(">");
        b4.setBounds(470, 375, 50, 25);
        b4.setFont(new Font("Century Gothic", 1, 15));
        b4.addActionListener(this);
        this.add(b4);

        //torre3
        torre3 = new Postes();
        torre3.setBounds(540, 75, 220, 300);
        //torre3.addMouseListener(this);
        this.add(torre3);

        nombreTorre3 = new JLabel("POSTE TRES");
        nombreTorre3.setFont(new Font("Century Gothic", 1, 15));
        nombreTorre3.setBounds(600, 55, 150, 20);
        this.add(nombreTorre3);

        b5 = new JButton();
        b5.setText("<");
        b5.setBounds(560, 375, 50, 25);
        b5.setFont(new Font("Century Gothic", 1, 15));
        b5.addActionListener(this);
        this.add(b5);

        b6 = new JButton();
        b6.setText(">");
        b6.setBounds(690, 375, 50, 25);
        b6.setFont(new Font("Century Gothic", 1, 15));
        b6.addActionListener(this);
        this.add(b6);

        SalirInterfaz = new JButton();
        SalirInterfaz.setBounds(780, 375, 200, 50);
        SalirInterfaz.setText("Salir");
        SalirInterfaz.setFont(new Font("Century Gothic", 1, 15));
        SalirInterfaz.setBackground(new Color(241, 148, 138));
        SalirInterfaz.addActionListener(this);
        this.add(SalirInterfaz);

        if (segundos == 0) {
            this.dispose();
        }

    }

    public static void agregarAros(int n) {
        Configuracion.n1 = n;
        Discos aro = new Discos();
        aro.setBounds(90, 250, 45, 20);
        torre1.add(aro);
        torre1.updateUI();
        for (int i = 1; i <= n - 1; i++) {
            torre1.add(new Discos());
        }
        organizar(n);
        torre1.updateUI();
    }

    public static void organizar(int n) {
        Configuracion.n1 = n;
        if (n >= 0) {
            for (int j = 1; j <= n - 1; j++) {
                //panel Anterior
                JPanel anterior = (JPanel) torre1.getComponent(j - 1);
                //posiciones y tamaño del aro anterior
                int x = anterior.getX();
                int y = anterior.getY();
                int w = anterior.getWidth();
                int h = anterior.getHeight();
                //Panel que se va a modificar
                JPanel aroA = (JPanel) torre1.getComponent(j);
                aroA.setBounds(x, y - h, w, h);
                anterior.setBounds(x - 10, y, w + 20, h);
                torre1.setComponentZOrder(aroA, j);
                torre1.setComponentZOrder(anterior, j - 1);
            }
            organizar(n - 1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            if (torre1.getComponentCount() > 0) {
                if (seleccionado == false) {

                    aroMover = (Discos) torre1.getComponent(torre1.getComponentCount() - 1);
                    seleccionado = true;

                    torre1.remove(torre1.getComponentCount() - 1);
                    torre1.updateUI();
                }
            }
            if (seleccionado == true) {
                if (aroMover != null) {

                    int x = aroMover.getX();
                    int h = aroMover.getHeight();
                    int w = aroMover.getWidth();
                    if (torre3.getComponentCount() == 0) {

                        aroMover.setBounds(x, 250, w, h);

                        torre3.add(aroMover);
                        torre3.updateUI();
                        aroMover = null;

                        numeroDePasos++;

                        pasosEchos.setText("Movimientos: " + numeroDePasos);
                        if (verificarFinalJuego(aros, torre3.getComponentCount()) == true) {
                            GuardarJugadores ventana = new GuardarJugadores();
                            ventana.setVisible(true);
                            this.dispose();
                        }
                        seleccionado = false;

                    } else {

                        Discos aroPresente = (Discos) torre3.getComponent(torre3.getComponentCount() - 1);
                        if (verificar(aroPresente, aroMover)) {

                            aroMover.setBounds(x, 250 - (20 * torre3.getComponentCount() - 1), w, 20);
                            torre3.add(aroMover);
                            torre3.updateUI();

                            numeroDePasos++;

                            pasosEchos.setText("Movimientos: " + numeroDePasos);
                            if (verificarFinalJuego(aros, torre3.getComponentCount()) == true) {
                                GuardarJugadores ventana = new GuardarJugadores();
                                ventana.setVisible(true);
                                this.dispose();
                            }
                            aroMover = null;
                            seleccionado = false;
                        } else {
                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            if (seleccionado == true) {
                                if (aroMover != null) {
                                    x = aroMover.getX();
                                    h = aroMover.getHeight();
                                    w = aroMover.getWidth();
                                    if (torre1.getComponentCount() == 0) {
                                        aroMover.setBounds(x, 250, w, h);
                                        torre1.add(aroMover);
                                        torre1.updateUI();
                                        aroMover = null;
                                        seleccionado = false;

                                    } else {
                                        aroPresente = (Discos) torre1.getComponent(torre1.getComponentCount() - 1);
                                        if (verificar(aroPresente, aroMover)) {
                                            aroMover.setBounds(x, 250 - (20 * torre1.getComponentCount() - 1), w, 20);
                                            torre1.add(aroMover);
                                            torre1.updateUI();
                                            aroMover = null;
                                            seleccionado = false;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (ae.getSource() == b2) {
            if (torre1.getComponentCount() > 0) {
                if (seleccionado == false) {
                    aroMover = (Discos) torre1.getComponent(torre1.getComponentCount() - 1);
                    seleccionado = true;
                    torre1.remove(torre1.getComponentCount() - 1);
                    torre1.updateUI();
                }
            }
            if (seleccionado == true) {
                if (aroMover != null) {

                    int x = aroMover.getX();
                    int w = aroMover.getWidth();
                    if (torre2.getComponentCount() == 0) {

                        aroMover.setBounds(x, 250, w, 20);

                        torre2.add(aroMover);
                        torre2.updateUI();

                        numeroDePasos++;

                        pasosEchos.setText("Movimientos: " + numeroDePasos);

                        aroMover = null;
                        seleccionado = false;

                    } else {
                        Discos aroPresente = (Discos) torre2.getComponent(torre2.getComponentCount() - 1);

                        if (verificar(aroPresente, aroMover)) {

                            aroMover.setBounds(x, 250 - (20 * torre2.getComponentCount() - 1), w, 20);
                            torre2.add(aroMover);
                            torre2.updateUI();

                            numeroDePasos++;

                            pasosEchos.setText("Movimientos: " + numeroDePasos);

                            aroMover = null;
                            seleccionado = false;
                        } else {
                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            if (seleccionado == true) {
                                if (aroMover != null) {
                                    x = aroMover.getX();
                                    w = aroMover.getWidth();
                                    if (torre1.getComponentCount() == 0) {

                                        aroMover.setBounds(x, 250, w, 20);

                                        torre1.add(aroMover);
                                        torre1.updateUI();
                                        aroMover = null;
                                        seleccionado = false;

                                    } else {

                                        aroPresente = (Discos) torre1.getComponent(torre1.getComponentCount() - 1);
                                        if (verificar(aroPresente, aroMover)) {

                                            aroMover.setBounds(x, 250 - (20 * torre1.getComponentCount() - 1), w, 20);
                                            torre1.add(aroMover);
                                            torre1.updateUI();
                                            aroMover = null;
                                            seleccionado = false;

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Movimiento inavlido");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        if (ae.getSource() == b3) {
            if (torre2.getComponentCount() > 0) {
                if (seleccionado == false) {
                    aroMover = (Discos) torre2.getComponent(torre2.getComponentCount() - 1);
                    seleccionado = true;
                    torre2.remove(torre2.getComponentCount() - 1);
                    torre2.updateUI();
                }
            }

            if (seleccionado == true) {
                if (aroMover != null) {
                    int x = aroMover.getX();
                    int h = aroMover.getHeight();
                    int w = aroMover.getWidth();
                    if (torre1.getComponentCount() == 0) {
                        aroMover.setBounds(x, 250, w, h);
                        torre1.add(aroMover);
                        torre1.updateUI();
                        numeroDePasos++;
                        pasosEchos.setText("Movimientos: " + numeroDePasos);
                        aroMover = null;
                        seleccionado = false;

                    } else {
                        Discos aroPresente = (Discos) torre1.getComponent(torre1.getComponentCount() - 1);

                        if (verificar(aroPresente, aroMover)) {
                            aroMover.setBounds(x, 250 - (20 * torre1.getComponentCount() - 1), w, 20);
                            torre1.add(aroMover);
                            torre1.updateUI();
                            numeroDePasos++;
                            pasosEchos.setText("Movimientos: " + numeroDePasos);
                            aroMover = null;
                            seleccionado = false;

                        } else {
                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            if (seleccionado == true) {
                                if (aroMover != null) {

                                    x = aroMover.getX();
                                    w = aroMover.getWidth();
                                    if (torre2.getComponentCount() == 0) {

                                        aroMover.setBounds(x, 250, w, 20);

                                        torre2.add(aroMover);
                                        torre2.updateUI();

                                        pasosEchos.setText("Movimientos: " + numeroDePasos);

                                        aroMover = null;
                                        seleccionado = false;

                                    } else {
                                        aroPresente = (Discos) torre2.getComponent(torre2.getComponentCount() - 1);

                                        if (verificar(aroPresente, aroMover)) {

                                            aroMover.setBounds(x, 250 - (20 * torre2.getComponentCount() - 1), w, 20);
                                            torre2.add(aroMover);
                                            torre2.updateUI();

                                            pasosEchos.setText("Movimientos: " + numeroDePasos);

                                            aroMover = null;
                                            seleccionado = false;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        if (ae.getSource() == b4) {
            if (torre2.getComponentCount() > 0) {
                if (seleccionado == false) {
                    aroMover = (Discos) torre2.getComponent(torre2.getComponentCount() - 1);
                    seleccionado = true;
                    torre2.remove(torre2.getComponentCount() - 1);
                    torre2.updateUI();
                }
            }
            if (seleccionado == true) {
                if (aroMover != null) {

                    int x = aroMover.getX();
                    int h = aroMover.getHeight();
                    int w = aroMover.getWidth();
                    if (torre3.getComponentCount() == 0) {

                        aroMover.setBounds(x, 250, w, h);

                        torre3.add(aroMover);
                        torre3.updateUI();
                        aroMover = null;

                        numeroDePasos++;

                        pasosEchos.setText("Movimientos: " + numeroDePasos);

                        seleccionado = false;
                        if (verificarFinalJuego(aros, torre3.getComponentCount()) == true) {
                            GuardarJugadores ventana = new GuardarJugadores();
                            ventana.setVisible(true);
                            this.dispose();
                        }
                    } else {

                        Discos aroPresente = (Discos) torre3.getComponent(torre3.getComponentCount() - 1);
                        if (verificar(aroPresente, aroMover)) {

                            aroMover.setBounds(x, 250 - (20 * torre3.getComponentCount() - 1), w, 20);
                            torre3.add(aroMover);
                            torre3.updateUI();

                            numeroDePasos++;

                            pasosEchos.setText("Movimientos: " + numeroDePasos);
                            if (verificarFinalJuego(aros, torre3.getComponentCount()) == true) {
                                GuardarJugadores ventana = new GuardarJugadores();
                                ventana.setVisible(true);
                                this.dispose();
                            }
                            aroMover = null;
                            seleccionado = false;
                        } else {
                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            if (seleccionado == true) {
                                if (aroMover != null) {
                                    x = aroMover.getX();
                                    w = aroMover.getWidth();
                                    if (torre2.getComponentCount() == 0) {

                                        aroMover.setBounds(x, 250, w, 20);

                                        torre2.add(aroMover);
                                        torre2.updateUI();

                                        pasosEchos.setText("Movimientos: " + numeroDePasos);

                                        aroMover = null;
                                        seleccionado = false;

                                    } else {

                                        aroPresente = (Discos) torre2.getComponent(torre2.getComponentCount() - 1);

                                        if (verificar(aroPresente, aroMover)) {

                                            aroMover.setBounds(x, 250 - (20 * torre2.getComponentCount() - 1), w, 20);
                                            torre2.add(aroMover);
                                            torre2.updateUI();

                                            pasosEchos.setText("Movimientos: " + numeroDePasos);

                                            aroMover = null;
                                            seleccionado = false;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (ae.getSource() == b5) {
            if (torre3.getComponentCount() > 0) {
                if (seleccionado == false) {

                    aroMover = (Discos) torre3.getComponent(torre3.getComponentCount() - 1);
                    seleccionado = true;

                    torre3.remove(torre3.getComponentCount() - 1);
                    torre3.updateUI();
                }
            }
            if (seleccionado == true) {
                if (aroMover != null) {

                    int x = aroMover.getX();
                    int w = aroMover.getWidth();
                    if (torre2.getComponentCount() == 0) {

                        aroMover.setBounds(x, 250, w, 20);

                        torre2.add(aroMover);
                        torre2.updateUI();

                        numeroDePasos++;

                        pasosEchos.setText("Movimientos: " + numeroDePasos);

                        aroMover = null;
                        seleccionado = false;
                    } else {
                        Discos aroPresente = (Discos) torre2.getComponent(torre2.getComponentCount() - 1);

                        if (verificar(aroPresente, aroMover)) {

                            aroMover.setBounds(x, 250 - (20 * torre2.getComponentCount() - 1), w, 20);
                            torre2.add(aroMover);
                            torre2.updateUI();

                            numeroDePasos++;

                            pasosEchos.setText("Movimientos: " + numeroDePasos);

                            aroMover = null;
                            seleccionado = false;
                        } else {
                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            if (seleccionado == true) {
                                if (aroMover != null) {

                                    x = aroMover.getX();
                                    int h = aroMover.getHeight();
                                    w = aroMover.getWidth();
                                    if (torre3.getComponentCount() == 0) {

                                        aroMover.setBounds(x, 250, w, h);

                                        torre3.add(aroMover);
                                        torre3.updateUI();
                                        aroMover = null;

                                        pasosEchos.setText("Movimientos: " + numeroDePasos);

                                        seleccionado = false;

                                    } else {

                                        aroPresente = (Discos) torre3.getComponent(torre3.getComponentCount() - 1);

                                        if (verificar(aroPresente, aroMover)) {

                                            aroMover.setBounds(x, 250 - (20 * torre3.getComponentCount() - 1), w, 20);
                                            torre3.add(aroMover);
                                            torre3.updateUI();

                                            pasosEchos.setText("Movimientos: " + numeroDePasos);

                                            aroMover = null;
                                            seleccionado = false;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Movimiento inavlido");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (ae.getSource() == b6) {
            if (torre3.getComponentCount() > 0) {
                if (seleccionado == false) {
                    aroMover = (Discos) torre3.getComponent(torre3.getComponentCount() - 1);
                    seleccionado = true;
                    torre3.remove(torre3.getComponentCount() - 1);
                    torre3.updateUI();
                }
            }
            if (seleccionado == true) {
                if (aroMover != null) {
                    int x = aroMover.getX();
                    int h = aroMover.getHeight();
                    int w = aroMover.getWidth();
                    if (torre1.getComponentCount() == 0) {

                        aroMover.setBounds(x, 250, w, h);

                        torre1.add(aroMover);
                        torre1.updateUI();
                        numeroDePasos++;
                        pasosEchos.setText("Movimientos: " + numeroDePasos);
                        aroMover = null;
                        seleccionado = false;

                    } else {
                        Discos aroPresente = (Discos) torre1.getComponent(torre1.getComponentCount() - 1);
                        if (verificar(aroPresente, aroMover)) {

                            aroMover.setBounds(x, 250 - (20 * torre1.getComponentCount() - 1), w, 20);
                            torre1.add(aroMover);
                            torre1.updateUI();
                            numeroDePasos++;
                            pasosEchos.setText("Movimientos: " + numeroDePasos);
                            aroMover = null;
                            seleccionado = false;

                        } else {
                            JOptionPane.showMessageDialog(null, "Movimiento inválido");
                            if (seleccionado == true) {
                                if (aroMover != null) {

                                    x = aroMover.getX();
                                    h = aroMover.getHeight();
                                    w = aroMover.getWidth();
                                    if (torre3.getComponentCount() == 0) {

                                        aroMover.setBounds(x, 250, w, h);

                                        torre3.add(aroMover);
                                        torre3.updateUI();
                                        aroMover = null;

                                        pasosEchos.setText("Tu numero de movimientos: " + numeroDePasos);
                                        seleccionado = false;

                                    } else {

                                        aroPresente = (Discos) torre3.getComponent(torre3.getComponentCount() - 1);

                                        if (verificar(aroPresente, aroMover)) {

                                            aroMover.setBounds(x, 250 - (20 * torre3.getComponentCount() - 1), w, 20);
                                            torre3.add(aroMover);
                                            torre3.updateUI();

                                            pasosEchos.setText("Movimientos: " + numeroDePasos);

                                            aroMover = null;
                                            seleccionado = false;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Movimiento inavlido");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (ae.getSource() == SalirInterfaz) {
            temporizador.resume();
            Practica2.segundos = 0;
            potenciadores = 0;
            this.dispose();
            Login ventana = new Login();
            ventana.setVisible(true);
        }

        if (ae.getSource() == boton) {
            if (segundos % 2 == 0) {
                segundos = segundos - 10;
            } else {
                segundos = segundos + 10;
            }
        }

    }

    public boolean verificar(Discos aroPresente, Discos aroAMover) {
        int w = aroPresente.getWidth();
        int w2 = aroAMover.getWidth();
        if (w > w2) {
            return true;
        } else {
            return false;
        }
    }

    public static void setTime(String text) {
        lbl_time.setText(text);
    }

    public boolean verificarFinalJuego(int n, int numeroArosTorre3) {
        return n == numeroArosTorre3;
    }


}
