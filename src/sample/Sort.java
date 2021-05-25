package sample;

import javafx.scene.chart.BarChart;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort {

    int[] pos=new int[10];


    public static ArrayList<Bar> sortBars(ArrayList<Bar> barlist)
    {
        for (int i=1;i<barlist.size();i++)
        {
            Bar temp = barlist.get(i);
            int j=i-1;

            for (;j>=0 && barlist.get(j).compareTo(temp)==-1 ;j--)
            {
                barlist.set(j+1,barlist.get(j));

            }
            barlist.set(j+1,temp);
        }

        ArrayList<Bar> bars1 =new ArrayList<>();
        for (int i=9;i>-1;i--)
        {
            bars1.add(barlist.get(i));
        }


        //System.out.println(bars[0].getName());

        return bars1;
    }

    public static void /*BarChart<Number,String>*/ sortBarChart(BarChart<Number,String> barChart)
    {
        barChart.getData().get(0).getData().sort(Comparator.comparingDouble(d -> d.getXValue().doubleValue()));
        //return barChart;
    }
    public static void sortBarChart(BarChart<Number,String> barChart,int temp)
    {

    }
}
