import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class Join {

    public static void main(String[] args) throws IOException {
        String input1 = args[0];
        //String col1 = args[1];
        //String input2 = args[2];
        //String col2 = args[3];
        //String procedure = args[4];
        //String output = args[5];
        String thisLine;
        FileInputStream fis = new FileInputStream(input1);
        DataInputStream myInput = new DataInputStream(fis);
        List<String[]> lines = new ArrayList<String[]>();
        while ((thisLine = myInput.readLine()) != null) {
            lines.add(thisLine.split(","));
        }

        // convert our list to a String array.
        String[][] array = new String[lines.size()][0];
        lines.toArray(array);
        for (int i =0; i < array.length; i++){
            System.out.println(array[i][0]);
        }

    }

}