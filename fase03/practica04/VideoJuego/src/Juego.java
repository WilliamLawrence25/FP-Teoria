import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego extends JPanel {
    private ArchivoLog archivoLog = new ArchivoLog();
    private Reinos reinos;
    ImageIcon reino1 = new ImageIcon(getClass().getResource("img/inglaterra.png"));//47 de ancho
    ImageIcon reino2 = new ImageIcon(getClass().getResource("img/moros.png"));
    ImageIcon arribaIcon = new ImageIcon(getClass().getResource("img/i-arriba.jpg"));
    ImageIcon abajoIcon = new ImageIcon(getClass().getResource("img/i-abajo.jpg"));
    ImageIcon derechaIcon = new ImageIcon(getClass().getResource("img/i-derecha.jpg"));
    ImageIcon izquierdaIcon = new ImageIcon(getClass().getResource("img/i-izquierda.jpg"));
    private JButton[] boton = new JButton[100];
    private JButton arriba;
    private JButton abajo;
    private JButton derecha;
    private JButton izquierda;
    private int x, y, direccion, x_x, y_y;
    private JPanel jPanel1;
    private JButton iniciarTurno;
    Info reino1Info;
    Info reino2Info;

    public Juego() {
        initComponents();
        reinos = new Reinos();
        reinos.Reinos();
        actualizarIcon();
        actualizarColor();
        reino1Info = new Info(1 ,reinos.getReino1(),reinos);
        reino2Info = new Info(-1,reinos.getReino2(),reinos);
        reino1Info.setVisible(true);
        reino2Info.setVisible(true);
    }

    private void initComponents() {
        jPanel1 = new JPanel(new GridLayout(10, 10));
        int lado = 500;
        for (int i = 0; i < 100; i++) {
            boton[i] = new JButton();
            boton[i].setName((i%10) + "" + ((99-i)/10));
            jPanel1.add(boton[i]);
            boton[i].setBorder(BorderFactory.createEtchedBorder());
            boton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {botonActionPerformed(e);}
            });
        }

        int ladoBoton = 50;
        iniciarTurno = new JButton();
        arriba = new JButton();
        abajo = new JButton();
        derecha = new JButton();
        izquierda = new JButton();
        Label turno = new Label("Turno de ");
        turno.setBounds(lado, lado, 150, 30);

        arriba.setBackground(new Color(200,50,50));
        arriba.setIcon(arribaIcon);;
        arriba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                direccion = 2;
            }
        });
        izquierda.setBackground(new Color(50,200,50));
        izquierda.setIcon(izquierdaIcon);
        izquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                direccion = 1;
            }
        });
        derecha.setBackground(new Color(50,50,200));
        derecha.setIcon(derechaIcon);
        derecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                direccion = 4;
            }
        });
        abajo.setOpaque(false);
        abajo.setContentAreaFilled(false);
        abajo.setBorderPainted(false);
        abajo.setBackground(new Color(200,250,100));
        abajo.setIcon(abajoIcon);
        abajo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                direccion = 3;
            }
        });
        iniciarTurno.setText("iniciando");
        iniciarTurno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                moviendoReino(evt);
                actualizarIcon();
                actualizarColor();
                if(reinos.verificarReinos()){
                    JOptionPane.showMessageDialog(null, "¡El juego ha terminado!", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
                    Juego a = new Juego();
                    Menu b = new Menu();
                    b.cambiarPanel(a);
                    int idUsuario = ConexionBD.getId();
                    String ganador = reinos.ganador_perdedor(true); 
                    String perdedor = reinos.ganador_perdedor(false);
                    int numSolGanad = reinos.numEjercito(ganador);
                    int numSolEnemi = reinos.numEjercito(perdedor);

                    ConexionBD.registrarPartida(idUsuario, ganador, perdedor, numSolGanad, numSolEnemi);
                    archivoLog.ejecutarQuerySQL();
                    archivoLog.batallaTerminada();
                    System.exit(0);
                    reino1Info.cerrar();
                    reino2Info.cerrar();
                }
                reino1Info.actualizar(reinos,x);
                reino2Info.actualizar(reinos,x);
                reino1Info.setVisible(true);
                reino2Info.setVisible(true);
            }
        });


        GroupLayout layout = new GroupLayout(this);
        JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("img/fondo1.jpg")));

        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, lado, lado, lado)
                .addGroup(layout.createSequentialGroup()
                    .addGap(lado+65,lado+65,lado+65)
                    .addComponent(izquierda, ladoBoton, ladoBoton, ladoBoton)
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(arriba, ladoBoton, ladoBoton, ladoBoton)
                        .addComponent(abajo , ladoBoton, ladoBoton, ladoBoton)) 
                    .addGap(5, 5, 5)
                    .addComponent(derecha, ladoBoton, ladoBoton, ladoBoton))
                .addGroup(layout.createSequentialGroup()
                    .addGap(lado + 70, lado + 70, lado + 70)
                    .addComponent(iniciarTurno, ladoBoton+100, ladoBoton + 100, ladoBoton+100))
                .addGroup(layout.createSequentialGroup()
                    .addGap(lado, lado, lado)
                    .addComponent(turno, ladoBoton, ladoBoton + 100, ladoBoton + 100))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(fondo, 800,800 ,800 )
                )
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, lado, lado, lado)
                .addGroup(layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(arriba, ladoBoton, ladoBoton, ladoBoton)
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(derecha, ladoBoton, ladoBoton, ladoBoton)
                        .addComponent(izquierda, ladoBoton, ladoBoton, ladoBoton))
                    .addGap(5, 5, 5)
                    .addComponent(abajo, ladoBoton, ladoBoton, ladoBoton)) 
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(iniciarTurno, ladoBoton, ladoBoton, ladoBoton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(turno, ladoBoton, ladoBoton, ladoBoton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fondo, 500,500 ,500 )
                    )
        );
    }


    //acciones y funciones de los botones
    //----------cada boton revela la ubicacion a la que se presiona

    private void botonActionPerformed(ActionEvent e) {
        actualizarColor();
        int num = Integer.parseInt(((JButton)e.getSource()).getName());
        this.x = (num/10) +1;
        this.y = (num%10) +1;
        ((JButton)e.getSource()).setBackground(new Color(0,0,0));
    }
    private void moviendoReino(ActionEvent e) {
        if(!reinos.verificarPosicionLibreEjercitos(x , y)){//veridficar si la casilla que presiono tiene un ejercito
            int ejercitoArray = reinos.buscarEjercito(x, y);
            x_x = x;
            y_y = y;
            movimientoCopia();
            if(reinos.verificarPosicionLibreEjercitos(x_x, y_y)){
                movimiento(ejercitoArray);
            }else if(reinos.verificarAmigoPosicion(x_x, y_y, reinos.getReinos().get(reinos.buscarEjercito(x,y)))){
            }else{
                String a = combate(ejercitoArray, reinos.buscarEjercito(x_x, y_y));
                archivoLog.ejecutarQuerySQL();
                archivoLog.muerteDeEjercito(a);
                movimiento(ejercitoArray);
            }
        }
    }
    private void movimiento(int ejercitoArray){
        switch (direccion) {
            case 1: reinos.izquierda(ejercitoArray);x--;  break;//izquierda
            case 2: reinos.alFrente(ejercitoArray) ;y++;  break;//arriba
            case 3: reinos.atras(ejercitoArray)    ;y--;  break;//abajo
            case 4: reinos.derecha(ejercitoArray)  ;x++;  break;//derecha
            default:System.out.println("Error: movimiento() --> Juego");  break;
        }
    }
    private void movimientoCopia(){
        switch (direccion) {
            case 1: x_x--; if(!(x_x <= 10 && x_x >= 1))  x_x++; break;//izquierda
            case 2: y_y++; if(!(y_y <= 10 && y_y >= 1))  y_y--; break;//arriba
            case 3: y_y--; if(!(y_y <= 10 && y_y >= 1))  y_y++; break;//abajo
            case 4: x_x++; if(!(x_x <= 10 && x_x >= 1))  x_x--; break;//derecha
            default:System.out.println("Error: movimiento() --> Juego-otro");  break;
        }
    }



    private void actualizarColor(){
        Color colora = new Color(0, 56, 43); //colores que puede cambiarlo el mapa
        Color colorb = new Color(25, 65, 47);//colores que puede cambiarlo el mapa
        for (int i = 0; i < 100; i++) {
            if((i%2==0 && i/10%2 == 0) || (i/10%2==1 && i%2==1 )){
                boton[i].setBackground(colora);
            }else{
                boton[i].setBackground(colorb);
            }
        }
    }
    private void actualizarIcon(){
        int col,fil;
        for(int i = 0; i < 100; i++){
            boton[i].setIcon(null);
        }
        for(int i = 0; i < reinos.getReinos().size(); i++){
            col = reinos.getReinos().get(i).getColumna();
            fil = reinos.getReinos().get(i).getFila();
            if(reinos.getReinos().get(i).getReino().equalsIgnoreCase(reinos.getReino1()) && reinos.getReinos().get(i).vive()){
                boton[(10-fil)*10 + (col-1)].setIcon(reino1);
            }else if(reinos.getReinos().get(i).getReino().equalsIgnoreCase(reinos.getReino2())&& reinos.getReinos().get(i).vive()){
                boton[(10-fil)*10 + (col-1)].setIcon(reino2);
            }
        }
    }
    private String combate(int ejercitoArray, int enemigo){
        String a = reinos.enfrentamientoEjercito(ejercitoArray, enemigo);
        return a;
    }
}
