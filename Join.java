import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class Join {

    public static void main(String[] args) throws IOException {
        String input1 = args[0];
        //String col1 = args[1];
        String input2 = args[2];
        //String col2 = args[3];
        //String procedure = args[4];
        //String output = args[5];
        String thisLine;
        //INPUT 1
        FileInputStream fis = new FileInputStream(input1);
        DataInputStream myInput = new DataInputStream(fis);
        List<String[]> lines = new ArrayList<String[]>();
        while ((thisLine = myInput.readLine()) != null) {
            lines.add(thisLine.split(","));
        }

        // convert our list to a String array.
        String[][] array1 = new String[lines.size()][0];
        lines.toArray(array1);
        //TEST
        for (int i =0; i < array1.length; i++){
            System.out.println(array1[i][0]);
        }

        //INPUT 2
        FileInputStream fis2 = new FileInputStream(input2);
        DataInputStream myInput2 = new DataInputStream(fis2);
        List<String[]> lines2 = new ArrayList<String[]>();
        while ((thisLine = myInput2.readLine()) != null) {
            lines2.add(thisLine.split(","));
        }

        // convert our list to a String array.
        String[][] array2 = new String[lines2.size()][0];
        lines2.toArray(array2);

        //TEST
        for (int i =0; i < array2.length; i++){
            System.out.println(array2[i][0]);
        }

        //if the argument equals nested loop TODO: make sure it is args[4]
        if(args[4].toLowerCase().equals("nested_loop")){
            ArrayList<String[]> matches = new ArrayList<>();
            for (String[] a : array1) {
                for(String[] b : array2){
                    if(a[index].equals(b[index])){
                        matches.add(combine(R[i], S[j], index1, index2));
                    }
                }
            }
            return matches.toArray(new String[matches.size()][]);
        } else if(args[4].toLowerCase().equals("hash")){
            HashMap<String, String[]> hash = new HashMap<String, String[]>();
            for (String[] a : array1) {
                //TODO: make sure a[0] is correct for the join column
                hash.put(a[0], a);
            }

            ArrayList joined = new ArrayList();

            for(String[] b : array2){
                if(b.equals())
                    String a = hash.get(b[0]);
                joined.add(new String[]{a, b});
            }
        }
    }
    private static String[] combine(String[] one, String[] two, int index1, int index2) {
        String[] r = new String[one.length + two.length - 1];
        int pos = 0;
        r[pos ++] = one[index1];
        for (int i=0; i<one.length; i++) if (i != index1) r[pos ++] = one[i];
        for (int i=0; i<two.length; i++) if (i != index2) r[pos ++] = two[i];
        return r;
    }
}