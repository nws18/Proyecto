package gui;


import LinkedBinaryTree.TreeException;
import com.mxrck.autocompleter.TextAutoCompleter;
import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.Product;
import domain.TransportUnit;
import domain.User;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import lab_grafos_algoritmos.GraphException;
import tda.CrudMaintenance;
import tda.LoadFiles;
import static tda.LoadTda.batchMap;
import static tda.LoadTda.categoryMap;
import static tda.LoadTda.cellarGraph;
import static tda.LoadTda.productsBinaryTree;
import static tda.LoadTda.transportUnitMap;
import static tda.LoadTda.userList;

/**
 * Interfaz mantenimiento de cada entidad.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class Maintenance extends javax.swing.JFrame {

    CrudMaintenance crudMaintenance = new CrudMaintenance();

    public Maintenance() throws TreeException {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icons/truck.png")).getImage());
        //Obtener fecha actual
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String packedDate = dateFormat.format(date);
        jLabel136.setText(packedDate);
        
        descriptionCategoryTextField.setLineWrap(true);

        //Información ComboBox
        comboBoxRole.addItem("Administrador");
        comboBoxRole.addItem("Operador");
        
        updateRoleUserComboBox.addItem("Administrador");
        updateRoleUserComboBox.addItem("Operador");
        
        MinCapacityComboBox.addItem("0");
        MinCapacityComboBox.addItem("1");
        MinCapacityComboBox.addItem("5");
        MinCapacityComboBox.addItem("10");
        
        MaxCapacityComboBox.addItem("1");
        MaxCapacityComboBox.addItem("5");
        MaxCapacityComboBox.addItem("10");
        MaxCapacityComboBox.addItem("30");
        
        unitMeasuredComboBox.addItem("Unidades");
        unitMeasuredComboBox.addItem("Paquetes");
        unitMeasuredComboBox.addItem("Cajas");
        unitMeasuredComboBox.addItem("Tarimas");
        
        updateUnitMeasuredComboBox.addItem("Unidades");
        updateUnitMeasuredComboBox.addItem("Paquetes");
        updateUnitMeasuredComboBox.addItem("Cajas");
        updateUnitMeasuredComboBox.addItem("Tarimas");
     
        updateMinCapacityComboBox.addItem("0");
        updateMinCapacityComboBox.addItem("1");
        updateMinCapacityComboBox.addItem("5");
        updateMinCapacityComboBox.addItem("10");
        
        updateMaxCapacityComboBox.addItem("1");
        updateMaxCapacityComboBox.addItem("5");
        updateMaxCapacityComboBox.addItem("10");
        updateMaxCapacityComboBox.addItem("30");
        
        Iterator iteratorBatchMap = batchMap.keySet().iterator();
        while (iteratorBatchMap.hasNext()) {
            Integer key = (Integer) iteratorBatchMap.next();
            Batch batch = batchMap.get(key);
            batchCodeComboBox.addItem(batch.getBatchCode());
            updateBatchCodeProduct.addItem(batch.getBatchCode());
        }
        
        Iterator iteratorCategoryMap = categoryMap.keySet().iterator();
        while (iteratorCategoryMap.hasNext()) {
            String key = (String) iteratorCategoryMap.next();
            Category category = categoryMap.get(key);
            categoryComboBox.addItem(category.getName());
            updateCategoryComboBox.addItem(category.getName());
        }
 
        //Autocompletar buscar categoría producto 
        TextAutoCompleter textAutoAcompleterSearchCategory = new TextAutoCompleter(searchNameCategoryTextField);
        Iterator iterator = categoryMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Category category = categoryMap.get(key);
            textAutoAcompleterSearchCategory.addItem(category.getName());
        }
        
        //Autocompletar actualizar categoría producto 
        TextAutoCompleter textAutoAcompleterUpdateCategory = new TextAutoCompleter(updateSearchNameCategoryTextField);
        Iterator iterator2 = categoryMap.keySet().iterator();
        while (iterator2.hasNext()) {
            String key = (String) iterator2.next();
            Category category = categoryMap.get(key);
            textAutoAcompleterUpdateCategory.addItem(category.getName());
        }
        
        //Autocompletar borrar categoría producto 
        TextAutoCompleter textAutoAcompleterDeleteCategory = new TextAutoCompleter(deleteCategoryTextField);
        Iterator iterator3 = categoryMap.keySet().iterator();
        while (iterator3.hasNext()) {
            String key = (String) iterator3.next();
            Category category = categoryMap.get(key);
            textAutoAcompleterDeleteCategory.addItem(category.getName());
        }
        
        //Autocompletar buscar usuario
        TextAutoCompleter textAutoCompleterSearchUser = new TextAutoCompleter(serchName);
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            textAutoCompleterSearchUser.addItem(user.getUser());
        }

        //Autocompletar actualizar usuario
        TextAutoCompleter textAutoCompleterUpdateUser = new TextAutoCompleter(updateUserTextField);
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            textAutoCompleterUpdateUser.addItem(user.getUser());
        }
        
        //Autocompletar actualizar usuario
        TextAutoCompleter textAutoCompleterDeleteUser = new TextAutoCompleter(deleteUserTextField);
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            textAutoCompleterDeleteUser.addItem(user.getUser());
        }
        
        //Autocompletar buscar unidad transporte
        TextAutoCompleter textAutoAcompleterSearchTransportUnit = new TextAutoCompleter(searchPlateTextField);
        Iterator iterator4 = transportUnitMap.keySet().iterator();
        while (iterator4.hasNext()) {
            int key = (int) iterator4.next();
            TransportUnit transportUnit = transportUnitMap.get(key);
            textAutoAcompleterSearchTransportUnit.addItem(transportUnit.getPlate());
        }
        
        //Autocompletar actualizar unidad transporte
        TextAutoCompleter textAutoAcompleterUpdateTransportUnit = new TextAutoCompleter(searchUpdateTransportTextField);
        Iterator iterator5 = transportUnitMap.keySet().iterator();
        while (iterator5.hasNext()) {
            int key = (int) iterator5.next();
            TransportUnit transportUnit = transportUnitMap.get(key);
            textAutoAcompleterUpdateTransportUnit.addItem(transportUnit.getPlate());
        }
        
         //Autocompletar borrar unidad transporte
        TextAutoCompleter textAutoAcompleterDeleteTransportUnit = new TextAutoCompleter(deleteTransportTextField);
        Iterator iterator6 = transportUnitMap.keySet().iterator();
        while (iterator6.hasNext()) {
            int key = (int) iterator6.next();
            TransportUnit transportUnit = transportUnitMap.get(key);
            textAutoAcompleterDeleteTransportUnit.addItem(transportUnit.getPlate());
        }
        
        //Autocompletar buscar lote
        TextAutoCompleter textAutoAcompleterSearchBatch = new TextAutoCompleter(searchBatchCodeLabel);
        Iterator iterator7 = batchMap.keySet().iterator();
        while (iterator7.hasNext()) {
            Integer key = (Integer) iterator7.next();
            Batch batch = batchMap.get(key);
            textAutoAcompleterSearchBatch.addItem(batch.getBatchCode());
        }
        
        //Autocompletar actualizar lote
        TextAutoCompleter textAutoAcompleterUpdateBatch = new TextAutoCompleter(updateSearchBatchCodeTextField);
        Iterator iterator8 = batchMap.keySet().iterator();
        while (iterator8.hasNext()) {
            Integer key = (Integer) iterator8.next();
            Batch batch = batchMap.get(key);
            textAutoAcompleterUpdateBatch.addItem(batch.getBatchCode());
        }
        
        //Autocompletar borrar lote
        TextAutoCompleter textAutoAcompleterDeleteBatch = new TextAutoCompleter(deleteBatchTextField);
        Iterator iterator9 = batchMap.keySet().iterator();
        while (iterator9.hasNext()) {
            Integer key = (Integer) iterator9.next();
            Batch batch = batchMap.get(key);
            textAutoAcompleterDeleteBatch.addItem(batch.getBatchCode());
        }
        
        //Autocompletar buscar bodega
        TextAutoCompleter textAutoAcompleterSearchCellar = new TextAutoCompleter(searchCellarTextField);
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            textAutoAcompleterSearchCellar.addItem(cellar.getName());
        }
        
        //Autocompletar actualizar bodega
        TextAutoCompleter textAutoAcompleterUpdateCellar = new TextAutoCompleter(updateSearchCellarTextField);
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            textAutoAcompleterUpdateCellar.addItem(cellar.getName());
        }
        
        //Autocompletar borrar bodega
        TextAutoCompleter textAutoAcompleterDeleteCellar = new TextAutoCompleter(deleteCellarTextField);
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar cellar = (Cellar) cellarGraph.list().get(i);
            textAutoAcompleterDeleteCellar.addItem(cellar.getName());
        }
        
        //Autocompletar buscar producto
        TextAutoCompleter textAutoCompleterSearchProduct = new TextAutoCompleter(searchProductTextField);
        for (int i = 0; i < productsBinaryTree.getSize() ; i++) {
            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
            textAutoCompleterSearchProduct.addItem(product.getName());
        }
        
        //Autocompletar actualizar producto
        TextAutoCompleter textAutoCompleterUpdateProduct = new TextAutoCompleter(updateSearchProductTextField);
        for (int i = 0; i < productsBinaryTree.getSize() ; i++) {
            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
            textAutoCompleterUpdateProduct.addItem(product.getName());
        }
        
        //Autocompletar borrar producto
        TextAutoCompleter textAutoCompleterDeleteProduct = new TextAutoCompleter(deleteProductTextField);
        for (int i = 0; i < productsBinaryTree.getSize() ; i++) {
            Product product = (Product) productsBinaryTree.recorreArbol().get(i);
            textAutoCompleterDeleteProduct.addItem(product.getName());
        }
        
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

        jTextField15 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboBoxRole = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        addUserButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        serchName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        serchUserButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        updateUserTextField = new javax.swing.JTextField();
        updateSearchUserButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        updateNameUserTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        updateRoleUserComboBox = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        updateUserNameTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        updatePasswordTextField = new javax.swing.JPasswordField();
        updateUserButton = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        deleteUserTextField = new javax.swing.JTextField();
        deleteUserButton = new javax.swing.JButton();
        jLabel114 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        plateTextField = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        MinCapacityComboBox = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        imageTransportUnitTextField = new javax.swing.JTextField();
        searchImageTransportUnit = new javax.swing.JButton();
        addTransportUnitButton = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        searchPlateTextField = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        capacityTransportUnitLabel = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        imageTransportUnit = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        searchUpdateTransportTextField = new javax.swing.JTextField();
        updateSearchPlateButton = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        plateTransportUnitTexField = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        updateMinCapacityComboBox = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        updateImageTransport = new javax.swing.JTextField();
        updateImageTransportUnit = new javax.swing.JButton();
        updateTransportUnitButton = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        deleteTransportTextField = new javax.swing.JTextField();
        deleteTransportUnitButton = new javax.swing.JButton();
        searchTransportUnitButton = new javax.swing.JButton();
        jLabel134 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        MaxCapacityComboBox = new javax.swing.JComboBox<>();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        updateMaxCapacityComboBox = new javax.swing.JComboBox<>();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel65 = new javax.swing.JLabel();
        codeBatchTextField = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel69 = new javax.swing.JLabel();
        searchBatchCodeLabel = new javax.swing.JTextField();
        searchBatchButton = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        packedDateLabel = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        expirationDateLabel = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        updateSearchBatchCodeTextField = new javax.swing.JTextField();
        updateSearchBatchButton = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        batchCodeLabel = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        expirationDatePicker = new org.jdesktop.swingx.JXDatePicker();
        updateBatchButton = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        deleteBatchTextField = new javax.swing.JTextField();
        deleteBatchButton = new javax.swing.JButton();
        addBatchButton = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel83 = new javax.swing.JLabel();
        nameCategoryTextField = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        searchNameCategoryTextField = new javax.swing.JTextField();
        searchCategoryButton = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        descriptionCategoryLabel = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        updateSearchNameCategoryTextField = new javax.swing.JTextField();
        updateSearchCategoryButton = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        updateNameCategoryTextField = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        addCategoryButton = new javax.swing.JButton();
        updateCategoryButton = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        deleteCategoryTextField = new javax.swing.JTextField();
        deleteCategoryButton = new javax.swing.JButton();
        addCategoryLabel = new javax.swing.JLabel();
        searchCategoryLabel = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        updateDescriptionCategoryTextField = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionCategoryTextField = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel96 = new javax.swing.JLabel();
        nameProductTextField = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        unitValueTextField = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        totalWeightTextField = new javax.swing.JTextField();
        descriptionProductTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        imageProductTextField = new javax.swing.JTextField();
        searchImageProductButton = new javax.swing.JButton();
        addProductButton = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        searchProductTextField = new javax.swing.JTextField();
        searchProductButton = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        unitMeasuredComboBox = new javax.swing.JComboBox<>();
        jLabel109 = new javax.swing.JLabel();
        totalWeightLabel = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        updateSearchProductTextField = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        updateNameProductTextField = new javax.swing.JTextField();
        updateSearchProductButton = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        deleteProductTextField = new javax.swing.JTextField();
        deleteProductButton = new javax.swing.JButton();
        updateImageProductTextField = new javax.swing.JTextField();
        updateUnitValueTextField = new javax.swing.JTextField();
        updateWeightTextField = new javax.swing.JTextField();
        updateDescriptionTextField = new javax.swing.JTextField();
        updatePriceTextField = new javax.swing.JTextField();
        updateCategoryComboBox = new javax.swing.JComboBox<>();
        updateUnitMeasuredComboBox = new javax.swing.JComboBox<>();
        unitMeasuredLabel = new javax.swing.JLabel();
        unitValueLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        batchLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        batchCodeComboBox = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        updateImageProductButton = new javax.swing.JButton();
        jLabel133 = new javax.swing.JLabel();
        updateProductButton = new javax.swing.JButton();
        updateBatchCodeProduct = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        cellarNameTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        latitudeCellarTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        LenghtCellarTextField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        distanceCellarTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        imageCellarTextField = new javax.swing.JTextField();
        addImageCellarButton = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        searchCellarTextField = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        latitudeCellarLabel = new javax.swing.JLabel();
        searchCellarButton = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        lenghtCellarLabel = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        distanceCellarLabel = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        imageCellarLabel = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        updateSearchCellarTextField = new javax.swing.JTextField();
        updateSearchCellarButton = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        updateNameCellarTextField = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        updateLatitudeCellarTextField = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        updateLenghtTextField = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        updateDistanceTextField = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        updateImageTextField = new javax.swing.JTextField();
        updateImageCellarButton = new javax.swing.JButton();
        addCellarButton = new javax.swing.JButton();
        updateCellarButton = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        deleteCellarTextField = new javax.swing.JTextField();
        deleteCellarButton = new javax.swing.JButton();
        jLabel146 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        returnAdministratorButton = new javax.swing.JButton();

        jTextField15.setText("jTextField15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento");

        jPanel1.setBackground(new java.awt.Color(153, 204, 153));

        jTabbedPane1.setBackground(new java.awt.Color(153, 204, 153));

        jPanel2.setBackground(new java.awt.Color(153, 204, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Agregar");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 21, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Buscar");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Actualizar");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Borrar");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, 303));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, 309));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, 319));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Nombre:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 39, -1, -1));

        nameTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 64, 160, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Rol:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 95, -1, -1));

        comboBoxRole.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(comboBoxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 127, 160, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Usuario:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 165, -1, -1));

        userTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(userTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 197, 160, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Contraseña:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 235, -1, -1));

        passwordTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(passwordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 260, 160, -1));

        addUserButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addUserButton.setText("Agregar");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });
        jPanel2.add(addUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Nombre usuario:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Rol:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        roleLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel2.add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 171, 17));

        serchName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(serchName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 171, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Nombre:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        userNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(userNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 171, 23));

        serchUserButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        serchUserButton.setText("Buscar");
        serchUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serchUserButtonActionPerformed(evt);
            }
        });
        jPanel2.add(serchUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Nombre:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        updateUserTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(updateUserTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 175, -1));

        updateSearchUserButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        updateSearchUserButton.setText("Buscar");
        updateSearchUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchUserButtonActionPerformed(evt);
            }
        });
        jPanel2.add(updateSearchUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Nombre:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        updateNameUserTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(updateNameUserTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 156, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Rol:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        updateRoleUserComboBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(updateRoleUserComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 156, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Usuario:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));

        updateUserNameTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(updateUserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 156, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Contraseña:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, -1, -1));

        updatePasswordTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(updatePasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 156, -1));

        updateUserButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        updateUserButton.setText("Actualizar");
        updateUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserButtonActionPerformed(evt);
            }
        });
        jPanel2.add(updateUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Nombre:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, -1, -1));

        deleteUserTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(deleteUserTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, 150, -1));

        deleteUserButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        deleteUserButton.setText("Borrar");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });
        jPanel2.add(deleteUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, -1, -1));
        jPanel2.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 220, 20));
        jPanel2.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 250, 30));
        jPanel2.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 260, 20));
        jPanel2.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, 220, 20));

        jTabbedPane1.addTab("Usuarios", jPanel2);

        jPanel4.setBackground(new java.awt.Color(153, 204, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel44.setText("Agregar");
        jPanel4.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel45.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel45.setText("Buscar");
        jPanel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        jLabel46.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel46.setText("Actualizar");
        jPanel4.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        jLabel47.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel47.setText("Borrar");
        jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, -1, -1));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, 253));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, 253));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, -1, 253));

        jLabel48.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel48.setText("Placa:");
        jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 62, -1, -1));

        plateTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.add(plateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 172, -1));

        jLabel49.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel49.setText("Capacidad mínima:");
        jPanel4.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        MinCapacityComboBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel4.add(MinCapacityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 50, -1));

        jLabel50.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel50.setText("Fotografía:");
        jPanel4.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        imageTransportUnitTextField.setEditable(false);
        imageTransportUnitTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.add(imageTransportUnitTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 72, -1));

        searchImageTransportUnit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        searchImageTransportUnit.setText("Buscar");
        searchImageTransportUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchImageTransportUnitActionPerformed(evt);
            }
        });
        jPanel4.add(searchImageTransportUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        addTransportUnitButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addTransportUnitButton.setText("Agregar");
        addTransportUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTransportUnitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(addTransportUnitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        jLabel51.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel51.setText("Placa:");
        jPanel4.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

        searchPlateTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.add(searchPlateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 129, -1));

        jLabel52.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel52.setText("Capacidad:");
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        capacityTransportUnitLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel4.add(capacityTransportUnitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 118, 14));

        jLabel54.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel54.setText("Fotografía:");
        jPanel4.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));
        jPanel4.add(imageTransportUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 110, 80));

        jLabel56.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel56.setText("Placa:");
        jPanel4.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        searchUpdateTransportTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.add(searchUpdateTransportTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 132, -1));

        updateSearchPlateButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        updateSearchPlateButton.setText("Buscar");
        updateSearchPlateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchPlateButtonActionPerformed(evt);
            }
        });
        jPanel4.add(updateSearchPlateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, -1, -1));

        jLabel57.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel57.setText("Placa:");
        jPanel4.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, -1));

        plateTransportUnitTexField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.add(plateTransportUnitTexField, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 131, -1));

        jLabel58.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel58.setText("Capacidad mínima:");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 120, -1));

        updateMinCapacityComboBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel4.add(updateMinCapacityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 40, -1));

        jLabel59.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel59.setText("Fotografía:");
        jPanel4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, -1, -1));

        updateImageTransport.setEditable(false);
        updateImageTransport.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.add(updateImageTransport, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 73, -1));

        updateImageTransportUnit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        updateImageTransportUnit.setText("Buscar");
        updateImageTransportUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateImageTransportUnitActionPerformed(evt);
            }
        });
        jPanel4.add(updateImageTransportUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 250, -1, -1));

        updateTransportUnitButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        updateTransportUnitButton.setText("Actualizar");
        updateTransportUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTransportUnitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(updateTransportUnitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, -1, -1));

        jLabel60.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel60.setText("Placa:");
        jPanel4.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, -1, -1));

        deleteTransportTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.add(deleteTransportTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 100, 150, -1));

        deleteTransportUnitButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        deleteTransportUnitButton.setText("Borrar");
        deleteTransportUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTransportUnitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(deleteTransportUnitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 140, -1, -1));

        searchTransportUnitButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        searchTransportUnitButton.setText("Buscar");
        searchTransportUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTransportUnitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(searchTransportUnitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));
        jPanel4.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 270, 20));

        jLabel140.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel140.setText("Capacidad máxima:");
        jPanel4.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        MaxCapacityComboBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel4.add(MaxCapacityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 50, 20));

        jLabel141.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel141.setText("toneladas");
        jPanel4.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 70, 20));

        jLabel142.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel142.setText("toneladas");
        jPanel4.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 80, -1));
        jPanel4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 280, 20));

        jLabel55.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel55.setText("toneladas");
        jPanel4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, -1, -1));

        jLabel143.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel143.setText("Capacidad máxima:");
        jPanel4.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 110, -1));

        updateMaxCapacityComboBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel4.add(updateMaxCapacityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 40, -1));

        jLabel144.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel144.setText("toneladas");
        jPanel4.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, -1, -1));
        jPanel4.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, 220, 20));
        jPanel4.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 270, 20));

        jTabbedPane1.addTab("Transporte", jPanel4);

        jPanel5.setBackground(new java.awt.Color(153, 204, 153));

        jLabel61.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel61.setText("Agregar");

        jLabel62.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel62.setText("Buscar");

        jLabel63.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel63.setText("Actualizar");

        jLabel64.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel64.setText("Borrar");

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel65.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel65.setText("Código lote:");

        codeBatchTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel66.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel66.setText("Fecha empacado:");

        jLabel68.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel68.setText("Fecha vencimiento:");

        jLabel69.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel69.setText("Código lote:");

        searchBatchCodeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        searchBatchButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        searchBatchButton.setText("Buscar");
        searchBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBatchButtonActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel70.setText("Fecha empacado:");

        packedDateLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel72.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel72.setText("Fecha vencimiento:");

        expirationDateLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel74.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel74.setText("Código lote:");

        updateSearchBatchCodeTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        updateSearchBatchButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        updateSearchBatchButton.setText("Buscar");
        updateSearchBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchBatchButtonActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel75.setText("Código lote:");

        batchCodeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel77.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel77.setText("Fecha vencimiento:");

        updateBatchButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        updateBatchButton.setText("Actualizar");
        updateBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBatchButtonActionPerformed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel78.setText("Código lote:");

        deleteBatchTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        deleteBatchButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        deleteBatchButton.setText("Borrar");
        deleteBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBatchButtonActionPerformed(evt);
            }
        });

        addBatchButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addBatchButton.setText("Agregar");
        addBatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBatchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel61))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel65)
                                            .addComponent(codeBatchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel66)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel68)
                                            .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addBatchButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel62)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel70)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel69)
                                            .addGap(49, 49, 49)
                                            .addComponent(searchBatchCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel72))
                                    .addComponent(searchBatchButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(packedDateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(expirationDateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(95, 95, 95)
                                            .addComponent(jLabel63))
                                        .addComponent(updateSearchBatchButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel74)
                                            .addComponent(jLabel75)
                                            .addComponent(jLabel77))
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(updateSearchBatchCodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                                    .addComponent(batchCodeLabel)))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(expirationDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(updateBatchButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel64))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel78)))
                                .addGap(96, 96, 96))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(deleteBatchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteBatchButton)
                                        .addGap(2, 2, 2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel78)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(deleteBatchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteBatchButton))
                                .addGap(67, 67, 67)
                                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel74)
                                            .addComponent(updateSearchBatchCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(updateSearchBatchButton)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel75)
                                            .addComponent(batchCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel77))
                                    .addComponent(expirationDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateBatchButton))
                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel69)
                                    .addComponent(searchBatchCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBatchButton)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel70)
                                .addGap(18, 18, 18)
                                .addComponent(packedDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel72)
                                .addGap(34, 34, 34)
                                .addComponent(expirationDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel65)
                                .addGap(18, 18, 18)
                                .addComponent(codeBatchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel66)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel68)
                                .addGap(18, 18, 18)
                                .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addBatchButton)))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lotes", jPanel5);

        jPanel6.setBackground(new java.awt.Color(153, 204, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel79.setText("Agregar");
        jPanel6.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 20, -1, -1));

        jLabel80.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel80.setText("Buscar");
        jPanel6.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel81.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel81.setText("Actualizar");
        jPanel6.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        jLabel82.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel82.setText("Borrar");
        jPanel6.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(972, 20, -1, -1));

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 40, -1, 258));

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, 258));

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(857, 40, -1, 258));

        jLabel83.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel83.setText("Nombre:");
        jPanel6.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        nameCategoryTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel6.add(nameCategoryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 130, -1));

        jLabel84.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel84.setText("Descripción:");
        jPanel6.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel85.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel85.setText("Nombre:");
        jPanel6.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 66, -1, -1));

        searchNameCategoryTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel6.add(searchNameCategoryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 63, 116, -1));

        searchCategoryButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        searchCategoryButton.setText("Buscar");
        searchCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCategoryButtonActionPerformed(evt);
            }
        });
        jPanel6.add(searchCategoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jLabel86.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel86.setText("Descripción:");
        jPanel6.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 162, -1, -1));

        descriptionCategoryLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel6.add(descriptionCategoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 210, 110));

        jLabel88.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel88.setText("Nombre:");
        jPanel6.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 60, -1, -1));

        updateSearchNameCategoryTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel6.add(updateSearchNameCategoryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 57, 113, -1));

        updateSearchCategoryButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        updateSearchCategoryButton.setText("Buscar");
        updateSearchCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchCategoryButtonActionPerformed(evt);
            }
        });
        jPanel6.add(updateSearchCategoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, -1, -1));

        jLabel89.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel89.setText("Nombre:");
        jPanel6.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 129, -1, -1));

        updateNameCategoryTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel6.add(updateNameCategoryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 154, 120, -1));

        jLabel90.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel90.setText("Descripción:");
        jPanel6.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 192, -1, -1));

        addCategoryButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addCategoryButton.setText("Agregar");
        addCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryButtonActionPerformed(evt);
            }
        });
        jPanel6.add(addCategoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        updateCategoryButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        updateCategoryButton.setText("Actualizar");
        updateCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCategoryButtonActionPerformed(evt);
            }
        });
        jPanel6.add(updateCategoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, -1, -1));

        jLabel91.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel91.setText("Nombre:");
        jPanel6.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 55, -1, -1));

        deleteCategoryTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel6.add(deleteCategoryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(952, 52, 108, -1));

        deleteCategoryButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        deleteCategoryButton.setText("Borrar");
        deleteCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCategoryButtonActionPerformed(evt);
            }
        });
        jPanel6.add(deleteCategoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, -1, -1));
        jPanel6.add(addCategoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 220, 19));
        jPanel6.add(searchCategoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 335, 260, 22));
        jPanel6.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 316, 230, 19));
        jPanel6.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, 244, 26));

        updateDescriptionCategoryTextField.setColumns(20);
        updateDescriptionCategoryTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        updateDescriptionCategoryTextField.setRows(5);
        jScrollPane1.setViewportView(updateDescriptionCategoryTextField);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 190, 100));

        descriptionCategoryTextField.setColumns(20);
        descriptionCategoryTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        descriptionCategoryTextField.setRows(5);
        jScrollPane2.setViewportView(descriptionCategoryTextField);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 120));

        jTabbedPane1.addTab("Categorías", jPanel6);

        jPanel7.setBackground(new java.awt.Color(153, 204, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel92.setText("Agregar");
        jPanel7.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel93.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel93.setText("Buscar");
        jPanel7.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel94.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel94.setText("Actualizar");
        jPanel7.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jLabel95.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel95.setText("Borrar");
        jPanel7.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, -1, -1));

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 21, -1, 271));

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 21, -1, 267));

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, 11, 267));

        jLabel96.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel96.setText("Nombre:");
        jPanel7.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        nameProductTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(nameProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 114, -1));

        jLabel97.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel97.setText("Unidad medida:");
        jPanel7.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 88, -1));

        jLabel98.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel98.setText("Valor unidad:");
        jPanel7.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 75, -1));

        unitValueTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(unitValueTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 114, -1));

        jLabel99.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel99.setText("Peso total:");
        jPanel7.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel100.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel100.setText("Descripción:");
        jPanel7.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel101.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel101.setText("Lote:");
        jPanel7.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel102.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel102.setText("Categoría:");
        jPanel7.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel103.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel103.setText("Precio:");
        jPanel7.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel104.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel104.setText("Fotografía:");
        jPanel7.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        totalWeightTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(totalWeightTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 114, -1));

        descriptionProductTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(descriptionProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 114, -1));

        priceTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(priceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 114, -1));

        imageProductTextField.setEditable(false);
        imageProductTextField.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(imageProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 50, -1));

        searchImageProductButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        searchImageProductButton.setText("Buscar");
        searchImageProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchImageProductButtonActionPerformed(evt);
            }
        });
        jPanel7.add(searchImageProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 70, -1));

        addProductButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        addProductButton.setText("Agregar");
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });
        jPanel7.add(addProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        jLabel105.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel105.setText("Nombre:");
        jPanel7.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        categoryComboBox.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(categoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 110, -1));

        searchProductTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(searchProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 130, -1));

        searchProductButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        searchProductButton.setText("Buscar");
        searchProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductButtonActionPerformed(evt);
            }
        });
        jPanel7.add(searchProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jLabel106.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel106.setText("Unidad medida:");
        jPanel7.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel108.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel108.setText("Valor unidad:");
        jPanel7.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        unitMeasuredComboBox.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(unitMeasuredComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 110, -1));

        jLabel109.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel109.setText("Peso total:");
        jPanel7.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        totalWeightLabel.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(totalWeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 120, 20));

        jLabel111.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel111.setText("Descripción:");
        jPanel7.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        jLabel113.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel113.setText("Lote:");
        jPanel7.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        jLabel115.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel115.setText("Categoría:");
        jPanel7.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        jLabel117.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel117.setText("Precio:");
        jPanel7.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        jLabel119.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel119.setText("Fotografía:");
        jPanel7.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        jLabel121.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel121.setText("Nombre:");
        jPanel7.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        updateSearchProductTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(updateSearchProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 120, -1));

        jLabel122.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel122.setText("Nuevo nombre:");
        jPanel7.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        updateNameProductTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(updateNameProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 120, -1));

        updateSearchProductButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        updateSearchProductButton.setText("Buscar");
        updateSearchProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchProductButtonActionPerformed(evt);
            }
        });
        jPanel7.add(updateSearchProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, -1, -1));

        jLabel123.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel123.setText("Unidad medida:");
        jPanel7.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        jLabel124.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel124.setText("Valor unidad:");
        jPanel7.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, -1));

        jLabel125.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel125.setText("Peso total:");
        jPanel7.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        jLabel126.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel126.setText("Descripción:");
        jPanel7.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, -1));

        jLabel127.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel127.setText("Lote:");
        jPanel7.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        jLabel128.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel128.setText("Categoría:");
        jPanel7.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, -1, -1));

        jLabel129.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel129.setText("Precio:");
        jPanel7.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, -1, 20));

        jLabel130.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel130.setText("Fotografía:");
        jPanel7.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, -1));

        jLabel131.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel131.setText("Nombre:");
        jPanel7.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, -1, -1));

        deleteProductTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(deleteProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, 130, -1));

        deleteProductButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        deleteProductButton.setText("Borrar");
        deleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductButtonActionPerformed(evt);
            }
        });
        jPanel7.add(deleteProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, -1, -1));

        updateImageProductTextField.setEditable(false);
        updateImageProductTextField.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(updateImageProductTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 80, -1));

        updateUnitValueTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(updateUnitValueTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 120, -1));

        updateWeightTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(updateWeightTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 110, -1));

        updateDescriptionTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(updateDescriptionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 110, -1));

        updatePriceTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(updatePriceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 80, -1));

        updateCategoryComboBox.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(updateCategoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, 80, -1));

        updateUnitMeasuredComboBox.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(updateUnitMeasuredComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 120, -1));

        unitMeasuredLabel.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(unitMeasuredLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 100, 20));

        unitValueLabel.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(unitValueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 120, 20));

        descriptionLabel.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 100, 20));

        batchLabel.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(batchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 100, 20));

        categoryLabel.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(categoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 120, 20));

        priceLabel.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 120, 20));
        jPanel7.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 120, 60));

        batchCodeComboBox.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(batchCodeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 110, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel7.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 240, 40));
        jPanel7.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 240, 20));
        jPanel7.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 240, 20));

        updateImageProductButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        updateImageProductButton.setText("Buscar");
        updateImageProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateImageProductButtonActionPerformed(evt);
            }
        });
        jPanel7.add(updateImageProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, -1, -1));

        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, 260, 20));

        updateProductButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        updateProductButton.setText("Actualizar");
        updateProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProductButtonActionPerformed(evt);
            }
        });
        jPanel7.add(updateProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 320, -1, -1));

        updateBatchCodeProduct.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel7.add(updateBatchCodeProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 110, -1));

        jTabbedPane1.addTab("Productos", jPanel7);

        jPanel3.setBackground(new java.awt.Color(153, 204, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Agregar");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Buscar");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Actualizar");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Borrar");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 22, -1, 280));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, 280));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, 280));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setText("Nombre:");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, -1, -1));

        cellarNameTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(cellarNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 48, 151, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Latitud:");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, -1, -1));

        latitudeCellarTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(latitudeCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, 151, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("Longitud:");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        LenghtCellarTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(LenghtCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 151, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Distancia:");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 186, -1, -1));

        distanceCellarTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(distanceCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 218, 151, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("Fotografía:");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 249, -1, -1));

        imageCellarTextField.setEditable(false);
        imageCellarTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(imageCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, 62, -1));

        addImageCellarButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        addImageCellarButton.setText("Buscar");
        addImageCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImageCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addImageCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 274, -1, -1));

        jLabel28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel28.setText("Nombre:");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 46, -1, -1));

        searchCellarTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(searchCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 43, 153, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setText("Latitud:");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 100, -1, -1));

        latitudeCellarLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(latitudeCellarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 140, 20));

        searchCellarButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        searchCellarButton.setText("Buscar");
        searchCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(searchCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 69, -1, -1));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setText("Longitud:");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 143, -1, -1));

        lenghtCellarLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(lenghtCellarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 140, 20));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel33.setText("Distancia:");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 186, -1, -1));

        distanceCellarLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(distanceCellarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 140, 20));

        jLabel35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel35.setText("Fotografía:");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 230, -1, -1));

        imageCellarLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(imageCellarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 140, 90));

        jLabel37.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel37.setText("Nombre:");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        updateSearchCellarTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(updateSearchCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 149, -1));

        updateSearchCellarButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        updateSearchCellarButton.setText("Buscar");
        updateSearchCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSearchCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateSearchCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, -1, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel38.setText("Nombre:");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        updateNameCellarTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(updateNameCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 149, -1));

        jLabel39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel39.setText("Latitud:");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        updateLatitudeCellarTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(updateLatitudeCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 149, -1));

        jLabel40.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel40.setText("Longitud:");
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        updateLenghtTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(updateLenghtTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 149, -1));

        jLabel41.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel41.setText("Distancia:");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, -1, -1));

        updateDistanceTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(updateDistanceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 149, -1));

        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setText("Fotografía:");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, -1));

        updateImageTextField.setEditable(false);
        updateImageTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(updateImageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 150, -1));

        updateImageCellarButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        updateImageCellarButton.setText("Buscar");
        updateImageCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateImageCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateImageCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, -1, -1));

        addCellarButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        addCellarButton.setText("Agregar");
        addCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        updateCellarButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        updateCellarButton.setText("Actualizar");
        updateCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, -1, -1));

        jLabel43.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel43.setText("Nombre:");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, -1, -1));

        deleteCellarTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.add(deleteCellarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 130, -1));

        deleteCellarButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        deleteCellarButton.setText("Borrar");
        deleteCellarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCellarButtonActionPerformed(evt);
            }
        });
        jPanel3.add(deleteCellarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 110, -1, -1));
        jPanel3.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 300, 20));
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 240, 20));
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 300, 20));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 230, 20));

        jTabbedPane1.addTab("Bodegas", jPanel3);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tuercas.png"))); // NOI18N
        jLabel1.setText("Mantenimientos");

        returnAdministratorButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                .addComponent(returnAdministratorButton)
                .addGap(34, 34, 34))
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(returnAdministratorButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnAdministratorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnAdministratorButtonActionPerformed
        Administrator administrator = new Administrator();
        administrator.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_returnAdministratorButtonActionPerformed

    private void updateImageCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateImageCellarButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = file.toString();
            Path origin = Paths.get(path);
            Path destiny = Paths.get(origin.getFileName().toString());

            try {
                if (Files.exists(destiny)) {
                    updateImageTextField.setText(destiny.toString());
                }
                Files.copy(origin, destiny, StandardCopyOption.COPY_ATTRIBUTES);
                updateImageTextField.setText(destiny.toString());
            } catch (IOException ex) {
            }
        } else {
            jLabel32.setText("Debe seleccionar un archivo.");
        }
    }//GEN-LAST:event_updateImageCellarButtonActionPerformed

    private void addCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCellarButtonActionPerformed
        try {
            if(crudMaintenance.existsCellar(cellarNameTextField.getText())) {
                jLabel146.setText("La bodega ya se encuentra registrada.");
            } else if(cellarNameTextField.getText().equals("") || latitudeCellarTextField.getText().equals("") || LenghtCellarTextField.getText().equals("")
                    || distanceCellarTextField.getText().equals("") || imageCellarTextField.getText().equals("")) {
                jLabel146.setText("Ingrese todos los datos.");
            } else {
                crudMaintenance.addCellar(cellarNameTextField.getText(), latitudeCellarTextField.getText(), LenghtCellarTextField.getText(), Float.valueOf(distanceCellarTextField.getText()), imageCellarTextField.getText());
                jLabel146.setText("Bodega agregada.");
                cellarNameTextField.setText("");
                latitudeCellarTextField.setText("");
                LenghtCellarTextField.setText("");
                distanceCellarTextField.setText("");
                imageCellarTextField.setText("");
            }
        } catch (GraphException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException numberFormatException) {
            jLabel146.setText("Ingrese una distancia válida.");
        }
    }//GEN-LAST:event_addCellarButtonActionPerformed

    private void deleteTransportUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTransportUnitButtonActionPerformed
        if(crudMaintenance.existsTransportUnit(deleteTransportTextField.getText())) {
            crudMaintenance.deleteTransportUnit(deleteTransportTextField.getText());
            jLabel145.setText("Unidad eliminada.");
        } else {
            jLabel145.setText("La unidad no se encuentra registrada.");
        }
    }//GEN-LAST:event_deleteTransportUnitButtonActionPerformed

    private void searchBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBatchButtonActionPerformed
       jLabel71.setText("");
        Batch batch = crudMaintenance.getBatch(searchBatchCodeLabel.getText());
        if(crudMaintenance.existsBatch(searchBatchCodeLabel.getText())) {
            packedDateLabel.setText(batch.getPackedDate().toString());
            expirationDateLabel.setText(batch.getExpirationDate().toString());
        } else {
            jLabel71.setText("El lote no se encuentra registrado.");
            packedDateLabel.setText("");
            expirationDateLabel.setText("");
        }
    }//GEN-LAST:event_searchBatchButtonActionPerformed

    private void updateSearchBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchBatchButtonActionPerformed
        jLabel73.setText("");
        if(crudMaintenance.existsBatch(updateSearchBatchCodeTextField.getText())) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Batch bacth = crudMaintenance.getBatch(updateSearchBatchCodeTextField.getText());
                batchCodeLabel.setText(bacth.getBatchCode());
                expirationDatePicker.setDate(dateFormat.parse(bacth.getExpirationDate()));
            } catch (ParseException ex) {
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
       } else {
           jLabel73.setText("El lote no se encuentra registrado");
           
       }
    }//GEN-LAST:event_updateSearchBatchButtonActionPerformed

    private void deleteBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBatchButtonActionPerformed
        if(crudMaintenance.existsBatch(deleteBatchTextField.getText())) {
            crudMaintenance.deleteBacth(deleteBatchTextField.getText());
            jLabel76.setText("Lote eliminado");
            deleteBatchTextField.setText("");
        } else {
            jLabel76.setText("El lote no se encuentra registrado");
            
        }
    }//GEN-LAST:event_deleteBatchButtonActionPerformed

    private void deleteProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductButtonActionPerformed
        
        try {
            if (crudMaintenance.existsProduct(deleteProductTextField.getText())) {
                try {
                    crudMaintenance.deleteProduct(deleteProductTextField.getText());
                    jLabel133.setText("Producto eliminado.");
                } catch (TreeException ex) {
                    Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                jLabel133.setText("El producto no se encuentra registrado.");
            }
        } catch (TreeException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_deleteProductButtonActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        if(crudMaintenance.existsUser(userTextField.getText())) {
            jLabel114.setText("El usuario ya se encuentra registrado.");
        } else if(nameTextField.getText().equals("") || comboBoxRole.getSelectedItem().toString().equals("") || userTextField.getText().equals("") 
                || passwordTextField.getText().equals("")) {
            jLabel114.setText("Ingrese todos los datos.");
        } else {
            crudMaintenance.addUser(nameTextField.getText(), comboBoxRole.getSelectedItem().toString(), userTextField.getText(), passwordTextField.getText());
            jLabel114.setText("Usuario agregado.");
            nameTextField.setText("");
            userTextField.setText("");
            passwordTextField.setText("");
        }
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void addCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryButtonActionPerformed
        if (crudMaintenance.existsCategory(nameCategoryTextField.getText()) == true) {
            addCategoryLabel.setText("La categoría ya existe.");
        } else if (nameCategoryTextField.getText().equals("") || descriptionCategoryTextField.getText().equals("")) {
            addCategoryLabel.setText("Ingrese los datos.");
        } else {
            crudMaintenance.addCategory(nameCategoryTextField.getText(), descriptionCategoryTextField.getText());
            addCategoryLabel.setText("Categoría agregada.");
            nameCategoryTextField.setText("");
            descriptionCategoryTextField.setText("");
        }
    }//GEN-LAST:event_addCategoryButtonActionPerformed

    private void searchCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCategoryButtonActionPerformed
        searchCategoryLabel.setText("");
        try {
            Category category = crudMaintenance.getCategory(searchNameCategoryTextField.getText());
            if (searchNameCategoryTextField.getText().equals(category.getName())) {
                jLabel107.setText("");
                descriptionCategoryLabel.setText("<html><p>" + category.getDescription() +"</html></p>");
            } else {
                jLabel107.setText("La categoría no se encuentra registrada.");
            }
        } catch (NullPointerException nullPointerException) {
            jLabel107.setText("La categoría no se encuentra registrada.");
            descriptionCategoryLabel.setText("");
        }
    }//GEN-LAST:event_searchCategoryButtonActionPerformed

    private void updateSearchCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchCategoryButtonActionPerformed
        searchCategoryLabel.setText("");
        if(crudMaintenance.existsCategory(updateSearchNameCategoryTextField.getText())) {
            Category category = crudMaintenance.getCategory(updateSearchNameCategoryTextField.getText());
            updateNameCategoryTextField.setText(category.getName());
            updateDescriptionCategoryTextField.setLineWrap(true);
            updateDescriptionCategoryTextField.setText(category.getDescription());     
        } else {
            searchCategoryLabel.setText("La categoría no se encuentra registrada.");
            updateNameCategoryTextField.setText("");
            updateDescriptionCategoryTextField.setText("");
        }
    }//GEN-LAST:event_updateSearchCategoryButtonActionPerformed

    private void updateCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCategoryButtonActionPerformed
        if (updateNameCategoryTextField.getText().equals("") || updateDescriptionCategoryTextField.getText().equals("")) {
            searchCategoryLabel.setText("Ingrese todos los datos.");
        } else if (crudMaintenance.existsCategory(updateSearchNameCategoryTextField.getText())){
            crudMaintenance.updateCategory(updateSearchNameCategoryTextField.getText(), updateNameCategoryTextField.getText(), updateDescriptionCategoryTextField.getText());
            searchCategoryLabel.setText("Información actualizada.");
            updateSearchNameCategoryTextField.setText("");
            updateNameCategoryTextField.setText("");
            updateDescriptionCategoryTextField.setText("");
        } else {
            searchCategoryLabel.setText("La categoría no se encuentra registrada.");
        }
    }//GEN-LAST:event_updateCategoryButtonActionPerformed

    private void deleteCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCategoryButtonActionPerformed
        if(crudMaintenance.existsCategory(deleteCategoryTextField.getText())) {
            crudMaintenance.deleteCategory(deleteCategoryTextField.getText());
            jLabel112.setText("Categoría eliminada.");
            deleteCategoryTextField.setText("");
        } else {
            jLabel112.setText("La categoría no se encuentra registrada.");
        }
    }//GEN-LAST:event_deleteCategoryButtonActionPerformed

    private void serchUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serchUserButtonActionPerformed
        jLabel118.setText("");
        try {
        User user = crudMaintenance.getUser(serchName.getText());
        if(crudMaintenance.existsUser(serchName.getText())) {
            roleLabel.setText(user.getRole());
            userNameLabel.setText(user.getName());
        } else {
            jLabel118.setText("El usuario no se encuentra registrado.");
        }
        } catch (NullPointerException nullPointerException) {
            jLabel118.setText("Ingrese todos los datos.");
        } 
    }//GEN-LAST:event_serchUserButtonActionPerformed

    private void updateSearchUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchUserButtonActionPerformed
       jLabel116.setText("");
        if(crudMaintenance.existsUser(updateUserTextField.getText())) {
           User user = crudMaintenance.getUser(updateUserTextField.getText());
           updateNameUserTextField.setText(user.getName());
           updateRoleUserComboBox.setSelectedItem(user.getRole());
           updateUserNameTextField.setText(user.getUser());
       } else {
           jLabel116.setText("El usuario no se encuentra registrado.");
       }
    }//GEN-LAST:event_updateSearchUserButtonActionPerformed

    private void updateUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserButtonActionPerformed
        jLabel116.setText("");
        if(updateNameUserTextField.getText().equals("") || updateRoleUserComboBox.getSelectedItem().toString().equals("") 
                || updateUserNameTextField.getText().equals("") || updatePasswordTextField.getText().equals("")) {
            jLabel116.setText("Ingrese todos los datos.");
        } else  if(crudMaintenance.existsUser(updateUserTextField.getText())){
            crudMaintenance.updateUser(updateUserTextField.getText(), updateNameUserTextField.getText(), 
                    updateRoleUserComboBox.getSelectedItem().toString(), updateUserNameTextField.getText(), updatePasswordTextField.getText());
            jLabel116.setText("Información actualizada.");
            updateUserTextField.setText("");
            updateNameUserTextField.setText("");
            updateUserNameTextField.setText("");
            updatePasswordTextField.setText("");
        } else {
            jLabel116.setText("El usuario no se encuentra registrado.");
        }
    }//GEN-LAST:event_updateUserButtonActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        if(crudMaintenance.existsUser(deleteUserTextField.getText())) {
            crudMaintenance.deleteUser(deleteUserTextField.getText());
            jLabel120.setText("Usuario eliminado.");
            deleteUserTextField.setText("");
        } else {
            jLabel120.setText("El usuario no se encuentra registrado.");
        }
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    private void addTransportUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTransportUnitButtonActionPerformed
        if(crudMaintenance.existsTransportUnit(plateTextField.getText())) {
            jLabel134.setText("La unidad ya se encuentra registrada");
        } else if(plateTextField.getText().equals("") || MinCapacityComboBox.getSelectedItem().toString().equals("") || imageTransportUnitTextField.getText().equals("")) {
            jLabel134.setText("Ingrese todos los datos.");
        } else {
            if (Integer.parseInt(MinCapacityComboBox.getSelectedItem().toString()) > Integer.parseInt(MaxCapacityComboBox.getSelectedItem().toString())) {
                jLabel134.setText("La capacidad es incorrecta.");
            } else {
                crudMaintenance.addTransportUnit(plateTextField.getText(), Integer.parseInt((String) MinCapacityComboBox.getSelectedItem()), Integer.parseInt((String) MaxCapacityComboBox.getSelectedItem()), imageTransportUnitTextField.getText());
                jLabel134.setText("Unidad agregada.");
                plateTextField.setText("");
                imageTransportUnitTextField.setText("");
            }
        }
    }//GEN-LAST:event_addTransportUnitButtonActionPerformed

    private void searchImageTransportUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchImageTransportUnitActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = file.toString();
            Path origin = Paths.get(path);
            Path destiny = Paths.get(origin.getFileName().toString());
            try {
                if (Files.exists(destiny)) {
                    imageTransportUnitTextField.setText(destiny.toString());
                } else {
                    Files.copy(origin, destiny, StandardCopyOption.COPY_ATTRIBUTES);
                    imageTransportUnitTextField.setText(destiny.toString());
                }
            } catch (IOException ex) {
            }
        } else {
            jLabel70.setText("Debe seleccionar un archivo");
        }

    }//GEN-LAST:event_searchImageTransportUnitActionPerformed

    private void searchTransportUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTransportUnitButtonActionPerformed
       jLabel135.setText("");
        TransportUnit transportUnit = crudMaintenance.getTransportUnit(searchPlateTextField.getText());
        if(crudMaintenance.existsTransportUnit(searchPlateTextField.getText())) {
            capacityTransportUnitLabel.setText(transportUnit.getMinCapacity() + "-" + transportUnit.getMaxCapacity());
            ImageIcon imageIcon = new ImageIcon(transportUnit.getUrl());
            imageTransportUnit.setIcon((Icon)imageIcon);
        } else {
            jLabel135.setText("La unidad no se encuentra registrada.");
            searchPlateTextField.setText("");
            capacityTransportUnitLabel.setText("");
            imageTransportUnit.setIcon(null);
        }
    }//GEN-LAST:event_searchTransportUnitButtonActionPerformed

    private void updateImageTransportUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateImageTransportUnitActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = file.toString();
            Path origin = Paths.get(path);
            Path destiny = Paths.get(origin.getFileName().toString());

            try {
                if (Files.exists(destiny)) {
                    updateImageTransport.setText(destiny.toString());
                }
                Files.copy(origin, destiny, StandardCopyOption.COPY_ATTRIBUTES);
                updateImageTransport.setText(destiny.toString());
            } catch (IOException ex) {
            }
        } else {
            jLabel53.setText("Debe seleccionar un archivo");
        }
    }//GEN-LAST:event_updateImageTransportUnitActionPerformed

    private void updateSearchPlateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchPlateButtonActionPerformed
        if(crudMaintenance.existsTransportUnit(searchUpdateTransportTextField.getText())) {
           TransportUnit transportUnit = crudMaintenance.getTransportUnit(searchUpdateTransportTextField.getText());
           plateTransportUnitTexField.setText(transportUnit.getPlate());
           updateMinCapacityComboBox.setSelectedItem(String.valueOf(transportUnit.getMinCapacity()));
           updateMaxCapacityComboBox.setSelectedItem(String.valueOf(transportUnit.getMaxCapacity()));
           updateImageTransport.setText(transportUnit.getUrl());
       } else {
           jLabel53.setText("La unidad no se encuentra registrada.");
       }
    }//GEN-LAST:event_updateSearchPlateButtonActionPerformed

    private void updateTransportUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTransportUnitButtonActionPerformed
       if(plateTransportUnitTexField.getText().equals("") || updateImageTransport.getText().equals("")) {
           jLabel53.setText("Ingrese todos los datos.");
       } else if(crudMaintenance.existsTransportUnit(searchUpdateTransportTextField.getText())){
           if (Integer.parseInt(updateMinCapacityComboBox.getSelectedItem().toString()) > Integer.parseInt(updateMaxCapacityComboBox.getSelectedItem().toString())) {
                jLabel53.setText("La capacidad es incorrecta.");
            } else {
               crudMaintenance.updateTransportUnit(searchUpdateTransportTextField.getText(), plateTransportUnitTexField.getText(),
                       Integer.parseInt(updateMinCapacityComboBox.getSelectedItem().toString()),
                       Integer.parseInt(updateMaxCapacityComboBox.getSelectedItem().toString()), updateImageTransport.getText());
               jLabel53.setText("Información actualizada.");
               plateTransportUnitTexField.setText("");
               updateImageTransport.setText("");
           }
       }
    }//GEN-LAST:event_updateTransportUnitButtonActionPerformed

    private void addBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBatchButtonActionPerformed
        try {
            if (crudMaintenance.existsBatch(codeBatchTextField.getText())) {
                jLabel67.setText("El lote ya se encuentra registrado.");
            } else if (codeBatchTextField.getText().equals("") || jXDatePicker2.getDate().toString().equals("")) {
                jLabel67.setText("Ingrese todos los datos.");
            } else {
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minutes = calendar.get(Calendar.MINUTE);
                String expirationDate = dateFormat.format(jXDatePicker2.getDate());
                if(dateFormat.parse(expirationDate).before(dateFormat.parse(jLabel136.getText()))) {
                    jLabel67.setText("La fecha de expiración es incorrecta.");
                } else {
                    crudMaintenance.addBacth(codeBatchTextField.getText(), jLabel136.getText() + " " + hour + ":" + minutes, expirationDate);
                    jLabel67.setText("Lote agregado");
                    codeBatchTextField.setText("");
                }
            }
        } catch (NullPointerException nullPointerException) {
            jLabel67.setText("Debe ingresar todos los datos.");
        } catch (ParseException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_addBatchButtonActionPerformed

    private void updateBatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBatchButtonActionPerformed
       try {
        if(batchCodeLabel.getText().equals("") || expirationDatePicker.getDate().toString().equals("")) {
           jLabel73.setText("Debe ingresar todos los datos");
       } else if(crudMaintenance.existsBatch(updateSearchBatchCodeTextField.getText())){
           Batch batch = crudMaintenance.getBatch(updateSearchBatchCodeTextField.getText());
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String expirationDate = dateFormat.format(expirationDatePicker.getDate());
            if(dateFormat.parse(expirationDate).before(dateFormat.parse(batch.getPackedDate()))) {
                jLabel73.setText("<html><p>Fecha de vencimiento incorrecta, la fecha de empaque es: " + batch.getPackedDate()+"</html></p>");
            } else {
                crudMaintenance.updateBatch(updateSearchBatchCodeTextField.getText(), batchCodeLabel.getText(), expirationDate);
                jLabel73.setText("Información actualizada");
                updateSearchBatchCodeTextField.setText("");
                batchCodeLabel.setText("");
            }
       }
       } catch(NullPointerException nullPointerException) {
           jLabel73.setText("Debe ingresar todos los datos.");
       } catch (ParseException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateBatchButtonActionPerformed

    private void addImageCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImageCellarButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = file.toString();
            Path origin = Paths.get(path);
            Path destiny = Paths.get(origin.getFileName().toString());

            try {
                if (Files.exists(destiny)) {
                    imageCellarTextField.setText(destiny.toString());
                }
                Files.copy(origin, destiny, StandardCopyOption.COPY_ATTRIBUTES);
                imageCellarTextField.setText(destiny.toString());
            } catch (IOException ex) {
            }
        } else {
            jLabel146.setText("Debe seleccionar un archivo");
        }
    }//GEN-LAST:event_addImageCellarButtonActionPerformed

    private void searchCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCellarButtonActionPerformed
        jLabel30.setText("");
        try {
            Cellar cellar = crudMaintenance.getCellar(searchCellarTextField.getText());
            if (crudMaintenance.existsCellar(searchCellarTextField.getText())) {
                latitudeCellarLabel.setText(cellar.getLatitude());
                lenghtCellarLabel.setText(cellar.getLength());
                distanceCellarLabel.setText(String.valueOf(cellar.getDistance()));
                ImageIcon imageIcon = new ImageIcon(cellar.getUrl());
                imageCellarLabel.setIcon((Icon) imageIcon);
            } else {
                jLabel30.setText("La bodega no se encuentra registrada.");
                latitudeCellarLabel.setText("");
                lenghtCellarLabel.setText("");
                distanceCellarLabel.setText("");
                imageCellarLabel.setIcon(null);
            }
        } catch (GraphException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchCellarButtonActionPerformed

    private void updateSearchCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchCellarButtonActionPerformed
        jLabel32.setText("");
        try {
            if(crudMaintenance.existsCellar(updateSearchCellarTextField.getText())) {
                Cellar cellar = crudMaintenance.getCellar(updateSearchCellarTextField.getText());
                updateNameCellarTextField.setText(cellar.getName());
                updateLatitudeCellarTextField.setText(cellar.getLatitude());
                updateLenghtTextField.setText(cellar.getLength());
                updateDistanceTextField.setText(String.valueOf(cellar.getDistance()));
                updateImageTextField.setText(cellar.getUrl());
            } else {
                jLabel32.setText("La bodega no se encuentra registrada.");
                updateNameCellarTextField.setText("");
                updateLatitudeCellarTextField.setText("");
                updateLenghtTextField.setText("");
                updateDistanceTextField.setText("");
                updateImageTextField.setText("");
            }} catch (GraphException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateSearchCellarButtonActionPerformed

    private void updateCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCellarButtonActionPerformed
        jLabel32.setText("");
        try {
            if (updateNameCellarTextField.getText().equals("") || updateLatitudeCellarTextField.getText().equals("")
                    || updateLenghtTextField.getText().equals("") || updateDistanceTextField.getText().equals("") || updateImageTextField.getText().equals("")) {
                jLabel32.setText("Ingrese todos los datos.");
            } else if(crudMaintenance.existsCellar(updateSearchCellarTextField.getText())){
                crudMaintenance.updateCellar(updateSearchCellarTextField.getText(), updateNameCellarTextField.getText(),
                        updateLatitudeCellarTextField.getText(), updateLenghtTextField.getText(), Float.valueOf(updateDistanceTextField.getText()),
                        updateImageTextField.getText());
                jLabel32.setText("Información actualizada.");
                updateSearchCellarTextField.setText("");
                updateNameCellarTextField.setText("");
                updateLatitudeCellarTextField.setText("");
                updateLenghtTextField.setText("");
                updateDistanceTextField.setText("");
                updateImageTextField.setText("");
            }
        } catch (GraphException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException numberFormatException) {
            jLabel32.setText("Ingrese una distancia válida.");
        }
    }//GEN-LAST:event_updateCellarButtonActionPerformed

    private void deleteCellarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCellarButtonActionPerformed
        try {
            if(crudMaintenance.existsCellar(deleteCellarTextField.getText())) {
                crudMaintenance.deleteCellar(deleteCellarTextField.getText());
                jLabel34.setText("Bodega eliminada.");
            } else {
                jLabel34.setText("La bodega no se encuentra registrada.");
            }
        } catch (GraphException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteCellarButtonActionPerformed

    private void searchImageProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchImageProductButtonActionPerformed
       JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = file.toString();
            Path origin = Paths.get(path);
            Path destiny = Paths.get(origin.getFileName().toString());

            try {
                if (Files.exists(destiny)) {
                    imageProductTextField.setText(destiny.toString());
                }
                Files.copy(origin, destiny, StandardCopyOption.COPY_ATTRIBUTES);
                imageProductTextField.setText(destiny.toString());
            } catch (IOException ex) {
            }
        } else {
            jLabel36.setText("Debe seleccionar un archivo.");
        }
    }//GEN-LAST:event_searchImageProductButtonActionPerformed

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        int idBatch = 0;
        int idCategory = 0;
        try {
            for (int i = 0; i < productsBinaryTree.getSize(); i++) {
                Product product = (Product) productsBinaryTree.recorreArbol().get(i);
                if (product.getName().equals(nameProductTextField.getText())) {
                    jLabel36.setText("El producto ya existe.");
                } else {
                    Iterator iterator = batchMap.keySet().iterator();
                    while (iterator.hasNext()) {
                        Integer key = (Integer) iterator.next();
                        Batch batch = batchMap.get(key);
                        if (batchCodeComboBox.getSelectedItem().toString().equals(batch.getBatchCode())) {
                            idBatch = batch.getIdBatch();
                        }
                    }
                    Iterator iterator2 = categoryMap.keySet().iterator();
                    while (iterator2.hasNext()) {
                        String key = (String) iterator2.next();
                        Category category = categoryMap.get(key);
                        if (categoryComboBox.getSelectedItem().toString().equals(category.getName())) {
                            idCategory = category.getIdCategory();
                        }
                    }
                    crudMaintenance.addProduct(nameProductTextField.getText(), unitMeasuredComboBox.getSelectedItem().toString(),
                            Integer.parseInt(unitValueTextField.getText()),
                            Integer.parseInt(totalWeightTextField.getText()),
                            descriptionProductTextField.getText(), idBatch, idCategory, Integer.parseInt(priceTextField.getText()),
                            imageProductTextField.getText());
                    jLabel36.setText("Producto agregado.");
                    nameProductTextField.setText("");
                    unitValueTextField.setText("");
                    totalWeightTextField.setText("");
                    descriptionProductTextField.setText("");
                    priceTextField.setText("");
                    imageProductTextField.setText("");
                }
            }
        } catch (TreeException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException nullPointerException) {
            jLabel36.setText("Ingrese todos los datos.");
        } catch (NumberFormatException numberFormatException) {
        }

    }//GEN-LAST:event_addProductButtonActionPerformed

    private void searchProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductButtonActionPerformed
        jLabel110.setText("");
        try {
            String batchCode = "";
            String categoryName = "";
            Product product = crudMaintenance.getProduct(searchProductTextField.getText());
            if (crudMaintenance.existsProduct(searchProductTextField.getText())) {
                unitMeasuredLabel.setText(product.getUnitMeasured());
                unitValueLabel.setText(String.valueOf(product.getUnitValue()));
                totalWeightLabel.setText(String.valueOf(product.getTotalWeight()));
                descriptionLabel.setText(product.getDescription());
                Iterator iterator = batchMap.keySet().iterator();
                while (iterator.hasNext()) {
                    Integer key = (Integer) iterator.next();
                    Batch batch = batchMap.get(key);
                    if(product.getIdBatch() == batch.getIdBatch()) {
                        batchCode = batch.getBatchCode();
                    }
                }
                Iterator iterator2 = categoryMap.keySet().iterator();
                while (iterator2.hasNext()) {
                    String key = (String) iterator2.next();
                    Category category = categoryMap.get(key);
                    if(product.getIdCategory() == category.getIdCategory()) {
                        categoryName = category.getName();
                    }
                }
                batchLabel.setText(batchCode);
                categoryLabel.setText(categoryName);
                priceLabel.setText(String.valueOf(product.getPrice()));
                ImageIcon imageIcon = new ImageIcon(product.getUrl());
                imageLabel.setIcon((Icon) imageIcon);
            } else {
                jLabel110.setText("El producto no se encuentra registrado.");
            }
        } catch (TreeException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchProductButtonActionPerformed

    private void updateSearchProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSearchProductButtonActionPerformed
        try {
            String batchCode = "";
            String nameCategory = "";
            if (crudMaintenance.existsProduct(updateSearchProductTextField.getText())) {
                Product product = crudMaintenance.getProduct(updateSearchProductTextField.getText());
                updateNameProductTextField.setText(product.getName());
                updateUnitMeasuredComboBox.setSelectedItem(product.getUnitMeasured());
                updateUnitValueTextField.setText(String.valueOf(product.getUnitValue()));
                updateWeightTextField.setText(String.valueOf(product.getTotalWeight()));
                updateDescriptionTextField.setText(product.getDescription());
                Iterator iterator = batchMap.keySet().iterator();
                while (iterator.hasNext()) {
                    Integer key = (Integer) iterator.next();
                    Batch batch = batchMap.get(key);
                    if (product.getIdBatch() == batch.getIdBatch()) {
                        batchCode = batch.getBatchCode();
                    }
                }
                Iterator iterator2 = categoryMap.keySet().iterator();
                while (iterator2.hasNext()) {
                    String key = (String) iterator2.next();
                    Category category = categoryMap.get(key);
                    if (product.getIdCategory() == category.getIdCategory()) {
                        nameCategory = category.getName();
                    }
                }
                updateBatchCodeProduct.setSelectedItem(batchCode);
                updatePriceTextField.setText(String.valueOf(product.getPrice()));
                updateCategoryComboBox.setSelectedItem(nameCategory);
                updateImageProductTextField.setText(product.getUrl());
            } else {
                jLabel32.setText("El producto no se encuentra registrado.");
            }
        } catch (TreeException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateSearchProductButtonActionPerformed

    private void updateImageProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateImageProductButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            String path = file.toString();
            Path origin = Paths.get(path);
            Path destiny = Paths.get(origin.getFileName().toString());

            try {
                if (Files.exists(destiny)) {
                    updateImageProductTextField.setText(destiny.toString());
                }
                Files.copy(origin, destiny, StandardCopyOption.COPY_ATTRIBUTES);
                updateImageProductTextField.setText(destiny.toString());
            } catch (IOException ex) {
            }
        } else {
            jLabel132.setText("Debe seleccionar un archivo.");
        }
    }//GEN-LAST:event_updateImageProductButtonActionPerformed

    private void updateProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProductButtonActionPerformed
        int idCategory = 0;
        int idBatch = 0;
        if (updateNameProductTextField.getText().equals("") || updatePriceTextField.getText().equals("")
                    || updateUnitValueTextField.getText().equals("") || updateWeightTextField.getText().equals("") || updateDescriptionTextField.getText().equals("")
                    || updateImageProductTextField.getText().equals("")) {
                jLabel132.setText("Ingrese todos los datos.");
            } else {
            try {
                Iterator iterator = categoryMap.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    Category category = categoryMap.get(key);
                    if (updateCategoryComboBox.getSelectedItem().toString().equals(category.getName())) {
                        idCategory = category.getIdCategory();
                    }
                }
                
                Iterator iterator1 = batchMap.keySet().iterator();
                while (iterator1.hasNext()) {
                    Integer key = (Integer) iterator1.next();
                    Batch batch = batchMap.get(key);
                    if(updateBatchCodeProduct.getSelectedItem().toString().equals(batch.getBatchCode())) {
                        idBatch = batch.getIdBatch();
                    }
                }
                crudMaintenance.updateProduct(updateSearchProductTextField.getText(), updateNameProductTextField.getText(),
                        updateUnitMeasuredComboBox.getSelectedItem().toString(), Integer.parseInt(updateUnitValueTextField.getText()),
                        Integer.parseInt(updateWeightTextField.getText()), updateDescriptionTextField.getText(), idCategory,
                        Double.parseDouble(updatePriceTextField.getText()), updateImageProductTextField.getText(), idBatch);
                jLabel132.setText("Información actualizada.");
                updateSearchProductTextField.setText("");
                updateNameProductTextField.setText("");
                updateUnitValueTextField.setText("");
                updateWeightTextField.setText("");
                updateDescriptionTextField.setText("");
                updatePriceTextField.setText("");
                updateImageProductTextField.setText("");
            } catch (TreeException ex) {
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_updateProductButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Maintenance().setVisible(true);
                } catch (TreeException ex) {
                    Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LenghtCellarTextField;
    private javax.swing.JComboBox<String> MaxCapacityComboBox;
    private javax.swing.JComboBox<String> MinCapacityComboBox;
    private javax.swing.JButton addBatchButton;
    private javax.swing.JButton addCategoryButton;
    private javax.swing.JLabel addCategoryLabel;
    private javax.swing.JButton addCellarButton;
    private javax.swing.JButton addImageCellarButton;
    private javax.swing.JButton addProductButton;
    private javax.swing.JButton addTransportUnitButton;
    private javax.swing.JButton addUserButton;
    private javax.swing.JComboBox<String> batchCodeComboBox;
    private javax.swing.JTextField batchCodeLabel;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JLabel capacityTransportUnitLabel;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTextField cellarNameTextField;
    private javax.swing.JTextField codeBatchTextField;
    private javax.swing.JComboBox<String> comboBoxRole;
    private javax.swing.JButton deleteBatchButton;
    private javax.swing.JTextField deleteBatchTextField;
    private javax.swing.JButton deleteCategoryButton;
    private javax.swing.JTextField deleteCategoryTextField;
    private javax.swing.JButton deleteCellarButton;
    private javax.swing.JTextField deleteCellarTextField;
    private javax.swing.JButton deleteProductButton;
    private javax.swing.JTextField deleteProductTextField;
    private javax.swing.JTextField deleteTransportTextField;
    private javax.swing.JButton deleteTransportUnitButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JTextField deleteUserTextField;
    private javax.swing.JLabel descriptionCategoryLabel;
    private javax.swing.JTextArea descriptionCategoryTextField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionProductTextField;
    private javax.swing.JLabel distanceCellarLabel;
    private javax.swing.JTextField distanceCellarTextField;
    private javax.swing.JLabel expirationDateLabel;
    private org.jdesktop.swingx.JXDatePicker expirationDatePicker;
    private javax.swing.JLabel imageCellarLabel;
    private javax.swing.JTextField imageCellarTextField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JTextField imageProductTextField;
    private javax.swing.JLabel imageTransportUnit;
    private javax.swing.JTextField imageTransportUnitTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField15;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JLabel latitudeCellarLabel;
    private javax.swing.JTextField latitudeCellarTextField;
    private javax.swing.JLabel lenghtCellarLabel;
    private javax.swing.JTextField nameCategoryTextField;
    private javax.swing.JTextField nameProductTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel packedDateLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JTextField plateTextField;
    private javax.swing.JTextField plateTransportUnitTexField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JButton returnAdministratorButton;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton searchBatchButton;
    private javax.swing.JTextField searchBatchCodeLabel;
    private javax.swing.JButton searchCategoryButton;
    private javax.swing.JLabel searchCategoryLabel;
    private javax.swing.JButton searchCellarButton;
    private javax.swing.JTextField searchCellarTextField;
    private javax.swing.JButton searchImageProductButton;
    private javax.swing.JButton searchImageTransportUnit;
    private javax.swing.JTextField searchNameCategoryTextField;
    private javax.swing.JTextField searchPlateTextField;
    private javax.swing.JButton searchProductButton;
    private javax.swing.JTextField searchProductTextField;
    private javax.swing.JButton searchTransportUnitButton;
    private javax.swing.JTextField searchUpdateTransportTextField;
    private javax.swing.JTextField serchName;
    private javax.swing.JButton serchUserButton;
    private javax.swing.JLabel totalWeightLabel;
    private javax.swing.JTextField totalWeightTextField;
    private javax.swing.JComboBox<String> unitMeasuredComboBox;
    private javax.swing.JLabel unitMeasuredLabel;
    private javax.swing.JLabel unitValueLabel;
    private javax.swing.JTextField unitValueTextField;
    private javax.swing.JButton updateBatchButton;
    private javax.swing.JComboBox<String> updateBatchCodeProduct;
    private javax.swing.JButton updateCategoryButton;
    private javax.swing.JComboBox<String> updateCategoryComboBox;
    private javax.swing.JButton updateCellarButton;
    private javax.swing.JTextArea updateDescriptionCategoryTextField;
    private javax.swing.JTextField updateDescriptionTextField;
    private javax.swing.JTextField updateDistanceTextField;
    private javax.swing.JButton updateImageCellarButton;
    private javax.swing.JButton updateImageProductButton;
    private javax.swing.JTextField updateImageProductTextField;
    private javax.swing.JTextField updateImageTextField;
    private javax.swing.JTextField updateImageTransport;
    private javax.swing.JButton updateImageTransportUnit;
    private javax.swing.JTextField updateLatitudeCellarTextField;
    private javax.swing.JTextField updateLenghtTextField;
    private javax.swing.JComboBox<String> updateMaxCapacityComboBox;
    private javax.swing.JComboBox<String> updateMinCapacityComboBox;
    private javax.swing.JTextField updateNameCategoryTextField;
    private javax.swing.JTextField updateNameCellarTextField;
    private javax.swing.JTextField updateNameProductTextField;
    private javax.swing.JTextField updateNameUserTextField;
    private javax.swing.JPasswordField updatePasswordTextField;
    private javax.swing.JTextField updatePriceTextField;
    private javax.swing.JButton updateProductButton;
    private javax.swing.JComboBox<String> updateRoleUserComboBox;
    private javax.swing.JButton updateSearchBatchButton;
    private javax.swing.JTextField updateSearchBatchCodeTextField;
    private javax.swing.JButton updateSearchCategoryButton;
    private javax.swing.JButton updateSearchCellarButton;
    private javax.swing.JTextField updateSearchCellarTextField;
    private javax.swing.JTextField updateSearchNameCategoryTextField;
    private javax.swing.JButton updateSearchPlateButton;
    private javax.swing.JButton updateSearchProductButton;
    private javax.swing.JTextField updateSearchProductTextField;
    private javax.swing.JButton updateSearchUserButton;
    private javax.swing.JButton updateTransportUnitButton;
    private javax.swing.JComboBox<String> updateUnitMeasuredComboBox;
    private javax.swing.JTextField updateUnitValueTextField;
    private javax.swing.JButton updateUserButton;
    private javax.swing.JTextField updateUserNameTextField;
    private javax.swing.JTextField updateUserTextField;
    private javax.swing.JTextField updateWeightTextField;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
