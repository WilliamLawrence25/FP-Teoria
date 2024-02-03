package pruebas_interfaz;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelFondo extends JPanel{
    Color colorFondo = colorFondo = Color.gray;
    int tamax, tam, can;
    
    public PanelFondo(int tamax, int can){
        this.tamax = tamax;
        this.can = can;
        this.tam = tamax/can;
    }
    public void paint(Graphics pinta){
        super.paint(pinta);
        pinta.setColor(colorFondo);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pinta.fillRect(i* tam, j*  tam, tam-1, tam-1);
            }
        }
    }

    void setBounds() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
