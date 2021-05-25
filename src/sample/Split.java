package sample;

public class Split {

    public static String[] splitText(String records)  {

        String[] splitRecords;
        String[] error = new String[1];
        error[0]="Girilen Satır Split Edilemiyor";
        if (records.contains(","))
        {
            splitRecords = records.split(",");
            return splitRecords;
        }

        return error;
    }

}
