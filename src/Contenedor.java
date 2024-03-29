import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contenedor extends JFrame implements ActionListener {

    private JButton boton_izquierda, boton_derecha, boton_pausa;
    private JLabel label_estado, label_tiempo;
    Font customFont = new Font("Arial", Font.BOLD, 16);

    public Contenedor(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Control de Motor GUI");

        label_estado = new JLabel("Estado: Detenido");
        label_estado.setFont(customFont);
        label_estado.setBounds(134,100,300,100);
        add(label_estado);

        // Crear un nuevo ImageIcon
        ImageIcon img_flecha_izquierda = new ImageIcon("img/flecha-izquierda.png");
        boton_izquierda = new JButton(img_flecha_izquierda);
        boton_izquierda.setBounds(134,200,64,64);
        boton_izquierda.addActionListener(this);
        add(boton_izquierda);

        ImageIcon img_pausa = new ImageIcon("img/pausa.png");
        boton_pausa = new JButton(img_pausa);
        boton_pausa.setBounds(218,200,64,64);
        boton_pausa.addActionListener(this);
        add(boton_pausa);

        ImageIcon img_flecha_derecha = new ImageIcon("img/flecha-correcta.png");
        boton_derecha = new JButton(img_flecha_derecha);
        boton_derecha.setBounds(302,200,64,64);
        boton_derecha.addActionListener(this);
        add(boton_derecha);

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = sdf.format(now);

        label_tiempo = new JLabel(formattedTime);
        label_tiempo.setFont(customFont);
        label_tiempo.setBounds(218,250,100,100);
        add(label_tiempo);

        // Crear un Timer para actualizar el tiempo cada segundo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la hora actual
                Date now = new Date();
                // Formatear la hora en el formato deseado (por ejemplo, HH:mm:ss)
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String formattedTime = sdf.format(now);
                // Actualizar el texto del JLabel con la hora formateada
                label_tiempo.setText(formattedTime);
            }
        });
        timer.start(); // Iniciar el Timer
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == boton_izquierda){
            label_estado.setText("Estado: Girando en sentido antihorario");
        }
        if (e.getSource() == boton_pausa){
            label_estado.setText("Estado: Detenido");
        }
        if (e.getSource() == boton_derecha){
            label_estado.setText("Estado: Girando en sentido horario");
        }
    }
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        contenedor.setBounds(0,0,500,500);
        contenedor.setVisible(true);
        contenedor.setResizable(false);
        contenedor.setLocationRelativeTo(null);
    }
}