import java.util.*;

public class Sucursal {
    int nEjemplares;
    int id;
    String nombre;
    String direccion;
    ArrayList<Article> ejemplares;

    public Sucursal(int nEjemp, int id, String nombre, String direccion){
        this.nEjemplares = nEjemp;
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public void mostrarInformacion(){
        System.out.printf("Nombre: %s\nID: %d\nDireccion: %s", this.nombre, this.id, this.direccion);
    }
    public void setId(int code) {
        this.id = code;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setnEjemplares(int ejemplares) {
        this.nEjemplares = ejemplares;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEjemplares(ArrayList<Article> ejemplares) {
        this.ejemplares = ejemplares;
    }
    public int getId() {
        return id;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getnEjemplares() {
        return nEjemplares;
    }
    public String getNombre() {
        return nombre;
    }
}
