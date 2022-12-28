/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newleaderproj;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Series;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import java.lang.Comparable;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

public class userInterfaceDisplay extends ApplicationFrame {
    
    public userInterfaceDisplay(final String title) {      
        super(title);
        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        chartPanel.setMouseZoomable(true, false);
        
        setContentPane(chartPanel);
    }

    private XYDataset createDataset() {
        final XYSeries data = new XYSeries("Default Values");   

        for (int i = -100; i <= 100; i+=5) {
            try {
                data.add(i, i);
                System.out.print(data.getItems());
            }
            catch (SeriesException e) {
                System.err.println("Error adding to series");
            }
        }
        
        return new XYSeriesCollection(data);
    }
    
    private JFreeChart createChart(final XYDataset dataset) {
        return ChartFactory.createXYLineChart(
            "New Leader Spreader Simulator", 
            "Distance From 0 (feet)", 
            "Distance From 0 (feet)", 
            dataset,
            PlotOrientation.VERTICAL,
            false, 
            false, 
            false
        );
    }
}
