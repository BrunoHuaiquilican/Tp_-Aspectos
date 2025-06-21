package aop.Punto2.main;
import aop.Punto2.Modelo.Concursos;
import aop.Punto2.Persistencia.ArchivoDeTexto;
import aop.Punto2.ui.VentanaInscriptos;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
// log exception...
                    System.out.println(e);
                }
            }
        });
    }

    private void start() {
        new VentanaInscriptos(new Concursos(new ArchivoDeTexto("RegistroDeInscriptos")));
        //new VentanaInscriptos(new Concursos(new JdbcRegistroDeInscriptos()));

    }
}
