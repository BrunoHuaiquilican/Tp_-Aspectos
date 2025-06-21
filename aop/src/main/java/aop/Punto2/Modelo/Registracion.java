package aop.Punto2.Modelo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
public class Registracion {
    private String pathGuardarInscriptos = "Registro.txt";

    @After("@annotation(Log)")
    public void registrarDespues (JoinPoint jp){
        String nombreDelMetodo = jp.getSignature().getName();
        List<String> parametros = new ArrayList<>();
        for (Object arg : jp.getArgs()) {
            parametros.add((String) arg);
        }
        LocalDateTime fechaDeEjecucion= LocalDateTime.now();
        guardar(nombreDelMetodo, parametros, fechaDeEjecucion);
    }

    private void guardar(String nombreDelMetodo, List<String> parametros, LocalDateTime fechaDeEjecucion) {
        final Path path = Paths.get(this.pathGuardarInscriptos);
        try {

            String linea = nombreDelMetodo;

            if(!parametros.isEmpty()) {
                for (String parametro : parametros) {
                    linea += " | " + parametro;
                }
            }
            else {
                linea += " " + "Sin parametros" + " ";
            }

            linea += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            Files.write(path, Arrays.asList(linea), StandardCharsets.UTF_8,
                    Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
