import java.util.ArrayList;
import java.util.List;

public class Reinos {
    private List<Ejercito> reinos = new ArrayList<>(); //batalla entre varios ejercitos
    private boolean vivo1;
    private boolean vivo2;
    private String reino1;
    private String reino2;

    public void Reinos(){//nombramiento de reinos
        int uno, dos;
        do {
            uno = (int) (Math.random() * 5 + 1);
            dos = (int) (Math.random() * 5 + 1);
        } while (uno == dos);
        this.reino1 = nombreReino(uno);
        this.reino2 = nombreReino(dos);
        this.vivo1 = true;
        this.vivo2 = true;
        crearReinos();
    }

    
    public List<Ejercito> getReinos(){
        return reinos;
    }
    public boolean getVivo(String reino_cual){
        if (reino_cual.equals(reino1)) 
            return vivo1;
        if (reino_cual.equals(reino2)) 
            return vivo2;
        return false;
    }
    public void setVivo(boolean vivo, String reino_cual){
        if (reino_cual.equals(reino1)) 
            this.vivo1 = vivo1;
        if (reino_cual.equals(reino2)) 
            this.vivo2 = vivo2;
    }
    public String toString(){
        String a = "";
        for (Ejercito ejercito : reinos) {
            a =  a + "Reino: " + ejercito.getReino() + " columna " + ejercito.getColumna() + " Fila: " + ejercito.getFila() +"  "+ ejercito.sumarNiveles()+"\n";
        }
        return a;
    }


    public void mostrarReinos(){
        System.out.println(reinos.toString());
        System.out.println(reino1 + " primer reino " + vivo1);
        System.out.println(reino2 + " primer reino " + vivo2);
    }

    //-----------Guerra entre 2 reinos
    public void crearReinos(){
        crearReino(this.reino1);
        crearReino(this.reino2);
        posicionamientoEjercitos();
    }
    private String nombreReino(int i){
        switch (i) {
            case 1:  return "Inglaterra     ";
            case 2:  return "Francia        ";
            case 3:  return "Castilla-Aragón";
            case 4:  return "Sacro Imperio  ";
            case 5:  return "Moros          ";
            default: return "";
        }
    }
    public String getReino1(){
        return reino1;
    }
    public String getReino2(){
        return reino2;
    }
    public void crearReino(String reino){
        int numEjerc = (int) (Math.random() * 10 + 1);
        for (int i = 0; i < numEjerc; i++) {
            crearEjercito(reino);
        }
    }
    public void crearEjercito(String reino){
        reinos.add(new Ejercito(reino));
    }


    //Posicionamiento en en los ejercitos
    public void posicionamientoEjercitos(){
        for (int i = 0; i < reinos.size(); i++) {
            int x, y;
            do {
                x = (int) (Math.random() * 10 + 1);
                y = (int) (Math.random() * 10 + 1);
            } while (!(verificarPosicionLibreEjercitos(x, y)));
            reinos.get(i).setColumna(x);
            reinos.get(i).setFila(y);
        }
    }
    public boolean verificarPosicionLibreEjercitos(int x, int y){
        int a,b;
        for (Ejercito ejercito : reinos) {
            a = ejercito.getColumna();
            b = ejercito.getFila();
            if(a == x && b == y){
                return false;
            }
        }
        return true;
    }

