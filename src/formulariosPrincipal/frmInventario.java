package formulariosPrincipal;

import Atxy2k.CustomTextField.RestrictedTextField;
import conexion.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

/**
 *
 * @author Vizcarra
 */
public class frmInventario extends javax.swing.JFrame {

    ResultSet rstId = null;
    DefaultTableModel model;
    Connection conn;
    Statement sent;
    String obtenerId = "";
    int obtenerIdEntero, estadoin = 0, nomInvr = 0, cantidadInv, compraventa;

    public frmInventario() {
        setTitle("Inventario");
        setResizable(false);
        //setLocationRelativeTo(null);
        initComponents();
        rbtnTodo.setSelected(true);
        ocultar();
        caracteristicas();
        OpcionesTabla();
    }

    public void OpcionesTabla() {
        int fila = tblInventario.getRowCount();
        if (fila == 0) {
            btnModificarInv.setEnabled(false);
            btnEliminarInv.setEnabled(false);
            btnVenderInv.setEnabled(false);
            btnAumentarInv.setEnabled(false);
        } else if (fila > 0) {
            btnModificarInv.setEnabled(true);
            btnEliminarInv.setEnabled(true);
            btnVenderInv.setEnabled(true);
            btnAumentarInv.setEnabled(true);
        }
    }

