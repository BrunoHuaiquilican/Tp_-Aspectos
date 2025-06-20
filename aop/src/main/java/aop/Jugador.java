package aop;

public class Jugador {
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    @Registrar
    public void insultarA(Arbitro unArbitro, String insulto) {
        unArbitro.escucharGrito(insulto);
    }

    public String nombre() {
        return nombre;
    }
}
