
package gui;

import com.mxrck.autocompleter.TextAutoCompleter;
import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.DistributionOrder;
import domain.Product;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab_grafos_algoritmos.GraphException;
import static tda.LoadTda.batchMap;
import static tda.LoadTda.categoryMap;
import static tda.LoadTda.cellarGraph;
import static tda.LoadTda.distributionOrderList;
//import static tda.LoadTda.productsBinaryTree;

/**
 * Interfaz reporte de lotes anulados.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class Reports extends javax.swing.JFrame {

    private ArrayList<Product> productList = new ArrayList<>();
    
    public Reports() {
        initComponents();
        
        //Autocompletar buscar lote
        TextAutoCompleter textAutoAcompleterSearchBatch = new TextAutoCompleter(batchTextField);
        Iterator iterator = batchMap.keySet().iterator();
        while (iterator.hasNext()) {
            try {
                Integer key = (Integer) iterator.next();
                Batch batch = batchMap.get(key);
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date expirationDate = dateFormat.parse(batch.getExpirationDate());
                if (expirationDate.before(date)) {
                    textAutoAcompleterSearchBatch.addItem(batch.getBatchCode());
                }
            } catch (ParseException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Llena la tabla con productos según el código de lote buscado.
     */
    public void fillTable() {
        for (int i = 0; i < distributionOrderList.size(); i++) {
            DistributionOrder distributionOrder = distributionOrderList.get(i);
            for (int j = 0; j < distributionOrder.getProductList().size(); j++) {
                Product tempProduct = (Product) distributionOrder.getProductList().get(j);
                if (batchTextField.getText().equals(getBatchCode(tempProduct.getIdBatch()))) {
                    productList.add(tempProduct);
                }
            }
        }
        
        String[][] array = new String[productList.size()][6];
        for (int i = 0; i < productList.size(); i++) {
            array[i][0] = productList.get(i).getName();
            array[i][1] = productList.get(i).getUnitMeasured();
            array[i][2] = String.valueOf(productList.get(i).getUnitValue());
            array[i][3] = String.valueOf(productList.get(i).getTotalWeight());
            array[i][4] = String.valueOf(getCategoryName(productList.get(i).getIdCategory()));
            array[i][5] = String.valueOf(productList.get(i).getPrice());
        }
        table.setModel(new javax.swing.table.DefaultTableModel(array, new String[]{"Nombre", "Unidad medida", "Valor unidad", "Peso total", "Categoría", "Precio"}));
 
    }
  
    /**
     * Recibe el id de una categoría y devuelve su nombre para mostrarlo en la tabla.
     * @param idCategory
     * @return String
     */
    private String getCategoryName(int idCategory) {
        Iterator iterator = categoryMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Category category = categoryMap.get(key);
            if (category.getIdCategory() == idCategory) {
                return category.getName();
            }
        }
        return null;
    }
    
    /**
     * Recibe el id de un código de lote y devuelve su nombre para mostrarlo en la tabla.
     * @param idBatch
     * @return 
     */
    private String getBatchCode(int idBatch) {
        Iterator iterator = batchMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            Batch batch = batchMap.get(key);
            if(idBatch == batch.getIdBatch()) {
                return batch.getBatchCode();
            }
        }
        return null;
    }
    
    /**
     * Llena la lista con las bodegas que cuentan con el producto según
     * el código de lote ingresado.
     * @throws GraphException 
     */
    public void fillList() throws GraphException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < distributionOrderList.size(); i++) {
            DistributionOrder distributionOrder = distributionOrderList.get(i);
            for (int x = 0; x < distributionOrder.getProductList().size(); x++) {
                Product product = distributionOrder.getProductList().get(x);
                if (batchTextField.getText().equals(getBatchCode(product.getIdBatch()))) {
                    for (int j = 0; j < cellarGraph.list().size(); j++) {
                        Cellar cellar = (Cellar) cellarGraph.list().get(j);
                        if (distributionOrder.getIdDestinyCellar() == cellar.getIdCellar()) {
                            arrayList.add(cellar.getName() + " " + distributionOrder.getOrderDate());
                        }
                    }
                }
            }
            
        }
        String[] cellarList = new String[arrayList.size()];
        for (int i = 0; i < cellarList.length; i++) {
            cellarList[i] = (String) arrayList.get(i);
        }
        this.cellarList.setListData(cellarList);
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
        batchTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        returnAdministratorButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cellarList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reporte de lotes anulados");

        jPanel1.setBackground(new java.awt.Color(153, 204, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Ingrese código de lote");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel1.add(batchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Unidad medida", "Valor unidad", "Peso total", "Categoría", "Precio"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 570, 190));

        returnAdministratorButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        returnAdministratorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salir-con-boton-en-esquema.png"))); // NOI18N
        returnAdministratorButton.setText("Salir");
        returnAdministratorButton.setBorderPainted(false);
        returnAdministratorButton.setContentAreaFilled(false);
        returnAdministratorButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnAdministratorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnAdministratorButtonActionPerformed(evt);
            }
        });
        jPanel1.add(returnAdministratorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 390, -1, -1));

        jScrollPane2.setViewportView(cellarList);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 230, 210));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tareas.png"))); // NOI18N
        jLabel2.setText("Reporte de lotes anulados");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        searchButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lupa-para-buscar.png"))); // NOI18N
        searchButton.setText("Buscar");
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 100, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/almacen.png"))); // NOI18N
        jLabel3.setText("Lista de bodegas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/carrito.png"))); // NOI18N
        jLabel4.setText("Productos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnAdministratorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnAdministratorButtonActionPerformed
        Administrator administrator = new Administrator();
        administrator.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_returnAdministratorButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        productList.clear();
        fillTable();
        try {
            fillList();
        } catch (GraphException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField batchTextField;
    private javax.swing.JList<String> cellarList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton returnAdministratorButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
