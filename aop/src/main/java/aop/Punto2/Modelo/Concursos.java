package aop.Punto2.Modelo;

import java.util.ArrayList;

public class Concursos {
    private ArrayList<Concurso> listaConcursos;
    private RegistroDeInscriptos unRegistro;

    public Concursos(RegistroDeInscriptos unRegistro) {
        listaConcursos = new ArrayList<>();
        this.unRegistro = unRegistro;
    }

    public void saveInscription(String apellido, String nombre, String telefono, String email, String idPersona, String idConcurso) {
        Inscripto inscripto = new Inscripto(apellido, nombre, telefono, email, idPersona);
        unRegistro.guardar(apellido, nombre, telefono, email, idPersona, idConcurso);
    }

    public ArrayList<Concurso> todosLosConcursos() {
// carga del archivo de texto concursos.txt los concursos
        listaConcursos = unRegistro.todosLosConcursos();
        return listaConcursos;
    }
}
