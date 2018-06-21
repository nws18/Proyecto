package gui;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import domain.Batch;
import domain.Cellar;
import domain.Product;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.plaf.IconUIResource;
import static tda.LoadTda.batchMap;
import static tda.LoadTda.cellarGraph;
import static tda.LoadTda.tempTree;

/**
 * Interfaz módulo Logística de distribución.
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class LogisticsDistribution extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Browser browser = new Browser();

    public LogisticsDistribution() {
        initComponents();
        loadMap("https://www.google.com/maps/@9.7808897,-84.1564765,8z");

//       
//        DefaultListModel modelo = new DefaultListModel();
//        for (int i = 0; i < productsBinaryTree.recorreArbol().size(); i++) {
//            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
//            modelo.addElement(String.valueOf(product.getName().toString()));
//            
//        }
//        listProducts.setModel(modelo);
        String[] arrayCellar = new String[batchMap.size()];
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar tempCellar = (Cellar) cellarGraph.list().get(i);
            arrayCellar[i] = tempCellar.getName();
        }
        cellarList.setListData(arrayCellar);
        
         String[] arrayProducts = new String[tempTree.size()];
         for (int i = 0; i < tempTree.size() ; i++) {
            Product tempProduct = (Product) tempTree.get(i);
            arrayProducts[i]= tempProduct.getName();
        }
        listProducts.setListData(arrayProducts);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProducts = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cellarList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        returnLoginButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/carrito.png"))); // NOI18N
        jLabel1.setText("Productos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        listProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listProducts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listProductsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listProducts);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 104, 139));

        jLabel2.setText("***IMAGEN PRODUCTO***");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 142, 81));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Monto", "Peso", "Categoría"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 88));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 285, 32));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/furgoneta-de-reparto.png"))); // NOI18N
        jLabel3.setText("Logística de distribución");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/almacen.png"))); // NOI18N
        jLabel4.setText("Bodegas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        cellarList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cellarList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cellarListMouseClicked(evt);
            }
        });
        cellarList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                cellarListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(cellarList);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 115, 138));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mapas-y-banderas.png"))); // NOI18N
        jLabel5.setText("Ubicación");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/compra-confirmada.png"))); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 580, -1, -1));

        returnLoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salir-con-boton-en-esquema.png"))); // NOI18N
        returnLoginButton.setText("Salir");
        returnLoginButton.setBorderPainted(false);
        returnLoginButton.setContentAreaFilled(false);
        returnLoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnLoginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(returnLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 580, -1, -1));

        jLabel6.setText("***IMAGEN BODEGA***");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 275, 138));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, 530));

        jPanel3.setMinimumSize(new java.awt.Dimension(320, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(320, 100));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 686, 439));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1294, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void returnLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnLoginButtonActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_returnLoginButtonActionPerformed

    private void listProductsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listProductsValueChanged
        for (int i = 0; i < tempTree.size(); i++) {
            Product tempProduct = (Product) tempTree.get(i);
            if(tempProduct.getName().equals(listProducts.getSelectedValue())){
                
            
            }
        }
        
    }//GEN-LAST:event_listProductsValueChanged

    private void cellarListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cellarListMouseClicked
       
    }//GEN-LAST:event_cellarListMouseClicked

    private void cellarListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_cellarListValueChanged
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar tempCellar = (Cellar) cellarGraph.list().get(i);
            if (tempCellar.getName().equals(cellarList.getSelectedValue())) {

                System.out.println(tempCellar.getLatitude());
                System.out.println(tempCellar.getLength());
                //String url="http://maps.google.es/?q=loc:"+tempCellar.getLatitude()+"%20"+tempCellar.getLength();
                //String url = "https://www.google.com/maps/@"+tempCellar.getLatitude()+","+tempCellar.getLength()+",16z";
                String url = "https://maps.googleapis.com/maps/api/staticmap?center="
                        + tempCellar.getLatitude()
                        + ","
                        + tempCellar.getLength()
                        + "&zoom=11&size=612x612&scale=2&maptype=roadmap";
                browser.loadURL(url);
                ImageIcon imageIcon = new ImageIcon(tempCellar.getUrl());
                jLabel6.setIcon(imageIcon);

            }

        }
    }//GEN-LAST:event_cellarListValueChanged
    public void loadMap(String url) {

        BrowserView view = new BrowserView(browser);
        jPanel3.setLayout(new BorderLayout());
        jPanel3.add(view, BorderLayout.CENTER);
        browser.loadURL(url);
        jPanel3.setVisible(true);
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
            java.util.logging.Logger.getLogger(LogisticsDistribution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogisticsDistribution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogisticsDistribution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogisticsDistribution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogisticsDistribution().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> cellarList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> listProducts;
    private javax.swing.JButton returnLoginButton;
    // End of variables declaration//GEN-END:variables
}
