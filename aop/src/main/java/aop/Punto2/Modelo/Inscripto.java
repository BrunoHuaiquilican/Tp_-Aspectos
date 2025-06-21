package aop.Punto2.Modelo;

public class Inscripto {
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;

    public Inscripto(String nombre, String apellido, String dni, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;

        assertNombre();
        assertApellido();
        assertDni();
        assertEmail();
        assertTelefono();
    }

    private void assertTelefono() {
        if (telefono == null || telefono.isBlank() || checkPhone(telefono)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
    }

    private void assertEmail() {
        if (email == null || email.isBlank() || !checkEmail(email)) {
            throw new RuntimeException("email debe ser válido");
        }
    }

    private void assertDni() {
        if (dni == null || dni.isBlank()) {
            throw new RuntimeException("dni no puede ser vacio");
        }
    }

    private void assertApellido() {
        if (apellido == null || apellido.isBlank()) {
            throw new RuntimeException("Nombre no puede ser vacio");
        }
    }

    private void assertNombre() {
        if (nombre == null || nombre.isBlank()) {
            throw new RuntimeException("apellido no puede ser vacio");
        }
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }
}
