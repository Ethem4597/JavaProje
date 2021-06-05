package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class BarChart extends Chart {



    ArrayList<String> categories = new ArrayList<>();
    ArrayList<String> categories2 = new ArrayList<>();

    public BarChart(String title, String xAxisLabel) {
        super(title, xAxisLabel);

    }

    public javafx.scene.chart.BarChart createBarChart(ArrayList<Bar> bar) {
        barChart.getData().clear();
        barChart.layout();

        for (int i = 0; i < 10; i++) {
            if (i == 0)
                categories.add(bar.get(i).getCategory());
            else if (!categories.contains(bar.get(i).getCategory()))
                categories.add(bar.get(i).getCategory());
        }

        XYChart.Series<Number, String> seriler = new XYChart.Series<>();


        for (int i = 0; i < 10; i++) {
            seriler.getData().addAll(new XYChart.Data<>(bar.get(i).getValue(), bar.get(i).getName()));
        }


        //seriler.getData().get(0).setXValue(50000);


        barChart.getData().addAll(seriler);

        //barChart.getData().get(0).getData().get(0).setXValue(200000);

        seriler.getData().sort(Comparator.comparingDouble(d -> d.getXValue().doubleValue()));


        //seriler.getData().sort(Comparator.comparingDouble(d -> d.getXValue().doubleValue()));




        barChart.setLegendVisible(false);

        return barChart;

    }
}
