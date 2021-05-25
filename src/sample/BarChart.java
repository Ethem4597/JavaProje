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

    public BarChart(String title, String xAxisLabel) {
        super(title, xAxisLabel);

    }

/*
    public javafx.scene.chart.BarChart createBarChart(Bar[] bar)
    {
        barChart.getData().clear();
        barChart.layout();

        Collections.reverse(Arrays.asList(bar));

        ArrayList<String> categories = new ArrayList<>();

        for (int i=0;i<10;i++)
        {
            if (i==0)
                categories.add(bar[i].getCategory());
            else if (!categories.contains(bar[i].getCategory()))
                categories.add(bar[i].getCategory());
        }
        //series

        XYChart.Series<Number,String> seriler=new XYChart.Series<>();

        XYChart.Series<Number, String>[] series = Stream.<XYChart.Series<Number, String>>generate(XYChart.Series::new).limit(categories.size()).toArray(XYChart.Series[]::new);

        for (int i = 0; i < 10; i++)
        {
            seriler.getData().addAll(new XYChart.Data<>(0, bar[i].getName()));
            seriler.setName(bar[i].getCategory());
        }

        //doğru sırası belirlenmiş diziye elemanları belirtilen isimlere göre ekleme

        for (int i=0;i<10;i++)
        {
            for(int j=0;j< categories.size();j++)
            {
                if (categories.get(j).equals(bar[i].getCategory())) {

                    series[j].getData().addAll(new XYChart.Data<>(bar[i].getValue(), bar[i].getName()));
                    series[j].setName(bar[i].getCategory());

                }

            }
        }

        //barChart.setLegendVisible(false);

        barChart.getData().addAll(seriler);

        //diziyi barcharta ekleme

        barChart.getData().addAll(series);



        return barChart;
    }
*/



/*
    public javafx.scene.chart.BarChart createBarChart(Bar[] bar)
    {

            barChart.getData().clear();
            barChart.layout();

            Collections.reverse(Arrays.asList(bar));

            //ArrayList<String> categories = new ArrayList<>();

            for (int i=0;i<10;i++)
            {
                if (i==0)
                    categories.add(bar[i].getCategory());
                else if (!categories.contains(bar[i].getCategory()))
                    categories.add(bar[i].getCategory());
            }
            //series
            XYChart.Series<Number, String>[] series = Stream.<XYChart.Series<Number, String>>generate(XYChart.Series::new).limit(categories.size()).toArray(XYChart.Series[]::new);

            XYChart.Series<Number,String> seriler=new XYChart.Series<>();


            for (int i = 0; i < 10; i++)
            {//todo xvaluesunu dizidekilerle aynı yapmaya sonra da seriler serisini sıralamaya çalış
                seriler.getData().addAll(new XYChart.Data<>(bar[i].getValue(), bar[i].getName()));
                seriler.setName(bar[i].getCategory());
            }

            //doğru sırası belirlenmiş diziye elemanları belirtilen isimlere göre ekleme

            for (int i=0;i<10;i++)
            {
                for(int j=0;j< categories.size();j++)
                {
                    if (categories.get(j).equals(bar[i].getCategory())) {

                        series[j].getData().addAll(new XYChart.Data<>(bar[i].getValue(), bar[i].getName()));
                        series[j].setName(bar[i].getCategory());

                    }

                }
            }

            seriler.getData().get(0).setXValue(50000);

            barChart.getData().addAll(seriler);


            barChart.getData().addAll(series);

            //series[0].getData().get(0).getNode().setTranslateY(-10);
            //series[0].getData().get(0).getNode().setScaleY(10);

            barChart.legendVisibleProperty();

            //sıralama yapılan serimizi daha az görünür yapma
            for (int i=0;i<10;i++)
                seriler.getData().get(i).getNode().setScaleY(0.02);

            //barları barcharta ortalama
            for (int i=0;i< categories.size();i++) {
                for (int j=0;j<series[i].getData().size();j++)
                    series[i].getData().get(j).getNode().setTranslateY(-8);
            }

            //seriler.getData().sort(Comparator.comparingDouble(d -> d.getXValue().doubleValue()));

            return barChart;

    }
*/

    public javafx.scene.chart.BarChart createBarChart(ArrayList<Bar> bar)
    {

        barChart.getData().clear();
        barChart.layout();



        //ArrayList<String> categories = new ArrayList<>();

        for (int i=0;i<10;i++)
        {
            if (i==0)
                categories.add(bar.get(i).getCategory());
            else if (!categories.contains(bar.get(i).getCategory()))
                categories.add(bar.get(i).getCategory());
        }
        //series
        XYChart.Series<Number, String>[] series = Stream.<XYChart.Series<Number, String>>generate(XYChart.Series::new).limit(categories.size()).toArray(XYChart.Series[]::new);

        XYChart.Series<Number,String> seriler=new XYChart.Series<>();


        for (int i = 0; i < 10; i++)
        {//todo xvaluesunu dizidekilerle aynı yapmaya sonra da seriler serisini sıralamaya çalış
            seriler.getData().addAll(new XYChart.Data<>(bar.get(i).getValue(), bar.get(i).getName()));
            seriler.setName(bar.get(i).getCategory());
        }

        //doğru sırası belirlenmiş diziye elemanları belirtilen isimlere göre ekleme

        for (int i=0;i<10;i++)
        {
            for(int j=0;j< categories.size();j++)
            {
                if (categories.get(j).equals(bar.get(i).getCategory())) {

                    series[j].getData().addAll(new XYChart.Data<>(bar.get(i).getValue(), bar.get(i).getName()));
                    series[j].setName(bar.get(i).getCategory());

                }

            }
        }

        //seriler.getData().get(0).setXValue(50000);

       // barChart.getData().addAll(seriler);


        barChart.getData().addAll(series);




        //sıralama yapılan serimizi daha az görünür yapma
       // for (int i=0;i<10;i++)
       //     seriler.getData().get(i).getNode().setScaleY(0.02);

        //barları barcharta ortalama
       /*
        for (int i=0;i< categories.size();i++) {
            for (int j=0;j<series[i].getData().size();j++)
                series[i].getData().get(j).getNode().setTranslateY(-8);
        }
        */

        //Sort.sortBarChart(barChart);

        //seriler.getData().sort(Comparator.comparingDouble(d -> d.getXValue().doubleValue()));

/*
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(1000),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        for (int i=0;i< categories.size();i++) {
                            for (int j=0;j<series[i].getData().size();j++)
                                series[i].getData().get(j).getNode().setTranslateY(-8);
                        }
                    }
                }
                    ));
*/

/*
        TranslateTransition tt1 = new TranslateTransition(Duration.millis(2000), Chart.barChart.getData().get(7).getData().get(0).getNode());
        //tt1.setByY(50);
        tt1.setFromY(50);
        //tt1.setToY(50);
        tt1.setCycleCount(1);
        tt1.play();

        TranslateTransition tt2 = new TranslateTransition(Duration.millis(5000), Chart.barChart.getData().get(4).getData().get(0).getNode());
        //tt2.setByY(0);
        tt2.setToY(50);
        tt2.setCycleCount(1);
        tt2.play();

        TranslateTransition tt3 = new TranslateTransition(Duration.millis(5000), Chart.barChart.getData().get(5).getNode());//.getData().get(0).getNode());
        //tt1.setByY(0);
        tt3.setToY(50);
        tt3.setCycleCount(1);
        tt3.play();

*/

        return barChart;




    }

}
