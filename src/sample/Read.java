package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read {

    public static String readText(int index)
    {
        int lineNo=-4;
        String line="";
        File textFile = new File("C:\\Users\\Ethem Akgul\\Desktop\\Kodlama + Notlar\\JavaProje\\src\\sample\\Text.txt");
        try
        {
            Scanner scanner = new Scanner(textFile);
            while(scanner.hasNextLine())
            {
                line=scanner.nextLine();
                if (lineNo==index) {
                    return line;
                }
                lineNo++;
            }

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.out.println("Dosya Bulunamadı");
        }
        return index+". satır Bulunamadı!!";
    }
    public static int totalLne ()
    {
        int lineNo=-4;
        File textFile = new File("C:\\Users\\Ethem Akgul\\Desktop\\Kodlama + Notlar\\VisualDeneme\\src\\sample\\Text.txt");
        try
        {
            Scanner scanner = new Scanner(textFile);
            while(scanner.hasNextLine())
            {
                scanner.nextLine();
                lineNo++;
            }

        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.out.println("Dosya Bulunamadı");
        }
        return lineNo;
    }

    public static int amountofBarCharts()
    {
        int endPoint = -3;
        int amountofRecords=0;//0-75      77-177      179-279
        int count=0;
        while(endPoint<Read.totalLne()-1) {

            amountofRecords = Integer.parseInt(Read.readText(endPoint + 2));//75,100
            endPoint = amountofRecords + endPoint + 2;//75,178

            count++;
        }

        return count;
    }

}
