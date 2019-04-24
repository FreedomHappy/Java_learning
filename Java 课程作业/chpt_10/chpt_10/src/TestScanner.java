
import java.io.*;
import java.util.*;
public class TestScanner {
   public static void main(String args[]) {
      File file = new File("./src/cost.txt");
      Scanner sc=null;
      int sum=0;
      try { 
    	    sc = new Scanner(file);
      		sc.useDelimiter("\\D+") ;
            while(sc.hasNext()){
               try{
                    int price=sc.nextInt();
                    sum=sum+price;
                    System.out.println(price); 
               } 
               catch(InputMismatchException exp){
                  
               }   
            }
            System.out.println("Total Cost:"+sum+" dollar");
      }
      catch(Exception exp){
         System.out.println(exp); 
      }
   }
}
