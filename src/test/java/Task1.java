import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class Task1 {
    public static void main(String[] args) {

fizzbuzz(20);
    }
   public static void fizzbuzz(int bound) {
       for (int i = 1; i <= bound; i++) {
           if (i % 3 == 0.0 && i % 5 == 0) {
               System.out.println("fizzBuzz" + i);
               continue;
           }
           if (i % 3 == 0) {
               System.out.println("buzz");
               continue;
           }
           System.out.println(i);


       }
   }
}