    //Posicionamiento de soldados cuando sea la hora
    public void posicionamientoSoldados(Ejercito uno , Ejercito dos){
        int uno1 = uno.getEjercito().size();
        int dos2 = dos.getEjercito().size();
        for (int i = 0 ; i <= uno1 + dos2 ; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
            } while (!(uno.verificarPosicionLibreSoldado(x, y) && dos.verificarPosicionLibreSoldado(x, y))); 
            if (i < dos2) {
                uno.getEjercito().get(i).setColumna(x);
                uno.getEjercito().get(i).setFila(y);
            }else{
                dos.getEjercito().get(i - dos2).setColumna(x);
                dos.getEjercito().get(i - dos2).setFila(y);
            }
        }
    }

    public boolean verificarEnemigoPosicion(int x, int y, Ejercito ejer){
        int a,b;
        for (Ejercito ejercito : reinos) {
            if (!(ejercito.getReino().equals(ejer.getReino()))) {
                a = ejercito.getColumna();
                b = ejercito.getFila();
                if((a == x)&&(b == y))
                    return true;
            }
        }
        return false;
    }
    public boolean verificarAmigoPosicion(int x, int y, Ejercito ejer){
        int a,b;
        for (Ejercito ejercito : reinos) {
            if (ejercito.getReino().equalsIgnoreCase(ejer.getReino())) {
                a = ejercito.getColumna();
                b = ejercito.getFila();
                if(a == x && b == y)
                    return true;
            }
        }
        return false;
    }




    //movimientos de los ejercitos
    public boolean validaPosicion(int a){
        return (a >= 1 && a <= 10);
    }
    public void alFrente(int i) {
        int y = reinos.get(i).getFila() + 1;
        if (validaPosicion(y))
            reinos.get(i).setFila(y); 
    }
    public void atras(int i) {
        int y = reinos.get(i).getFila() - 1;
        if (validaPosicion(y))
            reinos.get(i).setFila(y);
    }
    public void izquierda(int i) {
        int x = reinos.get(i).getColumna()-1;
        if (validaPosicion(x))
            reinos.get(i).setColumna(x);
    }
    public void derecha(int i) {
        int x = reinos.get(i).getColumna()+1;
        if (validaPosicion(x))
            reinos.get(i).setColumna(x);
    }

    //metricas de ganador 
    public void enfrentamientoSoldado(Soldado uno, Soldado dos){
        double probabilidad = (Math.random()*100+1);
        int a = uno.getVidaActual();
        int b = dos.getVidaActual();
        if ((a*100.0)/(a+b) > probabilidad) {
            uno.setVive(false);
        }else{
            dos.setVive(false);
        }
    }
    public String enfrentamientoEjercito(int index_uno, int index_dos){
        double probabilidad = (Math.random()*100+1);
        int a = reinos.get(index_uno).sumarNiveles();
        int b = reinos.get(index_dos).sumarNiveles();
        if ((a*100.0)/(a+b) > probabilidad) {
            reinos.get(index_uno).setVive(false);
            return "c:" + reinos.get(index_uno).getColumna() + "_F:" + reinos.get(index_uno).getFila();
        }else{
            reinos.get(index_dos).setVive(false);
            return "c:" + reinos.get(index_dos).getColumna() + "_F:" + reinos.get(index_dos).getFila();
        }
    }

    public void enfrentamientoEjercito(int x, int y, int x_x, int y_y){
        enfrentamientoEjercito(buscarEjercito(x, y),buscarEjercito(x_x, y_y));
    }
    public int buscarEjercito(int x, int y){
        int a,b;
        for (int i = 0; i < reinos.size(); i++) {
            a = reinos.get(i).getColumna();
            b = reinos.get(i).getFila();
            if(a == x && b == y){
                return i;
            }
        }
        return -1;
    }
    public boolean verificarReinos(){
        int uno = 0;
        int dos = 0;
        for (Ejercito ejercito : reinos) {
            if(ejercito.getReino().equals(reino1) && ejercito.vive()){
                uno++;
            }else if(ejercito.getReino().equals(reino2) && ejercito.vive()){
                dos++;
            }
        }
        return (uno == 0) || (dos == 0);
    }
    public String ganador_perdedor(Boolean gan_per){
        int uno = 0;//si ingresa true es gan y si es false es perd
        for (Ejercito ejercito : reinos) {
            if(ejercito.getReino().equals(reino1) && ejercito.vive())
                uno++;
        }
        if (gan_per) {
            if (uno != 0) {
                return reino1;
            }else{
                return reino2;
            }
        }else{
            if (uno == 0) {
                return reino1;
            }else{
                return reino2;
            }
        }

    }
    public int numEjercitoFinal(String reino){
        int num = 0;
        for (Ejercito ejercito : reinos) {
            if(ejercito.getReino().equals(reino) && ejercito.vive()){
                num++;
            }
        }
        System.out.println("final"+num + reino);
        return num;
    }
    public int numEjercito(String reino){
        int num = 0;
        for (Ejercito ejercito : reinos) {
            if(ejercito.getReino().equals(reino)){
                num++;
            }
        }
        System.out.println("inicio"+num + reino);
        return num;
    }
}