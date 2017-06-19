package com.ekstrah.wordRank;

import java.awt.*;
import java.io.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;

public class BarChart  {
    public BarChart(String[] topTen, int[] topTenNum)
    {
        try{
            final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
            //addValue(data��, ī�װ�����->�ϳ��� �����ϸ���, �ܾ��̸�)
            for(int i = 0; i < 10 ; i++) {
                dataset.addValue(topTenNum[i], "W1", topTen[i]);
            }



            JFreeChart barChart = ChartFactory.createBarChart(
                    "Word Rank! 1~10",
                    "Word Count", "Score",
                    dataset,PlotOrientation.HORIZONTAL,
                    false, true, true);

            CategoryPlot plot = barChart.getCategoryPlot();

            Font font = plot.getDomainAxis().getLabelFont();
            // X축 라벨
            plot.getDomainAxis().setLabelFont(new Font("돋움", font.getStyle(), font.getSize()));
            // X축 도메인
            plot.getDomainAxis().setTickLabelFont(new Font("돋움", font.getStyle(), 10));

            font = plot.getRangeAxis().getLabelFont();
            // Y축 라벨
            plot.getRangeAxis().setLabelFont(new Font("돋움", font.getStyle(), font.getSize()));
            // Y축 범위
            plot.getRangeAxis().setTickLabelFont(new Font("돋움", font.getStyle(), 10));




            int width = 700; /* Width of the image */
            int height = 550; /* Height of the image */
            File BarChart = new File( "BarChart.jpeg" );
            ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
        }
        catch(IOException e)
        {
            System.out.println("Error");
        }
    }
}