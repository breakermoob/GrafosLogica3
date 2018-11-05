package Grafos;

import java.awt.Image;
import java.io.*;
import java.util.logging.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Principal extends javax.swing.JFrame {

    private FileNameExtensionFilter filtrar = new FileNameExtensionFilter("Archivos de texto", "txt");
    private Grafos grafo = new Grafos();
    private String muestra, muestra2;

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        PanelAyuda.setVisible(false);
        MostrarCaminos.setVisible(false);
        Caminos.setVisible(false);
        MenorCamino.setVisible(false);
        TextoSalida.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        SeleccionarPalInicial.setVisible(false);
        SeleccionarPalFinal.setVisible(false);
        GenerarGrafo.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SeleccionarArchivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        GenerarGrafo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SeleccionarPalInicial = new javax.swing.JComboBox<>();
        SeleccionarPalFinal = new javax.swing.JComboBox<>();
        PanelAyuda = new javax.swing.JScrollPane();
        muestraGrafo = new javax.swing.JLabel();
        Caminos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MostrarCaminos = new javax.swing.JTable();
        MenorCamino = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextoSalida = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SeleccionarArchivo.setText("Seleccionar Archivo");
        SeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarArchivoActionPerformed(evt);
            }
        });

        jLabel1.setText("Por favor seleccione un archivo (.txt):");

        GenerarGrafo.setText("Crear Grafo");
        GenerarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarGrafoActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione palabra inicial");

        jLabel3.setText("Seleccione palabra final");

        muestraGrafo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelAyuda.setViewportView(muestraGrafo);

        Caminos.setText("Mostrar Caminos");
        Caminos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaminosActionPerformed(evt);
            }
        });

        MostrarCaminos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Todos los caminos existentes"
            }
        ));
        jScrollPane1.setViewportView(MostrarCaminos);

        MenorCamino.setText("Menor Camino");
        MenorCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenorCaminoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Algerian", 3, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("!!!!PROCESADOR DE GRAFOS 5000 EXTREME!!!!!");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        TextoSalida.setEditable(false);
        TextoSalida.setColumns(20);
        TextoSalida.setRows(5);
        jScrollPane2.setViewportView(TextoSalida);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(SeleccionarPalInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(SeleccionarPalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(GenerarGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Caminos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(MenorCamino, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(SeleccionarArchivo)))))
                .addGap(116, 116, 116)
                .addComponent(PanelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1))
                            .addComponent(SeleccionarArchivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(SeleccionarPalInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(SeleccionarPalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(GenerarGrafo)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Caminos)
                            .addComponent(MenorCamino))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Salir))
                    .addComponent(PanelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarArchivoActionPerformed
        TextoSalida.setVisible(true);
        grafo = new Grafos();
        muestraGrafo.setIcon(null);
        JFileChooser selecciona = new JFileChooser();
        selecciona.setFileFilter(filtrar);
        int opc = selecciona.showOpenDialog(this);
        if (opc == JFileChooser.APPROVE_OPTION) {
            String ruta = selecciona.getSelectedFile().getAbsolutePath();
            FileInputStream archivo;
            GenerarGrafo.setEnabled(true);
            TextoSalida.setEnabled(true);
            try {
                archivo = new FileInputStream(ruta);
                DataInputStream entrada = new DataInputStream(archivo);
                BufferedReader bf = new BufferedReader(new InputStreamReader(entrada));
                String lineas;
                String texto = "";

                while ((lineas = bf.readLine()) != null) {
                    TextoSalida.setText(lineas);
                }
                GenerarGrafo.setVisible(true);
                SeleccionarPalInicial.setVisible(true);
                jLabel2.setVisible(true);
                jLabel3.setVisible(true);
                PanelAyuda.setVisible(true);
                PanelAyuda.setEnabled(false);
                GenerarGrafo.setVisible(true);
                SeleccionarPalFinal.setVisible(true);
                SeleccionarPalInicial.removeAllItems();
                SeleccionarPalFinal.removeAllItems();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String aux = (TextoSalida.getText() + ".").toLowerCase();
        String vec[] = grafo.vertices(aux);
        for (int i = 0; i < vec.length; i++) {
            SeleccionarPalInicial.addItem(vec[i]);
            SeleccionarPalFinal.addItem(vec[i]);
        }
    }//GEN-LAST:event_SeleccionarArchivoActionPerformed

    private void GenerarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarGrafoActionPerformed
        if (SeleccionarPalInicial.getSelectedItem().equals(SeleccionarPalFinal.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione dos palabras diferentes ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            int pos1 = SeleccionarPalInicial.getSelectedIndex();
            int pos2 = SeleccionarPalFinal.getSelectedIndex();
            muestra = SeleccionarPalInicial.getSelectedItem().toString();
            muestra2 = SeleccionarPalFinal.getSelectedItem().toString();
            int aux = grafo.numLetrasDife(SeleccionarPalInicial.getSelectedItem().toString(), SeleccionarPalFinal.getSelectedItem().toString());
            grafo.desPalabras(aux, pos1);
            grafo.crearMatriz();
            int matriz[][] = grafo.mat;
            if (matriz != null) {
                try {
                    Thread.sleep(2000);

                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                ImageIcon dibujo = new ImageIcon(new ImageIcon("C:\\Users\\Public\\Grafos.jpg").getImage());
                int x = dibujo.getIconHeight();
                int y = dibujo.getIconWidth();
                muestraGrafo.setSize(x, y);
                muestraGrafo.setIcon(dibujo);
                jLabel1.setVisible(false);
                jLabel2.setVisible(false);
                jLabel3.setVisible(false);
                SeleccionarPalInicial.setVisible(false);
                SeleccionarPalFinal.setVisible(false);
                GenerarGrafo.setVisible(false);
                Caminos.setVisible(true);
                MostrarCaminos.setVisible(true);
            } else {
                jLabel2.setVisible(false);
                jLabel3.setVisible(false);
                SeleccionarPalInicial.setVisible(false);
                SeleccionarPalFinal.setVisible(false);
                GenerarGrafo.setVisible(false);
                JOptionPane.showMessageDialog(null, " La palabra ingresada no puede convertirse en otra "+
                "ya que se necesitan mas de dos cambios, por lo tanto no hay caminos posibles", "Error ", JOptionPane.ERROR_MESSAGE);
            }
        }
        SeleccionarArchivo.disable();
        SeleccionarArchivo.setVisible(false);
    }//GEN-LAST:event_GenerarGrafoActionPerformed

    private void CaminosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaminosActionPerformed
        MostrarCaminos.setVisible(true);
        MenorCamino.setVisible(true);
        String a[];
        if (muestra != null && muestra2 != null) {
            grafo.caminos(grafo.buscar(muestra), grafo.buscar(muestra2));
            DefaultTableModel model = (DefaultTableModel) MostrarCaminos.getModel();
            TableColumnModel columnModel = MostrarCaminos.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(700);
            MostrarCaminos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            MostrarCaminos.doLayout();
            a = grafo.mostrarCaminos(grafo.getpila());
            model.setRowCount(a.length);
            MenorCamino.setEnabled(true);
            for (int i = 0; i < a.length; i++) {
                MostrarCaminos.setValueAt(a[i], i, 0);
                System.out.println(" es "+i);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha ingresado algun vertices o los vertices son incorrectos, por favor intente de nuevo", "ERROR!!", JOptionPane.ERROR_MESSAGE);

        }
        Caminos.setVisible(false);
    }//GEN-LAST:event_CaminosActionPerformed

    private void MenorCaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenorCaminoActionPerformed
        
        JOptionPane.showMessageDialog(null,"El menor camino es: \n "+grafo.menorCamino(), "Menor Camino entre "+ muestra +" y " + muestra2, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_MenorCaminoActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Caminos;
    private javax.swing.JButton GenerarGrafo;
    private javax.swing.JButton MenorCamino;
    private javax.swing.JTable MostrarCaminos;
    private javax.swing.JScrollPane PanelAyuda;
    private javax.swing.JButton Salir;
    private javax.swing.JButton SeleccionarArchivo;
    private javax.swing.JComboBox<String> SeleccionarPalFinal;
    private javax.swing.JComboBox<String> SeleccionarPalInicial;
    private javax.swing.JTextArea TextoSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel muestraGrafo;
    // End of variables declaration//GEN-END:variables
}
