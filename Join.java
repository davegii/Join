import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class Join {

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        String input1 = args[0];
        String col1 = args[1];
        String input2 = args[2];
        String col2 = args[3];
        String procedure = args[4];
        String output = args[5];
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
        //for (int i =0; i < array1.length; i++){
        //    System.out.println(array1[i][0]);
        //}

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
        //for (int i =0; i < array2.length; i++){
        //    System.out.println(array2[i][0]);
        //}
        //Find the indexes
        int index1 =-1;
        for(int i = 0; i < array1.length; i++){
            if(array1[0][i].equals(col1)){
                index1 = i;
                break;
            }
        }
        if(index1 == -1){
            System.out.println("No match found");
            return;
        }

        int index2 =-1;
        for(int i = 0; i < array2.length; i++){
            if(array2[0][i].equals(col2)){
                index2 = i;
                break;
            }
        }
        if(index2 == -1){
            System.out.println("No match found");
            return;
        }
        //System.out.println("Index1: "+ index1);
        //System.out.println("Index2: "+ index2);
        //if the argument equals nested loop TODO: make sure it is args[4]
        ArrayList<String[]> matches = new ArrayList<>();
        if(procedure.toLowerCase().equals("nested_loop")){
            System.out.println();
            //start at 1 because we want to ignore first row of header
            for (int row1 = 1; row1 < array1.length; row1++) {
                for (int row2 = 1; row2 < array2.length; row2++) {
                    if (array1[row1][index1].equals(array2[row2][index2])) {
                        matches.add(combine(array1[row1], array2[row2], index1, index2));
                    }
                }
            }

        } else if(args[4].toLowerCase().equals("hash")){
            HashMap<String, String[]> hash = new HashMap<String, String[]>();
            for (int row1 = 1; row1 < array1.length; row1++) {
                hash.put(array1[row1][index1], array1[row1]);
            }
            //for (String[] a : array1) {
            //    //TODO: make sure a[0] is correct for the join column
            //    hash.put(a[0], a);
            //}

            //ArrayList joined = new ArrayList();
            for (int row2 = 1; row2 < array2.length; row2++) {
                if (hash.containsKey(array2[row2][index2])) {
                    matches.add(combine(hash.get(array2[row2][index2]), array2[row2], index1, index2));
                }
            }
            //for(String[] b : array2){
                //if(b.equals())
                    //String a = hash.get(b[0]);
                //joined.add(new String[]{a, b});
            //}
        }
        matches.toArray();
        //matches.toArray(new String[matches.size()][]);
        //System.out.println("Start");
        try (PrintWriter writer = new PrintWriter(output)) {

            StringBuilder sb = new StringBuilder();
            for(int row = 0; row<matches.size(); row++){
                for(int col =0; col <matches.get(row).length; col++) {
                    sb.append(matches.get(row)[col]);
                    sb.append(',');
                }
                sb.append('\n');
            }

            writer.write(sb.toString());
            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("That took: "+duration/1000000000.+" seconds");
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