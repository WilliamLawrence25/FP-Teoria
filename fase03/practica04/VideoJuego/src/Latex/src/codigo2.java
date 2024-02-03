
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class codigo2 extends JPanel {
    private JButton[] boton = new JButton[100];
    private JButton jugar = new JButton();
    private JButton arriba = new JButton();
    private JButton abajo = new JButton();
    private JButton derecha = new JButton();
    private JButton izquierda = new JButton();
    private int x, y, direccion;
    private JPanel jPanel1;
    private JButton iniciarTurno = new JButton();

    public codigo2() {
        initComponents();
    }
    private void initComponents() {

        jPanel1 = new JPanel(new GridLayout(10, 10));
        int lado = 500;
        boton = new JButton[100];
        for (int i = 0; i < 100; i++) {
            boton[i] = new JButton();
            boton[i].setName((i%10) + "" + ((99-i)/10));
            jPanel1.add(boton[i]);
            boton[i].setBorder(BorderFactory.createEtchedBorder());
            boton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    botonActionPerformed(e);
                }

            });
        }
        int ladoBoton = 50;
        iniciarTurno = new JButton();
        jugar = new JButton();
        arriba = new JButton();
        abajo = new JButton();
        derecha = new JButton();
        izquierda = new JButton();
        arriba.setText("ar");
        arriba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                direccion = 2;
                System.out.println(2);
            }
        });
        izquierda.setText("iz");
        izquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                direccion = 1;
                System.out.println(1);
            }
        });
        derecha.setText("de");
        derecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                direccion = 4;
                System.out.println(4);
            }
        });
        abajo.setText("ab");
        abajo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                direccion = 3;
                System.out.println(3);
            }
        });
        iniciarTurno.setText("iniciando");
        iniciarTurno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //funcion movimietno en el reino
                //funcion actualizacion de visualizacion del tablero segun la lista del reino
                System.out.println("Comenzando");
                repaint();
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, lado, lado, lado)
                .addGroup(layout.createSequentialGroup()
                    .addGap(lado+75,lado+75,lado+75)
                    .addComponent(izquierda, ladoBoton, ladoBoton, ladoBoton)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(arriba, ladoBoton, ladoBoton, ladoBoton)
                        .addComponent(abajo , ladoBoton, ladoBoton, ladoBoton)) 
                    .addComponent(derecha, ladoBoton, ladoBoton, ladoBoton))
                .addGroup(layout.createSequentialGroup()
                    .addGap(lado, lado +75, lado+ 75)
                    .addComponent(iniciarTurno, ladoBoton, ladoBoton + 100, ladoBoton+100)
                )
        );

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, lado, lado, lado)
                .addGroup(layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(arriba, ladoBoton, ladoBoton, ladoBoton)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(derecha, ladoBoton, ladoBoton, ladoBoton)
                        .addComponent(izquierda, ladoBoton, ladoBoton, ladoBoton))
                    .addComponent(abajo, ladoBoton, ladoBoton, ladoBoton))
                .addGroup(layout.createSequentialGroup()
                    .addGap(75,75,75)
                    .addComponent(iniciarTurno, ladoBoton, ladoBoton, ladoBoton)      
                )
        );
    }

    private void botonActionPerformed(ActionEvent e) {
        int num = Integer.parseInt(((JButton)e.getSource()).getName());
        this.x = (num/10) +1;
        this.y = (num%10) +1;
    }
    public void casilla(){
        
    }
}
