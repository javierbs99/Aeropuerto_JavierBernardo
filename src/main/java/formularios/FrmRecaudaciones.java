/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formularios;

import java.time.LocalDate;
import java.util.ArrayList;
import javierbs.interfaces.practica1_javierbernardo.entidades.Validacion;
import javierbs.interfaces.practica1_javierbernardo.entidades.VueloDiario;
import modelos.TablaVuelosDiarios;

public class FrmRecaudaciones extends javax.swing.JFrame {

    TablaVuelosDiarios modelo = new TablaVuelosDiarios();

    public FrmRecaudaciones() {
        initComponents();
        inicializarFecha();
        visualizarRecaudaciones();
        visualizarTabla();
    }

    public void inicializarFecha() {
        LocalDate fechaLd = LocalDate.now();
        String fecha = Validacion.parsearFechaAString(fechaLd);
        txtFecha.setText(fecha);
    }

    private void visualizarRecaudaciones() {
        ArrayList<VueloDiario> vuelosDiarios = VueloDiario.leerVueloDiarioPorFecha(txtFecha.getText());
        lblRecaudacion.setText("" + VueloDiario.calcularRecaudaciones(vuelosDiarios));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVuelosDiarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblRecaudacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha:");

        jLabel2.setText("dd/mm/yyyy");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tblVuelosDiarios.setModel(modelo);
        jScrollPane1.setViewportView(tblVuelosDiarios);

        jLabel3.setText("Recaudación total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnVolver))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(33, 33, 33)
                            .addComponent(lblRecaudacion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblRecaudacion, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (validarFecha(txtFecha.getText())) {
            visualizarTabla();
            visualizarRecaudaciones();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private boolean validarFecha(String fecha) {
        lblError.setText("");
        if (fecha.isBlank()) {
            lblError.setText("Tiene que rellenar los campos");
            return false;
        } else {
            if (!Validacion.validarFecha(fecha)) {
                lblError.setText("La fecha no es válida");
                return false;
            }
        }
        return true;
    }

    private void visualizarTabla() {
        ArrayList<VueloDiario> vuelosDiarios = VueloDiario.leerVueloDiarioPorFecha(txtFecha.getText());
        modelo.setRowCount(vuelosDiarios.size());
        int fila = 0;
        for (VueloDiario vd : vuelosDiarios) {
            tblVuelosDiarios.getModel().setValueAt(vd.getVuelo(), fila, 0);
            String fecha = Validacion.parsearFechaAString(vd.getFecha());
            tblVuelosDiarios.getModel().setValueAt(fecha, fila, 1);
            tblVuelosDiarios.getModel().setValueAt(vd.gethSalida(), fila, 2);
            tblVuelosDiarios.getModel().setValueAt(vd.gethLlegada(), fila, 3);
            tblVuelosDiarios.getModel().setValueAt(vd.getnPlazasOcupadas(), fila, 4);
            tblVuelosDiarios.getModel().setValueAt(vd.getPrecioVuelo(), fila, 5);
            fila++;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblRecaudacion;
    private javax.swing.JTable tblVuelosDiarios;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
