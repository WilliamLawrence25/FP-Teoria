import java.awt.*;

import javax.swing.*;

public class Info extends JFrame {
    String reino;
    JPanel panel = new JPanel(new GridLayout(0, 2));

    public Info(int posicion, String reino, Reinos reinos) {
        super("Info de " + reino);
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.reino = reino; // Asigna el valor de reino

        actualizar(reinos, 9);

        setLocationRelativeTo(null);
        Point currentLocation = getLocation();
        int x = currentLocation.x + 543 * posicion;
        int y = currentLocation.y - 20;

        setLocation(x, y);
    }

    public void actualizar(Reinos reinos, int a) {
        panel.removeAll();
        for (int i = 0; i < reinos.getReinos().size(); i++) {
            if (reinos.getReinos().get(i).getReino().equals(reino) && reinos.getReinos().get(i).vive()) {
                JLabel labelNombre = new JLabel(reino + " x_" + reinos.getReinos().get(i).getColumna() + " y_" + reinos.getReinos().get(i).getFila());
                labelNombre.setHorizontalAlignment(JLabel.RIGHT);
                JLabel labelDato = new JLabel("  :" + reinos.getReinos().get(i).sumarNiveles());
                panel.add(labelNombre);
                panel.add(labelDato);
            }
        }
        add(new JScrollPane(panel), BorderLayout.CENTER);
        panel.repaint();
    }
    public void cerrar(){
        System.exit(0);
    }
}

