package aop;

public class Dirigente {

    private String nombre;

    public Dirigente(String nombre) {
        this.nombre = nombre;
    }

    @Registrar
    public void insultarA(Arbitro unArbitro, String insulto) {
        //Ingresa a campo de juego y luego:
        unArbitro.escucharInsulto(insulto);
    }
}
