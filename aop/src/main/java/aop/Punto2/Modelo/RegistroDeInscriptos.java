package aop.Punto2.Modelo;

import java.util.ArrayList;

public interface RegistroDeInscriptos {
    @Log
    void guardar(String apellido, String nombre, String telefono, String email, String idPersona, String idConcurso);

    @Log
    ArrayList<Concurso> todosLosConcursos();
}
