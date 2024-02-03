import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaReinos extends JFrame {
    private Reinos reinos;
    private DefaultListModel<String> modeloReino1;
    private DefaultListModel<String> modeloReino2;
    private JList<String> listaReino1;
    private JList<String> listaReino2;

    public VentanaReinos(Reinos reinos) {
        this.reinos = reinos;
        this.modeloReino1 = new DefaultListModel<>();
        this.modeloReino2 = new DefaultListModel<>();
        this.listaReino1 = new JList<>(modeloReino1);
        this.listaReino2 = new JList<>(modeloReino2);

        actualizarListas();

        JButton agregarReino1 = new JButton("Agregar Ejército (Reino 1)");
        JButton eliminarReino1 = new JButton("Eliminar Ejército (Reino 1)");
        JButton agregarReino2 = new JButton("Agregar Ejército (Reino 2)");
        JButton eliminarReino2 = new JButton("Eliminar Ejército (Reino 2)");

        agregarReino1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEjercito(reinos.getReino1());
            }
        });

        eliminarReino1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarEjercito(reinos.getReino1());
            }
        });

        agregarReino2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEjercito(reinos.getReino2());
            }
        });

        eliminarReino2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarEjercito(reinos.getReino2());
            }
        });

        JPanel panelReinos = new JPanel(new GridLayout(1, 2));
        panelReinos.add(new JScrollPane(listaReino1));
        panelReinos.add(new JScrollPane(listaReino2));

        JPanel panelBotones = new JPanel(new GridLayout(2, 2));
        panelBotones.add(agregarReino1);
        panelBotones.add(agregarReino2);
        panelBotones.add(eliminarReino1);
        panelBotones.add(eliminarReino2);

        setLayout(new BorderLayout());
        add(panelReinos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setTitle("Gestión de Ejércitos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addEjercito(String nombreReino) {
        reinos.crearEjercito(nombreReino);
        actualizarListas();
    }

    private void eliminarEjercito(String nombreReino) {
        JList<String> lista = nombreReino.equals(reinos.getReino1()) ? listaReino1 : listaReino2;
        int indiceSeleccionado = lista.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            reinos.getReinos().remove(indiceSeleccionado);
            actualizarListas();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un ejército para eliminar.");
        }
    }

    private void actualizarListas() {
        modeloReino1.clear();
        modeloReino2.clear();
        for (Ejercito ejercito : reinos.getReinos()) {
            String infoEjercito = "Reino:" + ejercito.getReino() +
                    " /Suma de Niveles: " + ejercito.sumarNiveles() +
                    " /X: " + ejercito.getColumna() +
                    " /Y: " + ejercito.getFila();
            if (ejercito.getReino().equals(reinos.getReino1())) {
                modeloReino1.addElement(infoEjercito);
            } else if (ejercito.getReino().equals(reinos.getReino2())) {
                modeloReino2.addElement(infoEjercito);
            }
        }
    }

}
