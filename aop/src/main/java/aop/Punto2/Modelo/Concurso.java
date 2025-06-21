package aop.Punto2.Modelo;

import java.time.LocalDate;

public class Concurso {

    private final int id;
    private final String nombre;
    private final LocalDate fechaInicioInscripcion;
    private final LocalDate fechaFinInscripcion;

    public Concurso(int id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
        if (id < 1) {
            throw new IllegalArgumentException("El número del concurso debe ser igual o mayor a uno");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (fechaInicioInscripcion == null || fechaFinInscripcion == null) {
            throw new IllegalArgumentException("Las fechas de inscripción no pueden ser nulas");
        }

        if (fechaInicioInscripcion.isAfter(fechaFinInscripcion)) {
            throw new IllegalArgumentException("La fecha de inicio del concurso no puede ser posterior a la fecha de fin");
        }

        this.id = id;
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }

    public LocalDate getFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public String obtenerIDComoString() {
        return String.valueOf(this.id);
    }
}
