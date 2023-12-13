/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formularios;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javierbs.interfaces.practica1_javierbernardo.entidades.Aeropuerto;
import javierbs.interfaces.practica1_javierbernardo.entidades.Validacion;
import javierbs.interfaces.practica1_javierbernardo.entidades.Vuelo;

/**
 *
 * @author Usuario
 */
public class VueloEditar extends javax.swing.JFrame {

    FrmVuelos frmVuelos;
    Vuelo vuelo;
    String codigo;
    
    public VueloEditar(FrmVuelos frmVuelos, Vuelo vuelo) {
        initComponents();
        this.frmVuelos = frmVuelos;
        this.vuelo = vuelo;
        this.codigo = vuelo.getCodigo();
        rellenarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtAOrigen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtADestino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNPlazas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHSalida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHLlegada = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDiasOpera = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Código");

        jLabel2.setText("Aer. Origen");

        jLabel3.setText("Aer. Destino");

        jLabel4.setText("N. Plazas");

        jLabel5.setText("H. Salida");

        jLabel6.setText("H. Llegada");

        jLabel7.setText("Días que opera");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtADestino, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addComponent(btnVolver))
                        .addGap(23, 23, 23))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDiasOpera, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(146, 146, 146)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtADestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar))
                .addGap(58, 58, 58)
                .addComponent(btnVolver)
                .addGap(31, 31, 31)
                .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtAOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel3)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtNPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtHSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtHLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtDiasOpera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        boolean compForm = true;
        lblError.setText("");
        if (txtCodigo.getText().isBlank() || txtAOrigen.getText().isBlank()
            || txtADestino.getText().isBlank() || txtNPlazas.getText().isBlank()
            || txtHSalida.getText().isBlank() || txtHLlegada.getText().isBlank()
            || txtDiasOpera.getText().isBlank()) {
            compForm = false;
            lblError.setText("Tiene que rellenar todos los campos");
        } else {
            if (!Vuelo.validarCodigo(txtCodigo.getText().toString())) {
                compForm = false;
                lblError.setText("El código de vuelo es inválido");
            }
            if (!Validacion.esNumero(txtNPlazas.getText().toString())) {
                compForm = false;
                lblError.setText("El campo N. Plazas tiene que ser un número");
            }
            if (!Validacion.sonDiasOperables(txtDiasOpera.getText().toString())) {
                compForm = false;
                lblError.setText("El campo Dias que opera es inválido");
            }
            if (!Aeropuerto.validarCodigo(txtAOrigen.getText().toString())) {
                compForm = false;
                lblError.setText("El codigo del aeropuerto de origen no existe");
            }
            if (!Aeropuerto.validarCodigo(txtADestino.getText().toString())) {
                compForm = false;
                lblError.setText("El codigo del aeropuerto de destino no existe");
            }
            if (!Validacion.validarHora(txtHSalida.getText().toString())
                || !Validacion.validarHora(txtHLlegada.getText().toString())) {
                compForm = false;
                lblError.setText("La hora es inválida");
            }
        }

        if (compForm) {
            Aeropuerto aOrigen = Aeropuerto.leerPorCodigo(txtAOrigen.getText().toString());
            Aeropuerto aDestino = Aeropuerto.leerPorCodigo(txtADestino.getText().toString());
            Integer nPlazas = Integer.parseInt(txtNPlazas.getText().toString());
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime hSalida = LocalTime.parse(txtHSalida.getText().toString(), formato);
            LocalTime hLlegada = LocalTime.parse(txtHLlegada.getText().toString(), formato);
            Vuelo vuelo = new Vuelo(txtCodigo.getText().toString(), aOrigen, aDestino, nPlazas, hSalida, hLlegada, txtDiasOpera.getText().toString());
            vuelo.editarVuelo(this.codigo);
            frmVuelos.visualizarVuelos();
            dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void rellenarCampos(){
        txtCodigo.setText(vuelo.getCodigo());
        txtAOrigen.setText(vuelo.getAOrigen().getCodigo());
        txtADestino.setText(vuelo.getADestino().getCodigo());
        Integer nPlazasInt = vuelo.getNPlazas();
        String nPlazas = nPlazasInt.toString();
        txtNPlazas.setText(nPlazas);
        txtHSalida.setText(vuelo.getHSalida().toString());
        txtHLlegada.setText(vuelo.getHLlegada().toString());
        txtDiasOpera.setText(vuelo.getDiasOpera());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtADestino;
    private javax.swing.JTextField txtAOrigen;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDiasOpera;
    private javax.swing.JTextField txtHLlegada;
    private javax.swing.JTextField txtHSalida;
    private javax.swing.JTextField txtNPlazas;
    // End of variables declaration//GEN-END:variables
}
