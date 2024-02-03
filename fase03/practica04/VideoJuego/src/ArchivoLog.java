import java.io.FileWriter;
import java.io.IOException;

class ArchivoLog {

    private static final String ARCHIVO_LOG = "src/LabFP/Lab24/my_log_game.log";
    //src\LabFP\Lab24\my_log_game.log
    // Método sincronizado para simular ejecución de querys SQL
    public synchronized void ejecutarQuerySQL() {
        escribirEnArchivo("Ejecucion de consulta SQL");
    }
  
    // Método sincronizado para simular muerte de soldado
    public synchronized void muerteDeEjercito(String ejercito) {
        escribirEnArchivo("Muerte de un ejercito: " + ejercito);
    }
  
    // Método sincronizado para simular batalla terminada
    public synchronized void batallaTerminada() {
        escribirEnArchivo("Batalla terminada");
    }
  
    // Método para escribir en el archivo de log
    public void escribirEnArchivo(String mensaje) {
        try (FileWriter writer = new FileWriter(ARCHIVO_LOG, true)) {
            writer.write(mensaje + "\n\n");
            System.out.println("Escrito en el archivo: " + mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  }