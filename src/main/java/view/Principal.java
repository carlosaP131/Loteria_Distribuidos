package view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author labinfo04
 */
public class Principal extends javax.swing.JFrame {

    public Integer njugadores, x = 0, y = 0;
    private JLabel imagenAleatoriaLabel; // Declaración del JLabel para mostrar la imagen aleatoria
    private ArrayList<ImageIcon> imagenes; // Lista de imágenes disponibles
    private int imagenActualIndex; // Índice de la imagen actual

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.jpg"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(50, 50));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        //System.out.println("../img/" + 1 + ".jpg");
        //JLabel jl = new JLabel(new ImageIcon("/home/labinfo05/NetBeansProjects/Loteria_Distribuidos/src/main/java/img/1.jpg"));
        // this.add(jl);
        // Crear y mostrar una ventana para cada jugador
        for (int i = 0; i < numPaneles; i++) {
            JFrame ventana = new JFrame("Jugador " + (i + 1));
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.setSize(800, 650); // Tamaño de la ventana

            ventana.setLocation((400 * (i + 1)), 400);//ubicación de la ventana
            // Crear un panel para la cuadrícula de imágenes
            JPanel panel = new JPanel(new GridLayout(4, 13));

            // Crear una lista de números del 1 al 54
            ArrayList<Integer> numeros = new ArrayList<>();
            for (int j = 1; j <= 54; j++) {
                numeros.add(j);
            }

            // Agregar imágenes a la cuadrícula
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    // Barajar los números de forma aleatoria
                    Collections.shuffle(numeros);
                    // Obtener la imagen y escalarla al tamaño deseado
                    ImageIcon icono = new ImageIcon("/home/labinfo05/NetBeansProjects/Loteria_Distribuidos/src/main/java/img/" + numeros.get(k) + ".jpg");
                    Image imagen = icono.getImage().getScaledInstance(75, 150, Image.SCALE_SMOOTH);

                    // Crear un nuevo ImageIcon con la imagen escalada
                    ImageIcon imagenEscalada = new ImageIcon(imagen);

                    // Crear el JLabel con la imagen escalada
                    panel.setLayout(null);
                    JLabel label = new JLabel(imagenEscalada);
                    label.setBounds(x, y, 75, 150);
                    panel.add(label);
                    x = x + 75;
                }
                y = y + 150;
                x = 0;
            }

            /*JButton lanza = new JButton("Lanzar carta");
            lanza.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarImagenAleatoria();
                }
            });
            panel.setLayout(null);
            imagenAleatoriaLabel.setBounds(375, 150, 150, 300);
            panel.add(imagenAleatoriaLabel);
            lanza.setBounds(400, 500, 50, 30);
            panel.add(lanza);*/

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
            ImageIcon icono = new ImageIcon("/home/labinfo05/NetBeansProjects/Loteria_Distribuidos/src/main/java/img/" + j + ".jpg");
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
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
