import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Join {

    public static void main(String[] args) throws FileNotFoundException {
        
        //parsing a CSV file into Scanner class constructor  
        Scanner sc = new Scanner(new File("C:\\Users\\Kedde\\Downloads\\nation.csv"));
        sc.useDelimiter(",");   //sets the delimiter pattern  
        while (sc.hasNext())  //returns a boolean value  
        {  
        System.out.print(sc.next()+ " ");  //find and returns the next complete token from this scanner
        }   
        sc.close();  //closes the scanner  


        //if the argument equals nested loop TODO: make sure it is args[4]

    }

}