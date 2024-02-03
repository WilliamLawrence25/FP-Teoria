import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class codigo1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("titulo de interfaz grafica");
        JPanel panel = new JPanel();
        JLabel etiqueta = new JLabel("Hola mundo");
        JButton boton = new JButton("boton");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(etiqueta, BorderLayout.NORTH);
        panel.add(boton, BorderLayout.SOUTH);
        
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "generaste una accion", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}