import javax.swing.*;

import pruebas_interfaz.JuegoPersonalizado;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JPanel  menu;
    private JButton jugar;
    private JButton juego_Perzonalizado;
    private JButton salir;
    public Menu() {
        setSize(800, 530);
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Menu");
        this.setVisible(true);
    }

    private void initComponents() {

        menu  = new JPanel();
        jugar = new JButton();
        juego_Perzonalizado = new JButton();
        salir = new JButton();


        jugar.setText("Jugar");
        jugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Juegar");
                Juego a = new Juego();
                cambiarPanel(a);
            }
        });

        juego_Perzonalizado.setText("Juego Perzonalizado");
        juego_Perzonalizado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Perzonalizado");
                JuegoPersonalizado JP = new JuegoPersonalizado();
                cambiarPanel(JP);
            }
        });

        salir.setText("Exit");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        GroupLayout MenuLayout = new GroupLayout(menu);
        menu.setLayout(MenuLayout);
        JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("img/fondo_principal.jpg")));
        
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jugar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 800))
            .addGroup(GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, 800)
                .addComponent(salir, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(juego_Perzonalizado, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, 800))
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(fondo, 800,800 ,800 )
            )
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jugar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(juego_Perzonalizado, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, 800)
                .addComponent(salir, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(fondo, 500,500 ,500 )
            
            )
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(menu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 800)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(menu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 800)
        );
        

    }


    public void cambiarPanel(JPanel p){
        p.setSize(800, 500);
        p.setLocation(0,0);
        menu.removeAll();
        menu.add(p);
        menu.revalidate();
        menu.repaint();
    }
}