    public void caracteristicas() {
        String[] titulosar = {"Id", "Nombre", "Descripcion", "Cantidad", "Marca", "Categoria", "stockMaximo", "stockMinimo"};
        String sql = "SELECT * FROM productos";
        model = new DefaultTableModel(null, titulosar);
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] fila = new String[8];
            while (rs.next()) {
                fila[0] = rs.getString("Id");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("Descripcion");
                fila[3] = rs.getString("Cantidad");
                fila[4] = rs.getString("Marca");
                fila[5] = rs.getString("Categoria");
                fila[6] = rs.getString("stockMaximo");
                fila[7] = rs.getString("stockMinimo");
                model.addRow(fila);
            }
            tblInventario.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarcmb() {
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        String cmbcategoria = "SELECT Nombre FROM categoria ORDER BY Nombre ASC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cmbcategoria);
            while (rs.next()) {
                cmbCatInv.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        String cmbmarca = "SELECT Nombre FROM marca ORDER BY Nombre ASC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cmbmarca);
            while (rs.next()) {
                cmbMarcInv.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void ocultar() {
        jblModInv.setVisible(false);
        jblAgregarInv.setVisible(false);
        lblCodInv.setVisible(false);
        lblNomInv.setVisible(false);
        lblDescInv.setVisible(false);
        lblMarcInv.setVisible(false);
        lblCatInv.setVisible(false);
        lblCantInv.setVisible(false);
        lblMinInv.setVisible(false);
        lblMaxInv.setVisible(false);
        txtCodInv.setVisible(false);
        txtNomInv.setVisible(false);
        txtDescInv.setVisible(false);
        cmbMarcInv.setVisible(false);
        cmbCatInv.setVisible(false);
        txtCantInv.setVisible(false);
        txtMinInv.setVisible(false);
        txtMaxInv.setVisible(false);
        btnGuardarInv.setVisible(false);
        btnCancelarInv.setVisible(false);
        lblAgregarCI.setVisible(false);
        txtAgregarCI.setVisible(false);
        btnAgregarCI.setVisible(false);
        btnCancelarCI.setVisible(false);
    }

    public void mostrar() {
        lblCodInv.setVisible(true);
        lblNomInv.setVisible(true);
        lblDescInv.setVisible(true);
        lblMarcInv.setVisible(true);
        lblCatInv.setVisible(true);
        lblCantInv.setVisible(true);
        lblMinInv.setVisible(true);
        lblMaxInv.setVisible(true);
        txtCodInv.setVisible(true);
        txtNomInv.setVisible(true);
        txtDescInv.setVisible(true);
        cmbMarcInv.setVisible(true);
        cmbCatInv.setVisible(true);
        txtCantInv.setVisible(true);
        txtMinInv.setVisible(true);
        txtMaxInv.setVisible(true);
        btnGuardarInv.setVisible(true);
        btnCancelarInv.setVisible(true);
        //jpnCaracteristicas.setVisible(true);
    }

    public void vendercomprar() {
        lblAgregarCI.setVisible(false);
        txtAgregarCI.setVisible(false);
        txtAgregarCI.setText("");
        btnAgregarCI.setVisible(false);
        btnCancelarCI.setVisible(false);
        btnNuevoInv.setEnabled(true);
        btnModificarInv.setEnabled(true);
        btnEliminarInv.setEnabled(true);
        btnVenderInv.setEnabled(true);
        btnAumentarInv.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupFiltro = new javax.swing.ButtonGroup();
        jpnSubMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jpnBarraSuperior = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNombreInventario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        txtEscribirNombreInventario = new javax.swing.JTextField();
        btnNuevoInv = new javax.swing.JButton();
        btnModificarInv = new javax.swing.JButton();
        btnEliminarInv = new javax.swing.JButton();
        btnVenderInv = new javax.swing.JToggleButton();
        jblAgregarInv = new javax.swing.JLabel();
        jblModInv = new javax.swing.JLabel();
        lblCodInv = new javax.swing.JLabel();
        txtCodInv = new javax.swing.JTextField();
        lblNomInv = new javax.swing.JLabel();
        txtNomInv = new javax.swing.JTextField();
        lblDescInv = new javax.swing.JLabel();
        txtDescInv = new javax.swing.JTextField();
        lblMarcInv = new javax.swing.JLabel();
        cmbMarcInv = new javax.swing.JComboBox<>();
        cmbCatInv = new javax.swing.JComboBox<>();
        lblCatInv = new javax.swing.JLabel();
        lblCantInv = new javax.swing.JLabel();
        txtCantInv = new javax.swing.JTextField();
        txtMinInv = new javax.swing.JTextField();
        lblMinInv = new javax.swing.JLabel();
        lblMaxInv = new javax.swing.JLabel();
        txtMaxInv = new javax.swing.JTextField();
        btnCancelarInv = new javax.swing.JButton();
        btnGuardarInv = new javax.swing.JButton();
        lblAgregarCI = new javax.swing.JLabel();
        btnAgregarCI = new javax.swing.JToggleButton();
        txtAgregarCI = new javax.swing.JTextField();
        btnCancelarCI = new javax.swing.JToggleButton();
        btnAumentarInv = new javax.swing.JToggleButton();
        rbtnTodo = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario");
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        jpnSubMenu.setBackground(new java.awt.Color(102, 0, 0));
        jpnSubMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnSubMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/inventario.png"))); // NOI18N
        jpnSubMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/Home48.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jpnSubMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, -1, -1));

        jpnBarraSuperior.setBackground(new java.awt.Color(0, 0, 0));
        jpnBarraSuperior.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpnBarraSuperior.setMinimumSize(new java.awt.Dimension(1200, 50));
        jpnBarraSuperior.setPreferredSize(new java.awt.Dimension(1200, 50));
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
        lblLogo.setText("Inventario");
        lblLogo.setToolTipText("");
        jpnBarraSuperior.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Error.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 50, 50));

