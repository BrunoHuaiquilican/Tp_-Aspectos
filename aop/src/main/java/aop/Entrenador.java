package aop;

public class Entrenador {
    private String nombre;

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }


    @Registrar
    public void dialogarCon(AyudanteDeCampo unAyudanteDeCampo, String mensaje) {
        unAyudanteDeCampo.escucharMensaje(mensaje);
        //this.registro.registar(mensaje);
    }

    public String nombre() {
        return nombre;
    }
}
