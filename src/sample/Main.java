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
import java.util.Comparator;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane =new Pane();
        BarChart sutun =new BarChart(Read.readText(-4),Read.readText(-3));
        //sutun.createBarChart(Sort.sortBars(Bar.createBars(0,75)));


        pane.widthProperty().addListener((observable, oldvalue, newvalue) ->
        {
            Chart.barChart.setPrefWidth((Double)newvalue);
            //barChart.setBarGap(-(double) newvalue/20);
            //System.out.println("width  "+newvalue);
        });
        pane.heightProperty().addListener((observable, oldvalue, newvalue) ->
        {
            Chart.barChart.setPrefHeight((Double) newvalue);
            Chart.barChart.setBarGap(-(double) newvalue/20);
            //barChart.setCategoryGap((double) newvalue/20);
            //System.out.println("height  "+newvalue);
        });


        pane.getChildren().add(sutun.createBarChart(Sort.sortBars(Bar.createBars(0))));

        //Sort.sortBars(Bar.createBars(0)).

        //Sort.sortBarChart(sutun.barChart);

        //pane.getChildren().add(sutun.createBarChart(Sort.sortBars(Bar.createBars(1))));

        //sutun.barChart.getData().get(0).getData().sort(Comparator.comparingDouble(d -> d.getXValue().doubleValue()));


        /*
        double pos1 = Chart.barChart.getData().get(0).getData().get(0).getNode().localToScene(Chart.barChart.getData().get(0).getData().get(0).getNode().getBoundsInLocal()).getMinX();
        double pos2 = Chart.barChart.getData().get(0).getData().get(6).getNode().localToScene(Chart.barChart.getData().get(0).getData().get(6).getNode().getBoundsInLocal()).getMinX();
        double diff = pos1 - pos2;
*/
        //ArrayList<Bar> barlist= new ArrayList<>();
        //barlist.addAll(Sort.sortBars(Bar.createBars(216)));


/*
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(100),
                new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent actionEvent) {



                        for (int i =0 ;i<10;i++)//toplamdaki bar sayısı
                        {
                            for (int j=0;j<Chart.barChart.getData().size();j++)//barchartın toplam seri sayısı
                            {
                                for (int k=0;k<Chart.barChart.getData().get(j).getData().size();k++)//serilerin toplam bar sayısı
                                {
                                    //Chart.barChart.getData().get(j).getData().get(k).setXValue(barlist.get(i).getValue());

                                    if (barlist.get(i).getName().equals(Chart.barChart.getData().get(j).getData().get(k).getYValue())) {
                                        Chart.barChart.getData().get(j).getData().get(k).setXValue(barlist.get(i).getValue());
                                    }

                                }
                            }

                        }
/*
                        TranslateTransition tt1 = new TranslateTransition(Duration.millis(3000), Chart.barChart.getData().get(0).getData().get(6).getNode());
                        tt1.setByY(338);
                        tt1.setCycleCount(1);
                        tt1.play();

                        TranslateTransition tt2 = new TranslateTransition(Duration.millis(3000), Chart.barChart.getData().get(0).getData().get(0).getNode());
                        tt2.setByY(-338);
                        tt2.setCycleCount(1);
                        tt2.play();

 */

                        /*
                        for (XYChart.Series<Number, String> series : sutun.barChart.getData()) {

                            for (XYChart.Data<Number, String> data : series.getData()) {
                                data.setXValue(25000+Math.random() * 10000);
                                //Sort.sortBarChart(sutun.barChart);
                            }
                        }
                        */
/*

                    }
                }));
        tl.setCycleCount(216);
        tl.play();
*/



        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 800, 700));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
