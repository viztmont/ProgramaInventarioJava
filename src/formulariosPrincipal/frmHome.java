
package formulariosPrincipal;
import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;


public final class frmHome extends javax.swing.JFrame {    
    DefaultTableModel model;
      Connection conn;
      Statement sent;
        
    
    int x,y;
    String nombres, apellidos, rol, password;
    boolean apagado;
    boolean ventas, compras, productos, proveedores, sucursales, inventario, parametro, tipoPrecio, detalleCompra, detalleVenta;

    public frmHome()  {
        initComponents();        
        apagado2();
        Principal(true);
        Compras(false);
        Ventas(false);
        Productos(false);  
        jpnPass.setVisible(false);   
        //new javax.swing.ImageIcon(getClass().getResource("/iconos/home/tel.png")).getImage()
    }   

/*  ---- Visualización de imágenes en Menú ----  */
    public void Principal(boolean estado){
        jpnPrimero.setVisible(estado);
    }
    public void Compras(boolean estado){
        jpnSegundo.setVisible(estado);
    }
    public void Ventas(boolean estado){
        jpnTercero.setVisible(estado);
    }
    public void Productos(boolean estado){
        jpnCuarto.setVisible(estado);
    }
   
   
    public void apagado(){
        apagado = true;
        jpnPrincipal.setVisible(false);  
    }
    public void apagado2(){
        //pnlPortada.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnBarraSuperior = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpnBarraMenu = new javax.swing.JPanel();
        lblMenu = new javax.swing.JLabel();
        jpnSubMenu = new javax.swing.JPanel();
        btnInventario = new javax.swing.JButton();
        btnMarca = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnParametro = new javax.swing.JButton();
        btnHome = new javax.swing.JLabel();
        jpnPrincipal = new javax.swing.JPanel();
        jpnPrimero = new javax.swing.JPanel();
        jpnPass = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pwdAntigua = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        pwdNueva = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        pwdNueva2 = new javax.swing.JPasswordField();
        btnAtrasPwd = new javax.swing.JLabel();
        btnCambiarPwd = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        lblMitad = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        jpnSegundo = new javax.swing.JPanel();
        lblMitad2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl12 = new javax.swing.JLabel();
        lbl18 = new javax.swing.JLabel();
        lbl17 = new javax.swing.JLabel();
        lbl13 = new javax.swing.JLabel();
        lbl16 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        jpnTercero = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl28 = new javax.swing.JLabel();
        lbl29 = new javax.swing.JLabel();
        lbl30 = new javax.swing.JLabel();
        lbl36 = new javax.swing.JLabel();
        lblMitad3 = new javax.swing.JLabel();
        jpnCuarto = new javax.swing.JPanel();
        lblMitad4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl24 = new javax.swing.JLabel();
        lbl25 = new javax.swing.JLabel();
        lbl37 = new javax.swing.JLabel();
        lbl38 = new javax.swing.JLabel();
        lbl39 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        lblLogo.setText("AUSI135");
        lblLogo.setToolTipText("");
        jpnBarraSuperior.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Error.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 50, 50));

        getContentPane().add(jpnBarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 1200, 60));

        jpnBarraMenu.setBackground(new java.awt.Color(102, 0, 0));
        jpnBarraMenu.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jpnBarraMenuPropertyChange(evt);
            }
        });
        jpnBarraMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMenu.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Menu.png"))); // NOI18N
        lblMenu.setText("Menu");
        jpnBarraMenu.add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 20, 170, 50));

        jpnSubMenu.setBackground(new java.awt.Color(102, 0, 0));
        jpnSubMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnSubMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/inventario.png"))); // NOI18N
        btnInventario.setBorderPainted(false);
        btnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInventarioMouseExited(evt);
            }
        });
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(-126, 10, 180, 40));

        btnMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/Marca.png"))); // NOI18N
        btnMarca.setBorderPainted(false);
        btnMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMarcaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMarcaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMarcaMouseExited(evt);
            }
        });
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(-126, 110, 180, 40));

        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/Categoria.png"))); // NOI18N
        btnCategoria.setBorderPainted(false);
        btnCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCategoriaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCategoriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCategoriaMouseExited(evt);
            }
        });
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(-126, 210, 180, 40));

        btnParametro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/bitacoras.png"))); // NOI18N
        btnParametro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParametroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnParametroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnParametroMouseExited(evt);
            }
        });
        btnParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParametroActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(-126, 300, 180, 40));

        jpnBarraMenu.add(jpnSubMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 77, 190, 540));

        btnHome.setToolTipText("Inicio");
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpnBarraMenu.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, -1));

        getContentPane().add(jpnBarraMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 650));

        jpnPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        jpnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnPrimero.setBackground(new java.awt.Color(255, 255, 255));
        jpnPrimero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnPass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setText("Repita nueva contraseña:");
        jpnPass.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        pwdAntigua.setBackground(new java.awt.Color(240, 240, 240));
        pwdAntigua.setBorder(null);
        pwdAntigua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdAntiguaFocusGained(evt);
            }
        });
        pwdAntigua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdAntiguaActionPerformed(evt);
            }
        });
        jpnPass.add(pwdAntigua, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 35, 190, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel9.setText("Contraseña antigua:");
        jpnPass.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        pwdNueva.setBackground(new java.awt.Color(240, 240, 240));
        pwdNueva.setBorder(null);
        pwdNueva.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdNuevaFocusGained(evt);
            }
        });
        pwdNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdNuevaActionPerformed(evt);
            }
        });
        jpnPass.add(pwdNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 190, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText("Nueva contraseña:");
        jpnPass.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        pwdNueva2.setBackground(new java.awt.Color(240, 240, 240));
        pwdNueva2.setBorder(null);
        pwdNueva2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdNueva2FocusGained(evt);
            }
        });
        jpnPass.add(pwdNueva2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, 190, -1));

        btnAtrasPwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Atras2.png"))); // NOI18N
        btnAtrasPwd.setToolTipText("Volver atrás.");
        btnAtrasPwd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAtrasPwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasPwdMouseClicked(evt);
            }
        });
        jpnPass.add(btnAtrasPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 30, 30));

        btnCambiarPwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Aceptar.png"))); // NOI18N
        btnCambiarPwd.setToolTipText("Cambiar Contraseña.");
        btnCambiarPwd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCambiarPwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambiarPwdMouseClicked(evt);
            }
        });
        jpnPass.add(btnCambiarPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 155, 30, 30));

        jSeparator4.setBackground(new java.awt.Color(102, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(102, 0, 0));
        jpnPass.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 190, 10));

        jSeparator5.setBackground(new java.awt.Color(102, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(102, 0, 0));
        jpnPass.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, 10));

        jSeparator6.setBackground(new java.awt.Color(102, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(102, 0, 0));
        jpnPass.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 190, 10));

        jpnPrimero.add(jpnPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, -185, 230, 190));

        lblMitad.setBackground(new java.awt.Color(0, 0, 0));
        lblMitad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/demos.jpg"))); // NOI18N
        jpnPrimero.add(lblMitad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 650));
        jpnPrimero.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jpnPrincipal.add(jpnPrimero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1070, 650));

        jpnSegundo.setBackground(new java.awt.Color(0, 0, 0));
        jpnSegundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMitad2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/mitad7.JPG"))); // NOI18N
        jpnSegundo.add(lblMitad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 515, 640));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl12.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl12.setForeground(new java.awt.Color(102, 102, 102));
        lbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl12.setText("productos");
        jPanel1.add(lbl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 148, 210, 30));

        lbl18.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl18.setForeground(new java.awt.Color(102, 102, 102));
        lbl18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl18.setText("agregar o eliminar");
        jPanel1.add(lbl18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 30));

        lbl17.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl17.setForeground(new java.awt.Color(102, 102, 102));
        lbl17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl17.setText("Podrás elegir entre:");
        jPanel1.add(lbl17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, -1));

        lbl13.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl13.setForeground(new java.awt.Color(102, 102, 102));
        lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl13.setText("aumentos y reducciones");
        jPanel1.add(lbl13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 30));

        lbl16.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl16.setForeground(new java.awt.Color(102, 102, 102));
        lbl16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl16.setText("Podrás realizar ");
        jPanel1.add(lbl16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, -1));

        lbl11.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lbl11.setForeground(new java.awt.Color(255, 255, 255));
        lbl11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Compras.png"))); // NOI18N
        lbl11.setText("Inventario");
        jPanel1.add(lbl11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        jpnSegundo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 210, 230));

        jpnPrincipal.add(jpnSegundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1010, 650));

        jpnTercero.setBackground(new java.awt.Color(0, 0, 0));
        jpnTercero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl28.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl28.setForeground(new java.awt.Color(102, 102, 102));
        lbl28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl28.setText("las marcas a tu conveniencia");
        jPanel2.add(lbl28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, -1));

        lbl29.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl29.setForeground(new java.awt.Color(102, 102, 102));
        lbl29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl29.setText("modificar o eliminar");
        jPanel2.add(lbl29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 30));

        lbl30.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl30.setForeground(new java.awt.Color(102, 102, 102));
        lbl30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl30.setText("Podrás agregar");
        jPanel2.add(lbl30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, -1));

        lbl36.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lbl36.setForeground(new java.awt.Color(255, 255, 255));
        lbl36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ventas.png"))); // NOI18N
        lbl36.setText("Marcas");
        jPanel2.add(lbl36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        jpnTercero.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 210, 230));

        lblMitad3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/marcamitad.jpg"))); // NOI18N
        lblMitad3.setText("jLabel2");
        jpnTercero.add(lblMitad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 515, 640));

        jpnPrincipal.add(jpnTercero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1010, 650));

        jpnCuarto.setBackground(new java.awt.Color(0, 0, 0));
        jpnCuarto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMitad4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/mitad4.jpg"))); // NOI18N
        jpnCuarto.add(lblMitad4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 515, 640));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl24.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl24.setForeground(new java.awt.Color(102, 102, 102));
        lbl24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl24.setText("a tu conveniencia");
        jPanel3.add(lbl24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 30));

        lbl25.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl25.setForeground(new java.awt.Color(102, 102, 102));
        lbl25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl25.setText("las categorías");
        jPanel3.add(lbl25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, -1));

        lbl37.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl37.setForeground(new java.awt.Color(102, 102, 102));
        lbl37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl37.setText("modificar o eliminar");
        jPanel3.add(lbl37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 30));

        lbl38.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl38.setForeground(new java.awt.Color(102, 102, 102));
        lbl38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl38.setText("Podrás agregar");
        jPanel3.add(lbl38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, -1));

        lbl39.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lbl39.setForeground(new java.awt.Color(255, 255, 255));
        lbl39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Productos.png"))); // NOI18N
        lbl39.setText("Categorías");
        jPanel3.add(lbl39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        jpnCuarto.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 210, 230));

        jpnPrincipal.add(jpnCuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1010, 650));

        getContentPane().add(jpnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 1030, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpnBarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jpnBarraSuperiorMouseDragged

    private void jpnBarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jpnBarraSuperiorMousePressed

    private void jpnBarraMenuPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jpnBarraMenuPropertyChange
        
    }//GEN-LAST:event_jpnBarraMenuPropertyChange

    private void btnInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseClicked
        apagado();
        Animacion.Animacion.mover_derecha(-126, 0, 1, 2, btnInventario);
        apagado2();
        frmInventario inv = new frmInventario();
        inv.setVisible(true);
        dispose();
        //parte Agregar                            
    }//GEN-LAST:event_btnInventarioMouseClicked

    private void btnInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseEntered
        /*  ---- Animación compras, mover ----  */
        if(!compras)
        Animacion.Animacion.mover_derecha(-126, 0, 1, 2, btnInventario);
        Principal(false);
        Compras(true);
    }//GEN-LAST:event_btnInventarioMouseEntered

    private void btnInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseExited
        /*  ---- Animación compras, volver posición anterior ----  */
        if(!compras)
        Animacion.Animacion.mover_izquierda(0, -126, 1, 2, btnInventario);
        Principal(true);
        Compras(false);
    }//GEN-LAST:event_btnInventarioMouseExited

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed

    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarcaMouseClicked
            frmMarca mar = new frmMarca();
            mar.setVisible(true);   
            dispose();
    }//GEN-LAST:event_btnMarcaMouseClicked

    private void btnMarcaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarcaMouseEntered
        if(!ventas)
        Animacion.Animacion.mover_derecha(-126, 0, 1, 2, btnMarca);
        Principal(false);
        Ventas(true);
    }//GEN-LAST:event_btnMarcaMouseEntered

    private void btnMarcaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarcaMouseExited
        if(!ventas)
        Animacion.Animacion.mover_izquierda(0, -126, 1, 2, btnMarca);
        Principal(true);
        Ventas(false);
    }//GEN-LAST:event_btnMarcaMouseExited

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed

    }//GEN-LAST:event_btnMarcaActionPerformed

    private void btnCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriaMouseClicked
        Animacion.Animacion.mover_derecha(-126, 0, 1, 2, btnCategoria);
        frmCategoria cat = new frmCategoria();
        cat.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCategoriaMouseClicked

    private void btnCategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriaMouseEntered
        if(!productos)
        Animacion.Animacion.mover_derecha(-126, 0, 1, 2, btnCategoria);
        Principal(false);
        Productos(true);
    }//GEN-LAST:event_btnCategoriaMouseEntered

    private void btnCategoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriaMouseExited
        if(!productos)
        Animacion.Animacion.mover_izquierda(0, -126, 1, 2, btnCategoria);
        Principal(true);
        Productos(false);
    }//GEN-LAST:event_btnCategoriaMouseExited

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        //
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void pwdAntiguaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdAntiguaFocusGained
        pwdAntigua.selectAll();
    }//GEN-LAST:event_pwdAntiguaFocusGained

    private void pwdAntiguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdAntiguaActionPerformed
        pwdNueva.requestFocus();
    }//GEN-LAST:event_pwdAntiguaActionPerformed

    private void pwdNuevaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdNuevaFocusGained
        pwdNueva.selectAll();
    }//GEN-LAST:event_pwdNuevaFocusGained

    private void pwdNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdNuevaActionPerformed
        pwdNueva2.requestFocus();
    }//GEN-LAST:event_pwdNuevaActionPerformed

    private void pwdNueva2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdNueva2FocusGained
        pwdNueva2.selectAll();
    }//GEN-LAST:event_pwdNueva2FocusGained

    private void btnAtrasPwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasPwdMouseClicked
        Animacion.Animacion.subir(55, -195, 1, 2, jpnPass);
    }//GEN-LAST:event_btnAtrasPwdMouseClicked

    private void btnCambiarPwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarPwdMouseClicked
        //comprobarPass();
    }//GEN-LAST:event_btnCambiarPwdMouseClicked

    private void btnParametroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParametroMouseClicked
        Animacion.Animacion.mover_derecha(-126, 0, 1, 2, btnParametro);
        frmLoginm lg = new frmLoginm();
        lg.setVisible(true);           
    }//GEN-LAST:event_btnParametroMouseClicked

    private void btnParametroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParametroMouseEntered
        if(!parametro)
        Animacion.Animacion.mover_derecha(-126, 0, 1, 2, btnParametro);
        //Principal(false);
        //Productos(true);
    }//GEN-LAST:event_btnParametroMouseEntered

    private void btnParametroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParametroMouseExited
        if(!parametro)
        Animacion.Animacion.mover_izquierda(0, -126, 1, 2, btnParametro);
        //Principal(true);
        //Ventas(false);
    }//GEN-LAST:event_btnParametroMouseExited

    private void btnParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParametroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnParametroActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtrasPwd;
    private javax.swing.JLabel btnCambiarPwd;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JLabel btnHome;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnMarca;
    private javax.swing.JButton btnParametro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel jpnBarraMenu;
    private javax.swing.JPanel jpnBarraSuperior;
    private javax.swing.JPanel jpnCuarto;
    private javax.swing.JPanel jpnPass;
    private javax.swing.JPanel jpnPrimero;
    private javax.swing.JPanel jpnPrincipal;
    private javax.swing.JPanel jpnSegundo;
    private javax.swing.JPanel jpnSubMenu;
    private javax.swing.JPanel jpnTercero;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl16;
    private javax.swing.JLabel lbl17;
    private javax.swing.JLabel lbl18;
    private javax.swing.JLabel lbl24;
    private javax.swing.JLabel lbl25;
    private javax.swing.JLabel lbl28;
    private javax.swing.JLabel lbl29;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl30;
    private javax.swing.JLabel lbl36;
    private javax.swing.JLabel lbl37;
    private javax.swing.JLabel lbl38;
    private javax.swing.JLabel lbl39;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblMitad;
    private javax.swing.JLabel lblMitad2;
    private javax.swing.JLabel lblMitad3;
    private javax.swing.JLabel lblMitad4;
    private javax.swing.JPasswordField pwdAntigua;
    private javax.swing.JPasswordField pwdNueva;
    private javax.swing.JPasswordField pwdNueva2;
    // End of variables declaration//GEN-END:variables
}
