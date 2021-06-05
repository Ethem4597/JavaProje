package sample;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class Bar implements Comparable<Bar>{
    private String name;
    private String category;
    private int value;

    public Bar(String name,String category,int value)
    {
        this.name=name;
        this.category=category;
        this.value=value;
    }
    public String getName()
    {
        return this.name;
    }
    public String getCategory()
    {
        return this.category;
    }
    public int getValue()
    {
        return this.value;
    }

    @Override
    public int compareTo(Bar bar) {
        if (this.value==bar.value)
            return 0;
        else if (this.value< bar.value)
            return -1;
        else
            return 1;
    }

    public static ArrayList<Bar> createBars(int index) {
        ArrayList<Bar> barlist = new ArrayList<Bar>();
        barlist.clear();
        int endPoint = -3;
        int amountofRecords=0;//0-75      77-177      179-279
        int startPoint=0;
        //int count=0;



        for (int i=0;i<index+1;i++)
        {
            amountofRecords = Integer.parseInt(Read.readText(endPoint + 2));//75,100
            startPoint=endPoint+3;
            endPoint = amountofRecords + endPoint + 2;//75,178
        }
        //System.out.println(count);
        for (int i = startPoint; i<=endPoint;i++)
        {
            barlist.add(new Bar(Split.splitText(Read.readText(i))[1],Split.splitText(Read.readText(i))[4],Integer.parseInt(Split.splitText(Read.readText(i))[3])));
        }

        return barlist;
    }

}