        lblNombreInventario.setText("Nombre de producto");

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblInventario);

        txtEscribirNombreInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEscribirNombreInventarioKeyReleased(evt);
            }
        });

        btnNuevoInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/nuevo2.png"))); // NOI18N
        btnNuevoInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoInvActionPerformed(evt);
            }
        });

        btnModificarInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/modificar.png"))); // NOI18N
        btnModificarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarInvActionPerformed(evt);
            }
        });

        btnEliminarInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/eliminar.png"))); // NOI18N
        btnEliminarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInvActionPerformed(evt);
            }
        });

        btnVenderInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/vender.png"))); // NOI18N
        btnVenderInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderInvActionPerformed(evt);
            }
        });

        jblAgregarInv.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jblAgregarInv.setText("Agregar Producto");
        jblAgregarInv.setFocusable(false);
        jblAgregarInv.setRequestFocusEnabled(false);
        jblAgregarInv.setVerifyInputWhenFocusTarget(false);

        jblModInv.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jblModInv.setText("Modificar Producto");

        lblCodInv.setText("Código:");

        txtCodInv.setEditable(false);

        lblNomInv.setText("Nombre:");

        txtNomInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomInvActionPerformed(evt);
            }
        });

        lblDescInv.setText("Descripción:");

        lblMarcInv.setText("Marca:");

        cmbCatInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCatInvActionPerformed(evt);
            }
        });

        lblCatInv.setText("Categoría:");

        lblCantInv.setText("Cantidad:");

        txtCantInv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantInvKeyTyped(evt);
            }
        });

        txtMinInv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinInvKeyTyped(evt);
            }
        });

        lblMinInv.setText("Margen Mínimo:");

        lblMaxInv.setText("Margen Máximo:");

        txtMaxInv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxInvKeyTyped(evt);
            }
        });

        btnCancelarInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/cancelar.png"))); // NOI18N
        btnCancelarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarInvActionPerformed(evt);
            }
        });

        btnGuardarInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/guardarprov.png"))); // NOI18N
        btnGuardarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarInvActionPerformed(evt);
            }
        });

        lblAgregarCI.setText("Cantidad         ");

        btnAgregarCI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ok.png"))); // NOI18N
        btnAgregarCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCIActionPerformed(evt);
            }
        });
        btnAgregarCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnAgregarCIKeyTyped(evt);
            }
        });

        txtAgregarCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarCIActionPerformed(evt);
            }
        });
        txtAgregarCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgregarCIKeyTyped(evt);
            }
        });

        btnCancelarCI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Error.png"))); // NOI18N
        btnCancelarCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCIActionPerformed(evt);
            }
        });

        btnAumentarInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/compras.png"))); // NOI18N
        btnAumentarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarInvActionPerformed(evt);
            }
        });

        btnGroupFiltro.add(rbtnTodo);
        rbtnTodo.setText("Todo");
        rbtnTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTodoActionPerformed(evt);
            }
        });

        btnGroupFiltro.add(jRadioButton2);
        jRadioButton2.setText("Sin Existencias");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        btnGroupFiltro.add(jRadioButton3);
        jRadioButton3.setText("Con Existencia");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpnSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombreInventario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEscribirNombreInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(rbtnTodo)
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButton2)
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButton3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblNomInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblDescInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblCodInv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNomInv, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                            .addComponent(txtCodInv, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                            .addComponent(txtDescInv)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblMaxInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblCatInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblCantInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblMinInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblMarcInv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtMinInv, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCantInv, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbCatInv, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbMarcInv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMaxInv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(btnGuardarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jblAgregarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jblModInv, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAgregarCI, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelarCI, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtAgregarCI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(lblAgregarCI)
                                .addGap(185, 185, 185))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevoInv, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVenderInv, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAumentarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jpnBarraSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnBarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jblAgregarInv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jblModInv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(lblAgregarCI, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodInv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addComponent(txtAgregarCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNomInv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregarCI, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelarCI, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDescInv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbMarcInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMarcInv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCatInv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCatInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCantInv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMinInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMinInv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(txtMaxInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMaxInv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtEscribirNombreInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbtnTodo)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevoInv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVenderInv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAumentarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jpnSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpnBarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMouseDragged

    }//GEN-LAST:event_jpnBarraSuperiorMouseDragged

    private void jpnBarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMousePressed

    }//GEN-LAST:event_jpnBarraSuperiorMousePressed

    private void btnNuevoInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoInvActionPerformed
        llenarcmb();
        String nullmarca = "" + (String) cmbMarcInv.getSelectedItem();
        String nullcat = "" + (String) cmbCatInv.getSelectedItem();
        if (nullmarca.equals("null") || nullcat.equals("null")) {
            JOptionPane.showMessageDialog(rootPane, "Debe agregar Marcas y Categorias antes");
        } else {
            txtNomInv.setText("");
            txtDescInv.setText("");
            txtCantInv.setText("");
            txtMinInv.setText("");
            txtMaxInv.setText("");
            cmbMarcInv.removeAllItems();
            cmbCatInv.removeAllItems();
            btnVenderInv.setEnabled(false);
            btnAumentarInv.setEnabled(false);
            llenarcmb();
            estadoin = 1;
            jblAgregarInv.setVisible(true);
            mostrar();
            String idp = "SELECT MAX(Id) FROM productos";
            obtenerIdEntero = 0;
            Conexion cc = new Conexion();
            Connection cn = cc.getConnection();
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(idp);
                while (rs.next()) {
                    obtenerId = rs.getString(1);
                    String solution = "" + rs.getString(1);
                    if (solution.equals("null")) {
                        obtenerId = "0";
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
            }
            obtenerIdEntero = Integer.parseInt(obtenerId) + 1;
            txtCodInv.setText("" + obtenerIdEntero);
            btnNuevoInv.setEnabled(false);
            btnModificarInv.setEnabled(false);
            btnEliminarInv.setEnabled(false);
            btnVenderInv.setEnabled(false);
            btnAumentarInv.setEnabled(false);
        }
    }//GEN-LAST:event_btnNuevoInvActionPerformed

    private void btnModificarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarInvActionPerformed
        if (tblInventario.getSelectedRow() != -1) {
            estadoin = 2;
            btnNuevoInv.setEnabled(false);
            btnModificarInv.setEnabled(false);
            btnEliminarInv.setEnabled(false);
            btnVenderInv.setEnabled(false);
            btnAumentarInv.setEnabled(false);
            llenarcmb();
            jblModInv.setVisible(true);
            mostrar();
            int seleccion;
            seleccion = tblInventario.getSelectedRow();
            txtCodInv.setText(tblInventario.getValueAt(seleccion, 0).toString());
            txtNomInv.setText((tblInventario.getValueAt(seleccion, 1).toString()));
            txtDescInv.setText(tblInventario.getValueAt(seleccion, 2).toString());
            txtCantInv.setText((tblInventario.getValueAt(seleccion, 3).toString()));
            txtMaxInv.setText(tblInventario.getValueAt(seleccion, 6).toString());
            txtMinInv.setText(tblInventario.getValueAt(seleccion, 7).toString());
            txtNomInv.requestFocus();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una categoria");
        }
    }//GEN-LAST:event_btnModificarInvActionPerformed

    private void btnEliminarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInvActionPerformed
        if (tblInventario.getSelectedRow() != -1) {
            int fila = tblInventario.getSelectedRow();
            if (fila >= 0) {
                int cant = Integer.parseInt(tblInventario.getValueAt(fila, 3).toString());
                if (cant == 0) {
                    String valor = tblInventario.getValueAt(fila, 0).toString();
                    Conexion cc = new Conexion();
                    Connection cn = cc.getConnection();
                    try {
                        int a = JOptionPane.showConfirmDialog(this, "¿Esta Seguro?");
                        if (a == JOptionPane.YES_OPTION) {
                            PreparedStatement pps = cn.prepareStatement("DELETE FROM productos WHERE Id='" + valor + "'");
                            pps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "El Equipo Se Ha Eliminado!", "CONFIRMACION", JOptionPane.PLAIN_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(frmMarca.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    caracteristicas();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Para poder eliminar, la cantidad tiene que ser: 0");
                }
            }
            OpcionesTabla();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un producto");
        }


    }//GEN-LAST:event_btnEliminarInvActionPerformed

    private void btnVenderInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderInvActionPerformed

        txtAgregarCI.requestFocus();

        int fila = tblInventario.getSelectedRow();
        if (fila >= 0) {
            compraventa = 1;
            txtAgregarCI.requestFocus();
            btnNuevoInv.setEnabled(false);
            btnModificarInv.setEnabled(false);
            btnEliminarInv.setEnabled(false);
            btnVenderInv.setEnabled(false);
            btnAumentarInv.setEnabled(false);
            lblAgregarCI.setVisible(true);
            txtAgregarCI.setVisible(true);
            btnAgregarCI.setVisible(true);
            btnCancelarCI.setVisible(true);
        }
    }//GEN-LAST:event_btnVenderInvActionPerformed

    private void txtNomInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomInvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomInvActionPerformed

    private void cmbCatInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCatInvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCatInvActionPerformed

    private void txtCantInvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantInvKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        if (txtCantInv.getText().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantInvKeyTyped

    private void txtMinInvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinInvKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        if (txtMinInv.getText().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMinInvKeyTyped

    private void txtMaxInvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxInvKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        if (txtMaxInv.getText().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMaxInvKeyTyped

    private void btnCancelarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarInvActionPerformed
        ocultar();
        btnNuevoInv.setEnabled(true);
        //btnModificarInv.setEnabled(true);
        //btnEliminarInv.setEnabled(true);
        //btnVenderInv.setEnabled(true);
        //btnAumentarInv.setEnabled(true);        
        cmbMarcInv.removeAllItems();
        cmbCatInv.removeAllItems();
        OpcionesTabla();
    }//GEN-LAST:event_btnCancelarInvActionPerformed

    private void btnGuardarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarInvActionPerformed
        //primero verificamos si estan los campos llenos, ya que es obligacion
        if (txtNomInv.getText().equals("") || txtDescInv.getText().equals("")
                || txtCantInv.getText().equals("") || txtMinInv.getText().equals("")
                || txtMaxInv.getText().equals("")) {
            //si faltan los campos o algun campo no permite y arroja mensaje de error
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar los campos");
        } // si los campos estan rellenados correctamente pasa a la siguiente condicion
        // que es agregar o modificar segun sea el cazo
        else {
            //vaidar campos numericos
            if (Integer.parseInt(txtCantInv.getText()) > 0 && Integer.parseInt(txtMaxInv.getText()) > 0) {
                if (Integer.parseInt(txtMaxInv.getText()) > Integer.parseInt(txtCantInv.getText())) {
                    if (Integer.parseInt(txtMaxInv.getText()) > Integer.parseInt(txtMinInv.getText())) {
                        if (Integer.parseInt(txtCantInv.getText()) >= Integer.parseInt(txtMinInv.getText())) {
                            //campos validados correctamente, aca se hace lo de inserccion y modificacion
                            Conexion cc = new Conexion();
                            Connection cn = cc.getConnection();
                            //para agregar nuevo producto
                            if (estadoin == 1) {
                                for (int i = 0; i < tblInventario.getRowCount(); i++) {
                                    if (txtNomInv.getText().equals(tblInventario.getValueAt(i, 1).toString())) {
                                        nomInvr = 1;
                                    }
                                }
                                if (nomInvr == 1) {
                                    JOptionPane.showMessageDialog(rootPane, "Marca Existente /n Realice de nuevo el proceso");
                                } else {
                                    obtenerIdEntero = obtenerIdEntero + 1;
                                    String Id, Nombre, Descripcion, Cantidad, stockMaximo, stockMinimo, Marca, Categoria, sql = "";
                                    Id = txtCodInv.getText();
                                    Nombre = txtNomInv.getText();
                                    Descripcion = txtDescInv.getText();
                                    Cantidad = txtCantInv.getText();
                                    Marca = (String) cmbMarcInv.getSelectedItem();
                                    Categoria = (String) cmbCatInv.getSelectedItem();
                                    stockMaximo = txtMaxInv.getText();
                                    stockMinimo = txtMinInv.getText();
                                    sql = "INSERT INTO productos(Id,Nombre,Descripcion,Cantidad,stockMaximo,stockMinimo,Marca,Categoria) VALUES (?,?,?,?,?,?,?,?)";
                                    try {
                                        PreparedStatement psd = cn.prepareStatement(sql);
                                        psd.setString(1, Id);
                                        psd.setString(2, Nombre);
                                        psd.setString(3, Descripcion);
                                        psd.setString(4, Cantidad);
                                        psd.setString(5, stockMaximo);
                                        psd.setString(6, stockMinimo);
                                        psd.setString(7, Marca);
                                        psd.setString(8, Categoria);
                                        int n = psd.executeUpdate();
                                        if (n > 0) {
                                            JOptionPane.showMessageDialog(null, "Nuevo Equipo Registrado!", "CORRECTO", JOptionPane.PLAIN_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Su Equipo No Se Guardo ", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } catch (SQLException ErrorTienda) {
                                        JOptionPane.showMessageDialog(this, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    }
                                    txtCodInv.setText("" + obtenerIdEntero);
                                    txtNomInv.setText("");
                                    txtDescInv.setText("");
                                    txtCantInv.setText("");
                                    txtMinInv.setText("");
                                    txtMaxInv.setText("");
                                    caracteristicas();
                                }
                            } //para modificar
                            else if (estadoin == 2) {
                                int repetircampos = 0, repetirnombreinv = 0, sino = 0;
                                String idInventarioIgual = "0";
                                for (int i = 0; i < tblInventario.getRowCount(); i++) {
                                    if (txtNomInv.getText().equals(tblInventario.getValueAt(i, 1).toString())
                                            && txtDescInv.getText().equals(tblInventario.getValueAt(i, 2).toString())
                                            && txtCantInv.getText().equals(tblInventario.getValueAt(i, 3).toString())
                                            && cmbMarcInv.getSelectedItem().equals(tblInventario.getValueAt(i, 4).toString())
                                            && cmbCatInv.getSelectedItem().equals(tblInventario.getValueAt(i, 5).toString())
                                            && txtMaxInv.getText().equals(tblInventario.getValueAt(i, 6).toString())
                                            && txtMinInv.getText().equals(tblInventario.getValueAt(i, 7).toString())) {
                                        repetircampos = 1;
                                    }
                                    if (txtNomInv.getText().equals(tblInventario.getValueAt(i, 1).toString())) {
                                        repetirnombreinv = 1;
                                        idInventarioIgual = tblInventario.getValueAt(i, 0).toString();
                                    }
                                }
                                if (repetircampos == 1) {
                                    JOptionPane.showMessageDialog(rootPane, "campos repetidos");
                                } else if (repetircampos == 0) {
                                    if (repetirnombreinv == 1 && idInventarioIgual.equals(txtCodInv.getText())) {
                                        sino = 1;
                                    }

                                    if (repetirnombreinv == 0 || sino == 1) {
                                        //comple vadilacion
                                        JOptionPane.showMessageDialog(rootPane, "CORRECTO");
                                        int idinventario = idinventario = Integer.parseInt(txtCodInv.getText());
                                        String Id, Nombre, Descripcion, Cantidad, stockMaximo, stockMinimo, Marca, Categoria, sql = "";
                                        Id = txtCodInv.getText();
                                        Nombre = txtNomInv.getText();
                                        Descripcion = txtDescInv.getText();
                                        Cantidad = txtCantInv.getText();
                                        Marca = (String) cmbMarcInv.getSelectedItem();
                                        Categoria = (String) cmbCatInv.getSelectedItem();
                                        stockMaximo = txtMaxInv.getText();
                                        stockMinimo = txtMinInv.getText();
                                        sql = "UPDATE productos SET Nombre=?, Descripcion=?, Cantidad=?, stockMaximo=?, stockMinimo=?, Marca=?, Categoria=? WHERE Id='" + idinventario + "'";
                                        try {
                                            PreparedStatement psd = cn.prepareStatement(sql);
                                            psd.setString(1, Nombre);
                                            psd.setString(2, Descripcion);
                                            psd.setString(3, Cantidad);
                                            psd.setString(4, stockMaximo);
                                            psd.setString(5, stockMinimo);
                                            psd.setString(6, Marca);
                                            psd.setString(7, Categoria);
                                            int n = psd.executeUpdate();
                                            if (n > 0) {
                                                JOptionPane.showMessageDialog(null, "Nuevo Equipo Registrado!", "CORRECTO", JOptionPane.PLAIN_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(this, "Su Equipo No Se Guardo ", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } catch (SQLException ErrorTienda) {
                                            JOptionPane.showMessageDialog(this, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        }
                                        ocultar();
                                        btnNuevoInv.setEnabled(true);
                                        btnModificarInv.setEnabled(true);
                                        btnEliminarInv.setEnabled(true);
                                        btnVenderInv.setEnabled(true);
                                        btnAumentarInv.setEnabled(true);
                                        cmbMarcInv.removeAllItems();
                                        cmbCatInv.removeAllItems();
                                        caracteristicas();

                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "campos no repetidos, marca si");
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, " Incorrecto Cantidad debe ser mayor a StockMinimo");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, " Incorrecto StockMaximo debe ser mayor a StockMinimo");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, " Incorrecto StockMaximo debe ser mayor a Cantidad");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "la Cantidad o StockMaximo deven ser mayor a 0");
            }
            //cierre validar campos numericos
        }
        cmbMarcInv.removeAllItems();
        cmbCatInv.removeAllItems();
        llenarcmb();
    }//GEN-LAST:event_btnGuardarInvActionPerformed

    private void txtAgregarCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarCIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregarCIActionPerformed

    private void btnAgregarCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCIActionPerformed
        int cantidadDis = Integer.parseInt(txtAgregarCI.getText().toString());
        int fila = tblInventario.getSelectedRow();
        int codinv = Integer.parseInt(tblInventario.getValueAt(fila, 0).toString());
        cantidadInv = Integer.parseInt(tblInventario.getValueAt(fila, 3).toString());
        int stocmo = Integer.parseInt(tblInventario.getValueAt(fila, 6).toString());
        int stocmi = Integer.parseInt(tblInventario.getValueAt(fila, 7).toString());
        String insertarni = "UPDATE productos SET Cantidad=? WHERE Id='" + codinv + "'";
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        if (compraventa == 1) {
            int valor = cantidadInv - cantidadDis;
            String cantidad = "" + valor;
            if (valor >= 0) {
                if (stocmi > valor) {
                    JOptionPane.showMessageDialog(rootPane, "Sobrepaso su stockMinimo");
                }
                try {
                    PreparedStatement psd = cn.prepareStatement(insertarni);
                    psd.setString(1, cantidad);
                    int n = psd.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Cantidad Modificada!", " CORRECTO", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Cantidad No Modificada!", " ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ErrorTienda) {
                    JOptionPane.showMessageDialog(this, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                vendercomprar();
                caracteristicas();
            } else {
                JOptionPane.showMessageDialog(rootPane, "No hay esa cantidad en existencia");
            }
        } else if (compraventa == 2) {
            int vcompraa = cantidadDis + cantidadInv;
            String cantidad = "" + vcompraa;
            if (vcompraa > stocmo) {
                JOptionPane.showMessageDialog(rootPane, "Sobrepaso su stockMaximo");
            }
            try {
                PreparedStatement psd = cn.prepareStatement(insertarni);
                psd.setString(1, cantidad);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Cantidad Modificada!", " CORRECTO", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Cantidad No Modificada!", " ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ErrorTienda) {
                JOptionPane.showMessageDialog(this, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            vendercomprar();
            caracteristicas();
        }

    }//GEN-LAST:event_btnAgregarCIActionPerformed

    private void btnCancelarCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCIActionPerformed
        vendercomprar();
    }//GEN-LAST:event_btnCancelarCIActionPerformed

    private void btnAgregarCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarCIKeyTyped

    }//GEN-LAST:event_btnAgregarCIKeyTyped

    private void txtAgregarCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgregarCIKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        if (txtAgregarCI.getText().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAgregarCIKeyTyped

    private void btnAumentarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarInvActionPerformed

        int fila = tblInventario.getSelectedRow();
        if (fila >= 0) {
            compraventa = 2;
            txtAgregarCI.requestFocus();
            btnNuevoInv.setEnabled(false);
            btnModificarInv.setEnabled(false);
            btnEliminarInv.setEnabled(false);
            btnVenderInv.setEnabled(false);
            btnAumentarInv.setEnabled(false);
            lblAgregarCI.setVisible(true);
            txtAgregarCI.setVisible(true);
            btnAgregarCI.setVisible(true);
            btnCancelarCI.setVisible(true);
            cantidadInv = Integer.parseInt(tblInventario.getValueAt(fila, 3).toString());
        }

    }//GEN-LAST:event_btnAumentarInvActionPerformed

    private void rbtnTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTodoActionPerformed
        caracteristicas();
    }//GEN-LAST:event_rbtnTodoActionPerformed

    private void txtEscribirNombreInventarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEscribirNombreInventarioKeyReleased
        String[] titulosar = {"Id", "Nombre", "Descripcion", "Cantidad", "Marca", "Categoria", "stockMaximo", "stockMinimo"};
        String sql = "SELECT * FROM productos WHERE (Nombre LIKE '%" + txtEscribirNombreInventario.getText() + "%')";

        model = new DefaultTableModel(null, titulosar);
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] fila = new String[8];
            while (rs.next()) {
                fila[0] = rs.getString("Id");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("Descripcion");
                fila[3] = rs.getString("Cantidad");
                fila[4] = rs.getString("Marca");
                fila[5] = rs.getString("Categoria");
                fila[6] = rs.getString("stockMaximo");
                fila[7] = rs.getString("stockMinimo");
                model.addRow(fila);

            }
            tblInventario.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtEscribirNombreInventarioKeyReleased

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        String[] titulosar = {"Id", "Nombre", "Descripcion", "Cantidad", "Marca", "Categoria", "stockMaximo", "stockMinimo"};
        String sql = "SELECT * FROM productos WHERE Cantidad >0";
        model = new DefaultTableModel(null, titulosar);
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] fila = new String[8];
            while (rs.next()) {
                fila[0] = rs.getString("Id");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("Descripcion");
                fila[3] = rs.getString("Cantidad");
                fila[4] = rs.getString("Marca");
                fila[5] = rs.getString("Categoria");
                fila[6] = rs.getString("stockMaximo");
                fila[7] = rs.getString("stockMinimo");
                model.addRow(fila);
            }
            tblInventario.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        String[] titulosar = {"Id", "Nombre", "Descripcion", "Cantidad", "Marca", "Categoria", "stockMaximo", "stockMinimo"};
        String sql = "SELECT * FROM productos WHERE Cantidad=0";
        model = new DefaultTableModel(null, titulosar);
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] fila = new String[8];
            while (rs.next()) {
                fila[0] = rs.getString("Id");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("Descripcion");
                fila[3] = rs.getString("Cantidad");
                fila[4] = rs.getString("Marca");
                fila[5] = rs.getString("Categoria");
                fila[6] = rs.getString("stockMaximo");
                fila[7] = rs.getString("stockMinimo");
                model.addRow(fila);
            }
            tblInventario.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        frmHome hom = new frmHome();
        hom.setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAgregarCI;
    private javax.swing.JToggleButton btnAumentarInv;
    private javax.swing.JToggleButton btnCancelarCI;
    private javax.swing.JButton btnCancelarInv;
    private javax.swing.JButton btnEliminarInv;
    private javax.swing.ButtonGroup btnGroupFiltro;
    private javax.swing.JButton btnGuardarInv;
    private javax.swing.JButton btnModificarInv;
    private javax.swing.JButton btnNuevoInv;
    private javax.swing.JToggleButton btnVenderInv;
    private javax.swing.JComboBox<String> cmbCatInv;
    private javax.swing.JComboBox<String> cmbMarcInv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jblAgregarInv;
    public javax.swing.JLabel jblModInv;
    private javax.swing.JPanel jpnBarraSuperior;
    private javax.swing.JPanel jpnSubMenu;
    private javax.swing.JLabel lblAgregarCI;
    private javax.swing.JLabel lblCantInv;
    private javax.swing.JLabel lblCatInv;
    private javax.swing.JLabel lblCodInv;
    private javax.swing.JLabel lblDescInv;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMarcInv;
    private javax.swing.JLabel lblMaxInv;
    private javax.swing.JLabel lblMinInv;
    private javax.swing.JLabel lblNomInv;
    private javax.swing.JLabel lblNombreInventario;
    private javax.swing.JRadioButton rbtnTodo;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtAgregarCI;
    private javax.swing.JTextField txtCantInv;
    private javax.swing.JTextField txtCodInv;
    private javax.swing.JTextField txtDescInv;
    private javax.swing.JTextField txtEscribirNombreInventario;
    private javax.swing.JTextField txtMaxInv;
    private javax.swing.JTextField txtMinInv;
    private javax.swing.JTextField txtNomInv;
    // End of variables declaration//GEN-END:variables
}
