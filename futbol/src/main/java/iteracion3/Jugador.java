package iteracion3;

public class Jugador implements PersonaDelFutbol {
    private final String nombre;
    private final Registracion registro;

    public Jugador(String nombre, Registracion registro) {
        this.nombre = nombre;
        this.registro = registro;
    }

//    public void insularA(Arbitro unArbitro, String insulto) {
//        unArbitro.escucharInsulto(insulto);
//        this.registro.registrar(insulto);
//    }

    @Override
    public void dirigirmeA(Arbitro unArbitro, String mensaje) {
        unArbitro.escucharInsulto(mensaje);
    }

    // supongamos que esta clase tiene otras responsabilidades
    // si no, no tendria razon de ser
}
