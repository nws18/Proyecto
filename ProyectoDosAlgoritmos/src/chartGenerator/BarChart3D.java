/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartGenerator;

import domain.Cellar;
import domain.DistributionOrder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import tda.LoadTda;
import static tda.LoadTda.cellarGraph;
import static tda.LoadTda.distributionOrderList;

/**
 *
 * @author Wilmer Mata Nicole Fonseca Sergio Siles
 */
public class BarChart3D {
    JFreeChart barChart;
    /**
     * Método que genera charts dependiendo de las ventas de las bodegas en los últimos tres meses.
     * Mediante un addValue a un dataset definido se ingresan los datos, validando fecha actual y datos almacenados previamente.
     * @param jpanel
     * @throws IOException 
     */

    public void BarChart(JPanel jpanel) throws IOException {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String lastMonths[] = getLastMonths();
        for (int i = 0; i < cellarGraph.list().size(); i++) {
            Cellar tempCellar = (Cellar) cellarGraph.list().get(i);
            dataset.addValue(getTotalAmount(lastMonths[0], tempCellar.getIdCellar()), getMonthName(Integer.parseInt(lastMonths[0])), tempCellar.getName());
            dataset.addValue(getTotalAmount(lastMonths[1], tempCellar.getIdCellar()), getMonthName(Integer.parseInt(lastMonths[1])), tempCellar.getName());
            dataset.addValue(getTotalAmount(lastMonths[2], tempCellar.getIdCellar()), getMonthName(Integer.parseInt(lastMonths[2])), tempCellar.getName());
        }

       barChart = ChartFactory.createBarChart3D(
                "Venta por bodega de los últimos tres meses.",
                "Meses",
                "Ventas",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel = new ChartPanel(barChart);
        jpanel.setLayout(new java.awt.BorderLayout());
        jpanel.add(chartPanel, BorderLayout.CENTER);
        jpanel.validate();
    }

    public String getMonthName(int monthNumber) {
        String month = "";
        switch (monthNumber) {

            case 1:
                month = "enero";
                break;
            case 2:
                month = "febrero";
                break;
            case 3:
                month = "marzo";
                break;
            case 4:
                month = "abril";
                break;
            case 5:
                month = "mayo";
                break;
            case 6:
                month = "junio";
                break;
            case 7:
                month = "julio";
                break;
            case 8:
                month = "agosto";
                break;
            case 9:
                month = "septiembre";
                break;
            case 10:
                month = "octubre";
                break;
            case 11:
                month = "noviembre";
                break;
            case 12:
                month = "diciembre";
                break;
        }
        return month;
    }

    public String[] getLastMonths() {
        String lastMonths[] = new String[3];
        java.util.Date actualDate = new java.util.Date();
        switch (actualDate.getMonth() + 1) {
            case 1:
                lastMonths[2] = "11";
                lastMonths[1] = "12";
                lastMonths[0] = "01";
                break;
            case 2:
                lastMonths[2] = "12";
                lastMonths[1] = "01";
                lastMonths[0] = "02";
                break;
            case 3:
                lastMonths[2] = "01";
                lastMonths[1] = "02";
                lastMonths[0] = "03";
                break;
            case 4:
                lastMonths[2] = "02";
                lastMonths[1] = "03";
                lastMonths[0] = "04";
                break;
            case 5:
                lastMonths[2] = "03";
                lastMonths[1] = "04";
                lastMonths[0] = "05";
                break;
            case 6:
                lastMonths[2] = "04";
                lastMonths[1] = "05";
                lastMonths[0] = "06";
                break;
            case 7:
                lastMonths[2] = "05";
                lastMonths[1] = "06";
                lastMonths[0] = "07";
                break;
            case 8:
                lastMonths[2] = "06";
                lastMonths[1] = "07";
                lastMonths[0] = "08";
                break;
            case 9:
                lastMonths[2] = "07";
                lastMonths[1] = "08";
                lastMonths[0] = "09";
                break;
            case 10:
                lastMonths[2] = "08";
                lastMonths[1] = "09";
                lastMonths[0] = "10";
                break;
            case 11:
                lastMonths[2] = "09";
                lastMonths[1] = "10";
                lastMonths[0] = "11";
                break;
            case 12:
                lastMonths[2] = "10";
                lastMonths[1] = "11";
                lastMonths[0] = "12";
                break;
        }
        return lastMonths;
    }

    private double getTotalAmount(String month, int idCellar) {
        double amount = 0.0;
        for (int i = 0; i < distributionOrderList.size(); i++) {
            DistributionOrder tempDistributionOrder = distributionOrderList.get(i);
            String tempMonth = tempDistributionOrder.getOrderDate().substring(3, 5);
            if (tempMonth.equals(month) && tempDistributionOrder.getIdDestinyCellar() == idCellar) {
                amount = amount + tempDistributionOrder.getTotalAmount();
            }
        }
        return amount;
    }
}
