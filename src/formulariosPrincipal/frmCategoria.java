/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariosPrincipal;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vizcarra
 */
public class frmCategoria extends javax.swing.JFrame {

    ResultSet rstId = null;
    DefaultTableModel model;
    Connection conn;
    Statement sent;
    String obtenerId = "";
    int obtner_id_categoria, cat_ag_mo = 0, estadomc = 0, marcaexistente = 0;

    /**
     * Creates new form frmMarca
     */
    public frmCategoria() {
        setTitle("Categoria");
        setResizable(false);
        initComponents();
        ocultarCamposCategoria();
        caracteristicasCategoria();
        OpcionesTabla();
    }

    public void OpcionesTabla() {
        int fila = tblCategoria.getRowCount();
        if (fila == 0) {
            btnModificarCategoria.setEnabled(false);
            btnEliminarCategoria.setEnabled(false);
        } else if (fila > 0) {
            btnModificarCategoria.setEnabled(true);
            btnEliminarCategoria.setEnabled(true);
        }
    }

    public void ocultarCamposCategoria() {
        lblRegistrarCategoria.setVisible(false);
        lblModificarCategoria.setVisible(false);
        lblCodigoCategoria.setVisible(false);
        lblNombreCategoria.setVisible(false);
        lblDescripcionCategoria.setVisible(false);
        txtCodigoCategoria.setVisible(false);
        txtNombreCategoria.setVisible(false);
        txtDescripcionCategoria.setVisible(false);
        btnGuardarCategoria.setVisible(false);
        btnCancelarCategoria.setVisible(false);
    }

    public void mostrarCamposCategoria() {
        lblCodigoCategoria.setVisible(true);
        lblNombreCategoria.setVisible(true);
        lblDescripcionCategoria.setVisible(true);
        txtCodigoCategoria.setVisible(true);
        txtNombreCategoria.setVisible(true);
        txtDescripcionCategoria.setVisible(true);
        btnGuardarCategoria.setVisible(true);
        btnCancelarCategoria.setVisible(true);
    }

    public void caracteristicasCategoria() {
        String[] titulomar = {"Id", "Nombre", "Descripcion"};
        String sql = "SELECT * FROM categoria";

        model = new DefaultTableModel(null, titulomar);
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] fila = new String[3];
            while (rs.next()) {
                fila[0] = rs.getString("Id");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("Descripcion");
                model.addRow(fila);
            }
            tblCategoria.setModel(model);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnSubMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpnBarraSuperior = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        btnRegistrarCategoria = new javax.swing.JButton();
        btnModificarCategoria = new javax.swing.JButton();
        btnEliminarCategoria = new javax.swing.JButton();
        lblRegistrarCategoria = new javax.swing.JLabel();
        lblModificarCategoria = new javax.swing.JLabel();
        lblCodigoCategoria = new javax.swing.JLabel();
        txtCodigoCategoria = new javax.swing.JTextField();
        txtNombreCategoria = new javax.swing.JTextField();
        lblNombreCategoria = new javax.swing.JLabel();
        lblDescripcionCategoria = new javax.swing.JLabel();
        txtDescripcionCategoria = new javax.swing.JTextField();
        btnGuardarCategoria = new javax.swing.JButton();
        btnCancelarCategoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Categoria");
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setUndecorated(true);
        setResizable(false);

