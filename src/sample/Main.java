package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        boolean barvisible=true;

        Pane pane = new Pane();
        pane.setPrefSize(800, 800);
        BarChart sutun = new BarChart(Read.readText(-4), Read.readText(-3));

        if (barvisible)
        {

            //sutun.createBarChart(Sort.sortBars(Bar.createBars(0,75)));

            //barchartı pencere boyutuna göre uyarlama

            pane.widthProperty().addListener((observable, oldvalue, newvalue) ->
            {
                Chart.barChart.setPrefWidth((Double) newvalue);
                //barChart.setBarGap(-(double) newvalue/20);
                //System.out.println("width  "+newvalue);
            });
            pane.heightProperty().addListener((observable, oldvalue, newvalue) ->
            {
                Chart.barChart.setPrefHeight((Double) newvalue);
                Chart.barChart.setBarGap(0);
                //barChart.setCategoryGap((double) newvalue/20);
                //System.out.println("height  "+newvalue);
            });


            pane.getChildren().add(sutun.createBarChart(Sort.sortBars(Bar.createBars(0))));


            int a = 3;


            Timeline tl = new Timeline();
            tl.getKeyFrames().add(
                    new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {


                            for (int i = 1; i <= a; i++) {
                                ArrayList<Bar> bars = new ArrayList<>();
                                bars.clear();
                                bars.addAll(Sort.sortBars(Bar.createBars(i)));
                                for (int j = 0; j < 10; j++) {
                                    Chart.barChart.getData().get(0).getData().get(j).setXValue(bars.get(j).getValue());
                                    Chart.barChart.getData().get(0).getData().get(j).setYValue(bars.get(j).getName());
                                }
                            }

                        /*
                        for (XYChart.Series<Number, String> series : sutun.barChart.getData()) {

                            for (XYChart.Data<Number, String> data : series.getData()) {
                                data.setXValue(25000+Math.random() * 10000);
                                //Sort.sortBarChart(sutun.barChart);
                            }
                        }
                        */


                        }
                    })
                    //new KeyFrame(Duration.seconds(1.0), e -> Chart.barChart.getData().get(0).getData().sort(Comparator.comparingDouble(d -> d.getXValue().doubleValue())))
            );
            tl.setCycleCount(Animation.INDEFINITE);
            tl.play();
/*
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            //System.out.println("dgfdfgh");
                            //Chart.barChart.getData().get(0).getData().sort(Comparator.comparingDouble(d -> d.getXValue().doubleValue()));
                        }
                    }));
            timeline.setCycleCount(0);//Animation.INDEFINITE);
            timeline.play();
*/

            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(pane, 800, 800));
            primaryStage.show();
        }

        else//linechart
        {

        }



    }


    public static void main(String[] args) {
        launch(args);
    }
}
