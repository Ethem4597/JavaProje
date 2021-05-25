package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.util.Duration;

public abstract class Chart{

    private String title;//Read.readText(-4);
    private String xAxisLabel;//Read.readText(-3);

    static public CategoryAxis cAxis=new CategoryAxis();
    static public NumberAxis nAxis=new NumberAxis();

    public static BarChart<Number,String> barChart=new BarChart(nAxis,cAxis);

    public Chart(String title, String xAxisLabel)
    {
        this.title=title;
        this.xAxisLabel=xAxisLabel;
        setCaption(title);
    }


    public String getCaption()
    {
        return this.title;
    }
    public String getxAxisLabel()
    {
        return this.xAxisLabel;
    }

    public void setCaption(String caption)
    {
        this.title=caption;
        barChart.setTitle(title);
    }
    public void setxAxisLabel(String xAxisLabel)
    {
        this.xAxisLabel=xAxisLabel;
        nAxis.setLabel(xAxisLabel);
    }

    public void reset()
    {
        this.title=null;
        this.xAxisLabel=null;
        barChart.getData().clear();
        barChart.layout();
        barChart.setTitle(title);
        nAxis.setLabel(xAxisLabel);
    }
}