        jpnSubMenu.setBackground(new java.awt.Color(102, 0, 0));
        jpnSubMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnSubMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Home.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jpnSubMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, -1, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/Categoria.png"))); // NOI18N
        jpnSubMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        jpnBarraSuperior.setBackground(new java.awt.Color(0, 0, 0));
        jpnBarraSuperior.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpnBarraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpnBarraSuperiorMouseDragged(evt);
            }
        });
        jpnBarraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnBarraSuperiorMousePressed(evt);
            }
        });
        jpnBarraSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setText("Categoria");
        lblLogo.setToolTipText("");
        jpnBarraSuperior.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Error.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 50, 50));

        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Descripción", "Marca", "Categoria", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCategoria);

        btnRegistrarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/nuevo2.png"))); // NOI18N
        btnRegistrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCategoriaActionPerformed(evt);
            }
        });

        btnModificarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/modificar.png"))); // NOI18N
        btnModificarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCategoriaActionPerformed(evt);
            }
        });

        btnEliminarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/eliminar.png"))); // NOI18N
        btnEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCategoriaActionPerformed(evt);
            }
        });

        lblRegistrarCategoria.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRegistrarCategoria.setText("Registrar Categoría");

        lblModificarCategoria.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblModificarCategoria.setText("Modificar Categoría");

        lblCodigoCategoria.setText("Código:");

        txtCodigoCategoria.setEnabled(false);

        lblNombreCategoria.setText("Nombre:");

        lblDescripcionCategoria.setText("Descripción");

        btnGuardarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/guardarprov.png"))); // NOI18N
        btnGuardarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCategoriaActionPerformed(evt);
            }
        });

        btnCancelarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/cancelar.png"))); // NOI18N
        btnCancelarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnBarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpnSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btnModificarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRegistrarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnCancelarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNombreCategoria)
                                                    .addComponent(lblCodigoCategoria))
                                                .addGap(55, 55, 55)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtNombreCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))))
                                    .addComponent(lblModificarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblDescripcionCategoria))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGuardarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnBarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnModificarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnRegistrarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRegistrarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblModificarCategoria)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCodigoCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombreCategoria)
                                    .addComponent(txtNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(118, 118, 118)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGuardarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(125, 125, 125))))
                    .addComponent(jpnSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpnBarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMouseDragged

    }//GEN-LAST:event_jpnBarraSuperiorMouseDragged

    private void jpnBarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMousePressed

    }//GEN-LAST:event_jpnBarraSuperiorMousePressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        frmHome hom = new frmHome();
        hom.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnRegistrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCategoriaActionPerformed
        btnRegistrarCategoria.setEnabled(false);
        btnModificarCategoria.setEnabled(false);
        btnEliminarCategoria.setEnabled(false);
        txtNombreCategoria.setText("");
        txtDescripcionCategoria.setText("");
        estadomc = 1;
        lblRegistrarCategoria.setVisible(true);
        mostrarCamposCategoria();
        //
        String idmarca = "SELECT MAX(Id) FROM categoria";
        obtner_id_categoria = 0;
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(idmarca);
            while (rs.next()) {
                obtenerId = rs.getString(1);
                String solution = "" + rs.getString(1);
                if (solution.equals("null")) {
                    obtenerId = "0";
                }
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        obtner_id_categoria = Integer.parseInt(obtenerId) + 1;
        txtCodigoCategoria.setText("" + obtner_id_categoria);
    }//GEN-LAST:event_btnRegistrarCategoriaActionPerformed

    private void btnModificarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCategoriaActionPerformed
        if (tblCategoria.getSelectedRow() != -1) {
            estadomc = 2;
            btnRegistrarCategoria.setEnabled(false);
            btnModificarCategoria.setEnabled(false);
            btnEliminarCategoria.setEnabled(false);
            lblModificarCategoria.setVisible(true);
            mostrarCamposCategoria();
            int seleccion;
            seleccion = tblCategoria.getSelectedRow();
            txtCodigoCategoria.setText(tblCategoria.getValueAt(seleccion, 0).toString());
            txtNombreCategoria.setText((tblCategoria.getValueAt(seleccion, 1).toString()));
            txtDescripcionCategoria.setText((tblCategoria.getValueAt(seleccion, 2).toString()));
            txtNombreCategoria.requestFocus();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una categoria");
        }
    }//GEN-LAST:event_btnModificarCategoriaActionPerformed

    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed
        if (tblCategoria.getSelectedRow() != -1) {
            int fila = tblCategoria.getSelectedRow();
            String valor = tblCategoria.getValueAt(fila, 0).toString();
            String catcausada = tblCategoria.getValueAt(fila, 1).toString();
            if (fila >= 0) {
                Conexion cc = new Conexion();
                Connection cn = cc.getConnection();
                String sabervaor = "SELECT COUNT(*) FROM productos WHERE Categoria='" + catcausada + "'";
                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sabervaor);
                    while (rs.next()) {
                        catcausada = rs.getString(1);
                    }
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(frmMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                if (catcausada.equals("0")) {
                    try {
                        int a = JOptionPane.showConfirmDialog(this, "¿Esta Seguro?");
                        if (a == JOptionPane.YES_OPTION) {
                            PreparedStatement pps = cn.prepareStatement("DELETE FROM categoria WHERE Id='" + valor + "'");
                            pps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "El Equipo Se Ha Eliminado! ", "CONFIRMACION", JOptionPane.PLAIN_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(frmMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    caracteristicasCategoria();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se puede eliminar por que hay existencias");
                }
            }
            OpcionesTabla();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una Categoria");
        }
    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed

    private void btnGuardarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCategoriaActionPerformed
        //primero verificamos si estan los campos llenos, ya que es obligacion
        if (txtNombreCategoria.getText().equals("") || txtDescripcionCategoria.getText().equals("")) {
            //si faltan los campos o algun campo no permite y arroja mensaje de error
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar los campos");
        } // si los campos estan rellenados correctamente pasa a la siguiente condicion
        // que es agregar o modificar segun sea el cazo
        else {
            Conexion cc = new Conexion();
            Connection cn = cc.getConnection();
            String Id, Nombre, Descripcion;
            //aca es la opcion para agregar una nueva categoria
            if (estadomc == 1) {
                // para saber si la marca ya existe
                for (int i = 0; i < tblCategoria.getRowCount(); i++) {
                    if (txtNombreCategoria.getText().equals(tblCategoria.getValueAt(i, 1).toString())) {
                        marcaexistente = 1;
                    }
                }   // si la marca ya existe no se deja ingresar y se notifica
                if (marcaexistente == 1) {
                    JOptionPane.showMessageDialog(rootPane, "Categoria Existente n/ Realice de nuevo el proceso");
                } //si la categoria no existe se procede
                else {
                    obtner_id_categoria = obtner_id_categoria + 1;
                    String sql = "";
                    Id = txtCodigoCategoria.getText();
                    Nombre = txtNombreCategoria.getText();
                    Descripcion = txtDescripcionCategoria.getText();
                    sql = "INSERT INTO categoria(Id,Nombre,Descripcion) VALUES (?,?,?)";
                    try {
                        PreparedStatement psd = cn.prepareStatement(sql);
                        psd.setString(1, Id);
                        psd.setString(2, Nombre);
                        psd.setString(3, Descripcion);
                        int n = psd.executeUpdate();
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Categoria Registrada! ", "CORRECTO", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Categoria No Registrada! ", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ErrorTienda) {
                        JOptionPane.showMessageDialog(this, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    txtCodigoCategoria.setText("" + obtner_id_categoria);
                    txtNombreCategoria.setText("");
                    txtDescripcionCategoria.setText("");
                    caracteristicasCategoria();
                    JOptionPane.showMessageDialog(rootPane, "Marca Agregada Correctamente");
                }//termina e else compprobacion de existencia en categoria
            }//termina agregar nueva marca
            //para modificar categoria
            else if (estadomc == 2) {
                int saberdm = 0;
                int sabenm = 0;
                String idMarcaIgual = "0";
                for (int i = 0; i < tblCategoria.getRowCount(); i++) {
                    if (txtNombreCategoria.getText().equals(tblCategoria.getValueAt(i, 1).toString())) {
                        sabenm = 1;
                        idMarcaIgual = tblCategoria.getValueAt(i, 0).toString();
                        if (txtDescripcionCategoria.getText().equals(tblCategoria.getValueAt(i, 2).toString())) {
                            saberdm = 1;
                        }
                        if (sabenm == 1 && saberdm == 1) {
                            JOptionPane.showMessageDialog(rootPane, "Los campos siguen igual, debe modificar almenos un campo");
                            idMarcaIgual = "0";
                            break;
                        } else {
                            sabenm = 0;
                            saberdm = 0;
                        }
                    }
                }
                if (!idMarcaIgual.equals(txtCodigoCategoria.getText()) && !idMarcaIgual.equals("0")) {
                    JOptionPane.showMessageDialog(rootPane, "No se modifico, esa marca ya existe");
                } else if (!(sabenm == 1 && saberdm == 1) || idMarcaIgual.equals(txtCodigoCategoria.getText())) {
                    int Idmm;
                    Id = txtCodigoCategoria.getText();
                    Idmm = Integer.parseInt(txtCodigoCategoria.getText());
                    Nombre = txtNombreCategoria.getText();
                    Descripcion = txtDescripcionCategoria.getText();
                    String insertarmm = "UPDATE categoria SET Nombre=?, Descripcion=? WHERE Id='" + Idmm + "'";
                    try {
                        PreparedStatement psd = cn.prepareStatement(insertarmm);
                        psd.setString(1, Nombre);
                        psd.setString(2, Descripcion);
                        int n = psd.executeUpdate();
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Categoria Modificada! ", "CORRECTO", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Categoria no Modificada! ", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ErrorTienda) {
                        JOptionPane.showMessageDialog(this, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    int seleccion = tblCategoria.getSelectedRow();
                    String nomtaca = (tblCategoria.getValueAt(seleccion, 1).toString());
                    if (txtNombreCategoria.getText().equals(tblCategoria.getValueAt(seleccion, 1).toString())) {
                    } else {
                        String pca = "UPDATE productos SET Categoria=? WHERE Categoria='" + nomtaca + "'";
                        try {
                            PreparedStatement psd = cn.prepareStatement(pca);
                            psd.setString(1, Nombre);
                            int n = psd.executeUpdate();
                        } catch (SQLException ErrorTienda) {
                            JOptionPane.showMessageDialog(this, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    ocultarCamposCategoria();
                    btnRegistrarCategoria.setEnabled(true);
                    btnModificarCategoria.setEnabled(true);
                    btnEliminarCategoria.setEnabled(true);
                    caracteristicasCategoria();
                }
            }
        }// cierre de else si estan rellenos los campos
    }//GEN-LAST:event_btnGuardarCategoriaActionPerformed

    private void btnCancelarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCategoriaActionPerformed
        ocultarCamposCategoria();
        btnRegistrarCategoria.setEnabled(true);
        OpcionesTabla();
    }//GEN-LAST:event_btnCancelarCategoriaActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCategoria;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnGuardarCategoria;
    private javax.swing.JButton btnModificarCategoria;
    private javax.swing.JButton btnRegistrarCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnBarraSuperior;
    private javax.swing.JPanel jpnSubMenu;
    private javax.swing.JLabel lblCodigoCategoria;
    private javax.swing.JLabel lblDescripcionCategoria;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblModificarCategoria;
    private javax.swing.JLabel lblNombreCategoria;
    private javax.swing.JLabel lblRegistrarCategoria;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTextField txtCodigoCategoria;
    private javax.swing.JTextField txtDescripcionCategoria;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables
}