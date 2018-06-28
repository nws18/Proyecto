package gui;

import LinkedBinaryTree.TreeException;
import com.oracle.jrockit.jfr.Producer;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import domain.Category;
import domain.Cellar;
import domain.DistributionOrder;
import domain.Product;
import domain.TableProduct;
//import static gui.ConfirmOrder.booleanConfirmOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static tda.LoadTda.batchMap;
import static tda.LoadTda.categoryMap;
import static tda.LoadTda.cellarGraph;
import static tda.LoadTda.distributionOrderList;
import java.awt.BorderLayout;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import lab_grafos_algoritmos.GraphException;
import tda.LoadFiles;
import static tda.LoadTda.productsBinaryTree;

/**
 * Interfaz módulo Logística de distribución.
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class LogisticsDistribution extends javax.swing.JFrame {

    public static boolean confirm = false;
    public static ArrayList<DistributionOrder> pruebaList = new ArrayList<DistributionOrder>();
    public static DistributionOrder distributionOrder = new DistributionOrder();
    static int userId = -1;
    static int capacity = 0;
    /**
     * Creates new form NewJFrame
     */
    private Browser browser = new Browser();
    private BrowserView view = new BrowserView(browser);
    private ArrayList<TableProduct> tableList = new ArrayList<>();
    private boolean cell1 = false;
    private boolean cell2 = false;

    public LogisticsDistribution() throws TreeException {
        initComponents();
        jLabel11.setText("Distancia:");
        setIconImage(new ImageIcon(getClass().getResource("/icons/truck.png")).getImage());
        jPanel3.setLayout(new BorderLayout());
        jPanel3.add(view, BorderLayout.CENTER);
        browser.loadURL("maps.google.es");

//        
        String[] arrayCellar = new String[cellarGraph.list().size()];
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar tempCellar = (Cellar) cellarGraph.list().get(i);
            arrayCellar[i] = tempCellar.getName();
        }
        cellarList.setListData(arrayCellar);
        jList1.setListData(arrayCellar);

        String[] arrayProducts = new String[productsBinaryTree.getSize()];
        for (int i = 0; i < productsBinaryTree.getSize(); i++) {
            Product tempProduct = (Product) productsBinaryTree.recorreArbol().get(i);
            arrayProducts[i] = tempProduct.getName();
        }
        listProducts.setListData(arrayProducts);

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ConfirmExit confirmExit = new ConfirmExit();
                confirmExit.setVisible(true);
            }
        });
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
        progressBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cellarList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        returnLoginButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        labelTruck = new javax.swing.JLabel();
        nameTruck = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/carrito.png"))); // NOI18N
        jLabel1.setText("Productos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        listProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listProductsMousePressed(evt);
            }
        });
        listProducts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listProductsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listProducts);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 140, 150));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 142, 81));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Producto", "Monto", "Peso", "Categoría"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 500, 90));
        jPanel1.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 500, 32));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logistica.png"))); // NOI18N
        jLabel3.setText("Logística de distribución");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/almacen.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, -1));

        cellarList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cellarList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cellarListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cellarListMousePressed(evt);
            }
        });
        cellarList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                cellarListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(cellarList);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 140, 100));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mapas-y-banderas.png"))); // NOI18N
        jLabel5.setText("Ubicación");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        confirmButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        confirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/compra-confirmada.png"))); // NOI18N
        confirmButton.setText("Confirmar");
        confirmButton.setBorderPainted(false);
        confirmButton.setContentAreaFilled(false);
        confirmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        jPanel1.add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 580, -1, -1));

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
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 200, 100));

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
        jPanel1.add(labelTruck, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 80, 70));

        nameTruck.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        nameTruck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/truck.png"))); // NOI18N
        jPanel1.add(nameTruck, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 190, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Webp.net-gifmaker (1).gif"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 170, 110));

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/escoba.png"))); // NOI18N
        jButton1.setText("Limpiar orden");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 150, 40));

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList1MousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(jList1);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 140, 100));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, 200, 100));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Bodega Origen");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 110, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Bodega destino");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 140, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 160, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1294, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed

        ConfirmOrder confirmOrder = new ConfirmOrder();
        confirmOrder.setVisible(true);

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String orderDate = dateFormat.format(date);
        try {

            distributionOrder.setProductList(getProducts());
            distributionOrder.setIdDistributionOrder(distributionOrderList.size());
            distributionOrder.setTotalAmount(Double.parseDouble(String.valueOf(getTotalAmount())));
            distributionOrder.setWeightTotal(Float.parseFloat(String.valueOf(getTotalWeight())));
            distributionOrder.setIdDestinyCellar(getCellarDestinyId());
            distributionOrder.setIdOperator(userId);
            distributionOrder.setIdOriginCellar(getCellarOriginId());
            distributionOrder.setOrderDate(orderDate);

        } catch (TreeException ex) {
            Logger.getLogger(LogisticsDistribution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private int getTotalAmount() {
        int total = 0;
        for (int i = 0; i < tableList.size(); i++) {
            total += tableList.get(i).getAmount();
        }
        return total;
    }

    private int getTotalWeight() {
        int totalWeight = 0;
        for (int i = 0; i < tableList.size(); i++) {
            totalWeight += tableList.get(i).getWeight();
        }
        return totalWeight;
    }

    private int getCellarDestinyId() {
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar tempCellar = (Cellar) cellarGraph.list().get(i);
            if (tempCellar.getName().equals(jList1.getSelectedValue())) {
                return tempCellar.getIdCellar();
            }
        }
        return -1;
    }

    private int getCellarOriginId() {
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar tempCellar = (Cellar) cellarGraph.list().get(i);
            if (tempCellar.getName().equals(cellarList.getSelectedValue())) {
                return tempCellar.getIdCellar();
            }
        }
        return -1;
    }

    private ArrayList getProducts() throws TreeException {
        ArrayList<Product> arrayListProducts = new ArrayList<>();
        for (int i = 0; i < tableList.size(); i++) {

            TableProduct tempTableProduct = tableList.get(i);
            for (int j = 0; j < productsBinaryTree.getSize(); j++) {
                Product tempProduct = (Product) productsBinaryTree.recorreArbol().get(j);

                if (tempProduct.getName().equals(tempTableProduct.getProduct())) {
                    for (int k = 0; k < tempTableProduct.getQuantity(); k++) {
                        arrayListProducts.add(tempProduct);
                    }
                }
            }
        }
        return arrayListProducts;
    }

    private void returnLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnLoginButtonActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_returnLoginButtonActionPerformed

    private void listProductsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listProductsValueChanged
