package view;

import controller.CantadorController;
import controller.CartaController;
import controller.CartonController;
import controller.JuegoController;
import controller.JugadorController;
import model.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Carton;
import model.Jugador;

/**
 *
 * @author labinfo04
 */
public class Principal extends javax.swing.JFrame {

    private JuegoController juegoController;
    private Juego juegoLoteria;
    //lista de cartas para el cantador
    private ArrayList<Carta> cartasEnCantaro;
    private ArrayList<Jugador> listaJugadores;
    private CantadorController cantadorController;
    private CartonController cartonController;

    private CartaController cartaController;
    private JugadorController jugadorController;
    
    private Cantador cantador;

    public Integer njugadores, x = 0, y = 0;
    private JLabel imagenAleatoriaLabel; // Declaración del JLabel para mostrar la imagen aleatoria
    private ArrayList<ImageIcon> imagenes; // Lista de imágenes disponibles
    private int imagenActualIndex; // Índice de la imagen actual

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        cantador=new Cantador();
        listaJugadores=new ArrayList<>();
        juegoController = new JuegoController();
        juegoLoteria = juegoController.crearJuego(cantador, listaJugadores);//JUEGO PRINCIPAL
        cartasEnCantaro = new ArrayList<>();
        cantadorController = new CantadorController(cartasEnCantaro);
        cartonController = new CartonController();
        cartaController = new CartaController();
        jugadorController = new JugadorController();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setText("Lotería");

        jLabel2.setText("Número de jugadores:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        njugadores = Integer.valueOf(jComboBox1.getSelectedItem().toString());
        generarPaneles(njugadores);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void generarPaneles(int numPaneles) {

        // Crear y mostrar una ventana para cada jugador
        for (int i = 0; i < numPaneles; i++) {
            crearJugadores(numPaneles);//CREAMOS LOS JUGADORES
            JFrame ventana = new JFrame(juegoController.obtenerJugadorId(
                    juegoLoteria, i).getNombre());//LE DAMOS UN NOMBRE AL FRAME PARA CARGAR LAS CARTAS

            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.setSize(800, 650); // Tamaño de la ventana

            ventana.setLocation(100 + (800 * (i * 10)), 100);//ubicación de la ventana
            // Crear un panel para la cuadrícula de imágenes
            JPanel panel = new JPanel(new GridLayout(4, 13));

            
            pintarCartasEnPanel(panel, juegoController.obtenerJugadorId(
                    juegoLoteria, i).getCarton());
            

            // Agregar el panel a la ventana
            ventana.add(panel);

            // Mostrar la ventana
            ventana.setVisible(true);
            y = 0;
        }
    }

    private void mostrarImagenAleatoria() {
        imagenes = new ArrayList<>();
        for (int j = 1; j <= 54; j++) {
            ImageIcon icono = new ImageIcon("/home/skar/NetBeansProjects/Loteria_Distribuidos/src/main/java/img/" + j + ".jpg");
            imagenes.add(icono);
        }
        if (imagenes != null && !imagenes.isEmpty()) {
            // Obtener un índice aleatorio para seleccionar una imagen
            Random random = new Random();
            imagenActualIndex = random.nextInt(imagenes.size());

            // Mostrar la imagen aleatoria en el JLabel
            imagenAleatoriaLabel.setIcon(imagenes.get(imagenActualIndex));
        }
    }

    private void crearJugadores(int num) {
        for (int i = 0; i < num; i++) {
            Carton carton = crearCartonImg();
            //AGREGAR IMAGENES AL CARTÓN
            Jugador jugador = jugadorController.crearJugador(i + 1, "jugador" + i, carton);
            juegoController.agregarJugador(juegoLoteria, jugador);
        }
    }

    private Carton crearCartonImg() {
        Carton carton = new Carton();
        carton.setCartasEnCarton(new ArrayList<>());
        ArrayList<Integer> idsCartas = obtenerImagenes();
        for (int i = 0; i < idsCartas.size(); i++) {
            Carta carta = cartaController.crearCarta(idsCartas.get(i), "ejemplo", "/home/skar/NetBeansProjects/Loteria_Distribuidos/src/main/java/img/", i * 75, i * 150);
            cartonController.agregarCartaAlCarton(carton, carta);
        }
        return carton;
    }

    private ArrayList<Integer> obtenerImagenes() {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int j = 1; j <= 16; j++) {
            numeros.add(j);
        }
        return numeros;
    }

    private void pintarCartasEnPanel(JPanel panel, Carton carton) {
        // Obtener la lista de cartas del cartón
        ArrayList<Carta> cartasEnCarton = carton.getCartasEnCarton();

        // Iterar sobre las cartas y agregarlas al panel
        for (Carta carta : cartasEnCarton) {
            // Obtener la ruta de la imagen de la carta
            String rutaImagen = carta.getRutaCarta();

            // Cargar la imagen y escalarla al tamaño deseado
            ImageIcon icono = new ImageIcon(rutaImagen+carta.getIdCarta()+".jpg");
            Image imagen = icono.getImage().getScaledInstance(75, 150, Image.SCALE_SMOOTH);

            // Crear un nuevo ImageIcon con la imagen escalada
            ImageIcon imagenEscalada = new ImageIcon(imagen);

            // Crear el JLabel con la imagen escalada y establecer su posición
            JLabel label = new JLabel(imagenEscalada);
            label.setBounds(carta.getPosX(), carta.getPosY(), 75, 150);

            // Agregar el JLabel al panel
            panel.add(label);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
