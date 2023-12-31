/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formularios;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javierbs.interfaces.practica1_javierbernardo.entidades.Aeropuerto;
import javierbs.interfaces.practica1_javierbernardo.entidades.Compania;
import javierbs.interfaces.practica1_javierbernardo.entidades.Validacion;
import javierbs.interfaces.practica1_javierbernardo.entidades.Vuelo;
import modelos.TablaVuelos;

/**
 *
 * @author javierbs
 */
public class FrmVuelos extends javax.swing.JFrame {

    TablaVuelos modelo = new TablaVuelos();

    /**
     * Creates new form FrmVuelos
     */
    public FrmVuelos() {
        initComponents();
        visualizarVuelos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAltaVuelos = new javax.swing.JButton();
        btnBajaVuelos = new javax.swing.JButton();
        btnModificarVuelos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVuelos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAltaVuelos.setText("Dar de alta");
        btnAltaVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaVuelosActionPerformed(evt);
            }
        });

        btnBajaVuelos.setText("Dar de baja");
        btnBajaVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaVuelosActionPerformed(evt);
            }
        });

        btnModificarVuelos.setText("Editar");
        btnModificarVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarVuelosActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tblVuelos.setModel(modelo);
        jScrollPane1.setViewportView(tblVuelos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnAltaVuelos)
                        .addGap(103, 103, 103)
                        .addComponent(btnBajaVuelos)
                        .addGap(119, 119, 119)
                        .addComponent(btnModificarVuelos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(94, 94, 94)
                .addComponent(btnVolver)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnModificarVuelos)
                    .addComponent(btnBajaVuelos)
                    .addComponent(btnAltaVuelos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAltaVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaVuelosActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueloAlta(FrmVuelos.this).setVisible(true);
            }
        });
    }//GEN-LAST:event_btnAltaVuelosActionPerformed

    private void btnBajaVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaVuelosActionPerformed
        int indiceTabla = tblVuelos.getSelectedRow();
        if (indiceTabla == -1) {
            lblError.setText("Debe seleccionar un vuelo");
        } else {
            String codigo = tblVuelos.getValueAt(indiceTabla, 0).toString();
            String aOrigenId = tblVuelos.getValueAt(indiceTabla, 1).toString();
            Aeropuerto aOrigen = Aeropuerto.leerPorCodigo(aOrigenId);
            String aDestinoId = tblVuelos.getValueAt(indiceTabla, 2).toString();
            Aeropuerto aDestino = Aeropuerto.leerPorCodigo(aDestinoId);
            String nPlazasSt = tblVuelos.getValueAt(indiceTabla, 3).toString();
            int nPlazas = Integer.parseInt(nPlazasSt);
            String hSalidaSt = tblVuelos.getValueAt(indiceTabla, 4).toString();
            LocalTime hSalida = Validacion.parsearHora(hSalidaSt);
            String hLlegadaSt = tblVuelos.getValueAt(indiceTabla, 5).toString();
            LocalTime hLlegada = Validacion.parsearHora(hLlegadaSt);
            String diasOpera = tblVuelos.getValueAt(indiceTabla, 6).toString();
            Vuelo vuelo = new Vuelo(codigo, aOrigen, aDestino, nPlazas, hSalida, hLlegada, diasOpera);
            vuelo.eliminarVuelo();
            visualizarVuelos();
        }
    }//GEN-LAST:event_btnBajaVuelosActionPerformed

    private void btnModificarVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarVuelosActionPerformed

        int indiceTabla = tblVuelos.getSelectedRow();
        if (indiceTabla == -1) {
            lblError.setText("Debe seleccionar un vuelo");
        } else {
            String codigo = tblVuelos.getValueAt(indiceTabla, 0).toString();
            String aOrigenNombre = tblVuelos.getValueAt(indiceTabla, 1).toString();
            Aeropuerto aOrigen = Aeropuerto.leerPorNombre(aOrigenNombre);
            String aDestinoNombre = tblVuelos.getValueAt(indiceTabla, 2).toString();
            Aeropuerto aDestino = Aeropuerto.leerPorNombre(aDestinoNombre);
            String nPlazasSt = tblVuelos.getValueAt(indiceTabla, 3).toString();
            int nPlazas = Integer.parseInt(nPlazasSt);
            String hSalidaSt = tblVuelos.getValueAt(indiceTabla, 4).toString();
            LocalTime hSalida = Validacion.parsearHora(hSalidaSt);
            String hLlegadaSt = tblVuelos.getValueAt(indiceTabla, 5).toString();
            LocalTime hLlegada = Validacion.parsearHora(hLlegadaSt);
            String diasOpera = tblVuelos.getValueAt(indiceTabla, 6).toString();
            Vuelo vuelo = new Vuelo(codigo, aOrigen, aDestino, nPlazas, hSalida, hLlegada, diasOpera);

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new VueloEditar(FrmVuelos.this, vuelo).setVisible(true);
                }
            });
        }

    }//GEN-LAST:event_btnModificarVuelosActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVuelos().setVisible(true);
            }
        });
    }

    public void visualizarVuelos() {
        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
        vuelos = Vuelo.leerVuelos();
        modelo.setRowCount(vuelos.size());
        int fila = 0;
        for (Vuelo vuelo : vuelos) {
            tblVuelos.getModel().setValueAt(vuelo.getCodigo(), fila, 0);
            tblVuelos.getModel().setValueAt(vuelo.getAOrigen().getNombre(), fila, 1);
            tblVuelos.getModel().setValueAt(vuelo.getADestino().getNombre(), fila, 2);
            tblVuelos.getModel().setValueAt(vuelo.getNPlazas(), fila, 3);
            tblVuelos.getModel().setValueAt(vuelo.getHSalida(), fila, 4);
            tblVuelos.getModel().setValueAt(vuelo.getHLlegada(), fila, 5);
            tblVuelos.getModel().setValueAt(vuelo.getDiasOpera(), fila, 6);
            fila++;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaVuelos;
    private javax.swing.JButton btnBajaVuelos;
    private javax.swing.JButton btnModificarVuelos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JTable tblVuelos;
    // End of variables declaration//GEN-END:variables
}