//       
    }//GEN-LAST:event_listProductsValueChanged

    private void cellarListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cellarListMouseClicked

    }//GEN-LAST:event_cellarListMouseClicked

    private void cellarListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_cellarListValueChanged

    }//GEN-LAST:event_cellarListValueChanged

    private void listProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductsMousePressed
        try {
            for (int i = 0; i < productsBinaryTree.getSize(); i++) {
                Product tempProduct = (Product) productsBinaryTree.recorreArbol().get(i);
                if (tempProduct.getName().equals(listProducts.getSelectedValue())) {
                    ImageIcon imageIcon = new ImageIcon(tempProduct.getUrl());
                    jLabel2.setIcon(imageIcon);
                }
            }
        } catch (TreeException ex) {
            Logger.getLogger(LogisticsDistribution.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean exist = false;
        int total = 0;
        for (int i = 0; i < tableList.size(); i++) {
            TableProduct tempTableProduct = tableList.get(i);

            total += tempTableProduct.getWeight();

        }

        TableProduct tableProduct = new TableProduct();
        for (int i = 0; i < tableList.size(); i++) {
            try {
                if (listProducts.getSelectedValue().equals(tableList.get(i).getProduct()) && total + getWeight(listProducts.getSelectedValue()) < 30001) {
                    try {
                        tableList.get(i).setQuantity(tableList.get(i).getQuantity() + 1);
                        tableList.get(i).setAmount(tableList.get(i).getAmount() + getValue(listProducts.getSelectedValue()));
                        tableList.get(i).setWeight(tableList.get(i).getWeight() + getWeight(listProducts.getSelectedValue()));
                        exist = true;
                    } catch (TreeException ex) {
                        Logger.getLogger(LogisticsDistribution.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (TreeException ex) {
                Logger.getLogger(LogisticsDistribution.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!exist) {
            try {
                for (int i = 0; i < productsBinaryTree.getSize(); i++) {
                    Product tempProduct = (Product) productsBinaryTree.recorreArbol().get(i);
                    if (tempProduct.getName().equals(listProducts.getSelectedValue())) {
                        tableProduct.setAmount((int) tempProduct.getPrice());
                        tableProduct.setProduct(tempProduct.getName());
                        Iterator iterator = categoryMap.keySet().iterator();

                        while (iterator.hasNext()) {
                            String key = (String) iterator.next();
                            Category category = categoryMap.get(key);
                            if (category.getIdCategory() == tempProduct.getIdCategory()) {
                                tableProduct.setCategory(category.getName());
                            }
                        }
                        tableProduct.setQuantity(1);
                        tableProduct.setWeight(tempProduct.getTotalWeight());
                    }
                }
            } catch (TreeException ex) {
                Logger.getLogger(LogisticsDistribution.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (total + tableProduct.getWeight() < 30001) {
                tableList.add(tableProduct);
            }
        }

        double progress = 0;
        if (total < 30001) {
            if (total < 1000) {
                ImageIcon imageIcon = new ImageIcon("images/transport/small.png");
                labelTruck.setIcon(imageIcon);
                nameTruck.setText("Capacidad: 1 tonelada");
                double totalDouble = (double) total;
                double hundred = 100.0;
                double maxWeight = 1000.0;
                progress = ((total / maxWeight) * hundred);
            } else if (total > 1000 && total < 5000) {
                ImageIcon imageIcon = new ImageIcon("images/transport/medium.png");
                labelTruck.setIcon(imageIcon);
                nameTruck.setText("Capacidad: 5 toneladas");
                double totalDouble = (double) total;
                double hundred = 100.0;
                double maxWeight = 5000.0;
                progress = ((total / maxWeight) * hundred);
            } else if (total > 5000 && total < 10000) {
                ImageIcon imageIcon = new ImageIcon("images/transport/big.png");
                labelTruck.setIcon(imageIcon);
                nameTruck.setText("Capacidad: 10 toneladas");
                double totalDouble = (double) total;
                double hundred = 100.0;
                double maxWeight = 10000.0;
                progress = ((total / maxWeight) * hundred);
            } else if (total > 10000 && total <= 30000) {
                ImageIcon imageIcon = new ImageIcon("images/transport/giant.png");
                labelTruck.setIcon(imageIcon);
                nameTruck.setText("Capacidad: 30 toneladas");
                double totalDouble = (double) total;
                double hundred = 100.0;
                double maxWeight = 30000.0;
                progress = ((total / maxWeight) * hundred);

            }

            progressBar.setValue((int) progress);
            capacity = progressBar.getValue();
            progressBar.setStringPainted(true);
            if (total < 30001) {
                fillTable();
            }
        }
    }//GEN-LAST:event_listProductsMousePressed

    public void setDistance() throws GraphException {
        Cellar origin = new Cellar();
        Cellar destiny = new Cellar();

        if (cell1 == true && cell2 == true && !cellarList.getSelectedValue().equals(jList1.getSelectedValue())) {
            for (int i = 0; i < cellarGraph.getSize(); i++) {
                Cellar tempCellar = (Cellar) cellarGraph.list().get(i);
                if (cellarList.getSelectedValue().equals(tempCellar.getName())) {
                    origin = tempCellar;
                }
                if (jList1.getSelectedValue().equals(tempCellar.getName())) {
                    destiny = tempCellar;
                }
            }
//            jLabel11.setText("Distancia: " + cellarGraph.getWeigth(origin, destiny));
        }
    }
    private void cellarListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cellarListMousePressed
        // TODO add your handling code here:
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar tempCellar = (Cellar) cellarGraph.list().get(i);
            if (tempCellar.getName().equals(cellarList.getSelectedValue())) {
                try {
                    ImageIcon imageIcon = new ImageIcon(tempCellar.getUrl());
                    jLabel6.setIcon(imageIcon);
                    cell1 = true;
                    loadMap();
                    setDistance();
                } catch (GraphException ex) {
                    Logger.getLogger(LogisticsDistribution.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_cellarListMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        labelTruck.setIcon(null);
        jLabel6.setIcon(null);
        jLabel2.setIcon(null);
        jLabel8.setIcon(null);
        progressBar.setValue(0);
        tableList.removeAll(tableList);
        fillTable();
        browser.loadURL("maps.google.es");
        distributionOrder.setIdDestinyCellar(-1);
        distributionOrder.setIdDistributionOrder(-1);
        distributionOrder.setIdOperator(-1);
        distributionOrder.setIdOriginCellar(-1);
        distributionOrder.setOrderDate(null);
        distributionOrder.setProductList(null);
        distributionOrder.setTotalAmount(0.0);
        distributionOrder.setWeightTotal(0);
        cell1 = false;
        cell2 = false;
        nameTruck.setText(null);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MousePressed
        // TODO add your handling code here:
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar tempCellar = (Cellar) cellarGraph.list().get(i);
            if (tempCellar.getName().equals(jList1.getSelectedValue())) {
                try {
                    ImageIcon imageIcon = new ImageIcon(tempCellar.getUrl());
                    jLabel8.setIcon(imageIcon);
                    cell2 = true;
                    loadMap();
                    setDistance();
                } catch (GraphException ex) {
                    Logger.getLogger(LogisticsDistribution.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_jList1MousePressed
    private void loadMap() {
        if (cell1 == true && cell2 == true && !cellarList.getSelectedValue().equals(jList1.getSelectedValue())) {
            String[] array = new String[8];

            array[0] = ("https:/" + "" + "/www.google.com/maps/dir/");
            array[1] = ("");
            array[2] = (",");
            array[3] = ("");
            array[4] = ("/");
            array[5] = ("");
            array[6] = (",");
            array[7] = ("");

            for (int i = 0; i < cellarGraph.list().size(); i++) {
                Cellar tempCellar = (Cellar) cellarGraph.list().get(i);
                if (tempCellar.getName().equals(cellarList.getSelectedValue())) {
                    ImageIcon imageIcon = new ImageIcon(tempCellar.getUrl());
                    jLabel8.setIcon(imageIcon);
                    array[1] = tempCellar.getLatitude();
                    array[3] = tempCellar.getLength();

                }
                if (tempCellar.getName().equals(jList1.getSelectedValue())) {
                    ImageIcon imageIcon = new ImageIcon(tempCellar.getUrl());
                    jLabel8.setIcon(imageIcon);
                    array[5] = tempCellar.getLatitude();
                    array[7] = tempCellar.getLength();

                }
            }
            String url = array[0] + array[1] + array[2] + array[3] + array[4] + array[5] + array[6] + array[7];
            browser.loadURL(url);

        } else {
            browser.loadURL("maps.google.es");
        }
    }

    private int getValue(String name) throws TreeException {
        for (int i = 0; i < productsBinaryTree.getSize(); i++) {
            Product tempProduct = (Product) productsBinaryTree.recorreArbol().get(i);
            if (tempProduct.getName().equals(name)) {
                return (int) tempProduct.getPrice();
            }
        }
        return 0;
    }

    private int getWeight(String name) throws TreeException {
        for (int i = 0; i < productsBinaryTree.getSize(); i++) {
            Product tempProduct = (Product) productsBinaryTree.recorreArbol().get(i);
            if (tempProduct.getName().equals(name)) {
                return tempProduct.getTotalWeight();
            }
        }
        return 0;
    }

    public void fillTable() {
        String[][] array = new String[tableList.size()][5];
        for (int i = 0; i < tableList.size(); i++) {
            array[i][0] = String.valueOf(tableList.get(i).getQuantity());
            array[i][1] = tableList.get(i).getProduct();
            array[i][2] = String.valueOf(tableList.get(i).getAmount());
            array[i][3] = String.valueOf(tableList.get(i).getWeight());
            array[i][4] = tableList.get(i).getCategory();
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(array, new String[]{"Cantidad", "Producto", "Monto", "Peso", "Categoria"}));
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
                try {
                    new LogisticsDistribution().setVisible(true);
                } catch (TreeException ex) {
                    Logger.getLogger(LogisticsDistribution.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> cellarList;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelTruck;
    private javax.swing.JList<String> listProducts;
    private javax.swing.JLabel nameTruck;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton returnLoginButton;
    // End of variables declaration//GEN-END:variables
}
